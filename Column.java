/**Jacob Williams, Logan Newsom, Parker Billinger, Trey Etzel
CIS 200 Scholar's section
Column.java

This class defines a 1x9 column item for the Sudoku board. There will only ever be 9 of these made for one Sudoku.
This is sort of like an array with with one column and 9 rows.

**/
import java.util.*;


public class Column {
  private Item[] list = new Item[9];
  
  /** Column(ArrayList<Item>)
@param ArrayList<Item> This arraylist is the 9 item objects that are within the 1x9 column object.
This instantiates a Column object with the items within the arraylist.
**/
  public Column(Item[] l) {
    for(int i = 0; i < list.length; i++) {
      list[i] = l[i];
    }
  }
  
/**getVal(int)
@param pos This is the integer value of the position in the column that is being looked at for its value.
This method returns the value of whatever item is located at the passed in position.
The Column would be indexed like this [0,
									   1,
									   2,
									   3,
									   4,
									   5,
									   6,
									   7,
									   8]
**/
  public int getVal(int pos) {
    return list[pos].getVal();
  }
  
  /**setVal(int, Item)
@param int pos This is the position in the Column that is being updated
@param Item i This is the item that is being passed into the Column to update the value at a given location
This method updates the item in the Column at a the requested position.
**/
  public void setVal(int pos, Item i) {
    list[pos] = i;
  }
  
  /**toString()
  This method returns the string of the values of the Column, in order, on a single line.
  **/
  public String toString() {
    String temp = "";
    for(Item i: list) {
      temp += i.getVal() + " ";
    }
    temp += "\n";
    return temp;
  }
  
  /**contains(int)
  @param int val This is the integer value that is being checked if it is already in the Column.
  @return This returns true if the value is in Column object, else it returns false.
  This method was made to check if a value already exits within the Column.
  **/
  public boolean contains(int val) {
    for(Item i: list) {
      if(i.getVal() == val) {
        return true;
      }
    }
    return false;
  }
  
   /**isValid()
  @return This returns true if the Column is complete and false if it is not.
  This method checks if every possible value is in the Column meaning that the Column is complete.
  **/
  public boolean isValid() {
    return this.contains(1) && this.contains(2) && this.contains(3) && this.contains(4) && this.contains(5) && this.contains(6) && this.contains(7) && this.contains(8) && this.contains(9);
  }
    /**isPossible()
  This checks for duplicate numbers before we solve the sudoku to prevent attempting to solve an impossible sudoku.
  **/
  public boolean isPossible() {
    for(int i = 0; i < list.length-1; i++) {
      for(int j = i+1; j < list.length;j++) {
        if(list[j].getVal() != 0 && list[i].getVal() != 0 && list[j].getVal() == list[i].getVal()){
          return false;
        }
      }
    }
    return true;
  }
}