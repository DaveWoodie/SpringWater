//package com.netbuilder.session;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
//import com.netbuilder.test.Item;
//
//public class BasketImpl implements Basket {
//
//	private ArrayList<Item> itemList;
//
//	public BasketImpl() {
//		this.itemList = new ArrayList<Item>();
//	}
//	
//	@Override
//	public ArrayList<Item> getItemList() {
//		return this.itemList;
//	}
//
//	@Override
//	public void addItem(Item item) {
//		this.itemList.add(item);
//	}
//
//	@Override
//	public int getSize() {
//		return this.itemList.size();
//	}
//
//}
