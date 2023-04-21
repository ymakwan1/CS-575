package project5.projectManager;

import project5.bruteForce.BruteForce;
import project5.bruteForce.BruteForceI;
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
}
