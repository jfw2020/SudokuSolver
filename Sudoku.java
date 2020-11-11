/* Add Iteration counter to cmd line argumentss
 * 
 * 
 * 
 */
import java.util.*;
import java.io.*;
public class Sudoku {
  private Item[] list = new Item[81];
  private Column[] columns = new Column[9];
  private Row[] rows = new Row[9];
  private Box[] boxes = new Box[9];
  private int counter = 0;
  private int iterationsPerDisplay;
  
  public Sudoku(Item[] vals, int iterationBreak) {
    iterationsPerDisplay = iterationBreak;
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
    
    // Create Box Objects
    int start = 0;
    int counter = 0; // Box Number (0 through 8)
    while(start < (9*7)) {
      ArrayList<Item> temp = new ArrayList<>();
      for(int n = start; n < start + (9*3); n+= 9) {
        for(int j = 0; j < 3; j++) {
          temp.add(list[n+j]);
        }
      }
      // counter = box num @ this point
      boxes[counter] = new Box(temp);
      if(start == 6 || start == 33) {
        start += 21;
      } else {
        start += 3;
      }
      counter++;
    } // end while
    
    // Create Columns
    for(int i = 0; i < 9; i ++) {
      Item[] temp = new Item[9];
      for(int j = i; j < 81; j += 9) {
        temp[(int)(j/9)] = list[j];
      }
      columns[i] = new Column(temp);
      // i % 9 = column number
    }
  }
  
  public boolean solve() {
    counter++;
    if(counter % iterationsPerDisplay == 0) {
      this.printBoard();
    }
    int numUnsolved = this.countUnsolvedItems();

    while(numUnsolved > 0) {
      Item temp = findNextItem();
      for(int i = 1; i < 10; i++) {
        if(this.isPotentialSolution(i, temp)) {
          temp.setVal(i);
          
          if(this.solve()){
            return true;
          } else {
            temp.setVal(0);
          }
        }
      }
      return false;
      
    }
    return true;
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
    System.out.println("Iterations: " + counter);
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
  
  // Testing Purposes
  public void printAll() {
    this.printBoard();
    System.out.println("\n\nRows: ");
    for(Row r: rows) {
      System.out.println(r);
    }
    this.printBoard();
    System.out.println("\n\nColumns: ");
    for(Column r: columns) {
      System.out.println(r);
    }
    this.printBoard();
    System.out.println("\n\nBoxes: ");
    for(Box r: boxes) {
      System.out.println(r);
    }
  }
  
  // Testing contains methods
  public void printCheckVal(int val) {
    System.out.println("\n\nRows that contain " + val);
    for(int i = 0; i < 9; i++) {
      System.out.print(rows[i].contains(val) + " ");
    }
    System.out.println("\n\nColumns that contain " + val);
    for(int i = 0; i < 9; i++) {
      System.out.print(columns[i].contains(val) + " ");
    }
    System.out.println("\n\nBoxes that contain " + val);
    for(int i = 0; i < 9; i++) {
      System.out.print(boxes[i].contains(val) + " ");
    }
  }
  
  public void printIsValid() {
    System.out.println("\n\nRows that are valid");
    for(int i = 0; i < 9; i++) {
      System.out.print(rows[i].isValid() + " ");
    }
    System.out.println("\n\nColumns that are valid");
    for(int i = 0; i < 9; i++) {
      System.out.print(columns[i].isValid() + " ");
    }
    System.out.println("\n\nBoxes that are valid");
    for(int i = 0; i < 9; i++) {
      System.out.print(boxes[i].isValid() + " ");
    }
  } 
  
  // For Testing Purposes
  public void printItemsAndPositions() {
    for(Item i: list) {
      System.out.println(i + ": " + i.getPosArr());
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
  
  private int countUnsolvedItems() {
    int count = 0;
    for(int i = 0; i < list.length; i++) {
      if(list[i].getVal() == 0) {
        count++;
      }
    }
    return count;
  }
  
  private Item findNextItem() {
    for(Item i: list) {
      if(i.getVal() == 0) {
        return i;
      }
    }
    // should never get here ******
    System.out.println("ERROR");
    return new Item(0);
  }
  
  private boolean isPotentialSolution(int i, Item item) {
    return !rows[item.getRow()].contains(i) && !columns[item.getColumn()].contains(i) && !boxes[item.getBox()].contains(i);
  }
}
