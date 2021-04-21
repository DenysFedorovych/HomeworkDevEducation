package com.bitbucket.custom_web_socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {

    private final int port;

    public Server(int port) {
        this.port = port;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.printf("Server has started on 127.0.0.1:%d.\r\nWaiting for a connection...", this.port);
            Socket client = server.accept();
            System.out.println("A client connected.");
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();
            makeHandshake(in, out);
            while (true) {
                byte[] input = read(in);
                String message = new String(WebSocketEncoder.decode(input), StandardCharsets.UTF_8);
                System.out.println("Your received message is : " + message);
                byte[] output = WebSocketEncoder.encodeMessage("Received message is : " + message);
                out.write(output);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void makeHandshake(InputStream in, OutputStream out) {
        try {
            Scanner s = new Scanner(in, "UTF-8");
            String data = s.useDelimiter("\\r\\n\\r\\n").next();
            Matcher get = Pattern.compile("^GET").matcher(data);
            if (get.find()) {
                byte[] response = handshakeResponse(data);
                out.write(response, 0, response.length);
            }
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] handshakeResponse(String data) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Matcher match = Pattern.compile("Sec-WebSocket-Key: (.*)").matcher(data);
        match.find();
        return ("HTTP/1.1 101 Switching Protocols\r\n"
                + "Connection: Upgrade\r\n"
                + "Upgrade: websocket\r\n"
                + "Sec-WebSocket-Accept: "
                + Base64.getEncoder().encodeToString(MessageDigest.getInstance("SHA-1").digest((match.group(1) + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes(StandardCharsets.UTF_8)))
                + "\r\n\r\n").getBytes("UTF-8");
    }

    private byte[] read(InputStream in) throws IOException {
        while (in.available() < 3) ;
        byte[] bytes = new byte[in.available()];
        in.read(bytes, 0, in.available());
        return bytes;
    }
}
