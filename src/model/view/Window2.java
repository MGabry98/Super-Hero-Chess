package model.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Transparency;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.layout.TilePane;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import exceptions.InvalidPowerUseException;
import exceptions.OccupiedCellException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKick;
import model.pieces.sidekicks.SideKickP1;
import model.pieces.sidekicks.SideKickP2;

public class Window2 extends JFrame  implements ActionListener{
	private Object[] presses=new Object[4];
	private Object[] moveA = new Object[2];
	private static JLabel cpnamel;
	private static JTextArea info=new JTextArea();
	private int f=0;
	private static JComboBox l = new JComboBox();
	private static JProgressBar pb1 = new JProgressBar(SwingConstants.VERTICAL,0,6);
	private static JProgressBar pb2 = new JProgressBar(SwingConstants.VERTICAL,0,6);
	private static Point newPos=null;
	private static Game game;
	private JPanel board = new JPanel();
	private JPanel remain = new JPanel();
	private static JButton[][] boardButtons=new JButton[7][6];
	private static JButton sorto = new JButton();
	public static void main(String [] args){
		Window2 x = new Window2("omar","ahmed");
		x.setVisible(true);
	}
	public Window2(String x,String y){
		super();
		Player p1 = new Player(x);
		Player p2 = new Player(y);
		game = new Game(p1,p2);
		
		setSize(1300, 1000);
		setLocationRelativeTo(null);
		setTitle("Super Hero Chess");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setUndecorated(true);
		board.setSize(800, 1000);
		board.setLayout(new GridLayout(7,6));
		for(int i=0 ; i<7;i++){
			for (int j=0;j<6;j++){
				boardButtons[i][j]=new JButton ();
				//temp[i].setBackground(new Color(0,0,0,0));
				board.add(boardButtons[i][j]);
				boardButtons[i][j].addActionListener(this);
				boardButtons[i][j].setActionCommand(""+i+j);
		}
		}
		
		
		
		JPanel temp1 = new JPanel ();
		JPanel temp2 = new JPanel ();
		JPanel temp3 = new JPanel ();
		
		JButton [] directions1=new JButton[3];
		JButton [] directions2=new JButton[2];
		JButton [] directions3=new JButton[3];


		
		temp1.setLayout(new FlowLayout());
		temp2.setLayout(new FlowLayout());
		temp3.setLayout(new FlowLayout());
		for(int i=0;i<2;i++ ){
			directions2[i]=new JButton();
			temp3.add(directions2[i] );
			}
		directions2[0].setIcon(new ImageIcon("src/left.png"));
		directions2[0].addActionListener(this);
		directions2[0].setActionCommand("left");
		directions2[1].setIcon(new ImageIcon("src/right.png"));
		directions2[1].addActionListener(this);
		directions2[1].setActionCommand("right");
		
		for(int i=0 ;i<3;i++){
			directions1[i]=new JButton();
			directions3[i]=new JButton();
			temp1.add(directions1[i]);
			temp2.add(directions3[i]);
		}
		directions1[0].setIcon(new ImageIcon("src/upleft.png"));
		directions1[0].addActionListener(this);
		directions1[0].setActionCommand("upleft");
		directions1[1].setIcon(new ImageIcon("src/up.png"));
		directions1[1].addActionListener(this);
		directions1[1].setActionCommand("upp");
		directions1[2].setIcon(new ImageIcon("src/upright.png"));
		directions1[2].addActionListener(this);
		directions1[2].setActionCommand("upright");
		
		directions3[0].setIcon(new ImageIcon("src/downleft.png"));
		directions3[0].addActionListener(this);
		directions3[0].setActionCommand("downleft");
		directions3[1].setIcon(new ImageIcon("src/down.png"));
		directions3[1].addActionListener(this);
		directions3[1].setActionCommand("down");
		directions3[2].setIcon(new ImageIcon("src/downright.png"));
		directions3[2].addActionListener(this);
		directions3[2].setActionCommand("downright");
		
		JPanel temp4 = new JPanel ();
		temp4.setLayout(new BorderLayout());
		temp4.add(temp1, BorderLayout.NORTH);
		temp4.add(temp3, BorderLayout.CENTER);
		temp4.add(temp2, BorderLayout.SOUTH);
		
		JPanel t1 = new JPanel();
		t1.setLayout(new FlowLayout());
		JButton [] moveusepower= new JButton[2];
		for(int i=0;i<2;i++ ){
			moveusepower[i]=new JButton();
			t1.add(moveusepower[i]);
		}
		
		moveusepower[0].setIcon(new ImageIcon("src/move.jpg"));
		moveusepower[0].addActionListener(this);
		moveusepower[0].setActionCommand("move");
		moveusepower[1].setIcon(new ImageIcon("src/usepower.jpg"));
		moveusepower[1].addActionListener(this);
		moveusepower[1].setActionCommand("usepower");
		JPanel t2= new JPanel();
		t2.add(l);
		
		
		JPanel t3= new JPanel();
		t3.setLayout(new BorderLayout());
		t3.add(t1,BorderLayout.NORTH);
		t3.add(t2,BorderLayout.SOUTH);
		
		JButton newgame = new JButton();
		newgame.setPreferredSize(new Dimension(140,90));
		newgame.setIcon(new ImageIcon("src/newgame6.png"));
		
		JPanel lastaya = new JPanel();
		lastaya.setLayout(new BorderLayout());
		lastaya.setSize(200, 1000);
		JButton instructions = new JButton ("");
		instructions.setPreferredSize(new Dimension(120,45));
		instructions.addActionListener(this);
		instructions.setActionCommand("instructions");
		instructions.setIcon(new ImageIcon("src/help.jpg"));
		lastaya.add(instructions,BorderLayout.NORTH);
		
		JButton close=new JButton("EXIT");
		close.addActionListener(this);
		close.setActionCommand("close");
		lastaya.add(close,BorderLayout.SOUTH);
		sorto.addActionListener(this);
		sorto.setActionCommand("sorto");
		sorto.setPreferredSize(new Dimension(170,100));
		sorto.setVisible(false);
		//lastaya.add(sorto,BorderLayout.CENTER);
		newgame.addActionListener(this);
		newgame.setActionCommand("newgame");
		remain.add(lastaya);
		remain.add(newgame);
		
		remain.setPreferredSize(new Dimension(1000,150));
		remain.setLayout(new FlowLayout());
		String cpname = game.getCurrentPlayer().getName();
		cpnamel=new JLabel(cpname);
		cpnamel.setFont(new Font(null,20,40));
		cpnamel.setForeground(Color.WHITE);
		remain.add(temp4);
		remain.add(cpnamel);
		
		remain.add(t3);
		remain.add(sorto);

		remain.add(info);
		remain.setBackground(Color.GRAY);
		
		
		pb1.setForeground(Color.BLUE);
		pb2.setForeground(Color.ORANGE);
		//to make background transparent 
		//w.setBackground(new Color(0, 0, 0,0));
		//remain.setBackground(new ImageIcon(ImageIO.read(new File("C:\Users\Omar\Desktop\GameImages\background.jpg"))));
		pb1.setPreferredSize(new Dimension(50, 500));
		pb2.setPreferredSize(new Dimension(50, 500));
		add(pb1,BorderLayout.WEST);
		add(pb2,BorderLayout.EAST);
		add(board,BorderLayout.CENTER);
		add(remain,BorderLayout.SOUTH);
		boardBackground(game,this);
	}
	
