# CS-575
### Author
### Yash Sanjay Makwana - ymakwan1@binghamton.edu
-----------------------------------------------------------------------
-----------------------------------------------------------------------
## Programming Language - Java
-----------------------------------------------------------------------
## Commands and Example 

 **IMPORTANT! : Run all the following commands from the ~/makwana_yash_proj4/ directory**

#### Instruction to run:
** Command: make **  
 Description: On running the ** make ** command, it cleans & builds the java files. 
 <br>
 <br>
** Command: make clean ** <br>
 Description: On the running the ** make clean ** command, it cleans all the class files. <br>

 ## The output is generated in the following fashion. <br>

 # For Prims <br>
 *********** PROJECT 4 *********** <br>
Randomly selected 7 vertices. <br>

Random Matrix:<br>
0 2 1 10 8 5 1 <br>
2 0 2 9 1 4 5 <br>
1 2 0 7 4 7 7 <br>
10 9 7 0 3 2 10 <br>
8 1 4 3 0 8 7 <br>
5 4 7 2 8 0 7 <br>
1 5 7 10 7 7 0 <br>

Enter 1 for Prims and 2 for Kruskals : <br>
1 <br>

Prim's matrix: <br>

0 2 1 0 0 0 1<br>
2 0 0 0 1 0 0<br>
1 0 0 0 0 0 0<br>
0 0 0 0 3 2 0<br>
0 1 0 3 0 0 0<br>
0 0 0 2 0 0 0<br>
1 0 0 0 0 0 0<br>

Prim's MST:<br>
V1- V3: 1<br>
V1- V7: 1<br>
V1- V2: 2<br>
V2- V5: 1<br>
V5- V4: 3<br>
V4- V6: 2<br>


# For Kruskals <br>
*********** PROJECT 4 ***********<br>
Randomly selected 6 vertices.<br>

Random Matrix:<br>
0 6 7 4 9 4 <br>
6 0 9 6 1 9 <br>
7 9 0 4 6 9 <br>
4 6 4 0 5 8 <br>
9 1 6 5 0 2 <br>
4 9 9 8 2 0 <br>

Enter 1 for Prims and 2 for Kruskals : <br>
2<br>
Kruskal's matrix:<br>
0 0 0 4 0 4 <br>
0 0 0 0 1 0 <br>
0 0 0 4 0 0 <br>
4 0 4 0 0 0 <br>
0 1 0 0 0 2 <br>
4 0 0 0 2 0 <br>

Kruskal's MST<br>
V2-V5: 1<br>
V5-V6: 2<br>
V1-V4: 4<br>
V1-V6: 4<br>
V3-V4: 4<br>