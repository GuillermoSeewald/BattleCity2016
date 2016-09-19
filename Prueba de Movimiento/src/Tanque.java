import java.awt.*;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Tanque{
	private String nombre= "Tanque arriba";
	private String direccion;
	private int x;
	private int y;
	private int dx;
	private int dy;
	
	private Image imagen;
	
	public Tanque(){
		x=52;
		y=52;
		ImageIcon ima = new ImageIcon("Imagenes/"+nombre+".png");
		imagen= ima.getImage();
	}
	public void mover(){
		x+=dx;
		y+=dy;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public Image getImagen(){
		return imagen;
	}
	public void keyPressed(KeyEvent k){
		int key= k.getKeyCode();
		
		switch (key){
		case KeyEvent.VK_UP :
			dy = -1;
			direccion="arriba";
			break;
		case KeyEvent.VK_DOWN :
			dy = 1;
			direccion="abajo";
			break;
		case KeyEvent.VK_LEFT :
			dx = -1;
			direccion="izquierda";
			break;
		case KeyEvent.VK_RIGHT :
			dx = 1;
			direccion="derecha";
			break;
		}
	}
	public void keyReleased(KeyEvent k){
		int key= k.getKeyCode();
		
		switch (key){
		case KeyEvent.VK_UP :
			dy = 0;
			break;
		case KeyEvent.VK_DOWN :
			dy = 0;
			break;
		case KeyEvent.VK_LEFT :
			dx = 0;
			break;
		case KeyEvent.VK_RIGHT :
			dx = 0;
			break;
		}
	}
}