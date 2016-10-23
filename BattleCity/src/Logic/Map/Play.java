package Logic.Map;

import Logic.Tank.*;
import Graphic.Map.*;

public class Play {
	
	protected Map map;
	protected Player player;
	protected int cantEnemyDead;
	protected Frame_GraphicPlay graphicPlay;
	
	public Play(String m){
		
		
		player= new Player(null,4,12);
		map= new Map(m, this, player);
		player.setMap(map);
		Thread tp= new Thread(player);
		tp.start();
		cantEnemyDead=0;
		graphicPlay= new Frame_GraphicPlay(this, map);
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