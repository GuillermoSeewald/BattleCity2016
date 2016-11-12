package Graphic.Animation;

import Logic.Map.*;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ForceFieldGraphic extends Animation implements Runnable{
	
	private volatile boolean execute;
	
	public ForceFieldGraphic(int x, int y, String nom, Map map){
		super(x,y,nom, map);
		images= new Image[2];
		buildImages();
		actualImage=0;
		execute=true;
		width=60;
		height=60;
	}
	public void terminate(){
		execute=false;
	}
	public void run(){
		while(execute){
			try {
				Thread.sleep(300);
			} catch(InterruptedException e){
			}
			if(actualImage==0){
				actualImage=1;
			}
			else{
				actualImage=0;
			}
			image=images[actualImage];
			map.getGraphicMap().repaint();
		}
	}
	public void buildImages(){
		images[0]=new ImageIcon("Imagenes/Force field 1.png").getImage();
		images[1]=new ImageIcon("Imagenes/Force field 2.png").getImage();
	}
}