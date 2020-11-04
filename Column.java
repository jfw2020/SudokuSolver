import java.util.*;

public class Column {
  private Item[] list = new Item[9];
  
  public Column(Item[] l) {
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
}