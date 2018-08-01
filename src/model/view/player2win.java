package model.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.game.Game;
import model.game.Player;

public class player2win extends JFrame implements ActionListener {
	public static void main(String [] args){
		Player y = new Player("Omar");
		Player z = new Player("Ahmed");

		Game game = new Game(y,z);
		player2win x = new player2win(game);
		x.setVisible(true);
	}
	public player2win(Game game){
		setTitle(game.getPlayer2().getName()+" "+"Wins");
		setSize(1100, 528);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton all=new JButton();
		JPanel ngame = new JPanel();
		ngame.setLayout(new FlowLayout());
		JButton newgame = new JButton();
		newgame.setIcon(new ImageIcon("src/newgame6.png"));
		newgame.addActionListener( this);
		newgame.setActionCommand("newgame");
		ngame.add(newgame);
		add(all,BorderLayout.CENTER);
		add(ngame,BorderLayout.SOUTH);
		all.setIcon(new ImageIcon("src/player2wins.png"));	
		setVisible(true);
		File voice = new File ("src/soundyouwin.wav");
		Sound(voice);
	}
	public static void Sound(File x){
		try {
			Clip y=AudioSystem.getClip();
			y.open(AudioSystem.getAudioInputStream(x));
			y.start();
			
		} catch (Exception e) {
		}
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="newgame"){		
			setVisible(false);
			Window1 m=new Window1();
			m.setVisible(true);
		}
		
	}
	}
