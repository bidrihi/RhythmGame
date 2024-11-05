package rhythm;

public class NoteVO {
    private int noteNo;
    private int trackNo;
    private int noteTime;
    private String noteType;

    public NoteVO() {
    }

    public NoteVO(int noteNo, int trackNo, int noteTime, String noteType) {
        this.noteNo = noteNo;
        this.trackNo = trackNo;
        this.noteTime = noteTime;
        this.noteType = noteType;
    }

    public int getNoteNo() {
        return noteNo;
    }

    public void setNoteNo(int noteNo) {
        this.noteNo = noteNo;
    }

    public int getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(int trackNo) {
        this.trackNo = trackNo;
    }

    public int getNoteTime() {
        return noteTime;
    }

    public void setNoteTime(int noteTime) {
        this.noteTime = noteTime;
    }

    public String getNoteType() {
        return noteType;
    }

    public void setNoteType(String noteType) {
        this.noteType = noteType;
    }
}
