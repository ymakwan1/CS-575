package project3.projectManager;

import project3.floyds.Floyds;
import project3.floyds.FloydsI;
import project3.lcs.LCS;
import project3.lcs.LCSInterface;
import project3.utils.ExceptionHandler;
import project3.results.Results;
import project3.results.ResultsI;

/**
 * The main class of the project. It is the first class to be called when the program is executed
 */
public class ProjectManager implements ProjectManagerI {
    private String[] args;
    // A constructor. It is called when an object of the class is created.
    public ProjectManager(String[] argsIn) {
        args = argsIn;
    }
    
    public ProjectManager(){

    }


    
    /**
     * This function runs the Floyd's algorithm and prints the results
     */
    @Override
    public void runFloyds(){
        FloydsI floyds = new Floyds();
        ResultsI results = new Results();
        System.out.println("\n----------Floyd's Algorithm---------\n");
        floyds.makeFloyd();
        results.printFlyods(floyds);
    }

    /**
     * The function runLCS() is called from the main function in the Driver class. It creates an object
     * of the LCS class and calls the generateSubString() function to generate the longest common
     * subsequence. The results are then printed using the printLCS() function
     */
    @Override
    public void runLCS() {
        LCSInterface lcs = new LCS(args);
        ResultsI results = new Results();
        System.out.println("----------Longest Common Subsequence---------");
        lcs.generateSubString();
        results.printLCS(lcs);
    }

    /**
     * It checks if the input is valid or not
     * 
     * @return The method returns a boolean value.
     */
    @Override
    public Boolean validateInput(){
        boolean flag = true;
        if (args.length < 2) {
            ExceptionHandler.handleException(null, "Invalid no. of input. Need 2 strings as input.");
        } else if (args.length > 2) {
            ExceptionHandler.handleException(null, "-1 \nInput size more than 2.");
            flag = false;
        } else if (args[0].length() > 100 || args[1].length() > 100) {
            ExceptionHandler.handleException(null, "-2 \nInput has more than 100 characters.");
            flag = false;
        }
        return flag;
    }
}
