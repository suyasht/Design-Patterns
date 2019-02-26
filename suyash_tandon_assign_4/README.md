Assuming you are in the directory containing this README



## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=firstarg -Darg1=SECOND -Darg2=THIRD

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 07/13/2018 ]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Used BST becauseof the following:

Searching: For searching element 1, we have to traverse all elements (in order 3, 2, 1).
Therefore, searching in binary search tree has worst case complexity of O(n). 
In general, time complexity is O(h) where h is height of BST.

Insertion: For inserting element 0, it must be inserted as left child of 1. 
Therefore, we need to traverse all elements (in order 3, 2, 1) to insert 0 which has worst case complexity of O(n). 
In general, time complexity is O(h).

Deletion: For deletion of element 1, we have to traverse all elements to find 1 (in order 3, 2, 1). 
Therefore, deletion in binary tree has worst case complexity of O(n). 
In general, time complexity is O(h).
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
(if any).

https://www.geeksforgeeks.org/

