package project3.floyds;

import java.util.Arrays;
import java.util.Random;

public class Floyds implements FloydsI {
    private int[][] adjacencyMatrix;
    private int[][] shortestPathFloydsMatrix;
    private int vertices;
    public Floyds(){
        vertices = getRandomNumberInRange(5,10);
        adjacencyMatrix = new int[vertices][vertices];
        shortestPathFloydsMatrix = new int[vertices][vertices];
        createMatrix();

        System.out.println("----------Adjacency Matrix---------");
        printFloydMatrix(adjacencyMatrix);

        shortestPathFloydsMatrix = Arrays.copyOf(adjacencyMatrix, adjacencyMatrix.length);
        System.out.println();

        System.out.println("----------Shortest Paths Matrix---------");
        printFloydMatrix(floyd(shortestPathFloydsMatrix));
    }

    private void createMatrix(){
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (i==j){
                    adjacencyMatrix[i][j] = 0;
                } else {
                    int positionWeight = getRandomNumberInRange(1, 10);
                    adjacencyMatrix[i][j] = positionWeight;
                    adjacencyMatrix[j][i] = positionWeight;
                }
            }
        }
    }
    @Override
    public int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max-min)+1)+min;
    }

    @Override
    public void printFloydMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    @Override
    public int[][] floyd(int[][] shortestPathFloydsMatrixIn) {
        for (int k = 0; k < shortestPathFloydsMatrixIn.length; k++) {
            for (int i = 0; i < shortestPathFloydsMatrixIn.length; i++) {
                for (int j = 0; j < shortestPathFloydsMatrixIn.length; j++) {
                    if (shortestPathFloydsMatrixIn[i][k] + shortestPathFloydsMatrixIn[k][j] < shortestPathFloydsMatrixIn[i][j]){
                        shortestPathFloydsMatrixIn[i][j] = shortestPathFloydsMatrixIn[i][k] + shortestPathFloydsMatrixIn[j][k];
                    }
                }
            }
        }
        return shortestPathFloydsMatrixIn;
    }
}
