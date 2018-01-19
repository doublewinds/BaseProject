package function;
import org.junit.Assert;
import org.junit.Test;

public class SMM_Test {
	
	@Test
	public void test() throws Exception{
		SoundMeterMonitor smm = new SoundMeterMonitor();
		smm.startMonitor();
		int[] testQueue = smm.getDataQueue();
		int testKey = smm.getKey();
		Assert.assertEquals(testQueue[testKey],smm.getData());
		Assert.assertEquals(true,smm.soundMeterIsActive());
		System.out.println(smm.getSoundWave());
		smm.closeMonitor();
	}

}
