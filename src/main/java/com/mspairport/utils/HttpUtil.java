package com.mspairport.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Properties;

public class HttpUtil {

	public void sendPost(Map<String,String> requestParams) throws Exception {
		
		PropertyUtil propUtil = new PropertyUtil();
		Properties props = propUtil.getProperties();
		
	    StringBuilder tokenUri=new StringBuilder("param1="); 
	    tokenUri.append(URLEncoder.encode(requestParams.toString(), "UTF-8"));
	    
		String urlAddr = props.getProperty("url"); 
		URL url = new URL(urlAddr);
		
		if (url != null) {
			HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();
			if (httpCon != null) {
				httpCon.setRequestMethod("POST");
				httpCon.setRequestProperty("Content-Type", props.getProperty("applicationType"));
				httpCon.setDoOutput(true);
				OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpCon.getOutputStream());
				outputStreamWriter.write(tokenUri.toString());
				outputStreamWriter.flush();
				
				int responseCode = httpCon.getResponseCode();
				System.out.println("\nSending 'POST' request to URL : " + urlAddr);
				System.out.println("Response Code: " + responseCode);
				
				BufferedReader input = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));

				String inputLine;
				StringBuffer response = new StringBuffer();
				
				while ((inputLine = input.readLine()) != null) {
					response.append(inputLine);
				}
				
				input.close();
				System.out.println(URLDecoder.decode(response.toString(),"UTF-8"));
			}
			
		}
		
	}	
	
}
