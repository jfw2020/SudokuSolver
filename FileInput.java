/**Jacob Williams, Logan Newsom, Parker Billinger, Trey Etzel
 * CIS 200 Scholar's section
 * FileInput.java
 * 
 * This class works as the input class, all user interactions take place here. The class has 3 different methods. Firstly, the filename is
 * input by the user. Then, the file is read and formatted into a list of 81 values that we later use for everything else. Lastly, the user
 * is asked how many steps they want to skip between each display update.
 */
import java.io.*;
import java.util.*;
import javax.swing.*;
public class FileInput {
  private Scanner inFile = null;
  private Item[] list = new Item[81];
  
  /**FileInput()
   * 
   * This method asks the user for a filename.
   * Then it checks that it is a .txt file, and if not it throws an Illegal Argument Exception.
   * Lastly, it attempts to open the file for the following method.
   * Both possible errors are caught and dealt with at the bottom of this method, they both display an error message within a GUI.
   */
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
  
  /**readFile()
   *  
   * @return This returns a list, that should be 81 characters long if the user input a valid sudoku, of the 81 characters within the file.
   * This method is used to get the information out of the given file. It takes the single line and adds each individual character to the
   * list.
  */
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

  /**getIterations()
   * 
   * @return This returns the integer value that the user input, this is used by the program to know how many steps to display.
   * This method asks the user how many steps they want to occur between each diplay. If they enter 1, then they will see every single step,
   * if one were to enter 100, they'd see every 100 steps, etc.
   */
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