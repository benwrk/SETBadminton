package a_unused;

public class Customer {
	
	private String firstname;
	private String lastname;
	
	public Customer(String firstname,String lastname)
	{
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String toString()
	{
		return firstname+" "+lastname;
	}
	
}
