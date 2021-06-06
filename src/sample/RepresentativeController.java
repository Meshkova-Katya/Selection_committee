package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RepresentativeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name_representative;

    @FXML
    private TextField passport_ID;

    @FXML
    private TextField passport_series;

    @FXML
    private TextField registration;

    @FXML
    private Button button2;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup group;

    @FXML
    private RadioButton female;

    @FXML
    private TextField telephone;

    @FXML
    private ComboBox<?> comboBox2;

    private void signUpNewRepresentative() {

        DatabaseHandler dbHandler = new DatabaseHandler();
        String name = name_representative.getText().trim();

        String pass_Id = passport_ID.getText().trim();
        String pass_series = passport_series.getText().trim();
        String reg = registration.getText().trim();
        String phone = telephone.getText().trim();
        if (!name.equals("") && !pass_Id.equals("") && !pass_series.equals("") && !reg.equals("") && !phone.equals("")) {

            String guardian = "";
            if (comboBox2.getValue().equals("Родитель")) {
                guardian = "Родитель";
            }
            if (comboBox2.getValue().equals("Опекун")) {
                guardian = "Родитель";
            }
            String gender = "";
            if (group.getSelectedToggle().equals(male)) {
                gender = "Мужской";
            } else {
                gender = "Женский";
            }

            Representative representative2 = new Representative(name, pass_Id, pass_series, reg, phone, gender, guardian);


            try {

                dbHandler.signUpRepresentative(representative2);

                SelectionCommittee committee = new SelectionCommittee();
                committee.setName_enrollee(DatabaseHandler.ENROLLEE.getName_enrollee());
                committee.setAdmission_score(DatabaseHandler.ENROLLEE.getAdmission_score());
                committee.setName_representative(representative2.getName_representative());

                float admission_score = Float.parseFloat((DatabaseHandler.ENROLLEE.getAdmission_score()));
                if (admission_score >= 2 && admission_score < 3) {
                    committee.setEnrolled_or_not("Не зачислен");

                }
                if (admission_score >= 3 && admission_score <= 5) {
                    committee.setEnrolled_or_not("Зачислен");
                }


                dbHandler.signUpCommittee(committee);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            String str = "Заполните все поля!";
            System.out.println(str);
        }

    }


    @FXML
    void initialize() {

        Enrollee enrollee = DatabaseHandler.ENROLLEE;
        button2.setOnAction(event -> {
            signUpNewRepresentative();
            float score = Float.parseFloat(DatabaseHandler.ENROLLEE.getAdmission_score().replaceAll(",", "\\."));
            if (score < 3) {
                String str = "SelectionСommittee.fxml";
                finishWindow(str);
            }
            if (score > 3) {
                String str = "Student.fxml";
                finishWindow(str);
            }

        });


    }

    private void finishWindow(String str) {
        button2.getScene().getWindow().hide(); // закрытие текущего окна


        FXMLLoader loader = new FXMLLoader();
        System.out.println(getClass().getResource(str));
        loader.setLocation(getClass().getResource(str));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 600, 600));
        stage.showAndWait(); // чтобы подождал


    }


}
