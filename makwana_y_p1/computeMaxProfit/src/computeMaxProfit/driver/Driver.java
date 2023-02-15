package computeMaxProfit.driver;

import computeMaxProfit.projectmanager.ProjectManager;
import computeMaxProfit.utils.ExceptionHandler;
public class Driver {
    public static void main(String[] args) {
        
        if (args.length != 4) {
            String errorMessage = "Error: Incorrect number of arguments. Program accepts 4 arguments.";
            ExceptionHandler.handleException(null, errorMessage);
        }
        ProjectManager projectManager = new ProjectManager(args[0], args[1], args[2], args[3]);
        projectManager.run();
    }
}