package rhythm;

public interface OracleQuery {
    public static final String URL =
            "jdbc:oracle:thin:@192.168.0.147:1521:xe"; // 접속할 오라클 DB 경로
    public static final String USER = "scott";
    public static final String PASSWORD = "tiger";
    public static final String MEMBER_TABLE = "MEMBER";
    public static final String TRACK_TABLE = "TRACK";
    public static final String NOTE_TABLE = "NOTE";
    public static final String SCORE_TABLE = "SCORE";
    public static final String COL_MEMBER_NO = "MEMBER_NO";
    public static final String COL_MEMBER_ID = "MEMBER_ID";
    public static final String COL_MEMBER_PW = "MEMBER_PW";
    public static final String COL_TRACK_NO = "TRACK_NO";
    public static final String COL_SCORE_NO = "SCORE_NO";
    public static final String COL_SCORE_RESULT = "SCORE_RESULT";
    public static final String COL_COMBO = "COMBO";
    public static final String COL_HIGH_SCORE = "HIGH_SCORE";
    public static final String COL_HIGH_COMBO = "HIGH_COMBO";
    public static final String COL_DIFFICULTY = "DIFFICULTY";
    public static final String insertMember = "INSERT INTO " + MEMBER_TABLE + " VALUES (MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?)";
    public static final String selectMember = "SELECT * FROM " + MEMBER_TABLE + " WHERE " + COL_MEMBER_ID + " = ? AND " + COL_MEMBER_PW + " = ?";
    public static final String updateScore = "MERGE INTO " + SCORE_TABLE +
            " USING DUAL ON (" + COL_MEMBER_NO + " = ? AND " + COL_TRACK_NO + " = ? AND " + COL_DIFFICULTY + " = ?) " +
            "WHEN MATCHED THEN " +
            "UPDATE SET " + COL_SCORE_RESULT + " = ?, " + COL_COMBO + " = ?, " +
            COL_HIGH_SCORE + " = CASE WHEN ? > " + COL_HIGH_SCORE + " THEN ? ELSE " + COL_HIGH_SCORE + " END, " +
            COL_HIGH_COMBO + " = CASE WHEN ? > " + COL_HIGH_COMBO + " THEN ? ELSE " + COL_HIGH_COMBO + " END " +
            "WHEN NOT MATCHED THEN " +
            "INSERT (" + COL_SCORE_NO + ", " + COL_MEMBER_NO + ", " + COL_TRACK_NO + ", " + COL_SCORE_RESULT + ", " +
            COL_COMBO + ", " + COL_HIGH_SCORE + ", " + COL_HIGH_COMBO + ", " + COL_DIFFICULTY + ") " +
            "VALUES (SCORE_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";

    public static final String selectNote = "SELECT * FROM " + NOTE_TABLE + " WHERE " + COL_TRACK_NO + " = ? AND " + COL_DIFFICULTY + " = ?";
    public static final String selectTrack = "SELECT * FROM " + TRACK_TABLE;
    public static final String selectScore = "SELECT * FROM " + SCORE_TABLE + " WHERE " + COL_MEMBER_NO +
            " = ? AND " + COL_TRACK_NO + " = ? AND " + COL_DIFFICULTY + " = ?";
}
