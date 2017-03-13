package abs.deploy;

import abs.model.*;

public class AbsTest {
	
	public static void main(String[] args)
	{
		AbsFileOps file = new AbsFileOps("/Users/James/git/SEPT2017/", "ownerInfo");
		file.readFromOwner();
	}
	
}
