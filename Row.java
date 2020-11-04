import java.util.*;

public class Row {
  private Item[] list = new Item[9];
  
  public Row(Item[] l) {
    for(int i = 0; i < list.length; i++) {
      list[i] = l[i];
    }
  }

  public int getVal(int pos) {
    return list[pos].getVal();
  }

  public void setVal(int pos, Item i) {
    list[pos] = i;
  }
  
  public void printRow() {
    for(Item i: list) {
      System.out.print(i + " ");
    }
    System.out.println();
  }
  
}