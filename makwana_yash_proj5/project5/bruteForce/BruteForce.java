package project5.bruteForce;

import project5.fileProcessor.FileProcessorI;

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

    @Override
    public void initializeFile() {
        fileProcessor.readFile();
        numberOfItems = fileProcessor.getNumberOfItems();
        profit = fileProcessor.getProfit();
        weights = fileProcessor.getWeights();
        capacity = fileProcessor.getCapacity();
    }

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

    @Override
    public void writeToFile() {
        fileProcessor.writeToFile(stringBuilder, "output1.txt");
    }
}
