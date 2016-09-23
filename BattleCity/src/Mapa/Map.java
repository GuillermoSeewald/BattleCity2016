package Mapa;

import Obstaculo.*;
import Tanque.*;
import java.util.Random;
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
	
	protected Player player;
	protected Timer timer;
	protected Obstacle[][] obstacles;
	protected Enemy[] enemies;
	protected int cantEnemy;
	protected Play game;
	
	public Map(String mapa, Play p, Player jug){
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new Teclado());
		
		game=p;
		enemies= new Enemy[4];
		obstacles=new Obstacle[13][13];
		try{
			cargarMapa(mapa);
		}catch(FileNotFoundException e){
		}catch(IOException e){
		}
		
		player= jug;
		timer= new Timer(player.getVelMovimiento(),this);
		timer.start();
		
		setSize(677,707);
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
					obstacles[fila][i]= new SteelWall(x,y,i,fila,this);
					break;
				case 'L':
					obstacles[fila][i]= new BrickWall(x,y,i,fila,this);
					break;
				case 'G':
					obstacles[fila][i]= new Water(x,y,i,fila,this);
					break;
				case 'C':
					obstacles[fila][i]= new Tree(x,y,i,fila,this);
					break;
				case 'B':
					obstacles[fila][i]= new Base(x,y,i,fila,this);
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
	public void fullEnemyKill(){
		for(int i=0;i<enemies.length;i++){
			enemies[i]=null;
		}
	}
	public void deleteEnemy(int x){
		player.setPuntos(player.getPuntos()+enemies[x].getPuntos());
		enemies[x]=null;
	}
	public void deleteObstacle(int x, int y){
		obstacles[x][y]=null;
	}
	public boolean insertEnemy(){
		boolean insert= false;
		int posicion=0;
		Random r= new Random();
		int x= r.nextInt(4);
		if(game.getCantEnemyDead()<20){
			for(int i=0;(i<enemies.length)&&(!insert);i++){
				if(enemies[i]==null){
					insert=true;
					switch(x){
					case 0:
						enemies[i]= new ArmoredTank(posicion,0,this, i);
						break;
					case 1:
						enemies[i]= new FastTank(posicion, 0, this, i);
						break;
					case 2:
						enemies[i]= new PowerTank(posicion, 0, this, i);
						break;
					case 3:
						enemies[i]= new BasicTank(posicion, 0, this, i);
						break;
					}
				}
				else{
					posicion+=(enemies[i].getWidth()*4);
				}
			}
			
		}
		return insert;
	}
	public Enemy[] getEnemies(){
		return enemies;
	}
	public Obstacle[][] getMap(){
		return obstacles;
	}
	public Obstacle getObstacle(int x, int y){
		return obstacles[x][y];
	}
	public Play getPlay(){
		return game;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	public void paint(Graphics grafica){
		super.paint(grafica);
		Graphics2D g= (Graphics2D) grafica;
		g.drawImage(player.getImagen(), player.getX(), player.getY(), null);
		for(int j=0;j<enemies.length;j++){
			if(enemies[j]!=null){
				g.drawImage(enemies[j].getImagen(), enemies[j].getX(), enemies[j].getY(), null);
			}
		}
		for(int i=0;i<obstacles.length;i++){
			for(int j=0;j<obstacles.length;j++){
				if(obstacles[i][j]!=null){
					g.drawImage(obstacles[i][j].getImagen(), obstacles[i][j].getX(), obstacles[i][j].getY(), null);
				}
			}
		}
	}
	private class Teclado extends KeyAdapter{
		public void keyReleased(KeyEvent e){
			player.keyReleased(e);
		}
		public void keyPressed(KeyEvent e){
			player.keyPressed(e);
		}
	}

	public void actionPerformed(ActionEvent e) {
		player.mover();
		repaint();
	}
}