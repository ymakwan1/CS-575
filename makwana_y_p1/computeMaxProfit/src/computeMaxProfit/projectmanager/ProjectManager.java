package computeMaxProfit.projectmanager;

import computeMaxProfit.maxProfit.MaxProfit;
import computeMaxProfit.utils.FileProcessorI;
import computeMaxProfit.utils.FileProcessor;

public class ProjectManager implements ProjectManagerI{
    private FileProcessor inputFileProcessor;
    String firstFileType;
    String secondFileType;
    String marketPriceInputFile;
    String priceListInputFile;
    public ProjectManager(String firstFileTypeIn, String inputFileOne, String secondFileTypeIn, String inputFileTwo){
        if (firstFileTypeIn.equals("-m")){
            marketPriceInputFile = inputFileOne;
            priceListInputFile = inputFileTwo;
        } else{
            priceListInputFile = inputFileOne;
            marketPriceInputFile = inputFileTwo;
        }
        inputFileProcessor = new FileProcessor(marketPriceInputFile, priceListInputFile);
    }
    @Override
    public void run() {
        MaxProfit maxProfit = new MaxProfit(inputFileProcessor);
        maxProfit.extractDataMaxProfit();
    }
}