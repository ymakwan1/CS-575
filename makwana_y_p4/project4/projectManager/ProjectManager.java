package project4.projectManager;

import java.util.Random;

import project4.prims.PrimsI;
import project4.prims.Prims;
import project4.kruskals.KruskalI;
import project4.kruskals.Kruskals;
import project4.results.Results;
import project4.results.ResultsI;
import project4.utils.ExceptionHandler;

public class ProjectManager implements ProjectManagerI{
    int[][] randomGraph;
    int vertices;
    public ProjectManager(){

    }

    @Override
    public void run(){
        System.out.println("Randomly selected "+generateRandomVertex(5, 10)+" vertices.");
        generateRandomGraph();
        printRandomGraph();
    }
    @Override
    public void runPrims(){
        PrimsI prims = new Prims(vertices, randomGraph);
//        int[][] adjacencyMatrix = {
//                {0, 5, 8, 7, 9},
//                {5, 0, 2, 8, 6},
//                {8, 2, 0, 7, 7},
//                {7, 8, 7, 0, 6},
//                {9, 6, 7, 6, 0}
//        };
//
//        PrimsI prims = new Prims(5, adjacencyMatrix);
        prims.generateMST();
        prims.printPrimsGraph();
        prims.printMST();
    }

    @Override
    public void runKruskals(){
        int[][] A = {{0, 1, 0, 1, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 2},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 2},
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 2, 2, 0, 0, 0, 0}};
        KruskalI kruskals = new Kruskals(10, A);
        //KruskalI kruskals = new Kruskals(vertices, randomGraph);
        kruskals.initializeSetandHeight();
        kruskals.initializeEdges();
        kruskals.generateKruskalMST();
        kruskals.printKruskals();
    }
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
    @Override
    public int generateRandomVertex(int min, int max){
        Random random = new Random();
        vertices =  random.nextInt((max-min)+1)+min;
        return vertices;
    }

    @Override
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
