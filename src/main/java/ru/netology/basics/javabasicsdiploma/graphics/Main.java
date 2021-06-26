package ru.netology.basics.javabasicsdiploma.graphics;

import ru.netology.basics.javabasicsdiploma.graphics.image.TextGraphicsConverter;
import ru.netology.basics.javabasicsdiploma.graphics.image.TextGraphicsConverterImpl;

import java.io.File;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        TextGraphicsConverter converter = new TextGraphicsConverterImpl();

        PrintWriter fileWriter = new PrintWriter(new File("./src/main/java/ru/netology/basics/javabasicsdiploma/converted-image.txt"));
        converter.setMaxWidth(200);
        converter.setMaxHeight(300);
        fileWriter.write(converter.convert("https://proprikol.ru/wp-content/uploads/2020/10/kartinki-ne-grusti-1.jpg")); //example
        fileWriter.close();
    }
}