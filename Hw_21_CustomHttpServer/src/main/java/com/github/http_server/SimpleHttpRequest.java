package com.github.http_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SimpleHttpRequest {

    private final Socket socket;

    private final String request;

    private String body;

    private Type type;

    private Map<String, String> headers;

    public SimpleHttpRequest(Socket socket) {
        this.headers = new HashMap<>();
        this.socket = socket;
        this.request = this.setRequest();
        System.out.println(this.request);
    }

    private String setRequest() {
        StringBuilder result = new StringBuilder();
        try {
            InputStream in = this.socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String str = reader.readLine();
            if(str != null) {
                this.type = Type.getValue(str.substring(0, str.indexOf(' ')));
                result.append(str + "\n");
            }
            while ((str = reader.readLine()) != null && !str.isEmpty()) {
                result.append(str + "\n");
                int i = str.indexOf(':');
                headers.put(str.substring(0, i), str.substring(i + 2));
            }
            if (this.headers.containsKey("Content-Length")) {
                int bodyLength = Integer.parseInt(this.headers.get("Content-Length"));
                char[] res = new char[bodyLength];
                reader.read(res, 0, bodyLength);
                this.body = new String(res);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return result.toString();
    }

    public String getBody() {
        return body;
    }

    public Type getType() {
        return this.type;
    }

}
