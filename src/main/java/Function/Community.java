package Function;
import Hardware.Camera;
import javax.swing.*;

public class Community {
	Camera camera = new Camera();
	
	public boolean camera_islink(){
		return true;
	}	
	
	public String camera_status() {
		if(camera_islink()) {
			return camera.get_status();
		}else {
			return "£ό";
		}
	}

	public void show_community(){
		JOptionPane.showMessageDialog(null,"ΏΘΊθΟkΠQe:\nhttps://zh-cn.facebook.com/%E9%9D%A0%E5%8C%97%E9%84%B0%E5%B1%85-295032833999864");
	}

	public void film_start(){
		camera.film_start();
	}
	
	public void film_stop(){
		camera.film_stop();
	}
	
}