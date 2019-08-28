package gui.model;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import entity.Category;
import service.CategoryService;

public class CategoryComboBoxModel implements ComboBoxModel{

	public List<Category> menu=new CategoryService().list();
	public Category selected=null;
	
	public CategoryComboBoxModel() {
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return menu.size();
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return menu.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		selected=(Category)anItem;
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return selected;
	}

}
