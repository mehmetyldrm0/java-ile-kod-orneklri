package org.csystem.app;
import java.util.*;
class App {
	public static void main(String [] args)
	{	
		
		DateAppTest.run();
	}
	
}

class DateAppTest {
	public static void run()
	{
		Scanner scanner = new Scanner(System.in);
		
		for(;;) {
			System.out.println("gün, ay ve yıl bilgilerini giriniz");
			int day = scanner.nextInt();
			int month = scanner.nextInt();
			int year = scanner.nextInt();
		
			DateApp.print(day, month, year);
		}
	}
}

class DateApp {
	public static void print(int day, int month, int year)
	{
		if(!dateValidity(day, month, year)) {
			System.out.println("geçersiz tarih bilgisi girdiniz");
		
			return;
		}
		
		System.out.printf("%d %s %s%n ", year, monthsTR[month], dayOfWeeksTR[findTheDay(day, month, year)]);
		
		if(findTheDay(day, month, year) == 0 || findTheDay(day, month, year)  == 6)
			System.out.println("Bugün kurs var tekrar yaptınızmı?");
		else {
			System.out.println(" kurs günü yaklaşıyor tekrar yapıyormusunuz?");
		}
			
	}
	public static int [] daysOfMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static String [] monthsTR = {"", "Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran",
            "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"};
	
	public static String [] dayOfWeeksTR = {"Pazar", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi"};
	
	
	public static int findTheDay(int day , int month, int year)
	{
		
				
		int	totalDays = day;
		
		
		for (int i = month - 1; i >= 1; --i) {
			totalDays += daysOfMonths[i];
		
		}
		
		if(İsleapyear(year)) {
			totalDays += 1;
		}
		
		
		for(int i = 1900; i < year; ++i) {
			totalDays += İsleapyear(i) ? 366 : 365;
		}
		
		
		return totalDays % 7;
	}
	
	public static boolean dateValidity(int day, int month , int year)
	{
		if(year > 1900 && İsleapday(day, month, year))
			return true;
		return false;
	}
	public static boolean İsleapday(int day , int month, int year)
	{
		return 1<= day && day <= 31 && 1 <= month && month <= 12 && day <= getDays(month , year); 
	}
	
	public static int getDays(int month, int year)
	{
		return month == 2 || İsleapyear(year) ? 29 : daysOfMonths[month];
	}
	public static boolean İsleapyear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
}
