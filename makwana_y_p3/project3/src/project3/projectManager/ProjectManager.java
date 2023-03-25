package project3.projectManager;

import project3.floyds.Floyds;
import project3.floyds.FloydsI;
import project3.lcs.LCS;
import project3.lcs.LCSInterface;

public class ProjectManager implements ProjectManagerI {
    String[] args;
    public ProjectManager(String[] argsIn) {
        args = argsIn;
    }


    @Override
    public void run() {
        LCSInterface lcs = new LCS(args);
        FloydsI flyods = new Floyds();
    }
}
