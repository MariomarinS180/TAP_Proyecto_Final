package vista;

import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.border.Border;

import conectorBaseDeDatos.ConexionBD;
import controlador.InicioDeSesion;
import controlador.PacienteDAO;
/**
 * @author DiscoDurodeRoer
 */
class FondoSwing implements Border {
    private BufferedImage mImagen = null;
    public FondoSwing(BufferedImage pImagen) {
        mImagen = pImagen;       
    }
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (mImagen != null) {
            g.drawImage(mImagen, 0, 0, width, height, null);
        }
    }
    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }
    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
public class PantallaLogin extends JFrame {
	private ResultSet rs; 
	private PreparedStatement pst; 
	private Connection con; 
	ImageIcon imagen;
	Icon icono;
	JLabel label_usuario, label_contrase�a;
	JTextField caja_usuario, caja_contrase�a; 
	JButton boton_acceder, boton_crear, boton_Restablecer; 
	 

	
	public PantallaLogin() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("INICIO");
		setSize(500,370);
		setLocationRelativeTo(null);
		setVisible(true);	
		try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("imagenes/ImagenLoginFondo.jpg")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
		
	label_usuario = new JLabel("Ingrese el Usuario"); 
	label_usuario.setBounds(200, 105, 150, 30);
	add(label_usuario);
	caja_usuario = new JTextField(); 
	caja_usuario.setBounds(175, 130, 150, 20);
	add(caja_usuario); 
	
	label_contrase�a = new JLabel("Ingrese la Contrase�a"); 
	label_contrase�a.setBounds(185, 155, 150, 30);
	add(label_contrase�a);
	caja_contrase�a = new JTextField(); 
	caja_contrase�a.setBounds(175, 185, 150, 20);
	add(caja_contrase�a);
	
	//BOTON ACCEDER
	boton_acceder = new JButton("ACCEDER"); 
	boton_acceder.setBounds(140, 230, 100, 30);
	add(boton_acceder); 
	boton_acceder.setIcon(new ImageIcon("imagenes/Acceder.png"));
	boton_acceder.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String user = caja_usuario.getText(); 
			String pass = caja_usuario.getText();
			if(user.equals("")||pass.equals("")) {
				JOptionPane.showMessageDialog(getParent(), "DEBE INGRESAR LOS DATOS", "INICIO SESI�N", JOptionPane.CLOSED_OPTION);
		//	}else if (pass.equals("")){
		//		JOptionPane.showMessageDialog(getParent(), "DEBE INGRESAR SU CONTRASE�A", "INICIO SESI�N", JOptionPane.CLOSED_OPTION);
		//	}else if(user.equals("")) {
		//		JOptionPane.showMessageDialog(getParent(), "DEBE INGRESAR SU NOMBRE USUARIO", "INICIO SESI�N", JOptionPane.CLOSED_OPTION);
			}else {
				try {
					 con= ConexionBD.getConnection();
					 pst = con.prepareStatement("SELECT * FROM usuario WHERE user=? and pass=?");
					 pst.setString(1, user);
					 pst.setString(2, pass);
					 rs = pst.executeQuery();
			
					if(rs.next()) {
						VentanasABCC gui = new VentanasABCC(); 
						gui.setVisible(true);
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(getParent(), "DEBE REGISTRARSE", "FALLO AL INICIAR SESI�N", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					
				}
			}
		}
	});
	boton_crear = new JButton("REGISTRAR"); 
	boton_crear.setBounds(260, 230, 100, 30);
	add(boton_crear); 
	boton_crear.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (caja_usuario.getText().equals("") || caja_contrase�a.getText().equals("")) {
			JOptionPane.showMessageDialog(getParent(), "DEBE LLENAR LOS DATOS", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
			}else {
				try {
					boolean res = new PacienteDAO().agregarUsuario(new InicioDeSesion(caja_usuario.getText(), caja_contrase�a.getText()));
					JOptionPane.showMessageDialog(getParent(), "�SE REGISTR� CORRECTAMENTE!", "�EXITO!", JOptionPane.PLAIN_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(getParent(), "DEBE LLENAR LOS DATOS", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		}
	});
	
	//BOTON RESTABLECER
	JLabel lb1 = new JLabel("RESTABLECER");
	lb1.setBounds(210, 305, 100, 30);
	lb1.setForeground(Color.yellow);
	add(lb1); 
	boton_Restablecer = new JButton(); 
	boton_Restablecer.setBounds(230, 270, 40, 40);
	imagen = new ImageIcon("imagenes/botonActualizar.png");
	boton_Restablecer.setBackground(Color.blue);
	icono = new ImageIcon(imagen.getImage().getScaledInstance(boton_Restablecer.getWidth(), boton_Restablecer.getHeight(), Image.SCALE_DEFAULT));
	boton_Restablecer.setIcon(icono);
	add(boton_Restablecer); 
	boton_Restablecer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if (caja_contrase�a.getText().equals("") && caja_usuario.getText().equals("")) {
				JOptionPane.showMessageDialog(getParent(), "NO HAY NADA QUE RESTABLECER", "MENSAJE", JOptionPane.ERROR_MESSAGE);
			}else {
			caja_contrase�a.setText("");
			caja_usuario.setText("");
			}
		}
	});//BotonRestablecer
	
	
	}//Contrusctor PantallaLogin
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new PantallaLogin();
			}
		});
	}
}//Class PantallaLogin
