package model.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class WindowElShohra  extends JFrame implements ActionListener {
	private JPanel l;
	//BufferedImage img;
	private static Timer time;
	//5aleeh constructor fl a5er badal main method
	public WindowElShohra(){
		Timer time = new Timer(13500, this);
		time.start();
		time.addActionListener(this);
		time.setActionCommand("Timer");
		setSize(1200,860);
		setTitle("Super Hero Chess");
		setUndecorated(true);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton a = new JButton();
		add(a);
		a.setIcon(new ImageIcon("src/shohra.png"));

		//l.loadImage("/images/img.JPG");
		//myWindow.setIconImage(arg0);
		//myWindow.imageUpdate(arg0, arg1, arg2, arg3, arg4, arg5);
		setVisible(true);
		File voice = new File ("src/soundwelcome.wav");
		Sound(voice);
		//myWindow.setLayout(new BorderLayout());
		//myWindow.setContentPane(new JLabel(new ImageIcon(hj)));

	}
	public static void main(String[] args){
		WindowElShohra x=new WindowElShohra();
	}
	
	public static void Sound(File x){
		try {
			Clip y=AudioSystem.getClip();
			y.open(AudioSystem.getAudioInputStream(x));
			y.start();
			
		} catch (Exception e) {
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand()=="Timer"){
			setVisible(false);
			//new Window1();
			//time.stop();
		}
	}
	

}






