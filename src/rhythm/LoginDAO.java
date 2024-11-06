package rhythm;

import java.util.ArrayList;

public interface LoginDAO{
    void setLoginID(String loginID);
    String getLoginID();
    void setLoginPW(String loginPW);
    int memberInsert(MemberVO vo);
    boolean loginStart();
    void scoreUpdate(int highScore, int highCombo, int trackNo, String difficulty);
    ArrayList<NoteVO> selectNote(int trackNo);
    ArrayList<Track> selectMusic();
}
