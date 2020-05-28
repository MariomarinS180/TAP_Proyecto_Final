package vista;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.border.Border;
 
/**
 * @author DiscoDurodeRoer
 */
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
	JLabel imagenLogin; 
	public PantallaLogin() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("INICIO");
		setSize(500,300);
		setLocationRelativeTo(null);
		setVisible(true);	
		try {
            FondoSwing fondo = new FondoSwing(ImageIO.read(new File("imagenes/fondo.png")));
            JPanel panel = (JPanel) this.getContentPane();
            panel.setBorder(fondo);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
		
		
		imagenLogin = new JLabel();
		imagenLogin.setBounds(250, 150, 100, 100);
		imagenLogin.setIcon(new ImageIcon());
		add(imagenLogin); 
	
		
		
		
		
		
		
		
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
