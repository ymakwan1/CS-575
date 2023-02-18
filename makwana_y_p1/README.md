# CS-575

### Author
### Yash Sanjay Makwana - ymakwan1@binghamton.edu

-----------------------------------------------------------------------
-----------------------------------------------------------------------
## Slack Days Used : <span style="color:red">*0*</span>

-----------------------------------------------------------------------
## ANT Commands 
 **Note: build.xml is present in computeMaxProfit/src folder.**

 **IMPORTANT! : Run all the following commands from the ~/makwana_y_p1/ directory**

#### Instruction to clean:

 **Command: ant -buildfile computeMaxProfit/src/build.xml clean**
Description: It cleans up all the .class files that were generated when you
compiled your code.

#### Instruction to compile:

 **Command: ant -buildfile computeMaxProfit/src/build.xml all**

Description: Compiles your code and generates .class files inside the BUILD folder.

#### Instruction to run:
 **Command: ant -buildfile computeMaxProfit/src/build.xml run -Darg0=-m -Darg1=market-price.txt -Dagr2=-p -Darg3=price-list.txt**

Format: Input file kind, Input File, Input file kind, Input File

Note : all the input/output files are expected to be at the level of the src/ directory. Example:
computeMaxProfit/src
computeMaxProfit/market-price.txt

-----------------------------------------------------------------------