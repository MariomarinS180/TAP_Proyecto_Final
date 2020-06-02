package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class VentanasABCC extends JFrame{
	JMenuBar menuBar;
	JMenu menuABCC, menuTablas;
	JMenuItem menuAltas, menuBajas, menuCambios, menuConsultas, menuSalir, menuPacientes, menuDoctores;
	JInternalFrame IF_Altas, IF_Bajas, IF_Cambios ,IF_Consultas, IF_Salir;
	JTextField cajaNombre_Paciente, cajaApPaterno_Paciente, cajaApMaterno_Paciente, cajaDomicilio_Paciente,
	cajaTelefono_Paciente, cajaMotivoConsulta; 
	JLabel txtNombre, txtApPaterno, txtApMaterno, txtDomicilio, txtTelefono, txtMotivoConsulta, txtEdad, txtSexo; 
	
	public VentanasABCC() {
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("INICIO");
		setSize(710, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("imagenes/fondoBD.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
		
		menuBar = new JMenuBar(); 
		menuBar = new JMenuBar();
		menuTablas = new JMenu("TABLAS");
		menuDoctores = new JMenuItem("DOCTORES");
		menuPacientes = new JMenuItem("PACIENTES");
		menuABCC = new JMenu("ACCESOS");
		menuAltas = new JMenuItem("ALTAS");
		menuBajas = new JMenuItem("BAJAS"); 
		menuCambios = new JMenuItem("CAMBIOS");
		menuConsultas = new JMenuItem("CONSULTAS");
		//menuSalir = new JMenuItem("CERRAR SESIÓN");
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
					
		/*menuSalir.setAccelerator(null);
					menuSalir.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							IF_Salir.setVisible(true);
						}
					});	
		*/			
		menuABCC.add(menuAltas);
		menuABCC.add(menuBajas);
		menuABCC.add(menuCambios);
		menuABCC.add(menuConsultas);
		//menuInicio.add(menuSalir); 
		menuTablas.add(menuDoctores);
		menuTablas.add(menuPacientes);
		menuBar.add(menuTablas);
		menuBar.add(menuABCC);
		setJMenuBar(menuBar);
		
		JDesktopPane desktopPane = new JDesktopPane();
		
		IF_Altas = new JInternalFrame();
		IF_Altas.getContentPane().setLayout(null);
		IF_Altas.setDefaultCloseOperation(HIDE_ON_CLOSE);
		IF_Altas.setTitle("ALTAS");
		IF_Altas.setSize(695, 537);
		IF_Altas.setMaximizable(true);
		IF_Altas.setIconifiable(true);
		IF_Altas.setClosable(true);
		IF_Altas.setResizable(true);
		IF_Altas.setLayout(null);
		
		desktopPane.add(IF_Altas); 
		add(desktopPane, BorderLayout.CENTER);
		
		
		
		
		
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
