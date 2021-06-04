package sample;


import java.io.IOException;
import java.sql.SQLException;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class EnrolleeController {


    @FXML
    private TextField name_enrollee;

    @FXML
    private TextField admission_score;

    @FXML
    private TextField passport_ID;

    @FXML
    private TextField passport_series;

    @FXML
    private TextField registration;

    @FXML
    private Button button1;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup group;



    @FXML
    private ComboBox<?> comboBox;

    private void signUpNewEnrollee() {

        DatabaseHandler dbHandler = new DatabaseHandler();
        String admission = admission_score.getText().trim();
        String pass_Id = passport_ID.getText().trim();
        String pass_series = passport_series.getText().trim();
        String reg = registration.getText().trim();
        String name_enroll = name_enrollee.getText().trim();
        String name_specialty = "";
        if (comboBox.getValue().equals("Информационные системы и программирование")) {
            name_specialty = "Информационные системы и программирование";
        }
        if (comboBox.getValue().equals("Мехатроника и мобильная робототехника")) {
            name_specialty = "Мехатроника и мобильная робототехника";
        }
        if (comboBox.getValue().equals("Оператор станков с программным управлением")) {
            name_specialty = "Оператор станков с программным управлением";
        }
        if (!admission.equals("") && !pass_Id.equals("") && !pass_series.equals("") && !reg.equals("")) {

            String gender = "";
            if (group.getSelectedToggle().equals(male)) {
                gender = "Мужской";
            } else {
                gender = "Женский";
            }


            Enrollee enrollee = new Enrollee(admission, pass_Id, pass_series, reg,  name_specialty, name_enroll, gender);


            try {

                dbHandler.signUpEnrolle(enrollee);


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
        button1.setOnAction(event -> signUpNewEnrollee());


    }
}
