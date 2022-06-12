package ru.netology.dan;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serial;
import java.io.Serializable;

public class GameProgress implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    public GameProgress openProgress(String path) {
        GameProgress progress = null;
        String fileName = "\\save3.dat";
        try(FileInputStream fis = new FileInputStream(path + fileName)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            progress = (GameProgress) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return progress;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }
}
