import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.*;

/**
 * This method test the SimpleSet class. It creates a new check method and goes through
 * all the methods and constructors in the class.
 */

public class TestSimpleSet {

	SimpleSet emptySet;
	SimpleSet firstSet;
	SimpleSet secondSet;
	SimpleSet singleElementSet;
	SimpleSet textSet;
	SimpleSet constructorSet;
	SimpleSet copySet;
	
	/**
	 * This method initialises test sets and gives them different elements.
	 */
	@Before
	public void initialize() {

		emptySet = new SimpleSet();

		singleElementSet = new SimpleSet();
		singleElementSet.add(1);

		firstSet = new SimpleSet();
		firstSet.add(1);
		firstSet.add(2);
		firstSet.add(3);
		firstSet.add(4);

		secondSet = new SimpleSet();
		secondSet.add(3);
		secondSet.add(4);
		secondSet.add(5);
		
		textSet = new SimpleSet();
		
		constructorSet = new SimpleSet();
		constructorSet.add(3);
				
	}
	
	/**
	 * This method checks if a set contains certain elements.
	 * @param mySet This is the set the method checks.
	 * @param check An integer array.
	 * @return Returns true if the set has the same elements as the check array. Returns false otherwise.
	 */

	public static boolean checkContents(SimpleSet mySet, int[] check) {
		
		//Checks if the elements and the size of the check array and the set are the same.
		for (int i : check) {
			if (!mySet.contains(i))
				return false;
		}

		if (check.length != mySet.size())
			return false;

		return true;
	}

	/*@Test
	public void testConstructor() {
		
		int[] check = {3};
		copySet = new SimpleSet(constructorSet);
		assertEquals(true , checkContents(copySet, check));
				
	}*/
	
	/**
	 * This method tests the add method.
	 */
	
	@Test
	public void testAdd() {

		int[] check = { 1 };

		assertEquals(true, emptySet.add(1));

		assertEquals(true, checkContents(emptySet, check));

		assertEquals(false, singleElementSet.add(1));

		assertEquals(true, checkContents(singleElementSet, check));
	}
	
	/**
	 * This method tests the remove method.
	 */
	
	@Test
	public void testRemove() {

		int[] check = { 1 };

		assertEquals(true, firstSet.remove(1));

		assertEquals(false, checkContents(firstSet, check));

		assertEquals(false, emptySet.remove(2));

		assertEquals(false, checkContents(emptySet, check));
	}
	
	/**
	 * This method tests the contains method.
	 */
	
	@Test
	public void testContains() {

		int[] check = { 1 };

		assertEquals(true, singleElementSet.contains(1));

		assertEquals(true, checkContents(singleElementSet, check));

		assertEquals(false, emptySet.contains(2));

		assertEquals(false, checkContents(emptySet, check));
	}
	
	/**
	 * This method tests the static union method.
	 */
	
	@Test
	public void testStaticUnion() {

		int[] check = { 1, 2, 3, 4, 5 };
		int[] check2 = { 1, 2, 3 };
		int[] check3 = { 4, 5 };
		int[] check4 = {};

		assertEquals(true, checkContents(SimpleSet.union(firstSet, secondSet), check));

		assertEquals(false, checkContents(SimpleSet.union(firstSet, secondSet), check3));

		assertEquals(false, checkContents(SimpleSet.union(firstSet, secondSet), check2));

		assertEquals(true, checkContents(SimpleSet.union(emptySet, emptySet), check4));
	}
	
	/**
	 * This method tests the non static union method.
	 */
	
	@Test
	public void testNonStaticUnion() {

		int[] check = { 1, 2, 3, 4, 5 };
		int[] check2 = { 1, 2, 3 };
		int[] check3 = { 4, 5 };
		int[] check4 = {};

		assertEquals(true, checkContents(firstSet.union(secondSet), check));

		assertEquals(false, checkContents(firstSet.union(secondSet), check2));

		assertEquals(false, checkContents(firstSet.union(secondSet), check3));

		assertEquals(true, checkContents(emptySet.union(emptySet), check4));

	}
	
	/**
	 * This method tests the static difference method.
	 */

