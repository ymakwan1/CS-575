# CS-575

### Author
### Yash Sanjay Makwana - ymakwan1@binghamton.edu

-----------------------------------------------------------------------
-----------------------------------------------------------------------

## Programming Language - Java
## Build System - ant (available on remote.cs already)

-----------------------------------------------------------------------
## Commands and Example 

 **IMPORTANT! : Run all the following commands from the ~/makwana_y_p2/ directory**

#### Instruction to run:

 **Command: make**  
 Description: On running the **make** command, it clesns, builds and runs the java files. Below is the expected output on running the make command. ANT clean, build and run is executed one by one by the makefile and eventually user input is asked. File path names change as per your system.

 $ make  

 ant -buildfile trominoTiling/src/build.xml clean
 Buildfile: /home/ymakwan1/CS-575/makwana_y_p2/trominoTiling/src/build.xml

 clean:

BUILD SUCCESSFUL
Total time: 0 seconds
ant -buildfile trominoTiling/src/build.xml all
Buildfile: /home/ymakwan1/CS-575/makwana_y_p2/trominoTiling/src/build.xml

prepare:
    [mkdir] Created dir: /home/ymakwan1/CS-575/makwana_y_p2/trominoTiling/src/BUILD
    [mkdir] Created dir: /home/ymakwan1/CS-575/makwana_y_p2/trominoTiling/src/BUILD/classes

trominoTiling:
    [javac] Compiling 4 source files to /home/ymakwan1/CS-575/makwana_y_p2/trominoTiling/src/BUILD/classes

compile_all:

all:

BUILD SUCCESSFUL
Total time: 0 seconds
ant -buildfile trominoTiling/src/build.xml run
Buildfile: /home/ymakwan1/CS-575/makwana_y_p2/trominoTiling/src/build.xml

jar:
    [mkdir] Created dir: /home/ymakwan1/CS-575/makwana_y_p2/trominoTiling/src/BUILD/jar  
      [jar] Building jar: /home/ymakwan1/CS-575/makwana_y_p2/trominoTiling/src/BUILD/jar/trominoTiling.jar  

run:  
     [java] Please enter size of board (0 to quit):  
2  
     [java] Please enter coordinates of missing square (separate by a space):  
0 1  
     [java] MS LR   
     [java] LR LR  

BUILD SUCCESSFUL  
Total time: 32 seconds  

-----------------------------------------------------------------------