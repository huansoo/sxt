package com.wugu.ycyp.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MD5Util {
    /**
     * 
      * @Title: byteArrayToHexString
      * @Description: TODO(这里用一句话描述这个方法的作用)
      * @author lijun
      * @date 2014-9-11 
      * @param b
      * @return
      * @throws
     */
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	/**
	 * 
	  * @Title: byteToHexString
	  * @Description: 将字节转化成16进制数
	  * @author yangch
	  * @date 2014-9-28 
	  * @param b
	  * @return
	  * @throws
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	
	public static String MD5Encode(String origin) {
	   return MD5Util.MD5Encode(origin, null); 
	}

	public static String MD5Encode(String origin, String charsetname ) {
		String resultString = null;
		try {
			resultString = new String(origin);
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname)){
			    //md.digest获得密文
			    System.out.println("MD5Encode getBytes:"+Arrays.toString(md.digest(resultString.getBytes())));
			    //调用 digest 方法之一完成哈希计算，digest 方法只能被调用一次。
			    //digest 被调用后，MessageDigest 对象被重新设置成其初始状态
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			}else
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetname)));
		} catch (Exception exception) {
		}
		return resultString;
	}
	
	public static String md5(String origin) throws NoSuchAlgorithmException {
        String md5Str = origin;
        if(origin != null) {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(origin.getBytes());
            BigInteger hash = new BigInteger(1, md.digest());
            md5Str = hash.toString(16);
            if((md5Str.length() % 2) != 0) {
                md5Str = "0" + md5Str;
            }
        }
        return md5Str;
	}
	
	public static String encryption(String plain) {
	    String re_md5 = new String();
	    try {
	     MessageDigest md = MessageDigest.getInstance("MD5");
	     md.update(plain.getBytes());
	     byte b[] = md.digest();
	     //此处也可以换为md.digest(plain.getBytes());
	     System.out.println("encryption----getBytes"+Arrays.toString(b));
	    int i;

	    StringBuffer buf = new StringBuffer("");
	     for (int offset = 0; offset < b.length; offset++) {
	      i = b[offset];
	      if (i < 0)
	       i += 256;
	      if (i < 16)
	       buf.append("0");
	      buf.append(Integer.toHexString(i));
	     }

	    re_md5 = buf.toString();

	   } catch (NoSuchAlgorithmException e) {
	     e.printStackTrace();
	   }
	   return re_md5;
	}

	 
	 

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
	public static void main(String[] arg) throws Exception{
	    String key = "ycyp";	    
	    
	    String pwd = "ycyp123456";
	    
	    String phpMd5 = "cb0f548494418603bdf67fb1df7d097b";	    
	    
//	    String javaMd5 = MD5Encode(pwd);
//	    System.out.println(phpMd5);
	    System.out.println("encryption()"+encryption(key));
	    System.out.println("MD5Encode() "+MD5Encode(pwd));
	    System.out.println("md5()"+md5(pwd));
	}

}
