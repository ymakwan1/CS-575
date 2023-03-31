package project3.floyds;

import project3.projectManager.ProjectManager;
import project3.projectManager.ProjectManagerI;

/**
 * It runs the Floyd's algorithm on the graph
 */
public class FloydsDriver {
    public static void main(String[] args){
        ProjectManagerI projectManager = new ProjectManager();
        projectManager.runFloyds();
    }
}