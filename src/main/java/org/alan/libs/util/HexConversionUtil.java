package org.alan.libs.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * 进制转换类
 * Alan
 * 2015-1-20 下午9:57:10
 */
public class HexConversionUtil {
    final static char[] digits64 = {  
        '0' , '1' , '2' , '3' , '4' , '5' , 
        '6' , '7' , '8' , '9' , 'a' , 'b' , 
        'c' , 'd' , 'e' , 'f' , 'g' , 'h' , 
        'i' , 'j' , 'k' , 'l' , 'm' , 'n' , 
        'o' , 'p' , 'q' , 'r' , 's' , 't' , 
        'u' , 'v' , 'w' , 'x' , 'y' , 'z' , 
        'A' , 'B' , 'C' , 'D' , 'E' , 'F' , 
        'G' , 'H' , 'I' , 'J' , 'K' , 'L' , 
        'M' , 'N' , 'O' , 'P' , 'Q' , 'R' , 
        'S' , 'T' , 'U' , 'V' , 'W' , 'X' , 
        'Y' , 'Z' , '*' , '~'
    }, digits16 = {
        '0' , '1' , '2' , '3' , '4' , '5' , 
        '6' , '7' , '8' , '9' , 'a' , 'b' , 
        'c' , 'd' , 'e' , 'f'
    }, digits32 = {
        'a' , 'b' , 'c' , 'd' , 'e' , 'f' , 'g' , 'h' , 
        'i' , 'j' , 'k' , 'l' , 'm' , 'n' , 
        'o' , 'p' , 'q' , 'r' , 's' , 't' , 
        'u' , 'v' , 'w' , 'x' , 'y' , 'z', '0', '1',
        '2', '3', '4', '5'
    };
    
    /**
     * 将10进制转为指定进制字串
     * Alan
     * @param number 64进制为6
     * @return
     * 2015-1-20 下午9:57:25
     */
    public static String decimal2SixtyFour(long number) {  
        return decimal2SixtyFour(number, 6);
   } 
    
    /**
     * 把10进制的数字转换成64进制
     * Alan
     * @param number
     * @param shift  根本没用（如果需要转为不同进制，那么digits64值也不一样，所以这样写还是无法通用）
     * @return
     * 2015-1-20 下午9:57:41
     */
    private static String decimal2SixtyFour(long number, int shift) {
        int size = 1 << shift;
        char[] buf = new char[size];  
        int charPos = size;  
        long mask = size - 1;
        do {  
            buf[--charPos] = digits64[(int)(number & mask)];  
            number >>>= shift;  
        } while (number != 0);  
        return new String(buf, charPos, (64 - charPos));  
   }
    
    /**
     * 把十进制转为32进制
     * Alan
     * @param number
     * @return
     * 2015-1-22 下午9:41:37
     */
    public static String decimal2ThirtyTwo(long number) {
        int size = 1 << 5;
        char[] buf = new char[size];
        int charPos = size;
        long mask = size -1;
        do {
            buf[--charPos] = digits32[(int)(number & mask)];
            number >>>= 5;
        } while (number != 0);
        return new String(buf, charPos, (size - charPos));
    }
    
    public static long thirtyTwo2Decimal(String decompStr) {
        long result = 0;
        for(int n=0; n<decompStr.length(); n++) {
            result <<= 5;
            result += getCharIndexNum4ThirtyTwo(decompStr.charAt(n));
        }        
        
        return result;
    }
    
    /**
     * 把64进制的字符串转换成10进制 
     * Alan
     * @param decompStr
     * @return
     * 2015-1-20 下午9:58:47
     */
    public static long sixtyFour2Decimal(String decompStr) {
//        long result = 0;  
//        for (int i = decompStr.length() - 1; i >= 0; i--) {
//            if(i == decompStr.length() - 1) {
//                result += getCharIndexNum(decompStr.charAt(i));
//                continue;
//            }
//            for (int j = 0; j < digits.length; j++) {
//                if(decompStr.charAt(i) == digits[j]) {
//                    result += ((long)j) << 6 * (decompStr.length() - 1 - i);
//                }
//            }  
//        }  
        
        long result = 0;
        for(int n=0; n<decompStr.length(); n++) {
            result<<=6;
            result+=getCharIndexNum4SixtyFour(decompStr.charAt(n));
        }        
        
        return result;
    }
    
    /**
     * 用于64进制转为10进制
     * Alan
     * @param ch
     * @return
     * 2015-1-20 下午9:59:08
     */
    private static long getCharIndexNum4SixtyFour(char ch) {  
        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        } else if (ch >= 'a' && ch <= 'z') {
            return ch - 'a' + 10;
        } else if (ch >= 'A' && ch <= 'Z') {
            return ch - 'A' + 36;
        } else if (ch == '*') {
            return 62;
        } else if (ch == '~') {
            return 63;
        }
        return 0;
    }
    
    /**
     * 用于32进制转为10进制
     * Alan
     * @param ch
     * @return
     * 2015-1-22 下午9:44:21
     */
    private static long getCharIndexNum4ThirtyTwo(char ch) {  
        if (ch >= '0' && ch <= '5') {
            return ch - '0' + 27;
        } else if (ch >= 'a' && ch <= 'z') {
            return ch - 'a';
        }
        return 0;
    }
    
    
    /**
     * 字节数组转64进制
     * Alan
     * @param bytes
     * @return
     * 2015-1-20 下午9:59:32
     */
    public static String byte2SixtyFour(byte[] bytes) {
        //return Base64.encodeBase64String(bytes);
        char[] out = new char[bytes.length << 1];
        for (int i = 0, j = 0; i < bytes.length; i++) {
            out[j++] = digits64[(0xC0 & bytes[i]) >>> 6];
            out[j++] = digits64[0x3F & bytes[i]];
        }
        return new String(out);
    }
    
    /**
     * 将字节数组转为16进制
     * Alan
     * @param bytes
     * @return
     * 2015-1-20 下午9:59:39
     */
    public static String byte2Sixteen(byte[] bytes) {
        char[] out = new char[bytes.length << 1];
        for (int i = 0, j = 0; i < bytes.length; i++) {
            out[j++] = digits64[(0xF0 & bytes[i]) >>> 4];
            out[j++] = digits64[0x0F & bytes[i]];
        }
        return new String(out);
    }
    
    /**
     * 字节数组转md5
     * Alan
     * @param bytes
     * @return
     * @throws NoSuchAlgorithmException
     * 2015-1-20 下午9:59:46
     */
    public static String byte2Md5(byte[] bytes) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(bytes);
        return byte2SixtyFour(hash);
    }
    
    /**
     * 字节数组转md5(结果转为16进制字符串)
     * Alan
     * @param bytes
     * @return
     * @throws NoSuchAlgorithmException
     * 2015-1-20 下午9:59:58
     */
    public static String byte2Md516(byte[] bytes) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(bytes);
        return byte2Sixteen(hash);
    }

    /**
     * 将字符串转为md5码
     * Alan
     * @param str
     * @param encoding
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     * 2015-1-20 下午10:01:00
     */
    public static String toMd5(String str, String encoding) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return byte2Md5(str.getBytes(encoding));
    }
}
