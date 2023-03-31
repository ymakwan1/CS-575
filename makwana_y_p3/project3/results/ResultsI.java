package project3.results;

import project3.floyds.FloydsI;
import project3.lcs.LCSInterface;

// Defining an interface.
public interface ResultsI {
    public void printLCS(LCSInterface lcsIn);
    public void printFlyods(FloydsI floydsIn);
}
