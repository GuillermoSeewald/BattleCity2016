package Graphic.Level;

import java.awt.Image;

import Logic.Tank.Player;

public abstract class GraphicLevel{

	protected Image[][] images;
	
	public Image getImage(int x, int y){
		return images[x][y];
	}
	public void changePlayerImage(Player p){
		String d= p.getGraphic().getDirection();
		if(d=="arriba"){
			p.getGraphic().setImage(images[0][0]);
		}
		else{
			if(d=="izquierda"){
				p.getGraphic().setImage(images[0][2]);
			}
			else{
				if(d=="abajo"){
					p.getGraphic().setImage(images[0][4]);
				}
				else{
					p.getGraphic().setImage(images[0][6]);
				}
			}
		}
	}
}