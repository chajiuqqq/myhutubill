package util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {
	/**
	 * LocalDate->java.sql.Date 
	 * @param date
	 * @return
	 */
	public static java.sql.Date toSqlDate(LocalDate date) {
		Date d=LocalDateToUdate(date);
		return toSqlDate(d);
	}
	/**
	 * java.util.Date->java.sql.Date 
	 * @param date
	 * @return
	 */
	public static java.sql.Date toSqlDate(Date date) {
		long times=date.getTime();
		return new java.sql.Date(times);
	}
	/**
	 * LocalDate->java.util.Date
	 * @param localDate
	 * @return
	 */
	public static Date LocalDateToUdate(LocalDate localDate) {
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
		return Date.from(instant);
	}
	
	
	public static java.sql.Date theStartOfMonth() {
		LocalDate start=LocalDate.now();
		start=start.minusDays(start.getDayOfMonth()-1);
		return toSqlDate(start);
	}
	public static java.sql.Date theEndOfMonth() {
		LocalDate end=LocalDate.now();
		while(end.getMonthValue()==LocalDate.now().getMonthValue()){
			end=end.plusDays(1);
		}
		end=end.minusDays(1);
		return toSqlDate(end);
	}
	public static java.sql.Date today() {
		LocalDate date=LocalDate.now();
		return toSqlDate(date);
	}
	
	public static int totalDaysOfThisMonth() {
		LocalDate end=LocalDate.now();
		while(end.getMonthValue()==LocalDate.now().getMonthValue()){
			end=end.plusDays(1);
		}
		end=end.minusDays(1);
		int total=end.getDayOfMonth();
		return total;
	}
	public static int lastDaysOfThisMonth() {
		int total=totalDaysOfThisMonth();
		int lastdays=total-LocalDate.now().getDayOfMonth();
		return lastdays;
	}
	public static void main(String[] args) {
		System.out.println(lastDaysOfThisMonth());
	}
	
	
}
