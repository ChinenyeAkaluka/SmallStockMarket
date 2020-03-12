//-----------------------------------------
     // NAME  : Chinenye Akaluka 
     // STUDENT NUMBER : 7815587
     // COURSE  : COMP 2150
     // INSTRUCTOR : Dr. Olivier Tremblay-Savard
     // ASSIGNMENT : assignment 1
     // QUESTION : question 1      
     // 
     // REMARKS: This class implements a stock class
     //
     //
     //-----------------------------------------

public class Stock
{
  private String stockName;   //name of the stock
  private double stockPrice;  //current price
  private int stockAmount;   //amount of the stock
  
  
  //constructor
  public Stock(String name)
  {
    stockName = name;
    stockPrice = 0;
    stockAmount = 0;
  }
  
  public void setPrice(double a)
    /*This function sets a node to the node
    * It takes an node parameter
    * It returns nothing
    */
  {
   stockPrice=a; 
  }
  
  
  //getters and setters
  public void setAmount(int a)
    /*This function sets a node to the node
    * It takes an node parameter
    * It returns nothing
    */
  {
   stockAmount=a; 
  }
  
  public String getName()
    //this function returns the object
  {
    return stockName;
  }
  
  public double getPrice()
    //this function returns the link
  {
    return stockPrice;
  }
  
  public int getAmount()
    //this function returns the link
  {
    return stockAmount;
  }
  
  public String print()
  {
    return stockName+" has a current price of $"+stockPrice+".";
  }
}