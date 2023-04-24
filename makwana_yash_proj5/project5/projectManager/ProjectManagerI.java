package project5.projectManager;

/*  
* This code is defining a Java interface called `ProjectManagerI` with three methods:
* `runBruteForce()`, `runDynamicProgramming()`, and `runBackTracking()`. Any class that implements
* this interface must provide an implementation for all three methods. This interface can be used to
* enforce a common set of behaviors across multiple classes.
*/
public interface ProjectManagerI {
    void runBruteForce();
    void runDynamicProgramming();
    void runBackTracking();
}