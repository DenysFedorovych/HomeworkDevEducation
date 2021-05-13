package com.github.http_server;

import java.io.IOException;
import java.net.Socket;

public class ConnectionThread implements Runnable{

    private final Socket socket;

    public ConnectionThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            SimpleHttpRequest simpleHttpRequest = new SimpleHttpRequest(socket);
            SimpleHttpResponse simpleHttpResponse = new SimpleHttpResponse(socket, new HttpHandler(simpleHttpRequest));
            Thread.sleep(1000);
            socket.close();
        } catch (IOException | InterruptedException exception) {
            exception.printStackTrace();
        }
    }

}
