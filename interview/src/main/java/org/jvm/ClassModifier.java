package org.jvm;

/**
 * ClassModifier的实现
 *      修改Class文件，暂时只提供修改常量池常量的功能
 *
 * @author zhangbocheng
 * @version v1.0
 * @date 2020/9/3 23:30
 */
public class ClassModifier {

    /**
     * Class文件中常量池的起始偏移
     */
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;

    /**
     * CONSTANT_Utf8_info常量的tag标志
     */
    private static final int CONSTANT_UTF8_INFO = 1;

    /**
     * 常量池中11种常量所占的长度，CONSTANT_Utf8_info型常量除外，因为它不是定长的
     */
    private static final int[] CONSTANT_ITEM_LENGTH = {-1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5};

    private static final int U1 = 1;
    private static final int U2 = 2;

    private byte[] bytes;

    public ClassModifier(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] modifyUtf8Constant(String oldStr, String newStr) {
        int cpc = getConstantPoolCount();
        int offset = CONSTANT_POOL_COUNT_INDEX + U2;
        for (int i = 0; i < cpc; i++) {
            int tag = ByteUtils.bytes2Int(bytes, offset, U1);
            if (tag == CONSTANT_UTF8_INFO) {
                int len = ByteUtils.bytes2Int(bytes, offset + U1, U2);
                offset += (U1 + U2);
                String str = ByteUtils.bytes2String(bytes, offset, len);
                if (str.equalsIgnoreCase(oldStr)) {
                    byte[] strBytes = ByteUtils.string2Bytes(newStr);
                    byte[] strLen = ByteUtils.int2Byte(newStr.length(), U2);
                    bytes = ByteUtils.byteReplace(bytes, offset - U2, U2, strLen);
                    bytes = ByteUtils.byteReplace(bytes, offset, len, strBytes);
                    return bytes;
                } else {
                    offset += len;
                }
            } else {
                offset += CONSTANT_ITEM_LENGTH[tag];
            }
        }

        return bytes;
    }

    private int getConstantPoolCount() {
        return ByteUtils.bytes2Int(bytes, CONSTANT_POOL_COUNT_INDEX, U2);
    }
}
