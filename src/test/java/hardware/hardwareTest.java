package hardware;
import org.junit.Assert;
import org.junit.Test;

public class hardwareTest {

	@Test
	public void test() throws Exception{
		AcousticPanel ap = new AcousticPanel();
		Assert.assertEquals(true,ap.Panel_islink());
		ap.Panel_ON();
		Assert.assertEquals("啟動",ap.Panel_status());
		ap.Panel_OFF();
		Assert.assertEquals("關閉",ap.Panel_status());
		
		Camera ca = new Camera();
		Assert.assertEquals("待機",ca.get_status());
		ca.film_start();
		Assert.assertEquals("錄影中",ca.get_status());
		ca.film_stop();
		Assert.assertEquals("待機",ca.get_status());
		ca.save();
		
		Recorder rc = new Recorder();
		Assert.assertEquals("待機",rc.status);
		rc.start();
		Assert.assertEquals("錄音中",rc.status);
		rc.stop();
		Assert.assertEquals("待機",rc.status);
		
		Stereo st = new Stereo();
		Assert.assertEquals("待機",st.status);
		st.start();
		Assert.assertEquals("播放中",st.status);
		st.stop();
		Assert.assertEquals("待機",st.status);
		
		SoundMeter sm = new SoundMeter();
		int i = sm.getData();
		System.out.println(i);
	}

}
