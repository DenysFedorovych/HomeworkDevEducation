package com.github.http_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

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
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(80);
        while (true) {
            try {
                ConnectionThread connectionThread = new ConnectionThread(this.serverSocket.accept());
                executor.execute(connectionThread);
                System.out.println("Active count : " + executor.getActiveCount());
            } catch (IOException exception) {
                exception.printStackTrace();
            } finally {
                System.out.println("Socket was closed.");
            }
        }
    }
}
