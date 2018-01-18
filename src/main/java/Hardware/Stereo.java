package Hardware;

public class Stereo {
	
	public String status = "待機";
	
	public void start() {
		status = "播放中";
	}
	
	public void stop() {
		status = "待機";
	}

}
