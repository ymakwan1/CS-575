package project4.projectManager;
// Defining an interface.
public interface ProjectManagerI {
    void runPrims();
    void runKruskals();
    int generateRandomVertex(int min, int max);
    int[][] generateRandomGraph(int vertex);
    void printRandomGraph();
}
