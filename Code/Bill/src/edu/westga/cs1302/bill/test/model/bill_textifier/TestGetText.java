package edu.westga.cs1302.bill.test.model.bill_textifier;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;
import edu.westga.cs1302.bill.view.BillTextifier;

class TestGetText {

	@Test
	void testNullBill() {
		assertThrows(IllegalArgumentException.class, ()->{BillTextifier.getText(null);});
	}

	@Test
	void testBillWithNoItems() {
		Bill bill = new Bill();
		
		String result = BillTextifier.getText(bill);
		
		String expected = "ITEMS" + System.lineSeparator()
				+ System.lineSeparator()
				+ "SUBTOTAL - $0.00" + System.lineSeparator()
				+ "TAX - $0.00" + System.lineSeparator()
				+ "TIP - $0.00" + System.lineSeparator()
				+ "TOTAL - $0.00";
		
		assertEquals(expected, result);
	}

	@Test
	void testBillWithOneItem() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("1", 5);
		bill.addItem(item1);
		
		String result = BillTextifier.getText(bill);

		
		String expected = "ITEMS" + System.lineSeparator()
				+ "1 - $5.00" + System.lineSeparator()
				+ System.lineSeparator()
				+ "SUBTOTAL - $5.00" + System.lineSeparator()
				+ "TAX - $0.50" + System.lineSeparator()
				+ "TIP - $1.00" + System.lineSeparator()
				+ "TOTAL - $6.50";
		
		assertEquals(expected, result);
	}

	@Test
	void testBillWithMultipleItems() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("1", 5);
		bill.addItem(item1);
		BillItem item2 = new BillItem("2", 6);
		bill.addItem(item2);
		
		String result = BillTextifier.getText(bill);

		String expected = "ITEMS" + System.lineSeparator()
				+ "1 - $5.00" + System.lineSeparator()
				+ "2 - $6.00" + System.lineSeparator()
				+ System.lineSeparator()
				+ "SUBTOTAL - $11.00" + System.lineSeparator()
				+ "TAX - $1.10" + System.lineSeparator()
				+ "TIP - $2.20" + System.lineSeparator()
				+ "TOTAL - $14.30";
		
		assertEquals(expected, result);
	}
}
