import java.util.*;

public class Box {
  private Item[] list = new Item[9];
  
  public Box(ArrayList<Item> l) {
    for(int i = 0; i < list.length; i++) {
      list[i] = l.get(i);
    }
  }

  public int getVal(int pos) {
    return list[pos].getVal();
  }

  public void setVal(int pos, Item i) {
    list[pos] = i;
  }
  
  public String toString() {
    String temp = "";
    for(Item i: list) {
     temp += i.getVal() + " ";
    }
    temp += "\n";
    return temp;
  }
  
  public boolean contains(int val) {
    for(Item i: list) {
      if(i.getVal() == val) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isValid() {
    return this.contains(1) && this.contains(2) && this.contains(3) && this.contains(4) && this.contains(5) && this.contains(6) && this.contains(7) && this.contains(8) && this.contains(9);
  }
  
  /*public boolean contains(Item i){
    for(Item j : list){
      if(j.getVal() == i.getVal()){
        return true;
      }
    }
    return false;
  }*/
}