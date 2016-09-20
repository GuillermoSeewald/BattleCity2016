package Mapa;

import Tanque.*;
import javax.swing.JFrame;

public class Play extends JFrame{
	private static final long serialVersionUID = 1L;
	
	protected Map map;
	protected Player player;
	protected int cantEnemyDead;
	
	public Play(String m){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		map= new Map(m, this);
		add(map);
		setPlayer();
		cantEnemyDead=0;
		
		
		setTitle("Battle City");
		setSize(850,707);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public void setPlayer(){
		player= new Player();
	}
	public void incrementEnemyDead(){
		cantEnemyDead++;
	}
	public void createEnemy(){
	}
	public Player getJugador(){
		return player;
	}
	public int getCantEnemyDead(){
		return cantEnemyDead;
	}
	public Map getMap(){
		return map;
	}
	
}