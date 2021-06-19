package ru.netology.basics.javabasicsdiploma.graphics;

import ru.netology.basics.javabasicsdiploma.graphics.image.TextGraphicsConverter;
import ru.netology.basics.javabasicsdiploma.graphics.image.TextGraphicsConverterImpl;
import ru.netology.basics.javabasicsdiploma.graphics.server.GServer;

import java.io.File;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        TextGraphicsConverter converter = new TextGraphicsConverterImpl();

        //GServer server = new GServer(converter); // Создаём объект сервера
        //server.start(); // Запускаем

        // Или то же, но с сохранением в файл:
        ///*
        PrintWriter fileWriter = new PrintWriter(new File("src/ru/netology/basics/javabasicsdiploma/converted-image.txt"));
        converter.setMaxWidth(200);
        converter.setMaxHeight(300);
        //fileWriter.write(converter.convert("https://i.ibb.co/6DYM05G/edu0.jpg")); //example
        fileWriter.write(converter.convert("https://proprikol.ru/wp-content/uploads/2020/10/kartinki-ne-grusti-1.jpg")); //example
        fileWriter.close();
        //*/
    }
}