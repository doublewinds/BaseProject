package Hardware;

public class AcousticPanel{
	
	String panelStatus = "關閉";
	
	public boolean Panel_islink() {
		return true;
	}
	
	public void Panel_ON() {
		panelStatus = "啟動";
	}
	
	public void Panel_OFF() {
		panelStatus = "關閉";
	}
	
	public String Panel_status() {
		return panelStatus;
	}
	
}

