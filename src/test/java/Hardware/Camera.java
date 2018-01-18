package Hardware;

public class Camera{
	
	private String cameraStatus = "待機";
	
	public void film_start(){
		cameraStatus = "錄影中";
	}
	
	public void film_stop(){
		cameraStatus = "待機";
		save();
	}
	
	public void save(){
		
	}
	
	public String get_status() {
		return cameraStatus;
	}
	
}
