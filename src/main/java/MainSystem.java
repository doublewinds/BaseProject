import Function.*;
import GUI.Swing;
import Hardware.AcousticPanel;

public class MainSystem {
	//GUI及各項功能
	static Swing frame;
	static SoundMeterMonitor smm;
	static AcousticPanel ap;
	static Reporter rp;
	static VoiceCounter vc;
	static Community com;
	//各功能流程計數器
	static int rpPC = 0;
	static int vcPC = 0;
	static int comPC = 0;
	//超標判斷暫存
	static boolean judge= false;
	//系統狀態
	static String status = "主系統啟動中...";
	//主程式進入點
	public static void main(String[] args) {
		frame = new Swing();
		smm = new SoundMeterMonitor();
		ap = new AcousticPanel();
		rp = new Reporter();
		vc = new VoiceCounter();
		com = new Community();
		MainThread MT = new MainThread();
		MT.start();
	}
	//主執行緒
	public static class MainThread extends Thread {
		public void run() {
			while(true) {
				try {
					//暫存本次判斷結果避免重複呼叫
					judge = customJudge();
					//音量監控系統的控制
					if(frame.getcb0()) {
						smm.startMonitor();
					}else {
						smm.closeMonitor();
					}
					//吸音板開關的控制
					if(frame.getcb1()) {
						if(ap.Panel_islink()) {
							if(judge) {
								ap.Panel_ON();
							}else {
								ap.Panel_OFF();
							}
						}
					}else if(ap.Panel_islink()){
						if(frame.PanelFlag == 1) {
							ap.Panel_ON();
						}else if(frame.PanelFlag == 2) {
							ap.Panel_OFF();
						}
					}
					//自動檢舉的控制
					if(frame.getcb2()) {
						if(rpPC == 0) {
							rpPC = 2;
						}
						if(rpPC == 1) {
							rp.rulejudge(smm.getData());
						}
					}else {
						rpPC = 0;
						rp.reset();
					}
					//音量反擊的控制
					if(frame.getcb3()) {
						if(vcPC == 0 && judge) {
							vcPC = 20;
							vc.start_record();
						}else if(vcPC == 12) {
							vc.stop_record();
							vc.start_counter();
						}else if(vcPC == 4){
							vc.stop_counter();
						}
					}else {
						vcPC = 0;
						vc.stop_record();
						vc.stop_counter();
					}
					//靠北社群的控制
					if(frame.getcb4()) {
						if(com.camera_islink()) {
							if(comPC == 0 && judge) {
								comPC = 20;
								com.film_start();
								com.show_community();
							}else if(comPC == 10) {
								com.film_stop();
							}
						}else {
							comPC = 0;
							com.film_stop();
						}
					}else {
						comPC = 0;
						com.film_stop();
					}
					//刷新狀態
					refreshStatus(judge);
					//刷新狀態監控
					frame.showStatus(status);
					//流程計數器倒數
					allPCDown();
					//執行緒休眠0.5秒
					sleep(500);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//刷新狀態
	public static void refreshStatus(boolean j) {
		status = "吸音板狀態: " + ap.Panel_status() + 
				"\n錄音機狀態: " + vc.recorder_status() + 
				"\n雙音響狀態: " + vc.stereo_status() + 
				"\n錄影機狀態: " + com.camera_status() + 
				"\n" + smm.getSoundWave() + 
				"\n現在音量: " + smm.getData() +
				" db\n\n設定取樣週期: " + frame.getcustom_time() + 
				" min\n設定音量上限: " + frame.getcustom_db() + 
				" db\n目前是否超標: " + j;
	}
	
	//判斷是否超標
	public static boolean customJudge() {
		int time = frame.getcustom_time()*60;
		int decibel = frame.getcustom_db();
		int exceeded = 0;
		int data[] = smm.getDataQueue();
		int key = smm.getKey();
		for(int i=0;i<time;i++) {
			if(data[key]>=decibel)
				exceeded++;
			if(key==0)	
				key = data.length;
			key--;
		}
		if(exceeded>=time/2)
			return true;
		else
			return false;
	}
	
	//流程計數器倒數
	public static void allPCDown() {
		if(vcPC>0) {
			vcPC--;
		}
		if(comPC>0) {
			comPC--;
		}
		if(rpPC>0) {
			rpPC--;
		}
	}
	
}
	
	
