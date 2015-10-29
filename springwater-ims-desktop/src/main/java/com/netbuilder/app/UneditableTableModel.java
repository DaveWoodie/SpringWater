package com.netbuilder.app;

import javax.swing.table.DefaultTableModel;

public class UneditableTableModel extends DefaultTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

    public UneditableTableModel(Object[][] data, Object[] columnNames) {
        setDataVector(data, columnNames);
    }
	
	@Override
    public boolean isCellEditable(int i, int i1) {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

}
