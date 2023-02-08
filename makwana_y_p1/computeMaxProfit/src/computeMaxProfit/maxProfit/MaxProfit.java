package computeMaxProfit.maxProfit;

import computeMaxProfit.utils.ExceptionHandler;
import computeMaxProfit.utils.FileProcessor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
public class MaxProfit {
    FileProcessor fileProcessor;

    StringBuilder stringBuilder = new StringBuilder();
    public MaxProfit(FileProcessor fileProcessorIn){
        fileProcessor = fileProcessorIn;
    }

    public void extractDataMaxProfit(){
        LinkedHashMap<UUID, List<String>> priceList = fileProcessor.getPriceList();
        priceList.forEach((key, value) -> computeProfit(value));
        System.out.println(stringBuilder.toString());
        try {
            String fileName = System.getProperty("user.dir")+"/project-1/"+"output.txt";
            File file =  new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.close();
        } catch (Exception exceptionIn){
            ExceptionHandler.handleException(exceptionIn, "");
        } finally {

        }
    }

    public void computeProfit(List<String> valueIn){
        HashMap<String, Integer> marketList = fileProcessor.getMarketPrice();
        HashMap<String, Integer> plList = new HashMap<>();

        int maxProfit = 0;
        int maxWeight = Integer.parseInt(valueIn.get(1));

        for (int i = 2; i < valueIn.size(); i = i+2) {
            plList.put(valueIn.get(i), Integer.valueOf(valueIn.get(i+1)));
        }

        List<String> selectedNameOfCards = new ArrayList<>();
        List<String> nameOfCards = new ArrayList<>(plList.keySet());

        long startTime = System.nanoTime();

        int sumOfWeights = plList.values().stream().mapToInt(Integer::intValue).sum();

        if (sumOfWeights<=maxWeight){
            for (int i = 0; i < nameOfCards.size(); i++) {
                maxProfit += (marketList.get(nameOfCards.get(i)) - plList.get(nameOfCards.get(i)));
                selectedNameOfCards.add(nameOfCards.get(i));
            }
        } else {
            for (int i = 0; i < (1 << nameOfCards.size()); i++) {
                int currentWeight = 0;
                int currentProfit = 0;

                List<String> subsetOfCards = new ArrayList<>();

                for (int j = 0; j < nameOfCards.size(); j++) {
                    if ((i & (1 << j)) > 0) {
                        String cardName = nameOfCards.get(j);
                        currentWeight += plList.get(cardName);
                        currentProfit += (marketList.get(cardName) - plList.get(cardName));
                        subsetOfCards.add(cardName);
                    }
                }
                if (currentWeight <= maxWeight && currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                    selectedNameOfCards = subsetOfCards;
                }
            }
        }
        long endTime = System.nanoTime();
        double duration = (endTime - startTime)/ 1000000000.0;

        stringBuilder.append(nameOfCards.size()).append("\t").append(maxProfit).append("\t").append(selectedNameOfCards.size()).append("\t").append(String.format("%.5f",duration)).append("\n");
        for (int i = 0; i < selectedNameOfCards.size(); i++) {
            stringBuilder.append(selectedNameOfCards.get(i)).append("\n");
        }
        stringBuilder.append("\n").append("\n");
    }
}
