package GuessTheMovieCode;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class GuessTheMovieController
{
    public Text winningLabel;
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
    protected void handleTextFieldAction()
    {
        CharSequence characters = textField.getCharacters();

        if (characters.length() > 0)
        {
            char c = characters.charAt(0);
            guessTheMovieModel.testMethod(c);
            initialize();
            int count = guessTheMovieModel.getCount();
            if (count == 8)
            {
                this.textField.setDisable(true);
            }
            this.userGuessRemaining.setText("" + count);
            this.missedCharacters.setText(guessTheMovieModel.getWrong().toString());
            textField.clear();
        }
    }

    public void handleRestart() throws IOException
    {
        new GuessTheMovie().reload();
        textField.clear();
        userGuessRemaining.setText("");
        missedCharacters.setText("");
        initialize();
    }

    public void initialize()
    {
        hiddenMovieTitle.textProperty().bind(guessTheMovieModel.getHiddenArray());
        winningLabel.textProperty().bind(guessTheMovieModel.getWinning());
    }
}
