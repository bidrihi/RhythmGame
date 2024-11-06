package rhythm;

import javax.swing.*;
import java.awt.*;

public class ScoreResult extends Thread {
    private final Image scoreResult = new ImageIcon(getClass().getResource("../images/scoreResult.png")).getImage();
    Graphics2D g;

    public ScoreResult(Graphics2D g) {
        this.g = g;
    }

    public void screenDraw(Graphics2D g) {
        String grade = null;

        int totalScore = DynamicBeat.game.score;
        int totalCombo = DynamicBeat.game.combo;

        if (totalScore >= 40 * 50 * 0.9) {
            grade = "S";
        } else if (totalScore >= 40 * 50 * 0.6) {
            grade = "A";
        } else if (totalScore >= 40 * 50 * 0.4) {
            grade = "B";
        } else {
            grade = "C";
        }

        g.drawImage(scoreResult, 240, 70, null);

        g.setFont(new Font("Arial", Font.BOLD, 100));
        g.setColor(Color.white);
        g.drawString("Score : " + String.valueOf(totalScore), 350, 290);
        g.drawString("Combo : " + String.valueOf(totalCombo), 350, 400);

        g.setColor(Color.pink);
        g.drawString(grade, 600, 500);
    }

    @Override
    public void run() {
        screenDraw(g);
    }

    public void close() {
        interrupt();
    }
}
