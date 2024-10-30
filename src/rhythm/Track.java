package rhythm;

public class Track {
    private String titleImage; // 제목부문 이미지
    private String startImage; // 게임 선택창 이미지
    private String gameImage; // 해당 곡 실행했을떼 표지 이미지
    private String startMusic; // 게임 선택창 음악
    private String gameMusic;// 해당 곡을 실행 했을 때 음악

    public Track() {
    }

    public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic) {
        this.titleImage = titleImage;
        this.startImage = startImage;
        this.gameImage = gameImage;
        this.startMusic = startMusic;
        this.gameMusic = gameMusic;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public String getStartImage() {
        return startImage;
    }

    public void setStartImage(String startImage) {
        this.startImage = startImage;
    }

    public String getGameImage() {
        return gameImage;
    }

    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }

    public String getStartMusic() {
        return startMusic;
    }

    public void setStartMusic(String startMusic) {
        this.startMusic = startMusic;
    }

    public String getGameMusic() {
        return gameMusic;
    }

    public void setGameMusic(String gameMusic) {
        this.gameMusic = gameMusic;
    }
}
