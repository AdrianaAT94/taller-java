package graficoprincipal;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */
public class PanelImagen extends JPanel {
	public PanelImagen(){
		this.setSize(1000,900);
	}
	@Override
	public void paintComponent (Graphics g){
		Dimension tamanio = getSize(); //Tamanho que se lle vai dar a imaxe(toda a ventana)
		//Collese a imagen
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/fondoprincipal.jpg"));
		//Debuxase na posicion asignada
		g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
		//Que non sea opaca
		setOpaque(false);
		super.paintComponent(g);
	}
}
