package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class Swing extends JFrame {
	private boolean cb0_state=false,cb1_state=false,cb2_state=false,cb3_state=false,cb4_state=false;
 	private int custom_time=5;
	private int custom_db=70;
 	public int PanelFlag = 2;//吸音板旗標:自動判斷=0 強制開啟=1 強制關閉=2
 	JLabel dbData;
 	JTextArea textarea = new JTextArea("主系統啟動中...");
 	
	public Swing(){
		super("<超稀有+99不可突破> 反惱人鄰居系統"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,500);
		/*****************宣告元件********************/
		JCheckBox cb0 = new JCheckBox("啟動監控系統"),
				  cb1 = new JCheckBox("自動開關吸音板"),
				  cb2 = new JCheckBox("自動檢舉"),
				  cb3 = new JCheckBox("音量反擊"),
				  cb4 = new JCheckBox("靠北社群反擊");
		
		JButton setting = new JButton("設定");
		JButton panel_ON = new JButton("吸音板啟動");
		JButton panel_OFF = new JButton("吸音板關閉");
		
		JLabel lb1 = new JLabel("功能列表");
		JLabel lb2 = new JLabel("狀態監視窗");
		/*****************宣告元件********************/
		/*****************監聽器********************/
		ItemListener cblistener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox cbSourse = (JCheckBox)e.getSource();
				String target = cbSourse.getActionCommand();
				if(e.getStateChange( )== ItemEvent.SELECTED)
					switch(target) {
					case "啟動監控系統":
						cb0_state = true;
						break;
					case "自動開關吸音板":
						cb1_state = true;
						PanelFlag = 0;
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
					case "啟動監控系統":
						cb0_state = false;
						break;
					case "自動開關吸音板":
						cb1_state = false;
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
		cb0.addItemListener(cblistener);
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
					timeSet(time);
					String db = JOptionPane.showInputDialog("請輸入音量上限 單位:db");
					dbSet(db);
					break;
				case "吸音板啟動":
					cb1.setSelected(false);
					PanelFlag = 1;
					break;
				case "吸音板關閉":
					cb1.setSelected(false);
					PanelFlag = 2;
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
		cp.setLayout(null);
		
		lb1.setBounds(10, 10, 200, 30);
		lb2.setBounds(400,10,200,30);
		lb1.setFont(new Font("Time New Roman",Font.BOLD,30));
		lb2.setFont(new Font("Time New Roman",Font.BOLD,30));
		
		cb0.setBounds(10, 50, 200,20);
		cb1.setBounds(10, 80, 200,20);
		cb2.setBounds(10, 110, 200,20);
		cb3.setBounds(10, 140, 200,20);
		cb4.setBounds(10, 170, 200,20);
		cb0.setFont(new Font("Time New Roman",Font.PLAIN,20));
		cb1.setFont(new Font("Time New Roman",Font.PLAIN,20));
		cb2.setFont(new Font("Time New Roman",Font.PLAIN,20));
		cb3.setFont(new Font("Time New Roman",Font.PLAIN,20));
		cb4.setFont(new Font("Time New Roman",Font.PLAIN,20));
		
		textarea.setBounds(380, 50, 210, 250);
		textarea.setFont(new Font("Time New Roman",Font.PLAIN,18));
		
		setting.setBounds(10, 280, 150, 30);
		panel_ON.setBounds(10, 200, 150, 30);
		panel_OFF.setBounds(10, 230, 150, 30);
		setting.setFont(new Font("Time New Roman",Font.PLAIN,18));
		panel_ON.setFont(new Font("Time New Roman",Font.PLAIN,18));
		panel_OFF.setFont(new Font("Time New Roman",Font.PLAIN,18));
		
		cp.add(lb1);
		cp.add(lb2);
		cp.add(cb0);
		cp.add(cb1);
		cp.add(cb2);
		cp.add(cb3);
		cp.add(cb4);
		cp.add(textarea);
		cp.add(setting);
		cp.add(panel_ON);
		cp.add(panel_OFF);
		
		/*****************Layout設定********************/
		setVisible(true);
	}
	public boolean getcb0() {
		return cb0_state;
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
	public void showStatus(String s) {
		textarea.setText(s);
	}
	public void timeSet(String s) {
		try {
		int time = Integer.parseInt(s);
		if(time<=0 || time>10)
			System.out.println("請輸入1~10");
		else
			custom_time = time;
		}catch(NumberFormatException e) {
			System.out.println("輸入失敗");
		}
	}
	public void dbSet(String s) {
		try {
			int db = Integer.parseInt(s);
			if(db<=0)
				System.out.println("請輸入正整數");
			else
				custom_db = db;
			}catch(NumberFormatException e) {
				System.out.println("輸入失敗");
			}
	}
}