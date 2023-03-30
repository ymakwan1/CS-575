package project3.results;

import project3.floyds.Floyds;
import project3.floyds.FloydsI;
import project3.lcs.LCSInterface;

/**
 * It's a class that implements the ResultsI interface and has two class variables, one of type
 * LCSInterface and the other of type FloydsI. It has a constructor that takes in two interfaces and
 * sets them to the class variables. It has two functions, one that prints the length of the LCS and
 * the LCS itself and the other that prints the Floyd's shortest path
 */
public class Results implements ResultsI{
    LCSInterface lcs;
    FloydsI floyds;

    // A constructor that takes in two interfaces and sets them to the class variables.
    public Results(LCSInterface lcsIn, FloydsI floydsIn){
        lcs = lcsIn;
        floyds = floydsIn;
    }

    /**
     * The function prints the length of the LCS and the LCS itself
     */
    @Override
    public void printLCS() {
        System.out.print("Length of LCS : "+lcs.printSubStringLength()+"\n");
        System.out.print("LCS : "+lcs.printSubString());
    }

    /**
     * This function prints the Floyd's shortest path
     */
    @Override
    public void printFlyods() {
        floyds.printFloyd();
    }
}