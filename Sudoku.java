import java.util.*;
import java.io.*;
public class Sudoku {
  private Item[] list = new Item[81];
  private Column[] columns = new Column[9];
  private Row[] rows = new Row[9];
  private Box[] boxes = new Box[9];
  
  public Sudoku(Item[] vals) {
    for(int i = 0; i < vals.length; i++) {
      list[i] = vals[i];
    }
    
    // Create Row Objects
    for(int i = 0; i < list.length; i++) { // loop through all numbers in Sudoku (81 in length)
      Item[] tempRow = new Item[9];
      if(i%9 == 0) {
        tempRow = createSubArray(i);
        rows[(int)i/9] = new Row(tempRow);
      }
    }
    
    // Create Column Objects
    /*
    int c = 0;
    for(Row r: rows) {
      for(int i = 0; i < 9; i++) {
        
      }
      c++;
    }
    */
  }
  
  public void solve() {
    
  }
  
  public void printBoard() {
    /* Clears Screen
     * Code Sourced from stack overflow user Ankush Mundhra
     * https://stackoverflow.com/questions/19252496/clear-screen-with-windows-cls-command-in-java-console-application
     */
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      else
        Runtime.getRuntime().exec("clear");
    } catch (IOException ex){} catch (InterruptedException ex) {}
    
    System.out.println("-------------------------");
    for(int i = 0; i < 9; i++) {
      System.out.print("| ");
      for(int j = 0; j < 9; j++) {
        System.out.print(list[i*9 + j].getVal() + " ");
        if(j % 3 == 2) {
          System.out.print("| ");
        }
      }
      System.out.println();
      if(i % 3 == 2) {
        System.out.println("-------------------------");
      }
    }
  }
  
  private Item[] createSubArray(int start) {
    Item[] temp = new Item[9];
    int c = 0;
    for(int i = start; i < start + 9; i++) {
      temp[c] = list[i];
      c++;
    }
    return temp;
  }
  
}
