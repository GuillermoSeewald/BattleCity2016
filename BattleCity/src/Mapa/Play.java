package Mapa;

import Tanque.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Play extends JFrame{
	private static final long serialVersionUID = 1L;
	
	protected Map map;
	protected Player player;
	protected int cantEnemyDead;
	protected JPanel panelDetalles;
	
	public Play(String m){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		player= new Player(null);
		map= new Map(m, this, player);
		player.setMap(map);
		add(map);
		cantEnemyDead=0;
		
		int x=map.getWidth();
		int y=map.getHeight();
		setTitle("Battle City");
		setSize(x,y);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		armarPanelDetalles();
//		add(panelDetalles);
	}
	public void setPlayer(){
	}
	public void incrementEnemyDead(){
		cantEnemyDead++;
	}
	public void createEnemy(){
	}
	public Player getPlayer(){
		return player;
	}
	public int getCantEnemyDead(){
		return cantEnemyDead;
	}
	public Map getMap(){
		return map;
	}
	
	
	private void armarPanelDetalles(){
		
	}
}