	@Test
	public void testStaticDifference() {

		int[] check = { 1, 2 };
		int[] check2 = { 5 };

		assertEquals(true, checkContents(SimpleSet.difference(secondSet, firstSet), check2));

		assertEquals(true, checkContents(SimpleSet.difference(firstSet, secondSet), check));

		assertEquals(false, checkContents(SimpleSet.difference(secondSet, firstSet), check));
	}
	
	/** 
	 * This method tests the non static difference method.
	 */
	
	@Test
	public void testNonStaticDifference() {

		int[] check = { 1, 2 };
		int[] check2 = { 5 };

		assertEquals(true, checkContents(firstSet.difference(secondSet), check));

		assertEquals(true, checkContents(secondSet.difference(firstSet), check2));

		assertEquals(false, checkContents(firstSet.difference(secondSet), check2));
	}
	
	/**
	 * This method test the static intersection method.
	 */
	
	@Test
	public void testStaticIntersection() {

		int[] check = { 3, 4 };
		int[] check2 = { 4, 5 };

		assertEquals(true, checkContents(SimpleSet.intersection(firstSet, secondSet), check));

		assertEquals(false, checkContents(SimpleSet.intersection(firstSet, emptySet), check2));

		assertEquals(false, checkContents(SimpleSet.intersection(secondSet, firstSet), check2));
	}
	
	/**
	 * This method tests the non static intersection method.
	 */
	
	@Test
	public void testNonStaticIntersection() {

		int[] check = { 3, 4 };
		int[] check2 = { 4, 6 };

		assertEquals(true, checkContents(firstSet.intersection(secondSet), check));

		assertEquals(false, checkContents(emptySet.intersection(firstSet), check2));

		assertEquals(false, checkContents(firstSet.intersection(secondSet), check2));
	}
	
	/**
	 * This method tests the static subset method.
	 */
	
	@Test
	public void testStaticSubset() {

		assertEquals(true, SimpleSet.subset(singleElementSet, firstSet));

		assertEquals(false, SimpleSet.subset(firstSet, secondSet));

		assertEquals(false, SimpleSet.subset(secondSet, firstSet));

		assertEquals(false, SimpleSet.subset(firstSet, singleElementSet));
	}
	
	/**
	 * This method tests the non static subset method.
	 */
	
	@Test
	public void testNonStaticSubset() {

		assertEquals(true, singleElementSet.subset(firstSet));

		assertEquals(false, secondSet.subset(firstSet));

		assertEquals(false, firstSet.subset(secondSet));

		assertEquals(false, firstSet.subset(singleElementSet));
	}
	
	/**
	 * This method tests the static equals method.
	 */
	
	@Test
	public void testStaticEquals() {

		assertEquals(true, SimpleSet.subset(singleElementSet, singleElementSet));

		assertEquals(false, SimpleSet.equals(firstSet, secondSet));

		assertEquals(false, SimpleSet.equals(emptySet, singleElementSet));

		assertEquals(true, SimpleSet.subset(firstSet, firstSet));
	}
	
	/**
	 * This method test the non static equals method.
	 */
	
	@Test
	public void testNonStaticEquals() {

		assertEquals(true, singleElementSet.subset(firstSet));

		assertEquals(false, secondSet.subset(firstSet));

		assertEquals(false, firstSet.subset(secondSet));

		assertEquals(false, firstSet.subset(singleElementSet));
	}
	
	/**
	 * This method tests the size method.
	 */

	@Test
	public void testSize() {

		assertEquals(0, emptySet.size());

		assertEquals(1, singleElementSet.size());

		assertEquals(4, firstSet.size());

		assertEquals(3, secondSet.size());
	}
	
	/**
	 * This method tests the toString method.
	 */
	
	@Test
	public void testToString() {

		assertEquals("", emptySet.toString());

		assertEquals("1 ", singleElementSet.toString());

		assertEquals("1 2 3 4 ", firstSet.toString());
	}

	/*@Test
	public void testPrint() {
		
	}*/
		
	
	
	/*@Test
	public void testCreateFromFile() throws Exception {
		
		File textSet = new File("simpleset.txt");
		
		textSet = createFromFile();
				
	}*/
}