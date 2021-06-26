package ru.netology.core.homework03.task3;

import ru.netology.core.homework03.task2.GameProgress;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Main {

    private static final String PATH = "./src/main/java/ru/netology/core/homework03/Games/savegames";

    public static void main(String[] args) {
        openZip(PATH + "/savegames.zip", PATH);

        System.out.println(openProgress(PATH + "/saveGame1.1.dat"));
        System.out.println(openProgress(PATH + "/saveGame2.1.dat"));
        System.out.println(openProgress(PATH + "/saveGame3.1.dat"));
    }

    private static void openZip(String filePath, String unzipPath) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(filePath))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fout = new FileOutputStream(unzipPath + "/" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static GameProgress openProgress(String savePath) {
        GameProgress gameProgress = null;

        try (FileInputStream  fis = new FileInputStream(savePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            gameProgress = (GameProgress) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return gameProgress;
    }
}