
public class Camera extends Thread{
	public void film_start(){
		System.out.println("�}�l���v");
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		film_stop();
	}
	public void film_stop(){
		System.out.println("�������v");
		SAVE();
	}
	public void SAVE(){
		System.out.println("�w�N�v���s�b�ୱ");
	}
}

