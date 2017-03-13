package abs.deploy;

import abs.model.AbsFileOperationImpl;
import abs.model.AbsLoginImpl;
import abs.model.AbsRegisterImpl;
import abs.model.users.Customer;
import abs.model.users.Owner;
import abs.model.AbsClientSystemImpl;


public class AbsTest {
	
	public final static String PATH = "/Users/James/git/SEPT2017/";
	public final static String FILENAME = "ownerInfo";
	
	public static void main(String[] args)
	{
		Owner initOwner;
		AbsFileOperationImpl file = new AbsFileOperationImpl(PATH, FILENAME);
		AbsClientSystemImpl storeClient = new AbsClientSystemImpl();
		initOwner = file.readFromOwner();
		storeClient.addOwner(file.readFromOwner());
		storeClient.displayOwnerInfo(initOwner);
	}

}
