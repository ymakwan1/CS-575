package project5.backTracking;

import java.util.Arrays;
import java.util.HashMap;

import project5.fileProcessor.FileProcessorI;

/**
 * The BackTracking class implements a recursive approach to solve the Knapsack problem and calculates
 * the upper bound of the maximum profit that can be obtained using the KWF2 algorithm.
 */
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
    private float boundG = 0;
    private StringBuilder stringBuilderOutput = new StringBuilder();
    private StringBuilder stringBuilderEntries = new StringBuilder();
    private HashMap<String, Integer> map;

    public BackTracking(FileProcessorI fileProcessorIn){
        fileProcessor = fileProcessorIn;
    }

    /**
     * The function initializes variables and creates a HashMap to store item weights and profits.
     */
    @Override
    public void initializeFile() {
        fileProcessor.readFile();
        numberOfItems = fileProcessor.getNumberOfItems();
        profit = fileProcessor.getProfit();
        weights = fileProcessor.getWeights();
        capacity = fileProcessor.getCapacity();
        map = new HashMap<>();
        for (int i = 0; i < weights.length; i++) {
            String k = "Item"+(i+1);
            int val = weights[i]+profit[i];
            map.put(k, val);
        }
        sortItemsByProfitPerWeight();
    }

    /**
     * The function sorts items by their profit per weight ratio and updates the profit and weight
     * arrays accordingly.
     */
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

    /**
     * The function calculates the upper bound of the maximum profit that can be obtained in a Knapsack
     * problem using the KWF2 algorithm.
     * 
     * @param i an integer representing the current item being considered in the Knapsack problem
     * @param weight The current weight of the items being considered in the Knapsack problem.
     * @param profitIn The initial profit value before any items are included in the knapsack.
     * @param n The total number of items available for selection.
     * @param W The maximum weight capacity of the knapsack.
     * @return a float value which represents the bound of the Knapsack problem.
     */
    private float KWF2(int i, int weight, int profitIn, int n, int W) {
        float bound = profitIn;
        float sbx;
        while (weight < W && i <= n) {
            if (weight + weights[i-1] <= W) {
                weight = weight + weights[i-1];
                bound = bound + profit[i-1];
                //include[i] = 1;
            } else {
                sbx = (float) (W - weight) / (float) weights[i-1];
                weight = W;
                bound = bound +  (profit[i-1] * sbx);
                //include[i] =  sbx;
            }
            i += 1;
        }
        return bound;
    }
    

    /**
     * The function checks if a given state is promising for a Knapsack problem by calculating its
     * upper bound and comparing it to the maximum profit found so far.
     * 
     * @param i The current item being considered in the knapsack problem (0-indexed).
     * @param profit The current profit obtained by selecting items in the knapsack.
     * @param W The maximum weight capacity of the knapsack.
     * @param weight The current weight of the items selected so far in the knapsack.
     * @param n The number of items in the problem instance.
     * @return The method is returning a boolean value.
     */
    private boolean Promising(int i, int profit, int W, int weight, int n) {
       // boundG = profit;
        if (weight >= W) {
            return false;
        }
        float bound = KWF2(i+1, weight, profit, n, W);
        boundG = bound;
        return (bound > maxProfit);
    }

    
    /**
     * The function implements the knapsack problem using a recursive approach to find the maximum
     * profit that can be obtained while staying within a weight limit.
     * 
     * @param i The current item being considered for inclusion in the knapsack.
     * @param profitIn The current total profit obtained by selecting items in the knapsack.
     * @param weight The current weight of the items in the knapsack.
     * @param W The maximum weight capacity of the knapsack.
     * @param n The number of items available for selection in the knapsack problem.
     */
    private void knapsack(int i, int profitIn, int weight, int W, int n, int indexIn){
        // stringBuilderEntries.append(nodeCounter).append(" ").append(profitIn).append(" ").append(weight).append(" ").append(boundG).append("\n");
        // nodeCounter++;
        if (weight <= W && profitIn > maxProfit) {
            maxProfit = profitIn;
            num = i;
            for (int j = 1; j <= n; j++) {
                bestSet[j] = include[j];
            }
        }
        boolean isPromising = Promising(i, profitIn, W, weight, n);
        stringBuilderEntries.append(nodeCounter).append(" ").append(indexIn).append(" ").append(profitIn).append(" ").append(weight).append(" ").append(boundG).append("\n");
        nodeCounter++;
        indexIn++;
        if (isPromising) {
            include[i + 1] = 1;
            knapsack(i + 1, profitIn + profit[i], weight + weights[i], W, n, indexIn);
            include[i + 1] = 0;
            knapsack(i + 1, profitIn, weight, W, n, indexIn);
        }
    }

    /**
     * The function solves the knapsack problem and outputs the optimal set of items to include in the
     * knapsack along with their total profit and weight.
     */
    @Override
    public void knapSackSolver() {
        bestSet = new int[numberOfItems + 1];
        maxProfit = 0;
        include = new int[numberOfItems+1];
        nodeCounter = 1;
        Arrays.fill(include, 0);
        knapsack(0, 0, 0, capacity, numberOfItems, 0);
        int totalWeight = 0;
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (bestSet[i] == 1) {
                totalWeight += weights[i-1];
                count++;
                String k = getKeyByValue(map, (weights[i-1]+profit[i-1]));
                //stringBuilderOutput.append("Item" + i +" "+ profit[i-1] + " " + weights[i-1] + "\n");
                stringBuilderOutput.append(k +" "+ profit[i-1] + " " + weights[i-1] + "\n");
            }
        }
        stringBuilderOutput.insert(0, count + " " + maxProfit + " " + totalWeight + "\n");
    }
    
    /**
     * This Java function returns the key of a given value in a HashMap.
     * 
     * @param map A HashMap with keys of type K and values of type V.
     * @param value The value parameter is the value that we want to find the corresponding key for in
     * the HashMap.
     * @return The method is returning a key of type K from the given HashMap that matches the given
     * value of type V. If no such key is found, it returns null.
     */
    private <K, V> K getKeyByValue(HashMap<K, V> map, V value) {
        for (HashMap.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
    
    /**
     * The function writes two string builders to two separate files.
     */
    @Override
    public void writeToFile() {
        fileProcessor.writeToFile(stringBuilderEntries, "entries3.txt");
        fileProcessor.writeToFile(stringBuilderOutput, "output3.txt");
    }   
}