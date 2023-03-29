package project3.projectManager;

import project3.floyds.Floyds;
import project3.floyds.FloydsI;
import project3.lcs.LCS;
import project3.lcs.LCSInterface;
import project3.utils.ExceptionHandler;

public class ProjectManager implements ProjectManagerI {
    String[] args;
    public ProjectManager(String[] argsIn) {
        args = argsIn;
    }


    @Override
    public void run() {
        System.out.println("----------Longest Common Subsequence---------");
        LCSInterface lcs = new LCS(args);
        System.out.println();
        System.out.println("----------Floyd's Algorithm---------");
        FloydsI floyds = new Floyds();
    }

    @Override
    public Boolean validateInput(){
        boolean flag = true;
        if (args.length > 2) {
            ExceptionHandler.handleException(null, "Error! \n Input size more than 2");
            flag = false;
        }
        return flag;
    }
}
