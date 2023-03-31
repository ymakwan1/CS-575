package project3.results;

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
    
    public Results(){
        
    }

    
    /**
     * This function prints the length of the LCS and the LCS itself
     * 
     * @param lcsIn The LCSInterface object that contains the LCS information.
     */
    @Override
    public void printLCS(LCSInterface lcsIn) {
        System.out.print("Length of LCS : "+lcsIn.printSubStringLength()+"\n");
        System.out.print("LCS : "+lcsIn.printSubString()+"\n");
    }

    
    /**
     * This function prints the floyd's triangle.
     * 
     * @param floydsIn The FloydsI object that will be printed.
     */
    @Override
    public void printFlyods(FloydsI floydsIn) {
        floydsIn.printFloyd();
    }
}