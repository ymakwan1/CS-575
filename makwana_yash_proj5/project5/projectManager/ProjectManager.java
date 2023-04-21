package project5.projectManager;

import project5.backTracking.BackTracking;
import project5.backTracking.BackTrackingI;
import project5.bruteForce.BruteForce;
import project5.bruteForce.BruteForceI;
import project5.dynamicProgramming.DynamicProgramming;
import project5.dynamicProgramming.DynamicProgrammingI;
import project5.fileProcessor.FileProcessor;
import project5.fileProcessor.FileProcessorI;

public class ProjectManager implements ProjectManagerI{

    private String filePath;
    FileProcessorI fileProcessor;
    public ProjectManager(String filePathIn){
        filePath = filePathIn;
        fileProcessor = new FileProcessor(filePath);
    }

    @Override
    public void runBruteForce() {
        BruteForceI bruteForce = new BruteForce(fileProcessor);
        bruteForce.initializeFile();
        bruteForce.knapSackSolver();
        bruteForce.writeToFile();
    }

    @Override
    public void runDynamicProgramming() {
        DynamicProgrammingI dynamicProgramming = new DynamicProgramming(fileProcessor);
        dynamicProgramming.initializeFile();
        dynamicProgramming.knapSackSolver();
        dynamicProgramming.writeToFile();
    }

    @Override
    public void runBackTracking() {
        BackTrackingI backTracking = new BackTracking(fileProcessor);
        backTracking.initializeFile();
        backTracking.knapSackSolver();;
        backTracking.writeToFile();
    }
}