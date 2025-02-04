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
    private Image blueFlareImage;
    private Image judgeImage;
    private Image keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    private Image keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    private Image keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    private Image keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    private Image keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    private Image keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

    private String titleName;
    private int trackNo;
    private String difficulty;
    private String musicTitle;
    private Music gameMusic;

    ArrayList<Note> noteList = new ArrayList<>();


    int score = 0;
    int highScore = 0;
    int combo = 0;
    int highCombo = 0;
    private Image comboImage = new ImageIcon(Main.class.getResource("../images/combo.png")).getImage();

    //LoginDAO loginDAO;

    public Game(String titleName, int trackNo, String difficulty, String musicTitle) {
        this.titleName = titleName;
        this.trackNo = trackNo;
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
            if (note.getY() > 620) {
                judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
                score -= 10;
                combo = 0;
            }
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

        if (highScore < score) highScore = score;
        if (highCombo < combo) highCombo = combo;

        if (score < 0) {
            g.drawString(String.valueOf(0), 600, 702);
        } else g.drawString(String.valueOf(score), 600, 702);
        g.drawString(String.valueOf(highScore), 800, 702);

        g.drawImage(comboImage, 1070, 150, null);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(combo), 1150, 270);
        g.drawString(String.valueOf(highCombo), 1150, 350);

        g.setFont(new Font("Arial", Font.PLAIN, 26));
        g.setColor(Color.DARK_GRAY);
        g.drawString("S", 270, 609);
        g.drawString("D", 374, 609);
        g.drawString("F", 478, 609);
        g.drawString("Space Bar", 580, 609);
        g.drawString("J", 784, 609);
        g.drawString("K", 889, 609);
        g.drawString("L", 993, 609);
        g.drawImage(judgeImage, 450, 420, null);
        g.drawImage(blueFlareImage, 240, 270, null);
        g.drawImage(keyPadSImage, 228, 580, null);
        g.drawImage(keyPadDImage, 332, 580, null);
        g.drawImage(keyPadFImage, 436, 580, null);
        g.drawImage(keyPadSpace1Image, 540, 580, null);
        g.drawImage(keyPadSpace2Image, 640, 580, null);
        g.drawImage(keyPadJImage, 744, 580, null);
        g.drawImage(keyPadKImage, 848, 580, null);
        g.drawImage(keyPadLImage, 952, 580, null);
    }

    public void pressS() {
        judge("S");
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("snare1.mp3", false).start();
    }

    public void releaseS() {
        noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }

    public void pressD() {
        judge("D");
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("snare1.mp3", false).start();
    }

    public void releaseD() {
        noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }

    public void pressF() {
        judge("F");
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("snare1.mp3", false).start();
    }

    public void releaseF() {
        noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }

    public void pressSpace() {
        judge("Space");
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("tom1.mp3", false).start();
    }

    public void releaseSpace() {
        noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
        keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }

    public void pressJ() {
        judge("J");
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("snare1.mp3", false).start();
    }

    public void releaseJ() {
        noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }

    public void pressK() {
        judge("K");
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("snare1.mp3", false).start();
    }

    public void releaseK() {
        noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
    }

    public void pressL() {
        judge("L");
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
        keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
        new Music("snare1.mp3", false).start();
    }

    public void releaseL() {
        noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
        keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
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
        /*
        ArrayList<NoteVO> list;
        if (trackNo == 1 && difficulty.equals("Easy")) {
            list = loginDAO.selectNote(trackNo, difficulty);
            beats = new Beat[list.size()];
            for (int i = 0; i < list.size(); i++) {
                beats[i] = new Beat(list.get(i).getNoteTime(), list.get(i).getNoteType());
            }
        } else if (trackNo == 1 && difficulty.equals("Hard")) {
            list = loginDAO.selectNote(trackNo, difficulty);
            beats = new Beat[list.size()];
            for (int i = 0; i < list.size(); i++) {
                beats[i] = new Beat(list.get(i).getNoteTime(), list.get(i).getNoteType());
            }
        } else if (trackNo == 2 && difficulty.equals("Easy")) {
            list = loginDAO.selectNote(trackNo, difficulty);
            beats = new Beat[list.size()];
            for (int i = 0; i < list.size(); i++) {
                beats[i] = new Beat(list.get(i).getNoteTime(), list.get(i).getNoteType());
            }
        } else if (trackNo == 2 && difficulty.equals("Hard")) {
            list = loginDAO.selectNote(trackNo, difficulty);
            beats = new Beat[list.size()];
            for (int i = 0; i < list.size(); i++) {
                beats[i] = new Beat(list.get(i).getNoteTime(), list.get(i).getNoteType());
            }
        } else if (trackNo == 3 && difficulty.equals("Easy")) {
            list = loginDAO.selectNote(trackNo, difficulty);
            beats = new Beat[list.size()];
            for (int i = 0; i < list.size(); i++) {
                beats[i] = new Beat(list.get(i).getNoteTime(), list.get(i).getNoteType());
            }
        } else if (trackNo == 3 && difficulty.equals("Hard")) {
            list = loginDAO.selectNote(trackNo, difficulty);
            beats = new Beat[list.size()];
            for (int i = 0; i < list.size(); i++) {
                beats[i] = new Beat(list.get(i).getNoteTime(), list.get(i).getNoteType());
            }
        }
        */

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
                dropped = true;
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
                judgeEvent(note.judge());
                break;
            }
        }
    }

    public void judgeEvent(String judge) {
        if (!judge.equals("None")) {
            blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
        }
        if (judge.equals("Miss")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
            score -= 10;
            combo = 0;
        } else if (judge.equals("Late")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
            score += 5;
            combo++;
        } else if (judge.equals("Good")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
            score += 20;
            combo++;
        } else if (judge.equals("Great")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
            score += 30;
            combo++;
        } else if (judge.equals("Perfect")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
            score += 50;
            combo++;
        } else if (judge.equals("Early")) {
            judgeImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
            score += 5;
            combo++;
        }
    }
}