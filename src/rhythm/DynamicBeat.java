package rhythm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DynamicBeat extends JFrame {
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;

    private Image screenImage;
    private Graphics screenGraphic;

    private final Image introBackground = new ImageIcon(Main.class.getResource("../images/introBackground(Title).jpg")).getImage();
    private final JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
    private final ImageIcon exitButtonEnterdImage = new ImageIcon(Main.class.getResource("../images/exit_entered.png"));
    private final ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exit.png"));
    private JButton exitButton = new JButton(exitButtonBasicImage);

    private int mouseX, mouseY;

    public DynamicBeat() {
        setUndecorated(true); // 기본 메뉴바 숨기고 바뀐 메뉴바로 변경
        setTitle("Dynamic Beat");
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setResizable(false); // 창 크기 변경 불가
        setLocationRelativeTo(null); // 실행시 화면 정중앙에 뜨도록 설정
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);

        exitButton.setBounds(1245, 0, 30, 30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonEnterdImage);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonBasicImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);

        menuBar.setBounds(0, 0, 1280, 30);
        menuBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });
        add(menuBar);

        Music introMusic = new Music("upbeat-reel.mp3", true);
        introMusic.start();
    }

    // paint 메서드는 JFrame 에서 상속받아서 화면을 그릴때 가장 먼저 실행되는 함수
    // 아래 순서대로 실행된다고 생각
    // 1. JFrame 를 실행하면 updated(Graphics g) 가 가장 먼저 실행
    // 2. 다음으로 paint(Graphics g) 가 실행
    // 3. 이때 paint 함수 안에서 repaint() 를 실행함으로써 paint() -> repaint() -> paint() 식으로 반복
    // 실행시켜보면 실제로 a -> c -> d -> b 순서로 반복됨
    // 이렇게 화면을 계속 띄워주는 이유는 한번만 화면을 띄워주게 되면 버퍼링 현상이 심해서 느려지는 문제가 있음
    // -> 이에 paint 와 repaint 를 통해 계속해서 introBackground 이미지를 띄워주게 됨
    // 이런 기법을 더블 버퍼링 기법 이라고 함 : 버퍼에 이미지를 담아서 계속해서 갱신해줌
    public void paint(Graphics g) {
        screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g) {
        g.drawImage(introBackground, 0, 0, null);
        paintComponents(g); // 이미지를 단순히 그려주는 것 이외에 JLabel 처럼 추가된 요소를 그리는 것
        this.repaint();
    }
}
