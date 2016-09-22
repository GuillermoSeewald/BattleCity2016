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
	protected JButton boton;
	protected JLabel[] etiquetasEnemigos;
	
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
		
		OyenteBoton oyBot= new OyenteBoton();
		boton= new JButton("Set enemy");
		boton.addActionListener(oyBot);
		panelDetalles.add(new JPanel());
		
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
		
		panelDetalles.add(boton, BorderLayout.NORTH);
		panelDetalles.add(aux, BorderLayout.CENTER);
	}
	
	private class OyenteBoton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(cantEnemyDead<etiquetasEnemigos.length){
				if(map.insertEnemy()){
					etiquetasEnemigos[etiquetasEnemigos.length-cantEnemyDead-1].setIcon(null);
					cantEnemyDead++;
				}
			}
		}
	}
}