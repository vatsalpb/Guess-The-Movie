package GuessTheMovieCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class GuessTheMovieModel
{
    String movieTitle = new RandomMovieTitle().getMovieTitle();
    List<Character> titleCharList = new ArrayList<>();
    Set<Character> uniqueChar = new HashSet<>();
    Set<Character> oldChar = new HashSet<>();
    Set<Character> wrong = new HashSet<>();
    String hiddenMovie = "";
    hiddenMovie =

    getString(movieTitle, hiddenMovie, titleCharList, uniqueChar);

//        System.out.println("I have randomly chosen a Movie title");
//        System.out.println("Try to guess it.");
        System.out.println(hiddenMovie);
    char[] hiddenArray = hiddenMovie.toCharArray();

    Scanner scanner = new Scanner(System.in);

    int count = 0;

    testmethod(movieTitle, titleCharList, uniqueChar, oldChar, wrong, hiddenArray, scanner, count);


    private static void testmethod(String movieTitle, List<Character> titleCharList, Set<Character> uniqueChar, Set<Character> oldChar, Set<Character> wrong, char[] hiddenArray, Scanner scanner, int count)
    {
        while (true)
        {
            System.out.println("Enter a character ");
            char c = scanner.next().charAt(0);
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
                //System.out.println("Unique character: " + uniqueChar);
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
                break;
            } else if (uniqueChar.isEmpty())
            {
                System.out.println("You have guessed the correct movie title, Congratulation");
                break;
            }
        }
    }

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
}
