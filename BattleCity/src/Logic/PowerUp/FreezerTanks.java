package Logic.PowerUp;

import Logic.Map.Map;

public class FreezerTanks implements Runnable{
	
	protected Map map;
	protected boolean gameOver;
	
	public FreezerTanks(Map map, boolean g){
		this.map=map;
		gameOver=g;
	}
	public void run(){
		if(gameOver){
			map.getPlay().getPlayer().terminate();
		}
		else{
			for(int i=0;i<map.getEnemies().length;i++){
				if(map.getEnemies()[i]!=null){
					map.getEnemies()[i].setStop(true);
				}
			}
		}
	}
}