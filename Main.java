/**Jacob Williams, Logan Newsom, Parker Billinger, Trey Etzel
CIS 200 Scholar's section
Main.java

This class is contains the main method for the program. This class runs the FileInput to get the sudoku and how many steps the user
wants to skip between display updates. Then it checks that the sudoku is possible, and if so the program goes through the steps necessary 
to solve the sudoku puzzle. 
*/
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
public class Main {
  
  
  
  public static void main(String[] args) throws InterruptedException{
    /* There is a Huge Range of possible iterations any puzzle can have. Here are some demo puzzles
     * 9.4.7..3...2..3.64..39..1.2....12.....983..4..8...9...6...2...17.81.........6..9.     = 323 Iterations
     * 5.....8...8......5.....7.4......2.1......5..7.741...6...7...42.....637...1.2...83     = 761,311 Iterations
     * ...8.1.........43.5............7.8........1...2..3....6......75..34........2..6..     = 12,102,870 Iterations
     */
    FileInput f = new FileInput();
    Sudoku s = new Sudoku(f.readFile(),f.getIterations());
    if(s.isPossible) {
      if(s.solve()){
        s.printBoardgui();
        GUIOutput.printSolved(true);
      } else {
        GUIOutput.printSolved(false);
      }
    }
  }
}