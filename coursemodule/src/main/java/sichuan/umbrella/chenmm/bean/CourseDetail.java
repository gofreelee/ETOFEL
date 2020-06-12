package sichuan.umbrella.chenmm.bean;

public class CourseDetail {
    private Integer cdtCosId;
    private String cdtTchUsername;
    private Integer cdtGrpId;
    private String cdtPortrait;
    private String cdtPlan;
    private String cdtPattern;
    private String cdtGuide;
    private String cdtImg;

    public CourseDetail() {
    }

    public boolean someValueNotNull(){
        if (getCdtCosId()==null||getCdtTchUsername()==null||getCdtGrpId()==null){
            return false;
        }else {
            return true;
        }
    }

    public CourseDetail(Integer cdtCosId, String cdtTchUsername, Integer cdtGrpId, String cdtPortrait, String cdtPlan, String cdtPattern, String cdtGuide,String cdtImg) {
        this.cdtCosId = cdtCosId;
        this.cdtTchUsername = cdtTchUsername;
        this.cdtGrpId = cdtGrpId;
        this.cdtPortrait = cdtPortrait;
        this.cdtPlan = cdtPlan;
        this.cdtPattern = cdtPattern;
        this.cdtGuide = cdtGuide;
        this.cdtImg = cdtImg;
    }

    public String getCdtImg() {
        return cdtImg;
    }

    public void setCdtImg(String cdtImg) {
        this.cdtImg = cdtImg;
    }

    public Integer getCdtCosId() {
        return cdtCosId;
    }

    public void setCdtCosId(Integer cdtCosId) {
        this.cdtCosId = cdtCosId;
    }

    public String getCdtTchUsername() {
        return cdtTchUsername;
    }

    public void setCdtTchUsername(String cdtTchUsername) {
        this.cdtTchUsername = cdtTchUsername;
    }

    public Integer getCdtGrpId() {
        return cdtGrpId;
    }

    public void setCdtGrpId(Integer cdtGrpId) {
        this.cdtGrpId = cdtGrpId;
    }

    public String getCdtPortrait() {
        return cdtPortrait;
    }

    public void setCdtPortrait(String cdtPortrait) {
        this.cdtPortrait = cdtPortrait;
    }

    public String getCdtPlan() {
        return cdtPlan;
    }

    public void setCdtPlan(String cdtPlan) {
        this.cdtPlan = cdtPlan;
    }

    public String getCdtPattern() {
        return cdtPattern;
    }

    public void setCdtPattern(String cdtPattern) {
        this.cdtPattern = cdtPattern;
    }

    public String getCdtGuide() {
        return cdtGuide;
    }

    public void setCdtGuide(String cdtGuide) {
        this.cdtGuide = cdtGuide;
    }

    @Override
    public String toString() {
        return "CourseDetail{" +
                "cdtCosId=" + cdtCosId +
                ", cdtTchUsername='" + cdtTchUsername + '\'' +
                ", cdtGrpId=" + cdtGrpId +
                ", cdtPortrait='" + cdtPortrait + '\'' +
                ", cdtPlan='" + cdtPlan + '\'' +
                ", cdtPattern='" + cdtPattern + '\'' +
                ", cdtGuide='" + cdtGuide + '\'' +
                ", cdtImg='" + cdtImg + '\'' +
                '}';
    }
}
