package in.theqwerty.travel.flight.services;

import in.theqwerty.travel.flight.beans.WebServiceResponse;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("ws")
public class WebServiceAPI {

	private static Logger logger = LoggerFactory.getLogger(WebServiceAPI.class);
	
	public WebServiceResponse doGet(String url, String queryString) {
		return doGet(url, new Header[]{Constants.HEADER_FOR_CLEARTRIP}, queryString);
	}
	public WebServiceResponse doGet(String url) {
		return doGet(url, new String());
	}
	public WebServiceResponse doGet(String url, Header header, String queryString) {
		return doGet(url, new Header[]{header}, queryString);
	}
	public WebServiceResponse doGet(String url, Header header) {
		return doGet(url, new Header[]{header}, null);
	}
		
	/**
	 * This method sends a "GET" request to a server.
	 * @param String url of the host
	 * @param headers Header information to be set
	 * @param queryString A typical GET querystring. e.g. name=karan&age=24
	 * @return a response Encapsulated in a ({@link: WebServiceResponse})WebServiceRespose.
	 * 			which contains a status code 404 in case of an exception.  
	 */
	public WebServiceResponse doGet(String url, Header[] headers, String queryString) {
		WebServiceResponse response = new WebServiceResponse();
		System.out.println(queryString);
		GetMethod get = new GetMethod(url);
		get.setQueryString(queryString);
		
		for(Header h: headers) {
			get.addRequestHeader(h);
		}
		HttpClient client = new HttpClient();
        // Execute request
        try {
            int statusCode = client.executeMethod(get);
            response.setStatusCode(statusCode);
            InputStream stream = get.getResponseBodyAsStream();
            response.setStream(stream);
            response.setMethod(get);
            return response;
            
        } catch (HttpException e) {
        	logger.error("Unable to connect to HTTP in doGet method");
		} catch (IOException e) {
			logger.error("Unable to read the stream. Exception in doGet method");
		}
		return new WebServiceResponse(404, null);
	}
	
	
	
	/**
	 * This method sends a "POST" request to a server.
	 * Polymorphic version. Assumes the clear trip's neccessary headers as required.
	 * @param url String url of the host
	 * @param xmlStream an inputstream containing XML data.
	 * @return a response Encapsulated in a ({@link: WebServiceResponse})WebServiceRespose.
	 * 			which contains a status code 404 in case of an exception.  
	 */
	public WebServiceResponse doPost(String url, InputStream xmlStream) {
		return doPost(url,new Header[]{Constants.HEADER_FOR_CLEARTRIP,
						  new Header("Content-type", "text/xml; charset=UTF-8")}, xmlStream);
	}
	
	/**
	 * This method sends a "POST" request to a server.
	 * @param url String url of the host
	 * @param headers Header information to be set
	 * @param xmlStream an inputstream containing XML data.
	 * @return a response Encapsulated in a ({@link: WebServiceResponse})WebServiceRespose.
	 * 			which contains a status code 404 in case of an exception.  
	 */
	public WebServiceResponse doPost(String url, Header[] headers, InputStream xmlStream) {
		WebServiceResponse response = new WebServiceResponse();
		PostMethod post = new PostMethod(url);
		HttpClient client = new HttpClient(); 
		for(Header h: headers) {
			post.addRequestHeader(h);
		}
		try {
			post.setRequestEntity(new InputStreamRequestEntity(xmlStream));			
			int statusCode = client.executeMethod(post);
            response.setStatusCode(statusCode);
            
            InputStream stream = post.getResponseBodyAsStream();
            response.setStream(stream);
            response.setMethod(post);
            return response;
            
		} catch (IOException e) {
			logger.error("Unable to read the stream. Exception in doPost method");
        }
			
		return new WebServiceResponse(404, null);
	}
}
