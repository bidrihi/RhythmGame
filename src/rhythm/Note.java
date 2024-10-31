package rhythm;

import javax.swing.*;
import java.awt.*;

public class Note extends Thread {
    public static final int NOTE_SPEED = 3;
    public static final int SLEEP_TIME = 10;
    public static final int REACH_TIME = 2;

    private final Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.jpg")).getImage();
    private int x, y = 580 - (1000 / SLEEP_TIME * NOTE_SPEED) * REACH_TIME;
    private String noteType;

    public Note(String noteType) {
        switch (noteType) {
            case "S":
                x = 228;
                break;
            case "D":
                x = 332;
                break;
            case "F":
                x = 436;
                break;
            case "Space":
                x = 540;
                break;
            case "J":
                x = 744;
                break;
            case "K":
                x = 848;
                break;
            case "L":
                x = 952;
                break;
        }
        this.noteType = noteType;
    }

    public void screenDraw(Graphics2D g) {
        if (!noteType.equals("Space")) {
            g.drawImage(noteBasicImage, x, y, null);
        } else {
            g.drawImage(noteBasicImage, x, y, null);
            g.drawImage(noteBasicImage, x + 100, y, null);
        }
    }

    public void drop() {
        y += NOTE_SPEED;
    }

    @Override
    public void run() {
        try {
            while (true) {
                drop();
                Thread.sleep(SLEEP_TIME);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
