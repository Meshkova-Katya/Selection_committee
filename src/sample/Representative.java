package sample;

public class Representative {
    private String name_representative;
    private String telephone;
    private String registration;
    private String gender;
    private String guardian;
    private String passport_ID;
    private String passport_series;

    public Representative(String name, String pass_id, String pass_series, String reg, String phone, String gender, String guardian) {
        this.name_representative = name;
        this.telephone = phone;
        this.passport_ID = pass_id;
        this.registration = reg;
        this.gender = gender;
        this.guardian = guardian;
        this.passport_series = pass_series;
    }


    public String getName_representative() {
        return name_representative;
    }

    public void setName_representative(String name_representative) {
        this.name_representative = name_representative;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }




    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
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
}
