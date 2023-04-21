package project4.prims;

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * The `Prims` class is a Java implementation of Prim's algorithm for generating a minimum spanning
 * tree of a graph.
 */
public class Prims implements PrimsI{
    private int vertices;
    private int [][] primsGraph;
    private int [] cost;
    private boolean [] visited;
    private int[][] primMST;
    private StringBuilder stringBuilder = new StringBuilder();

    // This is a constructor for the `Prims` class that takes in the number of vertices and a 2D array
    // representing the graph. It initializes the `vertices` and `primsGraph` variables with the input
    // values, and creates a new 2D array `primMST` with the same number of vertices.
    public Prims(int verticesIn, int[][] primsGraphIn){
        vertices = verticesIn;
        primsGraph = primsGraphIn;
        primMST = new int[vertices][vertices];
    }

    /**
     * The function generates a minimum spanning tree using Prim's algorithm.
     */
    @Override
    public void generateMST() {
        cost = new int[vertices];
        visited = new boolean[vertices];

        Arrays.fill(cost, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        PriorityQueue<MSTNode> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new MSTNode(0, 0, 0));

        cost[0] = 0;

        while (!priorityQueue.isEmpty()){

            int nodeSource = priorityQueue.peek().source;
            int nodeDestination = priorityQueue.peek().destination;
            int nodeWeight = priorityQueue.peek().weight;
            priorityQueue.remove();

            if(visited[nodeDestination]){
                continue;
            }
            visited[nodeDestination] = true;

            if (nodeWeight != 0) {
                stringBuilder.append("V"+(nodeSource+1)+"- V" + (nodeDestination+1)+": \t"+nodeWeight).append("\n");
                primMST[nodeSource][nodeDestination] = nodeWeight;
                primMST[nodeDestination][nodeSource] = nodeWeight;
            }

            for (int index = 0; index < vertices; index++) {
                int edgeWeight = primsGraph[nodeDestination][index];
                if (visited[index] == false) {
                    priorityQueue.add(new MSTNode(nodeDestination, index, edgeWeight));
                }
            }
        }
    }

    /**
     * The MSTNode class represents a node in a minimum spanning tree and implements the Comparable
     * interface to compare nodes based on their weights.
     */
    private static class MSTNode implements Comparable<MSTNode> {
        int source;
        int destination;
        int weight;
        public MSTNode(int sourceIn, int destinationIn, int weightIn){
            source = sourceIn;
            destination = destinationIn;
            weight = weightIn;
        }
        @Override
        public int compareTo(MSTNode other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    /**
     * This function prints out the Prim's matrix for a given graph.
     */
    public void printPrimsGraph(){
        System.out.println("\nPrim's matrix:\n");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(primMST[i][j]+"\t");
            }
            System.out.println();
        }
    }

    /**
     * This function prints the minimum spanning tree using Prim's algorithm.
     */
    @Override
    public void printMST() {
        System.out.println("\nPrim's MST:");
        System.out.println(stringBuilder.toString());
    }
}