	public static void boardBackground(Game game,JFrame finish){
		if(game.checkWinner()==true){
			finish.setVisible(false);}
		if(game.getCurrentPlayer()==game.getPlayer1())
			cpnamel.setForeground(Color.BLUE);
		if(game.getCurrentPlayer()==game.getPlayer2())
			cpnamel.setForeground(Color.ORANGE);
		for(int i=0 ; i<7;i++){
			for (int j=0;j<6;j++){
				if (game.getCellAt(i, j).getPiece()==null)
					boardButtons[i][j].setIcon(new ImageIcon("src/background.jpg"));
				else{
					if(game.getCellAt(i, j).getPiece() instanceof SideKickP1)
						boardButtons[i][j].setIcon(new ImageIcon("src/minion.png"));
					//player2
					if(game.getCellAt(i, j).getPiece() instanceof SideKickP2)
						boardButtons[i][j].setIcon(new ImageIcon("src/pikatchu.png"));
					if(game.getCellAt(i, j).getPiece() instanceof Armored){
						if(game.getCellAt(i, j).getPiece().getOwner()==game.getPlayer1()){
							if(((Armored) game.getCellAt(i, j).getPiece()).isArmorUp()==true)
								boardButtons[i][j].setIcon(new ImageIcon("src/buzzarmorup.jpg"));
							else 
								boardButtons[i][j].setIcon(new ImageIcon("src/buzzarmordown.png"));
						}
						//player2
						if(game.getCellAt(i, j).getPiece().getOwner()==game.getPlayer2()){
							if(((Armored) game.getCellAt(i, j).getPiece()).isArmorUp()==true)
								boardButtons[i][j].setIcon(new ImageIcon("src/gokuarmorup.png"));
							else 
								boardButtons[i][j].setIcon(new ImageIcon("src/gokuarmordown.png"));	
						}
						}
					if(game.getCellAt(i, j).getPiece() instanceof Medic){
						if(game.getCellAt(i, j).getPiece().getOwner()==game.getPlayer1())
							boardButtons[i][j].setIcon(new ImageIcon("src/genie.jpg"));
						//player2
						if(game.getCellAt(i, j).getPiece().getOwner()==game.getPlayer2())
							boardButtons[i][j].setIcon(new ImageIcon("src/bugs.png"));
					}
					if(game.getCellAt(i, j).getPiece() instanceof Speedster){
						if(game.getCellAt(i, j).getPiece().getOwner()==game.getPlayer1())
							boardButtons[i][j].setIcon(new ImageIcon("src/san.jpg"));
						//player2
						if(game.getCellAt(i, j).getPiece().getOwner()==game.getPlayer2())
							boardButtons[i][j].setIcon(new ImageIcon("src/roadrunner.png"));
					}
					if(game.getCellAt(i, j).getPiece() instanceof Super){
						if(game.getCellAt(i, j).getPiece().getOwner()==game.getPlayer1())
							boardButtons[i][j].setIcon(new ImageIcon("src/incredible.jpg"));
						//player2
						if(game.getCellAt(i, j).getPiece().getOwner()==game.getPlayer2())
							boardButtons[i][j].setIcon(new ImageIcon("src/taz.png"));
					}
					if(game.getCellAt(i, j).getPiece() instanceof Tech){
						if(game.getCellAt(i, j).getPiece().getOwner()==game.getPlayer1())
							boardButtons[i][j].setIcon(new ImageIcon("src/aladdin.png"));
						//player2
						if(game.getCellAt(i, j).getPiece().getOwner()==game.getPlayer2())
							boardButtons[i][j].setIcon(new ImageIcon("src/popeye.png"));
					}
					if(game.getCellAt(i, j).getPiece() instanceof Ranged){
						if(game.getCellAt(i, j).getPiece().getOwner()==game.getPlayer1())
							boardButtons[i][j].setIcon(new ImageIcon("src/hercules.png"));
						//player2
						if(game.getCellAt(i, j).getPiece().getOwner()==game.getPlayer2())
							boardButtons[i][j].setIcon(new ImageIcon("src/sam.png"));
					}
				}
			}
			}
		cpnamel.setText(game.getCurrentPlayer().getName());
		l.removeAllItems();
		for(int i=0;i<game.getCurrentPlayer().getDeadCharacters().size();i++ ){
			l.addItem(game.getCurrentPlayer().getDeadCharacters().get(i).getName());
		}
		pb1.setValue(game.getPlayer1().getPayloadPos());
		pb2.setValue(game.getPlayer2().getPayloadPos());
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(game.checkWinner())
			System.exit(0);
		if(f==presses.length){
			f=0;
			for(int z=0;z<presses.length;z++){
				presses[z]=null;
			}
		}
		if(e.getActionCommand()=="close")
			System.exit(0);
		if(e.getActionCommand()=="newgame"){		
			setVisible(false);
			Window2 m=new Window2(game.getPlayer1().getName(),game.getPlayer2().getName());
			m.setVisible(true);
		}
		
		if(e.getActionCommand()=="move"){
			info.setText("");
			sorto.setVisible(false);
			//if(f==2){
				if((moveA[0] instanceof Piece&&moveA[1] instanceof Direction)){
					try {
						((Piece) moveA[0]).move((Direction) moveA[1]);
						if(game.getCurrentPlayer()==game.getPlayer1())
							new movewindow1((Piece) moveA[0]);
						else if(game.getCurrentPlayer()==game.getPlayer2())
							new movewindow((Piece)moveA[0]);
					}
					catch ( WrongTurnException e1) {
						f=0;
						JOptionPane.showMessageDialog(null,"This is not your turn","Super Hero Chess",JOptionPane.CANCEL_OPTION);
					}
					catch(UnallowedMovementException e1){
						f=0;
						JOptionPane.showMessageDialog(null,"You can not move in this direction","Super Hero Chess",JOptionPane.CANCEL_OPTION);

					}
					catch(OccupiedCellException e1){
						f=0;
						JOptionPane.showMessageDialog(null,"You are trying to move to a friendly piece cell","Super Hero Chess",JOptionPane.CANCEL_OPTION);
					}
					 
						
						
						moveA[0]=null;
						moveA[1]=null;
						f=0;
						for(int z=0;z<presses.length;z++){
							presses[z]=null;
						}
						boardBackground(game,this);
						if(game.getPlayer1().getPayloadPos()==6||game.getPlayer2().getPayloadPos()==6){
							setVisible(false);}
				}
				/*if((presses[1] instanceof Piece&&presses[0] instanceof Direction)){
					try {
						((Piece) presses[1]).move((Direction) presses[0]);
						if(game.getCurrentPlayer()==game.getPlayer1())
							new movewindow1((Piece) presses[1]);
						else if(game.getCurrentPlayer()==game.getPlayer2())
							new movewindow((Piece)presses[1]);
					}
					catch ( WrongTurnException e1) {
						f=0;
						for(int z=0;z<presses.length;z++){
							presses[z]=null;
						}
						JOptionPane.showMessageDialog(null,"This is not your turn","Super Hero Chess",JOptionPane.CANCEL_OPTION);
					}
					catch(UnallowedMovementException e1){
						f=0;
						for(int z=0;z<presses.length;z++){
							presses[z]=null;
						}
						JOptionPane.showMessageDialog(null,"You can not move in this direction","Super Hero Chess",JOptionPane.CANCEL_OPTION);

					}
					catch(OccupiedCellException e1){
						f=0;
						for(int z=0;z<presses.length;z++){
							presses[z]=null;
						}
						JOptionPane.showMessageDialog(null,"You are trying to move to a friendly piece cell","Super Hero Chess",JOptionPane.CANCEL_OPTION);
					}
					
					
					f=0;
					for(int z=0;z<presses.length;z++){
						presses[z]=null;
					}
					boardBackground(game,this);
				}*/
			//}
			else
				JOptionPane.showMessageDialog(null,"To move select a hero then a direction then press move","Super Hero Chess",JOptionPane.CANCEL_OPTION);

		}
		if(e.getActionCommand()=="left"){
			moveA[1]=Direction.LEFT;
			presses[f]=(Direction.LEFT);
			f++;
		}	
		if(e.getActionCommand()=="right"){
			moveA[1]=Direction.RIGHT;
			presses[f]=(Direction.RIGHT);
			f++;
		}
		if(e.getActionCommand()=="down"){
			moveA[1]=Direction.DOWN;
			presses[f]=(Direction.DOWN);
			f++;
		}
		if(e.getActionCommand()=="upp"){
			moveA[1]=Direction.UP;
			presses[f]=(Direction.UP);
			f++;
		}
		if(e.getActionCommand()=="upleft"){
			moveA[1]=Direction.UPLEFT;
			presses[f]=(Direction.UPLEFT);
			f++;
		}
		if(e.getActionCommand()=="upright"){
			moveA[1]=Direction.UPRIGHT;
			presses[f]=(Direction.UPRIGHT);
			f++;
		}
		if(e.getActionCommand()=="downright"){
			moveA[1]=Direction.DOWNRIGHT;
			presses[f]=(Direction.DOWNRIGHT);
			f++;
		}
		if(e.getActionCommand()=="downleft"){
			moveA[1]=Direction.DOWNLEFT;
			presses[f]=(Direction.DOWNLEFT);
			f++;
		}
		else if(e.getActionCommand().length()==2){
			if (game.checkWinner()){
				System.exit(0);
			}
			String x = e.getActionCommand();
			int y = Integer.parseInt(x);
			int j = y%10;
			int i =y/10 ;
			if(game.getCellAt(i, j).getPiece() instanceof SideKick){
				info.setText("Name: "+game.getCellAt(i, j).getPiece().getName()+'\n'+"Type: "+game.getCellAt(i, j).getPiece().getClass().getSimpleName()+'\n'+"Owner: "+game.getCellAt(i, j).getPiece().getOwner().getName());
			}
				else if(game.getCellAt(i, j).getPiece() instanceof Speedster)
				info.setText("Name: "+game.getCellAt(i, j).getPiece().getName()+'\n'+"Type: "+game.getCellAt(i, j).getPiece().getClass().getSimpleName()+'\n'+"Owner: "+game.getCellAt(i, j).getPiece().getOwner().getName());
			else if(game.getCellAt(i, j).getPiece() instanceof Armored){
				if(((Armored) game.getCellAt(i, j).getPiece()).isArmorUp()==false)
					info.setText("Name: "+game.getCellAt(i, j).getPiece().getName()+'\n'+"Type: "+game.getCellAt(i, j).getPiece().getClass().getSimpleName()+'\n'+"Owner: "+game.getCellAt(i, j).getPiece().getOwner().getName()+'\n'+"Armor is Down");
				if(((Armored) game.getCellAt(i, j).getPiece()).isArmorUp()==true)
					info.setText("Name: "+game.getCellAt(i, j).getPiece().getName()+'\n'+"Type: "+game.getCellAt(i, j).getPiece().getClass().getSimpleName()+'\n'+"Owner: "+game.getCellAt(i, j).getPiece().getOwner().getName()+'\n'+"Armor is Up");

			
			}
				else if(game.getCellAt(i, j).getPiece() instanceof ActivatablePowerHero){
				if(((ActivatablePowerHero) game.getCellAt(i, j).getPiece()).isPowerUsed()==false)
				info.setText("Name: "+game.getCellAt(i, j).getPiece().getName()+'\n'+"Type: "+game.getCellAt(i, j).getPiece().getClass().getSimpleName()+'\n'+"Owner: "+game.getCellAt(i, j).getPiece().getOwner().getName()+'\n'+"Power Available: Yes");
				if(((ActivatablePowerHero) game.getCellAt(i, j).getPiece()).isPowerUsed()==true)
					info.setText("Name: "+game.getCellAt(i, j).getPiece().getName()+'\n'+"Type: "+game.getCellAt(i, j).getPiece().getClass().getSimpleName()+'\n'+"Owner: "+game.getCellAt(i, j).getPiece().getOwner().getName()+'\n'+"Power Available: No");

			
			}
			moveA[0]=game.getCellAt(i, j).getPiece();
			zabatsorto(game.getCellAt(i, j).getPiece());
			if(f==0||f==1){
				if(game.getCellAt(i, j).getPiece()!=null){
					presses[f]=game.getCellAt(i, j).getPiece();
					f++;
				
			}
			}
			if (f==2){
				if(game.getCellAt(i, j).getPiece()==null){
					presses[f]=game.getCellAt(i, j).getPiece();
					 newPos = new Point(i,j);
					f++;
				}
			}
			/*else{
				f=0;
				for(int z=0;z<presses.length;z++){
					presses[z]=null;
				}
				JOptionPane.showMessageDialog(null,"To move select a hero then a direction then press move","Super Hero Chess",JOptionPane.CANCEL_OPTION);
			
		}	*/
		}
		if (e.getActionCommand()=="usepower"){
			info.setText("");
			sorto.setVisible(false);
			if (f==2){
				//Tech
				if(presses[0] instanceof Tech && presses[1] instanceof Piece ){
					try {
						((ActivatablePowerHero) presses[0]).usePower(null,(Piece) presses[1],null);
						if(game.getCurrentPlayer()==game.getPlayer1())
							new usepower2((Piece) presses[0]);
						else if(game.getCurrentPlayer()==game.getPlayer2())
							new usepower1((Piece)presses[0]);
					} catch ( WrongTurnException e1) {
						f=0;
						for(int z=0;z<presses.length;z++){
							presses[z]=null;
						}
						JOptionPane.showMessageDialog(null,"This is not your turn","Super Hero Chess",JOptionPane.CANCEL_OPTION);
					}
					 catch (InvalidPowerUseException e1){
						 f=0;
							for(int z=0;z<presses.length;z++){
								presses[z]=null;
							}
							JOptionPane.showMessageDialog(null,e1.getMessage(),"Super Hero Chess",JOptionPane.CANCEL_OPTION);
					 }
					
					f=0;
					for(int z=0;z<presses.length;z++){
						presses[z]=null;
					}
					
					boardBackground(game,this);
					if(game.getPlayer1().getPayloadPos()==6||game.getPlayer2().getPayloadPos()==6){
						setVisible(false);}
				}
				
				else if((presses[0] instanceof Super||presses[0] instanceof Ranged||presses[0] instanceof Medic&&presses[1] instanceof Direction)){
					if(presses[0] instanceof Medic){
						if(game.getCurrentPlayer().getDeadCharacters().size()==0)
							JOptionPane.showMessageDialog(null,"Your Dead Characters List is empty","Super Hero Chess",JOptionPane.CANCEL_OPTION);

						Piece temp = null;
						for(int i=0;i<game.getCurrentPlayer().getDeadCharacters().size();i++){
							//System.out.println(l.getSelectedItem());
							if(((String) l.getSelectedItem()).equals(game.getCurrentPlayer().getDeadCharacters().get(i).getName())){
								temp = game.getCurrentPlayer().getDeadCharacters().get(i);
								break;
						}}
						if (temp!=null){
						try {
							((ActivatablePowerHero) presses[0]).usePower((Direction) presses[1],temp,null);
							if(game.getCurrentPlayer()==game.getPlayer1())
								new usepower2((Piece) presses[0]);
							else if(game.getCurrentPlayer()==game.getPlayer2())
								new usepower1((Piece)presses[0]);
						} catch ( WrongTurnException e1) {
							f=0;
							for(int z=0;z<presses.length;z++){
								presses[z]=null;
							}
							JOptionPane.showMessageDialog(null,"This is not your turn","Super Hero Chess",JOptionPane.CANCEL_OPTION);
						}
						 catch (InvalidPowerUseException e1){
							 f=0;
								for(int z=0;z<presses.length;z++){
									presses[z]=null;
								}
								JOptionPane.showMessageDialog(null,e1.getMessage(),"Super Hero Chess",JOptionPane.CANCEL_OPTION);
						 }
						}
						else
							JOptionPane.showMessageDialog(null,"To use a Power :-"+ '\n'+"Choose the hero"+'\n'+"Then choose the Target(if needed)"+'\n' +"Then add Direction"+'\n'+"Then choose new position (if needed)"+'\n'+"Then press on use power button","Super Hero Chess",JOptionPane.CANCEL_OPTION);

					}
					else if((presses[0] instanceof Super||presses[0] instanceof Ranged&&presses[1] instanceof Direction)){
					try {
						((ActivatablePowerHero) presses[0]).usePower((Direction) presses[1],null,null);
						if(game.getCurrentPlayer()==game.getPlayer1())
							new usepower2((Piece) presses[0]);
						else if(game.getCurrentPlayer()==game.getPlayer2())
							new usepower1((Piece)presses[0]);
					} 
					 catch ( WrongTurnException e1) {
						f=0;
						for(int z=0;z<presses.length;z++){
							presses[z]=null;
						}
						JOptionPane.showMessageDialog(null,"This is not your turn","Super Hero Chess",JOptionPane.CANCEL_OPTION);
					}
					 catch (InvalidPowerUseException e1){
						 f=0;
							for(int z=0;z<presses.length;z++){
								presses[z]=null;
							}
							JOptionPane.showMessageDialog(null,e1.getMessage(),"Super Hero Chess",JOptionPane.CANCEL_OPTION);
					 }
					}
					 f=0;
						for(int z=0;z<presses.length;z++){
							presses[z]=null;
						}
						boardBackground(game,this);
						if(game.getPlayer1().getPayloadPos()>=6||game.getPlayer2().getPayloadPos()>=6){
							setVisible(false);}
 
				}
				else if((presses[1] instanceof Super||presses[1] instanceof Ranged&&presses[0] instanceof Direction)){ 
					try {
						((ActivatablePowerHero) presses[1]).usePower((Direction) presses[0],null,null);
						if(game.getCurrentPlayer()==game.getPlayer1())
							new usepower2((Piece) presses[1]);
						else if(game.getCurrentPlayer()==game.getPlayer2())
							new usepower1((Piece)presses[1]);
					} 
					 catch ( WrongTurnException e1) {
						f=0;
						for(int z=0;z<presses.length;z++){
							presses[z]=null;
						}
						JOptionPane.showMessageDialog(null,"This is not your turn","Super Hero Chess",JOptionPane.CANCEL_OPTION);
					}
					 catch (InvalidPowerUseException e1){
						 f=0;
							for(int z=0;z<presses.length;z++){
								presses[z]=null;
							}
							JOptionPane.showMessageDialog(null,e1.getMessage(),"Super Hero Chess",JOptionPane.CANCEL_OPTION);
					 }
					 f=0;
						for(int z=0;z<presses.length;z++){
							presses[z]=null;
						}
						boardBackground(game,this);
						if(game.getPlayer1().getPayloadPos()>=6||game.getPlayer2().getPayloadPos()>=6){
							setVisible(false);}

				}
				else{
					f=0;
					for(int z=0;z<presses.length;z++){
						presses[z]=null;
					}
					JOptionPane.showMessageDialog(null,"To use a Power :-"+ '\n'+"Choose the hero"+'\n'+"Then choose the Target(if needed)"+'\n' +"Then add Direction"+'\n'+"Then choose new position (if needed)"+'\n'+"Then press on use power button","Super Hero Chess",JOptionPane.CANCEL_OPTION);

				}
			}
			else if (f==3){
				//System.out.println(f);
				if(presses[0] instanceof Tech && presses[1] instanceof Piece&&newPos!=null){
					try {
						((ActivatablePowerHero) presses[0]).usePower(null,(Piece) presses[1],newPos);
						if(game.getCurrentPlayer()==game.getPlayer1())
							new usepower2((Piece) presses[0]);
						else if(game.getCurrentPlayer()==game.getPlayer2())
							new usepower1((Piece)presses[0]);
					}  catch ( WrongTurnException e1) {
						f=0;
						for(int z=0;z<presses.length;z++){
							presses[z]=null;
						}
						JOptionPane.showMessageDialog(null,"This is not your turn","Super Hero Chess",JOptionPane.CANCEL_OPTION);
					}
					 catch (InvalidPowerUseException e1){
						 f=0;
							for(int z=0;z<presses.length;z++){
								presses[z]=null;
							}
							JOptionPane.showMessageDialog(null,e1.getMessage(),"Super Hero Chess",JOptionPane.CANCEL_OPTION);
					 }
					f=0;
					for(int z=0;z<presses.length;z++){
						presses[z]=null;
					}
					boardBackground(game,this);
					if(game.getPlayer1().getPayloadPos()==6||game.getPlayer2().getPayloadPos()==6){
						setVisible(false);}
				}
				else{
					f=0;
					for(int z=0;z<presses.length;z++){
						presses[z]=null;
					}
					JOptionPane.showMessageDialog(null,"To use a Power :-"+ '\n'+"Choose the hero"+'\n'+"Then choose the Target(if needed)"+'\n' +"Then add Direction"+'\n'+"Then choose new position (if needed)"+'\n'+"Then press on use power button","Super Hero Chess",JOptionPane.CANCEL_OPTION);

				}
			}
				else 
					JOptionPane.showMessageDialog(null,"To use a Power :-"+ '\n'+"Choose the hero"+'\n'+"Then choose the Target(if needed)"+'\n' +"Then add Direction"+'\n'+"Then choose new position (if needed)"+'\n'+"Then press on use power button","Super Hero Chess",JOptionPane.CANCEL_OPTION);

					
			
			
		}
		if(e.getActionCommand()=="instructions")
			new help();
			//JOptionPane.showMessageDialog(null,"Game Instructions :-"+'\n'+"To move :-"+'\n'+"Select the piece you want to move then direction then press move."+'\n'+"SideKick of "+game.getPlayer1().getName() +" :- move in directions(Up,UpRight,UpLeft,Left,Right)."+'\n'+"SideKick of "+game.getPlayer2().getName() +" :- move in directions(Down,DownRight,DownLeft,Left,Right)."+'\n'+"Super,Medic :- moves in directions(Up,Right,Down,Left). "+'\n'+"Armored :- moves in all directions. "+'\n'+"Speedster:- moves 2 cells in all directions."+'\n'+"Tech :- moves only DIAGONALS."+'\n'+"To USE POWER :-"+'\n'+"Ranged&Super :- press on Ranged then the direction you want(Up,Down,Right,Left) then press on use power button."+'\n'+"Medic:- press on medic then choose the direction then  choose the Hero you want to revive from the dead characters list then press on the use power button. "+'\n'+"Tech :- ."+'\n'+"Armored :- It needs to be attacked twice to die.","Super Hero Chess",JOptionPane.CANCEL_OPTION);
		
	}
	
