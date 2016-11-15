package Graphic.Frames;

import Logic.Map.Play;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class InitialFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JButton start, information;
	private JPanel panelImage, panelButton;
	
	public InitialFrame(){
		setTitle("Battle city");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,700);
		setLocationRelativeTo(null);
		setResizable(false);
		
		panelImage();
		panelButton();
		this.setLayout(new GridLayout(2,1));
		this.add(panelImage);
		this.add(panelButton);
	}
	
	private void panelImage(){
		panelImage= new JPanel();
		panelImage.setBackground(Color.BLACK);
		
		JLabel etiqueta= new JLabel();
		etiqueta.setIcon(new ImageIcon("Imagenes/Battle City.png"));
		
		panelImage.add(etiqueta);
	}
	private void panelButton(){
		panelButton= new JPanel();
		panelButton.setBackground(Color.BLACK);
		panelButton.setLayout(new GridLayout(6,3));
		
		OyenteStart oySta= new OyenteStart();
		start= new JButton("Jugar");
		start.addActionListener(oySta);
		start.setFocusable(false);
		start.setPreferredSize(new Dimension(100,50));
		start.setFont(new Font("Times New Roman", Font.BOLD, 14));
		start.setBorder(new LineBorder(Color.BLACK));
		
		OyenteInfo oyInfo= new OyenteInfo();
		information= new JButton("Información");
		information.addActionListener(oyInfo);
		information.setFocusable(false);
		information.setPreferredSize(new Dimension(100,50));
		information.setFont(new Font("Times New Roman", Font.BOLD, 14));
		information.setBorder(new LineBorder(Color.BLACK));

		JPanel s= new JPanel();
		s.setBackground(Color.BLACK);
		panelButton.add(s);
		panelButton.add(start);
		for(int i=0;i<2;i++){
			JPanel p= new JPanel();
			p.setBackground(Color.BLACK);
			panelButton.add(p);
		}
		panelButton.add(information);
		for(int i=0;i<10;i++){
			JPanel p= new JPanel();
			p.setBackground(Color.BLACK);
			panelButton.add(p);
		}
	}
	
	
	private class OyenteStart implements ActionListener{
		public void actionPerformed(ActionEvent e){
			start.setFocusable(false);
			information.setFocusable(false);
			new Play("Mapas/Mapa 3.txt");
			dispose();
		}
	}
	private class OyenteInfo implements ActionListener{
		public void actionPerformed(ActionEvent e){
			start.setFocusable(false);
			information.setFocusable(false);
			new InstructionPanel().setVisible(true);
			dispose();
		}
	}
}