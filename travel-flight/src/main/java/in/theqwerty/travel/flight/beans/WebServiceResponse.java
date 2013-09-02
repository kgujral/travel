package in.theqwerty.travel.flight.beans;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.httpclient.HttpMethod;

public class WebServiceResponse {

	private int statusCode;
	private InputStream stream;
	private HttpMethod method;
	
	
	public void setMethod(HttpMethod method) {
		this.method = method;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public InputStream getStream() {
		return stream;
	}
	public void setStream(InputStream stream) {
		this.stream = stream;
	}
	
	@Override
	public String toString() {
		return "WebServiceResponse [statusCode=" + statusCode + ", stream="
				+ stream + "]";
	}
	public WebServiceResponse(int statusCode, InputStream stream) {
		this.statusCode = statusCode;
		this.stream = stream;
	}
	
	public WebServiceResponse() {
	}
	public void close() {
		try {
			if(stream != null) {
				this.stream.close();
			}
			if(method != null && method.isRequestSent()) {
				this.method.releaseConnection();
			}
		} catch (IOException e) {
			
		}
	}
	
}
