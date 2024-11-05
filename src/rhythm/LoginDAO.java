package rhythm;

public interface LoginDAO{
    String getLoginID();
    void setLoginID(String loginID);
    String getLoginPW();
    void setLoginPW(String loginPW);
    int memberInsert(MemberVO vo);
    boolean loginStart();
    int scoreUpdate(int highScore, int highCombo, String trackName);
}
