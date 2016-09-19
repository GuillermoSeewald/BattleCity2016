import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

public class Dibujar extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	private Tanque tanque;
	private Timer timer;
	
	public Dibujar(){
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(new Teclado());
		
		tanque= new Tanque();
		timer= new Timer(15,this);
		timer.start();
	}
	
	public void paint(Graphics grafica){
		super.paint(grafica);
		Graphics2D g= (Graphics2D) grafica;
		g.drawImage(tanque.getImagen(), tanque.getX(), tanque.getY(), null);
	}
	
	private class Teclado extends KeyAdapter{
		public void keyReleased(KeyEvent e){
			tanque.keyReleased(e);
		}
		public void keyPressed(KeyEvent e){
			tanque.keyPressed(e);
		}
	}

	public void actionPerformed(ActionEvent e) {
		tanque.mover();
		repaint();
	}
}