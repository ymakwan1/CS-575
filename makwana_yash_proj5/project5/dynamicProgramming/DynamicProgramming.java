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
     * This function computes the positions of a matrix based on given parameters using recursion.
     * 
     * @param n The number of items to be considered for inclusion in the knapsack problem.
     * @param w w is the maximum weight capacity of a knapsack. The function is likely being used to
     * compute the positions in a matrix that represent whether or not an item is included in the
     * knapsack based on its weight and value.
     */
    private void computeMatrixPositions(int n, int w){
        if(n<=0 || w<=0)
        {
            return;
        }
        isIncluded[n][w] = true;
        computeMatrixPositions(n-1, w);
        computeMatrixPositions(n-1, w-weights[n-1]);
    }

    /**
     * The function implements the dynamic programming solution to the 0/1 Knapsack problem and outputs
     * the optimal solution.
     */
    @Override
    public void knapSackSolver() {
        isIncluded = new boolean[numberOfItems + 1][capacity + 1];
        computeMatrixPositions(numberOfItems, capacity);
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
                stringBuilderEntries.append(B[i][w]).append(" ");
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