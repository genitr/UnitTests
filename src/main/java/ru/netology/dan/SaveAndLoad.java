package ru.netology.dan;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class SaveAndLoad {

    private final String saveDir = "C:\\Games\\savegames";

    public void saveGame(List<GameProgress> gameProgress, List<String> saveList) {
        for (int i = 0; i < gameProgress.size(); i++) {
            try(FileOutputStream fos = new FileOutputStream(saveDir + "\\save" + (i + 1) + ".dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(gameProgress.get(i));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            saveList.add(saveDir + "\\save" + (i + 1) + ".dat");
        }
    }

    public void zipFiles(List<String> saveList) {
        String name = "\\save.zip";
        try(ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(saveDir + name))) {
            for (int i = 0; i < saveList.size(); i++) {
                try(FileInputStream fis = new FileInputStream(saveList.get(i))) {
                    ZipEntry entry = new ZipEntry("save" + (i + 1) + ".dat");
                    zout.putNextEntry(entry);
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zout.write(buffer);
                    zout.closeEntry();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                File fileToDelete = new File(saveList.get(i));
                if (fileToDelete.exists()) fileToDelete.delete();
                else System.out.println("Файд не найден");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void openZip() {
        String zipName = "\\save.zip";
        try(ZipInputStream zis = new ZipInputStream(new FileInputStream(saveDir + zipName))) {
            ZipEntry entry;
            String fileName;
            while ((entry = zis.getNextEntry()) != null) {
                fileName = entry.getName();
                FileOutputStream fos = new FileOutputStream(saveDir + "\\" + fileName);
                for (int c = zis.read(); c!= -1; c = zis.read()) {
                    fos.write(c);
                }
                fos.flush();
                zis.closeEntry();
                fos.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public GameProgress openProgress() {
        GameProgress progress = null;
        String fileName = "\\save.dat";
        try(FileInputStream fis = new FileInputStream(saveDir + fileName)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            progress = (GameProgress) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return progress;
    }
}
