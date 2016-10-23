package Logic.Map;

import Logic.Obstacle.*;
import Logic.Tank.*;
import Graphic.Map.GraphicMap;

import java.util.Random;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Map{
	
	protected Player player;
	protected Obstacle[][] obstacles;
	protected Enemy[] enemies;
	protected int cantEnemy;
	protected Play game;
	protected GraphicMap graphicMap;
	
	public Map(String mapa, Play p, Player pla){
		
		game=p;
		enemies= new Enemy[4];
		obstacles=new Obstacle[13][13];
		try{
			loadMap(mapa);
		}catch(FileNotFoundException e){
		}catch(IOException e){
		}
		
		player= pla;
		
		graphicMap= new GraphicMap(this);
	}
	
	public void loadMap(String map) throws IOException, FileNotFoundException{
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
		player.setPoints(player.getPoints()+enemies[x].getPoints());
		enemies[x].terminate();
		enemies[x]=null;
		graphicMap.repaint();
	}
	public void deleteObstacle(int x, int y){
		obstacles[y][x]=null;
		graphicMap.repaint();
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
	public GraphicMap getGraphicMap(){
		return graphicMap;
	}
}