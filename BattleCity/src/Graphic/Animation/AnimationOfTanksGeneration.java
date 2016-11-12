package Graphic.Animation;

import Logic.Map.*;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class AnimationOfTanksGeneration extends Animation{
	
	public AnimationOfTanksGeneration(int x, int y, String nom, Map map){
		super(x,y,nom,map);
		images= new Image[6];
		buildImages();
		actualImage=0;
	}	
	public void buildImages(){
		images[0]=new ImageIcon("Imagenes/Generation 2.png").getImage();
		images[1]=new ImageIcon("Imagenes/Generation 3.png").getImage();
		images[2]=new ImageIcon("Imagenes/Generation 4.png").getImage();
		images[3]=new ImageIcon("Imagenes/Generation 5.png").getImage();
		images[4]=new ImageIcon("Imagenes/Generation 6.png").getImage();
		images[5]=new ImageIcon("Imagenes/Generation 7.png").getImage();
	}
}