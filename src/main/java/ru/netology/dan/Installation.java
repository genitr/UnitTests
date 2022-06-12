package ru.netology.dan;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Installation {

    private final String logPath = "C:\\Games\\temp\\temp.txt";
    private StringBuilder gameLog = new StringBuilder();

    public void createDirectory(File dir) {
        if(dir.mkdir()) {
            System.out.println("Директория была создана");
            gameLog.append("Создана папка ~ ")
                    .append(dir.getName())
                    .append(" [")
                    .append(dir.getPath())
                    .append("] ")
                    .append("\n");
        }
    }

    public void createFile(File gameFile) {
        try {
            if (gameFile.createNewFile()) {
                System.out.println("Файл был создан");
                gameLog.append("Создан файл ~ ")
                        .append(gameFile.getName())
                        .append(" [")
                        .append(gameFile.getPath())
                        .append("] ")
                        .append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void gameInstall (List<File> directories, List<File> files) {
        for (File gameDirectory : directories) {
            createDirectory(gameDirectory);
        }

        for (File gameFile : files) {
            createFile(gameFile);
        }
        createLog(gameLog);
    }

    public void createLog(StringBuilder gameLog) {
        try(FileWriter logFile = new FileWriter(logPath)) {
            logFile.write(gameLog.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
