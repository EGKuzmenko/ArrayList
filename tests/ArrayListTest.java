import org.junit.Before;
import org.junit.Test;

import java.util.ListIterator;

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
}