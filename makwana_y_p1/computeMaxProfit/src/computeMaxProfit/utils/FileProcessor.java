package computeMaxProfit.utils;

import java.io.*;
import java.util.*;

public class FileProcessor implements FileProcessorI{

    private HashMap<String, Integer> marketPrice = new HashMap<>();
    private LinkedHashMap<UUID, List<String>> priceList = new LinkedHashMap<>();
    private BufferedReader _reader;
    public String fileName;
    public String fullyQualifiedFileName;
    public File file;
    public FileProcessor(String marketPriceInputFileIn, String priceListInputFileIn) {
        readMarketPrice(marketPriceInputFileIn);
        readPriceList(priceListInputFileIn);
    }

    private void initializeFile(String fileNameIn){
        try {
            String fullFileName = System.getProperty("user.dir")+"/"+fileNameIn;
            fullyQualifiedFileName = fullFileName;
            file = new File(fullFileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader= new BufferedReader(fileReader);
            _reader = bufferedReader;
        } catch (FileNotFoundException exceptionIn) {
            ExceptionHandler.handleException(exceptionIn, "Unable to locate file:"+fileNameIn);
        } finally {

        }
    }
    @Override
    public void readMarketPrice(String marketPriceIn) {
        initializeFile(marketPriceIn);
        try {
            _reader.readLine();
            String str;
            while ((str = _reader.readLine()) != null){
                String[] stringParts = str.split(" ");
                marketPrice.put(stringParts[0], Integer.parseInt(stringParts[1]));
            }
        } catch (IOException exceptionIn) {
            ExceptionHandler.handleException(exceptionIn, "Unable to locate/read from file : " + fileName);
        }

    }

    @Override
    public void readPriceList(String priceListIn) {
        initializeFile(priceListIn);
        try{
            String priceListLine = _reader.readLine();
            while (priceListLine != null){
                int numberOfCards = Integer.parseInt(priceListLine.split(" ")[0]);
                int maxMoney = Integer.parseInt(priceListLine.split(" ")[1]);
                ArrayList<String> data = new ArrayList<>();
                data.add(String.valueOf(numberOfCards));
                data.add(String.valueOf(maxMoney));
                UUID uuid = UUID.randomUUID();
                for (int i = 0; i < numberOfCards; i++){
                    priceListLine = _reader.readLine();
                    String cardName = priceListLine.split(" ")[0];
                    int cardValue = Integer.parseInt(priceListLine.split(" ")[1]);
                    data.add(cardName);
                    data.add(String.valueOf(cardValue));
                }
                if (!priceList.containsKey(uuid)){
                    priceList.put(uuid, data);
                }
                priceListLine = _reader.readLine();
            }
        } catch (IOException exceptionIn) {
            ExceptionHandler.handleException(exceptionIn, "Unable to locate/read from file : " + fileName);
        }
    }

    public HashMap<String, Integer> getMarketPrice() {
        return marketPrice;
    }

    public LinkedHashMap<UUID, List<String>> getPriceList() {
        return priceList;
    }
}
