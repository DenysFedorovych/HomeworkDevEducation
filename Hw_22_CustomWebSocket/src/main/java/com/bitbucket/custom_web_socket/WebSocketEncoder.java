package com.bitbucket.custom_web_socket;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class WebSocketEncoder {

    private static short getShort(byte one, byte two) {
        ByteBuffer bb = ByteBuffer.allocate(2);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.put(one);
        bb.put(two);
        return bb.getShort(0);
    }

    public static byte[] decode(byte[] input) {
        int length = (input[1]) + 128;
        byte[] encoded = null;
        byte[] key = new byte[4];
        int offset;
        if (length < 126) {
            offset = 2;
        } else {
            offset = 4;
            length = getShort(input[3], input[2]);
        }
        encoded = new byte[length];
        for (int i = 0; i < length; i++) {
            encoded[i] = input[i + offset + 4];
        }
        for (int i = 0; i < 4; i++) {
            key[i] = input[i + offset];
        }
        byte[] result = new byte[encoded.length];
        for (int i = 0; i < encoded.length; i++) {
            result[i] = (byte) (encoded[i] ^ key[i & 0x3]);
        }
        return result;
    }

    public static byte[] encodeMessage(String string) {
        byte[] result;
        int offset = 2;
        if (string.length() < 126) {
            result = new byte[string.length() + offset];
            result[1] = (byte) string.length();
        } else {
            offset = 4;
            result = new byte[string.length() + offset];
            result[1] = (byte) 126;
            result[2] = (byte)((string.length() >> 8) & 0xff);
            result[3] = (byte)(string.length() & 0xff);
        }
        result[0] = (byte) -127;
        for (int i = 0; i < string.length(); i++) {
            result[i + offset] = (byte) string.charAt(i);
        }
        return result;
    }

}
