package GuessTheMovieCode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class GuessTheMovieController
{
    @FXML
    private TextField textField;
    private Button restart;
    @FXML
    private Text userGuessRemaining;
    @FXML
    private Text hiddenMovieTitle;
    @FXML
    private Text missedCharacters;

    @FXML
    protected void handleTextFieldAction(ActionEvent actionEvent)
    {
        hiddenMovieTitle.setText("Sign in button pressed");
        textField.clear();
    }

    public void handleRestart(ActionEvent actionEvent)
    {
        textField.clear();
        userGuessRemaining.setText("");
        missedCharacters.setText("");
        hiddenMovieTitle.setText("");
    }

    public void setTextField(TextField textField)
    {
        this.textField = textField;
    }

    public void setUserGuessRemaining(Text userGuessRemaining)
    {
        this.userGuessRemaining = userGuessRemaining;
    }

    public void setHiddenMovieTitle(Text hiddenMovieTitle)
    {
        this.hiddenMovieTitle = hiddenMovieTitle;
    }

    public void setMissedCharacters(Text missedCharacters)
    {
        this.missedCharacters = missedCharacters;
    }
}
