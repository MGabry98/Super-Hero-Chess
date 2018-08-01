package model.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKick;
import model.pieces.sidekicks.SideKickP2;

public class movewindow1 extends JFrame implements ActionListener {
	public static void main (String [] args){
		Player player1 = new Player(" ");
		Player player2 = new Player(" ");

		Game game = new Game(player1, player2);
		Speedster a=new Speedster(player2, game, "");
		new movewindow1(a);
	}
	public movewindow1(Piece p){
		Timer time = new Timer(2000, this);
		time.start();
		time.addActionListener(this);
		time.setActionCommand("Timer");
		setTitle("Super Hero Chess");
		setUndecorated(true);
		JButton a = new JButton();
		setSize(500,360);
		if(p instanceof Armored){
			setSize(500,360);
			a.setIcon(new ImageIcon("src/gokugif.gif"));
			File voice = new File ("src/soundgoku.wav");
			Sound(voice);
		}
		if(p instanceof Medic){
			setSize(500,350);
			a.setIcon(new ImageIcon("src/bugs2.gif"));
			File voice = new File ("src/soundbugs.wav");
			Sound(voice);
		}
		if(p instanceof Ranged){
			setSize(280,210);
			a.setIcon(new ImageIcon("src/sam2.gif"));
			File voice = new File ("src/soundsam.wav");
			Sound(voice);
		}
		if(p instanceof Speedster){
			setSize(400,300);
			a.setIcon(new ImageIcon("src/roadrunner2.gif"));
			File voice = new File ("src/soundroadrunner.wav");
			Sound(voice);
		}
		if(p instanceof Super){
			setSize(249,170);
			a.setIcon(new ImageIcon("src/taz2.gif"));
			File voice = new File ("src/soundtaz.wav");
			Sound(voice);
		}
		if(p instanceof Tech){
			setSize(430,300);
			a.setIcon(new ImageIcon("src/popeye2.gif"));
			File voice = new File ("src/soundpopeye.wav");
			Sound(voice);
		}
		if(p instanceof SideKick){
			setSize(500,370);
			a.setIcon(new ImageIcon("src/pikatchu2.gif"));
			File voice = new File ("src/soundpikatchu.wav");
			Sound(voice);
		}
		add(a);
		setLocationRelativeTo(null);
		setVisible(true);
		

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
		if (e.getActionCommand()=="Timer"){
			setVisible(false);
		}
		}
}
