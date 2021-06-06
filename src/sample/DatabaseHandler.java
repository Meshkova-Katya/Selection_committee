package sample;

import java.sql.*;

import static sample.Const.*;

import static sample.ConstRepresentative.*;
import static sample.ConstSelectionCommittee.ENROLLED_OR_NOT;
import static sample.ConstSelectionCommittee.SELECTION_COMMITTEE;
import static sample.ConstStudent.*;
import static sample.ConstStudent.NAME_SPECIALTY;


public class DatabaseHandler extends Configs {

    Connection dbConnection;
    public static Enrollee ENROLLEE;
    public static SelectionCommittee COMMITTEE;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost/selection_committee?serverTimezone=Europe/Moscow&useSSL=false";
        String userName = dbUser;
        String password = dbPass;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(url, userName, password);
        return dbConnection;
    }

    public void signUpEnrolle(Enrollee enrolle) throws SQLException {

        String insert = "INSERT INTO " + Const.ENROLLEE + "( " + ADMISSION_SCORE + ", " + PASSPORT_ID + "," + PASSPORT_SERIES +
                ", " + REGISTRATION + ", " + NAME_SPECIALTY + ", " + NAME_ENROLLEE + ", " + USER_GENDER + ") " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        ENROLLEE = enrolle;
        try {

            try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {

                prSt.setString(1, enrolle.getAdmission_score());
                prSt.setString(2, enrolle.getPassport_ID());
                prSt.setString(3, enrolle.getPassport_series());
                prSt.setString(4, enrolle.getRegistration());
                prSt.setString(5, enrolle.getName_specialty());
                prSt.setString(6, enrolle.getName_enrollee());
                prSt.setString(7, enrolle.getGender());
                System.out.println(prSt);
                System.out.println(insert);
                // Добавляет в бд
                prSt.executeUpdate();

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void signUpRepresentative(Representative representative) throws SQLException {

        String insert = "INSERT INTO " + REPRESENTATIVE + "( " + NAME_REPRESENTATIVE + ", " + TELEPHONE + "," + REGISTRATION_REPRESENTATIVE +
                ", " + PASSPORT_ID_REPRESENTATIVE + ", " + PASSPORT_SERIES_REPRESENTATIVE + ", " + GUARDIAN + ", " + REPRESENTATIVE_GENDER + ") " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {

                prSt.setString(1, representative.getName_representative());
                prSt.setString(2, representative.getTelephone());
                prSt.setString(3, representative.getRegistration());
                prSt.setString(4, representative.getPassport_ID());
                prSt.setString(5, representative.getPassport_series());
                prSt.setString(6, representative.getGuardian());
                prSt.setString(7, representative.getGender());
                System.out.println(insert);
                System.out.println(prSt);
                // Добавляет в бд
                prSt.executeUpdate();


            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void signUpStudent(String name, String sprcialty) throws SQLException {

        String insert = "INSERT INTO " + STUDENT + "( " + NAME_STUDENT + "," + NAME_SPECIALTY + ") " + "VALUES (?, ?)";

        try {

            try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {

                prSt.setString(1, name);
                prSt.setString(2, sprcialty);
                System.out.println(prSt);
                // Добавляет в бд
                prSt.executeUpdate();


            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void signUpCommittee(SelectionCommittee selection_committee) throws SQLException {

        String insert = "INSERT INTO " + ConstSelectionCommittee.SELECTION_COMMITTEE + "( " + NAME_ENROLLEE + ", " +
                NAME_REPRESENTATIVE + ", " + ADMISSION_SCORE + ", " +
                ENROLLED_OR_NOT + ") " + "VALUES (?, ?, ?, ?)";
        COMMITTEE = selection_committee;

        try {

            try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {

                prSt.setString(1, selection_committee.getName_enrollee());
                prSt.setString(2, selection_committee.getName_representative());
                prSt.setString(3, selection_committee.getAdmission_score());
                prSt.setString(4, selection_committee.getEnrolled_or_not());
                System.out.println(prSt);
                // Добавляет в бд
                prSt.executeUpdate();


            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
