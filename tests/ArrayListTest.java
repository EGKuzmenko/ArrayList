import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ArrayListTest {

    private ArrayList<Integer> testInstance;
    private ListIterator<Integer> listIterator;

    @Before
    public void setUp() throws Exception {
        testInstance = new ArrayList<>();
        listIterator = testInstance.listIterator();
    }

    @Test
    public void testSizeWhenSizeIs0() {
        assertEquals(0, testInstance.size());
    }

    @Test
    public void isEmpty() {
        assertTrue(testInstance.isEmpty());
    }

    @Test
    public void testToArrayWhenInputArrayHaveSizeOne() {

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        final Integer[] input = new Integer[1];

        final Integer[] result = testInstance.toArray(input);

        assertNotEquals(input, result);
        assertEquals((Integer) 1, result[0]);
        assertEquals((Integer) 2, result[1]);
        assertEquals((Integer) 3, result[2]);
        assertEquals(3, result.length);

    }

    @Test
    public void testToArrayWhenInputArrayHaveCorrectSize() {

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        final Integer[] input = new Integer[3];

        final Integer[] result = testInstance.toArray(input);

        assertArrayEquals(input, result);

    }

    @Test
    public void testContains() {

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);
        testInstance.add(4);
        testInstance.add(5);

        assertTrue(testInstance.contains(4));
        assertFalse(testInstance.contains(0));

    }

    @Test
    public void testAdd() {

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        assertEquals(3, testInstance.size());
        assertFalse(testInstance.isEmpty());

    }

    @Test
    public void testRemoveObjectFirstElement() {

        testInstance.add(1);
        testInstance.add(2);
        Object a = 1;
        testInstance.remove(a);

        assertEquals(1, testInstance.size());
        assertEquals((Integer)2, testInstance.get(0));
        assertFalse(testInstance.isEmpty());

    }

    @Test
    public void testRemoveObjectLastElement() {

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);
        Object a = 3;
        testInstance.remove(a);

        assertEquals(2, testInstance.size());
        assertEquals((Integer)2, testInstance.get(1));
        assertFalse(testInstance.isEmpty());
    }

    @Test
    public void testContainsAll() {

        final ArrayList<Integer> testInstance2 = new ArrayList<>();

        testInstance.add(1);
        testInstance.add(2);

        testInstance2.add(2);
        testInstance2.add(1);

        assertTrue(testInstance.containsAll(testInstance2));

    }

    @Test
    public void testAddAll() {

        final ArrayList<Integer> testInstance2 = new ArrayList<>();

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        testInstance2.add(6);
        testInstance2.add(7);
        testInstance2.add(8);

        testInstance.addAll(testInstance2);

        assertEquals(6, testInstance.size());
        assertEquals((Integer)7, testInstance.get(4));
        assertTrue(testInstance.contains(8));
        assertTrue(testInstance.contains(6));
        assertTrue(testInstance.contains(7));
        assertTrue(testInstance.contains(3));

    }

    @Test
    public void testRemoveAll() {

        final ArrayList<Integer> testInstance2 = new ArrayList<>();

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(4);
        testInstance.add(5);

        testInstance2.add(2);
        testInstance2.add(3);

        testInstance.removeAll(testInstance2);

        assertEquals(3, testInstance.size());
        assertTrue(testInstance.contains(1));
        assertFalse(testInstance.contains(2));

    }

    @Test
    public void testRetainAll() {

        final ArrayList<Integer> testInstance2 = new ArrayList<>();

        testInstance.add(1);
        testInstance.add(2);

        testInstance2.add(2);
        testInstance2.add(5);

        testInstance.retainAll(testInstance2);

        assertEquals(1, testInstance.size());
        assertTrue(testInstance.contains(2));

    }

    @Test
    public void testClear() {

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        testInstance.clear();

        assertTrue(testInstance.isEmpty());
        assertEquals(0, testInstance.size());

    }

    @Test
    public void testRemoveIndexFirst() {

        testInstance.add(1);
        testInstance.add(2);

        testInstance.remove(0);

        assertEquals(1, testInstance.size());
        assertFalse(testInstance.isEmpty());
        assertEquals((Integer) 2, testInstance.get(0));

    }

    @Test
    public void testRemoveIndexLast() {

        testInstance.add(1);
        testInstance.add(2);

        testInstance.remove(1);

        assertEquals(1, testInstance.size());
        assertFalse(testInstance.isEmpty());
        assertEquals((Integer) 1, testInstance.get(0));

    }

    @Test
    public void testRemoveIndexMiddle() {

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        assertEquals((Integer)2, testInstance.remove(1));

        assertEquals(2, testInstance.size());
        assertFalse(testInstance.isEmpty());
        assertEquals((Integer) 1, testInstance.get(0));

    }

    @Test
    public void testGet() {

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        assertEquals((Integer) 1, testInstance.get(0));
        assertEquals((Integer) 2, testInstance.get(1));
        assertEquals((Integer) 3, testInstance.get(2));

    }

    @Test
    public void testSet() {

        testInstance.add(1);
        testInstance.add(2);

        assertEquals((Integer)1, testInstance.set(0, 3));
        assertEquals((Integer)3, testInstance.get(0));
        assertFalse(testInstance.isEmpty());
        assertEquals(2, testInstance.size());
    }

    @Test
    public void testAddIndexFirst() {

        testInstance.add(2);
        testInstance.add(3);

        testInstance.add(0, 1);

        assertEquals(3, testInstance.size());
        assertEquals((Integer)1, testInstance.get(0));

    }

    @Test
    public void testAddIndexMiddle() {

        testInstance.add(1);
        testInstance.add(3);

        testInstance.add(1, 2);

        assertEquals(3, testInstance.size());
        assertEquals((Integer)2, testInstance.get(1));

    }

    @Test
    public void testAddWhenLengthEqualsSize() {

        ArrayList<Integer> testInstance2 = new ArrayList<>(2);

        testInstance2.add(1);
        testInstance2.add(3);

        testInstance2.add(1,2);

        assertEquals(3, testInstance2.size());
        assertEquals((Integer)2, testInstance2.get(1));

    }

    @Test
    public void testIndexOf() {

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(1);

        assertEquals(0, testInstance.indexOf(1));
        assertEquals(3, testInstance.size());
        assertEquals(-1, testInstance.indexOf(5));

    }

    @Test
    public void testLastIndexOf() {

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(1);
        testInstance.add(4);

        assertEquals(2, testInstance.lastIndexOf(1));
        assertEquals(4, testInstance.size());
        assertEquals(-1, testInstance.lastIndexOf(5));

    }

    @Test
    public void testHasNext() {

        testInstance.add(1);
        assertTrue(listIterator.hasNext());
        assertEquals((Integer)1, listIterator.next());
        assertFalse(listIterator.hasNext());

    }

    @Test
    public void testNext() {

        testInstance.add(1);
        testInstance.add(2);

        try {
            assertEquals("Expected 1", (Integer)1, listIterator.next());
            assertEquals("Expected 2", (Integer)2, listIterator.next());
            listIterator.next();
            fail("Expected NoSuchElementException");
        } catch (final NoSuchElementException e) {}

    }

    @Test
    public void testHasPrevious() {

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        assertFalse(listIterator.hasPrevious());
        listIterator.next();
        assertTrue(listIterator.hasPrevious());
        listIterator.next();
        assertTrue(listIterator.hasPrevious());
        listIterator.next();
        assertTrue(listIterator.hasPrevious());

    }

    @Test
    public void testPreviousWhenListSize0() {


        try {
            listIterator.previous();
            fail("Expected NoSuchElementException");
        } catch (final NoSuchElementException e) {}

    }

    @Test
    public void testPreviousBeforeNext() {

        testInstance.add(1);
        testInstance.add(2);

        try {
            listIterator.previous();
            fail("Expected NoSuchElementException");
        } catch (final NoSuchElementException e) {}

    }

    @Test
    public void testPrevious() {

        testInstance.add(1);
        testInstance.add(2);

        listIterator.next();
        listIterator.next();

        assertEquals((Integer)2, listIterator.previous());
        assertEquals((Integer)1, listIterator.previous());

    }

    @Test
    public void testNextIndex() {

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        assertEquals(0, listIterator.nextIndex());
        listIterator.next();
        assertEquals(1, listIterator.nextIndex());
        listIterator.next();
        assertEquals(2, listIterator.nextIndex());
        listIterator.next();

    }

    @Test
    public void testPreviousIndex() {

        testInstance.add(1);
        testInstance.add(2);

        assertEquals(-1, listIterator.previousIndex());
        listIterator.next();
        assertEquals(0, listIterator.previousIndex());

    }

    @Test
    public void testRemoveBeforeNextOrPrevious() {

        testInstance.add(1);

        try {
            listIterator.remove();
            fail("Expected IllegalStateException");
        } catch (final IllegalStateException e) {}

    }

    @Test
    public void testRemove() {

        testInstance.add(1);
        testInstance.add(2);
        testInstance.add(3);

        assertEquals((Integer)1, listIterator.next());
        assertEquals((Integer)2, listIterator.next());
        listIterator.remove();
        assertEquals(2, testInstance.size());
        assertEquals((Integer)3, listIterator.next());
        assertEquals((Integer)3, listIterator.previous());
        listIterator.remove();
        assertEquals(1, testInstance.size());
        assertEquals((Integer) 1, testInstance.get(0));

    }

    @Test
    public void testSetListIterator() {

        testInstance.add(1);
        testInstance.add(2);

        listIterator.next();
        listIterator.set(5);
        assertEquals((Integer)5, testInstance.get(0));

    }

    @Test
    public void testSetWhenLastIsNotSet() {

        testInstance.add(1);
        testInstance.add(2);

        try {
            listIterator.set(5);
            fail("Expected IllegalStateException");
        } catch (final IllegalStateException e) {}

    }

    @Test
    public void testAddListIterator() {

        testInstance.add(1);
        listIterator.add(2);

        assertFalse(testInstance.isEmpty());
        assertEquals(2, testInstance.size());
        assertEquals((Integer)2, testInstance.get(0));
        assertEquals((Integer)1, testInstance.get(1));


    }

    @Test
    public void testSubList() {


        for (int i = 0; i < 7; i++) {
            testInstance.add(i);
        }

        assertFalse(testInstance.subList(1, 5).isEmpty());
        assertEquals(5, testInstance.subList(1, 5).size());
        assertEquals((Integer) 3, testInstance.subList(1, 5).get(2));

    }

    @Test
    public void testSubListWhenIndexOutOfRange() {

        for (int i = 0; i < 4; i++) {
            testInstance.add(i);
        }

        try {
            testInstance.subList(0, 5);
            fail("Expected IndexOutOfBoundsException");
        } catch (final IndexOutOfBoundsException e) {}

        try {
            testInstance.subList(-1, 3);
            fail("Expected IndexOutOfBoundsException");
        } catch (final  IndexOutOfBoundsException e) {}

        try {
            testInstance.subList(2, 1);
            fail("Expected IndexOutOfBoundsException");
        } catch (final  IndexOutOfBoundsException e) {}

    }

}