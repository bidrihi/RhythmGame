package rhythm;

public interface LoginDAO{
    void setLoginID(String loginID);
    void setLoginPW(String loginPW);
    int memberInsert(MemberVO vo);
    boolean loginStart();
    int scoreUpdate(int highScore, int highCombo, String trackName);
    NoteVO selectNote(int trackNo);
}
