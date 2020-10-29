public class Item {
  private int value;
  private final int ID;
  private static int counter = 0;
  
  public Item(int val) {
    ID = counter;
    counter++;
    value = val;
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
  
}