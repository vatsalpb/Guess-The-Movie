package GuessTheMovieCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * This class handles the randomizing of movie title.
 */
public class RandomMovieTitle
{
    private Random random = new Random();

    private File file = new File("movies.txt");
    //List of movies
    private List<String> movieList = movieList(file);
    private String movieTitle = randomMovie(movieList);

    /**
     * @param file read a text file of movie titles
     * @return a list of movie titles.
     */
    private static List<String> movieList(File file)
    {
        List<String> movieTitles = new ArrayList<>();
        try
        {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                movieTitles.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + e.getMessage());
        }
        return movieTitles;
    }

    /**
     * @param movieList from the movies text file.
     * @return a random movie title.
     */
    private String randomMovie(List<String> movieList)
    {
        int randomInt = random.nextInt(movieList.size());
        return movieList.get(randomInt);
    }

    public String getMovieTitle()
    {
        return movieTitle;
    }
}
