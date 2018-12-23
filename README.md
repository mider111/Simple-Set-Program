# Simple-Set-Program-
A program named SimpleSet that stores integers. The items in the collection are stored in an int array. The code does not use any Java classes that store or manipulate collections of data (e.g. ArrayList, Arrays, Set, etc.). The program implements the following public methods and constructors: 
• Two constructors: 
1) A default constructor that creates a SimpleSet containing no items. 
2) A copy constructor. 
• One non-static add(int) method that stores the integer argument as a new item in the collection if the integer is not already in the set. 
• One non-static remove(int) method that removes the integer argument from the collection if the integer is already in the set. 
• One non-static contains(int) method that returns true if the integer argument is already in the set or false if the argument is not in the set. 
• Static and non-static methods for union(), difference(), and intersection(). Each of these methods create and return a new SimpleSet that is populated with the contents appropriate for the method functionality. The original sets are not modified. 
• Static and non-static methods for subset() and equals(). These methods return boolean values. In the non-static version of subset(), the method checks if the instance the method was called on is a subset of the argument. In the static version of subset(), the method checks if the first argument is a subset of the second argument. 
• A non-static method size() that returns the cardinality of the SimpleSet. 
• A non-static toString() method that returns a String containing all of the items in the set, each separated by a space and an empty string is returned if the set is empty. 
• A print() method whose purpose is to print the String returned by the toString() method to System.out. 
• A static createFromFile(String) method that takes a String argument specifying the file name and returns a new SimpleSet containing all of the items specified in the file. 

There is also a JUnit test class named TestSimpleSet that has test methods for every method and
constructor in the SimpleSet class. 
