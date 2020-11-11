import java.io.*;
import java.util.*;
public class FileInput {
  private Scanner inFile = null;
  private Item[] list = new Item[81];
  
  public FileInput() {
    Scanner scan = new Scanner(System.in);
    boolean valid = false;
    String filename = "";
    while(!valid) {
      try {
        System.out.print("Enter filename for input: ");
        filename = scan.nextLine();
        try {
        if(!filename.substring(filename.length()-4).equals(".txt")) {
          throw new IllegalArgumentException();
        }
        } catch (StringIndexOutOfBoundsException ex) {
        }
        inFile = new Scanner(new File(filename));
        valid = true;
      } catch(FileNotFoundException e) {
        System.out.println("Invalid file name; file not found.");
      } catch(IllegalArgumentException e) {
        System.out.println("Filename must have .txt file extension");
      }
    }
  }
  
  public Item[] readFile() {
    String s = inFile.nextLine();
    for(int i = 0; i < 81; i++) {
      if(s.charAt(i) == '.') 
        list[i] = new Item(0);
      else
        list[i] = new Item(Character.getNumericValue(s.charAt(i)));
    }
    return list;
  }
}