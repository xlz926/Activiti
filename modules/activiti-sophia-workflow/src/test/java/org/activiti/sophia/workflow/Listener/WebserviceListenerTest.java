package org.activiti.sophia.workflow.Listener;

import java.io.IOException;

import org.junit.Test;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class WebserviceListenerTest {

	@Test
	public void test() {
		ClientResource resource = new ClientResource("http://172.16.10.50:8080/rest/workflowwebservice/7F60D7D754CF4A509B0BF59ABB0E100C/DRAFT");  
	
	   try {
		System.out.println(resource.get().getText());
	} catch (ResourceException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	} 

}
