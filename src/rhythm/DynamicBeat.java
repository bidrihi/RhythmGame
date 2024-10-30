package rhythm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class DynamicBeat extends JFrame {
    public static final int SCREEN_WIDTH = 1280;
    public static final int SCREEN_HEIGHT = 720;

    private Image screenImage;
    private Graphics screenGraphic;

    private Image background = new ImageIcon(Main.class.getResource("../images/introBackground(Title).jpg")).getImage();

    private final JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
    private final ImageIcon exitButtonEnterdImage = new ImageIcon(Main.class.getResource("../images/exit_entered.png"));
    private final ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exit.png"));
    private JButton exitButton = new JButton(exitButtonBasicImage);

    private ImageIcon startButtonEnterdImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
    private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
    private ImageIcon quitButtonEnterdImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
    private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
    private JButton startButton = new JButton(startButtonBasicImage);
    private JButton quitButton = new JButton(quitButtonBasicImage);

    private ImageIcon leftEnterdImage = new ImageIcon(Main.class.getResource("../images/leftEntered.png"));
    private ImageIcon leftBasicImage = new ImageIcon(Main.class.getResource("../images/leftBasic.png"));
    private ImageIcon rightEnterdImage = new ImageIcon(Main.class.getResource("../images/rightEntered.png"));
    private ImageIcon rightBasicImage = new ImageIcon(Main.class.getResource("../images/rightBasic.png"));
    private JButton leftButton = new JButton(leftBasicImage);
    private JButton rightButton = new JButton(rightBasicImage);

    private ImageIcon easyEnterdImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
    private ImageIcon easyBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
    private ImageIcon hardEnterdImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
    private ImageIcon hardBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
    private JButton easyButton = new JButton(easyBasicImage);
    private JButton hardButton = new JButton(hardBasicImage);

    private int mouseX, mouseY;

    private boolean isMainScreen = false;

    ArrayList<Track> tracklist = new ArrayList<>();
    private Image selectedImage;
    private Image titleImage;
    private Music selectedMusic;
    private int nowSelected = 0;

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

        Music introMusic = new Music("upbeat-reel.mp3", true);
        introMusic.start();

        tracklist.add(new Track("information title.png", "information.png",
                "information ingame.png", "information selected.mp3", "information.mp3"));
        tracklist.add(new Track("sunset road title.png", "sunset road.png",
                "sunset road ingame.png", "sunset road selected.mp3", "sunset road.mp3"));
        tracklist.add(new Track("tokyo cafe title.png", "tokyo cafe.png",
                "tokyo cafe ingame.png", "tokyo cafe selected.mp3", "tokyo cafe.mp3"));

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

        startButton.setBounds(850, 490, 400, 100);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startButtonEnterdImage);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButtonBasicImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // 게임 시작 이벤트 -> 나중에 로그인 창 띄우고 확인된 후에 넘어가도록 바꿔보기
                introMusic.close();
                selectTrack(0);
                startButton.setVisible(false);
                quitButton.setVisible(false);
                leftButton.setVisible(true);
                rightButton.setVisible(true);
                easyButton.setVisible(true);
                hardButton.setVisible(true);
                background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
                isMainScreen = true;
            }
        });
        add(startButton);

        quitButton.setBounds(850, 600, 400, 100);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusPainted(false);
        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                quitButton.setIcon(quitButtonEnterdImage);
                quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                quitButton.setIcon(quitButtonBasicImage);
                quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        add(quitButton);

        leftButton.setVisible(false);
        leftButton.setBounds(140, 310, 60, 60);
        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setFocusPainted(false);
        leftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                leftButton.setIcon(leftEnterdImage);
                leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                leftButton.setIcon(leftBasicImage);
                leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectLeft();
            }
        });
        add(leftButton);

        rightButton.setVisible(false);
        rightButton.setBounds(1080, 310, 60, 60);
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setFocusPainted(false);
        rightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                rightButton.setIcon(rightEnterdImage);
                rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                rightButton.setIcon(rightBasicImage);
                rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                selectRight();
            }
        });
        add(rightButton);

        easyButton.setVisible(false);
        easyButton.setBounds(375, 80, 250, 67);
        easyButton.setBorderPainted(false);
        easyButton.setContentAreaFilled(false);
        easyButton.setFocusPainted(false);
        easyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                easyButton.setIcon(easyEnterdImage);
                easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                easyButton.setIcon(easyBasicImage);
                easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //난이도 쉬움 이벤트
                gameStart(nowSelected, "easy");
            }
        });
        add(easyButton);

        hardButton.setVisible(false);
        hardButton.setBounds(655, 80, 250, 67);
        hardButton.setBorderPainted(false);
        hardButton.setContentAreaFilled(false);
        hardButton.setFocusPainted(false);
        hardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hardButton.setIcon(hardEnterdImage);
                hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hardButton.setIcon(hardBasicImage);
                hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //난이도 어려움 이벤트
                gameStart(nowSelected, "hard");
            }
        });
        add(hardButton);

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
    }

    // paint 메서드는 JFrame 에서 상속받아서 화면을 그릴때 가장 먼저 실행되는 함수
    // 아래 순서대로 실행된다고 생각
    // 1. JFrame 를 실행하면 updated(Graphics g) 가 가장 먼저 실행
    // 2. 다음으로 paint(Graphics g) 가 실행
    // 3. 이때 paint 함수 안에서 repaint() 를 실행함으로써 paint() -> repaint() -> paint() 식으로 반복
    // 실행시켜보면 실제로 a -> c -> d -> b 순서로 반복됨
    // 이렇게 화면을 계속 띄워주는 이유는 한번만 화면을 띄워주게 되면 버퍼링 현상이 심해서 느려지는 문제가 있음
    // -> 이에 paint 와 repaint 를 통해 계속해서 background 이미지를 띄워주게 됨
    // 이런 기법을 더블 버퍼링 기법 이라고 함 : 버퍼에 이미지를 담아서 계속해서 갱신해줌
    public void paint(Graphics g) {
        screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
        screenGraphic = screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage, 0, 0, null);
    }

    public void screenDraw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        if (isMainScreen) {
            g.drawImage(selectedImage, 340, 100, null);
            g.drawImage(titleImage, 340, 550, null);
        }
        paintComponents(g); // 이미지를 단순히 그려주는 것 이외에 JLabel 처럼 추가된 요소를 그리는 것
        this.repaint();
    }

    public void selectTrack(int nowSelected) {
        if (selectedMusic != null) {
            selectedMusic.close();
        }
        titleImage = new ImageIcon(Main.class.getResource("../images/" + tracklist.get(nowSelected).getTitleImage())).getImage();
        selectedImage = new ImageIcon(Main.class.getResource("../images/" + tracklist.get(nowSelected).getStartImage())).getImage();
        selectedMusic = new Music(tracklist.get(nowSelected).getStartMusic(), true);
        selectedMusic.start();
    }

    public void selectLeft() {
        if (nowSelected == 0) {
            nowSelected = tracklist.size() - 1;
        } else {
            nowSelected--;
        }
        selectTrack(nowSelected);
    }

    public void selectRight() {
        if (nowSelected == tracklist.size() - 1) {
            nowSelected = 0;
        } else {
            nowSelected++;
        }
        selectTrack(nowSelected);
    }

    public void gameStart(int nowSelected, String difficulty) {
        if (selectedMusic != null) {
            selectedMusic.close();
        }
        isMainScreen = false;
        leftButton.setVisible(false);
        rightButton.setVisible(false);
        easyButton.setVisible(false);
        hardButton.setVisible(false);
        background = new ImageIcon(Main.class.getResource("../images/" + tracklist.get(nowSelected).getGameImage())).getImage();
    }
}
