package project3.lcs;

import project3.projectManager.ProjectManager;
import project3.projectManager.ProjectManagerI;


/**
 * The LCSDriver class is the main class that runs the LCS program
 */
public class LCSDriver {
    public static void main(String[] args) {
        ProjectManagerI projectManager = new ProjectManager(args);
        if (projectManager.validateInput()) {
            projectManager.runLCS();
        } else {
            System.exit(0);
        }
    }
}