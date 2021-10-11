package group5;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 * This class handles all the front end aspects of the program using Swing.
 * The class allows the user to add, edit, and remove clothing from their
 * "closet" and view any article of clothing in their closet and their
 * attributes. The class handles the programing of all buttons and displays
 * including the display of stats. Other small additions include bullet proofing
 * of users desired additions and edits of clothing and user friendly design to
 * ease potential user confusion. Lastly, some images made in photoshop are
 * added to make the program look cleaner and more desirable.
 * 
 * @author Ali Ibrahim, Hugo Wang, Juan Seo
 * @version 11/30/2020
 */
public class ClothingView extends JFrame{
    //the collection of clothing used for the GUI
    ClothingCollection closet = new ClothingCollection();
    //decleration of all parts of GUI
    JComboBox cmboNames;
    JLabel lblBackground;
    JLabel lblName;
    JTextField txtName;
    JLabel lblSize;
    JTextField txtSize;
    JLabel lblFabric;
    JTextField txtFabric;
    JLabel lblPrice;
    JTextField txtPrice;
    JButton btnNew;
    JButton btnDelete;
    JButton btnEdit;
    JButton btnStats;
    JButton btnSubmit;
    JButton btnBack;
    JButton btnSubmitDlt;
    JTextArea txtStats;
    String stats;

    /**
     * creates the whole GUI by running the addComponents method and
     * addEventHandlers method. the constructor also takes in a title parameter
     * which becomes the name of the window frame.
     * 
     * @param title the name of the JFrame that will show on the window when
     * the program is ran.
     */
    public ClothingView(String title) {
        super(title);
        addComponents();
        addEventHandlers();
    }
    
    /**
     * initializes all the parts of our GUI including the frame, buttons,
     * labels, text areas, and text fields. The method also adjusts them to the
     * right spots, sizes, fonts, colors, and images.
     */
    private void addComponents() {
        //setting up window
        this.setSize(650, 650);
        //I personally perfer to set the bounds and sizes of my btns, lbls,
        //etc via setBounds()
        this.setLayout(null);
        //COMBOBOX
        cmboNames = new JComboBox(closet.getSortedArray());
        cmboNames.setBackground(Color.LIGHT_GRAY);
        cmboNames.setBounds(185, 50, 275, 30);
        this.add(cmboNames);
        cmboNames.setSelectedIndex(-1);
        //NAME
        lblName = new JLabel("Name: ");
        txtName = new JTextField();
        lblName.setBounds(125, 100, 100, 100);
        txtName.setBounds(225, 140, 275, 30);
        lblName.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        lblName.setForeground(Color.YELLOW);
        txtName.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        txtName.setEditable(false);
        this.add(lblName);
        this.add(txtName);
        //SIZE
        lblSize = new JLabel("Size: ");
        txtSize = new JTextField();
        lblSize.setBounds(145, 150, 100, 100);
        txtSize.setBounds(225, 190, 275, 30);
        lblSize.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        lblSize.setForeground(Color.YELLOW);
        txtSize.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        txtSize.setEditable(false);
        this.add(lblSize);
        this.add(txtSize);
        //FABRIC   
        lblFabric = new JLabel("Fabric: ");
        txtFabric = new JTextField();
        lblFabric.setBounds(120, 200, 100, 100);
        txtFabric.setBounds(225, 240, 275, 30);
        lblFabric.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        lblFabric.setForeground(Color.YELLOW);
        txtFabric.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        txtFabric.setEditable(false);
        this.add(lblFabric);
        this.add(txtFabric);
        //PRICE
        lblPrice = new JLabel("Price: ");
        txtPrice = new JTextField();
        lblPrice.setBounds(135, 250, 100, 100);
        txtPrice.setBounds(225, 290, 275, 30);
        lblPrice.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
        lblPrice.setForeground(Color.YELLOW);
        txtPrice.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        txtPrice.setEditable(false);
        this.add(lblPrice);
        this.add(txtPrice);
        //NEW
        btnNew = new JButton("NEW");
        btnNew.setBackground(Color.LIGHT_GRAY);
        btnNew.setBounds(120, 340, 125, 75);
        this.add(btnNew);
        //DELETE
        btnDelete = new JButton("DELETE");
        btnDelete.setBackground(Color.LIGHT_GRAY);
        btnDelete.setBounds(250, 340, 125, 75);
        this.add(btnDelete);
        //UPDATE
        btnEdit = new JButton("EDIT");
        btnEdit.setBackground(Color.LIGHT_GRAY);
        btnEdit.setBounds(380, 340, 125, 75);
        this.add(btnEdit);
        //STATS
        btnStats = new JButton("STATS");
        btnStats.setBackground(Color.LIGHT_GRAY);
        btnStats.setBounds(120, 425, 385, 50);
        this.add(btnStats);
        //Submit
        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setBackground(Color.green);
        btnSubmit.setBounds(250, 340, 125, 75);
        btnSubmit.setVisible(false);
        this.add(btnSubmit);
        //Submit if delete
        btnSubmitDlt = new JButton("SUBMIT");
        btnSubmitDlt.setBackground(Color.green);
        btnSubmitDlt.setBounds(250, 340, 125, 75);
        btnSubmitDlt.setVisible(false);
        this.add(btnSubmitDlt);
        //Back
        btnBack = new JButton("BACK");
        btnBack.setBackground(Color.red);
        btnBack.setBounds(380, 340, 125, 75);
        btnBack.setVisible(false);
        this.add(btnBack);
        //(txt)STATS
        txtStats = new JTextArea();
        txtStats.setBounds(0, 0, 634, 611);
        txtStats.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        txtStats.setEditable(false);
        txtStats.setVisible(false);
        this.add(txtStats);
        //BACKGROUND
        //635x611
        lblBackground = new JLabel();
        lblBackground.setIcon(new ImageIcon(this.getClass().getResource("/images/background.jpg")));
        lblBackground.setBounds(0, 0, 635, 611);
        this.add(lblBackground);
    }
    
