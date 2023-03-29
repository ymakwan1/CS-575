package project3.results;

import project3.floyds.Floyds;
import project3.floyds.FloydsI;
import project3.lcs.LCSInterface;

public class Results implements ResultsI{
    LCSInterface lcs;
    FloydsI floyds;

    public Results(LCSInterface lcsIn, FloydsI floydsIn){
        lcs = lcsIn;
        floyds = floydsIn;
    }

    @Override
    public void printLCS() {

    }

    @Override
    public void printFlyods() {

    }
}
