package Mapa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.util.Iterator;

import Lista.*;
import Obstaculo.*;

public class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private Mapa mapa;
	private JPanel panelUno;
	private JLabel[][] etiqueta;
	
	Ventana(String nom, String map){
		super(nom);
		
		this.setLayout(new BorderLayout());
		
		
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
		String nombre;
		int contador=0;
		for(ListaSimplementeEnlazada<Celda> l: mapa.retornarMapa()){
			it=l.iterator();
			while(it.hasNext()){
				etiqueta[fila][columna]= new JLabel();
				etiqueta[fila][columna].setSize(26,26);
				nombre=it.next().getNombre();
				if(nombre.equals("bandera")){
					etiqueta[fila][columna].setIcon(new ImageIcon("Imagenes/"+nombre+""+contador+".jpg"));
					contador++;
				}
				else{
					etiqueta[fila][columna].setIcon(new ImageIcon("Imagenes/"+nombre+".png"));;
				}
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
}