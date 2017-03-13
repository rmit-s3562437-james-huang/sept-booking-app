package abs.deploy;

import abs.model.*;

public class AbsTest {
	
	public static void main(String[] args)
	{
		AbsFileOps file = new AbsFileOps("C:\\Users\\Sotoam Bak\\Documents\\Repositories\\SEPT2017\\", "ownerInfo");
		file.readFromOwner();
	}
	
}
