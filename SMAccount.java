//-----------------------------------------
     // NAME  : Chinenye Akaluka 
     // STUDENT NUMBER : 7815587
     // COURSE  : COMP 2150
     // INSTRUCTOR : Dr. Olivier Tremblay-Savard
     // ASSIGNMENT : assignment 1
     // QUESTION : question 1      
     // 
     // REMARKS: This class implements a stock market account
     //
     //
     //-----------------------------------------

public class SMAccount
{
  private String accountNo;    //Account number
  private double accountBal;   //account balance
  private StockAccountList theList;    //list of stocks
  
  
  //constructor
  public SMAccount(String num, double bal)
  {
    theList = new StockAccountList();
    accountNo = num;
    accountBal = bal;
  }
  
  //insert method to insert stocks
  public void insertStock(String sname, int damount, double dprice)
  {
    StockAccount theAccount = new StockAccount(accountNo, sname, dprice,damount);
    theList.insert(theAccount); //calling the list to insert a new stock
  }
  
  //delete method to delete stocks
  public void deleteStock(String sname)
  {
    //StockAccount theAccount = new StockAccount(accountNo, sname, dprice,damount);
    theList.delete(sname);   //calling the list to delete  a stock
  }
  
  
  //get and set methods
  public String getAccountNo()
  {
    return accountNo;
  }
  
  public StockAccountList getTheList()
  {
    return theList;
  }
  
  public void setAccountBal(double bb)
  {
    accountBal = bb;
  }
  
  public double getAccountBal()
  {
    return accountBal;
  }
  
  //print method
  public void print()
  {
    System.out.println( "Account #"+accountNo+" has a balance of $"+accountBal+" and owns these stocks:");
    theList.print();
  }
}