package computeMaxProfit.driver;

import computeMaxProfit.projectmanager.ProjectManager;

public class Driver {
    public static void main(String[] args) {
        
        ProjectManager projectManager = new ProjectManager(args[0], args[1], args[2], args[3]);
        projectManager.run();
    }
}