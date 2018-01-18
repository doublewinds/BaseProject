package Hardware;
import java.util.Random;
//•ªŠLŒv–Í‹[Ší
public class SoundMeter {
	//é˜ªÉ˜Òác¬•ªŠLŒvæ¤É
	Random decibel = new Random();
	
	//›’˜ªÉìˆ×‰¹—Ê‰ñ™B
	public int getData() {
		return decibel.nextInt(70)+20;
	}
	
}
