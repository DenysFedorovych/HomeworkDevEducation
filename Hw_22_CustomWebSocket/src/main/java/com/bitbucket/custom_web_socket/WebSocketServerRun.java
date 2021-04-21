package com.bitbucket.custom_web_socket;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class WebSocketServerRun {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Server server = new Server(80);
    }

}
