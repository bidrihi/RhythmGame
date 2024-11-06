package rhythm;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.ArrayList;

public class LoginDAOImple implements LoginDAO, OracleQuery {

    private String loginID;
    private String loginPW;
    private int getMemberNo;

    public String getLoginID() {
        return loginID;
    }
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
            System.out.println(loginID);
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
    public void scoreUpdate(int score, int combo, int trackNo, String difficulty) {
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(updateScore);
            /*
            merge into SCORE
            using DUAL
            on (MEMBER_NO = ? and TRACK_NO = ? and DIFFICULTY = ?)
            when matched then
                update
                set SCORE_RESULT = ?,
                    COMBO        = ?,
                    HIGH_SCORE   = case
                                       when ? > HIGH_SCORE then ?
                                       else HIGH_SCORE end,
                    HIGH_COMBO   = case
                                       when ? > HIGH_COMBO then ?
                                       else HIGH_COMBO end
            when not matched then
                insert (score_no, member_no, track_no, score_result, combo, high_score, high_combo, difficulty)
                VALUES (SCORE_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?);
            */

            pstmt.setInt(1, getMemberNo);
            pstmt.setInt(2, trackNo);
            pstmt.setString(3, difficulty);
            pstmt.setInt(4, score);
            pstmt.setInt(5, combo);
            pstmt.setInt(6, score);
            pstmt.setInt(7, score);
            pstmt.setInt(8, combo);
            pstmt.setInt(9, combo);
            pstmt.setInt(10, getMemberNo);
            pstmt.setInt(11, trackNo);
            pstmt.setInt(12, score);
            pstmt.setInt(13, combo);
            pstmt.setInt(14, score);
            pstmt.setInt(15, combo);
            pstmt.setString(16, difficulty);

            pstmt.executeUpdate();
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
    }

    @Override
    public ArrayList<NoteVO> selectNote(int trackNo) {
        ArrayList<NoteVO> list = new ArrayList<>();
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(selectNote);
            pstmt.setInt(1, trackNo);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int noteNo = rs.getInt(1);
                trackNo = rs.getInt(2);
                int noteTime = rs.getInt(3);
                String noteType = rs.getString(4);

                NoteVO vo = new NoteVO(noteNo, trackNo, noteTime, noteType);
                list.add(vo);
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
        return list;
    }

    @Override
    public ArrayList<Track> selectMusic() {
        ArrayList<Track> list = new ArrayList<>();
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            pstmt = conn.prepareStatement(selectTrack);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int trackNo = rs.getInt(1);
                String titleImage = rs.getString(3);
                String startImage = rs.getString(4);
                String gameImage = rs.getString(5);
                String startMusic = rs.getString(6);
                String gameMusic = rs.getString(6);
                String titleName = rs.getString(7);
                int trackTime = rs.getInt(8);

                Track vo = new Track(trackNo, titleImage, startImage, gameImage, startMusic, gameMusic, titleName, trackTime);
                list.add(vo);
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
        return list;
    }
}
