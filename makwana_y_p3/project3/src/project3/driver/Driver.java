package project3.driver;

import project3.projectManager.ProjectManager;
import project3.projectManager.ProjectManagerI;
import project3.utils.ExceptionHandler;

public class Driver{
    public static void main(String[] args) {
        System.out.println("**********PROJECT-3**********");
        if (args.length > 2){
            ExceptionHandler.handleException(null, "Wrong number of arguments!");
            System.exit(0);
        }
        ProjectManagerI projectManager = new ProjectManager(args);
        projectManager.run();
    }
}