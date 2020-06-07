### Porta-One-test-task
The training "Become a Developer" gives you a chance finally to get an amazing software developer

This program is used to search min,max,average and median values in a file containing numbers.
The program supports command line options that are described below:
  
### Usage:
  
  The program is distributed as a jar file. That jar is available under path "target/porta.jar"
  
  java -jar porta.jar [OPTIONS] filename
  
  - short, long
  - -a,   --avg:     find the average value
  - -c,   --max:   find the max value
  - -m,   --median:   find the median value
  - -s,   --sum:      find the sum value
  - -x,   --min:      find the min value
  
If no options were specified by a user,then the program uses a default set of options.

### Performance requirements

There is a time restriction. The program should perform those four operations less than 90 seconds.
It needless to say that the speed depends on a matchine, this program is running on.

### Run requirements

To run the program you need to install java version 13.0.2

### Implementation description

There is a weak implementation of BinarySearchTree based on nodes that supports a few operations required to this project (put,getMin,getMax,getAll). A binary search tree is a data structure that holds sorted nodes. When an node is inserted, tree looks for an insertion position. A binary search tree node has only two nodes - the left node is less or equals to the parent node. Right parent node is greater than itself.
