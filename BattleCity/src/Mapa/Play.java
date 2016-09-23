package Mapa;

import Tanque.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Random;

public class Play extends JFrame{
	private static final long serialVersionUID = 1L;
	
	protected Map map;
	protected Player player;
	protected int cantEnemyDead;
	protected JPanel panelDetalles;
	protected JButton[] botones;
	protected JLabel[] etiquetasEnemigos;
	protected JLabel etiquetaPuntos;
	
	public Play(String m){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		player= new Player(null);
		map= new Map(m, this, player);
		player.setMap(map);
		cantEnemyDead=0;
		armarPanelDetalles();
		
		setTitle("Battle City");
		setSize(map.getWidth()+panelDetalles.getWidth(),map.getHeight());
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		
		add(map, BorderLayout.CENTER);
		add(panelDetalles, BorderLayout.EAST);
	}
	public void setPlayer(){
	}
	public void incrementEnemyDead(){
		cantEnemyDead++;
	}
	public void createEnemy(){
	}
	public Player getPlayer(){
		return player;
	}
	public int getCantEnemyDead(){
		return cantEnemyDead;
	}
	public Map getMap(){
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void armarPanelDetalles(){
		panelDetalles= new JPanel();
		panelDetalles.setSize(200,707);
		panelDetalles.setBackground(Color.BLACK);
		panelDetalles.setLayout(new BorderLayout());

		JPanel aux2= new JPanel();aux2.setLayout(new GridLayout(3,1));
		botones= new JButton[3];
		OyenteBoton oyBot= new OyenteBoton();
		String[] s={"Set Enemy", "Delete Enemy", "Delete obstacle"};
		for(int i=0;i<botones.length;i++){
			botones[i]=new JButton(s[i]);
			botones[i].addActionListener(oyBot);
			aux2.add(botones[i]);
		}
		
		JPanel aux= new JPanel();
		etiquetasEnemigos= new JLabel[20];
		
		createAuxiliarPanel(aux);
		
		etiquetaPuntos= new JLabel();
		
		panelDetalles.add(aux2, BorderLayout.NORTH);
		panelDetalles.add(aux, BorderLayout.CENTER);
		panelDetalles.add(etiquetaPuntos, BorderLayout.SOUTH);
	}
	
	
	
	private void createAuxiliarPanel(JPanel aux){

		JPanel aux2= new JPanel();
		JPanel aux3= new JPanel();
		aux3.setBackground(Color.BLACK);
		aux.setLayout(new GridLayout(20,2));
		aux.setBackground(Color.BLACK);
		
		aux.add(aux3);aux3=new JPanel();aux3.setBackground(Color.BLACK);
		aux.add(aux3);aux3=new JPanel();aux3.setBackground(Color.BLACK);
		aux.add(aux3);aux3=new JPanel();aux3.setBackground(Color.BLACK);
		aux.add(aux3);
		int variable=0;
		for(int i=0;i<etiquetasEnemigos.length;i++){
			aux2= new JPanel();
			aux2.setLayout(new GridLayout(1,2));
			aux3=new JPanel();
			aux3.setBackground(Color.BLACK);
			aux2.add(aux3);
			aux3=new JPanel();
			etiquetasEnemigos[i]= new JLabel();
			etiquetasEnemigos[i].setIcon(new ImageIcon("Imagenes/EnemyToCreate.png"));
			if(variable==0){
				aux3.setBackground(Color.RED);
			}
			else{
				aux3.setBackground(Color.PINK);
			}
			aux3.add(etiquetasEnemigos[i]);
			aux2.add(aux3);
			aux.add(aux2);
			i++;
			aux2=new JPanel();
			aux2.setLayout(new GridLayout(1,2));
			aux3=new JPanel();
			etiquetasEnemigos[i]= new JLabel();
			etiquetasEnemigos[i].setIcon(new ImageIcon("Imagenes/EnemyToCreate.png"));
			if(variable==0){
				aux3.setBackground(Color.PINK);
				variable=1;
			}
			else{
				aux3.setBackground(Color.RED);
				variable=0;
			}
			aux3.add(etiquetasEnemigos[i]);
			aux2.add(aux3);
			aux3= new JPanel();
			aux3.setBackground(Color.BLACK);
			aux2.add(aux3);
			aux.add(aux2);			
		}
	}
	
	private class OyenteBoton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s= e.getActionCommand();
			Random r= new Random();
			int x= r.nextInt(4);
			int y= r.nextInt(13);
			if((botones[0].getName()==s)||(botones[0].getText()==s)){
				if(cantEnemyDead<etiquetasEnemigos.length){
					if(map.insertEnemy()){
						etiquetasEnemigos[etiquetasEnemigos.length-cantEnemyDead-1].setIcon(null);
						incrementEnemyDead();
						}
				}
			}
			else{
				if((botones[1].getName()==s)||(botones[1].getText()==s)){
					boolean vacio=true;
					Enemy[] ene= map.getEnemies();
					for(int i=0;(i<ene.length)&&(vacio);i++){
						if(ene[i]!=null)
							vacio=false;
					}
					if(!vacio){
						while(ene[x]==null){
							x=r.nextInt(4);
						}
						map.deleteEnemy(x);
					}
					etiquetaPuntos.setForeground(Color.GREEN);
					etiquetaPuntos.setText("Puntos jugador: "+player.getPuntos());
				}
			}
		}
	}
}