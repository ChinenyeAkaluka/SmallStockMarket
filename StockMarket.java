//-----------------------------------------
     // NAME  : Chinenye Akaluka 
     // STUDENT NUMBER : 7815587
     // COURSE  : COMP 2150
     // INSTRUCTOR : Dr. Olivier Tremblay-Savard
     // ASSIGNMENT : assignment 1
     // QUESTION : question 1      
     // 
     // REMARKS: This class is a stock market class. It allows accounts to be created, and stocks to be transacted.
     //Stocks are added, checked, bids and ask orders are added too.
     //
     //-----------------------------------------

public class StockMarket
{
  private SMAccountList accountHolders;    //A list of all accounts
  private StockList sMList;                //A list of all stocks
  private AskOrderList myAsks;            //A list of all ask orders
  private BidOrderList myBids;            //A list of all bid orders
  private double transactionFee;          //the transaction fee
  
  
  //constructor
  public StockMarket()
  {
    accountHolders = new SMAccountList();
    sMList = new StockList();
    myAsks = new AskOrderList();
    myBids = new BidOrderList();
    transactionFee = 9.99;
  }
  
  //Adding a new stock
  //name of stock is parameter
  public void add(String word)
  {
    Stock aStock = new Stock(word);  //create it
    sMList.insert(aStock);   //add to the list
  }
  
  //checking the status of a stock
  //name is parameter
  public void status(String word)
  {
    if(sMList.search(word))  //if it is in the list
    {
       sMList.status(word);  //get price
       myAsks.print(word);   //get asks
       myBids.print(word);   //get bids
       
    }
    else
    {
       System.out.println("Stock does not exist");
    }
  }
  
  //create a new account
  //takes balance, account number and stocks owned as parameters
  public void newAccount(String word, double num, String[] info)
  {
    SMAccount aStockAccount = new SMAccount(word, num);   //create
    //accountHolders.insert(aStockAccount);
    int i=0;
    String s= "";
    while(info[i] != null)
    {
      String[] again = info[i].split("-");
      if(sMList.search(again[0]))    //if stocks exist
      {
        s=again[0];
       aStockAccount.insertStock(again[0], Integer.parseInt(again[1]), Double.parseDouble(again[2]));
      }
      else
      {
        s=again[0];
        System.out.println("STOCK NOT FOUND");
      }
      i++;
    }
    //System.out.println(s);
    if(sMList.search(s) || info[0]==null)
    {
      //System.out.println("kk");
      accountHolders.insert(aStockAccount);
    }
  }
  
  //print balance of an account
  public void balance(String word)
  {
    accountHolders.balance(word);
  }
  
  //Handles ask orders
  //parameters: account number, stock name, stock amount, stock price
  public void askOrder(String names, String stockn, int stockAm, double stockpri)
  {
    if(!myAsks.search(names, stockn)) //is is in the ask list
    {
       if(accountHolders.search(names))  //is it owned
       {
          SMAccount newAccount = accountHolders.retrieve(names);
          if(!sMList.search(stockn))  //is the stock in the list
          {
             System.out.println("STOCK NOT FOUND");
          }
          else
          {   
             if(newAccount.getTheList().search(stockn))
             {
                AskOrder myAskOrder = new AskOrder(names, stockn, stockAm, stockpri);
                myAsks.insert(myAskOrder);
                //if(newAccount.getAccountBal() >= ((stockpri*stockAm) + 9.99))
                System.out.println("CONFIRMED");
                transaction(stockn);  //handles transactions involved
              }
             else
             {
                System.out.println("INVALID ORDER");
              }
           }
         }
         else
        {
           System.out.println("ACCOUNT NOT FOUND");
         }
    }
    else
    {
      System.out.println("DUPLICATE");
    }
  }
  