	public static void zabatsorto(Piece p){
		if(p instanceof SideKickP1)
			sorto.setIcon(new ImageIcon("src/minion.png"));
		//player2
		if(p instanceof SideKickP2)
			sorto.setIcon(new ImageIcon("src/pikatchu.png"));
		if(p instanceof Armored){
			if(p.getOwner()==game.getPlayer1()){
				if(((Armored) p).isArmorUp()==true)
					sorto.setIcon(new ImageIcon("src/buzzarmorup.jpg"));
				else 
					sorto.setIcon(new ImageIcon("src/buzzarmordown.png"));
			}
			//player2
			if(p.getOwner()==game.getPlayer2()){
				if(((Armored) p).isArmorUp()==true)
					sorto.setIcon(new ImageIcon("src/gokuarmorup.png"));
				else 
					sorto.setIcon(new ImageIcon("src/gokuarmordown.png"));	
			}
			}
		if(p instanceof Medic){
			if(p.getOwner()==game.getPlayer1())
				sorto.setIcon(new ImageIcon("src/genie.jpg"));
			//player2
			if(p.getOwner()==game.getPlayer2())
				sorto.setIcon(new ImageIcon("src/bugs.png"));
		}
		if(p instanceof Speedster){
			if(p.getOwner()==game.getPlayer1())
				sorto.setIcon(new ImageIcon("src/san.jpg"));
			//player2
			if(p.getOwner()==game.getPlayer2())
				sorto.setIcon(new ImageIcon("src/roadrunner.png"));
		}
		if(p instanceof Super){
			if(p.getOwner()==game.getPlayer1())
				sorto.setIcon(new ImageIcon("src/incredible.jpg"));
			//player2
			if(p.getOwner()==game.getPlayer2())
				sorto.setIcon(new ImageIcon("src/taz.png"));
		}
		if(p instanceof Tech){
			if(p.getOwner()==game.getPlayer1())
				sorto.setIcon(new ImageIcon("src/aladdin.png"));
			//player2
			if(p.getOwner()==game.getPlayer2())
				sorto.setIcon(new ImageIcon("src/popeye.png"));
		}
		if(p instanceof Ranged){
			if(p.getOwner()==game.getPlayer1())
				sorto.setIcon(new ImageIcon("src/hercules.png"));
			//player2
			if(p.getOwner()==game.getPlayer2())
				sorto.setIcon(new ImageIcon("src/sam.png"));			
	}
		sorto.setVisible(true);
	}
	
}
