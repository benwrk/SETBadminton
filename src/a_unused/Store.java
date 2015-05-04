package a_unused;

public class Store{
	
	private int revenue;
	
	public Store()
	{
		this.revenue = 0;
	}
	
	public void booking(Booking booking,Customer customer)
	{
		booking.createBookingCustomerName(customer);
	}
	
	public void reserve(Booking reserve,Customer customer)
	{
		reserve.createReserveCustomerName(customer);
	}
	
	public void cancelBooking(Booking booking,int index)
	{
		booking.removeBookingCustomerName(index);
	}
	
	public void cancelReserve(Booking reserve,int index)
	{
		Booking.removeReserveCustomerName(index);
	}
	
	public void receivePayment(Booking booking,int index)
	{
		revenue+=booking.getRatePrice();
	}
	
	public double getProfit(){
		return this.revenue;
	}
	
}
