import java.util.*;

/**
 * <h1>Simple Set</h1> The SimpleSet program allows the user to perform
 * different methods on simple integer sets.
 * 
 * @author Viktor Ivanov
 * @version 1.0
 * @since 18.9.2018
 */

public class SimpleSet {

	private static final int SETMAXSIZE = 10;
	private int[] myArray;
	public int elementMax = 5;

	// Simple default constructor.

	public SimpleSet() {

		myArray = new int[elementMax];

	}

	// This constructor creates a copy of another set.

	public SimpleSet(SimpleSet S) {

		SimpleSet copySet = new SimpleSet();

		for (int i : copySet.myArray) {

			S.add(i);
		}

	}

	/**
	 * This method receives a number and checks if it is in a set of integers. If it
	 * is not it adds it to the set.
	 * 
	 * @param number
	 *            This is the number that the method gets and adds to the set.
	 * @return The method returns true if it added the number and false if not.
	 */

	public boolean add(int number) {

		int setElements = 0;
		int[] biggerArray = new int[elementMax + 1];

		for (int i = 0; i < myArray.length; i++) {

			// If the number is in the set returns false.
			if (myArray[i] == number)
				return false;

			// Counts the elements of the set.
			if (myArray[i] != 0) {
				++setElements;

				// If the set is not big enough creates a new set one size bigger so it can add
				// the number.
				if (setElements == elementMax && setElements <= SETMAXSIZE) {

					for (int j = 0; j < myArray.length; j++) {

						biggerArray[j] = myArray[j];

					}

					++elementMax;
					myArray = biggerArray;
				}
				// If the set is big enough it just adds the number and returns true.
			} else if (myArray[i] == 0) {

				myArray[i] = number;
				break;

			}
		}
		return true;
	}

	/**
	 * This method receives a number and checks if it is in a set of integers. If it
	 * is it removes it.
	 * 
	 * @param number
	 *            This is the number that the method gets and removes from the set.
	 * @return The method returns true if it removed the number and false if not.
	 */

	public boolean remove(int number) {

		for (int i = 0; i < myArray.length; i++) {

			// If the number is in the set it removes it from it.
			if (myArray[i] == number) {
				myArray[i] = 0;
				int count = 0;

				// Counts the elements of the set that are not equal to zero and removes the
				// empty
				// elements from the set.
				for (int j = 0; j < myArray.length; j++) {

					if (myArray[j] != 0)
						myArray[count++] = myArray[j];

				}

				// Fill the rest of the set with zeroes.
				while (count < myArray.length) {

					myArray[count++] = 0;

				}
				return true;
			}
		}
		return false;
	}

	/**
	 * This method receives a number and checks if it is in a set of integers.
	 * 
	 * @param number
	 *            This is the number that the method checks for.
	 * @return The method returns true if the number is in the set and false if not.
	 */

	public boolean contains(int number) {

		for (int i = 0; i < myArray.length; i++) {

			// If the number is in the array returns true.
			if (myArray[i] == number)
				return true;

		}
		return false;
	}

	/**
	 * A non static method that finds the intersection of two integer sets.
	 * 
	 * @param fSet
	 *            This is the set it receives from the user.
	 * @return This is the intersection set that the method returns.
	 */

	public SimpleSet intersection(SimpleSet fSet) {

		SimpleSet interSet = new SimpleSet();
		int[] instanceSet = this.myArray;

		for (int i : instanceSet) {

			// If the number is in both sets it adds it to the final intersection set.
			if (fSet.contains(i)) {
				interSet.add(i);

			}
		}
		return interSet;
	}

	/**
	 * A static method that finds the intersection of two integer sets.
	 * 
	 * @param fSet
	 *            This is the first set it receives from the user.
	 * @param sSet
	 *            This is the second set it receives from the user.
	 * @return This is the intersection set that the method returns.
	 */

	public static SimpleSet intersection(SimpleSet fSet, SimpleSet sSet) {

		SimpleSet interSet = new SimpleSet();
		int[] setA = fSet.myArray;

		for (int i : setA) {

			// If the number is in both sets it adds it to the final intersection set.
			if (sSet.contains(i)) {
				interSet.add(i);

			}
		}
		return interSet;
	}

	/**
	 * A non static method that finds the difference of two integer sets.
	 * 
	 * @param fSet
	 *            This is the set it receives from the user.
	 * @return This is the difference set that the method returns.
	 */

	public SimpleSet difference(SimpleSet fSet) {

		SimpleSet differSet = new SimpleSet();
		int[] instanceSet = this.myArray;

		for (int i : instanceSet) {

			// If the number is in both sets it adds it to the final difference set.
			if (!(fSet.contains(i))) {
				differSet.add(i);

			}
		}
		return differSet;
	}

	/**
	 * A static method that finds the difference of two integer sets.
	 * 
	 * @param fSet
	 *            This is the first set it receives from the user.
	 * @param sSet
	 *            This is the second set it receives from the user.
	 * @return This is the difference set that the method returns.
	 */

	public static SimpleSet difference(SimpleSet fSet, SimpleSet sSet) {

		SimpleSet differSet = new SimpleSet();
		int[] setA = fSet.myArray;

		for (int i : setA) {

			// If the number is in both sets it adds it to the final difference set.
			if (!(sSet.contains(i))) {
				differSet.add(i);

			}
		}
		return differSet;
	}

