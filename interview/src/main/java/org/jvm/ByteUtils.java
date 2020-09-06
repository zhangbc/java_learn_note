package org.jvm;

/**
 * ByteUtils 的实现
 *      Bytes数组处理工具
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/3 23:56
 */
public class ByteUtils {
    
    public static int bytes2Int(byte[] bytes, int start, int len) {
        int sum = 0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            int n = ((int) bytes[i]) & 0xff;
            n <<= (--len) * 8;
            sum += n;
        }
        
        return sum;
    }

    public static String bytes2String(byte[] bytes, int offset, int len) {
        return new String(bytes, offset, len);
    }

    public static byte[] string2Bytes(String str) {
        return str.getBytes();
    }

    public static byte[] int2Byte(int value, int len) {
        byte[] bytes = new byte[len];
        for (int i = 0; i < len; i++) {
            bytes[len - i - 1] = (byte) ((value >> 8 * i) & 0xff);
        }

        return bytes;
    }

    public static byte[] byteReplace(byte[] bytes, int offset, int len, byte[] replaceBytes) {
        byte[] newBytes = new byte[bytes.length + (replaceBytes.length - len)];
        System.arraycopy(bytes, 0, newBytes, 0, offset);
        System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
        System.arraycopy(bytes, offset + len, newBytes, offset + replaceBytes.length, bytes.length);
        return newBytes;
    }
}
