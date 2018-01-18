import static org.junit.Assert.*;
import org.junit.Test;

import junit.framework.Assert;

public class Phontest 
{
	int decible[]=new int[150];
	int timeresult []=new int[150];
	int gapresult []=new int[150];
	int test=50,resultt=1,resultg=1;
	@Test
	public void test() throws Exception
	{
		for(int times=0;times<150;times++)
		{
			decible[times]=test;
			test++;
		}	
		Phone ph = new Phone();
		for(int times=0;times<150;times++)
		{
			ph.rulejudge(decible[times]);
			System.out.println(ph.time+"," +ph.gap);
		}
		Assert.assertEquals(10, ph.time);
		Assert.assertEquals(0, ph.gap);
	}
}
