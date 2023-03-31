package project3.floyds;

import java.util.Arrays;
import java.util.Random;

/**
 * It creates a random number of vertices between 5 and 10, then creates a matrix of size vertices x
 * vertices and fills it with random numbers between 1 and 10. It then uses the floyd algorithm to find
 * the shortest path between all pairs of vertices
 */
public class Floyds implements FloydsI {
    private int[][] adjacencyMatrix;
    private int[][] shortestPathFloydsMatrix;
    private int[][] path;
    private int vertices;

    // This is the constructor for the class. It creates a random number of vertices between 5 and 10.
    // It then creates two matrices of size vertices x vertices.
    public Floyds(){
        vertices = getRandomNumberInRange(5,10);
        adjacencyMatrix = new int[vertices][vertices];
        shortestPathFloydsMatrix = new int[vertices][vertices];
    }

    /**
     * The function creates an adjacency matrix, then uses the floyd algorithm to find the shortest
     * path between all pairs of vertices
     */
    @Override
    public void makeFloyd(){
        initializePathMatrix();
        createMatrix();

        // System.out.println("----------Adjacency Matrix---------");
        // printFloydMatrix(adjacencyMatrix);

        shortestPathFloydsMatrix = Arrays.copyOf(adjacencyMatrix, adjacencyMatrix.length);
        System.out.println();
        floyd(shortestPathFloydsMatrix);
        System.out.println("----------Adjacency Matrix---------");
        printFloydMatrix(shortestPathFloydsMatrix);
        System.out.println();
        System.out.println("----------Shortest Paths Matrix---------");
        //printFloydMatrix(floyd(shortestPathFloydsMatrix));
        
        printFloydMatrixP(path);

        // System.out.println();
        // System.out.println("----------All Pair Shortest Paths---------");
        // printAllPairShortestPaths(path, shortestPathFloydsMatrix);
    }

    @Override
    public void printFloyd(){
        System.out.println();
        System.out.println("----------All Pair Shortest Paths---------");
        printAllPairShortestPaths(path, shortestPathFloydsMatrix);
    }

    /**
     * The path matrix is initialized to -1
     */
    private void initializePathMatrix(){
        path = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                path[i][j] = -1;
            }
        }
    }
    /**
     * The function creates a matrix of size vertices x vertices and fills it with random numbers
     * between 1 and 10
     */
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

    /**
     * It returns a random number between min and max.
     * 
     * @param min The minimum number that can be generated.
     * @param max The maximum number of the range.
     * @return A random number between min and max.
     */
    private int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max-min)+1)+min;
    }

    /**
     * It prints the matrix
     * 
     * @param matrix The matrix that contains the shortest path between each pair of vertices.
     */
    private void printFloydMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    private void printFloydMatrixP(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print((matrix[i][j]+1)+"\t");
            }
            System.out.println();
        }
    }

    /**
     * For each vertex k, for each pair of vertices (i, j), if the path from i to k to j is shorter
     * than the current shortest path from i to j, update the shortest path from i to j to be the path
     * from i to k to j
     * 
     * @param shortestPathFloydsMatrixIn This is the matrix that contains the shortest path between
     * each pair of vertices.
     * @return The shortest path between two nodes.
     */
    //private int[][] floyd(int[][] shortestPathFloydsMatrixIn) 
    private void floyd(int[][] shortestPathFloydsMatrixIn){

        for (int k = 0; k < shortestPathFloydsMatrixIn.length; k++) {
            for (int i = 0; i < shortestPathFloydsMatrixIn.length; i++) {
                for (int j = 0; j < shortestPathFloydsMatrixIn.length; j++) {
                    if (shortestPathFloydsMatrixIn[i][k] + shortestPathFloydsMatrixIn[k][j] < shortestPathFloydsMatrixIn[i][j]){
                        shortestPathFloydsMatrixIn[i][j] = shortestPathFloydsMatrixIn[i][k] + shortestPathFloydsMatrixIn[j][k];
                        path[i][j] = k;
                    }
                }
            }
        }
        //return shortestPathFloydsMatrixIn;
    }

    /**
     * This function prints the shortest path from vertex i to vertex j
     * 
     * @param pathIn This is the 2D array that contains the shortest path from each vertex to every
     * other vertex.
     * @param shortestPathFloydsMatrixIn This is the matrix that contains the shortest path between any
     * two vertices.
     */
    private void printAllPairShortestPaths(int[][] pathIn, int[][] shortestPathFloydsMatrixIn) {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (i!=j){
                    System.out.print("Shortest Path from "+(i+1)+" to "+(j+1)+": ");
                    printPath(i, j, pathIn);
                    System.out.println(" (length " + shortestPathFloydsMatrixIn[i][j] + ")");
                } else {
                    System.out.print("Shortest Path from "+(i+1)+" to "+(j+1)+": ");
                    System.out.println(" (length " + shortestPathFloydsMatrixIn[i][j] + ")");
                }
            }
            System.out.println();
        }
    }

    /**
     * If the path matrix at the current i and j is -1, then print the current i and j. Otherwise,
     * recursively call the function with the current i and the path matrix at the current i and j.
     * Then print the current j
     * 
     * @param iIn the current row
     * @param jIn the column of the matrix
     * @param pathIn The path matrix that was created in the floydWarshall method.
     */
    private void printPath(int iIn, int jIn, int[][] pathIn){
        if (pathIn[iIn][jIn] == -1) {
            System.out.print((iIn+1) + " -> " + (jIn+1));
        } else {
            printPath(iIn, pathIn[iIn][jIn], pathIn);
            System.out.print(" -> " + (jIn+1));
        }
    }
}
