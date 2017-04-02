package abs.model.interfaces;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;

import abs.model.users.Owner;

public interface FileOperation {
	
	public abstract void createFile(Path path);
	
	public abstract void primeCustomerFile(String FileWritePath);
	
	public abstract void writeToCustomerFile(String FileWritePath, String toWrite, boolean newLine);

	public abstract ArrayList<String> readFromFile(Path path);
	
}
