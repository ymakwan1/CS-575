package project5.dynamicProgramming;

import project5.fileProcessor.FileProcessorI;

public class DynamicProgramming implements DynamicProgrammingI{

    private FileProcessorI fileProcessor;
    private int numberOfItems;
    private int[] profit;
    private int[] weights;
    private int capacity;
    private StringBuilder stringBuilderOutput = new StringBuilder();
    private StringBuilder stringBuilderEntries = new StringBuilder();
    private int[][] B;
    private boolean[][] isIncluded;
    public DynamicProgramming(FileProcessorI fileProcessorIn){
        fileProcessor = fileProcessorIn;
    }

    /**
     * This function initializes variables and arrays needed for solving the knapsack problem by
     * reading data from a file.
     */
    @Override
    public void initializeFile() {
        fileProcessor.readFile();
        numberOfItems = fileProcessor.getNumberOfItems();
        profit = fileProcessor.getProfit();
        weights = fileProcessor.getWeights();
        capacity = fileProcessor.getCapacity();
        B = new int[numberOfItems + 1][capacity + 1];
    }

    /**
     * This is a Java function that solves the knapsack problem using dynamic programming and outputs the
     * optimal solution.
     */
    @Override
    public void knapSackSolver() {
        isIncluded = new boolean[numberOfItems + 1][capacity + 1];
        int[][] W = new int[numberOfItems + 1][capacity + 1];
        for(int i = 1; i <= numberOfItems;i++){
            for(int w = 1; w <= capacity; w++){
                if (weights[i-1] <= w) {
                    int includeItem = profit[i-1]+B[i-1][w-weights[i-1]];
                    int excludeItem = B[i-1][w];
                    if (includeItem > excludeItem) {
                        B[i][w] = includeItem;
                        isIncluded[i][w] = true;
                        W[i][w] = W[i-1][w-weights[i-1]] + weights[i-1];
                    } else {
                        B[i][w] = excludeItem;
                        W[i][w] = W[i-1][w];
                    }
                } else {
                    B[i][w] = B[i-1][w];
                    W[i][w] = W[i-1][w];
                }
            }
        }

        for (int i = 0; i <= numberOfItems; i++) {
            for (int w = 0; w <= capacity; w++) {
                stringBuilderEntries.append(B[i][w]).append("\t");
            }
            stringBuilderEntries.append("\n");
        }
        
        int count = 0;
        int i = numberOfItems;
        int w = capacity;
        while (i > 0 && w > 0) {
            if (isIncluded[i][w]) {
                stringBuilderOutput.append("Item").append(i).append(" ").append(profit[i - 1]).append(" ").append(weights[i - 1]).append("\n");
                w -= weights[i - 1];
                count++;
            }
            i--;
        }
        stringBuilderOutput.insert(0, count+" "+B[numberOfItems][capacity]+" "+W[numberOfItems][capacity]+"\n");
    }

   /**
    * The function writes two string builders to two separate files.
    */
    @Override
    public void writeToFile() {
        fileProcessor.writeToFile(stringBuilderEntries, "entries2.txt");
        fileProcessor.writeToFile(stringBuilderOutput, "output2.txt");
    }
}