  //Handles bid orders
  //parameters: account number, stock name, stock amount, stock price
  public void bidOrder(String names, String stockn, int stockAm, double stockpri)
  {
    if(!myBids.search(names, stockn))   //is it in the list
    {
       if(accountHolders.search(names))  //is the account real
       {
          SMAccount newAccount = accountHolders.retrieve(names);
             if(newAccount.getAccountBal() >= ((stockpri*stockAm) + 9.99)) //does it have enough money
             {
                BidOrder myBidOrder = new BidOrder(names, stockn, stockAm, stockpri);
                myBids.insert(myBidOrder);
                //myBids.checkGreatestPrice();
                //sMList.changePrice(stockn, stockpri);
                System.out.println("CONFIRMED");
                transaction(stockn);    //manager call
              }
             else
             {
                System.out.println("INVALID ORDER");
             }
         }
         else
        {
           System.out.println("ACCOUNT NOT FOUND");
         }
    }
    else
    {
      System.out.println("DUPLICATE");
    }
  }

  //Handles ask removal
  //parameters: account number, stock name
  public void removeAsk(String item1, String item2)
  {
    if(myAsks.search(item1, item2))   //is it in the list
    {
     if(accountHolders.search(item1))  //is the account real
       {
         if(sMList.search(item2))   //is the stock real
         { 
           myAsks.delete(item1, item2);
           //SMAccount newAccount = accountHolders.retrieve(item1);
           //newAccount.getTheList().delete(item2);
           System.out.println("CONFIRMED");
         }
         else
         {
           System.out.println("STOCK NOT FOUND");
         }
       }
     else
     {
       System.out.println("ACCOUNT NOT FOUND");
     }
    }
    else
    {
      System.out.println("ORDER NOT FOUND");
    }
  }
  
  //Handles bid orders
  //parameters: account number, stock name
  public void removeBid(String item1, String item2)
  {
    if(myBids.search(item1, item2))   //is it in the list
    {
     if(accountHolders.search(item1))  //is the account real
       {
         if(sMList.search(item2))    //is the stock real
         { 
           myBids.delete(item1, item2);
           //SMAccount newAccount = accountHolders.retrieve(item1);
           //newAccount.getTheList().delete(item2);
           System.out.println("CONFIRMED");
         }
         else
         {
           System.out.println("STOCK NOT FOUND");
         }
       }
     else
     {
       System.out.println("ACCOUNT NOT FOUND");
     }
    }
    else
    {
      System.out.println("ORDER NOT FOUND");
    }
  }
  
  public void transaction(String stockna)
  {
    BidOrder newBid = myBids.checkGreatestPrice(stockna);  //check for highest bid price
    if(newBid != null)  //if there is a bid that can buy an ask
    {
    String aNames = newBid.getNum();
    double gPrice = newBid.getPrice();
    int numSt = newBid.getAmount();
    
    AskOrder newAsk = myAsks.checkMatchingAsk(stockna, gPrice);
    
    
    if(newAsk != null)  //if there is an ask
    {
      String aNames2 = newAsk.getNum();
      //charge account that holds this bid
      double ppbb = chargeBid(newBid);
      //charge account that holds this ask
      chargeAsk(newAsk, ppbb);
      //add stock to bid account
      SMAccount newAccount = accountHolders.retrieve(aNames);
      newAccount.insertStock(stockna, numSt, gPrice);
      //remove stock from ask account
      SMAccount newAccount2 = accountHolders.retrieve(aNames2);
      newAccount2.deleteStock(stockna);
      //delete ask;
      myAsks.delete(aNames2, stockna);
      //delete bid;
      myBids.delete(aNames, stockna);
      //change price of the stock
      sMList.changePrice(stockna, gPrice); 
    }
    }
    //System.out.println("nah");
  }
  
  //charges account that buys stocks
  public double chargeBid(BidOrder thebid)
  {
    String number = thebid.getNum();
    
    //calculating price
    double price = ( (thebid.getPrice())*(thebid.getAmount()));
    double priceb = price + transactionFee;
    accountHolders.updatePricedown(number, priceb);
    //System.out.println("yay!");
    return price;
  }
  
  //replenishes and charges account that sells stocks
  public void chargeAsk(AskOrder theask, double pb)
  {
    String number = theask.getNum();
    //calculating price
    double priceb2 =  pb-transactionFee;
    accountHolders.updatePriceup(number, priceb2);
  }
  
}
