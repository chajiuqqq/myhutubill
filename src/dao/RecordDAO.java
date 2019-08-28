package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.Record;
import util.DBUtil;
import util.DateUtil;

public class RecordDAO {
	public static int getTotal(int cid) {
		String sql="select count(*) from Record where cid=?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setInt(1, cid);
			s.execute();
			ResultSet result=s.getResultSet();
			int total=0;
			while(result.next()){
				total=result.getInt(1);
			}
			return total;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	public static void add(Record item) {
		String sql="insert into Record values(null,?,?,?,?)";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setInt(1, item.spend);
			s.setInt(2, item.cid);
			s.setString(3, item.comments);
			s.setDate(4, DateUtil.toSqlDate(item.days));
			s.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void update(Record item) {
		String sql="update Record set spend=?,cid=?,comments=?,days=? where id=?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setInt(1, item.spend);
			s.setInt(2, item.cid);
			s.setString(3, item.comments);
			s.setDate(4, DateUtil.toSqlDate(item.days));
			s.setInt(5, item.id);
			s.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void delete(int id) {
		String sql="delete from Record where id=?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setInt(1, id);
			s.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static List<Record> list() {
		return list(0, Integer.MAX_VALUE);
	}
	public static List<Record> list(int start,int count) {
		String sql="select * from Record limit ?,?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setInt(1, start);
			s.setInt(2, count);
			s.execute();
			ResultSet result=s.getResultSet();
			return toRecordsList(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 返回今天的消费记录列表
	 * @return
	 */
	public static List<Record> listToday() {
		return list(DateUtil.today());
	}
	
	public static List<Record> list(Date date) {
		String sql="select * from Record where days=?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setDate(1, date);
			s.execute();
			ResultSet result=s.getResultSet();
			return toRecordsList(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 返回这个月的消费记录列表
	 * @return
	 */
	public static List<Record> listThisMonth() {
		return list(DateUtil.theStartOfMonth(), DateUtil.theEndOfMonth());
	}
	public static List<Record> list(Date from,Date to ) {
		String sql="select * from Record where days>=? and days<=?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setDate(1, from);
			s.setDate(2, to);
			s.execute();
			ResultSet result=s.getResultSet();
			return toRecordsList(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	private static Record toRecord(ResultSet r) throws SQLException {		
		return new Record(r.getInt(1), r.getInt(2),r.getInt(3),r.getString(4),r.getDate(5));
	}
	private static List<Record> toRecordsList(ResultSet r) throws SQLException {
		List<Record> list=new ArrayList<Record>();
		while(r.next()){
			int id=r.getInt(1);
			int spend=r.getInt(2);
			int cid=r.getInt(3);
			String comments=r.getString(4);
			Date days=r.getDate(5);
			Record record=new Record(id, spend, cid, comments, days);
			list.add(record);
		}
		
		return list;
	
	}
	
	public static void main(String[] args) {
		Date d1=DateUtil.toSqlDate(LocalDate.of(2019, 8, 25));
		RecordDAO.add(new Record(200,2,"comments",new java.util.Date()));
		RecordDAO.add(new Record(300,2,"comments",d1));
		for(Record x:listThisMonth())
			System.out.println(x);
		System.out.println("=========");
		for(Record x:listToday())
			System.out.println(x);
		
		
	}
}
