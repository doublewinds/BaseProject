package Function;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SMMTest {
	
	static SoundMeterMonitor smm = new SoundMeterMonitor();
	@Test
	void test() {
		smm.startMonitor();
		int[] testQueue = smm.getDataQueue();
		int testKey = smm.getKey();
		assertEquals(testQueue[testKey],smm.getData());
		assertEquals(true,smm.soundMeterIsActive());
		System.out.println(smm.getSoundWave());
		smm.closeMonitor();
	}

}
