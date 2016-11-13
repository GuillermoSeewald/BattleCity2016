package Graphic.Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InformationButtons extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JButton goBackMenu, goBackInstructions;
	private JPanel panelButton, panelImage;
	
	public InformationButtons(String s){
		setTitle("Battle city");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,700);
		setLocationRelativeTo(null);
		setResizable(false);
		
		panelImage(s);
		panelButton();
		this.setLayout(new BorderLayout());
		add(panelImage, BorderLayout.CENTER);
		add(panelButton, BorderLayout.SOUTH);
	}
	private void panelImage(String s){
		panelImage= new JPanel();
		panelImage.setBackground(Color.BLACK);
		
		JLabel etiqueta1= new JLabel();
		etiqueta1.setIcon(new ImageIcon("Imagenes/Battle City.png"));
		JLabel etiqueta2= new JLabel();
		etiqueta2.setIcon(new ImageIcon("Imagenes/"+s+".png"));
		
		panelImage.add(etiqueta1);
		panelImage.add(etiqueta2);
	}
	private void panelButton(){
		panelButton= new JPanel();
		panelButton.setBackground(Color.BLACK);
		panelButton.setLayout(new BorderLayout());
		
		OyenteGoBackMenu oyM= new OyenteGoBackMenu();
		goBackMenu= new JButton("Menu principal");
		goBackMenu.addActionListener(oyM);
		goBackMenu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		goBackMenu.setPreferredSize(new Dimension(150,50));
		goBackMenu.setFocusable(false);
		
		OyenteGoBackInstructions oyI= new OyenteGoBackInstructions();
		goBackInstructions= new JButton("Información");
		goBackInstructions.addActionListener(oyI);
		goBackInstructions.setFont(new Font("Times New Roman", Font.BOLD, 14));
		goBackInstructions.setPreferredSize(new Dimension(150,50));
		goBackInstructions.setFocusable(false);

		panelButton.add(goBackMenu, BorderLayout.WEST);
		panelButton.add(goBackInstructions, BorderLayout.EAST);
	}
	private class OyenteGoBackMenu implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new InitialFrame().setVisible(true);
			dispose();
		}
	}
	private class OyenteGoBackInstructions implements ActionListener{
		public void actionPerformed(ActionEvent e){
			new InstructionPanel().setVisible(true);
			dispose();
		}
	}
}