/**Jacob Williams, Logan Newsom, Parker Billinger, Trey Etzel
CIS 200 Scholar's section
Column.java

This class defines an item object for the Sudoku board. There will only ever be 81 of these made for one Sudoku.
These objects represent each individual square on the board, and are used to make the Row, Column, and Box objects.

**/
public class Item {
  private int value;
  private final int ID;
  private static int counter = 0;
  private int[] position; // position[0] = row index; position[1] = column index; position[2] = box index;
  
  /**Item(int val)
  This instantiates an Item object and adds one to the counter which is used as the unique ID for each Item.
  Also, based off of the ID, the position on the board for the item is calculated using generatePosition().
  **/
  public Item(int val) {
    ID = counter;
    counter++;
    value = val;
    position = generatePosition(ID);
    /*
    for(int i = 0; i < position.length; i++) {
      System.out.print(position[i] + " ");
    }
    System.out.println();
    */
  }
  
  /**getVal()
  @return This returns the integer value of the Item.
  **/
  public int getVal() {
    return value;
  }
  
  /**setVal(int i)
  @param int i This is the value that the Item is being changed to.
  This method changes the integer value stored within the Item object.
  **/
  public void setVal(int i) {
    value = i;
  }
  
  /**getID()
  @return this returns the unique integer value for the Item object.
  This method is used to keep track of what items are within the other objects.
  **/
  public int getID() {
    return ID;
  }
  
  /**toString()
  @returns it returns a string of the value of the Item.
  **/
  public String toString() {
    return value + "";
  }
  
  /**equals(Item)
  @returns this returns true if the ID of both objects is the same and false otherwise.
  **/
  public boolean equals(Item i){
   return this.ID == i.ID;  
  }
  
  /**getPosArr()
  @return This returns a string of the row, column, and box that the Item is in.
  **/
  public String getPosArr() {
    return position[0] + " " + position[1] + " " + position[2];
  }
  
  /**getRow()
  @return this returns what Row the Item is in
  **/
  public int getRow() {
    return position[0];
  }
  
  /**getColumn()
  @return this returns what Column the Item is in
  **/
  public int getColumn() {
    return position[1];
  }
  
  /**getBox()
  @return this returns what Box the Item is in
  **/
  public int getBox() {
    return position[2];
  }
  
  /**generatePosition(int id)
  @param This takes the unique ID num
  @return This returns an int[] of the positions.
  This uses the ID of the number to calculate the Row, Column, and Box that it is in.
  **/
  private int[] generatePosition(int id) {
    int[] temp = new int[3];
    int row = (int) id / 9;
    int column = id % 9;
    int box = ((int) (row / 3)) * 3 + ((int)(column/3));
    temp[0] = row;
    temp[1] = column;
    temp[2] = box;
    return temp;
  }
}