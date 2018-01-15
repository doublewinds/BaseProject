import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

public class Swing extends JFrame {
	private boolean cb1_state=false,cb2_state=false,cb3_state=false,cb4_state=false;
 	private int custom_time=5,custom_db=70;
 	JLabel dbData;
	Swing(AcousticPanel AP){
		super("System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,200);
		/*****************宣告元件********************/
		JCheckBox cb1 = new JCheckBox("自動開關吸音板"),
				  cb2 = new JCheckBox("自動檢舉"),
				  cb3 = new JCheckBox("音量反擊"),
				  cb4 = new JCheckBox("靠北社群反擊");
		
		JButton setting = new JButton("設定");
		JButton panel_ON = new JButton("吸音板啟動");
		JButton panel_OFF = new JButton("吸音板關閉");
		
		JLabel dbTitle = new JLabel("現在分貝：",JLabel.RIGHT);
		dbTitle.setFont(new Font("",Font.BOLD,30));
		JLabel dbData = new JLabel("0",JLabel.CENTER);
		dbData.setFont(new Font("",Font.PLAIN,30));
		/*****************宣告元件********************/
		/*****************監聽器********************/
		ItemListener cblistener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox cbSourse = (JCheckBox)e.getSource();
				String target = cbSourse.getActionCommand();
				if(e.getStateChange( )== ItemEvent.SELECTED)
					switch(target) {
					case "自動開關吸音板":
						cb1_state = true;
						AP.execute();
						break;
					case "自動檢舉":
						cb2_state = true;
						break;
					case "音量反擊":
						cb3_state = true;
						break;
					case "靠北社群反擊":
						cb4_state = true;
						break;
					}
				else if(e.getStateChange() == ItemEvent.DESELECTED)
					switch(target) {
					case "自動開關吸音板":
						cb1_state = false;
						AP.terminate();
						break;
					case "自動檢舉":
						cb2_state = false;
						break;
					case "音量反擊":
						cb3_state = false;
						break;
					case "靠北社群反擊":
						cb4_state = false;
						break;
					}
			}
		};
		cb1.addItemListener(cblistener);
		cb2.addItemListener(cblistener);
		cb3.addItemListener(cblistener);
		cb4.addItemListener(cblistener);
		
		ActionListener buttonlistener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton btnSourse = (JButton)e.getSource();
				String target = btnSourse.getActionCommand();
				switch(target) {
				case "設定":
					String time = JOptionPane.showInputDialog("請輸入取樣週期 單位:分鐘");
					custom_time = Integer.parseInt(time);
					String db = JOptionPane.showInputDialog("請輸入音量上限 單位:db");
					custom_db = Integer.parseInt(db);
					break;
				case "吸音板啟動":
					cb1.setSelected(false);
					JOptionPane.showMessageDialog(null,"吸音板已啟動，請耐心等候");
					break;
				case "吸音板關閉":
					cb1.setSelected(false);
					JOptionPane.showMessageDialog(null,"吸音板已關閉，請耐心等候");
					break;
				}
			}	
		};
		setting.addActionListener(buttonlistener);
		panel_ON.addActionListener(buttonlistener);
		panel_OFF.addActionListener(buttonlistener);
		/*****************監聽器********************/
		/*****************Layout設定********************/
		Container cp = getContentPane();
		Box box_cb = new Box(BoxLayout.X_AXIS);
		box_cb.add(cb1);
		box_cb.add(Box.createHorizontalGlue());
		box_cb.add(cb2);
		box_cb.add(Box.createHorizontalGlue());
		box_cb.add(cb3);
		box_cb.add(Box.createHorizontalGlue());
		box_cb.add(cb4);
		cp.setLayout(new GridLayout(4,1,10,10));
		cp.add(box_cb);
		
		Box box_btnpanel = new Box(BoxLayout.X_AXIS);
		box_btnpanel.add(panel_ON);
		box_btnpanel.add(panel_OFF);
		cp.add(box_btnpanel);
		
		Box box_db = new Box(BoxLayout.X_AXIS);
		box_db.add(dbTitle);
		box_db.add(dbData);
		cp.add(box_db);
		
		cp.add(setting);
		/*****************Layout設定********************/
		setVisible(true);
	}
	public boolean getcb1() {
		return cb1_state;
	}
	public boolean getcb2() {
		return cb2_state;
	}
	public boolean getcb3() {
		return cb3_state;
	}
	public boolean getcb4() {
		return cb4_state;
	}
	public int getcustom_time() {
		return custom_time;
	}
	public int getcustom_db() {
		return custom_db;
	}
	public void changedbData(String s) {
		dbData.setText(s);
	}
}
