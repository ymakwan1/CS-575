package project4.utils;

import project4.results.Results;

/**
 * It handles exceptions
 */
public class ExceptionHandler {

    public static Results errorLogProcessor;
    /**
     * It handles exceptions.
     * 
     * @param exceptionIn The exception that was thrown.
     * @param errorMessageIn This is the error message that you want to display.
     */
    public static void handleException(Exception exceptionIn, String errorMessageIn){
        String errorMessage;
        if (errorMessageIn.isEmpty()){
            errorMessage = exceptionIn.getMessage();
        }else {
            errorMessage = errorMessageIn;
        }

        String errorString = "Error Message : " + errorMessage;

        if (errorLogProcessor != null) {
            //errorLogProcessor.writeToConsole(errorString);
        }else {
            System.out.println(errorString);
        }

        if (exceptionIn != null){
            exceptionIn.printStackTrace();
        }
        System.exit(1);
    }
}