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
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import controlador.PacienteDAO;
import modelos.Paciente;

public class VentanasABCC extends JFrame{
	
	JMenuBar menuBar;
	JMenu menuABCC, menuTablas;
	JMenuItem menuAltas, menuBajas, menuCambios, menuConsultas, menuSalir, menuPacientes, menuDoctores;
	JInternalFrame IF_Altas, IF_Bajas, IF_Cambios ,IF_Consultas, IFT_Pacientes, IF_Salir;
	JComboBox<String> comboBoxEdad, comboBoxSexo, comboBoxGravedad; 
	JTextField cajaNombre_Paciente, cajaApPaterno_Paciente, cajaApMaterno_Paciente, cajaCalle, 
	cajaTelefono_Paciente, cajaColonia, cajaNumero, cajaID; 
	JLabel txtNombre, txtApPaterno, txtApMaterno, txtDomicilio, txtTelefono, txtMotivoConsulta, txtEdad, txtSexo,
	txtCalle, txtColonia, txtNumero, txtGravedad, txtID;  
	JButton botonRegistrar, botonRestablecer, botonEliminar; 
	
	JTable mitabla1, miTabla2;
	JScrollPane mibarra1, miBarra2;
	
	
	private void mostrarDatosConTableModel() {
		DefaultTableModel model;
		model = new DefaultTableModel();
		miTabla2 = new JTable();
		miTabla2.setModel(model);
		model.addColumn("ID Paciente");
		model.addColumn("Nombre");
		model.addColumn("Apellido Paterno");
		model.addColumn("Apellido Materno");
		model.addColumn("Teléfono Celular");
		model.addColumn("Edad");
		model.addColumn("Sexo");
		model.addColumn("Gravedad");
		model.addColumn("Calle");
		model.addColumn("Colonia");
		model.addColumn("Numero");

		miTabla2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		miTabla2.getTableHeader().setReorderingAllowed(false);

		PacienteDAO miPersonaDao2 = new PacienteDAO();
		
		miPersonaDao2.buscarUsuariosConTableModel(model);
		miBarra2.setViewportView(miTabla2);

	}
	
	
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
		menuDoctores = new JMenuItem("DOCTORES");
		menuPacientes = new JMenuItem("TABLA - PACIENTES");
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
		menuPacientes.setAccelerator(
				KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
					menuPacientes.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							IFT_Pacientes.setVisible(true);
						}
					});				
		
		
		menuABCC.add(menuAltas);
		menuABCC.add(menuBajas);
		menuABCC.add(menuCambios);
		menuABCC.add(menuConsultas);
		menuABCC.add(menuPacientes);
		menuABCC.add(menuDoctores); 
		//menuInicio.add(menuSalir); 
		menuBar.add(menuABCC);
		setJMenuBar(menuBar);
		
		JDesktopPane desktopPane = new JDesktopPane();	
		
		//-------------------------- INICIO INTERNALFRAME ALTAS -------------------------
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
		
		txtID = new JLabel("Crée un ID para el Paciente");
		txtID.setBounds(125, 375, 170, 30);
		IF_Altas.add(txtID); 
		cajaID = new JTextField(); 
		cajaID.setBounds(285, 373, 100, 30);
		IF_Altas.add(cajaID); 
		
		botonRegistrar = new JButton("REGISTRAR"); 
		botonRegistrar.setBounds(130, 430, 140, 30);
		botonRegistrar.setForeground(Color.black);
		botonRegistrar.setBackground(Color.green);
		botonRegistrar.setIcon(new ImageIcon("imagenes/verificacion.png"));
		IF_Altas.add(botonRegistrar);
		botonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cajaID.getText().equals("")||cajaNombre_Paciente.getText().equals("") || cajaApPaterno_Paciente.getText().equals("")|| cajaApMaterno_Paciente.getText().equals("")
						|| cajaTelefono_Paciente.getText().equals("") || comboBoxEdad.getSelectedIndex() == 0 || comboBoxSexo.getSelectedIndex()==0 || comboBoxGravedad.getSelectedIndex()==0
						|| cajaCalle.getText().equals("")||cajaColonia.getText().equals("")|| cajaNumero.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "LLENE TODOS LOS CAMPOS", "¡PSST!", JOptionPane.INFORMATION_MESSAGE);
				}else {
					try {
						boolean res = new PacienteDAO().agregarPaciente(new Paciente(Integer.parseInt(cajaID.getText()), cajaNombre_Paciente.getText(), cajaApPaterno_Paciente.getText(), 
								cajaApMaterno_Paciente.getText(), cajaNumero.getText(), 
								String.valueOf(comboBoxGravedad.getSelectedItem()), cajaCalle.getText(), 
								cajaColonia.getText(), cajaNumero.getText(), 
								String.valueOf(comboBoxSexo.getSelectedItem()), comboBoxEdad.getSelectedIndex()));
						JOptionPane.showMessageDialog(getParent(), "SE REGISTRÓ CORRECTAMENTE", "¡ÉXITO!", JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(getParent(), "LLENE LOS DATOS", "AVISO", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		botonRestablecer = new JButton("REESTABLECER"); 
		botonRestablecer.setBounds(400, 430, 160, 30);
		botonRestablecer.setForeground(Color.black);
		botonRestablecer.setBackground(Color.red);
		botonRestablecer.setIcon(new ImageIcon("imagenes/restablecer.png"));
		IF_Altas.add(botonRestablecer); 
		botonRestablecer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cajaNombre_Paciente.getText().equals("") && cajaApPaterno_Paciente.getText().equals("")&& cajaApMaterno_Paciente.getText().equals("")
						&& cajaTelefono_Paciente.getText().equals("") && comboBoxEdad.getSelectedIndex() == 0 && comboBoxSexo.getSelectedIndex()==0 && comboBoxGravedad.getSelectedIndex()==0
						&& cajaCalle.getText().equals("")&&cajaColonia.getText().equals("")&& cajaNumero.getText().equals("") && cajaID.getText().equals("")) {
					JOptionPane.showMessageDialog(getParent(), "NO HAY NADA QUE REESTABLECER", "¡PSST!", JOptionPane.INFORMATION_MESSAGE);
				}else {
				cajaNombre_Paciente.setText(""); 
				cajaApPaterno_Paciente.setText("");
				cajaApMaterno_Paciente.setText(""); 
				cajaCalle.setText(""); 
				cajaTelefono_Paciente.setText(""); 
				cajaColonia.setText(""); 
				cajaNumero.setText(""); 
				cajaID.setText("");
				comboBoxEdad.setSelectedIndex(0);
				comboBoxGravedad.setSelectedIndex(0);
				comboBoxSexo.setSelectedIndex(0);
				}
				
			}
		});
		
		//-------------------------- FIN INTERNALFRAME ALTAS -------------------------
		
		//-------------------------- INICIO INTERNALFRAME BAJAS -------------------------
		
		IF_Bajas = new JInternalFrame();
		IF_Bajas.getContentPane().setLayout(null);
		IF_Bajas.setDefaultCloseOperation(HIDE_ON_CLOSE);
		IF_Bajas.setTitle("ELIMINAR PACIENTE");
		IF_Bajas.setSize(695, 537);
		IF_Bajas.setMaximizable(true);
		IF_Bajas.setIconifiable(true);
		IF_Bajas.setClosable(true);
		IF_Bajas.setResizable(true);
		IF_Bajas.setLayout(null);
		IF_Bajas.setBackground(Color.LIGHT_GRAY);
		
		
		JLabel label_txt3 = new JLabel();
		label_txt3.setIcon(new ImageIcon("imagenes/fondoBajas.png"));
		label_txt3.setBounds(0, 0, 695, 60);
		IF_Bajas.add(label_txt3);
		
		txtNombre = new JLabel("Nombre del Paciente");
		txtNombre.setBounds(8, 80, 200, 30);
		IF_Bajas.add(txtNombre);
		cajaNombre_Paciente = new JTextField();
		cajaNombre_Paciente.setBounds(145, 80, 125, 30);
		IF_Bajas.add(cajaNombre_Paciente);
		
		txtApPaterno = new JLabel("Apellido Paterno del Paciente");
		txtApPaterno.setBounds(330, 80, 200, 30);
		IF_Bajas.add(txtApPaterno);
		cajaApPaterno_Paciente = new JTextField();
		cajaApPaterno_Paciente.setBounds(520, 80, 125, 30);
		IF_Bajas.add(cajaApPaterno_Paciente);
		
		txtApMaterno = new JLabel("Apellido Materno del Paciente");
		txtApMaterno.setBounds(8, 150, 200, 30);
		IF_Bajas.add(txtApMaterno);
		cajaApMaterno_Paciente = new JTextField();
		cajaApMaterno_Paciente.setBounds(180, 150, 125, 30);
		IF_Bajas.add(cajaApMaterno_Paciente);
		
		txtNumero = new JLabel("Telefono/Celular");
		txtNumero.setBounds(330, 150 ,125, 30);
		IF_Bajas.add(txtNumero); 
		cajaTelefono_Paciente = new JTextField(); 
		cajaTelefono_Paciente.setBounds(430, 150, 125, 30);
		IF_Bajas.add(cajaTelefono_Paciente); 
		

		
		txtEdad = new JLabel("Edad");
		txtEdad.setBounds(8, 215, 50, 30);
		IF_Altas.add(txtEdad); 
		comboBoxEdad = new JComboBox<>();
		comboBoxEdad.setBounds(60, 215, 80, 30);
		for (int i = 0; i < 101; i++) {
			comboBoxEdad.addItem(""+i);
		}
		IF_Bajas.add(comboBoxEdad);
		
		txtEdad = new JLabel("Sexo");
		txtEdad.setBounds(160, 215, 30, 30);
		IF_Bajas.add(txtEdad); 
		String sexo2[] = {"Seleccione el Sexo...", "Masculino", "Femenino"}; 
		comboBoxSexo = new JComboBox<>(sexo2);
		comboBoxSexo.setBounds(200, 215, 150, 30);
		IF_Bajas.add(comboBoxSexo); 
		
		txtGravedad = new JLabel("Gravedad");
		txtGravedad.setBounds(380, 215, 80, 30);
		IF_Bajas.add(txtGravedad); 
		String gravedad2[] = {"Seleccione la gravedad...", "Baja", "Media", "Alta"}; 
		comboBoxGravedad= new JComboBox<>(gravedad2);
		comboBoxGravedad.setBounds(445, 215, 170, 30);
		IF_Bajas.add(comboBoxGravedad); 
		
		txtDomicilio = new JLabel(" < =================== DATOS DEL DOMICILIO DEL PACIENTE =================== > ");
		txtDomicilio.setBounds(80, 280, 600, 30);
		IF_Bajas.add(txtDomicilio); 
		
		txtCalle = new JLabel("Calle");
		txtCalle.setBounds(20, 330, 50, 30);
		IF_Bajas.add(txtCalle); 
		cajaCalle = new JTextField();
		cajaCalle.setBounds(60, 330, 130, 30);
		IF_Bajas.add(cajaCalle);
		
		txtColonia = new JLabel("Colonia");
		txtColonia.setBounds(220, 330, 50, 30);
		IF_Bajas.add(txtColonia); 
		cajaColonia = new JTextField();
		cajaColonia.setBounds(270, 330, 130, 30);
		IF_Bajas.add(cajaColonia);
		
		txtNumero = new JLabel("Numero");
		txtNumero.setBounds(450, 330, 50, 30);
		IF_Bajas.add(txtNumero); 
		cajaNumero = new JTextField(); 
		cajaNumero.setBounds(500, 330, 100, 30);
		IF_Bajas.add(cajaNumero); 
		
		txtID = new JLabel("Crée un ID para el Paciente");
		txtID.setBounds(125, 375, 170, 30);
		IF_Bajas.add(txtID); 
		cajaID = new JTextField(); 
		cajaID.setBounds(285, 373, 100, 30);
		IF_Bajas.add(cajaID); 
		
		botonRegistrar = new JButton("REGISTRAR"); 
		botonRegistrar.setBounds(130, 430, 140, 30);
		botonRegistrar.setForeground(Color.black);
		botonRegistrar.setBackground(Color.green);
		botonRegistrar.setIcon(new ImageIcon("imagenes/verificacion.png"));
		IF_Bajas.add(botonRegistrar);
		
		
		
		//-------------------------- FIN INTERNALFRAME BAJAS -------------------------
		
		
		//-------------------------- INICIO INTERNALFRAME CAMBIOS -------------------------
		
		IF_Cambios = new JInternalFrame();
		IF_Cambios.getContentPane().setLayout(null);
		IF_Cambios.setDefaultCloseOperation(HIDE_ON_CLOSE);
		IF_Cambios.setTitle("MODIFICAR PACIENTE");
		IF_Cambios.setSize(695, 537);
		IF_Cambios.setMaximizable(true);
		IF_Cambios.setIconifiable(true);
		IF_Cambios.setClosable(true);
		IF_Cambios.setResizable(true);
		IF_Cambios.setLayout(null);
		IF_Cambios.setBackground(Color.LIGHT_GRAY);
		//-------------------------- INICIO INTERNALFRAME CAMBIOS -------------------------
		
		
		
		//-------------------------- INICIO INTERNALFRAME CONSULTAS -------------------------
		
		IF_Consultas = new JInternalFrame();
		IF_Consultas.getContentPane().setLayout(null);
		IF_Consultas.setDefaultCloseOperation(HIDE_ON_CLOSE);
		IF_Consultas.setTitle("BUSQUEDA DE PACIENTES");
		IF_Consultas.setSize(695, 537);
		IF_Consultas.setMaximizable(true);
		IF_Consultas.setIconifiable(true);
		IF_Consultas.setClosable(true);
		IF_Consultas.setResizable(true);
		IF_Consultas.setLayout(null);
		IF_Consultas.setBackground(Color.LIGHT_GRAY);
		
		
		//-------------------------- FIN INTERNALFRAME CONSULTAS -------------------------
		
		
		
		//TABLAS DE LOS PACIENTES ======================================================= //
		IFT_Pacientes = new JInternalFrame();
		IFT_Pacientes.getContentPane().setLayout(null);
		IFT_Pacientes.setDefaultCloseOperation(HIDE_ON_CLOSE);
		IFT_Pacientes.setTitle("BASE DE DATOS DE LOS PACIENTES");
		IFT_Pacientes.setSize(695, 537);
		IFT_Pacientes.setMaximizable(true);
		IFT_Pacientes.setIconifiable(true);
		IFT_Pacientes.setClosable(true);
		IFT_Pacientes.setResizable(true);
		IFT_Pacientes.setLayout(null);
		IFT_Pacientes.setBackground(Color.DARK_GRAY);
		miBarra2 = new JScrollPane(); 
		miBarra2.setBounds(0, 150, 685, 150);
		IFT_Pacientes.add(miBarra2);
		mostrarDatosConTableModel();
		JLabel label_txt2 = new JLabel();
		label_txt2.setIcon(new ImageIcon("imagenes/fondoTablaPacientes.jpg"));
		label_txt2.setBounds(0, 0, 945, 120);
		IFT_Pacientes.add(label_txt2);
		
		
		
		
		desktopPane.add(IF_Altas);
		desktopPane.add(IF_Bajas);
		desktopPane.add(IF_Cambios); 
		desktopPane.add(IF_Consultas);
		desktopPane.add(IFT_Pacientes);
		
		
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
