package project5.backTracking;

import project5.fileProcessor.FileProcessorI;

public class BackTracking implements BackTrackingI {
    
    private FileProcessorI fileProcessor;
    private int numberOfItems;
    private int[] profit;
    private int[] weights;
    private int capacity;
    private StringBuilder stringBuilderOutput = new StringBuilder();
    private StringBuilder stringBuilderEntries = new StringBuilder();

    public BackTracking(FileProcessorI fileProcessorIn){
        fileProcessor = fileProcessorIn;
    }

    @Override
    public void initializeFile() {
        fileProcessor.readFile();
        numberOfItems = fileProcessor.getNumberOfItems();
        
    }

    @Override
    public void knapSackSolver() {

    }

    @Override
    public void writeToFile() {

    }
    
}
