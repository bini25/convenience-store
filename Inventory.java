import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


	
public class Inventory implements IInventory {
	 
	  List<Product> products;
	 
	  public Inventory () {
			 
		}
	
	public List<Product>  getProducts() {
		
		 return  products;
		}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	  
	String convertToString(InputStream in){
		    @SuppressWarnings("resource")
			Scanner scanner = new Scanner(in);
		    scanner.useDelimiter("\\A");
	
		    boolean hasInput = scanner.hasNext();
		    if (hasInput) {
		        return scanner.next();
		    } else {
		        return null;}
		    }
		
		@Override
	    public void replenish(InputStream is) {
			String a = "";
		     a = convertToString(is);
			String[] product = a.split(",");
			for (int i = 0; i < product.length; i++) {
			   product[i] = product[i].replaceAll("[^\\w]", "");
			}
			
			//populating from input
			  products  = new ArrayList<Product>();
			  for (int i = 5; i < product.length; i++) {
			Product apple = new Product(product[i],product[i+1],Double.parseDouble(product[i+2])/100,Double.parseDouble(product[i+3])/100,Integer.parseInt(product[i+4]));
			Product peach = new Product(product[i+5],product[i+6],Double.parseDouble(product[i+7])/100,Double.parseDouble(product[i+8])/100,Integer.parseInt(product[i+9]));
			Product milk = new Product(product[i+10],product[i+11],Double.parseDouble(product[i+12])/100,Double.parseDouble(product[i+13])/100,Integer.parseInt(product[i+14]));
			  i=19;
			//adding objects to the list
			 products.add( 0,apple);
			 products.add( 1, peach);
			 products.add(2, milk); }
			 
		}
		     
		

		@Override
public List<Product> list() {
		List<Product> list = new ArrayList<Product>();    
		 list = products; 
			 return list;
		}
	}
