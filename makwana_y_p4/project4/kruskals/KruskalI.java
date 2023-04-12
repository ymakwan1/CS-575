package project4.kruskals;
/* 
* This is a Java interface named `KruskalI` that defines a set of methods that must be implemented by
* any class that implements this interface. The methods defined in this interface are related to the
* Kruskal's algorithm for finding the minimum spanning tree of a graph.
*/
public interface KruskalI {
    void generateKruskalMST();
    void printKruskals();
    void initializeSetandHeight();
    void initializeEdges();
    int find3(int x);
    void union3(int repx, int repy);
}