package Mapa;

import javax.swing.WindowConstants;

public class Interfaz {

	public static void main(String[] args) {
		Ventana ventana = new Ventana("Battle City","Mapas/Mapa 2.txt");
		ventana.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		ventana.pack();
		ventana.setSize(676, 676);
		ventana.setVisible(true);
	}
}