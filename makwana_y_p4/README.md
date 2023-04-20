# CS-575
### Author
### Yash Sanjay Makwana - ymakwan1@binghamton.edu
-----------------------------------------------------------------------
-----------------------------------------------------------------------
## Programming Language - Java
-----------------------------------------------------------------------
## Commands and Example 

 **IMPORTANT! : Run all the following commands from the ~/makwana_y_p3/ directory**

#### Instruction to run:
** Command: make **  
 Description: On running the ** make ** command, it cleans & builds the java files. 
 <br>
 <br>
** Command: make clean ** <br>
 Description: On the running the ** make clean ** command, it cleans all the class files. <br>

 ## The output is generated in the following fashion.

 # For Prims
 *********** PROJECT 4 ***********
Randomly selected 7 vertices. <br>

Random Matrix:
0 2 1 10 8 5 1 
2 0 2 9 1 4 5 
1 2 0 7 4 7 7 
10 9 7 0 3 2 10 
8 1 4 3 0 8 7 
5 4 7 2 8 0 7 
1 5 7 10 7 7 0 

Enter 1 for Prims and 2 for Kruskals : 
1

Prim's matrix:

0       2       1       0       0       0       1
2       0       0       0       1       0       0
1       0       0       0       0       0       0
0       0       0       0       3       2       0
0       1       0       3       0       0       0
0       0       0       2       0       0       0
1       0       0       0       0       0       0

Prim's MST:
V1- V3:         1
V1- V7:         1
V1- V2:         2
V2- V5:         1
V5- V4:         3
V4- V6:         2


# For Kruskals <br>
*********** PROJECT 4 ***********
Randomly selected 6 vertices.

Random Matrix:
0 6 7 4 9 4 
6 0 9 6 1 9 
7 9 0 4 6 9 
4 6 4 0 5 8 
9 1 6 5 0 2 
4 9 9 8 2 0 

Enter 1 for Prims and 2 for Kruskals : 
2
Kruskal's matrix:
 0  0  0  4  0  4 
 0  0  0  0  1  0 
 0  0  0  4  0  0 
 4  0  4  0  0  0 
 0  1  0  0  0  2 
 4  0  0  0  2  0 
Kruskal's MST
V2-V5: 1
V5-V6: 2
V1-V4: 4
V1-V6: 4
V3-V4: 4