package Mapa;

import Obstaculo.*;
import Tanque.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Map extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private Player jugador;
	private Timer timer;
	private Element[][] obstacles;
	private Enemy[] enemigos;
	
	public Map(String mapa){
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new Teclado());
		
		obstacles=new Element[13][13];
		try{
			cargarMapa(mapa);
		}catch(FileNotFoundException e){
		}catch(IOException e){
		}
		
		jugador= new Player();
		timer= new Timer(jugador.getVelMovimiento(),this);
		timer.start();
	}
	
	public void paint(Graphics grafica){
		super.paint(grafica);
		Graphics2D g= (Graphics2D) grafica;
		g.drawImage(jugador.getImagen(), jugador.getX(), jugador.getY(), null);
		for(int i=0;i<obstacles.length;i++){
			for(int j=0;j<obstacles.length;j++){
				if(obstacles[i][j]!=null){
					g.drawImage(obstacles[i][j].getImagen(), obstacles[i][j].getX(), obstacles[i][j].getY(), null);
				}
			}
		}
	}
	public void cargarMapa(String map) throws IOException, FileNotFoundException{
		String cadena;
		char[] c;
		int fila=0;
		FileReader f= new FileReader(map);
		BufferedReader b= new BufferedReader(f);
		int x=0;
		int y=0;
		while((cadena=b.readLine())!=null){
			c=cadena.toCharArray();
			for(int i=0;i<c.length;i++){
				switch (c[i]){
				case 'A':
					obstacles[fila][i]= new SteelWall(x,y);
					break;
				case 'L':
					obstacles[fila][i]= new BrickWall(x,y);
					break;
				case 'G':
					obstacles[fila][i]= new Water(x,y);
					break;
				case 'C':
					obstacles[fila][i]= new Tree(x,y);
					break;
				case 'B':
					obstacles[fila][i]= new Base("Bandera1",x+52,y);
					break;
				}
				x=x+52;
			}
			x=0;
			y+=52;
			fila++;
		}
		b.close();
	}
	
	private class Teclado extends KeyAdapter{
		public void keyReleased(KeyEvent e){
			jugador.keyReleased(e);
		}
		public void keyPressed(KeyEvent e){
			jugador.keyPressed(e);
		}
	}

	public void actionPerformed(ActionEvent e) {
		jugador.mover();
		repaint();
	}
}