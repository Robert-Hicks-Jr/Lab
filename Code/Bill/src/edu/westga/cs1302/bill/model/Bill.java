package edu.westga.cs1302.bill.model;

/**
 * Manages a set of BillItems.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class Bill {
	public static final int MAX_NUMBER_OF_ITEMS = 3;
	private BillItem[] items;
	private int size;

	/**
	 * Create a new empty Bill
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 */
	public Bill() {
		this.items = new BillItem[Bill.MAX_NUMBER_OF_ITEMS];
		this.size = 0;
	}

	/**
	 * Adds the item to the bill
	 * 
	 * @precondition item != null && size < 5
	 * @postcondition item is added to the list of items in the bill
	 * 
	 * @param item the item to be added to the bill
	 */
	public void addItem(BillItem item) {
		if (item == null) {
			throw new IllegalArgumentException("item must not be null.");
		}
		if (this.size == Bill.MAX_NUMBER_OF_ITEMS) {
			throw new IllegalStateException("bill items list is full");
		}
		this.items[this.size] = item;
		this.size++;
	}
	
	/** Return the number of items in the bill
	 * 
	 * @return the number of items in the bill
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Return the items in the bill
	 * 
	 * @return the items in the bill
	 */
	public BillItem[] getItems() {
		return this.items;
	}

	/**
	 * Return the subtotal for the bill
	 * 
	 * @return the subtotal for the bill
	 */
	public double getSubTotal() {
		double subTotal = 0.0;
		for (BillItem item : this.items) {
			if (item != null) {
				subTotal += item.getAmount();
			}
		}
		return subTotal;
	}

	/**
	 * Return the tax for the bill
	 * 
	 * @return the tax for the bill
	 */
	public double getTax() {
		return this.getSubTotal() * 0.1;
	}

	/**
	 * Return the tip for the bill
	 * 
	 * @return the tip for the bill
	 */
	public double getTip() {
		return this.getSubTotal() * 0.2;
	}

	/**
	 * Return the total for the bill
	 * 
	 * @return the total for the bill
	 */
	public double getTotal() {
		return this.getSubTotal() + this.getTax() + this.getTip();
	}

}
