package com.boc.bocop.sdk.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.List;

public class MD5Helper {
	public String getSignature(List<String> paramList,String secret){

		 Collections.sort(paramList);
		 StringBuffer buffer = new StringBuffer();
		 for (String param : paramList) {
		     buffer.append(param); 
		     //将参数键值对，以字典序升序排列后，拼接在一起
		 }
		 buffer.append(secret);  
		 //符串末尾追加上应用的Secret Key
		 try {           
			 //下面是将拼好的字符串转成MD5值，然后返回
		    MessageDigest md = MessageDigest.getInstance("MD5");
		    StringBuffer result = new StringBuffer();
		    try {
		        for (byte b : md.digest(buffer.toString().getBytes("UTF-8"))) {
		            result.append(Integer.toHexString((b & 0xf0) >>> 4));
		            result.append(Integer.toHexString(b & 0x0f));
		        }
		    } catch (UnsupportedEncodingException e) {
		        for (byte b : md.digest(buffer.toString().getBytes())) {
		            result.append(Integer.toHexString((b & 0xf0) >>> 4));
		            result.append(Integer.toHexString(b & 0x0f));
		        }
		    }
		    return result.toString();
		} catch (java.security.NoSuchAlgorithmException ex) {
		    
		}
		return null;
   	}
	
	public static String getMD5buffer(StringBuffer buffer){
		try {            
			//下面是将拼好的字符串转成MD5值，然后返回
		    MessageDigest md = MessageDigest.getInstance("MD5");
		    StringBuffer result = new StringBuffer();
		    try {
		        for (byte b : md.digest(buffer.toString().getBytes("UTF-8"))) {
		            result.append(Integer.toHexString((b & 0xf0) >>> 4));
		            result.append(Integer.toHexString(b & 0x0f));
		        }
		    } catch (UnsupportedEncodingException e) {
		        for (byte b : md.digest(buffer.toString().getBytes())) {
		            result.append(Integer.toHexString((b & 0xf0) >>> 4));
		            result.append(Integer.toHexString(b & 0x0f));
		        }
		    }
		    return result.toString();
		} catch (java.security.NoSuchAlgorithmException ex) {
		    
		}
		return null;
  	}
	
	// MD5加密，32位
	public static String getMD5(String str) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		char[] charArray = str.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
}
