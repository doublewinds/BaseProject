import javax.swing.*;
public class Phone extends Thread
{
	String[] phonenum=new String[3];
	int time=0,gap=0;
	public void rulejudge(int decibel)
	{
		if(decibel>=70)
		{
			time++;
		}
		else 
		{	
			gap++;
			if(gap==3)
			{
				time=0;
				gap=0;
			}
		}
		if(time==120)
		{
			time=0;
			gap=0;
			outnumber();
		}
	}
	public void outnumber()
	{
		phonenum[0]="全國環保報案專線:0800-066666";
		phonenum[1]="台中市環保局檢舉電話:04-22291747";
		phonenum[2]="蘋果爆料電話:0809-012-555";
		JOptionPane.showMessageDialog(null, phonenum );
	}
}
