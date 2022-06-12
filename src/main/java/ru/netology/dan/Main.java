package ru.netology.dan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Installation install = new Installation();
        SaveAndLoad saveAndLoad = new SaveAndLoad();

        //StringBuilder gameLog = new StringBuilder();


        // список директорий
        List<File> gameDirectories = new ArrayList<>();
        gameDirectories.add(new File("C:\\Games\\src"));
        gameDirectories.add(new File("C:\\Games\\res"));
        gameDirectories.add(new File("C:\\Games\\savegames"));
        gameDirectories.add(new File("C:\\Games\\temp"));
        gameDirectories.add(new File("C:\\Games\\src\\main"));
        gameDirectories.add(new File("C:\\Games\\src\\test"));
        gameDirectories.add(new File("C:\\Games\\res\\drawables"));
        gameDirectories.add(new File("C:\\Games\\res\\vectors"));
        gameDirectories.add(new File("C:\\Games\\res\\icons"));

        //install.createSaveDirectory(String.valueOf(gameDirectories.get(2)));

        // список файлов
        List<File> gameFiles = new ArrayList<>();
        gameFiles.add(new File("C:\\Games\\src\\main\\Main.java"));
        gameFiles.add(new File("C:\\Games\\src\\main\\Utils.java"));
        gameFiles.add(new File("C:\\Games\\temp\\temp.txt"));

        install.gameInstall(gameDirectories, gameFiles);
        //install.createLog(install.getGameLog());

        List<GameProgress> gameProgress = new ArrayList<>();
        gameProgress.add(new GameProgress(110, 2, 1, 125.6));
        gameProgress.add(new GameProgress(58, 12, 11, 190.0));
        gameProgress.add(new GameProgress(200, 6, 4, 111.11));

        List<String> saveList = new ArrayList<>();

        saveAndLoad.saveGame(gameProgress, saveList);

        saveAndLoad.zipFiles(saveList);

        saveAndLoad.openZip();

        GameProgress loadProgress = saveAndLoad.openProgress();
        System.out.println(loadProgress);

    }
}
