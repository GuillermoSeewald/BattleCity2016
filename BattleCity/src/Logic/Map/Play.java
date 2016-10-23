package Logic.Map;

import Logic.Tank.*;
import Graphic.Map.*;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Play extends JFrame{
	private static final long serialVersionUID = 1L;
	
	protected Map map;
	protected Player player;
	protected int cantEnemyDead;
	protected Frame_GraphicPlay graphicPlay;
	
	public Play(String m){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		player= new Player(null,4,12);
		map= new Map(m, this, player);
		player.setMap(map);
		Thread tp= new Thread(player);
		tp.start();
		cantEnemyDead=0;
		graphicPlay= new Frame_GraphicPlay(this);
		
		setTitle("Battle City");
		setSize(map.getGraphicMap().getWidth()+graphicPlay.getInformationPanel().getWidth()+100,map.getGraphicMap().getHeight());
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		add(map.getGraphicMap(), BorderLayout.CENTER);
		add(graphicPlay.getInformationPanel(), BorderLayout.EAST);
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
	public Frame_GraphicPlay getFrame(){
		return graphicPlay;
	}
}