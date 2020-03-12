# SmallStockMarket
Implement a stock market. Allow for trading stocks between buyers and sellers. Implement rules for trading. OOP. Java.

##Methods
1. NEW [ACCOUNT#] [BALANCE] [OWNED_STOCKS]
• This action adds a new investing account to the system.
2. ADD [ASK_OR_BID] [ACCOUNT#] [SYMBOL] [NB_STOCKS] [PRICE]
• This action adds an order (order to sell (ask) or to buy (bid)) to the system, from a specific account number (int), for a specific stock symbol (string), for a certain number of stocks (int) and for a certain price (double).
3. REMOVE [ASK_OR_BID] [ACCOUNT#] [SYMBOL]
• This action removes an ask order from the system, for a specific account number (int) and for a specific stock symbol (string).
4. BALANCE [ACCOUNT#]
• This action prints the status of an investing account: what is the current balance? Which stocks are owned and at what price?
5. STATUS [STOCK_SYMBOL]
• This action prints the status of a stock: what is the current price of the stock (based on the last trade)? What are the bids and asks for this stock?
6. QUIT
• This ends the program.
