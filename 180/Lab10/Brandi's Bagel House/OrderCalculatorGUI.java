import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * Elijah Ellis 
 * Thursday Decemeber 8 2016
   The OrderCalculatorGUI class creates the GUI for the
   Brandi's Bagel House application.
*/

public class OrderCalculatorGUI extends JFrame
{
   private BagelPanel bagels;     // Bagel panel
   private ToppingPanel toppings; // Topping panel
   private CoffeePanel coffee;    // Coffee panel
   private GreetingPanel banner;  // To display a greeting
   private JPanel buttonPanel;    // To hold the buttons
   private JButton calcButton;    // To calculate the cost
   private JButton exitButton;   // To exit the application
   private JButton aboutButton; 
   private final double TAX_RATE = 0.06; // Sales tax rate

   /**
      Constructor
   */

   public OrderCalculatorGUI()
   {
	  // Set look and feel
	   
	  try{ 
		  
		  UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		  SwingUtilities.updateComponentTreeUI(this);
		  
	  } catch (Exception e) {
		  
		  JOptionPane.showMessageDialog(null, "Error setting the look and feel");
		  System.exit(0);
		  
	  }
      // Display a title.
      setTitle("Order Calculator");

      // Specify an action for the close button.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Create a BorderLayout manager.
      setLayout(new BorderLayout());

      // Create the custom panels.
      banner = new GreetingPanel();
      bagels = new BagelPanel();
      toppings = new ToppingPanel();
      coffee = new CoffeePanel();

      // Create the button panel.
      buildButtonPanel();

      // Add the components to the content pane.
      add(banner, BorderLayout.NORTH);
      add(bagels, BorderLayout.CENTER);
      add(toppings, BorderLayout.EAST);
      add(coffee, BorderLayout.WEST);
      add(buttonPanel, BorderLayout.SOUTH);

      // Pack the contents of the window and display it.
      pack();
      setVisible(true);
   }

   /**
      The buildButtonPanel method builds the button panel.
   */

   private void buildButtonPanel()
   {
      // Create a panel for the buttons.
      buttonPanel = new JPanel();

      // Create the buttons.
      calcButton  = new JButton("Calculate");
      aboutButton = new JButton("About");
      exitButton  = new JButton("Exit");
      
      // Register the action listeners.
      calcButton.addActionListener(new CalcButtonListener());
      exitButton.addActionListener(new ExitButtonListener());
      aboutButton.addActionListener(new AboutButtonListener());

      // Add the buttons to the button panel.
      buttonPanel.add(calcButton);
      buttonPanel.add(exitButton);
      buttonPanel.add(aboutButton);
   }

   /**
      Private inner class that handles the event when
      the user clicks the Calculate button.
   */

   private class CalcButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         // Variables to hold the subtotal, tax, and total
         double subtotal, tax, total;

         // Calculate the subtotal.
         subtotal = bagels.getBagelCost() + 
                    toppings.getToppingCost() +
                    coffee.getCoffeeCost();

         // Calculate the sales tax.
         tax = subtotal * TAX_RATE;

         // Calculate the total.
         total = subtotal + tax;

         // Create a DecimalFormat object to format output.
         DecimalFormat dollar = new DecimalFormat("0.00");

         // Display the charges.
         JOptionPane.showMessageDialog(null, "Subtotal: $" +
                       dollar.format(subtotal) + "\n" +
                       "Tax: $" + dollar.format(tax) + "\n" +
                       "Total: $" + dollar.format(total));
      }
   }
   
   private class AboutButtonListener implements ActionListener
   {
	   public void actionPerformed(ActionEvent e)
	   {
		   JOptionPane.showMessageDialog(null, "Brandi's Bagel House \n 12/8/2016 \n Version: 1.0.0");
	   }
   }

   /**
      Private inner class that handles the event when
      the user clicks the Exit button.
   */

   private class ExitButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
          System.exit(0);
      }
   }
   
   /**
      main method
   */
   
   public static void main(String[] args)
   {
      new OrderCalculatorGUI();
   }
}