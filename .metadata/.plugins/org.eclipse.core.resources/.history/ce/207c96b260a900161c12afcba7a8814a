package Logic.Level;

import Logic.Tank.Player;
import Graphic.Level.GraphicLevel3;


public class Level3 extends Level{
	
	protected GraphicLevel3 graphic;
	
	public Level3(Player pla){
		speedShot=4;
		pla.setSimultaneousShots(2);
		pla.setSpeedMove(55);
		pla.setResistance(2);
		graphic= new GraphicLevel3();
		killSteel=false;
	}
	public int getSpeedShot(){
		return speedShot;
	}
	public Level getNextLevel(Player pla){
		return new Level4(pla);
	}
	public GraphicLevel3 getGraphic(){
		return graphic;
	}
}