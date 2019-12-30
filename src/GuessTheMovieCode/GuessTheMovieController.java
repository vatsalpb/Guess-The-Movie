package GuessTheMovieCode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class GuessTheMovieController {
    public TextField textField;
    public Text guessAction;
    public Text missAction;
    @FXML
    private Text actiontarget;

    @FXML
    protected void handleTextFieldAction(ActionEvent actionEvent) {
        actiontarget.setText("Sign in button pressed");
        textField.clear();
    }
}
