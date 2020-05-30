package vista;

import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.border.Border;
/**
 * @author DiscoDurodeRoer
 */

class Prueba{
	
}



class FondoSwing implements Border {
    private BufferedImage mImagen = null;
    /**
     * Constructor, indicamos la imagen que queremos que se redimensione
     * @param pImagen ImageIO.read(new File(ruta imagen))
     */
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
	JLabel label_usuario, label_contraseña;
	JTextField caja_usuario, caja_contraseña; 
	JButton boton_acceder, boton_crear; 
	public PantallaLogin() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("INICIO");
		setSize(500,300);
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
	label_usuario.setBounds(200, 90, 150, 30);
	add(label_usuario);
	caja_usuario = new JTextField(); 
	caja_usuario.setBounds(175, 120, 150, 20);
	add(caja_usuario); 
	
	label_contraseña = new JLabel("Ingrese la Contraseña"); 
	label_contraseña.setBounds(185, 145, 150, 30);
	add(label_contraseña);
	caja_contraseña = new JTextField(); 
	caja_contraseña.setBounds(175, 175, 150, 20);
	add(caja_contraseña); 
	
	boton_acceder = new JButton("ACCEDER"); 
	boton_acceder.setBounds(140, 225, 100, 30);
	add(boton_acceder); 
	
	boton_crear = new JButton("REGISTRAR"); 
	boton_crear.setBounds(260, 225, 100, 30);
	add(boton_crear); 
	
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
