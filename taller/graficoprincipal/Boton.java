package graficoprincipal;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

/**
 * @author Adriana Armental Tom�
 * @version 06.03.2017
 */
public class Boton extends JButton{

	int x, y;
	
	//Constructor forma rectangulo bordes curvos con un tamanho e colores dado
	public Boton(String rotulo, int x, int y) {
		super(rotulo);     
		this.x = x;		        
		this.y = y;	
		setContentAreaFilled(false); //que non se pinte o que "sobra"		    
	}

	@Override		    
	protected void paintComponent(Graphics g) {	
		//Colores para o gradiante
		Color blanco = new Color(255, 255, 255);
		Color negro = new Color(0, 0, 0);
		//Cambiar letra
		g.setFont(new Font("Lucida Sans", Font.BOLD, 26));
		//Gradiente 
		Graphics2D g2d=(Graphics2D)g;
		g2d.setPaint(new GradientPaint(500, 0, blanco, 200, 400, negro));		
		if (getModel().isArmed()) {	//si se pulsa cambiaselle o color       
			g.setColor(blanco);		       
		} 
		//pintase o boton
		g2d.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, x, y);
		super.paintComponent(g);	
	}
	
	//Sobreescritura del borde
	@Override
	protected void paintBorder(Graphics g) {
		g.setColor(Color.black);
		g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, x, y);	    
	}
}
