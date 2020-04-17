import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Scanner;


public class CashRegister {
	IInventory inventory  = new Inventory();
	int quantity=1;
	int apple = 0;
	int peach=0;
	int milk =0;
	String  output;
	double RetailPrice  ;
    double applePrice ;
    double peachPrice ;
	double milkPrice ;
	OutputStream os;
	public IInventory getInventory() {
		return inventory;
	}

	public void setInventory(IInventory inventory) {
		this.inventory = inventory;
	}

	public CashRegister(IInventory inventory) {
		super();
		this.inventory = inventory;
	}
	public void beginTransaction() throws Exception  {
		System.out.println("New transaction");
		System.out.println("****************");
		System.out.println("scan your item!/Type product upc");
		Scanner input = new Scanner(System.in);
		String upc = input.next();
		if(scan(upc)==true) {
			
			    switch(upc) {
				   case "A123" :
					   System.out.println("Transaction");
					   RetailPrice = 1.00 ;
					   apple= apple+ 1;
					   applePrice = apple * RetailPrice;
					  break; 
				     
				   case "B234" :
					   System.out.println("Transaction");
					   RetailPrice = 0.75 ;
					   peach = peach+ 1;
					   peachPrice = peach * RetailPrice;
					   
					 break; 
				  
				   case "C123" :
					   System.out.println("Transaction");
					   RetailPrice = 4.50 ;
					   milk = milk+1;
					   milkPrice = milk * RetailPrice;
					 break;
				   
				   default : 
				     
				} } 
				else {
					 System.out.println("scan again wrong barcode");
				      beginTransaction(); };
				
				System.out.println(" Do you want to continue  scanning more items ? press yes to continue /OR press any key to end purchase ");
			    String a = input.next();
				if ((a.equals("yes")||a.equals("YES"))) {
			    	quantity++;
			    	
			    beginTransaction();
			    } else {
			    	
			    	System.out.println("Your total is "  +getTotal());
			    	 System.out.println("enter cash amount for payment");
				    	BigDecimal cashAmount = input.nextBigDecimal();
				    	BigDecimal change = pay(cashAmount);
			      
				    	output = "BridgePhase Convenience Store\r\n" + 
			    		"-----------------------------\r\n" + 
			    		"Total Products Bought: "+quantity+"\r\n" + 
			    		"\r\n" + 
			    		""+apple+" Apple @ $1.00: $"+applePrice+"\r\n" + 
			    		""+milk+" Milk @ $4.50: $"+milkPrice+"\r\n" + 
			    		""+peach+" Peach @ $0.75: $"+peachPrice+"\r\n" + 
			    		"-----------------------------\r\n" + 
			    		"Total: $"+getTotal()+"\r\n" + 
			    		"Paid: $"+cashAmount+"\r\n" + 
			    		"Change: $"+change+"\r\n" + 
			    		"-----------------------------\r\n" + 
			    		"";
			   
			    printReceipt(os);
			
			    }
				
			    
		}
	public boolean scan(String upc) {
		boolean k = false;
		if(upc.equals("A123"))  k= true;
		if(upc.equals("B234"))  k=true;
		if (upc.equals("C123") ) k= true ;
	 return k;
	}

	
	BigDecimal getTotal() {
		double t ;
		t= applePrice + peachPrice + milkPrice;
		BigDecimal total= BigDecimal.valueOf(t);
		
		return total;
	}
	BigDecimal pay(BigDecimal cashAmount) {
		cashAmount = cashAmount.subtract(getTotal());
		return cashAmount;
	}
	void printReceipt(OutputStream os)  {
		byte[] data = output.getBytes();
       try
        {
            os = System.out;
            os.write(data);
            os.flush();
            os.close();
        }
        catch(Exception e)
        {
            System.out.println("Message: " + e);
        }
		

	}
	
}
