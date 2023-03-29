package project3.driver;

import project3.projectManager.ProjectManager;
public class Driver{
    public static void main(String[] args) {
        System.out.println("**********PROJECT-3**********");
        ProjectManager projectManager = new ProjectManager(args);
        if (projectManager.validateInput()) {
            projectManager.run();
        } else {
            System.exit(0);
        }
        //projectManager.run();
    }
}