package project5.fileProcessor;

/*  
*This is a Java interface named `FileProcessorI` that defines a set of methods that must be
* implemented by any class that implements this interface. The methods defined in this interface are:
*/
public interface FileProcessorI {
    void readFile();
    int[] getProfit();
    int[] getWeights();
    int getCapacity();
    int getNumberOfItems();
    void writeToFile(StringBuilder stringBuilder, String outputFile);
}