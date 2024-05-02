package org.decrypt;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class GZIPDepress {
    public static byte[] depress(byte[] compressedData) {
        byte[] ans = null;
        try {
            // 创建 GZIPInputStream 对象并传入压缩后的数据流
            InputStream inputStream = new ByteArrayInputStream(compressedData);
            GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);

            // 读取解压缩后的数据
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = gzipInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }

            // 将解压缩后的数据转换为字符串
            ans = byteArrayOutputStream.toByteArray();
            // 关闭流
            gzipInputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ans;
    }
}
