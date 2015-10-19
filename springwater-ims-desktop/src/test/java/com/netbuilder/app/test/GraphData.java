package com.netbuilder.app.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class GraphData 
{
	private ArrayList<Object[]> graphData = new ArrayList<Object[]>();
	private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public GraphData()
	{
		initArray();
		sortArray();
	}
	
	public void initArray()
	{
		graphData.add(new Object[]{20.0, "sales","05/07/2015"});
		graphData.add(new Object[]{20.0, "sales","05/07/2015"});
		graphData.add(new Object[]{23.0, "sales","12/07/2015"});
		graphData.add(new Object[]{24.0, "sales","19/07/2015"});
		graphData.add(new Object[]{7.0, "sales","26/07/2015"});
		graphData.add(new Object[]{25.0, "sales","02/08/2015"});
		graphData.add(new Object[]{25.0, "sales","02/08/2015"});
		graphData.add(new Object[]{25.0, "sales","16/08/2015"});
		graphData.add(new Object[]{27.0, "sales","23/08/2015"});
		graphData.add(new Object[]{28.0, "sales","30/08/2015"});
		graphData.add(new Object[]{35.0, "sales","06/09/2015"});
		graphData.add(new Object[]{34.0, "sales","13/09/2015"});				
		graphData.add(new Object[]{36.0, "sales","20/09/2015"});
		graphData.add(new Object[]{37.0, "sales","27/09/2015"});
		graphData.add(new Object[]{39.0, "sales","04/10/2015"});
		graphData.add(new Object[]{38.0, "sales","11/11/2015"});
	    graphData.add(new Object[]{12.0, "sales","09/04/2015"});	
	}
	
	public void sortArray()
	{
		ArrayList<String> stringDateArray = new ArrayList<String>();
		ArrayList<Date> dateArray = new ArrayList<Date>();
		ArrayList<Object[]> objectArray = new ArrayList<Object[]>();
		
		for(int i = 0; i < graphData.size(); i++)
		{
			try 
			{
				//Extracts date from object array
				//Adds date to date array list
				dateArray.add(df.parse((String) graphData.get(i)[2]));
			} 
			catch (ParseException e) 
			{
				e.printStackTrace();
			}
		}
		
		//sort array list of dates in order
		Collections.sort(dateArray);
		
		for(int i = 0; i < dateArray.size(); i++)
		{
			//convert date to String and format to DD/MM/YYYY
			//Add to string date array
			stringDateArray.add(df.format(dateArray.get(i)));
		}
		
		for(int i = 0; i < stringDateArray.size(); i++)
		{
			for(int j = 0; j < graphData.size(); j++)
			{
				if(stringDateArray.get(i).equals(graphData.get(j)[2]))
				{
					objectArray.add(graphData.get(j));
				}
			}
		}
		
		//Update array
		graphData = objectArray;
	}
	
	public ArrayList<Object[]> getDataArray()
	{
		return graphData;
	}
	
	public void addSale(int itemsSold, String Date)
	{
		graphData.add(new Object[]{itemsSold, "Sales", Date});
		sortArray();
	}
	
	public static void main(String[] args) {
		GraphData gd = new GraphData();
	}
}
