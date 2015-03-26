package testexams.gevapps.com.testexams.textexams.gevapps.com.testexams.engine;

public enum ShowOption {
	ALL(0),
	ONLYPASS(1),
	PASS(2);
	
	private int option;
	
	public ShowOption(int option) {
		this.option = option;
	}
}
