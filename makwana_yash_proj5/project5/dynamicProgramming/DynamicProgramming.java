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

    @Override
    public void initializeFile() {
        fileProcessor.readFile();
        numberOfItems = fileProcessor.getNumberOfItems();
        profit = fileProcessor.getProfit();
        weights = fileProcessor.getWeights();
        capacity = fileProcessor.getCapacity();
        B = new int[numberOfItems + 1][capacity + 1];
    }

    @Override
    public void knapSackSolver() {
        isIncluded = new boolean[numberOfItems + 1][capacity + 1];
        //int wt = 0;
        for(int i = 1; i <= numberOfItems;i++){
            for(int w = 1; w <= capacity; w++){
                if (weights[i-1] <= w) {
                    int includeItem = profit[i-1]+B[i-1][w-weights[i-1]];
                    int excludeItem = B[i-1][w];
                    if (includeItem > excludeItem) {
                        B[i][w] = includeItem;
                        isIncluded[i][w] = true;
                        //wt += weights[i-1];
                    } else {
                        B[i][w] = excludeItem;
                    }
                } else {
                    B[i][w] = B[i-1][w];
                }
            }
        }

        for (int i = 0; i <= numberOfItems; i++) {
            for (int w = 0; w <= capacity; w++) {
                stringBuilderEntries.append(B[i][w]).append("\t");
            }
            stringBuilderEntries.append("\n");
        }
        //TODO Handle this weight printing
        stringBuilderOutput.append(numberOfItems).append(" ").append(B[numberOfItems][capacity]).append(" ").append("").append("\n");
        int i = numberOfItems;
        int w = capacity;
        while (i > 0 && w > 0) {
            if (isIncluded[i][w]) {
                stringBuilderOutput.append("Item").append(i).append(" ").append(profit[i - 1]).append(" ").append(weights[i - 1]).append("\n");
                w -= weights[i - 1];
            }
            i--;
        }
    }
    @Override
    public void writeToFile() {
        fileProcessor.writeToFile(stringBuilderEntries, "entries1.txt");
        fileProcessor.writeToFile(stringBuilderOutput, "output2.txt");
    }
}