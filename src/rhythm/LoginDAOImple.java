package rhythm;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

public class LoginDAOImple implements LoginDAO, OracleQuery {

    private String loginID;
    private String loginPW;
    private int getMemberNo;

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public void setLoginPW(String loginPW) {
        this.loginPW = loginPW;
    }

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public LoginDAOImple() {
    }

    @Override
    public int memberInsert(MemberVO vo) {
        int result = 0;
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(insertMember);

            pstmt.setString(1, vo.getMemberId());
            pstmt.setString(2, vo.getMemberPw());
            pstmt.setString(3, vo.getName());
            pstmt.setString(4, vo.getEmail());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public boolean loginStart() {
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(selectMember);

            pstmt.setString(1, loginID);
            pstmt.setString(2, loginPW);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                getMemberNo = rs.getInt("MEMBER_NO");
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int scoreUpdate(int highScore, int highCombo, String trackName) {
        int result = 0;
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(updateScore);

            if (trackName.equalsIgnoreCase("information")) {
                pstmt.setInt(1, highScore);
                pstmt.setInt(2, highCombo);
                pstmt.setInt(3, getMemberNo);
                pstmt.setInt(4, 1);

                result = pstmt.executeUpdate();

                if (result == 0) {
                    pstmt = conn.prepareStatement(insertScore);
                    pstmt.setInt(1, getMemberNo);
                    pstmt.setInt(2, 1);
                    pstmt.setInt(3, highScore);
                    pstmt.setInt(4, highCombo);
                }
            } else if (trackName.equalsIgnoreCase("sunset road")) {
                pstmt.setInt(1, highScore);
                pstmt.setInt(2, highCombo);
                pstmt.setInt(3, getMemberNo);
                pstmt.setInt(4, 2);

                result = pstmt.executeUpdate();

                if (result == 0) {
                    pstmt = conn.prepareStatement(insertScore);
                    pstmt.setInt(1, getMemberNo);
                    pstmt.setInt(2, 2);
                    pstmt.setInt(3, highScore);
                    pstmt.setInt(4, highCombo);
                }
            } else if (trackName.equalsIgnoreCase("tokyo cafe")) {
                pstmt.setInt(1, highScore);
                pstmt.setInt(2, highCombo);
                pstmt.setInt(3, getMemberNo);
                pstmt.setInt(4, 3);

                result = pstmt.executeUpdate();

                if (result == 0) {
                    pstmt = conn.prepareStatement(insertScore);
                    pstmt.setInt(1, getMemberNo);
                    pstmt.setInt(2, 3);
                    pstmt.setInt(3, highScore);
                    pstmt.setInt(4, highCombo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public NoteVO selectNote(int trackNo) {
        return null;
    }
}
