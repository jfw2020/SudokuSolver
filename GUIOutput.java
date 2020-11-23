import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.util.*;
public class GUIOutput {
  static JFrame frame = new JFrame("Sudoku Solver");
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
  
  public static void printSolved(boolean b) {
    if(!b) {
      JOptionPane.showMessageDialog(null, "Unsolvable Sudoku");
    } else {
      JOptionPane.showMessageDialog(null, "Solved!");
    }
  }
}