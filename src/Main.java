import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        File file = new File("movies.txt");
        //List of movies
        List<String> movieList = movieList(file);
        String movieTitle = randomMovie(movieList);
        //String movieTitle = "inception";
        String hiddenMovie = "";
        List<Character> titleCharList = new ArrayList<>();
        Set<Character> uniqueChar = new HashSet<>();

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

        // System.out.println(titleCharList);
        // System.out.println(uniqueChar);
        // System.out.println("The movie title: " + movieTitle);

        System.out.println("I have randomly chosen a Movie title");
        System.out.println("Try to guess it.");
        System.out.println(hiddenMovie);
        char[] hiddenArray = hiddenMovie.toCharArray();

        Scanner scanner = new Scanner(System.in);
        StringBuilder wrong = new StringBuilder();
        int count = 0;

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
                //System.out.println("Unique character: " + uniqueChar);
            } else
            {
                count++;
                wrong.append(c);
            }
            System.out.println("You have entered (" + count + ") wrong: " + wrong);
            System.out.println("Hidden movie array: " + String.valueOf(hiddenArray));
            if (count == 10)
            {
                System.out.println("You have ran out of guess, good luck next time.");
                System.out.println("The movie title is: " + movieTitle);
                break;
            } else if (uniqueChar.size() == 0)
            {
                System.out.println("You have guessed the correct movie title, Congratulation");
                break;
            }
        }
    }

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
    private static String randomMovie(List<String> movieList)
    {
        Random random = new Random();
        int randomInt = random.nextInt(movieList.size());
        return movieList.get(randomInt);
    }
}
