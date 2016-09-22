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
		
		botones= new JButton[2];
		OyenteBoton oyBot= new OyenteBoton();
		botones[0]= new JButton("Set enemy");
		botones[0].addActionListener(oyBot);
		botones[1]= new JButton("Delete enemy");
		botones[1].addActionListener(oyBot);
		
		JPanel aux= new JPanel();
		JPanel aux2= new JPanel();
		JPanel aux3= new JPanel();
		JPanel aux4= new JPanel();
		aux4.setBackground(Color.BLACK);
		aux.setLayout(new GridLayout(20,2));
		aux.setBackground(Color.BLACK);
		
		aux.add(aux4);aux4=new JPanel();aux4.setBackground(Color.BLACK);
		aux.add(aux4);aux4=new JPanel();aux4.setBackground(Color.BLACK);
		aux.add(aux4);aux4=new JPanel();aux4.setBackground(Color.BLACK);
		aux.add(aux4);aux4=new JPanel();aux4.setBackground(Color.BLACK);
		
		etiquetasEnemigos= new JLabel[20];
		int variable=0;
		for(int i=0;i<etiquetasEnemigos.length;i++){
			aux2= new JPanel();
			aux2.setLayout(new GridLayout(1,2));
			aux4=new JPanel();
			aux4.setBackground(Color.BLACK);
			aux2.add(aux4);
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
			aux4= new JPanel();
			aux4.setBackground(Color.BLACK);
			aux2.add(aux4);
			aux.add(aux2);			
		}
		
		etiquetaPuntos= new JLabel();
		
		aux2= new JPanel();	aux2.setLayout(new GridLayout(2,1));
		aux2.add(botones[0]);aux2.add(botones[1]);
		panelDetalles.add(aux2, BorderLayout.NORTH);
		panelDetalles.add(aux, BorderLayout.CENTER);
		panelDetalles.add(etiquetaPuntos, BorderLayout.SOUTH);
	}
	
	private class OyenteBoton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s= e.getActionCommand();
			if((botones[0].getName()==s)||(botones[0].getText()==s)){
				if(cantEnemyDead<etiquetasEnemigos.length){
					if(map.insertEnemy()){
						etiquetasEnemigos[etiquetasEnemigos.length-cantEnemyDead-1].setIcon(null);
						incrementEnemyDead();
						}
				}
			}
			else{
				map.deleteEnemy();
				etiquetaPuntos.setForeground(Color.GREEN);
				etiquetaPuntos.setText("Puntos jugador: "+player.getPuntos());
			}
		}
	}
}