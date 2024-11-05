package rhythm;

public class ScoreVO {
    private int scoreNo;
    private int memberNo;
    private int musicNo;
    private int scoreResult;
    private int combo;

    public ScoreVO() {
    }

    public ScoreVO(int scoreNo, int memberNo, int musicNo, int scoreResult, int combo) {
        this.scoreNo = scoreNo;
        this.memberNo = memberNo;
        this.musicNo = musicNo;
        this.scoreResult = scoreResult;
        this.combo = combo;
    }

    public int getScoreNo() {
        return scoreNo;
    }

    public void setScoreNo(int scoreNo) {
        this.scoreNo = scoreNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public int getMusicNo() {
        return musicNo;
    }

    public void setMusicNo(int musicNo) {
        this.musicNo = musicNo;
    }

    public int getScoreResult() {
        return scoreResult;
    }

    public void setScoreResult(int scoreResult) {
        this.scoreResult = scoreResult;
    }

    public int getCombo() {
        return combo;
    }

    public void setCombo(int combo) {
        this.combo = combo;
    }
}