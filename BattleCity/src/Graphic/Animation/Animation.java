package Graphic.Animation;

import Logic.Map.*;

import java.awt.Image;
import Graphic.Map.GraphicElement;

public abstract class Animation extends GraphicElement{
	
	protected Map map;
	protected Image images[];
	protected int posInAnimations;
	protected int actualImage;
	
	public Animation(int x, int y, String nom, Map map){
		super(x,y,nom);
		this.map=map;
	}
	public void setPosInAnimations(int x){
		posInAnimations=x;
	}
	public int getPosInAnimations(){
		return posInAnimations;
	}
}