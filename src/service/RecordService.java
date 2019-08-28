package service;

import java.util.Date;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;
import util.DateUtil;

public class RecordService {
	public void add(int spend,Category category,String comments,Date date) {
		int cid=category.id;
		Record item=new Record(0, spend, cid, comments, DateUtil.toSqlDate(date));
		RecordDAO.add(item);
	}
}
