package Logic.Map;

import Logic.Obstacle.*;
import Logic.Tank.*;
import Logic.Shot.*;
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

public class Map extends JPanel{
	private static final long serialVersionUID = 1L;
	
	protected Player player;
	protected Timer timer;
	protected Obstacle[][] obstacles;
	protected Enemy[] enemies;
	protected Shot[] shots;
	protected int cantEnemy;
	protected Play game;
	
	public Map(String mapa, Play p, Player jug){
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new Teclado());
		
		game=p;
		enemies= new Enemy[4];
		shots= new Shot[7];
		obstacles=new Obstacle[13][13];
		try{
			cargarMapa(mapa);
		}catch(FileNotFoundException e){
		}catch(IOException e){
		}
		
		player= jug;
		setSize(676,715);
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
	public void deleteShot(int x){
		shots[x]=null;
		repaint();
	}
	public void deleteEnemy(int x){
		player.setPoints(player.getPoints()+enemies[x].getPoints());
		enemies[x].terminate();
		enemies[x]=null;
		repaint();
	}
	public void deleteObstacle(int x, int y){
		obstacles[y][x]=null;
		repaint();
	}
	public boolean insertEnemy(){
		Thread t;
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
						ArmoredTank a= new ArmoredTank(posicion,0,this, i,i*4,0);
						t= new Thread(a);
						t.start();
						enemies[i]= a;
						break;
					case 1:
						FastTank f= new FastTank(posicion, 0, this, i,i*4,0);
						t= new Thread(f);
						t.start();
						enemies[i]=f;
						break;
					case 2:
						PowerTank p= new PowerTank(posicion, 0, this, i,i*4,0);
						t= new Thread(p);
						t.start();
						enemies[i]=p;
						break;
					case 3:
						BasicTank b= new BasicTank(posicion, 0, this, i,i*4,0);
						t= new Thread(b);
						t.start();
						enemies[i]= b;
						break;
					}
				}
				else{
					posicion+=(enemies[i].getGraphic().getWidth()*4);
				}
			}
			
		}
		return insert;
	}
	public int insertShot(Shot s){
		int retorno=0;
		boolean insert=false;
		while((!insert)&&(retorno<shots.length)){
			if(shots[retorno]==null){
				shots[retorno]=s;
				insert=true;
			}
			else{
				retorno++;
			}
		}
		return retorno;
	}
	public Enemy[] getEnemies(){
		return enemies;
	}
	public Obstacle[][] getMap(){
		return obstacles;
	}
	public Obstacle getObstacle(int x, int y){
		if((x<obstacles.length)&&(y<obstacles.length)){
			return obstacles[y][x];
		}
		else return null;
	}
	public Play getPlay(){
		return game;
	}
	public Shot[] getShots(){
		return shots;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	public void paint(Graphics grafica){
		super.paint(grafica);
		Graphics2D g= (Graphics2D) grafica;
		g.drawImage(player.getGraphic().getImagen(), player.getGraphic().getX(), player.getGraphic().getY(), null);
		for(int n=0;n<shots.length;n++){
			if(shots[n]!=null){
				g.drawImage(shots[n].getGraphic().getImagen(),shots[n].getGraphic().getX(),shots[n].getGraphic().getY(),null);
			}
		}
		for(int j=0;j<enemies.length;j++){
			if(enemies[j]!=null){
				g.drawImage(enemies[j].getGraphic().getImagen(), enemies[j].getGraphic().getX(), enemies[j].getGraphic().getY(), null);
			}
		}
		for(int i=0;i<obstacles.length;i++){
			for(int j=0;j<obstacles.length;j++){
				if(obstacles[i][j]!=null){
					g.drawImage(obstacles[i][j].getGraphic().getImagen(), obstacles[i][j].getGraphic().getX(), obstacles[i][j].getGraphic().getY(), null);
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
			repaint();
		}
	}
}