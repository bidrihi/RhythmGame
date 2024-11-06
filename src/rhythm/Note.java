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

    private boolean proceeded = true;

    public String getNoteType() {
        return noteType;
    }

    public boolean isProceeded() {
        return proceeded;
    }

    public void close() {
        proceeded = false;
    }

    public Note(String noteType) {
        if (noteType.equals("S")) {
            x = 228;
        } else if (noteType.equals("D")) {
            x = 332;
        } else if (noteType.equals("F")) {
            x = 436;
        } else if (noteType.equalsIgnoreCase("Space")) {
            x = 540;
        } else if (noteType.equals("J")) {
            x = 744;
        } else if (noteType.equals("K")) {
            x = 848;
        } else if (noteType.equals("L")) {
            x = 952;
        }
        this.noteType = noteType;
    }

    public void screenDraw(Graphics2D g) {
        if (!noteType.equalsIgnoreCase("Space")) {
            g.drawImage(noteBasicImage, x, y, null);
        } else {
            g.drawImage(noteBasicImage, x, y, null);
            g.drawImage(noteBasicImage, x + 100, y, null);
        }
    }

    public void drop() {
        y += NOTE_SPEED;
        if (y > 620) {
            close();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                drop();
                if (proceeded) {
                    Thread.sleep(SLEEP_TIME);
                } else {
                    interrupt();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String judge() {
        if (y >= 613) {
            close();
            return "Late";
        } else if (y >= 600) {
            close();
            return "Good";
        } else if (y >= 587) {
            close();
            return "Great";
        } else if (y >= 573) {
            close();
            return "Perfect";
        } else if (y >= 565) {
            close();
            return "Great";
        } else if (y >= 550) {
            close();
            return "Good";
        } else if (y >= 530) {
            close();
            return "Early";
        }
        return "None";
    }

    public int getY() {
        return y;
    }
}
