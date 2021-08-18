package com.daoklab.test.dbid.interceptor;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName: MyRequestWrapper
 * @Author: ztzh_liuxl
 * @Date: 2021/01/15 13:48
 * @Desc: TODO
 * @Version: 1.0
 */
public class MyRequestWrapper extends HttpServletRequestWrapper {

    private byte[] body;

    public MyRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        StringBuilder builder = new StringBuilder();
        String line;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        this.body = builder.toString().getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(body);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
    }

    public String getBody() {
        return new String(body, StandardCharsets.UTF_8);
    }
}
