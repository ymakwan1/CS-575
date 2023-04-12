package project4.projectManager;

import java.util.Random;

import project4.prims.PrimsI;
import project4.prims.Prims;
import project4.kruskals.KruskalI;
import project4.kruskals.Kruskals;


/**
 * The ProjectManager class generates a random graph with a random number of vertices and runs Prim's
 * and Kruskal's algorithms on it to find the minimum spanning tree.
 */
public class ProjectManager implements ProjectManagerI{
    int[][] randomGraph;
    int vertices;

    public ProjectManager(){

    }

    /**
     * This function generates a random graph with a random number of vertices and prints it.
     */
    @Override
    public void run(){
        System.out.println("Randomly selected "+generateRandomVertex(5, 10)+" vertices.");
        generateRandomGraph();
        printRandomGraph();
    }

    /**
     * This function runs Prim's algorithm on a given graph and prints the resulting minimum spanning
     * tree.
     */
    @Override
    public void runPrims(){
        PrimsI prims = new Prims(vertices, randomGraph);
        prims.generateMST();
        prims.printPrimsGraph();
        prims.printMST();
    }

    
    /* 
    * This method is running the Kruskal's algorithm on the randomly generated graph. It creates an
    * instance of the `Kruskals` class with the number of vertices and the random graph as parameters.
    * It then initializes the set and height of each vertex, initializes the edges of the graph,
    * generates the minimum spanning tree using Kruskal's algorithm, and finally prints the minimum
    * spanning tree.
    */
    @Override
    public void runKruskals(){
        KruskalI kruskals = new Kruskals(vertices, randomGraph);
        kruskals.initializeSetandHeight();
        kruskals.initializeEdges();
        kruskals.generateKruskalMST();
        kruskals.printKruskals();
    }

    /**
     * This Java function generates a random graph with weights between 1 and 10 for each edge.
     */
    @Override
    public void generateRandomGraph(){
        randomGraph = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = i+1; j < vertices; j++) {
                int positionWeight = generateRandomWeight(1, 10);
                randomGraph[i][j] = positionWeight;
                randomGraph[j][i] = positionWeight;
            }
        }
    }

    /**
     * This Java function generates a random integer between a given minimum and maximum value.
     * 
     * @param min The minimum value that the generated random vertex can have.
     * @param max The maximum value that the generated random vertex can have.
     * @return The method is returning an integer value which is the randomly generated vertex between
     * the minimum and maximum values provided as parameters.
     */
    @Override
    public int generateRandomVertex(int min, int max){
        Random random = new Random();
        vertices =  random.nextInt((max-min)+1)+min;
        return vertices;
    }

    @Override
    /*
    * This method generates a random integer weight between the minimum and maximum values (inclusive)
    * specified as parameters using the `Random` class in Java. 
    * @return the generated weight as an integer.
    */
    public int generateRandomWeight(int min, int max) {
        Random random = new Random();
        return random.nextInt((max-min)+1)+min;
    }

    @Override
    public void printRandomGraph(){
        System.out.println("\nRandom Matrix:");
        for (int[] row : randomGraph) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}