package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	JComboBox<String> comboBoxEdad, comboBoxSexo, comboBoxGravedad; 
	JTextField cajaNombre_Paciente, cajaApPaterno_Paciente, cajaApMaterno_Paciente, cajaCalle, 
	cajaTelefono_Paciente, cajaRiesgo, cajaColonia, cajaNumero; 
	JLabel txtNombre, txtApPaterno, txtApMaterno, txtDomicilio, txtTelefono, txtMotivoConsulta, txtEdad, txtSexo,
	txtCalle, txtColonia, txtNumero, txtGravedad ;  
	JButton botonRegistrar, botonRestablecer; 
	
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
		IF_Altas.setTitle("REGISTRAR PACIENTE");
		IF_Altas.setSize(695, 537);
		IF_Altas.setMaximizable(true);
		IF_Altas.setIconifiable(true);
		IF_Altas.setClosable(true);
		IF_Altas.setResizable(true);
		IF_Altas.setLayout(null);
		IF_Altas.setBackground(Color.LIGHT_GRAY);
		
		
		JLabel label_txt = new JLabel();
		label_txt.setIcon(new ImageIcon("imagenes/fondoAltas.png"));
		label_txt.setBounds(0, 0, 695, 60);
		IF_Altas.add(label_txt);
		
		txtNombre = new JLabel("Nombre del Paciente");
		txtNombre.setBounds(8, 80, 200, 30);
		IF_Altas.add(txtNombre);
		cajaNombre_Paciente = new JTextField();
		cajaNombre_Paciente.setBounds(145, 80, 125, 30);
		IF_Altas.add(cajaNombre_Paciente);
		
		txtApPaterno = new JLabel("Apellido Paterno del Paciente");
		txtApPaterno.setBounds(330, 80, 200, 30);
		IF_Altas.add(txtApPaterno);
		cajaApPaterno_Paciente = new JTextField();
		cajaApPaterno_Paciente.setBounds(520, 80, 125, 30);
		IF_Altas.add(cajaApPaterno_Paciente);
		
		txtApMaterno = new JLabel("Apellido Materno del Paciente");
		txtApMaterno.setBounds(8, 150, 200, 30);
		IF_Altas.add(txtApMaterno);
		cajaApMaterno_Paciente = new JTextField();
		cajaApMaterno_Paciente.setBounds(180, 150, 125, 30);
		IF_Altas.add(cajaApMaterno_Paciente);
		
		txtNumero = new JLabel("Telefono/Celular");
		txtNumero.setBounds(330, 150 ,125, 30);
		IF_Altas.add(txtNumero); 
		cajaTelefono_Paciente = new JTextField(); 
		cajaTelefono_Paciente.setBounds(430, 150, 125, 30);
		IF_Altas.add(cajaTelefono_Paciente); 
		

		
		txtEdad = new JLabel("Edad");
		txtEdad.setBounds(8, 215, 50, 30);
		IF_Altas.add(txtEdad); 
		comboBoxEdad = new JComboBox<>();
		comboBoxEdad.setBounds(60, 215, 80, 30);
		for (int i = 0; i < 101; i++) {
			comboBoxEdad.addItem(""+i);
		}
		IF_Altas.add(comboBoxEdad);
		
		txtEdad = new JLabel("Sexo");
		txtEdad.setBounds(160, 215, 30, 30);
		IF_Altas.add(txtEdad); 
		String sexo[] = {"Seleccione el Sexo...", "Masculino", "Femenino"}; 
		comboBoxSexo = new JComboBox<>(sexo);
		comboBoxSexo.setBounds(200, 215, 150, 30);
		IF_Altas.add(comboBoxSexo); 
		
		txtGravedad = new JLabel("Gravedad");
		txtGravedad.setBounds(380, 215, 80, 30);
		IF_Altas.add(txtGravedad); 
		String gravedad[] = {"Seleccione la gravedad...", "Baja", "Media", "Alta"}; 
		comboBoxGravedad= new JComboBox<>(gravedad);
		comboBoxGravedad.setBounds(445, 215, 170, 30);
		IF_Altas.add(comboBoxGravedad); 
		
		txtDomicilio = new JLabel(" < =================== DATOS DEL DOMICILIO DEL PACIENTE =================== > ");
		txtDomicilio.setBounds(80, 280, 600, 30);
		IF_Altas.add(txtDomicilio); 
		
		txtCalle = new JLabel("Calle");
		txtCalle.setBounds(20, 330, 50, 30);
		IF_Altas.add(txtCalle); 
		cajaCalle = new JTextField();
		cajaCalle.setBounds(60, 330, 130, 30);
		IF_Altas.add(cajaCalle);
		
		txtColonia = new JLabel("Colonia");
		txtColonia.setBounds(220, 330, 50, 30);
		IF_Altas.add(txtColonia); 
		cajaColonia = new JTextField();
		cajaColonia.setBounds(270, 330, 130, 30);
		IF_Altas.add(cajaColonia);
		
		txtNumero = new JLabel("Numero");
		txtNumero.setBounds(450, 330, 50, 30);
		IF_Altas.add(txtNumero); 
		cajaNumero = new JTextField(); 
		cajaNumero.setBounds(500, 330, 100, 30);
		IF_Altas.add(cajaNumero); 
		
		botonRegistrar = new JButton("REGISTRAR"); 
		botonRegistrar.setBounds(130, 430, 140, 30);
		botonRegistrar.setForeground(Color.black);
		botonRegistrar.setBackground(Color.green);
		botonRegistrar.setIcon(new ImageIcon("imagenes/verificacion.png"));
		IF_Altas.add(botonRegistrar); 
		
		botonRestablecer = new JButton("REESTABLECER"); 
		botonRestablecer.setBounds(400, 430, 160, 30);
		botonRestablecer.setForeground(Color.black);
		botonRestablecer.setBackground(Color.red);
		botonRestablecer.setIcon(new ImageIcon("imagenes/restablecer.png"));
		IF_Altas.add(botonRestablecer); 
		
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
