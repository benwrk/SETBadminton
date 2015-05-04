package a_unused;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class Booking{
	
	private ArrayList<Customer> bookingCustomerName = new ArrayList<Customer>();
	private static ArrayList<Customer> reserveCustomerName = new ArrayList<Customer>();
	private int RatePrice;
	private int currentHour,currentMinute;
	
	public Booking()
	{
		RatePrice = 0;
	}
	
	public void setCurrentTime()
	{
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	int hour=0,minute=0;
    	SimpleDateFormat sdf = new SimpleDateFormat("HH");
    	SimpleDateFormat sdf2 = new SimpleDateFormat("mm");
    	hour = Integer.parseInt(String.format("%s",sdf.format(cal.getTime())));
    	minute = Integer.parseInt(String.format("%s",sdf2.format(cal.getTime())));
    	currentHour = hour;
    	currentMinute = minute;
	}
	
	public int getCurrentHour()
	{
		return currentHour;
	}
	
	public int getCurrentMinute()
	{
		return currentMinute;
	}
	
	public void createBookingCustomerName(Customer customer)
	{
		bookingCustomerName.add(customer);
		if(currentHour<18)
			RatePrice = 150;
		else
			RatePrice = 200;
	}
	
	public void createReserveCustomerName(Customer customer)
	{
		reserveCustomerName.add(customer);
		if(currentHour<18)
			RatePrice = 150;
		else
			RatePrice = 200;
	}
	
	public int getRatePrice()
	{
		return RatePrice;
	}
	
	public int numberOfBookingCustomerName()
	{
		return bookingCustomerName.size();
	}
	
	public int numberOFReserveCustomerName()
	{
		return reserveCustomerName.size();
	}
	
	public void removeBookingCustomerName(int index)
	{
		bookingCustomerName.remove(index);
	}
	
	public static void removeReserveCustomerName(int index)
	{
		reserveCustomerName.remove(index);
	}
	
}
