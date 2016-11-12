package Logic.Level;

import Graphic.Level.GraphicLevel;
import Logic.Tank.*;

public abstract class Level{
	
	protected int speedShot;
	
	public int getSpeedShot(){
		return speedShot;
	}
	public abstract Level getNextLevel(Player pla);
	public abstract GraphicLevel getGraphic();
}