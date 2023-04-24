package project5.projectManager;

import project5.backTracking.BackTracking;
import project5.backTracking.BackTrackingI;
import project5.bruteForce.BruteForce;
import project5.bruteForce.BruteForceI;
import project5.dynamicProgramming.DynamicProgramming;
import project5.dynamicProgramming.DynamicProgrammingI;
import project5.fileProcessor.FileProcessor;
import project5.fileProcessor.FileProcessorI;

/**
 * The ProjectManager class implements ProjectManagerI and runs different algorithms to solve the
 * knapsack problem and write the results to a file.
 */
public class ProjectManager implements ProjectManagerI{

    private String filePath;
    FileProcessorI fileProcessor;
    public ProjectManager(String filePathIn){
        filePath = filePathIn;
        fileProcessor = new FileProcessor(filePath);
    }

    /**
     * This function runs a brute force algorithm to solve the knapsack problem using a file processor.
     */
    @Override
    public void runBruteForce() {
        BruteForceI bruteForce = new BruteForce(fileProcessor);
        bruteForce.initializeFile();
        bruteForce.knapSackSolver();
        bruteForce.writeToFile();
    }

    /**
     * This function runs a dynamic programming algorithm to solve the knapsack problem and writes the
     * results to a file.
     */
    @Override
    public void runDynamicProgramming() {
        DynamicProgrammingI dynamicProgramming = new DynamicProgramming(fileProcessor);
        dynamicProgramming.initializeFile();
        dynamicProgramming.knapSackSolver();
        dynamicProgramming.writeToFile();
    }

    /**
     * This function runs a knapsack solver using backtracking algorithm and writes the result to a
     * file.
     */
    @Override
    public void runBackTracking() {
        BackTrackingI backTracking = new BackTracking(fileProcessor);
        backTracking.initializeFile();
        backTracking.knapSackSolver();;
        backTracking.writeToFile();
    }
}