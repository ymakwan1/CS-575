package project5.backTracking;

import java.util.Arrays;

import project5.fileProcessor.FileProcessorI;

public class BackTracking implements BackTrackingI {
    
    private FileProcessorI fileProcessor;
    private int numberOfItems;
    private int[] profit;
    private int[] weights;
    private int capacity;
    private int[] bestSet;
    private int[] include;
    private int nodeCounter;
    private int maxProfit;
    private int num;
    float boundG = 0;
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
        sortItemsByProfitPerWeight();
    }

    private void sortItemsByProfitPerWeight() {
        Integer[] items = new Integer[numberOfItems];
        for (int i = 0; i < numberOfItems; i++) {
            items[i] = i;
        }
        Arrays.sort(items, (a, b) -> Double.compare((double) profit[b] / weights[b], (double) profit[a] / weights[a]));

        int[] newProfit = new int[numberOfItems];
        int[] newWeights = new int[numberOfItems];
        for (int i = 0; i < numberOfItems; i++) {
            newProfit[i] = profit[items[i]];
            newWeights[i] = weights[items[i]];
        }
        profit = newProfit;
        weights = newWeights;
    }

    private float KWF2(int i, int weight, int profitIn, int n, int W) {
        float bound = profitIn;
        float sbx;
        while (weight < W && i <= n) {
            if (weight + weights[i-1] <= W) {
                weight = weight + weights[i-1];
                bound = bound + profit[i-1];
                include[i] = 1;
            } else {
                sbx = (float) (W - weight) / (float) weights[i-1];
                weight = W;
                bound = bound + (int) (profit[i-1] * sbx);
                include[i] = (int) sbx;
            }
            i += 1;
        }
        return bound;
    }
    

    private boolean Promising(int i, int profit, int W, int weight, int n) {
        boundG = profit;
        if (weight >= W) {
            return false;
        }
        float bound = KWF2(i+1, weight, profit, n, W);
        boundG = bound;
        // stringBuilderEntries.append(nodeCounter).append(" ").append(profit).append(" ").append(weight).append(" ").append(bound).append("\n");
        // nodeCounter++;
        return (bound > maxProfit);
    }

    
    private void knapsack(int i, int profitIn, int weight, int W, int n){
        stringBuilderEntries.append(nodeCounter).append(" ").append(profitIn).append(" ").append(weight).append(" ").append(boundG).append("\n");
        nodeCounter++;
        if (weight <= W && profitIn > maxProfit) {
            maxProfit = profitIn;
            num = i;
            for (int j = 1; j <= n; j++) {
                bestSet[j] = include[j];
            }
        }
        if (Promising(i, profitIn, W, weight, n)) {
            include[i + 1] = 1;
            knapsack(i + 1, profitIn + profit[i], weight + weights[i], W, n);
            include[i + 1] = 0;
            knapsack(i + 1, profitIn, weight, W, n);
        }
    }

    @Override
    public void knapSackSolver() {
        bestSet = new int[numberOfItems + 1];
        maxProfit = 0;
        include = new int[numberOfItems+1];
        nodeCounter = 1;
        Arrays.fill(include, 0);
        knapsack(0, 0, 0, capacity, numberOfItems);
        int totalWeight = 0;
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (bestSet[i] == 1) {
                totalWeight += weights[i-1];
                count++;
                stringBuilderOutput.append("Item" + i +" "+ profit[i-1] + " " + weights[i-1] + "\n");
            }
        }
        stringBuilderOutput.insert(0, count + " " + maxProfit + " " + totalWeight + "\n");
    }

    @Override
    public void writeToFile() {
        fileProcessor.writeToFile(stringBuilderEntries, "entries3.txt");
        fileProcessor.writeToFile(stringBuilderOutput, "output3.txt");
    }   
}