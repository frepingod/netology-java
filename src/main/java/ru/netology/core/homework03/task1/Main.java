package ru.netology.core.homework03.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final StringBuilder LOG = new StringBuilder();
    private static final String PATH = "./src/main/java/ru/netology/core/homework03/Games";

    private static final List<String> DIR_PATHS = Arrays.asList(
            PATH + "/src", PATH + "/res", PATH + "/savegames", PATH + "/temp",
            PATH + "/src/main", PATH + "/src/test",
            PATH + "/res/drawables", PATH + "/res/vectors", PATH + "/res/icons"
    );

    private static final List<String> FILE_PATHS = Arrays.asList(
            PATH + "/src/main/Main.java", PATH + "/src/main/Utils.java",
            PATH + "/temp/temp.txt"
    );

    public static void main(String[] args) {
        for (String dirPath : DIR_PATHS) {
            File dir = new File(dirPath);
            writeToTheLog(dir, dir.mkdir());
        }

        for (String filePath : FILE_PATHS) {
            File file = new File(filePath);
            try {
                writeToTheLog(file, file.createNewFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        writeToTheFile(new File(PATH + "/temp/temp.txt"));
    }

    private static void writeToTheLog(File file, boolean result) {
        LOG.append(file.isDirectory() ? "Каталог '" : "Файл '")
                .append(file.getName())
                .append(result ? "' СОЗДАН!" : "' НЕ СОЗДАН!")
                .append((!result && file.exists()) ? ", потому что уже существует!" : "")
                .append((!result && !file.exists()) ? ", потому что неверно указан путь!" : "")
                .append("\n");
    }

    private static void writeToTheFile(File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(LOG.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}