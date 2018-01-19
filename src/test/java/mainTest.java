import org.junit.Assert;
import org.junit.Test;

public class mainTest {
	
	@Test
	public void test() throws Exception{
		MainSystem ms = new MainSystem();
		ms.main(null);
		for(int i=10; i>-10; i--) {
			String s = "" + i;
			ms.frame.timeSet(s);
			ms.frame.dbSet(s);
			ms.frame.timeSet("");
			ms.frame.dbSet("");
		}
		for(int j=0; j<100; j++) {
			
			ms.frame.allForcedOn();
			ms.judge = true;
			ms.main(null);
		}
		ms.frame.allForcedOff();
		ms.frame.showStatus("");
	}

}
