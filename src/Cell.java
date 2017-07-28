

public class Cell{
  /** row int This is the row */
  private int row;
  /** col int This is the col */
  private int col;
  /** status int This is the status */
  private int status; //-1 means not initialized!
  
  /** This is the class constructor for a cell
   * @param row int This is the row
   * @param col int This is the column
   * @param status int This is the temporary status in the cell */
  public Cell(int col, int row, int status){
    this.row = row;
    this.col = col;
    this.status = status;
  }
  
  /** This method gets the row
    * @return int This is the row */
  public int getRow(){
    return row;
  }
  
  /** This method returns the col
    * @return int This is the column number */
  public int getCol(){
    return col;
  }
  
  /** This method returns the status.
    * @return int This is the status */
  public int getStatus(){
    return status;
  }
  
  /** This method sets the status.
    * @param status int This is the status that wants to be set. */
  public void setStatus(int status){
    this.status = status;
  }
}