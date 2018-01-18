package Hardware;
import java.util.Random;
//分貝計模擬器
public class SoundMeter {
	//建立亂數作為分貝計讀數
	Random decibel = new Random();
	
	//取得亂數作為讀數回傳
	public int getData() {
		return decibel.nextInt(70)+20;
	}
	
}
