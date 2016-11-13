package Logic.Level;

import Graphic.Level.GraphicLevel4;
import Logic.Tank.Player;

public class Level4 extends Level{
	
	protected GraphicLevel4 graphic;
	
	public Level4(Player pla){
		speedShot=3;
		pla.setSimultaneousShots(3);
		pla.setSpeedMove(55);
		pla.setResistance(4);
		graphic= new GraphicLevel4();
//		graphic.changePlayerImage(pla);
	}
	public int getSpeedShot(){
		return speedShot;
	}
	public Level getNextLevel(Player pla){
		return new Level4(pla);
	}
	public GraphicLevel4 getGraphic(){
		return graphic;
	}
}