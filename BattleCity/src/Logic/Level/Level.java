package Logic.Level;

import Graphic.Level.GraphicLevel;
import Logic.Tank.*;

public abstract class Level{
	
	protected int speedShot;
	protected boolean killSteel;
	
	public int getSpeedShot(){
		return speedShot;
	}
	public boolean canKillSteel(){
		return killSteel;
	}
	public abstract Level getNextLevel(Player pla);
	public abstract GraphicLevel getGraphic();
}