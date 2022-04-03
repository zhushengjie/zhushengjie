package com.zhuzhu.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try(ServerSocket s = new ServerSocket(8189)){
            try(Socket incoming = s.accept()){
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();
                try(Scanner in = new Scanner(inputStream, StandardCharsets.UTF_8.name())){
                    PrintWriter out = new PrintWriter(
                            new OutputStreamWriter(outputStream,StandardCharsets.UTF_8),true);
                    out.println("HELLO!Enter BYE to exit.");
                    boolean done = false;
                    while (!done && in.hasNextLine()){
                        String line = in.nextLine();
                        out.println("ECHO:"+line);
                        if(line.trim().equals("BYE")) done = true;
                    }
                }
            }
        }
    }
}
