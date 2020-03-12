//-----------------------------------------
     // NAME  : Chinenye Akaluka 
     // STUDENT NUMBER : 7815587
     // COURSE  : COMP 2150
     // INSTRUCTOR : Dr. Olivier Tremblay-Savard
     // ASSIGNMENT : assignment 1
     // QUESTION : question 1      
     // 
     // REMARKS: This class implements a list to store all the stocks
     //
     //
     //-----------------------------------------

public class StockList
{
  //instance variables
  private Node top;
  private int count;    //keeps count of the number of objects inserted
  
  //constructor
  public StockList()
  {
    top=null;
    count=0;
  }
  
  public void insert(Stock newItem)
  {
    /*This function inserts an object into the linkedlist
    * It takes a Object parameter
    * It does not return anything
    */
    
      String y = newItem.getName();
      //System.out.println(y);
    if(search(y))
    {
      System.out.println(" DUPLICATE");
    }
    else
    {
    Node newNode=new Node(newItem, top);      //create new node and make it point to top
    top=newNode;          //make top equal to new node
    count++;              //add 1 to the number of objects
    System.out.println("CONFIRMED");
    }
  }//add
  
  public boolean search(String item)
  {
    /*This searches for a stock
    * It takes a string parameter
    * It does not return anything
    */
    Node theNode = top;
    boolean ask = false;
    while(theNode !=null)   //loop till you find it
    {
      Stock x = theNode.getData();
      String y = x.getName();
      //System.out.println(y+"  "+item);
      if(y.equals(item))  //if it is the stock
      {
        ask = true;
      }
      theNode = theNode.getTheLink();
    }
    return ask;
  }
  
  public void status(String item)
  {
    /*This function prints out the current price of a stock
    * It takes a string parameter
    * It does not return anything
    */
    Node theNode = top;
    boolean ask = false;
    while(theNode !=null)   //loop till you find it
    {
      Stock x = theNode.getData();
      String y = x.getName();
      //System.out.println(y+"  "+item);
      
      if(y.equals(item))
      {
        //System.out.println("ggg");
        System.out.println(x.print());
      }
      theNode = theNode.getTheLink();
    }
  }
  
  public void changePrice(String item, double b)
  {
    Node theNode = top;
    while(theNode !=null)
    {
      Stock x = theNode.getData();
      String y = x.getName();
      //System.out.println(y+"  "+item);
      if(y.equals(item))
      {
        x.setPrice(b);
      }
      theNode = theNode.getTheLink();
    }
    
  }

   //=====================================================================================================
  //Inner node class
  private class Node
{
  //instance variable
  private Stock data;
  private Node link;
  
  //constructor
  public Node(Stock d, Node c)
  {
      data= new Stock(d.getName());
      link=c;
  }
  
 
  
  public Stock getData()
    //this function returns the object
  {
    return data;
  }
  
  public Node getTheLink()
    //this function returns the link
  {
    return link;
  }
}//Node

}