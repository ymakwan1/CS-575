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
        lcs.generateSubString();
        System.out.print("Length of LCS : "+lcs.printSubStringLength()+"\n");
        System.out.print("LCS : "+lcs.printSubString());

        System.out.println();
        System.out.println("\n----------Floyd's Algorithm---------\n");
        FloydsI floyds = new Floyds();
        floyds.makeFloyd();
        
    }

    @Override
    public Boolean validateInput(){
        boolean flag = true;
        if (args.length < 2) {
            ExceptionHandler.handleException(null, "Invalid no. of input. Need 2 strings as input.");
        } else if (args.length > 2) {
            ExceptionHandler.handleException(null, "-1 \nInput size more than 2.");
            flag = false;
        } else if (args[0].length() > 100 || args[1].length() > 100) {
            ExceptionHandler.handleException(null, "-2 \nInput has more than 100 characters.");
            flag = false;
        }
        return flag;
    }
}
