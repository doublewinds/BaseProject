
public class MainSystem {
	static Swing frame;
	public static void main(String[] args) {
		AcousticPanel AP = new AcousticPanel();
		frame = new Swing(AP);
		}
	public static boolean customJudge() {
		int time = frame.getcustom_time()*60;   //§â per60s ´«¦¨ per1s
		int decibel = frame.getcustom_db();
		int exceeded = 0;
		SoundMeterMonitor sm = new SoundMeterMonitor();
		int data[] = sm.getDataQueue();
		int key = sm.getKey();
		for(int i=0;i<time;i++) {
			if(data[key]>=decibel)
				exceeded++;
			if(key==0)	
				key = 599;
			key--;
		}
		if(exceeded>=time/2)
			return true;
		else
			return false;
	}
}
	
	
