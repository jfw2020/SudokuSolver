/**Jacob Williams, Logan Newsom, Parker Billinger, Trey Etzel
 * CIS 200 Scholar's section
 * GUIOutput.java
 * 
 * This class works as a view class, but only handling GUI output of the sudoku board. The class has two static methods.
 * The first is for printing the board as it is being solved by the Sudoku class. The other class is a message to the user
 * displaying whether the Sudoku was solved or if the sudoku is unsolvable.
 */
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.util.*;
public class GUIOutput {
  static JFrame frame = new JFrame("Sudoku Solver");
   /**printBoardGUI(Item[] list, int counter)
   This prints the sudoku board using a JFrame object. It controls the window size, font size, and other attributes of the output format.
   @param Item[] list this is a list of 81 Item objects that represent each board position
   @param int counter this the number of iterations that have been completed by the backtracking algorithm
  **/
  public static void printBoardGUI(Item[] list, int counter) throws InterruptedException {
    StringBuilder sb = new StringBuilder();
    //Thread.sleep(36);
    sb.append("Iterations: " + counter + "\n" + " ------------------------------" + "\n");
    for(int i = 0; i < 9; i++) {
      sb.append(" |  ");
      for(int j = 0; j < 9; j++) {
        sb.append(list[i*9 + j].getVal() + " ");
        if(j % 3 == 2) {
          sb.append(" |  ");
        }
      }
      sb.append("\n");
      if(i % 3 == 2) {
        sb.append(" ------------------------------\n");
      }
    }
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().removeAll();
    JTextArea ta = new JTextArea(sb.toString());
    ta.setPreferredSize(new Dimension(500, 500));
    ta.setFont(new Font("Times New Roman", Font.BOLD, 30));
    ta.setEditable(false);
    frame.add(ta);
    frame.pack();
    frame.setVisible(true);
  }
  
  /**printSolved(boolean b)
   This prints a message for the user indicating whether the sudoku was solved by backtracking or if the sudoku is unsolvable.
   @param boolean b this is a boolean representing whether or not the backtrackign algorithm was able to solve the sudoku
  **/
  public static void printSolved(boolean b) {
    if(!b) {
      JOptionPane.showMessageDialog(null, "Unsolvable Sudoku");
    } else {
      JOptionPane.showMessageDialog(null, "Solved!");
    }
  }
}