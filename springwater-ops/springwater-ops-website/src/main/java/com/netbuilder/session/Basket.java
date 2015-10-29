package com.netbuilder.session;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.netbuilder.test.Item;
import com.netbuilder.test.ItemLine;

public class Basket {
	private ArrayList<ItemLine> itemList;
	private float VAT;
	private float postage;

	public Basket() {
		this.itemList = new ArrayList<ItemLine>();
		VAT = 0.0f;
		postage = 3.99f;
	}

	public ArrayList<ItemLine> getItemList() {
		return this.itemList;
	}

	public void addItemLine(Item item) {
		this.itemList.add(new ItemLine(item, 1));
	}

	public ItemLine getItemLine(Item item) {
		for (ItemLine i : itemList) {
			if (i.getItem().equals(item)) {
				return itemList.get(itemList.indexOf(i));
			}
		}
		return null;
	}

	public boolean itemExists(Item item) {
		for (ItemLine i : itemList) {
			if (i.getItem().equals(item)) {
				return true;
			}
		}
		return false;
	}

	public int getSize() {
		int size = 0;
		for(ItemLine itemLine : itemList) {
			size += itemLine.getQuantity();
		}
		return size;
	}

	public void removeItemLine(ItemLine item) {
		itemList.remove(item);
	}

	public float getVAT() {
		return VAT;
	}
	
	public float getPostage() {
		if(itemList.size() == 0) {
			postage = 0.0f;
		}
		return postage;
	}

	public float grandTotal() {
		float grandTotal = 0.0f;
		for (ItemLine i : itemList) {
			grandTotal += i.totalPrice();
		}
		float total = (float) new BigDecimal((double) grandTotal).setScale(2,
				BigDecimal.ROUND_HALF_UP).doubleValue();
		VAT = total * 0.2f;
		VAT = (float) new BigDecimal((double) VAT).setScale(2,
				BigDecimal.ROUND_HALF_UP).doubleValue();
		return total;
	}
	
	public String formattedGrandTotal() {
		return String.format("%10.2f", grandTotal());
	}
	
	public String formattedPostage() {
		return String.format("%10.2f", postage);
	}
	
	public String formattedFullTotal() {
		return String.format("%10.2f", fullTotal());
	}
	
	public String formattedVAT() {
		return String.format("%10.2f", VAT);
	}

	public float fullTotal() {
		float fullTotal = grandTotal() + VAT + postage;
		float total = (float) new BigDecimal((double) fullTotal).setScale(2,
				BigDecimal.ROUND_HALF_UP).doubleValue();
		return total;
	}

}
