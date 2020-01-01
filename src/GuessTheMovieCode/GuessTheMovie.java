package GuessTheMovieCode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GuessTheMovie extends Application
{
    private static Stage stage;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        GuessTheMovie.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GuessTheMovie.fxml"));
        fxmlLoader.setControllerFactory(t -> new GuessTheMovieController(new GuessTheMovieModel()));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Guess the Movie Title");
        stage.setScene(scene);
        stage.show();
    }

    public void reload() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GuessTheMovie.fxml"));
        fxmlLoader.setControllerFactory(t -> new GuessTheMovieController(new GuessTheMovieModel()));
        Parent root = fxmlLoader.load();
        stage.getScene().setRoot(root);
    }
}