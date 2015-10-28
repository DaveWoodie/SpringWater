package com.netbuilder.test;

import java.math.BigDecimal;

public class ItemLine {
	private Item item;
	private int quantity;

	public ItemLine(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity += quantity;
		if (this.quantity < 0) {
			this.quantity = 0;
		}
	}

	public float totalPrice() {
		Double toBeTruncated = (double) item.getPrice() * quantity;
		float total = (float) new BigDecimal(toBeTruncated).setScale(2,
				BigDecimal.ROUND_HALF_UP).doubleValue();
		return total;
	}

	public String formattedTotalPrice() {
		return String.format("%10.2f", totalPrice());
	}
}
