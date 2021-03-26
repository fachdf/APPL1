package main;

// ******************************************************************
// RatePanel.java
//
// Panel for a program that converts different currencies to
// U.S. Dollars
// ******************************************************************
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class RatePanel extends JPanel{
    private double[] rate; // exchange rates
    private String[] currencyName;
    private JLabel result;
    private JComboBox comboBox;
    private JTextField textField;
    private JLabel howMuch; 
    // ------------------------------------------------------------
    // Sets up a panel to convert cost from one of 6 currencies
    // into U.S. Dollars. The panel contains a heading, a text
    // field for the cost of the item, a combo box for selecting
    // the currency, and a label to display the result.
    // ------------------------------------------------------------
    public RatePanel (){
        JLabel title = new JLabel ("How much is that in dollars?");
        title.setBounds(200, 100, 50, 50);
        title.setAlignmentX (Component.CENTER_ALIGNMENT);
        title.setFont (new Font ("Helvetica", Font.BOLD, 20));
        
        // Set up the arrays for the currency conversions
        currencyName = new String[] {"Select the currency..", "European Euro", "Canadian Dollar", "Japanese Yen", 
            "Australian Dollar", "Indian Rupee", "Mexican Peso"};
        rate = new double [] {0.0, 1.2103, 0.7351, 0.0091, 0.6969, 0.0222, 0.0880};
        
        comboBox = new JComboBox(currencyName);
        howMuch = new JLabel("Amount of Money you Want to Convert");
        
        textField = new JTextField(20);
        textField.addActionListener(new ComboListener());
        
        result = new JLabel (" ------------ ");
        result.setLocation(300, 300);
        
        add(title);
        add(comboBox);
        add(howMuch);
        add(textField);
        add(result);
    }
    
    // ******************************************************
    // Represents an action listener for the combo box.
    // ******************************************************
    private class ComboListener implements ActionListener{
        // --------------------------------------------------
        // Determines which currency has been selected and
        // the value in that currency then computes and
        // displays the value in U.S. Dollars.
        // --------------------------------------------------
        @Override
        public void actionPerformed (ActionEvent event){
            double val;
            // jika tidak diisi, maka value currency nya 0
            if (textField.getText().equals("")){
                val = 0;
            }else{
                val = Double.parseDouble(textField.getText());
            }
            
            int index = comboBox.getSelectedIndex();
            result.setText (val +" "+ currencyName[index] +
                    " = " + (rate[index] * val) + " U.S. Dollars");
        }
    }
}