package Mapa;

import Obstaculo.*;
import Tanque.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.KeyEvent;

public class Mapa{
	private Celda[][] celdas;
	private Tanque jugador;
	private Tanque[] enemigos;
	
	public Mapa(String mapa){
		jugador= new Jugador();
		jugador.setX(4);
		jugador.setY(12);
		celdas=new Celda[13][13];
		try{
			cargarMapa(mapa);
		}catch(FileNotFoundException e){
		}catch(IOException e){
		}
		
	}	
	public int getLongitud(){
		return celdas.length;
	}
	public Celda[][] retornarMap(){
		return celdas;
	}
	
	public Tanque getJugador(){
		return jugador;
	}
	public void mover(int dir){		
		int direccion = 0;
		
		switch (dir){
			case KeyEvent.VK_UP :
				direccion = 0;
				break;
			case KeyEvent.VK_DOWN :
				direccion = 1;
				break;
			case KeyEvent.VK_LEFT :
				direccion = 2;
				break;
			case KeyEvent.VK_RIGHT :
				direccion = 3;
				break;
		}
		
		jugador.mover(direccion);
	}
	public void cargarMapa(String map) throws IOException, FileNotFoundException{
		String cadena;
		char[] c;
		int fila=0;
		FileReader f= new FileReader(map);
		BufferedReader b= new BufferedReader(f);
		while((cadena=b.readLine())!=null){
			c=cadena.toCharArray();
			for(int i=0;i<c.length;i++){
				switch (c[i]){
				case 'A':
					celdas[fila][i]= new Acero("acero",i,fila);
					break;
				case 'L':
					celdas[fila][i]= new Ladrillo("ladrillo",i,fila);
					break;
				case 'G':
					celdas[fila][i]= new Agua("agua",i,fila);
					break;
				case 'C':
					celdas[fila][i]= new Cesped("cesped",i,fila);
					break;
				case 'N':
					celdas[fila][i]= new Nulo("nulo",i,fila);
					break;
				case 'B':
					celdas[fila][i]= new Bandera("bandera1",i,fila);
					break;
				}
				
			}
			fila++;
			agregarJugador(jugador.getY(),jugador.getX());
		}
		b.close();
	}
	private void agregarJugador(int y, int x){
		celdas[y][x]= jugador;
	}
}