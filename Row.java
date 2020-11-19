/**Jacob Williams, Logan Newsom, Parker Billinger, Trey Etzel
CIS 200 Scholar's section
Row.java

This class defines a 9x1 Row item for the Sudoku board. There will only ever be 9 of these made for one Sudoku.
This is pretty much an array with 9 columns and 1 row.
**/
import java.util.*;

public class Row {
  private Item[] list = new Item[9];
  
  /** Row(ArrayList<Item>)
@param ArrayList<Item> This arraylist is the 9 item objects that are within the 3x3 Row object.
This instantiates a Row object with the items within the arraylist.
**/
  public Row(Item[] l) {
    for(int i = 0; i < list.length; i++) {
      list[i] = l[i];
    }
  }

/**getVal(int)
@param pos This is the integer value of the position in the Row that is being looked at for its value.
This method returns the value of whatever item is located at the passed in position.
The Row would be indexed like this [0,1,2,3,4,5,6,7,8]
**/
  public int getVal(int pos) {
    return list[pos].getVal();
  }

/**setVal(int, Item)
@param int pos This is the position in the Row that is being updated
@param Item i This is the item that is being passed into the Row to update the value at a given location
This method updates the item in the Row at a the requested position.
**/
  public void setVal(int pos, Item i) {
    list[pos] = i;
  }
  
    /**toString()
  This method returns the string of the values of the Row, in order, on a single line.
  **/
  public String toString() {
    String temp = "";
    for(Item i: list) {
      temp += i + " ";
    }
    temp += "\n";
    return temp;
  }
  
    /**contains(int)
  @param int val This is the integer value that is being checked if it is already in the Row.
  @return This returns true if the value is in Row object, else it returns false.
  This method was made to check if a value already exits within the Row.
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
  @return This returns true if the Row is complete and false if it is not.
  This method checks if every possible value is in the Row meaning that the Row is complete.
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