import java.util.Random;

public class SoundMeter {
	
	Random decibel = new Random();
	
	public int getData() {
		return decibel.nextInt(80)+5;
	}
	
}
