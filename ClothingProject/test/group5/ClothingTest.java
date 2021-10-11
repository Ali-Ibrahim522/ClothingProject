package group5;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class is in charge of running tests for the Clothing class, most of the
 * class was getters and setters so few tests were needed.
 * 
 * @author Ali Ibrahim, Hugo Wang, Juan Seo
 * @version 11/30/2020
 */
public class ClothingTest {
    Clothing c1, c2, c3;
    
    /**
     * this method will setup three test clothing with all different values
     * except for c1's and c3's name being the same
     */
    @Before
    public void setUp() {
        c1 = new Clothing("name1", "fabric1", "size1", 1);
        c2 = new Clothing("name2", "fabric2", "size2", 2);
        c3 = new Clothing("name1", "fabric3", "size3", 3);
    }
    
    /**
     * Test of equals method, of class Clothing.
     */
    @Test
    public void testEquals() {
        assertTrue(c1.equals(c3));
        assertFalse(c1.equals(c2));
    }

    /**
     * Test of toString method, of class Clothing.
     */
    @Test
    public void testToString() {
        assertTrue(c1.toString().equals(c3.toString()));
        assertFalse(c1.toString().equals(c2.toString()));
    }

    /**
     * Test of compareTo method, of class Clothing.
     */
    @Test
    public void testCompareTo() {
        assertTrue(c1.compareTo(c3) == 0);
        assertTrue(c1.compareTo(c2) < 0);
        assertTrue(c2.compareTo(c1) > 0);
    }
    
}
