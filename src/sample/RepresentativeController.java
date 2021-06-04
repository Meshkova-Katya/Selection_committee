package sample;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
            String parent = "";
            String guardian = "";
            if (comboBox2.getValue().equals("Родитель")) {
                parent = "Родитель";
            }
            if (comboBox2.getValue().equals("Опекун")) {
                guardian  = "Родитель";
            }
            String gender = "";
            if (group.getSelectedToggle().equals(male)) {
                gender = "Мужской";
            } else {
                gender = "Женский";
            }


            Representative representative2 = new Representative(name, pass_Id, pass_series, reg, phone, gender, guardian, parent);


            try {

                dbHandler.signUpRepresentative(representative2);


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
        button2.setOnAction(event -> signUpNewRepresentative());

    }
}
