package rhythm;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Music extends Thread {
    private Player player;
    private boolean isLoop; // 현재 곡이 무한 반복중인지
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    public Music(String name, boolean isLoop) {
        try {
            this.isLoop = isLoop;
            file = new File(Main.class.getResource("../music/" + name).toURI());
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getTime() {
        if (player == null) return 0;
        return player.getPosition();
    }

    public void close() {
        isLoop = false;
        player.close();
        this.interrupt(); // 해당 쓰레드를 중지 상태로 만듦
    }

    @Override
    public void run() {
        try {
            do {
                player.play();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            } while (isLoop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
