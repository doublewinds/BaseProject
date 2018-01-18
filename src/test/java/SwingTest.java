import org.junit.Assert;
import org.junit.Test;

public class SwingTest {

	@Test
	public void testTimeSet() throws Exception {
		Swing sw = new Swing();
		int temp = sw.getcustom_time();
		sw.timeSet("100");
		Assert.assertEquals(temp , sw.getcustom_time());
		
		sw.timeSet("abc");
		Assert.assertEquals(temp , sw.getcustom_time());
		
		sw.timeSet("5");
		Assert.assertEquals(5, sw.getcustom_time());
	}

	@Test
	public void testDbSet() throws Exception {
		Swing sw = new Swing();
		int temp = sw.getcustom_db();
		sw.dbSet("-1");
		Assert.assertEquals(temp , sw.getcustom_db());
		
		sw.dbSet("abc");
		Assert.assertEquals(temp , sw.getcustom_db());
		
		sw.dbSet("60");
		Assert.assertEquals(60, sw.getcustom_db());
	}
}