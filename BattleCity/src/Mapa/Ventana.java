package Mapa;

import java.awt.BorderLayout;
import java.awt.GridLayout;


import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Iterator;

import Lista.*;

public class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private Mapa mapa;
	private JButton[] botones;
	private JPanel panelUno, panelDos;
	private JLabel[][] etiqueta;
	private JLabel etiquetas;
	private String juego;
	
	Ventana(String nom, String map){
		super(nom);	
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					mover(arg0);
				} catch (IOException e) {
				}
			}
		});
			
		this.setLayout(new BorderLayout());
		juego=map;
		armarPanelUno(map);
		armarPanelDos();
		this.add(panelUno, BorderLayout.CENTER);
		this.add(panelDos, BorderLayout.EAST);
	}
	
	
/*	private void armarPanelUno(String map){
		mapa= new Mapa(map);
		panelUno= new JPanel();
		panelUno.setLayout(new GridLayout(mapa.getLongitud(),mapa.getLongitud()));
		etiqueta= new JLabel[mapa.getLongitud()][mapa.getLongitud()];
		Celda[][] celdas= mapa.retornarMap();
		for(int i=0;i<celdas.length;i++){
			for(int j=0;j<celdas.length;j++){
				etiqueta[j][i]= new JLabel();
				etiqueta[j][i].setSize(52,52);
				etiqueta[j][i].setIcon(celdas[j][i].getImagen());
			}
		}
		for(int i=0;i<etiqueta.length;i++){
			for(int j=0;j<etiqueta.length;j++){
				panelUno.add(etiqueta[i][j]);
			}
		}
	}
*/	
	private void armarPanelUno(String map){
		mapa= new Mapa(map);
		
		panelUno= new JPanel();
		panelUno.setLayout(new GridLayout(mapa.getLongitud(),mapa.getLongitud()));
		
		Iterator<Celda> it;
		etiqueta= new JLabel[mapa.getLongitud()][mapa.getLongitud()];
		int fila=0;int columna=0;
		ImageIcon imagen;
		for(ListaSimplementeEnlazada<Celda> l: mapa.retornarMapa()){
			it=l.iterator();
			while(it.hasNext()){
				etiqueta[fila][columna]= new JLabel();
				etiqueta[fila][columna].setSize(52,52);
				imagen=it.next().getImagen();
				etiqueta[fila][columna].setIcon(imagen);
				columna++;
			}
			columna=0;
			fila++;
		}
		for(int i=0;i<etiqueta.length;i++){
			for(int j=0;j<etiqueta.length;j++){
				panelUno.add(etiqueta[i][j]);
			}
		}
	}
	public void armarPanelDos(){
		panelDos= new JPanel();
		panelDos.setLayout(new GridLayout(5,1));
		
		etiquetas= new JLabel();
		etiquetas= new JLabel();
		etiquetas.setText("Posicion del tanque= X: "+mapa.getJugador().getX()+" / Y: "+mapa.getJugador().getY()+" / "+mapa.getJugador().getDireccion());
		panelDos.add(etiquetas);
		
		JPanel aux= new JPanel();
		aux.setLayout(new GridLayout(2,3));
		
		String[] palabras= {"arriba", "abajo", "izquierda", "derecha"};
		OyenteBotones oyBot= new OyenteBotones();
		botones= new JButton[4];
		for(int i=0;i<botones.length;i++){
			botones[i]= new JButton();
			botones[i].setText(palabras[i]);
			botones[i].setName(palabras[i]);
			botones[i].addActionListener(oyBot);
		}
		aux.add(new JPanel());aux.add(botones[0]);aux.add(new JPanel());aux.add(botones[2]);
		aux.add(botones[1]);aux.add(botones[3]);
		
		panelDos.add(new JPanel());
		panelDos.add(new JPanel());
		panelDos.add(aux);
		panelDos.add(new JPanel());
	}
	
	protected void mover(KeyEvent key) throws FileNotFoundException, IOException{
		mapa.mover(key.getKeyCode());
		mapa.cargarMapa(juego);
	}
	
	
	class OyenteBotones implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s= (String) e.getActionCommand();
			boolean encontre=false;int pos=0;
			for(int i=0;(i<botones.length)&&(!encontre);i++){
				if((botones[i].getName()==s)||(botones[i].getText()==s)){
					encontre=true;
					pos=i;
				}
			}
			mapa.getJugador().mover(pos);
			etiquetas.setText("Posicion del tanque= X: "+mapa.getJugador().getX()+" / Y: "+mapa.getJugador().getY()+" / "+mapa.getJugador().getDireccion());
			try {
				mapa.cargarMapa(juego);
			} catch (IOException e1) {
			}
			
		}
	}
}