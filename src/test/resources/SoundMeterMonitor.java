
public class SoundMeterMonitor{
	
	private boolean power = false;
	private boolean soundMeterActive = true;
	private int[] dataQueue = new int[10];
	private int key = -1;
	SoundMeter soundMeter = new SoundMeter();
	
	public SoundMeterMonitor() {
		
		for(int i=0; i<dataQueue.length; i++) {
			dataQueue[i] = -1;
		}
		new MonitorThread().start();
	}
	
	private void putData(int data) {
		
		if(key+1 >= dataQueue.length) {
			dataQueue[0] = data;
			key = 0;
		}else {
			dataQueue[key+1] = data;
			key++;
		}
	}
	
	private class MonitorThread extends Thread{
		
		public void run() {
			
			while(true) {
				if(power&&soundMeterActive) {
					try {
						sleep(1000);
						putData(soundMeter.getData());
					}catch (InterruptedException e) {
						e.printStackTrace();
						soundMeterActive = false;
					}
				}else {
					try {
						sleep(1000);
						putData(0);
						soundMeterActive = true;
					}catch (InterruptedException e) {
						e.printStackTrace();
						soundMeterActive = false;
					}
				}
				queueTest();
			}
		}
	}
	
	public void startMonitor() {
		power = true;
	}
	
	public void closeMonitor() {
		power = false;
	}
	
	public boolean soundMeterIsActive() {
		return soundMeterActive;
	}
	
	public int[] getDataQueue() {
		return dataQueue;
	}
	
	public int getKey() {
		return key;
	}
	
	public int getData() {
		return dataQueue[key];
	}
	
	private void queueTest() {
		System.out.printf("Key= %d, Queue= ",key);
		for(int i=0; i<dataQueue.length; i++) {
			System.out.printf("%2d ", dataQueue[i]);
		}
		System.out.println();
	}

}
