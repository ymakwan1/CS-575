package project5.dynamicProgramming;

import java.io.File;

import project5.projectManager.ProjectManager;
import project5.projectManager.ProjectManagerI;
import project5.utils.ExceptionHandler;

/**
 * This Java class runs a dynamic programming algorithm on a knapsack problem specified in a text file.
 */
public class DynamicProgrammingDriver {
    public static void main(String[] args) {
        if (args.length < 1) {
            ExceptionHandler.handleException(null, "Usage : java project5/dynamicProgramming/DynamicProgrammingDriver knapsack01.txt");
        }

        String relativePathCheck = args[0];
        File file = new File(relativePathCheck);
        if (!file.exists()) {
            ExceptionHandler.handleException(null, "File does not exist");
        }

        ProjectManagerI projectManager = new ProjectManager(relativePathCheck);
        projectManager.runDynamicProgramming();
    }
}