/**
 * @author Freshwater
 * @date 29/10/2015
 */

package com.netbuilder.logic;

import java.util.ArrayList;
import java.util.Iterator;

import entities.PurchaseOrder;
import entities.PurchaseOrderLine;
import loaders.PurchaseOrderLineLoader;
import loaders.PurchaseOrderLoader;
import net.sourceforge.openforecast.DataPoint;
import net.sourceforge.openforecast.DataSet;
import net.sourceforge.openforecast.Forecaster;
import net.sourceforge.openforecast.ForecastingModel;
import net.sourceforge.openforecast.Observation;

public class SalesForecast 
{
	//TODO Link : http://www.stevengould.org/portfolio/independent/ofc-ug/x90.html
	
	private int itemID;
	
	private ForecastingModel forecaster;
	private DataSet dataSet = new DataSet();
	
	private PurchaseOrderLoader purchaseOrderLoader = new PurchaseOrderLoader();
	private PurchaseOrderLineLoader pOLineLoader = new PurchaseOrderLineLoader();
	
	private DateLogic dateLogic = new DateLogic();
	
	public SalesForecast(int itemID)
	{
		this.itemID = itemID;
		
		createDataset();
		getForecast();
		Iterate();
	}
	
	public void createDataset()
	{		
		//get purchase order lists containing item ID by earliest date
		ArrayList<PurchaseOrder> pOList = purchaseOrderLoader.getPurchaseOrderListByItem(itemID);
		
		ArrayList<Observation> observationList = new ArrayList<Observation>();
		
		if(pOList.size() > 0)
		{
			for(int i = 0; i < pOList.size(); i++)
			{
				//get purchase order line
				ArrayList<PurchaseOrderLine> pOLineList = pOLineLoader.getPurchaseOrderLineByOrderAndProduct(pOList.get(i).getIDPurchaseOrder(), itemID);
				
				observationList.add(new Observation(pOLineList.get(0).getQuantity()));
				
				dataSet.add(observationList.get(i));
			}
		}
	}
	
	public void getForecast()
	{
		ForecastingModel forecaster = Forecaster.getBestForecast(dataSet);
	}
	
	public void Iterate()
	{
		Iterator it = dataSet.iterator();
		
		while(it.hasNext())
		{
			DataPoint dp = (DataPoint) it.next();
			double forecastValue = dp.getDependentValue();
			
			System.out.println(dp);
		}
	}
	
	public static void main(String[] args)
	{
		SalesForecast s = new SalesForecast(4);
	}
}
