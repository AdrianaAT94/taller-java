import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graficoprincipal.MenuPrincipal;
import textual.*;
/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */
public class Taller extends JFrame implements KeyListener
{
	static ConexionBD con;
    MenuPrincipal menu;


    public Taller()
    {
    	menu = new MenuPrincipal();
    	menu.setVisible(true);

		//para desactivar o espacio no control de menu
		JPanel panel = (JPanel) menu.getContentPane();
		
    	panel.addKeyListener(this);
		panel.setFocusable(true);
    	
        con = new ConexionBD();
    }
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	//control de espacio
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode(); //collese a tecla soltada
		
		if(key == KeyEvent.VK_SPACE) { //si e o espacio
			e.consume();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	}
    
    public static void main(String[] args) {
    	new Taller();
        
    }
    
}