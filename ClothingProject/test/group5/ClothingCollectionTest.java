package group5;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class is in charge of running tests for the ClothingCollection class.
 * Please make sure to run these tests when the collection is empty in the
 * program because the tests and the program all run off of the same
 * serialization that is reading from one collection.
 * 
 * @author Ali Ibrahim, Hugo Wang, Juan Seo
 * @version 11/30/2020
 */
public class ClothingCollectionTest {
    ArrayList<Clothing> ccTest = new ArrayList<>();
    Clothing c1, c2, c3;
    ClothingCollection cc1, cc2;
    
    @Before
    public void setUp() {
        cc1 = new ClothingCollection();
    }

    /**
     * Test of addClothing method, of class ClothingCollection.
     */
    @Test
    public void testAddClothing() {
        Clothing clothing = new Clothing("name1", "fabric1", "size1", 1);
        cc1.addClothing(clothing);
        cc2 = new ClothingCollection();
        assertEquals(cc2.getSortedArray()[0], clothing);
        cc1.removeClothing(clothing);
        cc2.removeClothing(clothing);
    }

    /**
     * Test of removeClothing method, of class ClothingCollection.
     */
    @Test
    public void testRemoveClothing_int() {
        Clothing clothing = new Clothing("name1", "fabric1", "size1", 1);
        cc1.addClothing(clothing);
        cc1.removeClothing(0);
        cc2 = new ClothingCollection();
        assertEquals(cc2.size(), 0);
    }

    /**
     * Test of removeClothing method, of class ClothingCollection.
     */
    @Test
    public void testRemoveClothing_Clothing() {
        Clothing clothing = new Clothing("name1", "fabric1", "size1", 1);
        cc1.addClothing(clothing);
        cc1.removeClothing(clothing);
        cc2 = new ClothingCollection();
        assertEquals(cc2.size(), 0);
    }

    /**
     * Test of setClothing method, of class ClothingCollection.
     */
    @Test
    public void testSetClothing() {
        Clothing clothing = new Clothing("name1", "fabric1", "size1", 1);
        Clothing setClothing = new Clothing("name2", "fabric1", "size1", 1);
        cc1.addClothing(clothing);
        cc1.setClothing(0, setClothing);
        cc2 = new ClothingCollection();
        assertFalse(cc2.getSortedArray()[0].equals(clothing));
        cc1.removeClothing(setClothing);
        cc2.removeClothing(setClothing);
        
    }

    /**
     * Test of getClothing method, of class ClothingCollection.
     */
    @Test
    public void testGetClothing() {
        Clothing clothing = new Clothing("name1", "fabric1", "size1", 1);
        cc1.addClothing(clothing);
        cc2 = new ClothingCollection();
        assertEquals(cc2.getSortedArray()[0], cc2.getClothing(0));
        cc1.removeClothing(clothing);
        cc2.removeClothing(clothing);
    }

    /**
     * Test of size method, of class ClothingCollection.
     */
    @Test
    public void testSize() {
        assertTrue(cc1.size() == 0);
        Clothing clothing = new Clothing("name1", "fabric1", "size1", 1);
        cc1.addClothing(clothing);
        assertTrue(cc1.size() == 1);
        cc1.removeClothing(clothing);
    }

    /**
     * Test of isEmpty method, of class ClothingCollection.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(cc1.isEmpty());
        Clothing clothing = new Clothing("name1", "fabric1", "size1", 1);
        cc1.addClothing(clothing);
        assertFalse(cc1.isEmpty());
        cc1.removeClothing(clothing);
    }

    /**
     * Test of contains method, of class ClothingCollection.
     */
    @Test
    public void testContains() {
        Clothing clothing = new Clothing("name1", "fabric1", "size1", 1);
        assertFalse(cc1.contains(clothing.getName()));
        cc1.addClothing(clothing);
        assertTrue(cc1.contains(clothing.getName()));
        cc1.removeClothing(clothing);
    }

    /**
     * Test of containsForEdit method, of class ClothingCollection.
     */
    @Test
    public void testContainsForEdit() {
        Clothing clothing = new Clothing("name1", "fabric1", "size1", 1);
        cc1.addClothing(clothing);
        assertFalse(cc1.containsForEdit(0, clothing.getName()));
        cc1.removeClothing(clothing);
    }
    
    /**
     * Test of totalPrice method, of class ClothingCollection.
     */
    @Test
    public void testTotalPrice() {
        Clothing clothing1 = new Clothing("name1", "fabric1", "size1", 1);
        Clothing clothing2 = new Clothing("name2", "fabric1", "size1", 2);
        cc1.addClothing(clothing1);
        cc1.addClothing(clothing2);
        assertTrue(cc1.totalPrice().equals("3.0"));
        cc1.removeClothing(clothing1);
        cc1.removeClothing(clothing2);   
    }

    /**
     * Test of avgPrice method, of class ClothingCollection.
     */
    @Test
    public void testAvgPrice() {
        Clothing clothing1 = new Clothing("name1", "fabric1", "size1", 2);
        Clothing clothing2 = new Clothing("name2", "fabric1", "size1", 2);
        cc1.addClothing(clothing1);
        cc1.addClothing(clothing2);
        assertTrue(cc1.avgPrice().equals("2.0"));
        cc1.removeClothing(clothing1);
        cc1.removeClothing(clothing2);  
    }

    /**
     * Test of toString method, of class ClothingCollection.
     */
    @Test
    public void testToString() {
        Clothing clothing = new Clothing("name1", "fabric1", "size1", 1);
        String expectedOutput = "1. Name: name1, Size: size1, Fabric: fabric1, Price: 1.0";
        cc1.addClothing(clothing);
        assertEquals(cc1.toString(0), expectedOutput);
        cc1.removeClothing(clothing);
    }
    
}
