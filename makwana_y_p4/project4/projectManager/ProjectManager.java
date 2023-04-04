package project4.projectManager;

import java.util.Random;

public class ProjectManager implements ProjectManagerI{
    int[][] randomGraph;
    public ProjectManager(){

    }

    public void runPrims(){

    }

    public void runKruskals(){

    }

    public int[][] generateRandomGraph(int vertexIn){
        randomGraph = new int[vertexIn][vertexIn];
        for (int i = 0; i < vertexIn; i++) {
            for (int j = i+1; j < vertexIn; j++) {
                int positionWeight = generateRandomVertex(1, 10);
                randomGraph[i][j] = positionWeight;
                randomGraph[j][i] = positionWeight;
            }
        }
        return randomGraph;
    }

    public int generateRandomVertex(int min, int max){
        Random random = new Random();
        return random.nextInt((max-min)+1)+min;
    }
    
    public void printRandomGraph(){
        for (int[] row : randomGraph) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
