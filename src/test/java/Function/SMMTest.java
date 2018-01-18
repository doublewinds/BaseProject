package Function;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SMMTest {
	
	static SoundMeterMonitor smm = new SoundMeterMonitor();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		smm.startMonitor();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		smm.closeMonitor();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
		int[] testQueue = smm.getDataQueue();
		int testKey = smm.getKey();
		assertEquals(testQueue[testKey],smm.getData());
		assertEquals(true,smm.soundMeterIsActive());
		System.out.println(smm.getSoundWave());
	}

}
