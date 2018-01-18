import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import function.SoundMeterMonitor;

public class SMM_Test {
	
	static SoundMeterMonitor smm = new SoundMeterMonitor();

	@Test
	public void test() {
		smm.startMonitor();
		int[] testQueue = smm.getDataQueue();
		int testKey = smm.getKey();
		assertEquals(testQueue[testKey],smm.getData());
		assertEquals(true,smm.soundMeterIsActive());
		System.out.println(smm.getSoundWave());
		smm.closeMonitor();
	}

}
