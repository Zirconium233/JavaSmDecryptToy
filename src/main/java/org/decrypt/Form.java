package org.decrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form {
    public static void main( String[] args ) {
        JFrame frame = new JFrame("解密小工具");
        frame.setResizable(false);
        frame.setContentPane(new Form().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JButton button;
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JCheckBox CheckBox;
    private JTextArea textArea1;
    private JTextArea textArea2;

    public Form(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {

                String sm2Key = textField1.getText();
                String sm4Data = textArea1.getText();
                boolean useGzip = CheckBox.isSelected();
                try {
                    String key = decryptKey(sm2Key);
                    String data = decryptText(sm2Key, sm4Data, useGzip);
                    textField2.setText(key);
                    textArea2.setText(data);
                }
                catch (Exception ee){
                    JOptionPane.showConfirmDialog(panel1, "解密错误，请检查密钥和gzip设置，注意都是base64编码", "错误", JOptionPane.OK_OPTION);
                }
            }
        });
    }
    private String decryptKey( String key_enc ) {
        String key_dec = SM2Decrypt.decrypt(key_enc);
        return key_dec;
    }

    public String decryptText(String key, String data, boolean use_gzip){
        String ans = SM4Decrypt.decrypt(data, decryptKey(key), use_gzip);
        return ans;
    }
}
