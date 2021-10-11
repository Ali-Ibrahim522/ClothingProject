package group5;

import javax.swing.JFrame;

/**
 * This class is in charge of running the clothing view class which in turn is
 * running the whole program. This is the method the user will run to start the
 * program.
 * 
 * @author Ali Ibrahim, Hugo Wang, Juan Seo
 * @version 11/30/2020
 */
public class ClothingProject {

    /**
     * this is method that runs the view class and sets the view class frame
     * to exit on close and visible.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClothingView view = new ClothingView("Your Closet");
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setVisible(true);
    }
    
}
