Sudoku Solver

To run this program, the user needs to run Main.java in a command-line window.
Or use the Run.jar by double clicking it.

How to use:
  1) Use sudoku.txt for demo or create your own text file. The only line of the text file must be 81 characters, with empty spaces represented by a period character '.'
    NOTE: to generate these sudokus, use (https://qqwing.com/generate.html) and select the output format of "One Line"
    Text file should not have any non-digit characters other than a period ('.')
  2) Run the program
  3) Enter in how many iterations you would like to have between display updates (recommended 100-1000 to keep run time reasonable)
    NOTE: Since the number of iterations to solve a sudoku can range from the 100s to the 1,000,000s, we recommend that you choose a very large iteration count initially and note the number of iterations required to solve the given sudoku. Then, rerun the program and choose a iteration break that is approximately 1/100 to 1/1000 of the number of iterations required to solve the given sudoku. This will allow you to see the backtracking algorithm in action, and have a reasonably quick run time.
  4) GUI should pop up and attempt to solve the sudoku
  5) If the backtracking algorithm finishes successfully, a message should pop up saying it was solved. Otherwise, the sudoku is not solvable.
