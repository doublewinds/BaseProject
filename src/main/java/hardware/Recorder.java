package hardware;

public class Recorder {
	
	public String status = "待機";
	
	public void start() {
		status = "錄音中";
	}
	
	public void stop() {
		status = "待機";
	}
	
}
