package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class VentanasABCC extends JFrame {
	JMenuBar menuBar;
	JMenu menuInicio;
	JMenuItem menuAltas, menuBajas, menuCambios, menuConsultas, menuSalir;
	JInternalFrame IF_Altas, IF_Bajas, IF_Cambios ,IF_Consultas, IF_Salir;
	public VentanasABCC() {
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("ABCC");
		setSize(600, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		
		menuBar = new JMenuBar(); 
		menuInicio = new JMenu("ACCESOS");
		menuAltas = new JMenuItem("ALTAS");
		menuBajas = new JMenuItem("BAJAS"); 
		menuCambios = new JMenuItem("CAMBIOS");
		menuConsultas = new JMenuItem("CONSULTAS");
		menuSalir = new JMenuItem("CERRAR SESIÓN");
		menuAltas.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
					menuAltas.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							IF_Altas.setVisible(true);
						}
					});
		menuBajas.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
					menuBajas.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							IF_Bajas.setVisible(true);
						}
					});	
					
					
		menuCambios.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
					menuCambios.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							IF_Cambios.setVisible(true);
						}
					});
		menuConsultas.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
					menuConsultas.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							IF_Consultas.setVisible(true);
						}
					});	
					
		menuSalir.setAccelerator(null);
					menuSalir.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							IF_Salir.setVisible(true);
						}
					});	
					
		menuInicio.add(menuAltas);
		menuInicio.add(menuBajas);
		menuInicio.add(menuCambios);
		menuInicio.add(menuConsultas);
		menuInicio.add(menuSalir); 
		menuBar.add(menuInicio);
		setJMenuBar(menuBar);
		
		
	}//Constructor

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanasABCC(); 
			}
		});

	}//main
}//class
