package Hardware;
import java.util.Random;
//���L�v�͋[��
public class SoundMeter {
	//�鍐���ɘ��c�����L�v椝�
	Random decibel = new Random();
	
	//�����ɍ�׉��ʉ�B
	public int getData() {
		return decibel.nextInt(70)+20;
	}
	
}
