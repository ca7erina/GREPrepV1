package util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class MD5Utils {
	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] b1 = md.digest(str.getBytes());
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(b1);
		} catch (Exception e) {
			return null;
		}
	}

	public static void main(String[] args){
		System.out.println(md5("a"));
		
	}

}
