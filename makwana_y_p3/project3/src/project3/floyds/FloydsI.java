package project3.floyds;

public interface FloydsI {
    int getRandomNumberInRange(int min, int max);
    void printFloydMatrix(int[][] matrix);
    int[][] floyd(int[][] adjacencyMatrix);
}
