package Function;
import Hardware.Recorder;
import Hardware.Stereo;

public class VoiceCounter {
	
	Recorder recorder = new Recorder();
	Stereo stereo = new Stereo();
	
	public void start_record() {
		recorder.start();
	}
	
	public void stop_record() {
		recorder.stop();
	}
	
	public void start_counter() {
		stereo.start();
	}
	
	public void stop_counter() {
		stereo.stop();
	}
	
	public String recorder_status() {
		return recorder.status;
	}
	
	public String stereo_status() {
		return stereo.status;
	}
	
}
