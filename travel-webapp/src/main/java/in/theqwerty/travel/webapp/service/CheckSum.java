package in.theqwerty.travel.webapp.service;

import java.util.zip.Adler32;

public class CheckSum {
	public static String verifyChecksum(String MerchantId , String OrderId, String Amount, String AuthDesc, String WorkingKey, String CheckSum) throws Exception 	{
		String str = MerchantId+"|"+OrderId+"|"+Amount+"|"+AuthDesc+"|"+WorkingKey;
		
		Adler32  adl = new Adler32();                 
		adl.update(str.getBytes());

		String newChecksum = String.valueOf(adl.getValue());
		return (newChecksum.equals(CheckSum)) ? "true" : "false";
		
	}


	public static String getChecksum(String MerchantId, String OrderId, String Amount, String redirectUrl, String WorkingKey) {
		String str = MerchantId + "|" + OrderId + "|" + Amount + "|" + redirectUrl + "|" + WorkingKey;

		Adler32  adl = new Adler32();
		adl.update(str.getBytes());
		return String.valueOf(adl.getValue());
	}

}
