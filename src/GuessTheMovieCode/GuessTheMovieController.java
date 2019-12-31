package GuessTheMovieCode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.util.Arrays;

public class GuessTheMovieController
{
    @FXML
    private TextField textField;
    @FXML
    private Text userGuessRemaining;
    @FXML
    private Text hiddenMovieTitle;
    @FXML
    private Text missedCharacters;
    private GuessTheMovieModel guessTheMovieModel;

    public GuessTheMovieController(GuessTheMovieModel guessTheMovieModel)
    {
        this.guessTheMovieModel = guessTheMovieModel;
    }

    @FXML
    protected void handleTextFieldAction(ActionEvent actionEvent)
    {
        char c = textField.getCharacters().charAt(0);
        guessTheMovieModel.testMethod(c);
        this.hiddenMovieTitle.setText(Arrays.toString(guessTheMovieModel.getHiddenArray()));
        int count = guessTheMovieModel.getCount();
        if(count == 8)
        {
            this.textField.setDisable(true);
        }
        this.userGuessRemaining.setText("" + count);
        this.missedCharacters.setText(guessTheMovieModel.getWrong().toString());
        textField.clear();
    }

    public void handleRestart(MouseEvent actionEvent)
    {
        textField.clear();
        userGuessRemaining.setText("");
        missedCharacters.setText("");
        hiddenMovieTitle.setText("");
    }
}
