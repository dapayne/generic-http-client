package com.mspairport.utils;

import java.util.HashMap;
import java.util.Map;

public class GenericHttpClient {

	public static void main(String[] args) throws Exception {

		// Add comment here
		Map<String,String> inputMap = new HashMap<String,String>();
		
		for (int i=0; i < args.length; i++) {
			if (args[i] != null) {
				String input = args[i];
				if (input != null) {
					String[] result = input.split(",");
					if (result != null) {
						for (int j=0; j < result.length; j++) {
							inputMap.put(result[0], result[1]);
						}
					}
					System.out.println(inputMap);
					HttpUtil httpUtil = new HttpUtil();
					
					httpUtil.sendPost(inputMap);
				}
						
			}
		}
		
	}

}
