package org.activiti.sophia.workflow.Listener;

import org.junit.Test;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class WebserviceListenerTest {

	@Test
	public void test() {
		ClientResource resource = new ClientResource("http://www.baidu.com");  
	
	   try {
		System.out.println(resource.get());
	} catch (ResourceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	} 

}
