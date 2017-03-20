package abs.model.interfaces;

public interface Client {

	public abstract String getName();
	
	public abstract String getUserName();
	
	public abstract String getUserPassword();
	
	public abstract String getUserAddress();
	
	public abstract String getUserPhoneNumber();
	
	public abstract void setName(String name);
	
	public abstract void setUserName(String userName);
	
	public abstract void setUserPassword(String userPassword);
	
	public abstract void setUserAddress(String userAddress);
	
	public abstract void setUserPhoneNumber(String userPhoneNumber);
	
	public abstract String getUserRole();
	
	public abstract void setUserRole(String userRole);
	
}
