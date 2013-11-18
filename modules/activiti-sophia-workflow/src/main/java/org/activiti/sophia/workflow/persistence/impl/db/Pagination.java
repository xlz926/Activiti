package org.activiti.sophia.workflow.persistence.impl.db;

import java.util.HashMap;
import java.util.Map;


public class Pagination   {

   private static final String  PAGE_LIMIT_BEFORE ="select * from ( select a.*, ROWNUM rnum from ( ";
   private static final String PAGE_LIMIT_AFTER =" ) a where ROWNUM < %d) where rnum  >= %d ";
   private static final String ORDER_BY ="order by %s";
   
   public static Map toListPage(int start , int size){
	   return toListPage(start ,size,null);
   }
   
   public static Map toListPage(int start , int size,String orderBy){
	   Map page =new HashMap();
	  page.put("limitBefore", PAGE_LIMIT_BEFORE);
	  page.put("limitAfter", String.format(PAGE_LIMIT_AFTER, start+size,start));
	   if(orderBy!=null){
		   page.put("orderBy",String.format(ORDER_BY,orderBy) );
	   }
	   return page;
   }
}
