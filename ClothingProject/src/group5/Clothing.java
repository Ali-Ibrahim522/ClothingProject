package group5;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class holds all the methods and constructor in charge of making one
 * article of clothing. the singular piece of clothing has 4 attributes: Name,
 * Size, Fabric, Price. Getters and setters for all the fields are included
 * with equals, hash code, compareTo, and toString.
 * 
 * @author Ali Ibrahim, Hugo Wang, Juan Seo
 * @version 11/30/2020
 */
public class Clothing implements Comparable<Clothing>, Serializable{
    //field for the parts of the clothing.
    private String name;
    private String fabric;
    private String size;
    private double cost;
    
    /**
     * Creates a new article of clothing with a name, fabric, size, and cost.
     * 
     * @param name the value to set name to.
     * @param fabric the value to set fabric to.
     * @param size the value to set size to.
     * @param cost the value to set cost to.
     */
    public Clothing(String name, String fabric, String size, double cost) {
        this.name = name;
        this.fabric = fabric;
        this.size = size;
        this.cost = cost;
    }

    /**
     * provides access to the name of the clothing.
     * 
     * @return the name of the clothing.
     */
    public String getName() {
        return name;
    }

    /**
     * allows the name of the clothing to be set.
     * 
     * @param name the value to which the name of the clothing will be set to.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * provides access to the fabric of the clothing.
     * 
     * @return the fabric of the clothing.
     */
    public String getFabric() {
        return fabric;
    }

    /**
     * allows the fabric of the clothing to be set.
     * 
     * @param fabric the value to which the fabric of the clothing will be
     * set to.
     */
    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    /**
     * provides the size of the clothing.
     * 
     * @return the size of the clothing.
     */
    public String getSize() {
        return size;
    }

    /**
     * allows the size of the clothing to be set.
     * 
     * @param size the value to which the size of the clothing will be set to.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * provides access to the cost of the clothing.
     *
     * @return the cost of the clothing.
     */
    public double getCost() {
        return cost;
    }

    /**
     * allows the cost of the clothing to be set.
     * 
     * @param cost the value to which the cost of the clothing will be set to.
     */
    public void setCost(double cost) {
        this.cost = cost;
    }
    
    /**
     * calculates the hash code of the clothing.
     *
     * @return the hash code of the clothing.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
    /**
     * sees if two articles of clothing are the same by comparing their name and
     * returning true or false accordingly.
     * 
     * @param obj the clothing that is seen if equals to.
     * @return if the two clothing have the same name or not.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clothing other = (Clothing) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    /**
     * provides access to the name of clothing, we are only returning the name
     * because the combo box in clothingView automatically toStrings the
     * clothing that's in it as the display name of the clothing when they are
     * held inside the combo box.
     *
     * @return the name of the clothing.
     */
    @Override
    public String toString() {
        return name;
    }
    
    /**
     * compares the name of two pieces of clothing. This isn't used much in the
     * program besides for Collection.sort().
     * 
     * @param o the clothing that is compared to.
     * @return the int value representing how different the two clothing's
     * name are.
     */
    @Override
    public int compareTo(Clothing o) {
        return this.name.compareTo(o.name);
    }
}
