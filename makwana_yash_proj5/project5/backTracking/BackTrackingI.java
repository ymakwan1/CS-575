package project5.backTracking;
/* 
* This is a Java interface named `BackTrackingI` that declares three methods: `initializeFile()`,
* `knapSackSolver()`, and `writeToFile()`. Any class that implements this interface must provide
* implementations for these three methods. The purpose of this interface is to define a contract for
* classes that perform backtracking algorithms related to the knapsack problem and require these three
* methods to be implemented.
*/

public interface BackTrackingI {
    void initializeFile();
    void knapSackSolver();
    void writeToFile();
}