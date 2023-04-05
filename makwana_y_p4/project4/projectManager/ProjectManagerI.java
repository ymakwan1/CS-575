package project4.projectManager;
// Defining an interface.
public interface ProjectManagerI {
    void runPrims();
    void runKruskals();
    int generateRandomVertex(int min, int max);
    int generateRandomWeight(int min, int max);
    void generateRandomGraph();
    void printRandomGraph();
    void run();
}
