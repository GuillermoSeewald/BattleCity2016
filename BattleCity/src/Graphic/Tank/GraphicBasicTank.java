package Graphic.Tank;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GraphicBasicTank extends GraphicEnemy{
	
	public GraphicBasicTank(int x, int y, String n, String dir){
		super(x,y,n,dir);
		width=40;
		height=40;
		buildImages();
	}
	public Image getImageInArray(int x, int y){
		return images[x][y];
	}
	private void buildImages(){
		images[0][0]=new ImageIcon("Imagenes/Basic tank arriba-mov1.png").getImage();		
		images[1][0]=new ImageIcon("Imagenes/Basic tank arriba-mov2.png").getImage();
		images[0][1]=new ImageIcon("Imagenes/Basic tank izquierda-mov1.png").getImage();
		images[1][1]=new ImageIcon("Imagenes/Basic tank izquierda-mov2.png").getImage();
		images[0][2]=new ImageIcon("Imagenes/Basic tank abajo-mov1.png").getImage();
		images[1][2]=new ImageIcon("Imagenes/Basic tank abajo-mov2.png").getImage();
		images[0][3]=new ImageIcon("Imagenes/Basic tank derecha-mov1.png").getImage();
		images[1][3]=new ImageIcon("Imagenes/Basic tank derecha-mov2.png").getImage();
	}
	public void changeImage(){
		int dir=2;
		switch (direction){
		case "arriba":
			dir=0;
			break;
		case "abajo":
			dir=2;
			break;
		case "izquierda":
			dir=1;
			break;
		case "derecha":
			dir=3;
			break;
		}
		if(moveImage==0){
			moveImage=1;;
		}
		else{
			moveImage=0;
		}
		setImage(getImageInArray(moveImage,dir));
	}
}