import static org.junit.Assert.*;
import org.junit.Test;

import junit.framework.Assert;

public class Phontest 
{
	int decible[]=new int[150];
	int timeresult []=new int[150];
	int gapresult []=new int[150];
	int test=50,resultt=1,resultg=1;
	public void  value()
	{
		for(int times=0;times<150;times++)
		{
			decible[times]=test;
			test++;
			if(times<20)
			{
				timeresult[times]=0;
				gapresult[times]=resultg;
				resultg++;
				if(resultg==3)
				{
					resultg=0;
				}
			}
			else if(times>19&&times<139)
			{
				timeresult[times]=resultt;
				resultt++;
				if(times==138)
				{
					resultt=0;
				}
				gapresult[times]=0;
			}
			else
			{
				timeresult[times]=resultt;
				resultt++;
				gapresult[times]=0;
			}
		}	
	}
	@Test
	public void test() throws Exception
	{
		value();
		Phone ph = new Phone();
		for(int times=0;times<150;times++)
		{
			ph.rulejudge(decible[times]);
			System.out.println(ph.time+"," +ph.gap);
		}
		Assert.assertEquals(10, ph.time);
	}
	@Test
	public void test2() throws Exception
	{	
		value();
		Phone ph = new Phone();
		for(int times=0;times<150;times++)
		{
			ph.rulejudge(decible[times]);
			System.out.println(ph.time+"," +ph.gap);
		}
		Assert.assertEquals(0, ph.gap);
	}

}
