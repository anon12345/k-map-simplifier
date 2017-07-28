import java.util.*;

public class TruthTable{
  
  /**  twoVariableTruth int [] This variable stores the truth table of the two variable truth table. */
  public static int [] twoVariableTruth = new int [4];
  /**  threeVariableTruth int [] This variable stores the truth table of the three variable truth table. */
  public static int [] threeVariableTruth = new int [9];
  /**  fourVariableTruth int [] This variable stores the truth table of the four variable truth table. */
  public static int [] fourVariableTruth = new int [16]; /* 2D array? */
  /**  fourVariableTruth int [] This variable stores the truth table of the five+ variable truth table. */
  public static int [] fiveOrMoreVariableTruth = new int [225];

  /** ignoreFlag boolean This tells the ButtonRenderer if the execution should be ignored or not.*/
  static boolean ignoreFlag = false;
  
  /** This method returns the boolean expression from the truthtable.
   * @param num int This is the number of numbers.
   * @param variables int This is the number of variables.
   * @return String This is the input equation.
   */
  public static String getInputEquation(int num, int variables){
    variables = variables * variables; 
    int [] s;
    int bits = log2(variables) - 1; 
    s = new int[bits];
    for(int i = bits-1; i >= 0; i--){
      s[i] = (num >> (bits-1-i) & 1); 
    }
    String returnS = "";
    for(int i = 0; i < s.length; i++){
      if (s[i] == 0)
        returnS += (char)('A' + i) + "'";
      else
        returnS += (char)('A' + i) + "";
    }
    return returnS;
  }
  
  /** This method gets the number of bits 
    * @param value int The value of the number.
    * @return int The number of bits.
    */
  static int log2(int value) {
    return Integer.SIZE-Integer.numberOfLeadingZeros(value);
  }
  
  /** This method fills the truth tables with 0 values. */
  public static void initializeTruthTableValues(){
    Arrays.fill(twoVariableTruth, 0);
    Arrays.fill(threeVariableTruth, 0);
    Arrays.fill(fourVariableTruth, 0);
    Arrays.fill(fiveOrMoreVariableTruth, 0);
  }
  
  /** This method updates the JTextField with the proper variables.
    * @param variables int This gives the number of variables. */
  
  public static void updateGivenSOP(int variables, boolean isFiveVariablePlus){
    String output = "";
    for(int x = 0; x < variables * variables; x++){
      int val;
      if (variables == 2)
        val = twoVariableTruth[x];
      else if (variables == 3)
        val = threeVariableTruth[x];
      else if (variables == 4)
        val = fourVariableTruth[x];
      else
        val = fiveOrMoreVariableTruth[x];
      if (val == 1){
        output += "+" + getInputEquation(x, variables);
      }
    }
    if (output.equals("")){
      output = " False";
    }
    if (!isFiveVariablePlus) {
      if (output.length() >= 1)
        Frame.givenEq[variables - 2].setText(output.substring(1)); //take off additional
      else
        Frame.givenEq[variables - 2].setText("");
    }

    Solve.solveKarnaughMap(variables, false);
  }
}
