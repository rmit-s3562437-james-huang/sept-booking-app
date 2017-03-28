package abs.model.interfaces;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface Data {
	
	//public final static String PATHNAME = "D:\\Repositories\\SEPT2017\\SEPT2017\\";
	public final static String PATHNAME = "/Users/James/git/SEPT2017/";
	public final static String CUSTOMERFILE = "customerInfo";
	public final static String OWNERFILE = "ownerInfo";
	public final static Path CUSTOMERFILEPATH = Paths.get(PATHNAME + CUSTOMERFILE + ".txt");
	public final static Path OWNERFILEPATH = Paths.get(PATHNAME + OWNERFILE + ".txt");
	public final static String CUSTOMERWRITEFILEPATH = PATHNAME + CUSTOMERFILE + ".txt";
	public final static String REGEX =  "\\,\\ ";
	
	public abstract Availability getAvailability();
}
