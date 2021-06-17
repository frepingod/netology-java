package ru.netology.core.homework03.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static final StringBuilder LOG = new StringBuilder();
    private static final String PATH = "D:/Programming/IdeaProjects/netology-java/src/ru/netology/core/homework03/Games";

    public static void main(String[] args) {
        File src = new File(PATH + "/src");
        File res = new File(PATH + "/res");
        File savegames = new File(PATH + "/savegames");
        File temp = new File(PATH + "/temp");

        writeToTheLog(src, src.mkdir());
        writeToTheLog(res, res.mkdir());
        writeToTheLog(savegames, savegames.mkdir());
        writeToTheLog(temp, temp.mkdir());

        File main = new File(src.getAbsolutePath() + "/main");
        File test = new File(src.getAbsolutePath() + "/test");

        writeToTheLog(main, main.mkdir());
        writeToTheLog(test, test.mkdir());

        File mainFile = new File(main.getAbsolutePath() + "/Main.java");
        File utilsFile = new File(main.getAbsolutePath() + "/Utils.java");

        try {
            writeToTheLog(mainFile, mainFile.createNewFile());
            writeToTheLog(utilsFile, utilsFile.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        File drawables = new File(res.getAbsolutePath() + "/drawables");
        File vectors = new File(res.getAbsolutePath() + "/vectors");
        File icons = new File(res.getAbsolutePath() + "/icons");

        writeToTheLog(drawables, drawables.mkdir());
        writeToTheLog(vectors, vectors.mkdir());
        writeToTheLog(icons, icons.mkdir());

        File tempFile = new File(temp.getAbsolutePath() + "/temp.txt");

        try {
            writeToTheLog(tempFile, tempFile.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        writeToTheFile(tempFile);
    }

    private static void writeToTheLog(File file, boolean result) {
        LOG.append(file.isDirectory() ? "Каталог '" : "Файл '")
                .append(file.getName())
                .append(result ? "' СОЗДАН!" : "' НЕ СОЗДАН!, потому что уже существует!")
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