package com.example.demo.utl;

import java.util.Random;

/**
 * 生成salt的工具类
 */
public class SaltUtil {

    public static String getSalt(int n) {
        String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";

        StringBuffer sb = new StringBuffer();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int rand = random.nextInt(str.length() - 1);
            char c = str.charAt(rand);
            sb.append(c);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(getSalt(4));
    }
}
