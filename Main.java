import java.util.*;
public class Main {
  public static void main(String[] args) {
    //Scanner scan = new Scanner(System.in);
    FileInput f = new FileInput();
    Sudoku s = new Sudoku(f.readFile());
    //scan.nextLine();
    //s.solve();
    
    //s.printBoard();
    
  }
}