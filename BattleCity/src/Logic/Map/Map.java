package Logic.Map;

import Logic.Obstacle.*;
import Logic.Tank.*;
import Logic.PowerUp.*;
import Graphic.Map.GraphicMap;
import Graphic.Animation.*;

import java.util.Random;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Map{
	
	protected Player player;
	protected Obstacle[][] obstacles;
	protected Base base;
	protected Enemy[] enemies;
	protected int cantEnemy;
	protected Play game;
	protected boolean gameOver;
	protected boolean win;
	protected GraphicMap graphicMap;
	
	public Map(String mapa, Play p, Player pla){
		
		game=p;
		enemies= new Enemy[4];
		obstacles=new Obstacle[13][13];
		gameOver=false;
		win=false;
		try{
			loadMap(mapa);
		}catch(FileNotFoundException e){
		}catch(IOException e){
		}
		Obstacle[] w= new Obstacle[5];
		w[0]= obstacles[base.getPosY()-1][base.getPosX()-1];
		w[1]= obstacles[base.getPosY()-1][base.getPosX()];
		w[2]= obstacles[base.getPosY()-1][base.getPosX()+1];
		w[3]= obstacles[base.getPosY()][base.getPosX()-1];
		w[4]= obstacles[base.getPosY()][base.getPosX()+1];
		base.setWall(w);
		
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
					base= new Base(x,y,i,fila,this);
					obstacles[fila][i]= base;
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
			deleteEnemy(i);
		}
	}
	public void setPowerUp(){
		Random r= new Random();
		int x= r.nextInt(obstacles[0].length);
		int y= r.nextInt(obstacles.length);		
		while(obstacles[y][x]!=null){
			x= r.nextInt(obstacles[0].length);
			y= r.nextInt(obstacles.length);
		}		
		int z= r.nextInt(6);
		Thread t;
		switch(z){
		case 0:
			Grenade p= new Grenade(x*52,y*52,x,y,this);
			t= new Thread(p);
			t.start();
			obstacles[y][x]= p;
			break;
		case 1:
			Helmet h= new Helmet(x*52,y*52,x,y,this);
			t= new Thread(h);
			t.start();
			obstacles[y][x]= h;
			break;
		case 2:
			Shovel s= new Shovel(x*52,y*52,x,y,this);
			t= new Thread(s);
			t.start();
			obstacles[y][x]= s;
			break;
		case 3:
			Star st= new Star(x*52,y*52,x,y,this);
			t= new Thread(st);
			t.start();
			obstacles[y][x]= st;
			break;
		case 4:
			Tank tn= new Tank(x*52,y*52,x,y,this);
			t= new Thread(tn);t.start();
			obstacles[y][x]= tn;
			break;
		case 5:
			Timer tm= new Timer(x*52,y*52,x,y,this);
			t= new Thread(tm);t.start();
			obstacles[y][x]= tm;
			break;
		}
	}
	public void deleteEnemy(int x){
		if(enemies[x]!=null){
			player.setPoints(enemies[x].getPoints());
			game.getFrame().getInformationPanel().updatelabelPoints();
			enemies[x].terminate();
			enemies[x]=null;
			graphicMap.repaint();
			boolean empty=true;
			for(int i=4;(i<enemies.length)&&(!empty);i++){
				if(enemies[i]!=null){
					empty=false;
				}
			}
			if((game.getCantEnemyDead()==19)){
				game.incrementEnemyDead();
				win=true;
				Thread t= new Thread(new GameFinished(180,670,"Congratulations, you won",this));
				t.start();
			}
			else{
				if(game.cantEnemyDead<16){
					insertEnemy();
					game.getFrame().getInformationPanel().deleteImageLabel();
				}
				game.incrementEnemyDead();
			}
			if(((game.getCantEnemyDead()%4)==0)&&(game.getCantEnemyDead()<20)){
				setPowerUp();
			}
		}
	}
	public void deleteObstacle(int x, int y){
		obstacles[y][x]=null;
		graphicMap.repaint();
	}
	public boolean getWin(){
		return win;
	}
	public boolean insertEnemy(){
		Thread t;
		boolean insert= false;
		int posicion=3;
		Random r= new Random();
		int x= r.nextInt(4);
		boolean collide=false;
		boolean havePlace=false;
//		int posInsert=0;
		if(game.getCantEnemyDead()<20){
			for(int i=0;(i<enemies.length)&&(!insert);i++){
				if(enemies[i]==null){
					havePlace=true;
					switch(x){
					case 0:
						ArmoredTank a= new ArmoredTank(posicion,0,this, i,i*4,0);
						t= new Thread(a);
						t.start();
						enemies[i]= a;
						collide= (a.getGraphic().haveEnemyTank(this, i)!=null)||(a.getGraphic().havePlayerTank(this)!=null);
						break;
					case 1:
						FastTank f= new FastTank(posicion, 0, this, i,i*4,0);
						t= new Thread(f);
						t.start();
						enemies[i]=f;
						collide= (f.getGraphic().haveEnemyTank(this, i)!=null)||(f.getGraphic().havePlayerTank(this)!=null);
						break;
					case 2:
						PowerTank p= new PowerTank(posicion, 0, this, i,i*4,0);
						t= new Thread(p);
						t.start();
						enemies[i]=p;
						collide= (p.getGraphic().haveEnemyTank(this, i)!=null)||(p.getGraphic().havePlayerTank(this)!=null);
						break;
					case 3:
						BasicTank b= new BasicTank(posicion, 0, this, i,i*4,0);
						t= new Thread(b);
						t.start();
						enemies[i]= b;
						collide= (b.getGraphic().haveEnemyTank(this, i)!=null)||(b.getGraphic().havePlayerTank(this)!=null);
						break;
					}
					if(!collide){
						insert=true;
//						posInsert=i;
					}
					else{
						enemies[i].terminate();
						enemies[i]=null;
					}
				}
				else{
					posicion+=(52*4);
				}
				if((i==enemies.length-1)&&(havePlace)){
					i=0;
					posicion=3;
				}
			}
			
		}
//		if(insert){
//			enemies[posInsert].setStop(true);
//			Thread a= new Thread(new EnemiesGeneration(enemies[posInsert].getGraphic().getX(),enemies[posInsert].getGraphic().getY(),this));
//			a.start();
//		}
		return insert;
		
	}
	public void setObstacle(Obstacle o, int posX, int posY){
		obstacles[posY][posX]= o;
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
	public Base getBase(){
		return base;
	}
	public void gameOver(){
		if(!gameOver){
			player.setSimultaneousShots(0);
			Thread t= new Thread(new FreezerTanks(this,true));
			t.start();
			Thread s= new Thread(new GameFinished(270,670,"Game over",this));
			s.start();
			gameOver=true;
		}
	}
}