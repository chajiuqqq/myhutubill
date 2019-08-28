package service;

import java.util.List;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import gui.panel.CategoryPanel;

public class CategoryService {
	public List<Category> list() {
		List<Category> list=CategoryDAO.list();
		for(Category x:list){
			int total=RecordDAO.getTotal(x.id);
			x.recordNumber=total;
		}
		
		list.sort((o1,o2)->o2.recordNumber-o1.recordNumber);
		return list;
	}
	
	public void add(String name) {
		CategoryDAO.add(new Category(name));
	}
	
	public void delete(int id) {
		CategoryDAO.delete(id);
	}
	public void update(int id,String name) {
		CategoryDAO.update(new Category(id, name));
	}
}
