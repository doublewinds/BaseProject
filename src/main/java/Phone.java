import javax.swing.*;
public class Phone extends Thread
{
	String[] phonenum=new String[3];
	int time=0,gap=0;
	boolean i = false;
	public boolean rulejudge(int decibel)
	{
		i=false;
		if(decibel>=70)
		{
			time++;
			gap=0;
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
			i=true;
		}
		return i;
	}
	public void outnumber()
	{
		phonenum[0]="�������O���ױM�u:0800-066666";
		phonenum[1]="�x�������O�����|�q��:04-22291747";
		phonenum[2]="ī�G�z�ƹq��:0809-012-555";
		JOptionPane.showMessageDialog(null, phonenum );
	}
}
