package com.hoursecy.common.util;



import org.springframework.util.DigestUtils;

public class MD5Encrypt {

    /**
     * MD5方法
     * 
     * @param text 明文
     * @param key 密钥
     * @return 密文
     * @throws Exception
     */
	
    public static String MD5Encipherment(String string) throws Exception {
    	byte[] b = string.getBytes();
        //加密后的字符串
        String encodeStr=DigestUtils.md5DigestAsHex(b);
		return encodeStr;
    }

    /**
     * MD5验证方法
     * 
     * @param text 明文
     * @param key 密钥
     * @param md5 密文
     * @return true/false
     * @throws Exception
     */
   
    
    //TODO
    
    /* public static boolean verify(String text, String key, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = string.getBytes()(text, key);
        if(md5Text.equalsIgnoreCase(md5))
        {
            System.out.println("MD5验证通过");
            return true;
        }

            return false;
    }*/

}
