package org.decrypt;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import java.util.Base64;

public class SM2Decrypt {
    // 默认的密钥
    public static final String DEFAULT_PRIVATE_KEY_BASE64 = "P3s0+rMuY4Nt5cUWuOCjMhDzVNdom+W0RvdV6ngM+/E=";
    public static final String DEFAULT_PUBLIC_KEY_BASE64 = "BL7JvEAV7Wci0h5YAysN0BPNVdcUhuyJszJLRwnurav0CGftcrVcvrWeCPBIjIIBF371teRbrCS9V1Wyq7i3Arc=";
    // 解密方法，接受密文作为参数
    public static String decrypt(String ciphertext) {
        // 创建 SM2 对象并使用默认私钥初始化
        Base64.Decoder b64decoder = Base64.getDecoder();
        SM2 sm2 = SmUtil.sm2(b64decoder.decode(DEFAULT_PRIVATE_KEY_BASE64), b64decoder.decode(DEFAULT_PUBLIC_KEY_BASE64));

        try {
            // 使用 SM2 对象进行解密
            byte[] decryptedData = sm2.decrypt(b64decoder.decode(ciphertext), KeyType.PrivateKey);
            // 将解密后的字节数组转换为字符串
            return new String(decryptedData);
        } catch (Exception e) {
            // 解密过程中可能会抛出异常，例如密文格式错误等
            e.printStackTrace();
            return null;
        }
    }
}