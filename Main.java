import java.util.*;
public class Main {
  public static void main(String[] args) {
     FileInput f = new FileInput();
     Sudoku s = new Sudoku(f.readFile());
     s.solve();
     s.printBoard();
  }
}