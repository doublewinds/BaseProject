import org.junit.Assert;
import org.junit.Test;

public class SwingTest {

	@Test
	public void testTimeSet1() throws Exception {
		Swing sw = new Swing();
		int temp = sw.getcustom_time();
		sw.timeSet("100");
		Assert.assertEquals(temp , sw.getcustom_time());
		
		sw.timeSet("-10");
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
	
	@Test
	public void testshowStatus() throws Exception {
		Swing sw = new Swing();
		sw.showStatus("Test\nHello world");
		String s = sw.textarea.getText();
		Assert.assertEquals("Test\nHello world", s);
	}
}