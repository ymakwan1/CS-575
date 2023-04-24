package project5.createFile;

import java.io.FileWriter;
import java.util.Random;

import project5.utils.ExceptionHandler;

/**
 * The CreateKP class generates a random Knapsack problem and writes it to a file.
 */
public class CreateKP {
    public static void main(String[] args) {
        if (args.length < 1) {
            ExceptionHandler.handleException(null, "Usage: java project5/createFile/CreateKnapsackProblem <output_file.txt>");
        }
        String knapSackProblemFile = args[0];

        int numberOfItems = randomValueGenerator(4, 8);
        int totalWeight = 0;
        int [] profit = new int [numberOfItems];
        int [] weights = new int [numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {
            profit[i] = randomValueGenerator(10, 30);
            weights[i] = randomValueGenerator(5, 20);
            totalWeight += weights[i];
        }
        int capacity = (int) (Math.floor(0.6 * totalWeight));
        try {
            FileWriter fileWriter = new FileWriter(knapSackProblemFile);
            fileWriter.write(numberOfItems+" "+capacity+"\n");
            for (int index = 0; index < numberOfItems; index++) {
                String line = String.format("Item%d %d %d", index + 1, profit[index], weights[index]);
                if (index == numberOfItems - 1) {
                    fileWriter.write(line);
                } else {
                    fileWriter.write(line + "\n");
                }
            }
            fileWriter.close();
        } catch (Exception e) {
            ExceptionHandler.handleException(e, "Error writing to file");
        }
    }  

    /**
     * The function generates a random integer value within a given range.
     * 
     * @param min The minimum value that the random number can take.
     * @param max The maximum value that the random number generator can generate.
     * @return The method `randomValueGenerator` returns an integer value that is randomly generated
     * between the `min` and `max` values (inclusive).
     */
    private static int randomValueGenerator(int min, int max) {
        Random random = new Random();
        int randomValue = random.nextInt((max - min) + 1) + min;
        return randomValue;
    }
}