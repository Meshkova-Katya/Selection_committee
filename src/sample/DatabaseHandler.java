package sample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static sample.Const.*;
import static sample.Const.PASSPORT_ID;
import static sample.Const.PASSPORT_SERIES;
import static sample.Const.REGISTRATION;
import static sample.ConstRepresentative.*;


public class DatabaseHandler  extends Configs{

    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost/selection_committee?serverTimezone=Europe/Moscow&useSSL=false";
        String userName = dbUser;
        String password = dbPass;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(url, userName, password);
        return dbConnection;
    }
    public void signUpEnrolle(Enrollee enrolle) throws SQLException {

        String insert = "INSERT INTO " + ENROLLEE + "( " + ADMISSION_SCORE + ", " + PASSPORT_ID + "," + PASSPORT_SERIES +
                ", " + REGISTRATION + ", " + NAME_SPECIALTY + ", " + NAME_ENROLLEE + ", " + USER_GENDER + ") " + "VALUES (?, ?, ?, ?, ?, ?, ?)";


        try {

            try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {

                prSt.setString(1, enrolle.getAdmission_score());
                prSt.setString(2, enrolle.getPassport_ID());
                prSt.setString(3, enrolle.getPassport_series());
                prSt.setString(4, enrolle.getRegistration());
                prSt.setString(5, enrolle.getName_specialty());
                prSt.setString(6, enrolle.getName_enrollee());
                prSt.setString(7, enrolle.getGender());

                // Добавляет в бд
                prSt.executeUpdate();

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void signUpRepresentative(Representative representative) throws SQLException {

        String insert = "INSERT INTO " + REPRESENTATIVE + "( " + NAME_REPRESENTATIVE + ", " + TELEPHONE + "," + REGISTRATION_REPRESENTATIVE +
                ", " + PARENT + ", " + PASSPORT_ID_REPRESENTATIVE + ", " + PASSPORT_SERIES_REPRESENTATIVE + ", " + GUARDIAN + ", " + REPRESENTATIVE_GENDER + ") " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            try (PreparedStatement prSt = getDbConnection().prepareStatement(insert)) {

                prSt.setString(1, representative.getName_representative());
                prSt.setString(2, representative.getTelephone());
                prSt.setString(3, representative.getRegistration());
                prSt.setString(4, representative.getGender());
                prSt.setString(5, representative.getParent());
                prSt.setString(6, representative.getGuardian());
                prSt.setString(7, representative.getPassport_ID());
                prSt.setString(7, representative.getPassport_series());


                // Добавляет в бд
                prSt.executeUpdate();


            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
