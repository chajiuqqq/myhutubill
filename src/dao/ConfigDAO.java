package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Config;
import util.DBUtil;

public class ConfigDAO {
	
	
	public static void add(Config item) {
		String sql="insert into config values(null,?,?)";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setString(1, item.key);
			s.setString(2, item.value);
			s.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void update(Config item) {
		String sql="update config set value_=? where key_=?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setString(1, item.value);
			s.setString(2, item.key);
			s.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void delete(int id) {
		String sql="delete from config where id=?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setInt(1, id);
			s.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static Config get(int id) {
		String sql="select * from config where id=?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setInt(1, id);
			s.execute();
			ResultSet result=s.getResultSet();
			return toConfig(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public static List<Config> list() {
		return list(0, Integer.MAX_VALUE);
	}
	public static List<Config> list(int start,int count) {
		String sql="select * from config limit ?,?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setInt(1, start);
			s.setInt(2, count);
			s.execute();
			ResultSet result=s.getResultSet();
			return toConfigsList(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public static Config getByKey(String key) {
		String sql="select * from config where key_=?";
		try(Connection c=DBUtil.getConnection();
				PreparedStatement s=c.prepareStatement(sql);) {
			s.setString(1, key);
			s.execute();
			ResultSet result=s.getResultSet();
			return toConfig(result);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public static Config toConfig(ResultSet r) throws SQLException {
		Config config=null;
		while(r.next()){
			config=new Config(r.getInt(1), r.getString(2), r.getString(3));
		}
		return config;
	}
	public static List<Config> toConfigsList(ResultSet r) throws SQLException {
		List<Config> list=new ArrayList<Config>();
		while(r.next()){
			int id=r.getInt(1);
			String key=r.getString(2);
			String value=r.getString(3);
			Config config=new Config(id, key, value);
			list.add(config);
		}
		
		return list;
	
	}
	
	public static void main(String[] args) {
		ConfigDAO.add(new Config("budget", "2500"));
		System.out.println(ConfigDAO.list());
	}
	
	
	
}
