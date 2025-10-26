# CRC utilities

This folder contains a small CRC32 utility implemented in Java.

Files:

- `CRC32Util.java` — simple wrapper around `java.util.zip.CRC32` with helpers to compute CRC32 for byte arrays and strings and to return the checksum as hex.

Example usage:

```java
import crc.CRC32Util;

public class Example {
    public static void main(String[] args) {
        String s = "hello";
        long checksum = CRC32Util.compute(s);
        String hex = CRC32Util.computeHex(s);
        System.out.println("crc32(" + s + ") = " + checksum + " (0x" + hex + ")");
    }
}
```
