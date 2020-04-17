import java.io.InputStream;
import java.util.List;



/**
 * Interface that represents a product inventory.
 * 

 */
public interface IInventory {

	

	/**
	 * Reads the inventory from a comma separated <code>InputStream</code>, each
	 * line in the <code>InputStream</code> represents a different <code>Product</code>. An
	 * example input stream looks like this (the header will be part of the
	 * input stream as well):
	 * 
	 * <pre>
	upc,name,wholesalePrice,retailPrice,quantity
	A123,Apple,0.50,1.00,100
	B234,Peach,0.35,0.75,200
	C123,Milk,2.15,4.50,40
	 * </pre>
	 * 
	 * @param inputStream the stream from where to read the inventory
	 */
	public void replenish(InputStream inputStream);

	/**
	 * @return returns an unmodifiable <code>List</code> of <code>Product</code> representing 
	 * products inside the inventory.
	 */
	public List<Product> list();


}
