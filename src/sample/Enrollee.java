package sample;

public class Enrollee {
    private String admission_score;
    private String passport_ID;
    private String passport_series;
    private String registration;
    private String name_specialty;
    private String name_enrollee;
    private String gender;

    public Enrollee(String admission_score, String passport_ID, String passport_series, String registration, String name_specialty, String name_enrollee, String gender) {
        this.admission_score = admission_score;
        this.passport_ID = passport_ID;
        this.passport_series = passport_series;
        this.registration = registration;
        this.name_specialty = name_specialty;
        this.name_enrollee = name_enrollee;
        this.gender = gender;
    }

    public Enrollee() {
    }

    public String getAdmission_score() {
        return admission_score;
    }

    public void setAdmission_score(String admission_score) {
        this.admission_score = admission_score;
    }

    public String getPassport_ID() {
        return passport_ID;
    }

    public void setPassport_ID(String passport_ID) {
        this.passport_ID = passport_ID;
    }

    public String getPassport_series() {
        return passport_series;
    }

    public void setPassport_series(String passport_series) {
        this.passport_series = passport_series;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getName_specialty() {
        return name_specialty;
    }

    public void setName_specialty(String name_specialty) {
        this.name_specialty = name_specialty;
    }

    public String getName_enrollee() {
        return name_enrollee;
    }

    public void setName_enrollee(String name_enrollee) {
        this.name_enrollee = name_enrollee;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }




}
