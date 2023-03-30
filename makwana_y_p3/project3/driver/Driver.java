package project3.driver;

import project3.projectManager.ProjectManager;
/**
 * It takes in the command line arguments, validates them, and then runs the project
 */
public class Driver{
    public static void main(String[] args) {
        System.out.println("**********PROJECT-3**********\n");
        ProjectManager projectManager = new ProjectManager(args);
        if (projectManager.validateInput()) {
            projectManager.run();
        } else {
            System.exit(0);
        }
    }
}