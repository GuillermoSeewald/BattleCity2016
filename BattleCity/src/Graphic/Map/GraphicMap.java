package Graphic.Map;

import Logic.Map.Map;
import Logic.Shot.Shot;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;


public class GraphicMap extends JPanel{
	private static final long serialVersionUID = 1L;
	
	protected Map map;
	protected Shot[] shots;
	
	public GraphicMap(Map m){
		map=m;
		shots= new Shot[7];
		
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new Teclado());
		setSize(676,715);
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
	public void deleteShot(int x){
		shots[x]=null;
		repaint();
	}
	public Shot[] getShots(){
		return shots;
	}
	
	
	
	
	public void paint(Graphics grafica){
		super.paint(grafica);
		Graphics2D g= (Graphics2D) grafica;
		g.drawImage(map.getPlay().getPlayer().getGraphic().getImagen(), map.getPlay().getPlayer().getGraphic().getX(), map.getPlay().getPlayer().getGraphic().getY(), null);
		for(int n=0;n<shots.length;n++){
			if(shots[n]!=null){
				g.drawImage(shots[n].getGraphic().getImagen(),shots[n].getGraphic().getX(),shots[n].getGraphic().getY(),null);
			}
		}
		for(int j=0;j<map.getEnemies().length;j++){
			if(map.getEnemies()[j]!=null){
				g.drawImage(map.getEnemies()[j].getGraphic().getImagen(), map.getEnemies()[j].getGraphic().getX(), map.getEnemies()[j].getGraphic().getY(), null);
			}
		}
		for(int i=0;i<map.getMap().length;i++){
			for(int j=0;j<map.getMap().length;j++){
				if(map.getMap()[i][j]!=null){
					g.drawImage(map.getMap()[i][j].getGraphic().getImagen(), map.getMap()[i][j].getGraphic().getX(), map.getMap()[i][j].getGraphic().getY(), null);
				}
			}
		}
	}
	private class Teclado extends KeyAdapter{
		public void keyReleased(KeyEvent e){
			map.getPlay().getPlayer().keyReleased(e);
		}
		public void keyPressed(KeyEvent e){
			map.getPlay().getPlayer().keyPressed(e);
			repaint();
		}
	}
}
