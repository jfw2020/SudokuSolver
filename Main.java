import java.util.*;
public class Main {
  public static void main(String[] args) {
    /* There is a Huge Range of possible iterations any puzzle can have. Here are some demo puzzles
     * 9.4.7..3...2..3.64..39..1.2....12.....983..4..8...9...6...2...17.81.........6..9.     = 323 Iterations
     * 5.....8...8......5.....7.4......2.1......5..7.741...6...7...42.....637...1.2...83     = 761,311 Iterations
     * ...8.1.........43.5............7.8........1...2..3....6......75..34........2..6..     = 12,102,870 Iterations
     */
    
    
    
    // Scanner scan = new Scanner(System.in);
    int iterationsBreak = 100;
    if(args.length > 0) {
      try {
        int temp = Integer.parseInt(args[0]);
        iterationsBreak = temp;
      } catch (NumberFormatException ex){};
    }
    FileInput f = new FileInput();
    Sudoku s = new Sudoku(f.readFile(),iterationsBreak);
    //scan.nextLine();
    //s.printAll();
    if(s.solve()){
      s.printBoard();
      System.out.println("Solved!");
    } else {
      System.out.println("Unsolvable Puzzle");
    }
    //s.printAll();
    //s.printBoard();
    //s.printItemsAndPositions();
    //s.printIsValid();
  }
}