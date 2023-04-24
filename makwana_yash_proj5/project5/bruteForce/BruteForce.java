package project5.bruteForce;

import project5.fileProcessor.FileProcessorI;

/**
 * The BruteForce class implements the BruteForceI interface to solve the knapsack problem using a
 * brute force approach and writes the output to a file.
 */
public class BruteForce implements BruteForceI{

    private FileProcessorI fileProcessor;
    private int numberOfItems;
    private int[] profit;
    private int[] weights;
    private int capacity;
    private StringBuilder stringBuilder = new StringBuilder();
    public BruteForce(FileProcessorI fileProcessorIn) {
        fileProcessor = fileProcessorIn;
    }

    /**
     * This function initializes variables by reading data from a file using a file processor object.
     */
    @Override
    public void initializeFile() {
        fileProcessor.readFile();
        numberOfItems = fileProcessor.getNumberOfItems();
        profit = fileProcessor.getProfit();
        weights = fileProcessor.getWeights();
        capacity = fileProcessor.getCapacity();
    }

    /**
     * The function solves the knapsack problem using a brute force approach and returns the maximum
     * profit, weight, and items selected.
     */
    @Override
    public void knapSackSolver() {
        int maxProfit = 0;
        int maxWeight = 0;
        int maxMask = 0;

        for (int i = 0; i < (1 << numberOfItems); i++) {
            int currentWeight = 0;
            int currentProfit = 0;
            for (int j = 0; j < numberOfItems; j++) {
                if ((i & (1 << j)) > 0) {
                    currentWeight += weights[j];
                    currentProfit += profit[j];
                }
            }
            if (currentWeight <= capacity && currentProfit > maxProfit) {
                maxProfit = currentProfit;
                maxWeight = currentWeight;
                maxMask = i;
            }
        }
        stringBuilder.append(Integer.bitCount(maxMask)).append(" ").append(maxProfit).append(" ").append(maxWeight).append("\n");

        for (int i = 0; i < numberOfItems; i++) {
            if((maxMask & (1 << i)) > 0) {
                stringBuilder.append("Item").append(i+1).append(" ").append(profit[i]).append(" ").append(weights[i]).append("\n");
            }
        }
    }

    /**
     * This function writes the contents of a StringBuilder object to a file named "output1.txt" using
     * a file processor.
     */
    @Override
    public void writeToFile() {
        fileProcessor.writeToFile(stringBuilder, "output1.txt");
    }
}