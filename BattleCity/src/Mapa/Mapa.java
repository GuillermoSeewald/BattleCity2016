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

public class Mapa extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private Jugador jugador;
	private Timer timer;
	private Celda[][] celdas;
	
	public Mapa(String mapa){
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new Teclado());
		
		celdas=new Celda[13][13];
		try{
			cargarMapa(mapa);
		}catch(FileNotFoundException e){
		}catch(IOException e){
		}
		
		jugador= new Jugador();
		timer= new Timer(12,this);
		timer.start();
	}
	
	public void paint(Graphics grafica){
		super.paint(grafica);
		Graphics2D g= (Graphics2D) grafica;
		g.drawImage(jugador.getImagen(), jugador.getX(), jugador.getY(), null);
		for(int i=0;i<celdas.length;i++){
			for(int j=0;j<celdas.length;j++){
				if(celdas[i][j]!=null){
					g.drawImage(celdas[i][j].getImagen(), celdas[i][j].getX(), celdas[i][j].getY(), null);
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
					celdas[fila][i]= new Acero(x,y);
					break;
				case 'L':
					celdas[fila][i]= new Ladrillo(x,y);
					break;
				case 'G':
					celdas[fila][i]= new Agua(x,y);
					break;
				case 'C':
					celdas[fila][i]= new Cesped(x,y);
					break;
				case 'B':
					celdas[fila][i]= new Bandera("Bandera1",x+52,y);
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