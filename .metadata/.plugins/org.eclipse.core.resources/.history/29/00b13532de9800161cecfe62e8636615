package Graphic.Tank;

import java.awt.Image;

import javax.swing.ImageIcon;

public class GraphicFastTank extends GraphicCharacter{
	
	protected Image[][] images;
	
	public GraphicFastTank(int x, int y, String n, String dir){
		super(x,y,n,dir);
		images= new Image[2][4];
		buildImages();
	}
	public Image getImageInArray(int x, int y){
		return images[x][y];
	}
	private void buildImages(){
		images[0][0]=new ImageIcon("Imagenes/Fast tank arriba-mov1.png").getImage();		
		images[1][0]=new ImageIcon("Imagenes/Fast tank arriba-mov2.png").getImage();
		images[0][1]=new ImageIcon("Imagenes/Fast tank izquierda-mov1.png").getImage();
		images[1][1]=new ImageIcon("Imagenes/Fast tank izquierda-mov2.png").getImage();
		images[0][2]=new ImageIcon("Imagenes/Fast tank abajo-mov1.png").getImage();
		images[1][2]=new ImageIcon("Imagenes/Fast tank abajo-mov2.png").getImage();
		images[0][3]=new ImageIcon("Imagenes/Fast tank derecha-mov1.png").getImage();
		images[1][3]=new ImageIcon("Imagenes/Fast tank derecha-mov2.png").getImage();
	}
}
