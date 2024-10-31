package rhythm;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends Thread {
    private final Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
    private final Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
    private final Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
    private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
    private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

    private String titleName;
    private String difficulty;
    private String musicTitle;
    private Music gameMusic;

    ArrayList<Note> noteList = new ArrayList<>();

    private boolean gameMaker = false;

    public Game(String titleName, String difficulty, String musicTitle) {
        this.titleName = titleName;
        this.difficulty = difficulty;
        this.musicTitle = musicTitle;
        gameMusic = new Music(this.musicTitle, false);
    }

    public void screenDraw(Graphics2D g) {
        g.drawImage(noteRouteSImage, 228, 30, null);
        g.drawImage(noteRouteDImage, 332, 30, null);
        g.drawImage(noteRouteFImage, 436, 30, null);
        g.drawImage(noteRouteSpace1Image, 540, 30, null);
        g.drawImage(noteRouteSpace2Image, 640, 30, null);
        g.drawImage(noteRouteJImage, 744, 30, null);
        g.drawImage(noteRouteKImage, 848, 30, null);
        g.drawImage(noteRouteLImage, 952, 30, null);
        g.drawImage(noteRouteLineImage, 224, 30, null);
        g.drawImage(noteRouteLineImage, 328, 30, null);
        g.drawImage(noteRouteLineImage, 432, 30, null);
        g.drawImage(noteRouteLineImage, 536, 30, null);
        g.drawImage(noteRouteLineImage, 740, 30, null);
        g.drawImage(noteRouteLineImage, 844, 30, null);
        g.drawImage(noteRouteLineImage, 948, 30, null);
        g.drawImage(noteRouteLineImage, 1052, 30, null);
        g.drawImage(gameInfoImage, 0, 660, null);
        g.drawImage(judgementLineImage, 0, 580, null);

        for (int i = 0; i < noteList.size(); i++) {
            Note note = noteList.get(i);
            if (!note.isProceeded()) {
                noteList.remove(i);
                i--;
            } else {
                note.screenDraw(g);
            }
        }

        g.setColor(Color.white);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(titleName, 20, 702);
        g.drawString(difficulty, 1190, 702);
        g.setFont(new Font("Arial", Font.PLAIN, 26));
        g.setColor(Color.DARK_GRAY);
        g.drawString("S", 270, 609);
        g.drawString("D", 374, 609);
        g.drawString("F", 478, 609);
        g.drawString("Space Bar", 580, 609);
        g.drawString("J", 784, 609);
        g.drawString("K", 889, 609);
        g.drawString("L", 993, 609);
        g.setFont(new Font("Elephant", Font.BOLD, 30));
        g.drawString("000000", 565, 702);
    }

    public void pressS() {
        judge("S");
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("snare1.mp3", false).start();
        if (gameMaker) {
            System.out.println(gameMusic.getTime() + " S");
        }
    }

    public void releaseS() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

    }

    public void pressD() {
        judge("D");
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("snare1.mp3", false).start();
        if (gameMaker) {
            System.out.println(gameMusic.getTime() + " D");
        }
    }

    public void releaseD() {
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

    }

    public void pressF() {
        judge("F");
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("snare1.mp3", false).start();
        if (gameMaker) {
            System.out.println(gameMusic.getTime() + " F");
        }
    }

    public void releaseF() {
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

    }

    public void pressSpace() {
        judge("Space");
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("tom1.mp3", false).start();
        if (gameMaker) {
            System.out.println(gameMusic.getTime() + " Space");
        }
    }

    public void releaseSpace() {
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

    }

    public void pressJ() {
        judge("J");
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("snare1.mp3", false).start();
        if (gameMaker) {
            System.out.println(gameMusic.getTime() + " J");
        }
    }

    public void releaseJ() {
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

    }

    public void pressK() {
        judge("K");
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("snare1.mp3", false).start();
        if (gameMaker) {
            System.out.println(gameMusic.getTime() + " K");
        }
    }

    public void releaseK() {
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

    }

    public void pressL() {
        judge("L");
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        new Music("snare1.mp3", false).start();
        if (gameMaker) {
            System.out.println(gameMusic.getTime() + " L");
        }
    }

    public void releaseL() {
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

    }

    @Override
    public void run() {
        dropNotes(this.titleName);
    }

    public void close() {
        gameMusic.close();
        this.interrupt();
    }

    public void dropNotes(String titleName) {
        Beat[] beats = null;
        if (titleName.equalsIgnoreCase("information") && difficulty.equals("Easy")) {
            int startTime = 4460 - Note.REACH_TIME * 1000;
            int gap = 2000;
            beats = new Beat[]{
                    new Beat(startTime, "Space"),
                    new Beat(startTime + gap * 2, "Space"),
                    new Beat(startTime + gap * 4, "S"),
                    new Beat(startTime + gap * 6, "D"),
                    new Beat(startTime + gap * 8, "F"),
                    new Beat(startTime + gap * 10, "J"),
                    new Beat(startTime + gap * 12, "K"),
                    new Beat(startTime + gap * 14, "L"),
                    new Beat(startTime + gap * 16, "L"),
                    new Beat(startTime + gap * 18, "K"),
                    new Beat(startTime + gap * 20, "J"),
                    new Beat(startTime + gap * 22, "D"),
                    new Beat(startTime + gap * 24, "F"),
                    new Beat(startTime + gap * 26, "S"),
                    new Beat(startTime + gap * 28, "S"),
                    new Beat(startTime + gap * 30, "J"),
                    new Beat(startTime + gap * 32, "Space"),
                    new Beat(startTime + gap * 34, "S"),
                    new Beat(startTime + gap * 36, "K"),
                    new Beat(startTime + gap * 38, "S"),
                    new Beat(startTime + gap * 40, "L"),
                    new Beat(startTime + gap * 42, "L"),
                    new Beat(startTime + gap * 44, "F"),
                    new Beat(startTime + gap * 46, "Space"),
                    new Beat(startTime + gap * 48, "D"),
                    new Beat(startTime + gap * 50, "D"),
                    new Beat(startTime + gap * 52, "S"),
                    new Beat(startTime + gap * 54, "J"),
                    new Beat(startTime + gap * 56, "S"),
                    new Beat(startTime + gap * 58, "Space"),
                    new Beat(startTime + gap * 60, "L"),
                    new Beat(startTime + gap * 62, "S"),
                    new Beat(startTime + gap * 64, "L"),
                    new Beat(startTime + gap * 66, "L"),
                    new Beat(startTime + gap * 68, "F"),
                    new Beat(startTime + gap * 70, "Space"),
                    new Beat(startTime + gap * 72, "D"),
                    new Beat(startTime + gap * 74, "D"),
                    new Beat(startTime + gap * 76, "S"),
                    new Beat(startTime + gap * 78, "J"),
                    new Beat(startTime + gap * 80, "S"),
                    new Beat(startTime + gap * 82, "Space"),
                    new Beat(startTime + gap * 84, "L"),
                    new Beat(startTime + gap * 86, "J"),
                    new Beat(startTime + gap * 88, "K"),
                    new Beat(startTime + gap * 90, "L")
            };
        } else if (titleName.equalsIgnoreCase("information") && difficulty.equals("Hard")) {
            int startTime = 4460 - Note.REACH_TIME * 1000;
            int gap = 2000;
            beats = new Beat[]{
                    new Beat(startTime, "Space"),
                    new Beat(startTime + gap * 2, "Space"),
                    new Beat(startTime + gap * 4, "S"),
                    new Beat(startTime + gap * 6, "D"),
                    new Beat(startTime + gap * 8, "F"),
                    new Beat(startTime + gap * 10, "J"),
                    new Beat(startTime + gap * 12, "K"),
                    new Beat(startTime + gap * 14, "L"),
                    new Beat(startTime + gap * 16, "L"),
                    new Beat(startTime + gap * 18, "K"),
                    new Beat(startTime + gap * 20, "J"),
                    new Beat(startTime + gap * 22, "D"),
                    new Beat(startTime + gap * 24, "F"),
                    new Beat(startTime + gap * 26, "S"),
                    new Beat(startTime + gap * 28, "S"),
                    new Beat(startTime + gap * 30, "J"),
                    new Beat(startTime + gap * 32, "Space"),
                    new Beat(startTime + gap * 34, "S"),
                    new Beat(startTime + gap * 36, "K"),
                    new Beat(startTime + gap * 38, "S"),
                    new Beat(startTime + gap * 40, "L"),
                    new Beat(startTime + gap * 42, "L"),
                    new Beat(startTime + gap * 44, "F"),
                    new Beat(startTime + gap * 46, "Space"),
                    new Beat(startTime + gap * 48, "D"),
                    new Beat(startTime + gap * 50, "D"),
                    new Beat(startTime + gap * 52, "S"),
                    new Beat(startTime + gap * 54, "J"),
                    new Beat(startTime + gap * 56, "S"),
                    new Beat(startTime + gap * 58, "Space"),
                    new Beat(startTime + gap * 60, "L"),
                    new Beat(startTime + gap * 62, "S"),
                    new Beat(startTime + gap * 64, "L"),
                    new Beat(startTime + gap * 66, "L"),
                    new Beat(startTime + gap * 68, "F"),
                    new Beat(startTime + gap * 70, "Space"),
                    new Beat(startTime + gap * 72, "D"),
                    new Beat(startTime + gap * 74, "D"),
                    new Beat(startTime + gap * 76, "S"),
                    new Beat(startTime + gap * 78, "J"),
                    new Beat(startTime + gap * 80, "S"),
                    new Beat(startTime + gap * 82, "Space"),
                    new Beat(startTime + gap * 84, "L"),
                    new Beat(startTime + gap * 86, "J"),
                    new Beat(startTime + gap * 88, "K"),
                    new Beat(startTime + gap * 90, "L")
            };
        } else if (titleName.equalsIgnoreCase("sunset road") && difficulty.equals("Easy")) {
            int startTime = 1000 - Note.REACH_TIME * 1000;
            int gap = 2000;
            beats = new Beat[]{
                    new Beat(startTime, "Space"),
                    new Beat(startTime + gap * 2, "Space"),
                    new Beat(startTime + gap * 4, "S"),
                    new Beat(startTime + gap * 6, "D"),
                    new Beat(startTime + gap * 8, "F"),
                    new Beat(startTime + gap * 10, "J"),
                    new Beat(startTime + gap * 12, "K"),
                    new Beat(startTime + gap * 14, "L"),
                    new Beat(startTime + gap * 16, "L"),
                    new Beat(startTime + gap * 18, "K"),
                    new Beat(startTime + gap * 20, "J"),
                    new Beat(startTime + gap * 22, "D"),
                    new Beat(startTime + gap * 24, "F"),
                    new Beat(startTime + gap * 26, "S"),
                    new Beat(startTime + gap * 28, "S"),
                    new Beat(startTime + gap * 30, "J"),
                    new Beat(startTime + gap * 32, "Space"),
                    new Beat(startTime + gap * 34, "S"),
                    new Beat(startTime + gap * 36, "K"),
                    new Beat(startTime + gap * 38, "S"),
                    new Beat(startTime + gap * 40, "L"),
                    new Beat(startTime + gap * 42, "L"),
                    new Beat(startTime + gap * 44, "F"),
                    new Beat(startTime + gap * 46, "Space"),
                    new Beat(startTime + gap * 48, "D"),
                    new Beat(startTime + gap * 50, "D"),
                    new Beat(startTime + gap * 52, "S"),
                    new Beat(startTime + gap * 54, "J"),
                    new Beat(startTime + gap * 56, "S"),
                    new Beat(startTime + gap * 58, "Space"),
                    new Beat(startTime + gap * 60, "L"),
                    new Beat(startTime + gap * 62, "S"),
                    new Beat(startTime + gap * 64, "L"),
                    new Beat(startTime + gap * 66, "L"),
                    new Beat(startTime + gap * 68, "F"),
                    new Beat(startTime + gap * 70, "Space"),
                    new Beat(startTime + gap * 72, "D"),
                    new Beat(startTime + gap * 74, "D"),
                    new Beat(startTime + gap * 76, "S"),
                    new Beat(startTime + gap * 78, "J"),
                    new Beat(startTime + gap * 80, "S"),
                    new Beat(startTime + gap * 82, "Space"),
                    new Beat(startTime + gap * 84, "L"),
                    new Beat(startTime + gap * 86, "J"),
                    new Beat(startTime + gap * 88, "K"),
                    new Beat(startTime + gap * 90, "L"),
                    new Beat(startTime + gap * 92, "L"),
                    new Beat(startTime + gap * 94, "K"),
                    new Beat(startTime + gap * 96, "J"),
                    new Beat(startTime + gap * 98, "K"),
                    new Beat(startTime + gap * 100, "J"),
            };
        } else if (titleName.equalsIgnoreCase("sunset road") && difficulty.equals("Hard")) {
            int startTime = 1000 - Note.REACH_TIME * 1000;
            int gap = 2000;
            beats = new Beat[]{
                    new Beat(startTime, "Space"),
                    new Beat(startTime + gap * 2, "Space"),
                    new Beat(startTime + gap * 4, "S"),
                    new Beat(startTime + gap * 6, "D"),
                    new Beat(startTime + gap * 8, "F"),
                    new Beat(startTime + gap * 10, "J"),
                    new Beat(startTime + gap * 12, "K"),
                    new Beat(startTime + gap * 14, "L"),
                    new Beat(startTime + gap * 16, "L"),
                    new Beat(startTime + gap * 18, "K"),
                    new Beat(startTime + gap * 20, "J"),
                    new Beat(startTime + gap * 22, "D"),
                    new Beat(startTime + gap * 24, "F"),
                    new Beat(startTime + gap * 26, "S"),
                    new Beat(startTime + gap * 28, "S"),
                    new Beat(startTime + gap * 30, "J"),
                    new Beat(startTime + gap * 32, "Space"),
                    new Beat(startTime + gap * 34, "S"),
                    new Beat(startTime + gap * 36, "K"),
                    new Beat(startTime + gap * 38, "S"),
                    new Beat(startTime + gap * 40, "L"),
                    new Beat(startTime + gap * 42, "L"),
                    new Beat(startTime + gap * 44, "F"),
                    new Beat(startTime + gap * 46, "Space"),
                    new Beat(startTime + gap * 48, "D"),
                    new Beat(startTime + gap * 50, "D"),
                    new Beat(startTime + gap * 52, "S"),
                    new Beat(startTime + gap * 54, "J"),
                    new Beat(startTime + gap * 56, "S"),
                    new Beat(startTime + gap * 58, "Space"),
                    new Beat(startTime + gap * 60, "L"),
                    new Beat(startTime + gap * 62, "S"),
                    new Beat(startTime + gap * 64, "L"),
                    new Beat(startTime + gap * 66, "L"),
                    new Beat(startTime + gap * 68, "F"),
                    new Beat(startTime + gap * 70, "Space"),
                    new Beat(startTime + gap * 72, "D"),
                    new Beat(startTime + gap * 74, "D"),
                    new Beat(startTime + gap * 76, "S"),
                    new Beat(startTime + gap * 78, "J"),
                    new Beat(startTime + gap * 80, "S"),
                    new Beat(startTime + gap * 82, "Space"),
                    new Beat(startTime + gap * 84, "L"),
                    new Beat(startTime + gap * 86, "J"),
                    new Beat(startTime + gap * 88, "K"),
                    new Beat(startTime + gap * 90, "L"),
                    new Beat(startTime + gap * 92, "L"),
                    new Beat(startTime + gap * 94, "K"),
                    new Beat(startTime + gap * 96, "J"),
                    new Beat(startTime + gap * 98, "K"),
                    new Beat(startTime + gap * 100, "J"),
            };
        } else if (titleName.equalsIgnoreCase("tokyo cafe") && difficulty.equals("Easy")) {
            int startTime = 1000 - Note.REACH_TIME * 1000;
            int gap = 1500;
            beats = new Beat[]{
                    new Beat(startTime, "Space"),
                    new Beat(startTime + gap * 2, "Space"),
                    new Beat(startTime + gap * 4, "S"),
                    new Beat(startTime + gap * 6, "D"),
                    new Beat(startTime + gap * 8, "F"),
                    new Beat(startTime + gap * 10, "J"),
                    new Beat(startTime + gap * 12, "K"),
                    new Beat(startTime + gap * 14, "L"),
                    new Beat(startTime + gap * 16, "L"),
                    new Beat(startTime + gap * 18, "K"),
                    new Beat(startTime + gap * 20, "J"),
                    new Beat(startTime + gap * 22, "D"),
                    new Beat(startTime + gap * 24, "F"),
                    new Beat(startTime + gap * 26, "S"),
                    new Beat(startTime + gap * 28, "S"),
                    new Beat(startTime + gap * 30, "J"),
                    new Beat(startTime + gap * 32, "Space"),
                    new Beat(startTime + gap * 34, "S"),
                    new Beat(startTime + gap * 36, "K"),
                    new Beat(startTime + gap * 38, "S"),
                    new Beat(startTime + gap * 40, "L"),
                    new Beat(startTime + gap * 42, "L"),
                    new Beat(startTime + gap * 44, "F"),
                    new Beat(startTime + gap * 46, "Space"),
                    new Beat(startTime + gap * 48, "D"),
                    new Beat(startTime + gap * 50, "D"),
                    new Beat(startTime + gap * 52, "S"),
                    new Beat(startTime + gap * 54, "J"),
                    new Beat(startTime + gap * 56, "S"),
                    new Beat(startTime + gap * 58, "Space"),
                    new Beat(startTime + gap * 60, "L"),
                    new Beat(startTime + gap * 62, "S"),
                    new Beat(startTime + gap * 64, "L"),
                    new Beat(startTime + gap * 66, "L"),
                    new Beat(startTime + gap * 68, "F"),
                    new Beat(startTime + gap * 70, "Space"),
                    new Beat(startTime + gap * 72, "D"),
                    new Beat(startTime + gap * 74, "D"),
                    new Beat(startTime + gap * 76, "S"),
                    new Beat(startTime + gap * 78, "J"),
                    new Beat(startTime + gap * 80, "S"),
                    new Beat(startTime + gap * 82, "Space"),
                    new Beat(startTime + gap * 84, "L"),
                    new Beat(startTime + gap * 86, "J"),
                    new Beat(startTime + gap * 88, "K"),
                    new Beat(startTime + gap * 90, "L")
            };
        } else if (titleName.equalsIgnoreCase("tokyo cafe") && difficulty.equals("Hard")) {
            int startTime = 1000 - Note.REACH_TIME * 1000;
            int gap = 1500;
            beats = new Beat[]{
                    new Beat(startTime, "Space"),
                    new Beat(startTime + gap * 2, "Space"),
                    new Beat(startTime + gap * 4, "S"),
                    new Beat(startTime + gap * 6, "D"),
                    new Beat(startTime + gap * 8, "F"),
                    new Beat(startTime + gap * 10, "J"),
                    new Beat(startTime + gap * 12, "K"),
                    new Beat(startTime + gap * 14, "L"),
                    new Beat(startTime + gap * 16, "L"),
                    new Beat(startTime + gap * 18, "K"),
                    new Beat(startTime + gap * 20, "J"),
                    new Beat(startTime + gap * 22, "D"),
                    new Beat(startTime + gap * 24, "F"),
                    new Beat(startTime + gap * 26, "S"),
                    new Beat(startTime + gap * 28, "S"),
                    new Beat(startTime + gap * 30, "J"),
                    new Beat(startTime + gap * 32, "Space"),
                    new Beat(startTime + gap * 34, "S"),
                    new Beat(startTime + gap * 36, "K"),
                    new Beat(startTime + gap * 38, "S"),
                    new Beat(startTime + gap * 40, "L"),
                    new Beat(startTime + gap * 42, "L"),
                    new Beat(startTime + gap * 44, "F"),
                    new Beat(startTime + gap * 46, "Space"),
                    new Beat(startTime + gap * 48, "D"),
                    new Beat(startTime + gap * 50, "D"),
                    new Beat(startTime + gap * 52, "S"),
                    new Beat(startTime + gap * 54, "J"),
                    new Beat(startTime + gap * 56, "S"),
                    new Beat(startTime + gap * 58, "Space"),
                    new Beat(startTime + gap * 60, "L"),
                    new Beat(startTime + gap * 62, "S"),
                    new Beat(startTime + gap * 64, "L"),
                    new Beat(startTime + gap * 66, "L"),
                    new Beat(startTime + gap * 68, "F"),
                    new Beat(startTime + gap * 70, "Space"),
                    new Beat(startTime + gap * 72, "D"),
                    new Beat(startTime + gap * 74, "D"),
                    new Beat(startTime + gap * 76, "S"),
                    new Beat(startTime + gap * 78, "J"),
                    new Beat(startTime + gap * 80, "S"),
                    new Beat(startTime + gap * 82, "Space"),
                    new Beat(startTime + gap * 84, "L"),
                    new Beat(startTime + gap * 86, "J"),
                    new Beat(startTime + gap * 88, "K"),
                    new Beat(startTime + gap * 90, "L")
            };
        }
        int i = 0;
        gameMusic.start();
        while (i < beats.length && !isInterrupted()) {
            boolean dropped = false;
            if (beats[i].getTime() <= gameMusic.getTime()) {
                Note note = new Note(beats[i].getNoteName());
                note.start();
                noteList.add(note);
                i++;
            }
            if (!dropped) {
                try {
                    Thread.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void judge(String input) {
        for (int i = 0; i < noteList.size(); i++) {
            Note note = noteList.get(i);
            if (input.equals(note.getNoteType())) {
                note.judge();
                break;
            }
        }
    }
}
