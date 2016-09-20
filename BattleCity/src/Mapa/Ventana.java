package Mapa;

import Tanque.*;
import javax.swing.JFrame;

public class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private Map mapa;
	private Player jugador;
	
	public Ventana(String m){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mapa= new Map(m);
		add(mapa);
		setTitle("Battle City");
		setSize(850,707);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}