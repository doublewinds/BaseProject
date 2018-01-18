package Function;
import Hardware.SoundMeter;
//音量監控系統
public class SoundMeterMonitor{
	//系統開關
	private boolean power = true;
	//分貝計連線狀態
	private boolean soundMeterActive = false;
	//資料紀錄陣列
	private int[] dataQueue = new int[600];
	//陣列鍵值
	private int key = dataQueue.length-1;
	//音波圖像
	private String soundWave = "▁▁▁▁▁▁▁▁▁▁▁▁";
	//分貝計模擬器
	SoundMeter soundMeter = new SoundMeter();
	
	//建構子
	public SoundMeterMonitor() {
		//初始化陣列內容為-1
		for(int i=0; i<dataQueue.length; i++) {
			dataQueue[i] = -1;
		}
		//建立物件的同時啟動執行緒
		new MonitorThread().start();
	}
	
	//監視執行緒
	private class MonitorThread extends Thread{
		//改寫run的內容
		public void run() {
			//保持不斷迴圈
			while(true) {
				if(power&&soundMeterActive) {
					try {
						//將接收到的資料儲存
						putData(soundMeter.getData());
						//執行緒休眠1秒
						sleep(1000);
					}catch (InterruptedException e) {
						e.printStackTrace();
						soundMeterActive = false;
					}
				}else {
					try {
						putData(0);
						soundMeterActive = true;
						sleep(1000);
					}catch (InterruptedException e) {
						e.printStackTrace();
						soundMeterActive = false;
					}
				}
			}
		}
	}
	
	//將接收到的資料儲存
	private void putData(int data) {
		//將資料存進陣列
		if(key+1 >= dataQueue.length) {
			dataQueue[0] = data;
			key = 0;
		}else {
			dataQueue[key+1] = data;
			key++;
		}
		//將資料存成音波圖像
		convertToWave(data);
	}
		
	//將資料存成音波圖像
	private void convertToWave(int data) {
		String wave;
		//音量圖像分級
		if(data/10 < 3) {
			wave = "▁";
		}else if(data/10 < 4) {
			wave = "▂";
		}else if(data/10 < 5) {
			wave = "▃";
		}else if(data/10 < 6) {
			wave = "▅";
		}else if(data/10 < 7) {
			wave = "▆";
		}else if(data/10 < 8) {
			wave = "▇";
		}else {
			wave = "▉";
		}
		//將舊有資料往前移並加入新資料
		soundWave = soundWave.substring(1) + wave;
	}
		
	//啟動監視系統
	public void startMonitor() {
		power = true;
	}
	
	//關閉監視系統
	public void closeMonitor() {
		power = false;
	}
	
	//確認分貝計連線
	public boolean soundMeterIsActive() {
		return soundMeterActive;
	}
	
	//取得資料陣列
	public int[] getDataQueue() {
		return dataQueue;
	}
	
	//取得陣列鍵值
	public int getKey() {
		return key;
	}
	
	//取得當下的音量
	public int getData() {
		return dataQueue[key];
	}
	
	//取得音波圖像
	public String getSoundWave() {
		return soundWave;
	}

}
