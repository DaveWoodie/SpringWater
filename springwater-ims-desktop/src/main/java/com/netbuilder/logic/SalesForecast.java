/**
 * @author Freshwater
 * @date 29/10/2015
 */

package com.netbuilder.logic;

import java.util.ArrayList;

import entities.PurchaseOrder;
import entities.PurchaseOrderLine;
import loaders.PurchaseOrderLineLoader;
import loaders.PurchaseOrderLoader;
import net.sourceforge.openforecast.DataSet;
import net.sourceforge.openforecast.Forecaster;
import net.sourceforge.openforecast.Observation;

public class SalesForecast 
{
	private int itemID;
	
	private Forecaster forecaster;
	private DataSet dataSet = new DataSet();
	
	private PurchaseOrderLoader purchaseOrderLoader = new PurchaseOrderLoader();
	private PurchaseOrderLineLoader pOLineLoader = new PurchaseOrderLineLoader();
	
	public SalesForecast(int itemID)
	{
		this.itemID = itemID;
		
		createDataset();
	}
	
	public void createDataset()
	{
		ArrayList<PurchaseOrder> pOList = purchaseOrderLoader.getPurchaseOrderListByItem(itemID);
		
		//get purchase order lists containing item ID
		ArrayList<PurchaseOrderLine> pOLineList = pOLineLoader.getPurchaseOrderLineByProductID(itemID);
		
		//Observation o = new Observation(600.0);
		
		for(int i = 0; i < pOLineList.size(); i++)
		{
			dataSet.add(new Observation(pOLineList.get(i).getQuantity()));
			System.out.println(data);
		}
	}
	
	public static void main(String[] args)
	{
		SalesForecast s = new SalesForecast(4);
	}
}
