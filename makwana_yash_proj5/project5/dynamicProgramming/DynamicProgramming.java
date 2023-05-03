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

    private void query(int n, int w){
        // if (numberOfItemsIn <= 0 || capacityIn <= 0) {
        //     return;
        // }
        // isIncluded[numberOfItemsIn][capacityIn] = true;
        // query(capacityIn, numberOfItemsIn-1);
        // query(capacityIn - weights[capacityIn-1], numberOfItemsIn-1);
        if(n<=0 || w<=0)
        {
            return;
        }
        //compute[n][w] = 1;
        isIncluded[n][w] = true;
        query(n-1, w);
        query(n-1, w-weights[n-1]);
    }

    @Override
    public void knapSackSolver() {
        isIncluded = new boolean[numberOfItems + 1][capacity + 1];
        query(numberOfItems, capacity);
        int[][] W = new int[numberOfItems + 1][capacity + 1];
        for(int i = 1; i <= numberOfItems;i++){
            B[i][0] =0;
            for(int w = 1; w <= capacity; w++){
                if (isIncluded[i][w] == true) {
                    if (weights[i-1] <= w && B[i-1][w-weights[i-1]] + profit[i-1] > B[i-1][w]) {
                        B[i][w] = B[i - 1][w - weights[i-1]] + profit[i-1];
                        W[i][w] = W[i-1][w-weights[i-1]] + weights[i-1];
                    } else {
                        B[i][w] = B[i-1][w];
                        W[i][w] = W[i-1][w];
                    }
                } else {
                    B[i][w] = 0;
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
        int max = B[numberOfItems][capacity];
        while (i > 0 && w > 0) {
            if (!(max == B[i-1][w])) {
                stringBuilderOutput.append("Item").append(i).append(" ").append(profit[i - 1]).append(" ").append(weights[i - 1]).append("\n");
                w -= weights[i - 1];
                max = max -profit[i-1];
                count++;
            }
            i--;
        }
        stringBuilderOutput.insert(0, count+" "+B[numberOfItems][capacity]+" "+W[numberOfItems][capacity]+"\n");
        // int res = B[numberOfItems][capacity];
        // int profits = res;

        // int w = capacity;
        // for (int i = numberOfItems; i > 0 && res > 0; i--) {
        //     if (res == B[i - 1][w])
        //         continue;
        //     else {
        //         //output.add(input.get(i - 1));
        //         //totalSum = totalSum + input.get(i - 1).weight;
        //         res = res - profit[i-1];
        //         w = w - weights[i-1];
        //         stringBuilderOutput.append("Item").append(i).append(" ").append(profit[i - 1]).append(" ").append(weights[i - 1]).append("\n");
        //         count++;
        //     }
        // }
        // stringBuilderOutput.insert(0, count+" "+B[numberOfItems][capacity]+" "+W[numberOfItems][capacity]+"\n");
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