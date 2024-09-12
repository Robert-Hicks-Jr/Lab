package edu.westga.cs1302.bill.test.model.bill;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillItem;

class TestAddItem {

	@Test
	void testNullItem() {
		Bill bill = new Bill();
		
		assertThrows(IllegalArgumentException.class, ()->{bill.addItem(null);});
	}
	
	@Test
	void testAddFirstItem() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("1", 5);
		
		bill.addItem(item1);
		
		assertEquals(1, bill.getSize(), "checking number of items in the bill");
		BillItem firstItem = bill.getItems()[0];
		assertEquals("1", firstItem.getName(), "checking the name of the first item in the bill");
		assertEquals(5, firstItem.getAmount(), "checking the name of the first item in the bill");
	}
	
	@Test
	void testAddSecondItem() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("1", 5);
		BillItem item2 = new BillItem("2", 6);
		bill.addItem(item1);
		
		bill.addItem(item2);
		
		assertEquals(2, bill.getSize(), "checking number of items in the bill");
		BillItem firstItem = bill.getItems()[0];
		assertEquals("1", firstItem.getName(), "checking the name of the first item in the bill");
		assertEquals(5, firstItem.getAmount(), "checking the name of the first item in the bill");
		BillItem secondItem = bill.getItems()[1];
		assertEquals("2", secondItem.getName(), "checking the name of the first item in the bill");
		assertEquals(6, secondItem.getAmount(), "checking the name of the first item in the bill");
	}
	
	@Test
	void testAddTooManyItems() {
		Bill bill = new Bill();
		BillItem item1 = new BillItem("1", 5);
		BillItem item2 = new BillItem("2", 6);
		BillItem item3 = new BillItem("3", 7);
		BillItem item4 = new BillItem("4", 8);
		bill.addItem(item1);
		bill.addItem(item2);
		bill.addItem(item3);
		
		assertThrows(IllegalStateException.class, ()->{bill.addItem(item4);});
	}

}
