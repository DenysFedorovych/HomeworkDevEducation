package com.github.http_server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SimpleHttpResponse {

    private Socket socket;

    private HttpHandler httpHandler;

    public SimpleHttpResponse(Socket socket, HttpHandler httpHandler) {
        this.httpHandler = httpHandler;
        this.socket = socket;
        this.makeResponse(httpHandler.getResponce(), httpHandler.getHtmlPage());
    }

    private void makeResponse(String response, String html) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            writer.write(response);
            writer.write(html);
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
