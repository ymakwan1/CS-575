package project4.kruskals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskals implements KruskalI{

    private  int vertices;
    private int[] Set;
    private int[] height;
    private int[][] kruskalsGraph;
    private List<int[]> edges = new ArrayList<int[]>();
    private List<int[]> MST = new ArrayList<int[]>();
    public Kruskals(int verticesIn, int[][] kruskalsGraphIn){
        vertices = verticesIn;
        kruskalsGraph = kruskalsGraphIn;
        Set = new int[vertices];
        height = new int[vertices];
    }
    @Override
    public void generateKruskalMST() {
        int count = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
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
    }

    @Override
    public void printKruskals() {
        System.out.println("Kruskal's MST");
        for (int[] edge: MST) {
            System.out.println("V" + (edge[0]+1) + "-V" + (edge[1]+1) + ": " + edge[2]);
        }
    }

    @Override
    public void initializeSetandHeight() {
        for (int i = 0; i < vertices; i++) {
            Set[i] = i;
            height[i] = 0;
        }
    }

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
//        Collections.sort(edges, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[2] - o2[2];
//            }
//        });
    }

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
