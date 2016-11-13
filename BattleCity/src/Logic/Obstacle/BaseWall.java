package Logic.Obstacle;

import Logic.Map.*;

public class BaseWall implements Runnable{
	
	protected Map map;
	
	public BaseWall(Map map){
		this.map=map;
	}
	public void run(){
		createSteelWall();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e){
		}
		createBrickWall();
	}

	private void createSteelWall(){
		for(int i=0;i<5;i++){
			SteelWall s= new SteelWall(map.getBase().getWall()[i].getGraphic().getX(),map.getBase().getWall()[i].getGraphic().getY(),map.getBase().getWall()[i].getPosX(),map.getBase().getWall()[i].getPosY(),map);
			map.getBase().setObstacleInWall(s, i);
		}
	}
	private void createBrickWall(){
		for(int i=0;i<5;i++){
			BrickWall b= new BrickWall(map.getBase().getWall()[i].getGraphic().getX(),map.getBase().getWall()[i].getGraphic().getY(),map.getBase().getWall()[i].getPosX(),map.getBase().getWall()[i].getPosY(),map);
			map.getBase().setObstacleInWall(b, i);
		}
	}
}