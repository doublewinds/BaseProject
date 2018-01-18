package Hardware;

public class Camera{
	
	String cameraStatus = "待機";
	
	public void film_start(){
		cameraStatus = "錄影中";
	}
	
	public void film_stop(){
		cameraStatus = "待機";
		save();
	}
	
	private void save(){
		
	}
	
	public String get_status() {
		return cameraStatus;
	}
	
}
