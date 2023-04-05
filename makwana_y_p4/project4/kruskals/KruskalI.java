package project4.kruskals;
public interface KruskalI {
    void generateKruskalMST();
    void printKruskals();
    void initializeSetandHeight();
    void initializeEdges();
    int find3(int x);
    void union3(int repx, int repy);
}