    /**
     * the code for the back button used when the user presses back after
     * pressing new, delete, or edit. Allows the window to return to its
     * "Home screen". The method is also in charge of going from the home screen
     * to the respective screen needed for new, delete, and edit, the code knows
     * which one to do because of the Boolean parameter status.
     * 
     * @param status if false the program is moving from the home screen to the
     * screen needed for the button pressed before hand, if true the method is
     * reverting the window back to the home screen.
     */
    public void back(boolean status) {
        //hiding unessary buttons
        btnNew.setVisible(status);
        btnDelete.setVisible(status);
        btnEdit.setVisible(status);
        btnStats.setVisible(status);
        //showing new buttons needed
        btnSubmit.setVisible(!status);
        btnBack.setVisible(!status);
    }
    
    /**
     * rendition of the back function that is in charge of going back or from
     * the home screen when the user presses stats.
     * 
     * @param status if false the program is moving from the home screen to the
     * screen needed for the button pressed before hand, if true the method is
     * reverting the window back to the home screen.
     */
    public void largeBack(boolean status) {
        //hiding unessary buttons
        cmboNames.setVisible(status);
        lblName.setVisible(status);
        txtName.setVisible(status);
        lblSize.setVisible(status);
        txtSize.setVisible(status);
        lblFabric.setVisible(status);
        txtFabric.setVisible(status);
        lblPrice.setVisible(status);
        txtPrice.setVisible(status);
        btnNew.setVisible(status);
        btnDelete.setVisible(status);
        btnEdit.setVisible(status);
        btnStats.setVisible(status);
        btnSubmit.setVisible(status);
        btnSubmitDlt.setVisible(status);
        //showing new buttons needed
        txtStats.setVisible(!status);
        btnBack.setVisible(!status);
    }
    
