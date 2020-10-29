import java.io.*;
import java.util.*;
public class FileInput {
  private Scanner inFile = null;
  private ArrayList<Item> list = new ArrayList<>();
  
  public FileInput() {
    Scanner scan = new Scanner(System.in);
    boolean valid = false;
    String filename = "";
    while(!valid) {
      try {
        System.out.print("Enter filename for input: ");
        filename = scan.nextLine();
        inFile = new Scanner(new File(filename));
        valid = true;
      } catch(FileNotFoundException e) {
        System.out.println("Invalid file name; file not found.");
      }
    }
  }
  
  public ArrayList<Item> readFile() {
    String s = inFile.nextLine();
    for(int i = 0; i < 81; i++) {
      if(s.charAt(i) == '.') 
        list.add(new Item(0));
      else
        list.add(new Item(Character.getNumericValue(s.charAt(i))));
    }
    return list;
  }
}