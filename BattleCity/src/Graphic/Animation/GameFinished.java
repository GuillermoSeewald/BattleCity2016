package Graphic.Animation;

import Logic.Map.*;
import Graphic.Frames.*;

public class GameFinished extends Animation implements Runnable{
	
	private volatile boolean execute;
	
	public GameFinished(int x, int y, String nom, Map map){
		super(x,y,nom, map);
		map.getPlay().getPlayer().setSimultaneousShots(0);
		map.getPlay().getPlayer().terminate();
		execute=true;
		posInAnimations=map.getGraphicMap().insertAnimation(this);
	}
	
	public void terminate(){
		execute=false;
	}
	public void run(){
		while(execute){
			if(!upload()){
				try {
					Thread.sleep(5000);
				} catch(InterruptedException e){
				}
				map.getGraphicMap().deleteAnimation(posInAnimations);
				terminate();
				new InitialFrame().setVisible(true);
				map.getPlay().getFrame().dispose();
			}
			try {
				Thread.sleep(50);
			} catch(InterruptedException e){
			}
		}
	}
	private boolean upload(){
		boolean upload=false;
		if(Y>260){
			upload=true;
			Y-=5;
			map.getGraphicMap().repaint();
		}
		return upload;
	}
}