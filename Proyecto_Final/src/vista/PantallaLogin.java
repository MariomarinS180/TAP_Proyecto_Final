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

import javax.swing.border.Border;
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
	ImageIcon imagen;
	Icon icono;
	JLabel label_usuario, label_contraseña;
	JTextField caja_usuario, caja_contraseña; 
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
	
	label_contraseña = new JLabel("Ingrese la Contraseña"); 
	label_contraseña.setBounds(185, 155, 150, 30);
	add(label_contraseña);
	caja_contraseña = new JTextField(); 
	caja_contraseña.setBounds(175, 185, 150, 20);
	add(caja_contraseña); 
	
	//BOTON ACCEDER
	boton_acceder = new JButton("ACCEDER"); 
	boton_acceder.setBounds(140, 230, 100, 30);
	add(boton_acceder); 
	boton_acceder.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//VALIDACION CAJA VACIA	
			if (caja_usuario.getText().equals("") || caja_contraseña.getText().equals("")) {
			JOptionPane.showMessageDialog(getParent(), "DEBE LLENAR LOS DATOS", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
			
			}
		}
	});
	
	boton_crear = new JButton("REGISTRAR"); 
	boton_crear.setBounds(260, 230, 100, 30);
	add(boton_crear); 
	boton_crear.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (caja_usuario.getText().equals("") || caja_contraseña.getText().equals("")) {
			JOptionPane.showMessageDialog(getParent(), "DEBE LLENAR LOS DATOS", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
				
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
			caja_contraseña.setText("");
			caja_usuario.setText("");
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
