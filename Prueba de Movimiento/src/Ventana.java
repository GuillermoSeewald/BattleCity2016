import javax.swing.JFrame;
public class VentanaAux extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public VentanaAux(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Dibujar());
		setTitle("Battle City");
		setSize(800,600);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	public static void main(String args){
		new VentanaAux();
	}
}