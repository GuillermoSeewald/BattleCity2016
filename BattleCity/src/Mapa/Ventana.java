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
	private JPanel panelUno;
	private JLabel[][] etiqueta;
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
		this.add(panelUno, BorderLayout.CENTER);
	}
	
	private void armarPanelUno(String map){
		mapa=new Mapa(map);
		
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
	
	protected void mover(KeyEvent key) throws FileNotFoundException, IOException{
		mapa.mover(key.getKeyCode());
		mapa.cargarMapa(juego);
	}
}