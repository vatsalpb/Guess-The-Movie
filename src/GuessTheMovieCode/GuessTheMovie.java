package GuessTheMovieCode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuessTheMovie extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GuessTheMovie.fxml"));
        fxmlLoader.setControllerFactory(t -> new GuessTheMovieController(new GuessTheMovieModel()));
        Scene scene = new Scene(fxmlLoader.load(), 300, 275);
        stage.setTitle("Guess the Movie Title");
        stage.setScene(scene);
        stage.show();
    }
}