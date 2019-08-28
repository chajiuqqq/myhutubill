package service;

import dao.ConfigDAO;
import entity.Config;

public class ConfigService {
	private static  String budget="2500";
	private static  String mysqlPath="";
	
	public ConfigService() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	public void init() {
		if(ConfigDAO.getByKey("budget")==null){
			ConfigDAO.add(new Config("budget", budget));
		}
		if(ConfigDAO.getByKey("mysqlPath")==null){
			ConfigDAO.add(new Config("mysqlPath", mysqlPath));
		}
	}
	
	public Config get(String key) {
		return ConfigDAO.getByKey(key);
	}
	
	public void update(String key,String value) {
		Config c=new Config(key, value);
		ConfigDAO.update(c);
	}
	
}
