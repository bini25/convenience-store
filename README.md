# Background

BridgePhase is opening up a new convenience store and needs a Point-of-Sale system to serve as the cash register and inventory system.


# Part 1. Inventory System

Create a class Inventory that implements the methods in the IInventory interface. An Inventory contains a list of Product. Each Product contains upc (String), name (String), wholesalePrice (Number or subclass), retailPrice (Number or subclass), and quantity (Number or subclass).  Add standard getter and setters getName(), setName(), etc to the Product class. 

The IInventory interfaces supports the following public operations:



1. void replenish(InputStream is) - Reads the inventory from a comma separated InputStream, each line in the InputStream represents a different Product. An example input stream looks like this (the header will be part of the input stream as well):

upc,name,wholesalePrice,retailPrice,quantity <br>
A123,Apple,0.50,1.00,100<br>
B234,Peach,0.35,0.75,200<br>
C123,Milk,2.15,4.50,40<br>




The replenish() method will populate the list of Product on the Inventory.



1. List<Product> list() - returns an unmodifiable List<Product> representing the Product inside the Inventory.




Note: Pay attention to what class you'll use to represent prices and quantity...



# Part 2. Cash Register

Create a class called CashRegister that accepts an IInventory as part of its constructor. The CashRegister will be used to calculate the total price of Product bought by a user and must therefore provide the following methods: 


1. void beginTransaction() - will setup the CashRegister to create a new transaction which means that a new customer is checking out<br>

2. boolean scan(String upc) - will scan a product based on its UPC (Universal Product Code). Returns true when successful.<br>

3. BigDecimal getTotal() - returns the total retail price of all goods purchased. This value is a currency.<br>

4. BigDecimal pay(BigDecimal cashAmount) - mimics a customer paying for their total and returns the amount of change due to the customer. This is also the end of the transaction.<br>

5. void printReceipt(OutputStream os) - prints the receipt in the following format (the format is important):<br>


BridgePhase Convenience Store  <br>
-----------------------------<br>
Total Products Bought: 17 <br>
<br>
3 Apple @ $1.00: $3.00<br>
2 Milk @ $4.50: $9.00<br>
12 Peach @ $0.75: $9.00<br>
-----------------------------<br>
Total: $21.00<br>
Paid: $25.00<br>
Change: $4.00<br>
-----------------------------<br>

# Technologies

Programing lanague used ------------- Java   <br />

source-code editor--------------- Visual Studio Code & online java compiler   <br />

version control system------------GitLab & Github desktop  <br />



# Instructions on how to execute
Solution is provided using Java programing languge.Any Java compiler should compile and run the provided codes.
You can use any  Java editor/JRE/javaIDEs of your choice.<br />
Just download the whole package and open with one of java's IDE like eclipse.Or download all Java classes provided and put them in one folder you should be able to excute it with no problem.<br />
Note: use the driver class StoreApplication to test as entry point to ensure that you have a working implementation for Part 1 & 2.