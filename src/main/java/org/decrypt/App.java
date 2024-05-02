package org.decrypt;
import org.decrypt.SM2Decrypt;
import org.decrypt.SM4Decrypt;
import java.awt.*;
import java.awt.event.*;
public class App
{
//    public static void main( String[] args )
//    {
//        new App();
//    }
    public static void test()
    {
        String key = SM2Decrypt.decrypt("BIQWEosEECsZ6WdwU1lTkkLAXeN+t2rgDytWN+wMYKAXfDni7XUsfGcxsfQVCPrDrO73Wl6ZJd+/bJN+454r7W3XtWkF0SrqQ+khtaqOV9feXaNtvIB13ACUaWXtYEczSHenDnFfwqR0Y+YnHc+6ml+WY+oed3MfHg==");
        System.out.println(key);
        key = "d4tARxviwcU+f559sqki2A==";
        String ans = SM4Decrypt.decrypt("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", key, true);
        System.out.println(ans);
    }
}
