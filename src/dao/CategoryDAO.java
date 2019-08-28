package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import util.DBUtil;

public class CategoryDAO {

	public static void add(Category item) {
		String sql="insert into Category values(null,?)";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setString(1, item.name);
			s.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void update(Category item) {
		String sql="update Category set name_=? where id=?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setString(1, item.name);
			s.setInt(2, item.id);
			s.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void delete(int id) {
		String sql="delete from Category where id=?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setInt(1, id);
			s.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static Category get(int id) {
		String sql="select * from Category where id=?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setInt(1, id);
			s.execute();
			ResultSet result=s.getResultSet();
			return toCategory(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public static List<Category> list() {
		return list(0, Integer.MAX_VALUE);
	}
	public static List<Category> list(int start,int count) {
		String sql="select * from Category limit ?,?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setInt(1, start);
			s.setInt(2, count);
			s.execute();
			ResultSet result=s.getResultSet();
			return toCategorysList(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public static Category toCategory(ResultSet r) throws SQLException {		
		return new Category(r.getInt(1), r.getString(2));
	}
	public static List<Category> toCategorysList(ResultSet r) throws SQLException {
		List<Category> list=new ArrayList<Category>();
		while(r.next()){
			int id=r.getInt(1);
			String name=r.getString(2);
			Category category=new Category(id, name);
			list.add(category);
		}
		
		return list;
	
	}
	
	public static void main(String[] args) {
		CategoryDAO.add(new Category("±ö¹Ý"));
		
//		System.out.println(CategoryDAO.list());
//		CategoryDAO.delete(1);
//		System.out.println(CategoryDAO.list());
	}
	
	
}
