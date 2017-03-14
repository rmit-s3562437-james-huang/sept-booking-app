package abs.deploy.testcases;

import static org.junit.Assert.*;
import abs.model.AbsFileOperationImpl;
import abs.model.users.Owner;

import org.junit.*;

public class AbsFileOperationTest {

	public final static String PATH = "/Users/James/git/SEPT2017/";
	public final static String FILENAME = "ownerInfo";
	AbsFileOperationImpl fo = new AbsFileOperationImpl(PATH, FILENAME);
	
	@Test
	public void testReadFromOwner() {
		Owner fileOwner = fo.readFromOwner();
		Owner testOwner = new Owner("Bob", "bob1", "iambob", "1 Bob St", "0311111111", "Owner", "Bob's Burgers");
		assertEquals(fileOwner.toString(), testOwner.toString());
	}

}
