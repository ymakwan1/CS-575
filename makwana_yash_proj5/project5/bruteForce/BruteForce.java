package project5.bruteForce;

import project5.utils.ExceptionHandler;

public class BruteForce {
    public static void main(String[] args) {
        if (args.length < 1) {
            ExceptionHandler.handleException(null, "Usage : java project5/bruteForce/BruteForce knapsack01.txt");
        }
        //TODO - Check if file exists, if not raise exception and ask to run createFile
    }
}
