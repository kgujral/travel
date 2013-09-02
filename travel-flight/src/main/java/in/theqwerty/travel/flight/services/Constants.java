package in.theqwerty.travel.flight.services;

import org.apache.commons.httpclient.Header;

public class Constants {

	public static final String API_KEY = "e42d636e8efd88d4af8cf5c01d99f514";
	public static final String API_KEY_HEADER = "X-CT-API-KEY";
	public static final String SEARCH_URL = "http://api.staging.cleartrip.com/air/1.0/search";
	public static final Header HEADER_FOR_CLEARTRIP = new Header(API_KEY_HEADER, API_KEY); 
	
}
