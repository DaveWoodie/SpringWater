package com.netbuilder.app.test;

import java.util.ArrayList;
import java.util.Date;

public class graphData 
{
	//ArrayList<Object[]> Data = new ArrayList<Object[]>();
	Object[][] graphData;
	
	public graphData()
	{
		initArray();
		sortArray();
	}
	
	public void initArray()
	{
		graphData = new Object[][]{
				{20.0, "sales","05/07/2015"},
				{23.0, "sales","12/07/2015"},
				{24.0, "sales","19/07/2015"},
			    {7.0, "sales","26/07/2015"},
				{25.0, "sales","02/08/2015"},
				{25.0, "sales","02/08/2015"},
				{25.0, "sales","16/08/2015"},
				{27.0, "sales","23/08/2015"},
				{28.0, "sales","30/08/2015"},
				{35.0, "sales","06/09/2015"},
				{34.0, "sales","13/09/2015"},
				{36.0, "sales","20/09/2015"},
				{37.0, "sales","27/09/2015"},
				{39.0, "sales","04/10/2015"},
				{38.0, "sales","11/11/2015"},
				{12.0, "sales","09/04/2015"}};	
	}
	
	public void sortArray()
	{

	}
	
	public Object[][] getArray()
	{
		return graphData;
	}
}
