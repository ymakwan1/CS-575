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


    
    /**
     * The run() function is the main function of the program. It creates an instance of the LCS class,
     * the Floyds class, and the Results class. It then calls the generateSubString() function from the
     * LCS class, and the makeFloyd() function from the Floyds class. It then calls the printLCS() and
     * printFlyods() functions from the Results class
     */
    @Override
    public void run() {
        LCSInterface lcs = new LCS(args);
        FloydsI floyds = new Floyds();
        ResultsI results = new Results(lcs, floyds);
        System.out.println("----------Longest Common Subsequence---------");
        lcs.generateSubString();
        results.printLCS();

        System.out.println();
        System.out.println("\n----------Floyd's Algorithm---------\n");
        
        floyds.makeFloyd();
        results.printFlyods();
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
