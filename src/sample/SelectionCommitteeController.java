package sample;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

public class SelectionCommitteeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {
        SelectionCommittee selectionCommittee = DatabaseHandler.COMMITTEE;
        float admission_score = Float.parseFloat((DatabaseHandler.ENROLLEE.getAdmission_score()));
        if (admission_score >= 2 && admission_score < 3) {
            DatabaseHandler.COMMITTEE.setEnrolled_or_not("Не зачислен");

        }
        if (admission_score >= 3 && admission_score <= 5) {
            DatabaseHandler.COMMITTEE.setEnrolled_or_not("Зачислен");
        }
        DatabaseHandler handler = new DatabaseHandler();
        try {
            handler.signUpCommittee(selectionCommittee);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
