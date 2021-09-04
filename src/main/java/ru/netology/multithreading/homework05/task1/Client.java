package ru.netology.multithreading.homework05.task1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8080;

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)
        ) {

            System.out.println(in.readLine());
            out.println(scanner.nextLine());

            System.out.println(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}