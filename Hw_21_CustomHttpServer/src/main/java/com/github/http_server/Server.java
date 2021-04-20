package com.github.http_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private int port;

    public Server(int port) {
        this.port = port;
        this.startServer();
        this.makeHttpConnection();
    }

    private void startServer() {
        try {
            this.serverSocket = new ServerSocket(this.port);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        System.out.println("Local server started with port : " + this.port);
    }

    private void makeHttpConnection() {
        while (true) {
            try {
                Socket socket = this.serverSocket.accept();
                SimpleHttpRequest simpleHttpRequest = new SimpleHttpRequest(socket);
                SimpleHttpResponse simpleHttpResponse = new SimpleHttpResponse(socket, new HttpHandler(simpleHttpRequest));
                socket.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            } finally {
                System.out.println("Socket was closed.");
            }
        }
    }
}
