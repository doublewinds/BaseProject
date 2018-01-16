
public class Camera extends Thread{
	public void film_start(){
		System.out.println("開始錄影");
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
		SAVE();
	}
	public void SAVE(){
		System.out.println("已將影片存在桌面");
	}
}