    /**
     * this method is repeated code for when the user presses submit for a new
     * piece of clothing or when they are editing a new piece of clothing. The
     * method starts by checking if the user has inputted something for each of
     * the boxes and then bulletproofs their inputs and asks the user to fix any
     * issues they have with their inputs.
     * 
     * @return whether a successful submission is possible or not, false if
     * its not true if it is.
     */
    public boolean submit() {
        //boolean for if its ok to move on with the users submission
        boolean okSubmit = false;
        //if user has inputted something for every box
        if (!(txtName.getText().isEmpty() || txtSize.getText().isEmpty()
                        || txtFabric.getText().isEmpty() || 
                        txtPrice.getText().isEmpty())) {
            okSubmit = true;
            //try catch bulletproofing to see if the price inputted 
            //is a exceptable input
            double testParse;
            boolean ok = false;
            //bullet proofin of name
            do {
                ok = true;
                if (cmboNames.getSelectedIndex() == -1 && (closet.contains(txtName.getText()) || txtName.getText().equals(""))) {
                    ok = false;
                    txtName.setText(JOptionPane.showInputDialog("There is already an article of clothing with this name, try something else."));
                } else if (cmboNames.getSelectedIndex() != -1 && (closet.containsForEdit(cmboNames.getSelectedIndex() ,txtName.getText()) || txtName.getText().equals(""))) {
                    ok = false;
                    txtName.setText(JOptionPane.showInputDialog("There is already an article of clothing with this name, try something else."));
                }
            } while(!ok);
            //bullet proofing of price
            do {
                try {
                    testParse = Double.parseDouble(txtPrice.getText());
                    ok = true;
                    if (txtPrice.getText().contains(".")) {
                        if ((txtPrice.getText().length() - 1) - (txtPrice.getText().indexOf(".")) > 2) {
                            txtPrice.setText(JOptionPane.showInputDialog("The price you inputted is not acceptable, please try again."));
                            ok = false;
                        }
                    }
                } catch (NumberFormatException nfe) {
                    txtPrice.setText(JOptionPane.showInputDialog("The price you inputted is not acceptable, please try again."));
                    ok = false;
                }
            } while(!ok);
        } else {
            JOptionPane.showMessageDialog(ClothingView.this, "you must fill every box when making a new article of clothing or editing a pre-exsisting one.");
        }
    return okSubmit;
    }
    
