package project5.fileProcessor;

import java.io.BufferedReader;
import java.io.FileReader;

import project5.utils.ExceptionHandler;

public class FileProcessor implements FileProcessorI{

    private int numberOfItems;
    private int [] profit;
    private int [] weights;
    private int capacity;
    private String filePath;
    public FileProcessor(String filePathIn) {
        filePath = filePathIn;
    }

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
                String[] parts = bufferedReader.readLine().split(" ");
                profit[i] = Integer.parseInt(parts[1]);
                weights[i] = Integer.parseInt(parts[2]);
            }

            bufferedReader.close();
        } catch (Exception e) {
            ExceptionHandler.handleException(e, "Error reading file.");
        }
    }


    @Override
    public int[] getProfit() {
        return profit;
    }

    @Override
    public int[] getWeights() {
        return weights;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getNumberOfItems() {
     return numberOfItems;
    }
    
}