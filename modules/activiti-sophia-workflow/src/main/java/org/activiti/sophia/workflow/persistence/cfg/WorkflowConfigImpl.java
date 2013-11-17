package org.activiti.sophia.workflow.persistence.cfg;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import org.activiti.sophia.workflow.WorkflowException;
import org.activiti.sophia.workflow.persistence.util.IoUtil;
import org.activiti.sophia.workflow.persistence.util.ReflectUtil;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkflowConfigImpl extends  WorkflowConfig{
	
	
	  private static Logger log = LoggerFactory.getLogger(WorkflowConfigImpl.class);
	
	  public static final String DEFAULT_MYBATIS_MAPPING_FILE = "org/activiti/sophia/workflow/persistence/mapper.xml";
	  
	  private static final String  LIMIT_BEFORE="select * from ( select a.*, ROWNUM rnum from (";
	  private static final String  LIMIT_AFTER=") a where ROWNUM < #{lastRow}) where rnum  >= #{firstRow}";
	  private static final String  LIMIT_BETWEEN="";
	  private static final String  LIMIT_OUTERJOINBETWEEN="";
 	  private static final String  ORDER_BY="order by ${orderBy}";
 	  private static final String  LIMIT_BEFORENATIVEQUERY= "selectExclusiveJobsToExecute_integerBoolean";
	  

	  protected SqlSessionFactory sqlSessionFactory;
	  protected TransactionFactory transactionFactory;
	 
	  public  WorkflowConfigImpl(){
		  init();
	  }
	  
	  
	  protected void init(){
		  
		  initTransactionFactory();
		  initDataSource();
		  initSqlSessionFactory();
		  
	  }
	  
	  
	  
	  
	  // myBatis SqlSessionFactory ////////////////////////////////////////////////
	  
	  protected void initTransactionFactory() {
	    if (transactionFactory==null) {
	      if (transactionsExternallyManaged) {
	        transactionFactory = new ManagedTransactionFactory();
	      } else {
	        transactionFactory = new JdbcTransactionFactory();
	      }
	    }
	  }
	  
	  // DataSource ///////////////////////////////////////////////////////////////
	  protected void initDataSource() {
	    if (dataSource==null) {
	       if (jdbcUrl!=null) {
	        if ( (jdbcDriver==null) || (jdbcUrl==null) || (jdbcUsername==null) ) {
	          throw new WorkflowException("DataSource or JDBC properties have to be specified in a process engine configuration");
	        }
	        
	        log.debug("initializing datasource to db: {}", jdbcUrl);
	        
	        PooledDataSource pooledDataSource = 
	          new PooledDataSource(ReflectUtil.getClassLoader(), jdbcDriver, jdbcUrl, jdbcUsername, jdbcPassword );
	        
	        if (jdbcMaxActiveConnections > 0) {
	          pooledDataSource.setPoolMaximumActiveConnections(jdbcMaxActiveConnections);
	        }
	        if (jdbcMaxIdleConnections > 0) {
	          pooledDataSource.setPoolMaximumIdleConnections(jdbcMaxIdleConnections);
	        }
	        if (jdbcMaxCheckoutTime > 0) {
	          pooledDataSource.setPoolMaximumCheckoutTime(jdbcMaxCheckoutTime);
	        }
	        if (jdbcMaxWaitTime > 0) {
	          pooledDataSource.setPoolTimeToWait(jdbcMaxWaitTime);
	        }
	        if (jdbcPingEnabled == true) {
	          pooledDataSource.setPoolPingEnabled(true);
	          if (jdbcPingQuery != null) {
	            pooledDataSource.setPoolPingQuery(jdbcPingQuery);
	          }
	          pooledDataSource.setPoolPingConnectionsNotUsedFor(jdbcPingConnectionNotUsedFor);
	        }
	        if (jdbcDefaultTransactionIsolationLevel > 0) {
	          pooledDataSource.setDefaultTransactionIsolationLevel(jdbcDefaultTransactionIsolationLevel);
	        }
	        dataSource = pooledDataSource;
	      }
	    }
	  }
	  
	  protected void initSqlSessionFactory() {
		    if (sqlSessionFactory==null) {
		      InputStream inputStream = null;
		      try {
		        inputStream = Resources.getResourceAsStream(DEFAULT_MYBATIS_MAPPING_FILE);
		        // update the jdbc parameters to the configured ones...
		        Environment environment = new Environment("default", transactionFactory, dataSource);
		        Reader reader = new InputStreamReader(inputStream);
		        Properties properties = new Properties();
		        properties.put("prefix", databaseTablePrefix);
		        if(databaseType != null) {
		          properties.put("limitBefore" ,LIMIT_BEFORE);
		          properties.put("limitAfter" , LIMIT_AFTER);
		          properties.put("limitBetween" , LIMIT_BETWEEN);
		          properties.put("limitOuterJoinBetween" ,LIMIT_OUTERJOINBETWEEN);
		          properties.put("orderBy" ,ORDER_BY);
		          properties.put("limitBeforeNativeQuery" ,LIMIT_BEFORENATIVEQUERY);
		        }
		         XMLConfigBuilder parser = new XMLConfigBuilder(reader,"", properties);
		        Configuration configuration = parser.getConfiguration();
		        configuration.setEnvironment(environment);
		        configuration = parser.parse();
		        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(configuration);
		    	  
		      } catch (Exception e) {
		        throw new WorkflowException("创建mybatis factory 失败: " + e.getMessage(), e);
		      } finally {
		        IoUtil.closeSilently(inputStream);
		      }
		    }
		  }
	  
	  protected InputStream getMyBatisXmlConfigurationSteam() {
		    return ReflectUtil.getResourceAsStream(DEFAULT_MYBATIS_MAPPING_FILE);
      }
}
