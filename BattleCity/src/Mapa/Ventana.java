package Mapa;

import javax.swing.JFrame;
public class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public Ventana(String mapa){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Mapa(mapa));
		setTitle("Battle City");
		setSize(850,707);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}