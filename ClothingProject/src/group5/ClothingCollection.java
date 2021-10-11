package group5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is in charge of handling the collection of clothing the user will
 * have access of in the program. The class provides methods to add, remove,
 * and edit clothing in the collection. The class also calculates the total and
 * average price, handles serialization, and a few other methods like isEmpty
 * and contains that help with functions in ClothingView.
 * 
 * @author Ali Ibrahim, Hugo Wang, Juan Seo
 * @version 11/30/2020
 */
public class ClothingCollection {
    //the ArrayList that acts to be our ClothingCollection
    private ArrayList<Clothing> closet;

    /**
     * creates the ArrayList to which holds our collection of clothing and reads
     * in any existing clothing from our serialization.
     * 
     */
    public ClothingCollection() {
        closet = new ArrayList<>();
        readCollection();
    }
    
    /**
     * adds a new article of clothing to the ArrayList.
     *
     * @param clothing the clothing object to which is added.
     */
    public void addClothing(Clothing clothing) {
        closet.add(clothing);
        writeCollection();
    }
    
    /**
     * removes an article of clothing found at the index provided in the
     * parameter.
     * 
     * @param index the index in the ArrayList to which the clothing is removed
     * from.
     */
    public void removeClothing(int index) {
        closet.remove(index);
        writeCollection();
    }
    
    /**
     * a second rendition of the remove clothing function that instead of using
     * an index, uses an element of the ArrayList to find which clothing to
     * remove.
     * 
     * @param clothing the element of the ArrayList to which is removed.
     */
    public void removeClothing(Clothing clothing) {
        closet.remove(clothing);
        writeCollection();
    }
    
    /**
     * changes the value of a specific article of clothing found at index,
     * being replaced with the new clothing found in the parameter.
     * 
     * @param index the index of the ArrayList that is having its clothing
     * changed.
     * @param clothing the clothing that is replacing the past clothing.
     */
    public void setClothing(int index, Clothing clothing) {
        closet.set(index, clothing);
        writeCollection();
    }
    
    /**
     * provides access to a piece of clothing in the ArrayList found at the
     * index provided in the parameter.
     * 
     * @param index the location of the clothing in the collection. 
     * @return the clothing found in the index.
     */
    public Clothing getClothing(int index) {
        return closet.get(index);
    }
    
    /**
     * provides access to the size of the clothing ArrayList.
     * 
     * @return the size of the clothing collection.
     */
    public int size() {
        return closet.size();
    }
    
    /**
     * provides access to whether the clothing collection is empty or not.
     * 
     * @return false if the collection is not empty, true if it is.
     */
    public boolean isEmpty() {
        return closet.isEmpty();
    }
    
    /**
     * finds if the name of an article of clothing already exits in the clothing
     * collection.
     * 
     * @param name the name to which we are searching duplicates for.
     * @return true if duplicates are found, false if not.
     */
    public boolean contains(String name) {
        for (int i = 0; i < closet.size(); i++) {
            if (closet.get(i).getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * a different rendition of contains that will avoid a certain index in the
     * collection. This serves the bullet proofing of the edit button so that
     * the program will not stop the user from editing their clothing when they
     * decide to not change the name.
     *
     * @param avoid the index to avoid when searching for duplicates in the
     * collection.
     * @param name the name to which we are searching duplicates of.
     * @return true if duplicates are found, false if not.
     */
    public boolean containsForEdit(int avoid,String name) {
        for (int i = 0; i < closet.size(); i++) {
            if (closet.get(i).getName().equals(name) && i != avoid) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * a sorted snapshot of the collection as an array.
     * 
     * @return the snapshot array of the collection.
     */
    public Clothing[] getSortedArray() {
        //sorting ArrayList
        Collections.sort(closet);
        //returning snapshot of ArrayList as an array
        
        return closet.toArray(new Clothing[closet.size()]);
    }
    
    /**
     * finds the total price of all the clothing found in the collection.
     * 
     * @return the total price of all the clothing.
     */
    public String totalPrice() {
        double total = 0;
        for (int i = 0; i < closet.size(); i++) {
            //adding the value of each clothings price to total
            total += closet.get(i).getCost();
        }
        //returning total as a double so that the value can be added to txtStats
        return Double.toString(total);
    }
    
    /**
     * finds the average price of all the clothing found in collection.
     * 
     * @return the average price of all the clothing.
     */
    public String avgPrice() {
        double avg;
        double total = 0;
        for (int i = 0; i < closet.size(); i++) {
            //adding the value of each clothings price to total
            total += closet.get(i).getCost();
        }
        //finding the mean of the clothing and returning
        avg = total / closet.size();
        return Double.toString(Math.round(avg * 100) / 100);
    }
    
    /**
     * makes a string representation of a chosen article of clothing found at
     * index. The method provides the name, size, fabric, and price of the
     * chosen clothing.
     * 
     * @param index the index of the clothing we want to toString.
     * @return a representation of the chosen clothing and its attributes.
     */
    public String toString(int index) {
        return (index + 1) + ". Name: " + closet.get(index).getName() + 
                ", Size: " + closet.get(index).getSize() + ", Fabric: " +
                closet.get(index).getFabric() + ", Price: " +
                closet.get(index).getCost();
    }
    
    /**
     * updates the serialization to have the most current rendition of the
     * clothing collection.
     * 
     * @return false if the update was not successful, true if it was.
     */
    private boolean writeCollection() {
        boolean success = true;
        try (FileOutputStream fos = new FileOutputStream("clothing.ser"); 
                ObjectOutputStream output = new ObjectOutputStream(fos)) {
                output.writeObject(closet);
        } catch (Exception ex) {
            System.out.println("Cannot write to file:\n" + ex.getMessage());
            success = false;
        }
        return success;
    }
    
    /**
     * reads in whats currently stored in serialization and sets the clothing
     * collection to whats was stored.
     * 
     * @return false if the read was not successful, true if it was.
     */
    private boolean readCollection() {
        boolean success = true;
        File ser = new File("clothing.ser");
        if (ser.exists()) {
            try (FileInputStream fis = new FileInputStream("clothing.ser"); 
                    ObjectInputStream input = new ObjectInputStream(fis)) {
                closet = (ArrayList<Clothing>) input.readObject();
            } catch (Exception ex) {
                System.out.println("cannot read from file:\n" 
                        + ex.getMessage());
                success = false;
            }
        }
        return success;
    }
}
