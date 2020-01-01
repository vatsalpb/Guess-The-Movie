package GuessTheMovieCode;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GuessTheMovieModel
{
    private List<Character> titleCharList;
    private Set<Character> uniqueChar;
    private Set<Character> oldChar;
    private Set<Character> wrong;
    private final String movieTitle;
    private String hiddenMovie = "";
    private int count = 0;
    private final char[] hiddenArray;
    private SimpleStringProperty winning = new SimpleStringProperty(this, "winning");
    private SimpleStringProperty hiddenArrayString = new SimpleStringProperty(this, "hiddenArrayString");

    /**
     * Constructor for GuessTheMovieModel
     */
    public GuessTheMovieModel()
    {
        titleCharList = new ArrayList<>();
        uniqueChar = new HashSet<>();
        oldChar = new HashSet<>();
        wrong = new HashSet<>();
        movieTitle = new RandomMovieTitle().getMovieTitle();
        hiddenMovie = getString(movieTitle, hiddenMovie, titleCharList, uniqueChar);
        hiddenArray = hiddenMovie.toCharArray();
    }

    public int getCount()
    {
        return count;
    }

    public void testMethod(char c)
    {
        System.out.println("I have randomly chosen a Movie title");
        System.out.println("Try to guess it.");
        System.out.println(hiddenMovie);
        List<Integer> intArray = new ArrayList<>();
        int index = 0;
        if (uniqueChar.contains(c))
        {
            for (Character character : titleCharList)
            {
                if (character.equals(c))
                {
                    intArray.add(index);
                }
                index++;
            }

            for (int find : intArray)
            {
                hiddenArray[find] = c;
            }
            uniqueChar.remove(c);
            oldChar.add(c);
            System.out.println("Unique character: " + uniqueChar);
        } else
        {
            if (!oldChar.contains(c) && !wrong.contains(c))
            {
                count++;
                wrong.add(c);
            }
        }
        System.out.println("You have entered (" + count + ") wrong: " + wrong);
        System.out.println("Hidden movie array: " + String.valueOf(hiddenArray));
        if (count == 8)
        {
            System.out.println("You have ran out of guess, good luck next time.");
            System.out.println("The movie title is: " + movieTitle);
            winning.set("The movie title is: " + movieTitle);
        } else if (uniqueChar.isEmpty())
        {
            winning.set("Congratulation");
            System.out.println("You have guessed the correct movie title, Congratulation");
        }
    }

    /**
     * This method creates the hiddenMovie title with dashes.
     * <p>
     * It a set of unique characters and list of characters in the title.
     *
     * @param movieTitle    title of the movie
     * @param hiddenMovie   empty string for hidden movie
     * @param titleCharList empty list of characters
     * @param uniqueChar    list of unique characters in the title
     * @return hidden movie title with dashes for characters to guess.
     */
    private static String getString(String movieTitle, String hiddenMovie, List<Character> titleCharList, Set<Character> uniqueChar)
    {
        for (char charArray : movieTitle.toCharArray())
        {
            titleCharList.add(charArray);
            if (charArray == ' ')
            {
                hiddenMovie = hiddenMovie.concat(" ");
            } else
            {
                hiddenMovie = hiddenMovie.concat("_");
                uniqueChar.add(charArray);
            }
        }
        return hiddenMovie;
    }

    public Set<Character> getWrong()
    {
        return wrong;
    }

    public SimpleStringProperty getHiddenArray()
    {
        hiddenArrayString.set(String.valueOf(hiddenArray));
        return hiddenArrayString;
    }

    public SimpleStringProperty getWinning()
    {
        return  winning;
    }
}
