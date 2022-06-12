package ru.netology.dan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class InstallSaveLoadTest {

    @Test
    @DisplayName("Проверка пути для установки файлов")
    public void isPathExist() {

        // подготовка данных
        Installation install = new Installation();
        File file = new File("C:\\Games\\src\\Main.java");
        File path = new File("C:\\Games\\src");

        install.createDirectory(path);
        Assertions.assertTrue(path.exists());

        // вызов целевого метода
        install.createFile(file);

        // проверка результата
        Assertions.assertTrue(file.exists());
    }

    @Test
    @DisplayName("Проверка файла сохранения")
    public void isSaveFileExist() {

        // подготовка данных
        Installation install = new Installation();
        SaveAndLoad saveAndLoad = new SaveAndLoad();
        File saveDir = new File("C:\\Games\\savegames");
        File saveFile = new File("C:\\Games\\savegames\\save1.dat");
        List<GameProgress> gameProgress = new ArrayList<>();
        gameProgress.add(new GameProgress(1, 2, 3, 4));
        List<String> saveList = new ArrayList<>();

        install.createDirectory(saveDir);
        Assertions.assertTrue(saveDir.exists());

        // вызов целевого метода
        saveAndLoad.saveGame(gameProgress, saveList);

        // проверка результата
        Assertions.assertTrue(saveFile.exists() | saveFile.canWrite());
    }

    @Test
    @DisplayName("Был ли записан лог установки")
    public void isLogFileWrite() {

        // подготовка данных
        Installation install = new Installation();
        File logDir = new File("C:\\Games\\temp");
        File logFile = new File("C:\\Games\\temp\\temp.txt");
        StringBuilder sb = new StringBuilder();

        install.createDirectory(logDir);

        // вызов целевого метода
        install.createLog(sb);

        // проверка результата
        Assertions.assertTrue(logFile.exists() | (logFile.canRead()));
    }

}
