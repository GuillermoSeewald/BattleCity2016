package Level;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Level3 extends Level{
	public Level3(){
		images= new Image[2][4];
		buildImages();
	}
	public int getSpeedShot(){
		return speedShot;
	}
	
	private void buildImages(){
		images[0][0]=new ImageIcon("Imagenes/Jugador arriba-mov1-level3.png").getImage();		
		images[1][0]=new ImageIcon("Imagenes/Jugador arriba-mov2-level3.png").getImage();
		images[0][1]=new ImageIcon("Imagenes/Jugador izquierda-mov1-level3.png").getImage();
		images[1][1]=new ImageIcon("Imagenes/Jugador izquierda-mov2-level3.png").getImage();
		images[0][2]=new ImageIcon("Imagenes/Jugador abajo-mov1-level3.png").getImage();
		images[1][2]=new ImageIcon("Imagenes/Jugador abajo-mov2-level3.png").getImage();
		images[0][3]=new ImageIcon("Imagenes/Jugador derecha-mov1-level3.png").getImage();
		images[1][3]=new ImageIcon("Imagenes/Jugador derecha-mov2-level3.png").getImage();
	}
}