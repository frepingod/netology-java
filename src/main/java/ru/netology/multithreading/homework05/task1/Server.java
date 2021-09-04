package ru.netology.multithreading.homework05.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        int port = 8080;

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
            ) {

                System.out.printf("New connection accepted. Port: %d%n", socket.getPort());

                out.println("Enter the number of the desired member of the Fibonacci series, starting with one:");
                int n = Integer.parseInt(in.readLine());
                int nthFibonacciNumber = nthFibonacciNumber(n);
                out.println("Hi " + socket.getPort() + "! Your answer: " + nthFibonacciNumber);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int nthFibonacciNumber(int n) {
        int[] fibonacciSeries = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                fibonacciSeries[i] = 0;
            } else if (i == 1) {
                fibonacciSeries[i] = 1;
            } else {
                fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
            }
        }

        return fibonacciSeries[n - 1];
    }
}