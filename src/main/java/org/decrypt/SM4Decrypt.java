package org.decrypt;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SM4;

import java.util.Base64;

public class SM4Decrypt {
    public static String decrypt(String ciphertext, String key, boolean use_gzip){
        Base64.Decoder b64decoder = Base64.getDecoder();
        SM4 sm4 = (SM4) SmUtil.sm4(b64decoder.decode(key));
        byte[] ans = sm4.decrypt(b64decoder.decode(ciphertext));
        if(!use_gzip)
            return new String(ans, CharsetUtil.CHARSET_UTF_8);
        else{
            ans = GZIPDepress.depress(ans);
            return new String(ans, CharsetUtil.CHARSET_UTF_8);
        }
    }
}
