package crc;

import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;
//check readme for details
public class CRC32Util {

    public static long compute(byte[] data) {
        CRC32 crc = new CRC32();
        crc.update(data, 0, data.length);
        return crc.getValue();
    }
    public static long compute(String s) {
        if (s == null) return 0L;
        return compute(s.getBytes(StandardCharsets.UTF_8));
    }

    public static String computeHex(byte[] data) {
        long v = compute(data);
        return String.format("%08x", v);
    }

    public static String computeHex(String s) {
        long v = compute(s);
        return String.format("%08x", v);
    }
}
