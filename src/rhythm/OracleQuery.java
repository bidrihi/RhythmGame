package rhythm;

public interface OracleQuery {
    public static final String URL =
            "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 오라클 DB 경로
    public static final String USER = "scott";
    public static final String PASSWORD = "tiger";
    public static final String MEMBER_TABLE = "MEMBER";
    public static final String TRACK_TABLE = "TRACK";
    public static final String NOTE_TABLE = "NOTE";
    public static final String SCORE_TABLE = "SCORE";
    public static final String COL_MEMBER_NO = "MEMBER_NO";
    public static final String COL_MEMBER_ID = "MEMBER_ID";
    public static final String COL_MEMBER_PW = "MEMBER_PW";
    public static final String COL_MEMBER_NAME = "NAME";
    public static final String COL_MEMBER_EMAIL = "EMAIL";
    public static final String COL_TRACK_NAME = "TRACK_NAME";
    public static final String COL_TRACK_NO = "TRACK_NO";
    public static final String COL_SCORE_NO = "SCORE_NO";
    public static final String COL_SCORE_RESULT = "SCORE_RESULT";
    public static final String COL_COMBO = "COMBO";
    public static final String insertMember = "INSERT INTO " + MEMBER_TABLE + " VALUES (MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?)";
    public static final String selectMember = "SELECT * FROM " + MEMBER_TABLE + " WHERE " + COL_MEMBER_ID + " = ? AND " + COL_MEMBER_PW + " = ?";
    public static final String insertScore = "INSERT INTO " + SCORE_TABLE + " VALUES (SCORE_SEQ.NEXTVAL, ?, ?, ?)";
    public static final String updateScore = "UPDATE " + SCORE_TABLE + " SET " + COL_SCORE_RESULT + " = ?, "
            + COL_COMBO + " = ? WHERE " + COL_MEMBER_NO + " = ? AND " + COL_TRACK_NO + " = ?";
}
