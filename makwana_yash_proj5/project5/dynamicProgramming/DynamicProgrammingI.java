package project5.dynamicProgramming;

/* 
*This is a Java interface named `DynamicProgrammingI` that declares three methods:
* `initializeFile()`, `knapSackSolver()`, and `writeToFile()`. Any class that implements this
* interface must provide implementations for these three methods. This interface is likely used in a
* dynamic programming project to define a common set of methods that all dynamic programming solvers
* must implement.
*/ 
public interface DynamicProgrammingI {
    void initializeFile();
    void knapSackSolver();
    void writeToFile();
}