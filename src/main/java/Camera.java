public class Camera extends Thread{
	String cameraStatus = "待機";
	public void film_start(){
		System.out.println("開始錄影");
		cameraStatus = "錄影中";
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		film_stop();
	}
	public void film_stop(){
		System.out.println("結束錄影");
		cameraStatus = "待機";
		SAVE();
	}
	public void SAVE(){
		System.out.println("已將影片存在桌面");
	}
	public String get_status() {
		return cameraStatus;
	}
}
