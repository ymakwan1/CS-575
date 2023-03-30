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
 Description: On the running the ** make clean ** command, it cleans all the class files.

 ## To test different cases, such as more than 2 inputs, string length more than 100. 
 
 ## Use any of these commands after you have ran the make command, you can edit the string to whatever you feel suitable.

 ## For normal working 
 java project3/driver/Driver AGGTAB GXTXAYB
 
 ## For string less than 2
 java project3/driver/Driver AGGTAB

 ## For more than 2 strings in input.
 java project3/driver/Driver AGGTAB GXTXAYB XAXAXA

 ## For string length in input more than 100 characters.
 java project3/driver/Driver AGGTAB ACGTTCGGCCTCTGAGGCTAGTCGACAGATCTTCTCGGATCCGACTAGGTACCTTCTAGGATTCACAGGTGCTAGCTGACTAGCTACCTTGAGTAGTCTCTA
 
 -----------------------------------------------------------------------
  ## The output is generated in the following fashion.

  # For string less than 2
  ********** PROJECT-3 ********** <br>
  Error Message : Invalid no. of input. Need 2 strings as input. <br>

  # For more than 2 strings in input.
  ********** PROJECT-3 ********** <br>
  Error Message : -1 <br>
  Input size more than 2. <br>

  # For string length in input more than 100 characters.
  ********** PROJECT-3 **********
  Error Message : -2 
  Input has more than 100 characters.

  # Normal working
  ********** PROJECT-3 **********

  ----------Longest Common Subsequence---------
  Length of LCS : 4
  LCS : GTAB

  ----------Floyd's Algorithm---------

  ----------Adjacency Matrix---------
  0       3       5       3       8
  3       0       8       2       9
  5       8       0       3       1
  3       2       3       0       7
  8       9       1       7       0

  ----------Shortest Paths Matrix---------
  0       3       5       3       6
  3       0       5       2       6
  5       5       0       3       1
  3       2       3       0       4
  6       6       1       4       0

----------All Pair Shortest Paths---------
Shortest Path from 1 to 2: 1 -> 2 (length 3)
Shortest Path from 1 to 3: 1 -> 3 (length 5)
Shortest Path from 1 to 4: 1 -> 4 (length 3)
Shortest Path from 1 to 5: 1 -> 3 -> 5 (length 6)

Shortest Path from 2 to 1: 2 -> 1 (length 3)
Shortest Path from 2 to 3: 2 -> 4 -> 3 (length 5)
Shortest Path from 2 to 4: 2 -> 4 (length 2)
Shortest Path from 2 to 5: 2 -> 4 -> 5 (length 6)

Shortest Path from 3 to 1: 3 -> 1 (length 5)
Shortest Path from 3 to 2: 3 -> 4 -> 2 (length 5)
Shortest Path from 3 to 4: 3 -> 4 (length 3)
Shortest Path from 3 to 5: 3 -> 5 (length 1)

Shortest Path from 4 to 1: 4 -> 1 (length 3)
Shortest Path from 4 to 2: 4 -> 2 (length 2)
Shortest Path from 4 to 3: 4 -> 3 (length 3)
Shortest Path from 4 to 5: 4 -> 3 -> 5 (length 4)

Shortest Path from 5 to 1: 5 -> 3 -> 1 (length 6)
Shortest Path from 5 to 2: 5 -> 3 -> 4 -> 2 (length 6)
Shortest Path from 5 to 3: 5 -> 3 (length 1)
Shortest Path from 5 to 4: 5 -> 3 -> 4 (length 4)
 -----------------------------------------------------------------------