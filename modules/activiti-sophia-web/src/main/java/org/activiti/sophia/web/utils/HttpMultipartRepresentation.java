package org.activiti.sophia.web.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.PartSource;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;
import org.restlet.data.MediaType;
import org.restlet.representation.InputRepresentation;

public class HttpMultipartRepresentation extends InputRepresentation {

	
	public HttpMultipartRepresentation(final String fileName, final InputStream fileStream, Map<String, String> additionalFormFields) throws IOException {
	    super(null, MediaType.MULTIPART_FORM_DATA);
	    processStreamAndSetMediaType(fileName, fileStream, additionalFormFields);
	  }
	  
	  public HttpMultipartRepresentation(final String fileName, final InputStream fileStream) throws IOException {
	    this(fileName, fileStream, null);
	  }

	  public void processStreamAndSetMediaType(final String fileName, InputStream fileStream, Map<String, String> additionalFormFields) throws IOException {
	    // Copy the stream in a bytearray to get the length
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    IOUtils.copy(fileStream, output);

	    final int length = output.toByteArray().length;
	    final InputStream stream = new ByteArrayInputStream(output.toByteArray());

	    List<Part> parts = new ArrayList<Part>();
	    
	    // Filepart is based on in-memory stream an file-name rather than an actual file
	    FilePart filePart = new FilePart(fileName, new PartSource() {
	      @Override
	      public long getLength() {
	        return length;
	      }
	      
	      @Override
	      public String getFileName() {
	        return fileName;
	      }

	      @Override
	      public InputStream createInputStream() throws IOException {
	        return stream;
	      }
	    });
	    parts.add(filePart);
	    
	    if(additionalFormFields != null && !additionalFormFields.isEmpty()) {
	      for(Entry<String, String> field : additionalFormFields.entrySet()) {
	        parts.add(new StringPart(field.getKey(), field.getValue()));
	      }
	    }
	    
	    MultipartRequestEntity entity = new MultipartRequestEntity(parts.toArray(new Part[] {}), new HttpMethodParams());

	    // Let the entity write the raw multipart to a bytearray, which is used as a source
	    // for the input-stream returned by this Representation
	    ByteArrayOutputStream os = new ByteArrayOutputStream();
	    entity.writeRequest(os);
	    setMediaType(new MediaType(entity.getContentType()));
	    setStream(new ByteArrayInputStream(os.toByteArray()));
	  }
}
