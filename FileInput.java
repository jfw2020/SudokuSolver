import java.io.*;
import java.util.*;
import javax.swing.*;
public class FileInput {
  private Scanner inFile = null;
  private Item[] list = new Item[81];
  
  public FileInput() {
    Scanner scan = new Scanner(System.in);
    boolean valid = false;
    String filename = "";
    while(!valid) {
      try {
        filename = JOptionPane.showInputDialog("Enter filename for input: ");
        try {
          if(!filename.substring(filename.length()-4).equals(".txt")) {
            throw new IllegalArgumentException();
          }
        } catch (StringIndexOutOfBoundsException ex) {
        }
        inFile = new Scanner(new File(filename));
        valid = true;
      } catch(FileNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Invalid file name; file not found.");
      } catch(IllegalArgumentException e) {
        JOptionPane.showMessageDialog(null, "Filename must have .txt file extension");
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
    inFile.close();
    return list;
  }
  
  public int getIterations(){
    boolean valid = false;
    int num = 0;
    while(!valid){
      try{
        num = Integer.parseInt(JOptionPane.showInputDialog("Enter how many iterations you want between each display: "));
        if(num <= 0) {
          throw new NumberFormatException();
        }
        valid = true;
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(null,"Invalid input");
      }
    }
    return num;
  }
}