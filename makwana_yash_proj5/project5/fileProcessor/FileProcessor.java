package project5.fileProcessor;

public class FileProcessor implements FileProcessorI{

    private int [] profit;
    private int [] weights;
    private int capacity;
    private String filePath;
    public FileProcessor(String filePathIn) {
        filePath = filePathIn;
    }

    @Override
    public void readFile() {
        
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
    public int capacity() {
        return capacity;
    }
    
}