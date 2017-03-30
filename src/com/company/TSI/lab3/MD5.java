package com.company.TSI.lab3;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;

/**
 * Author: vadym
 * Date: 26.02.17
 * Time: 15:25
 */
public class MD5 {

        public static String getHash(String str) throws NoSuchAlgorithmException,
                UnsupportedEncodingException {
//            String s="f78spx";
            String s="muffin break";
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.reset();
            // передаем в MessageDigest байт-код строки
            m.update(str.getBytes("utf-8"));
            // получаем MD5-хеш строки без лидирующих нулей
            String s2 = new BigInteger(1, m.digest()).toString(16);
            StringBuilder sb = new StringBuilder(32);
            // дополняем нулями до 32 символов, в случае необходимости
            //System.out.println(32 - s2.length());
            for (int i = 0, count = 32 - s2.length(); i < count; i++) {
                sb.append("0");
            }
            // возвращаем MD5-хеш
            return sb.append(s2).toString();
        }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println(getMD5Digest("gheijf"));
    }



    public static long hash(long x){
        if (x%1000==0) return 1000;
        return (x % 1000);
    }

    private static String getMD5Digest(String input) {
        byte[] buffer = input.getBytes();
        String resultHash = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            byte[] result = new byte[md5.getDigestLength()];
            md5.reset();
            md5.update(buffer);
            result = md5.digest();

            StringBuffer buf = new StringBuffer(result.length * 2);

            for (int i = 0; i < result.length; i++) {
                int intVal = result[i] & 0xff;
                if (intVal < 0x10) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(intVal));
            }

            resultHash = buf.toString();
        } catch (NoSuchAlgorithmException e) {
        }
        return resultHash;
    }
}
