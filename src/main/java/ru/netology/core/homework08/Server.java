package ru.netology.core.homework08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        int port = 8080;

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());

                out.println("Write your name");
                String name = in.readLine();

                out.println("Write your age");
                int age = Integer.parseInt(in.readLine());

                out.println("Write your weight, kg");
                double weight = Double.parseDouble(in.readLine());

                out.println("Write your height, m");
                double height = Double.parseDouble(in.readLine());

                double bmi = Math.round((weight / (height * height)) * 100.0) / 100.0;
                out.println("Hi " + name
                        + "! Your age: " + age
                        + "! Your bmi: " + bmi
                        + "! Your result bmi: " + resultBMI(bmi));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String resultBMI(double bmi) {
        if (bmi < 15.99) {
            return "Выраженный дефицит массы тела";
        } else if (bmi >= 16.00 && bmi <= 18.50) {
            return "Недостаточная (дефицит) масса тела";
        } else if (bmi > 18.50 && bmi <= 25.0) {
            return "Норма";
        } else if (bmi > 25.00 && bmi <= 30.00) {
            return "Избыточная масса тела (предожирение)";
        } else if (bmi > 30.00 && bmi <= 35.00) {
            return "Ожирение первой степени";
        } else if (bmi > 35.00 && bmi <= 40.00) {
            return "Ожирение второй степени";
        } else if (bmi > 40.00) {
            return "Ожирение третьей степени (морбидное)";
        }
        return null;
    }
}