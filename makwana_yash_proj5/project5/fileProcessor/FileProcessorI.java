package project5.fileProcessor;

public interface FileProcessorI {
    void readFile();
    int[] getProfit();
    int[] getWeights();
    int getCapacity();
    int getNumberOfItems();
    void writeToFile(StringBuilder stringBuilder);
}
