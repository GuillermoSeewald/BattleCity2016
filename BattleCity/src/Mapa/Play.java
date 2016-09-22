package Mapa;

import Tanque.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		panelDetalles.setBackground(Color.WHITE);
		panelDetalles.setLayout(new GridLayout(10,1));
		
		OyenteBoton oyBot= new OyenteBoton();
		boton= new JButton("Set enemy");
		boton.addActionListener(oyBot);
		
		etiquetaPuntos = new JLabel();
		etiquetaPuntos.setText("Etiqueta");
		
		panelDetalles.add(boton);
		panelDetalles.add(new JPanel());
		panelDetalles.add(etiquetaPuntos);
	}
	
	private class OyenteBoton implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
}