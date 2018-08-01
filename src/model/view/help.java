package model.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class help extends JFrame implements ActionListener{

	
	public static void main(String [] args){
		help x= new help();
	}
	public help(){
		setSize(650,925);
		setTitle("Game Rules");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		JButton mid = new JButton();
		add(mid,BorderLayout.CENTER);
		JPanel last=new JPanel();
		JButton ok = new JButton("OK");
		ok.addActionListener(this);
		ok.setActionCommand("ok");
		last.add(ok);
		JButton more = new JButton("More Info");
		more.addActionListener(this);
		more.setActionCommand("more");
		last.add(more);
		last.setPreferredSize(new Dimension(650,60));
		add(last,BorderLayout.SOUTH);
		mid.setIcon(new ImageIcon("src/ins.png"));
		//JTextField z = new JTextField("dvgfsg");
		//add(z,BorderLayout.EAST);
		
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="ok")
			setVisible(false);
		if(e.getActionCommand()=="more")
			JOptionPane.showMessageDialog(null,"Game Instructions :-"+'\n'+"To move :-"+'\n'+"Select the piece you want to move then direction then press move."+'\n'+'\n'+"To USE POWER :-"+'\n'+"Ranged&Super :- press on Ranged then the direction you want(Up,Down,Right,Left) then press on use power button."+'\n'+"Medic:- press on medic then choose the direction then  choose the Hero you want to revive from the dead characters list then press on the use power button. "+'\n'+"Tech :- to hack press on tech then the hero you want to hack then press use power button."+'\n'+"To restore Power press on tech then the hero then press the use power button."+'\n'+"To teleport press on tech then the piece you want to teleport then the empty cell then press use power","Super Hero Chess",JOptionPane.CANCEL_OPTION);

	}

}
