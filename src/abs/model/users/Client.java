package abs.model.users;

public class Client {
	
	private String userName;
	private String userPassword;
	private String userAddress;
	private String userPhoneNumber;
	
	public Client(String userName, String userPassword, String userAddress, String userPhoneNumber)
	{
		this.userName = userName;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userPhoneNumber = userPhoneNumber;
	}
	
	
	public String getUserName()
	{
		return this.userName;
	}
	public String getUserPassword()
	{
		return this.userPassword;
	}
	public String getUserAddress()
	{
		return this.userAddress;
	}
	public String getUserPhoneNumber()
	{
		return this.userPhoneNumber;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}
	public void setUserAddress(String userAddress)
	{
		this.userAddress = userAddress;
	}
	public void setUserPhoneNumber(String userPhoneNumber)
	{
		this.userPhoneNumber = userPhoneNumber;
	}
}
