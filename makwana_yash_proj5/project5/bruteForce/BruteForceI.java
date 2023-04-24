package project5.bruteForce;

/*  This is a Java interface named `BruteForceI` that declares three methods: `knapSackSolver()`,
* `initializeFile()`, and `writeToFile()`. Any class that implements this interface must provide an
* implementation for these three methods. The purpose of this interface is to define a contract for
* classes that solve the knapsack problem using a brute force approach.
*/
public interface BruteForceI {
    void knapSackSolver();
    void initializeFile();
    void writeToFile();
}