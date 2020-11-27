/**Jacob Williams, Logan Newsom, Parker Billinger, Trey Etzel
 * CIS 200 Scholar's section
 * Sudoku.java
 * 
 * This class works as the model class, all calculations take place here. The class has many different methods that control interactions between
 * row, colummn, box, and item classes. It also interacts with the GUIOutput class and prints the board between a set number of iterations.
 * The solve method uses a backtracking algorithm to solve the sudoku. 
 */
import java.util.*;
import java.io.*;
public class Sudoku {
  private Item[] list = new Item[81];
  private Column[] columns = new Column[9]; // columns
  private Row[] rows = new Row[9]; // rows
  private Box[] boxes = new Box[9]; // boxes
  private int counter = 0; // number iterations completed in the solving algorithm
  private int iterationsPerDisplay;
  public boolean isPossible = true;
  
  /**Sudoku(Item[] vals, int iterationBreak)
    * This is the constructor for a sudoku object that represents a sudoku board.
    * @param Item[] vals this is a list of Item objects that represent each number on the board
    * @param int iterationBreak this is the number of iterations the backtracking algorithm will complete between display updates
    */
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
    
    boolean columnsValid = true;
    boolean rowsValid = true;
    boolean boxesValid = true;
    for(Column c: columns) {
      if(!c.isPossible()){
        columnsValid = false;
        break;
      }
    }
    for(Row r: rows) {
      if(!r.isPossible()){
        rowsValid = false;
        break;
      }
    }
    for(Box b: boxes) {
      if(!b.isPossible()){
        boxesValid = false;
        break;
      }
    }
    isPossible = columnsValid && boxesValid && rowsValid;
    if(!isPossible) {
      GUIOutput.printSolved(false);
    }
  }
  
  /**solve()
    * This is the solve method that uses backtracking to solve the sudoku. It prints the board between a set number of iterations
    */
  public boolean solve() throws InterruptedException{
    counter++;
    if(counter % iterationsPerDisplay == 0) {
      this.printBoardgui();
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
  
  /**printBoard()
    * This is the non-GUI printboard method. It is not used in the most recent version of this program.
    * It uses console output for printing the sudoku.
    */
  public void printBoard() {
    /* Clears Screen
     * Clear screen code Sourced from stack overflow user Ankush Mundhra
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
  
  // TESTING PURPOSES ONLY
  /**printAll()
    * TESTING PURPOSES ONLY
    * This prints out all the values of the rows, columns, and boxes
    */
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
  
  public void printBoardgui() throws InterruptedException {
    GUIOutput.printBoardGUI(list, counter);
  }
  
  
  // TESTING PURPOSES ONLY
  /**printAll()
    * TESTING PURPOSES ONLY
    * tests the Contains() methods for rows, colunns, and boxes
    */
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
  
  // TESTING PURPOSES ONLY
  /**printAll()
    * TESTING PURPOSES ONLY
    * This prints out all of the rows, columns, and boxes that are valid
    */
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
  
  // TESTING PURPOSES ONLY
  /**printAll()
    * TESTING PURPOSES ONLY
    * This prints out all the of the items and their position on the board
    */
  public void printItemsAndPositions() {
    for(Item i: list) {
      System.out.println(i + ": " + i.getPosArr());
    }
  }
  
  
  /**createSubArray()
    * This creates a subarray of Items of length 9. This is used in the constructor for a sudoku object
    * @param int start this is the starting index of where you want the subarray to begin
    * @return Item[] this is a subarray of Item objects starting from the inputted start index. It is of length 9
    */
  private Item[] createSubArray(int start) {
    Item[] temp = new Item[9];
    int c = 0;
    for(int i = start; i < start + 9; i++) {
      temp[c] = list[i];
      c++;
    }
    return temp;
  }
  
  /**CountUnsolvedItems()
    * This counts the number of empty items in the sudoku board. Used in the backtracking algorithm
    * @return int this is the number of empty items in the sudoku board.
    */
  private int countUnsolvedItems() {
    int count = 0;
    for(int i = 0; i < list.length; i++) {
      if(list[i].getVal() == 0) {
        count++;
      }
    }
    return count;
  }
  
   /**findNextItem()
    * This finds the next empty item object in the sudoku board. Used in the backtracking algorithm
    * @return Item this is the next empty item on the board
    */
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
  
   /**isPotentialSolution(int i, Item item)
    * This checks if a number value could be a potential solution given an Item. Used in the backtracking algorithm
    * @return boolean this is a boolean representing whether or not the number is a potential solution for a given Item object
    */
  private boolean isPotentialSolution(int i, Item item) {
    return !rows[item.getRow()].contains(i) && !columns[item.getColumn()].contains(i) && !boxes[item.getBox()].contains(i);
  }
}
