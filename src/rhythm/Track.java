package rhythm;

public class Track {
    private int trackNo;
    private String titleImage; // 제목부문 이미지
    private String startImage; // 게임 선택창 이미지
    private String gameImage; // 해당 곡 실행했을떼 표지 이미지
    private String startMusic; // 게임 선택창 음악
    private String gameMusic; // 해당 곡을 실행 했을 때 음악
    private String titleName; // 곡 제목
    private int trackTime;

    public Track() {
    }

    public Track(int trackNo, String titleImage, String startImage, String gameImage, String startMusic, String gameMusic, String titleName, int trackTime) {
        this.trackNo = trackNo;
        this.titleImage = titleImage;
        this.startImage = startImage;
        this.gameImage = gameImage;
        this.startMusic = startMusic;
        this.gameMusic = gameMusic;
        this.titleName = titleName;
        this.trackTime = trackTime;
    }

    public int getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(int trackNo) {
        this.trackNo = trackNo;
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

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int getTrackTime() {
        return trackTime;
    }

    public void setTrackTime(int trackTime) {
        this.trackTime = trackTime;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackNo=" + trackNo +
                ", titleImage='" + titleImage + '\'' +
                ", startImage='" + startImage + '\'' +
                ", gameImage='" + gameImage + '\'' +
                ", startMusic='" + startMusic + '\'' +
                ", gameMusic='" + gameMusic + '\'' +
                ", titleName='" + titleName + '\'' +
                ", trackTime=" + trackTime +
                '}';
    }
}
