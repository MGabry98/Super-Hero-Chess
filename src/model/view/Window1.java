package model.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.image.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Window1 extends JFrame implements ActionListener{
	private JPanel p = new JPanel();
	private JTextField TF2 = new JTextField(20);
	private JTextField TF1 = new JTextField(20);
//Need to ask in GAME ROOM 
	// if names of players empty string .done
	// how progress bar works . google it
	// remain panel components size . put components and it will work 
	// How to press on multiple buttons to make the move. put them in an array and check the order.
	// how to add video . change to gif
	// How to make close after a certain period of time or after pressing on a specified button.
	public Window1(){
		super();
		//WindowDestroyer myListener = new WindowDestroyer();
	  //  addWindowListener(myListener);
		//p.setLayout(new BorderLayout());
		setTitle("Super Hero Chess");
		setSize(500, 130);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel enterName1 = new JLabel("Please enter Player 1 name :-");
		p.add(enterName1,BorderLayout.NORTH);
		
		p.add(TF1,BorderLayout.NORTH);
		JLabel enterName2 = new JLabel("Please enter Player 2 name :-");
		p.add(enterName2,BorderLayout.CENTER);
		
		p.add(TF2,BorderLayout.CENTER);
		JButton button = new JButton("Next");
		p.add(button,BorderLayout.SOUTH);
		button.addActionListener(this);
		button.setActionCommand("Next");
		add(p);
		setVisible(true);
	}
	// main method just to test.
	public static void main (String [] args){
		Window1 x=new Window1();
		x.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Next"){
			String x = TF1.getText();
			String y = TF2.getText();
		if(x.length()!=0&&y.length()!=0){
			setVisible(false);
			Window2 a = new Window2(x,y);
			a.setVisible(true);
			
		}
			else{
				JOptionPane.showMessageDialog(null,"Please enter the 2 players names","Super Hero Chess",JOptionPane.CANCEL_OPTION);
			}
		}		
	}
}
