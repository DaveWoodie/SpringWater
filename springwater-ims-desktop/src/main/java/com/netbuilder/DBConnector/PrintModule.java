package com.netbuilder.DBConnector;

import java.sql.*;
import java.util.ArrayList;

public class PrintModule {

	public void printResultSet(ResultSet rs) {

		try {
	      	ResultSetMetaData meta = rs.getMetaData();

	      	ArrayList<String> columnNames = getColumNames(meta);
	      	
	      	ArrayList<Integer> maxColumnWidths = setUpMaxColumnWidths(columnNames);
	      	
	      	ArrayList<String[]> contents = new ArrayList<String[]>();

	      	while(rs.next()) {
	    		updateMaxColumnWidths(rs, columnNames, maxColumnWidths);
	    		addRowToContents(rs, contents, columnNames);
	      	}

	    	printColumnNames(columnNames, maxColumnWidths);

	    	for(int i = 0; i < contents.size(); i++) {
	    		printRow(contents.get(i), maxColumnWidths);
	    	}

	    	printHorizontalDivide(maxColumnWidths);
	    } catch (Exception e) {
	    	throw new Error(e);
	    }

  	}

  	private ArrayList<String> getColumNames(ResultSetMetaData meta) throws Exception {

      	int columns = meta.getColumnCount();
      	ArrayList<String> columnNames = new ArrayList<String>();

      	for(int i = 1; i <= columns; i++) {
        	columnNames.add(meta.getColumnName(i));
      	}
      	return columnNames;
  	}

  	private ArrayList<Integer> setUpMaxColumnWidths(ArrayList<String> columnNames) {
      	ArrayList<Integer> maxColumnWidths = new ArrayList<Integer>();

      	for(int i = 0; i < columnNames.size(); i++) {
        	maxColumnWidths.add(columnNames.get(i).length());
      	}
      	return maxColumnWidths;
  	}

  	private void updateMaxColumnWidths(ResultSet rs, ArrayList<String> columnNames, ArrayList<Integer> maxColumnWidths) throws Exception {
        for(int i = 0; i < columnNames.size(); i++) {
          	String contents = rs.getString(columnNames.get(i));
          	if(rs.wasNull()) {
            	contents = "null";
          	}
          	if(contents.length() > maxColumnWidths.get(i)) {
              	maxColumnWidths.set(i, contents.length());
          	}
        }
  	}

  	private void addRowToContents(ResultSet rs, ArrayList<String[]> contents, ArrayList<String> columnNames) throws Exception {
  		contents.add(new String[columnNames.size()]);
  		String[] currentRow = contents.get(contents.size()-1);

  		for(int i = 0; i < columnNames.size(); i++) {
  			currentRow[i] = rs.getString(columnNames.get(i));
  			if(rs.wasNull()) {
  				currentRow[i] = "null";
  			}
  		}
  	}

  	private void printColumnNames(ArrayList<String> columnNames, ArrayList<Integer> maxColumnWidths) {
  		
  		printHorizontalDivide(maxColumnWidths);
  		String rw = "|";
  		for(int i = 0; i < columnNames.size(); i++) {
  			rw = rw.concat(columnNames.get(i));
  			int diff = maxColumnWidths.get(i) - columnNames.get(i).length();
  			for(int j = 0; j < diff; j++) {
  				rw = rw.concat(" ");
  			}
  			rw = rw.concat("|");
  		}
  		System.out.println(rw);
  		printHorizontalDivide(maxColumnWidths);

  	}

  	private void printHorizontalDivide(ArrayList<Integer> maxColumnWidths) {
  		String divide = "-";
  		int totalWidth = 0;
  		for(int i = 0; i < maxColumnWidths.size(); i++) {
  			totalWidth += maxColumnWidths.get(i);
  			totalWidth ++;
  		}
  		for(int i = 0; i < totalWidth; i++) {
  			divide = divide.concat("-");
  		}
  		System.out.println(divide);
  	}

  	private void printRow(String[] rowContents, ArrayList<Integer> maxColumnWidths) {
  		String rw = "|";
  		for(int i = 0; i < rowContents.length; i++) {
  			rw = rw.concat(rowContents[i]);
  			int diff = maxColumnWidths.get(i) - rowContents[i].length();
  			for(int j = 0; j < diff; j++) {
  				rw = rw.concat(" ");
  			}
  			rw = rw.concat("|");
  		}
  		System.out.println(rw);
  	}

}
