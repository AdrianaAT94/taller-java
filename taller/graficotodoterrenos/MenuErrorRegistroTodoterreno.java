package graficotodoterrenos;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import graficoprincipal.Boton;
import graficoprincipal.PanelImagen;

/**
 * @author Adriana Armental Tom�
 * @version 06.03.2017
 */


public class MenuErrorRegistroTodoterreno extends JFrame implements KeyListener, ActionListener{

	//Declaracion de paneles, etiquetas e botons
	JPanel panel;
	JLabel label;
	Boton volver;
	
	public MenuErrorRegistroTodoterreno() {
		super("Taller"); //Nome
		PanelImagen p = new PanelImagen();
        setContentPane(p);
		setSize(400,350); //Tamaño ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Poder cerrar a ventana.
		setResizable(false); //Que non se poda cambiar o tamaño da ventana
	    setLayout(new GridBagLayout());
	    setLocationRelativeTo(null);
	    
	    //Declaro colores para o fondo e as etiquetas dos paneles
	    Color co= new Color(0);
        Color col= new Color(255,255,255);
        
        //Creanse paneles e daselle un color de fondo
        panel = new JPanel(); 
        panel.setBackground(co);
	            
        String texto =  "<html><body><p align='center'>ERROR</p><br>"
        		+ "<p align='center'>Se ha detectado un error en los datos introducidos.</p></body></html>" ;
        
        label = new JLabel(texto);
        label.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        label.setForeground(col);
        
	    volver = new Boton("VOLVER", 200, 110);
	    volver.setFocusPainted(false);
	    volver.addActionListener(this);
	    
	    panel.add(label);
	     
	    GridBagConstraints c = new GridBagConstraints();			
	    c.gridx=0; // especifica a coordenada x			
	    c.gridy=0;	// coordenada y			
	    c.gridwidth=1; //número de celdas que ocupa no GridBagLayout			
	    c.gridheight=1; 			
	    c.anchor=GridBagConstraints.NORTH; //posición dentro dunha celda			
	    c.fill=GridBagConstraints.NORTH; //espacio que ocupara dentro dunha celda			
	    c.weightx=1.0; //porcentaxe de espazo libre que ocupara 			
	    c.weighty=1.0;			
	    c.insets=new Insets(10,10,10,10); //poñer marxes			
	    add(panel,c);			
		
	    c.gridx=0; 	
	    c.gridy=1;	
	    c.gridwidth=1; 	
	    c.gridheight=1; 		
	    c.anchor=GridBagConstraints.CENTER; 	
	    c.fill=GridBagConstraints.BOTH; 		
	    c.weightx=1.0;  		
	    c.weighty=1.0;		
	    //c.insets=new Insets(20,200,20,200); 	
	    add(volver,c);
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

	@Override
	public void actionPerformed(ActionEvent e) {	

		if (e.getActionCommand().equals("VOLVER")) {
			MenuTodoterrenos men = new MenuTodoterrenos();
			dispose();
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) men.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
			
		}
		
	}
	
}
