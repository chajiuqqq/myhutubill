package gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Category;
import service.CategoryService;

public class CategoryTableModel extends AbstractTableModel{
	public String[] columns={"消费分类","消费次数"};
	public List<Category> values=(new CategoryService()).list();
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return values.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columns[column];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex==0){
			return values.get(rowIndex).name;
		}
		if(columnIndex==1){
			return values.get(rowIndex).recordNumber;
		}
		return null;
	}

}
