package Hardware;
import java.util.Random;
//ชLvอ[ํ
public class SoundMeter {
	//้ชษาแcฌชLvๆคษ
	Random decibel = new Random();
	
	//ชษ์ืนส๑B
	public int getData() {
		return decibel.nextInt(70)+20;
	}
	
}
