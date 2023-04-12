package project4.driver;

import project4.utils.ExceptionHandler;
import project4.projectManager.ProjectManager;
import project4.projectManager.ProjectManagerI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * The Driver class takes user input to run either Prims or Kruskals algorithm on a project managed by
 * ProjectManager.
 */
public class Driver {
    public static void main(String[] args) {
        /*  This code block is the main method of the Driver class. It creates an instance of the
         * ProjectManager class, which manages a project and its tasks. It then prompts the user to
         * choose between running Prim's algorithm or Kruskal's algorithm on the project. The user's
         * input is read from the console using a BufferedReader. Depending on the user's input, the
         * appropriate algorithm is run on the project using the ProjectManager's methods runPrims() or
         * runKruskals(). If the user enters an invalid input, an exception is thrown and handled by
         * the ExceptionHandler class.
        */
        try {
            ProjectManagerI projectManager = new ProjectManager();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            projectManager.run();

            System.out.print("\nEnter 1 for Prims and 2 for Kruskals : \n");
            int algoInput = Integer.parseInt(bufferedReader.readLine());
            if (algoInput == 1) {
                projectManager.runPrims();
            } else if (algoInput == 2) {
                projectManager.runKruskals();
            } else {
                ExceptionHandler.handleException(null, "Wrong Input. Please run the program again!");
            }

        } catch (Exception e) {
            ExceptionHandler.handleException(e, "IO Exception occurred.\nPlease enter input as instructed.");
        }
    }
}