package sichuan.umbrella.chenmm.bean;

public class CourseData {
    private int cdaId;
    private int cdaCosId;
    private String cdaTitle;
    private String cdaUri;

    public CourseData(){}

    public CourseData(int cdaId, int cdaCosId, String cdaTitle, String cdaUri) {
        this.cdaId = cdaId;
        this.cdaCosId = cdaCosId;
        this.cdaTitle = cdaTitle;
        this.cdaUri = cdaUri;
    }

    public int getCdaId() {
        return cdaId;
    }

    public void setCdaId(int cdaId) {
        this.cdaId = cdaId;
    }

    public int getCdaCosId() {
        return cdaCosId;
    }

    public void setCdaCosId(int cdaCosId) {
        this.cdaCosId = cdaCosId;
    }

    public String getCdaTitle() {
        return cdaTitle;
    }

    public void setCdaTitle(String cdaTitle) {
        this.cdaTitle = cdaTitle;
    }

    public String getCdaUri() {
        return cdaUri;
    }

    public void setCdaUri(String cdaUri) {
        this.cdaUri = cdaUri;
    }

    @Override
    public String toString() {
        return "CourseData{" +
                "cdaId=" + cdaId +
                ", cdaCosId=" + cdaCosId +
                ", cdaTitle='" + cdaTitle + '\'' +
                ", cdaUri='" + cdaUri + '\'' +
                '}';
    }
}
