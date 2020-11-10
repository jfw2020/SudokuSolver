public class Item {
  private int value;
  private final int ID;
  private static int counter = 0;
  private int[] position; // position[0] = row index; position[1] = column index; position[2] = box index;
  
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
  
  public int getVal() {
    return value;
  }
  
  public void setVal(int i) {
    value = i;
  }
  
  public int getID() {
    return ID;
  }
  
  public String toString() {
    return value + "";
  }
  
  public boolean equals(Item i){
   return this.ID == i.ID;  
  }
  
  public String getPosArr() {
    return position[0] + " " + position[1] + " " + position[2];
  }
  
  public int getRow() {
    return position[0];
  }
  public int getColumn() {
    return position[1];
  }
  public int getBox() {
    return position[2];
  }
  
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