import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * This can be used as driver class to  ensure that you have a working implementation for Part 1 & 2.
 * You are free to modify this class as you deem necessary although it's highly
 * recommended that you produce jUnit tests to verify the logic in your code.
 */
public class StoreApplication {

	/**
	 * This is the main entry point to this application.
	 * 
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(final String args[]) throws UnsupportedEncodingException {

        final InputStream input = inputStreamFromString("upc,name,wholesalePrice,retailPrice,quantity,\n"
                + "A123,Apple,0.50,1.00,100,\n" + " B234,Peach,0.35,0.75,200,\n" + " C123,Milk,2.15,4.50,40"

        ); // part one scenario
        final IInventory inventory = new Inventory();
        inventory.replenish(input);
        System.out.println("upc  product Wprice  Rprice  quantity");
        for (final Product product : inventory.list()) {
            System.out.println(product.toString());
        }
        // Part Two scenario
        final CashRegister c = new CashRegister(inventory);

        try {
            c.beginTransaction();
        } catch (final Exception e) {

            e.printStackTrace();
        }

    }

    /**
     * This is a simple way to convert a string to an input stream.
     * 
     * @param value the String value to convert
     * @return an InputStream that can read the values from the <code>value</code>
     *         parameter
     * @throws UnsupportedEncodingException
     */
    private static InputStream inputStreamFromString(final String value) throws UnsupportedEncodingException {
		return new ByteArrayInputStream(value.getBytes("UTF-8"));
	}
}