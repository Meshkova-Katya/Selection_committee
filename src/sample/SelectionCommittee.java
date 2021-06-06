package sample;

public class SelectionCommittee {
    private String name_enrollee;
    private String name_representative;
    private String admission_score;
    private String enrolled_or_not;

    public SelectionCommittee(String name_enrollee, String name_representative, String admission_score, String enrolled_or_not) {
        this.name_enrollee = name_enrollee;
        this.name_representative = name_representative;
        this.admission_score = admission_score;
        this.enrolled_or_not = enrolled_or_not;
    }

    public SelectionCommittee() {

    }

    public String getName_enrollee() {
        return name_enrollee;
    }

    public void setName_enrollee(String name_enrollee) {
        this.name_enrollee = name_enrollee;
    }

    public String getName_representative() {
        return name_representative;
    }

    public void setName_representative(String name_representative) {
        this.name_representative = name_representative;
    }

    public String getAdmission_score() {
        return admission_score;
    }

    public void setAdmission_score(String admission_score) {
        this.admission_score = admission_score;
    }

    public String getEnrolled_or_not() {
        return enrolled_or_not;
    }

    public void setEnrolled_or_not(String enrolled_or_not) {
        this.enrolled_or_not = enrolled_or_not;
    }
}
