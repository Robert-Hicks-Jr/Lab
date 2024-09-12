package edu.westga.cs1302.bill.test.model.bill_item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.BillItem;

class TestConstructor {

	@Test
	void testNullName() {
		assertThrows(IllegalArgumentException.class, ()->{new BillItem(null, 5);});
	}
	
	@Test
	void testAmountTooLow() {
		assertThrows(IllegalArgumentException.class, ()->{new BillItem("abc", 0);});
	}
	
	@Test
	void testValidNameAndAmount() {
		BillItem result = new BillItem("a", 1);
		
		assertEquals("a", result.getName(), "checking name of the item");
		assertEquals(1, result.getAmount(), "checking amount for the item");
	}

}
