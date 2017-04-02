package abs.model.bookings;

import java.util.HashMap;

public class Availability {
	
	private HashMap<String, String[]> daysTimesMap;
	
	public Availability (HashMap<String, String[]> daysTimesMap) {
		this.daysTimesMap = daysTimesMap;
	}

	public HashMap<String, String[]> getDaysTimesMap() {
		return daysTimesMap;
	}

	public void setDaysTimesMap(HashMap<String, String[]> daysTimesMap) {
		this.daysTimesMap = daysTimesMap;
	}


	
	
}
