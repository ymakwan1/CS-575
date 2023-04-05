package project4.prims;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Prims implements PrimsI{
    private int vertices;
    private int [][] primsGraph;
    private int [] mst;
    private int [] cost;
    private boolean [] visited;
    int[][] primMST;
    public Prims(int verticesIn, int[][] primsGraphIn){
        vertices = verticesIn;
        primsGraph = primsGraphIn;
         primMST = new int[vertices][vertices];
    }

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
    public void printPrimsGraph(){
        System.out.println("\nPrim's matrix:\n");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(primMST[i][j]+"\t");
            }
            System.out.println();
        }
    }
    @Override
    public void printMST() {
        System.out.println("\nPrim's MST:");
        for (int i = 1; i < vertices; i++) {
            System.out.printf("V%d-V%d: %d\n", mst[i] + 1, i + 1, primsGraph[i][mst[i]]);
        }
    }
}
