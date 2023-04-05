package project4.driver;

import project4.utils.ExceptionHandler;
import project4.projectManager.ProjectManager;
import project4.projectManager.ProjectManagerI;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Driver {
    public static void main(String[] args) {
        try {
            ProjectManagerI projectManager = new ProjectManager();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            projectManager.run();

            System.out.print("\nEnter 1 for Prims and 2 for Kruskals : \n");
            int algoInput = Integer.parseInt(bufferedReader.readLine());
            //int algoInput = 1;
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