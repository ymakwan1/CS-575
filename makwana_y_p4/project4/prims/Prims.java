package project4.prims;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * The Prims class implements Prim's algorithm to generate a minimum spanning tree for a given graph
 * and provides methods to print the MST and Prim's matrix.
 */
public class Prims implements PrimsI{
    private int vertices;
    private int [][] primsGraph;
    private int [] mst;
    private int [] cost;
    private boolean [] visited;
    int[][] primMST;

    /*  
    * This is a constructor for the Prims class that takes in the number of vertices and a 2D array
    * representing the graph. It initializes the instance variables vertices and primsGraph with the
    * input parameters, and creates a new 2D array primMST with the same number of vertices as the
    * input graph.
    */
    public Prims(int verticesIn, int[][] primsGraphIn){
        vertices = verticesIn;
        primsGraph = primsGraphIn;
        primMST = new int[vertices][vertices];
    }

    /**
     * This function generates a minimum spanning tree using Prim's algorithm.
     */
    @Override
    public void generateMST() {
        mst = new int[vertices];
        cost = new int[vertices];
        visited = new boolean[vertices];

        Arrays.fill(cost, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        PriorityQueue<MSTNode> priorityQueue = new PriorityQueue<MSTNode>();
        priorityQueue.add(new MSTNode(0, 0));

        cost[0] = 0;

        while (!priorityQueue.isEmpty()){
            int u = priorityQueue.poll().vertex;
            visited[u] = true;
            for (int v = 0; v < vertices; v++) {
                if (primsGraph[u][v] != 0 && visited[v]==false && primsGraph[u][v] < cost[v]){
                    cost[v] = primsGraph[u][v];
                    mst[v] = u;
                    priorityQueue.add(new MSTNode(v, cost[v]));
                }
            }
        }

        for (int i = 1; i < vertices; i++) {
            primMST[mst[i]][i] = primsGraph[i][mst[i]];
            primMST[i][mst[i]] = primsGraph[i][mst[i]];
        }
    }

    /**
     * The MSTNode class is a Java implementation of a node used in a minimum spanning tree algorithm,
     * with a vertex and key value, and a compareTo method for comparing nodes based on their key
     * values.
     */
    private static class MSTNode implements Comparable<MSTNode> {
        int vertex;
        int key;
        public MSTNode(int vertexIn, int keyIn){
            vertex = vertexIn;
            key = keyIn;
        }

        @Override
        public int compareTo(MSTNode otherNode) {
            return Integer.compare(key, otherNode.key);
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
     * This function prints the minimum spanning tree (MST) of a graph using Prim's algorithm.
     */
    @Override
    public void printMST() {
        System.out.println("\nPrim's MST:");
        for (int i = 1; i < vertices; i++) {
            System.out.printf("V%d-V%d: %d\n", mst[i] + 1, i + 1, primsGraph[i][mst[i]]);
        }
    }
}
