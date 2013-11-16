package org.activiti.sophia.web.actions;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class Index {

	@RequestMapping(value = "/index", method = { RequestMethod.GET,RequestMethod.POST })
	public String getIndex(HttpServletRequest request, HttpSession session, Model model) {
		return "index";
	}
	
	
	@RequestMapping(value = "/test", method = { RequestMethod.GET,RequestMethod.POST })
	public void test(HttpServletRequest request, HttpSession session, Model model,HttpServletResponse  response) {
		ByteArrayOutputStream stream =  new ByteArrayOutputStream();
	     String	filename = "chart.png";		
	     String input  = request.getParameter("exportInput");
		try {
			URL url = new URL("http://127.0.0.1:8888");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			OutputStream out = connection.getOutputStream();
			out.write("eeeee".getBytes("utf-8"));
			out.close();
			
			InputStream in = connection.getInputStream();
			IOUtils.copy(in,  stream);
			in.close();
			response.setContentType("image/png");
			response.setContentLength(stream.size());
			response.setHeader("Content-disposition", "attachment; filename=\""+ filename +  "\"");
			IOUtils.write(stream.toByteArray(), response.getOutputStream());
			response.flushBuffer();


		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
