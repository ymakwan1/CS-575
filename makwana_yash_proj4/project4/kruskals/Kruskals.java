package project4.kruskals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The `Kruskals` class in Java implements Kruskal's algorithm to generate the minimum spanning tree of
 * a graph and stores the resulting edges and weights in a matrix.
 */
public class Kruskals implements KruskalI{

    // These are instance variables of the `Kruskals` class in Java.
    private  int vertices;
    private int[] Set;
    private int[] height;
    private int[][] kruskalsGraph;
    private int[][] kruskalsMatrix;
    private List<int[]> edges = new ArrayList<int[]>();
    private List<int[]> MST = new ArrayList<int[]>();

    /*  This is a constructor for the `Kruskals` class that takes in two parameters: `verticesIn` and
     * `kruskalsGraphIn`. It initializes the instance variables `vertices`, `kruskalsGraph`, `Set`,
     * `height`, and `kruskalsMatrix`.
     */
    public Kruskals(int verticesIn, int[][] kruskalsGraphIn){
        vertices = verticesIn;
        kruskalsGraph = kruskalsGraphIn;
        Set = new int[vertices];
        height = new int[vertices];
        kruskalsMatrix = new int[vertices][vertices];
    }

    /**
     * This function generates the minimum spanning tree of a graph using Kruskal's algorithm and
     * stores the resulting edges and weights in a matrix.
     */
    @Override
    public void generateKruskalMST() {
        int count = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int ucomp = find3(u);
            int vcomp = find3(v);
            if (ucomp != vcomp) {
                MST.add(edge);
                union3(ucomp, vcomp);
                count++;
            }
            if (count == vertices - 1){
                break;
            }
        }
        for (int[] edge : MST) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            kruskalsMatrix[u][v] = w;
            kruskalsMatrix[v][u] = w;
        }
    }

    /**
     * This function prints the Kruskal's matrix and the minimum spanning tree (MST) obtained using
     * Kruskal's algorithm.
     */
    @Override
    public void printKruskals() {
        
        System.out.println("Kruskal's matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(" " + kruskalsMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Kruskal's MST");
        for (int[] edge: MST) {
            System.out.println("V" + (edge[0]+1) + "-V" + (edge[1]+1) + ": " + edge[2]);
        }
    }

    /**
     * The function initializes the set and height arrays with values for each vertex.
     */
    @Override
    public void initializeSetandHeight() {
        for (int i = 0; i < vertices; i++) {
            Set[i] = i;
            height[i] = 0;
        }
    }

    /**
     * This function initializes the edges of a graph and sorts them in ascending order based on their
     * weights.
     */
    @Override
    public void initializeEdges() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (kruskalsGraph[i][j] != 0){
                    int[] edge = {i,j,kruskalsGraph[i][j]};
                    edges.add(edge);

                }
            }
        }
       Collections.sort(edges, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               return o1[2] - o2[2];
           }
       });
    }

    /**
     * The function finds the root of a given node in a disjoint set data structure and performs path
     * compression.
     * 
     * @param xIn The input integer value for which we want to find the root node in a disjoint set.
     * @return The method is implementing the find operation in a disjoint-set data structure using
     * path compression. It returns the root of the set that contains the element with value xIn.
     */
    @Override
    public int find3(int xIn) {
        int root = xIn;
        while (root != Set[root]){
            root = Set[root];
        }
        int node = xIn;
        while (node != root){
            int parent = Set[node];
            Set[node] = root;
            node = parent;
        }
        return root;
    }

    /**
     * The function performs union operation on two sets using the union by rank heuristic.
     * 
     * @param repxIn The parameter repxIn represents the representative element of the first set that
     * needs to be merged.
     * @param repyIn repyIn is an integer variable representing the representative element of the
     * second set that needs to be merged with the first set.
     */
    @Override
    public void union3(int repxIn, int repyIn) {
        if (height[repxIn] == height[repyIn]){
            height[repxIn]++;
            Set[repyIn] = repxIn;
        } else if (height[repxIn] > height[repyIn]) {
            Set[repyIn] = repxIn;
        } else {
            Set[repxIn] = repyIn;
        }
    }
}