	/**
	 * A non static method that finds the union of two integer sets.
	 * 
	 * @param fSet
	 *            This is the set it receives from the user.
	 * @return This is the union set that the method returns.
	 */

	public SimpleSet union(SimpleSet fSet) {

		SimpleSet unionSet = new SimpleSet();

		// In order to produce the union set it creates 3 different sets.
		int[] difffSet = this.difference(fSet).myArray;
		int[] diffThis = fSet.difference(this).myArray;
		int[] interSet = this.intersection(fSet).myArray;

		// The next 3 for loops add each element of the newly created sets and adds them
		// to final union set.
		for (int i : interSet) {
			unionSet.add(i);
		}

		for (int i : diffThis) {
			unionSet.add(i);
		}

		for (int i : difffSet) {
			unionSet.add(i);
		}
		return unionSet;
	}

	/**
	 * A static method that finds the union of two integer sets.
	 * 
	 * @param fSet
	 *            This is the first set it receives from the user.
	 * @param sSet
	 *            This is the second set it receives from the user.
	 * @return This is the union set that the method returns.
	 */

	public static SimpleSet union(SimpleSet fSet, SimpleSet sSet) {

		SimpleSet unionSet = new SimpleSet();

		// In order to produce the union set it creates 3 different sets.
		int[] difffSet = difference(fSet, sSet).myArray;
		int[] diffsSet = difference(sSet, fSet).myArray;
		int[] interSet = intersection(fSet, sSet).myArray;

		// The next 3 for loops add each element of the newly created sets and adds them
		// to final union set.
		for (int i : interSet) {
			unionSet.add(i);
		}

		for (int i : diffsSet) {
			unionSet.add(i);
		}

		for (int i : difffSet) {
			unionSet.add(i);
		}

		return unionSet;
	}

	/**
	 * A non static method that checks if a set is a subset of another set.
	 * 
	 * @param fSet
	 *            This is the set it receives from the user.
	 * @return The method returns true if the two sets are subsets and false if not.
	 */

	public boolean subset(SimpleSet fSet) {

		int[] instanceSet = this.myArray;

		// Goes true the set and if it contains all elements as the other set returns
		// true.
		for (int i : instanceSet) {

			if (!(fSet.contains(i))) {
				return false;

			}
		}
		return true;
	}

	/**
	 * A static method that checks if a set is a subset of another set.
	 * 
	 * @param fSet
	 *            This is the first set it receives from the user.
	 * @param sSet
	 *            This is the second set it receives from the user.
	 * @return The method returns true if the two sets are subsets and false if not.
	 */

	public static boolean subset(SimpleSet fSet, SimpleSet sSet) {

		int[] setA = fSet.myArray;

		// Goes true the set and if it contains all elements as the other set returns
		// true.
		for (int i : setA) {

			if (!(sSet.contains(i))) {
				return false;
			}

		}
		return true;
	}

	/**
	 * A non static method that checks if a set is equal to another set.
	 * 
	 * @param fSet
	 *            This is the first set it receives from the user.
	 * @return The method returns true if the two sets are equal and false if not.
	 */

	public boolean equals(SimpleSet fSet) {

		// Checks if both sets are subsets of each other they are equal and returns
		// true.
		if (this.subset(fSet) && fSet.subset(this)) {
			return true;
		}

		return false;
	}

	/**
	 * A static method that checks if a set is equal to another set.
	 * 
	 * @param fSet
	 *            This is the first set it receives from the user.
	 * @param sSet
	 *            This is the second set it receives from the user.
	 * @return The method returns true if the two sets are equal and false if not.
	 */

	public static boolean equals(SimpleSet fSet, SimpleSet sSet) {

		// Checks if both sets are subsets of each other they are equal and returns
		// true.
		if (subset(fSet, sSet) && subset(sSet, fSet)) {
			return true;
		}

		return false;
	}

	/**
	 * A non static method that finds the size of a set.
	 * 
	 * @return This returns the size of the set.
	 */

	public int size() {

		int elements = 0;

		for (int i = 0; i < myArray.length; i++) {

			// Counts each element and returns the count.
			if (myArray[i] != 0) {
				elements++;
			}

		}
		return elements;
	}

	/**
	 * This method converts a set to a string form.
	 * 
	 * @return The method returns the string containing all set elements.
	 */

	public String toString() {

		String stringSet = "";

		for (int i : myArray) {

			// Gets all of the set's elements into a string.
			if (i != 0) {
				stringSet = stringSet + i + " ";
			}

		}
		return stringSet;
	}

	/**
	 * This method prints out a string.
	 */

	public void print() {

		System.out.println(this.toString());

	}

	/**
	 * This method reads integers from a text file and creates a set with all of the
	 * integers.
	 * 
	 * @param filename
	 *            This is the text file it gets from the user.
	 * @return This is the set that the method created.
	 */

	public static SimpleSet createFromFile(String filename) {

		SimpleSet textSet = new SimpleSet();

		try {

			Scanner sc = new Scanner(filename);

			// Keeps going through the text file and adds each integer in the file to the
			// set.
			while (sc.hasNextInt()) {
				textSet.add(sc.nextInt());
			}

			sc.close();

		} catch (Exception e) {

			System.out.println("Catching the exception " + e);

		}
		return textSet;
	}
}