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

public class usepower2 extends JFrame implements ActionListener {
	public static void main (String [] args){
		Player player1 = new Player(" ");
		Player player2 = new Player(" ");

		Game game = new Game(player1, player2);
		Tech a=new Tech(player1, game, "");
		new usepower2(a);
	}
	public usepower2(Piece p){
		Timer time = new Timer(3000, this);
		time.start();
		time.addActionListener(this);
		time.setActionCommand("Timer");
		setTitle("Super Hero Chess");
		setUndecorated(true);
		JButton a = new JButton();
		setSize(500,360);
		if(p instanceof Medic){
			setSize(230,170);
			a.setIcon(new ImageIcon("src/bugs3.gif"));
			File voice = new File ("src/soundbugspower.wav");
			Sound(voice);
		}
		if(p instanceof Ranged){
			setSize(500,330);
			a.setIcon(new ImageIcon("src/sam3.gif"));
			File voice = new File ("src/soundsampower.wav");
			Sound(voice);
		}
		if(p instanceof Super){
			setSize(400,350);
			a.setIcon(new ImageIcon("src/taz3.gif"));
			File voice = new File ("src/soundtazpower.wav");
			Sound(voice);
		}
		if(p instanceof Tech){
			setSize(500,250);
			a.setIcon(new ImageIcon("src/aladdin3.gif"));
			File voice = new File ("src/soundaladdinpower.wav");
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
