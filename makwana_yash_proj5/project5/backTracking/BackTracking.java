package project5.backTracking;

import project5.fileProcessor.FileProcessorI;

public class BackTracking implements BackTrackingI {
    
    private FileProcessorI fileProcessor;
    private int numberOfItems;
    private int[] profit;
    private int[] weights;
    private int capacity;
    private static int[] bestItems;
    private static int bestProfit;
    private StringBuilder stringBuilderOutput = new StringBuilder();
    private StringBuilder stringBuilderEntries = new StringBuilder();

    public BackTracking(FileProcessorI fileProcessorIn){
        fileProcessor = fileProcessorIn;
    }

    @Override
    public void initializeFile() {
        fileProcessor.readFile();
        numberOfItems = fileProcessor.getNumberOfItems();
        profit = fileProcessor.getProfit();
        weights = fileProcessor.getWeights();
        capacity = fileProcessor.getCapacity();
        bestItems = new int[numberOfItems];
    }

    private void knapsack(int iIn, int profitIn, int weightIn, int boundIn, int[] itemsIn){
        if (weightIn <= capacity && profitIn > bestProfit) {
            bestProfit = profitIn;
            bestItems = itemsIn.clone();
        }

        if (iIn < numberOfItems){
            int itemWeight = weights[iIn];
            int itemProfit = profit[iIn];
            int bound = bound(weightIn, profitIn, iIn+1);
            if (bound > bestProfit) {
                itemsIn[iIn] = 1;
                knapsack(iIn+1, profitIn+itemProfit, weightIn+itemWeight, bound, itemsIn);
                itemsIn[iIn] = 0;
                int bound1 = bound(weightIn, profitIn, iIn + 1);
                if (bound1 > bestProfit) {
                    knapsack(iIn+1, profitIn, weightIn, bound1, itemsIn);
                }
            }
        }
        stringBuilderEntries.append(iIn).append(" ").append(profitIn).append(" ").append(weightIn).append(" ").append(boundIn).append("\n");
    }

    private int bound(int weightIn, int profitIn, int iIn){
        int bound = profitIn;
        int remainingWeight = capacity - weightIn;
        while (iIn < numberOfItems && weights[iIn] <= remainingWeight) {
            remainingWeight -= weights[iIn];
            bound += profit[iIn];
            iIn++;
        }
        if (iIn < numberOfItems) {
            bound += remainingWeight * profit[iIn] / weights[iIn];
        }
        return bound;
    }
    @Override
    public void knapSackSolver() {
        //int bound = bound(0, 0, 0);
        knapsack(0, 0, 0, bound(0, 0, 0), new int[numberOfItems]);
        int totalWeight = 0;
        for (int i = 0; i < numberOfItems; i++) {
            if (bestItems[i] == 1) {
                totalWeight += weights[i];
                stringBuilderOutput.append("Item ").append(i + 1).append(": weight = ").append(weights[i])
                        .append(", profit = ").append(profit[i]).append("\n");
            }
        }
    }

    @Override
    public void writeToFile() {
        fileProcessor.writeToFile(stringBuilderEntries, "entries2.txt");
        fileProcessor.writeToFile(stringBuilderOutput, "output3.txt");
    }
    
}
