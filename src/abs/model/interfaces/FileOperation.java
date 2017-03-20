package abs.model.interfaces;

import abs.model.users.Customer;
import abs.model.users.Owner;

public interface FileOperation {
	
	public abstract String getFilePath();
	
	public abstract void setFilePath(String filePath);
	
	public abstract String getFileName();
	
	public abstract void setFileName(String fileName);
	
	public abstract Owner readFromOwner();
	
	public abstract Customer readFromCustomer();
	
	public abstract void createFile();
	
	public abstract void readFromFile();
	
	public abstract void writeToFile();
}