    /**
     * this method holds all the action listener for all the buttons and item listener for the combo box.
     */
    private void addEventHandlers() {
        /**
         * action listener for btnStats, will activate the code inside when the
         * stats button is set.
         */
        btnStats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //hides the home screen and present the stats text area
                largeBack(false);
                //moves the back button to the bottom right corner to
                //accomadate for the potentially large amount of text in
                //txtStats
                btnBack.setBounds(495, 520, 125, 75);
                stats = "";
                //adding the stats of each clothing to the stats variable
                for (int i = 0; i < closet.size(); i++) {
                    stats += closet.toString(i);
                    stats += "\n";
                }
                //adding the total price and average price the variable stats
                stats += "Total Price: " + closet.totalPrice() + "\n";
                stats += "Average Price: " + closet.avgPrice();
                //setting the visual text area, txtStats, to the combined
                //string variable, stats
                txtStats.setText(stats);
            }
        });
        
        /**
         * item listener for the combo box, activates when the user selects an
         * item from the combo box.
         */
        cmboNames.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                //-1 is the index of unselected and the program will crash if we
                //try to set text from a non exsisting index. So we make it so
                //that the code will only work if the index is one of an actual
                //piece of clothing.
                if (cmboNames.getSelectedIndex() != -1) {
                //grabbing Clothing details and adding to corrosponding
                //textboxes
                    txtName.setText(closet.getClothing(
                            cmboNames.getSelectedIndex()).getName());
                    txtSize.setText(closet.getClothing(
                            cmboNames.getSelectedIndex()).getSize());
                    txtFabric.setText(closet.getClothing(
                            cmboNames.getSelectedIndex()).getFabric());
                    txtPrice.setText(Double.toString(closet.getClothing(
                            cmboNames.getSelectedIndex()).getCost()));
                }
            }
        });
        
        /**
         * action listener for when the button btnNew is pressed, this method is
         * in charge of setting up the window to allow the user to input
         * their clothing.
         */
        btnNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //clearing the text for the user to avoid confusion
                txtName.setText("");
                txtSize.setText("");
                txtFabric.setText("");
                txtPrice.setText(""); 
                //allowing user to edit txt fields
                txtName.setEditable(true);
                txtSize.setEditable(true);
                txtFabric.setEditable(true);
                txtPrice.setEditable(true);
                //creating screen for user
                back(false);
                //setting selected index to nothing for user friendly purposes
                //and hiding combo box to avoid user error
                cmboNames.setSelectedIndex(-1);
                cmboNames.setVisible(false);
            }
        });
        
        /**
         * action listener for when the button btnDelete is pressed, this method
         * is in charge of setting up the window to allow the user to delete
         * clothing. similar code to back(), but pushes the SubmitDlt to the
         * front.
         */
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //hiding unessary buttons
                btnNew.setVisible(false);
                btnDelete.setVisible(false);
                btnEdit.setVisible(false);
                btnStats.setVisible(false);
                //showing new buttons needed to complete deleting clothing
                btnSubmitDlt.setVisible(true);
                btnBack.setVisible(true);
            }
        });
        
        /**
         * a special rendition of the submit button that handles the submission
         * of a deletion of clothing
         */
        btnSubmitDlt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cmboNames.getSelectedIndex() != -1) {
                    //saving index and clothing in combo box
                    int index = cmboNames.getSelectedIndex();
                    Clothing dltClothing = closet.getClothing(cmboNames.getSelectedIndex());
                    //removing said clothing
                    cmboNames.removeItem(dltClothing);
                    closet.removeClothing(index);
                    //reverting UI to home page
                    txtName.setText("");
                    txtSize.setText("");
                    txtFabric.setText("");
                    txtPrice.setText("");
                    back(true);
                    btnSubmitDlt.setVisible(false);
                    cmboNames.setSelectedIndex(-1);
                } else {
                    JOptionPane.showMessageDialog(ClothingView.this, "You dont have a article of clothing selected to delete, click on the drop down menu to pick one.");
                }
            }
        });
        
        /**
         * this method handles the submission of new clothing and edited clothing 
         */
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //checking to see if user has inputed text for every detail of
                //the clothing
                boolean success = submit();
                //submission of edit
                if (success == true) {
                    if (cmboNames.getSelectedIndex() != -1) {
                        //saving the current index and element from collection
                        int index = cmboNames.getSelectedIndex();
                        Clothing dltClothing = closet.getClothing(index);
                        //removing said clothing
                        closet.removeClothing(index);
                        closet.addClothing(new Clothing(txtName.getText(), txtFabric.getText(), txtSize.getText(), Double.parseDouble(txtPrice.getText())));
                        //removing clothing from GUI
                        cmboNames.removeItem(dltClothing);
                        //adding clothing to GUI
                        cmboNames.addItem(closet.getClothing(closet.size() - 1));
                        //returning to home screen
                        txtName.setText("");
                        txtSize.setText("");
                        txtFabric.setText("");
                        txtPrice.setText("");
                        back(true);
                        cmboNames.setSelectedIndex(-1);
                    //submission on new
                    } else {
                        //making the new Clothing
                        closet.addClothing(new Clothing(txtName.getText(), txtFabric.getText(), txtSize.getText(), Double.parseDouble(txtPrice.getText())));
                        //adding to comboBox
                        cmboNames.addItem(closet.getClothing(closet.size() - 1));
                        //return window to home screen
                        txtName.setText("");
                        txtSize.setText("");
                        txtFabric.setText("");
                        txtPrice.setText("");
                        back(true);
                        cmboNames.setSelectedIndex(-1);
                        cmboNames.setVisible(true);
                    }
                    //setting the txt fields to not editable on the home screen
                    txtName.setEditable(false);
                    txtSize.setEditable(false);
                    txtFabric.setEditable(false);
                    txtPrice.setEditable(false);
                }
            }
        });
        
        /**
         * this method is in charge of returning to the home screen when they
         * are on the new, edit, delete, or stats screen.
         */
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //back if they are at the stats screen
                if (txtStats.isVisible() == false) {
                    txtName.setText("");
                    txtSize.setText("");
                    txtFabric.setText("");
                    txtPrice.setText(""); 
                    back(true);
                    cmboNames.setVisible(true);
                    cmboNames.setSelectedIndex(-1);
                    //setting the txt fields to not editable on the home screen
                    txtName.setEditable(false);
                    txtSize.setEditable(false);
                    txtFabric.setEditable(false);
                    txtPrice.setEditable(false);
                //back if they are on any other screen
                } else {
                    txtStats.setText("");
                    largeBack(true);
                    btnBack.setBounds(380, 340, 125, 75);
                }
            }
        });
        
        /**
         * this method sets up the screen to which allows the user to edit an
         * article of clothing. Edit will only happen if there are clothing in
         * the closet.
         */
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //if there are clothing in the closet
                if (!closet.isEmpty()) {
                    //allowing user to edit txt fields
                    txtName.setEditable(true);
                    txtSize.setEditable(true);
                    txtFabric.setEditable(true);
                    txtPrice.setEditable(true);
                    //setting up screen
                    back(false);
                    //pushing user selection on cmbo box off of unselected to
                    //avoid user errors.
                    if (cmboNames.getSelectedIndex() == -1) {
                        cmboNames.setSelectedIndex(0);
                    }
               //dont allow user to edit if closet is empty   
               } else {
                    //notifying user of why they cant edit clothing.
                    JOptionPane.showMessageDialog(ClothingView.this, "You have no clothing in your closet, try adding some.");
               }
            }
        });
        
    }
}