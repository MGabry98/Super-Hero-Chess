package model.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
import model.pieces.sidekicks.SideKickP1;

public class movewindow extends JFrame implements ActionListener {
	public static void main (String [] args){
		Player player1 = new Player(" ");
		Player player2 = new Player(" ");

		Game game = new Game(player1, player2);
		Tech a=new Tech( player1,game, "");
		new movewindow(a);
	}
	public movewindow(Piece p){
		Timer time = new Timer(2000, this);
		time.start();
		time.addActionListener(this);
		time.setActionCommand("Timer");
		setTitle("Super Hero Chess");
		setUndecorated(true);
		JButton a = new JButton();
		setSize(500,360);
		if(p instanceof Armored){
			setSize(500,280);
			a.setIcon(new ImageIcon("src/buzz1.gif"));
			File voice = new File ("src/soundbuzz.wav");
			Sound(voice);
		}
		if(p instanceof Medic){
			setSize(500,280);
			a.setIcon(new ImageIcon("src/genie4.gif"));
			File voice = new File ("src/soundgenie.wav");
			Sound(voice);
		}
		if(p instanceof Ranged){
			setSize(500,280);
			a.setIcon(new ImageIcon("src/hercules2.gif"));
			File voice = new File ("src/soundhercules.wav");
			Sound(voice);
		}
		if(p instanceof Speedster){
			setSize(249,145);
			a.setIcon(new ImageIcon("src/san2.gif"));
			File voice = new File ("src/sounddash.wav");
			Sound(voice);
		}
		if(p instanceof Super){
			setSize(249,170);
			a.setIcon(new ImageIcon("src/incredible2.gif"));
			File voice = new File ("src/soundincredible.wav");
			Sound(voice);
		}
		if(p instanceof Tech){
			setSize(500,250);
			a.setIcon(new ImageIcon("src/aladdin2.gif"));
			File voice = new File ("src/soundaladdin.wav");
			Sound(voice);
		}
		if(p instanceof SideKick){
			setSize(248,145);
			a.setIcon(new ImageIcon("src/minion2.gif"));
			File voice = new File ("src/soundminion.wav");
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
