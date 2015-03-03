import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Generates lists of random integers.
 *
 * @author Andrei Muntean
 */
public class RandomNumbersGenerator
{
    private boolean hasSeed;
    private long seed;

    /**
     * Constructs a RandomNumbersGenerator object.
     */
    public RandomNumbersGenerator()
    {
        hasSeed = false;
    }

    /**
     * Constructs a RandomNumbersGenerator object with the specified seed.
     *
     * @param seed A seed.
     */
    public RandomNumbersGenerator(long seed)
    {
        this.seed = seed;
        hasSeed = true;
    }

    /**
     * Generates a list of random integers.
     *
     * @param smallest The smallest integer that can appear in the list. Inclusive.
     * @param highest The highest integer that can appear in the list. Inclusive.
     * @param count The number of integers in the list.
     * 
     * @return A list of random integers.
     */
    public ArrayList<Integer> generate(int smallest, int highest, int count)
    {
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>(count);
        Random random = hasSeed ? new Random(seed) : new Random();

        // Updates the variable to be better suited for Random.
        highest = highest - smallest + 1;

        while (count-- > 0)
        {
            int randomNumber = smallest + random.nextInt(highest);

            randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }

    public static void main(String[] args)
    {
        try
        {
            RandomNumbersGenerator randomNumbersGenerator = new RandomNumbersGenerator();
            int smallest;
            int highest;
            int count;

            if (args.length == 3)
            {
                // Reads input from args.
                smallest = Integer.parseInt(args[0]);
                highest = Integer.parseInt(args[1]);
                count = Integer.parseInt(args[2]);
            }
            else
            {
                // Reads input from standard input.
                Scanner scanner = new Scanner(System.in);

                // Gets the smallest value.
                System.out.println("What should the smallest integer be?");
                System.out.print("> ");
                smallest = scanner.nextInt();

                // Gets the highest value.
                System.out.println("What should the highest integer be?");
                System.out.print("> ");
                highest = scanner.nextInt();

                // Gets the number of integers.
                System.out.println("How many integers should there be?");
                System.out.print("> ");
                count = scanner.nextInt();
            }

            // Prints the output to standard output.
            // It is recommended for the user to redirect it to a file.
            for (Integer integer : randomNumbersGenerator.generate(smallest, highest, count))
            {
                System.out.println(integer);
            }
        }
        catch (Exception exception)
        {
            if (exception.getMessage() != null)
            {
                System.err.println("Invalid input: " + exception.getMessage());
            }
            else
            {
                System.err.println("Invalid input.");
            }
        }
    }
}