package com.example.demo.shiro.salt;

import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

/**
 * 用与认证时salt使用ByteSource不能正常序列化的问题
 */
public class MyByteSource extends SimpleByteSource implements Serializable {


    private static final long serialVersionUID = -848895509249493609L;

    public MyByteSource(String string) {
        super(string);
    }

    public MyByteSource(ByteSource source) {
        super(source);
    }

    public MyByteSource(File file) {
        super(file);
    }

    public MyByteSource(InputStream stream) {
        super(stream);
    }

    public MyByteSource(byte[] bytes) {
        super(bytes);
    }

    public MyByteSource(char[] chars) {
        super(chars);
    }
}
