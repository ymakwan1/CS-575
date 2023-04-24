package project5.fileProcessor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import project5.utils.ExceptionHandler;

/**
 * The FileProcessor class reads and processes a file containing information about items, their
 * weights, and profits, and stores the data in arrays.
 */
public class FileProcessor implements FileProcessorI{

    private int numberOfItems;
    private int [] profit;
    private int [] weights;
    private int capacity;
    private String filePath;
    public FileProcessor(String filePathIn) {
        filePath = filePathIn;
    }

    /**
     * This function reads a file containing information about items, their weights, and profits, and
     * stores the data in arrays.
     */
    @Override
    public void readFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String[] line = bufferedReader.readLine().split(" ");
            numberOfItems = Integer.parseInt(line[0]);
            capacity = Integer.parseInt(line[1]);

            weights = new int[numberOfItems];
            profit = new int[numberOfItems];

            for (int i = 0; i < numberOfItems; i++) {
                String itemsLine = bufferedReader.readLine();;
                String[] parts = itemsLine.split(" ");
                profit[i] = Integer.parseInt(parts[1]);
                weights[i] = Integer.parseInt(parts[2]);
            }

            bufferedReader.close();
        } catch (Exception e) {
            ExceptionHandler.handleException(e, "Error reading file.");
        }
    }


    /**
     * The function returns an integer array of profits.
     * 
     * @return An integer array named "profit" is being returned.
     */
    @Override
    public int[] getProfit() {
        return profit;
    }

    /**
     * The function returns an array of integers representing weights.
     * 
     * @return An integer array called "weights" is being returned.
     */
    @Override
    public int[] getWeights() {
        return weights;
    }

    /**
     * The function returns the capacity of an object.
     * 
     * @return The method is returning the value of the variable "capacity".
     */
    @Override
    public int getCapacity() {
        return capacity;
    }

    /**
     * This function returns the number of items.
     * 
     * @return The method is returning the value of the variable `numberOfItems`.
     */
    @Override
    public int getNumberOfItems() {
     return numberOfItems;
    }

    /**
     * This function writes the contents of a StringBuilder object to a file specified by the
     * outputFileIn parameter.
     * 
     * @param stringBuilderIn A StringBuilder object that contains the data to be written to the file.
     * @param outputFileIn The parameter "outputFileIn" is a String variable that represents the file
     * path and name of the output file where the contents of the StringBuilder object will be written.
     */
    @Override
    public void writeToFile(StringBuilder stringBuilderIn, String outputFileIn) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFileIn));
            bufferedWriter.write(stringBuilderIn.toString().trim());
            bufferedWriter.close();
        } catch (Exception e) {
            ExceptionHandler.handleException(e, "Error writing file.");
        }
    }
}