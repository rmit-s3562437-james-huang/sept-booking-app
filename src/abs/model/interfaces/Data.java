package abs.model.interfaces;

public interface Data {
	
	public void readUsername();
	
	public void readPassword();
	
	public boolean validateUsername(String username);
	
	public boolean validatePassword(String password);
}
