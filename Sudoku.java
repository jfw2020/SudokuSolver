import java.util.*;
public class Sudoku {
  private ArrayList<Item> list = new ArrayList<>();
  
  public Sudoku(ArrayList<Item> vals) {
    for(Item i: vals) {
      list.add(i);
    }
  }
  
  public void solve() {
    
  }
  
  public void printBoard() {
    Random rand = new Random();
    for(int x = 0; x < 40000; x++) {
      int change = rand.nextInt(81);
      int changeVal = rand.nextInt(10);
      list.get(change).setVal(changeVal);
      if(x % 50 == 0) {
        try {
          if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
          else
            Runtime.getRuntime().exec("clear");
        } catch (Exception ex) {}
        System.out.println("-------------------------");
        for(int i = 0; i < 9; i++) {
          System.out.print("| ");
          for(int j = 0; j < 9; j++) {
            System.out.print(list.get(i*9 + j).getVal() + " ");
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
    }
  }
}