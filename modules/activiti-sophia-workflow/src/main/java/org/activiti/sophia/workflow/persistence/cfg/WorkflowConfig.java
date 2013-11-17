package org.activiti.sophia.workflow.persistence.cfg;

import javax.sql.DataSource;

public abstract class WorkflowConfig {

	  protected String databaseType="oralce";
	  protected String databaseTablePrefix = "";
	  protected String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	  protected String jdbcUrl = "jdbc:oracle:thin:@192.168.238.136:1521:ORCL";
	  protected String jdbcUsername = "stell";
	  protected String jdbcPassword = "123456";
	  protected int jdbcMaxActiveConnections;
	  protected int jdbcMaxIdleConnections;
	  protected int jdbcMaxCheckoutTime;
	  protected int jdbcMaxWaitTime;
	  protected boolean jdbcPingEnabled = false;
	  protected String jdbcPingQuery = null;
	  protected int jdbcPingConnectionNotUsedFor;
	  protected int jdbcDefaultTransactionIsolationLevel;
	  protected DataSource dataSource;
	  protected boolean transactionsExternallyManaged = false;
	  
	  protected String xmlEncoding = "UTF-8";
	  protected ClassLoader classLoader;
	  
	public String getDatabaseTablePrefix() {
		return databaseTablePrefix;
	}
	public void setDatabaseTablePrefix(String databaseTablePrefix) {
		this.databaseTablePrefix = databaseTablePrefix;
	}
	public String getJdbcDriver() {
		return jdbcDriver;
	}
	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getJdbcUsername() {
		return jdbcUsername;
	}
	public void setJdbcUsername(String jdbcUsername) {
		this.jdbcUsername = jdbcUsername;
	}
	public String getJdbcPassword() {
		return jdbcPassword;
	}
	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}
	public int getJdbcMaxActiveConnections() {
		return jdbcMaxActiveConnections;
	}
	public void setJdbcMaxActiveConnections(int jdbcMaxActiveConnections) {
		this.jdbcMaxActiveConnections = jdbcMaxActiveConnections;
	}
	public int getJdbcMaxIdleConnections() {
		return jdbcMaxIdleConnections;
	}
	public void setJdbcMaxIdleConnections(int jdbcMaxIdleConnections) {
		this.jdbcMaxIdleConnections = jdbcMaxIdleConnections;
	}
	public int getJdbcMaxCheckoutTime() {
		return jdbcMaxCheckoutTime;
	}
	public void setJdbcMaxCheckoutTime(int jdbcMaxCheckoutTime) {
		this.jdbcMaxCheckoutTime = jdbcMaxCheckoutTime;
	}
	public int getJdbcMaxWaitTime() {
		return jdbcMaxWaitTime;
	}
	public void setJdbcMaxWaitTime(int jdbcMaxWaitTime) {
		this.jdbcMaxWaitTime = jdbcMaxWaitTime;
	}
	public boolean isJdbcPingEnabled() {
		return jdbcPingEnabled;
	}
	public void setJdbcPingEnabled(boolean jdbcPingEnabled) {
		this.jdbcPingEnabled = jdbcPingEnabled;
	}
	public String getJdbcPingQuery() {
		return jdbcPingQuery;
	}
	public void setJdbcPingQuery(String jdbcPingQuery) {
		this.jdbcPingQuery = jdbcPingQuery;
	}
	public int getJdbcPingConnectionNotUsedFor() {
		return jdbcPingConnectionNotUsedFor;
	}
	public void setJdbcPingConnectionNotUsedFor(int jdbcPingConnectionNotUsedFor) {
		this.jdbcPingConnectionNotUsedFor = jdbcPingConnectionNotUsedFor;
	}
	public int getJdbcDefaultTransactionIsolationLevel() {
		return jdbcDefaultTransactionIsolationLevel;
	}
	public void setJdbcDefaultTransactionIsolationLevel(
			int jdbcDefaultTransactionIsolationLevel) {
		this.jdbcDefaultTransactionIsolationLevel = jdbcDefaultTransactionIsolationLevel;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public boolean isTransactionsExternallyManaged() {
		return transactionsExternallyManaged;
	}
	public void setTransactionsExternallyManaged(
			boolean transactionsExternallyManaged) {
		this.transactionsExternallyManaged = transactionsExternallyManaged;
	}
	public String getXmlEncoding() {
		return xmlEncoding;
	}
	public void setXmlEncoding(String xmlEncoding) {
		this.xmlEncoding = xmlEncoding;
	}
	public ClassLoader getClassLoader() {
		return classLoader;
	}
	public void setClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}
}
