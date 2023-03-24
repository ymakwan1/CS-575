package project3.utils;

public class ExceptionHandler {

    //public static Results errorLogProcessor;
    public static void handleException(Exception exceptionIn, String errorMessageIn){
        String errorMessage;
        if (errorMessageIn.isEmpty()){
            errorMessage = exceptionIn.getMessage();
        }else {
            errorMessage = errorMessageIn;
        }

        String errorString = "EXCEPTION : " + errorMessage;

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

