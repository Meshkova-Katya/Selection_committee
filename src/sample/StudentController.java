package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StudentController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField score;

    @FXML
    private TextField specialty;

    @FXML
    private TextField numberBook;


    @FXML
    void initialize() {

        Enrollee enrollee = DatabaseHandler.ENROLLEE;
        float admission_score = Float.parseFloat((DatabaseHandler.ENROLLEE.getAdmission_score()));

        if (admission_score >= 2 && admission_score < 3) {
            return;
        }
        if (admission_score >= 3 && admission_score < 4) {
            score.setText(String.valueOf(admission_score));
            specialty.setText("Оператор станков с программным управлением");
            numberBook.setText("" + generate());

        }
        if (admission_score >= 4 && admission_score <= 5) {
            score.setText(String.valueOf(admission_score));
            specialty.setText(DatabaseHandler.ENROLLEE.getName_specialty());
            numberBook.setText("" + generate());

        }
        DatabaseHandler handler = new DatabaseHandler();
        try {
            handler.signUpStudent(enrollee.getName_enrollee(), enrollee.getName_specialty());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }


    public int generate() {
        int a = 1;
        int b = 1000;
        int random_number = a + (int) (Math.random() * b);
        return random_number;
    }
}
