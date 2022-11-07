
package graficofichas;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import graficoprincipal.Boton;
import graficoprincipal.PanelImagen;
import textual.Ficha;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */

public class MenuEliminarFicha extends JFrame implements KeyListener, ActionListener {

	//Botons menu
	Boton atras, eliminar;
	Font fuente;
	JPanel panel, panel2;
	JLabel label, label2;
	JComboBox sel;
	Ficha fic;
	
	public MenuEliminarFicha(){
		super("Taller"); //Nome
        //declarar e colocar fondo
        PanelImagen p = new PanelImagen(); //Panel que conten a imaxe
        setContentPane(p); //Asignar panel
        setSize(800,700); //Tamanho ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Poder cerrar a ventana.
        setResizable(false); //Que non se poda cambiar o tamaanho da ventana
        setLayout(new GridBagLayout()); //Distribucion da ventana
        setLocationRelativeTo(null); //Colocar a ventana no centro
        
        fic = new Ficha();
       
        atras = new Boton("ATRÁS", 200, 110);
        atras.setForeground(Color.BLACK);
		atras.setFocusPainted(false);
		atras.addActionListener(this);	 
		eliminar = new Boton("ELIMINAR", 200, 110);
		eliminar.setForeground(Color.BLACK);
		eliminar.setFocusPainted(false);
		eliminar.addActionListener(this);	
		
		//Declaro colores para o fondo e as etiquetas dos paneles
        Color co= new Color(0);
        Color col= new Color(255,255,255);
        
      //Creanse paneles e daselle un color de fondo
        panel = new JPanel(); 
        panel.setBackground(co);
        
        panel2 = new JPanel(); 
        panel2.setBackground(co);
        
        label = new JLabel("ELIMINAR CLIENTES");
        label.setFont(new Font("Lucida Sans", Font.BOLD, 20));
        label.setForeground(col);	
        
        label2 = new JLabel("¿A quién quieres eliminar?");
        label2.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        label2.setForeground(col);	
        
        sel = new JComboBox();
        sel.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        
        String nombreveh = fic.FichaVehiculo().toString();
        nombreveh = nombreveh.replace("[", "").replace("]", "");
        String[] parts = nombreveh.split(",");
        String nombremec = fic.FichaMecanico().toString();
        nombremec = nombremec.replace("[", "").replace("]", "");
        String[] parts2 = nombremec.split(",");
        String idficha = fic.FichaID().toString();
        idficha = idficha.replace("[", "").replace("]", "");
        String[] parts3 = idficha.split(",");
        for (int i=0; i< parts.length; i++) {
            sel.addItem(parts[i].trim()+" "+parts2[i].trim()+" ("+parts3[i].trim()+")");
        }
		
		//Añadense as etiquetas os paneles
		panel.add(label);
		panel2.add(label2);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx=0; // especifica a coordenada x
		c.gridy=0;	// coordenada y
		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=0;
		c.insets=new Insets(10,100,10,100); //ponher marxes
		add(panel,c);

		c.gridx=0; // especifica a coordenada x
		c.gridy=1;	// coordenada y
		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=0;
		c.insets=new Insets(10,200,10,200); //ponher marxes
		add(panel2,c);
		
		c.gridx=0; // especifica a coordenada x
		c.gridy=2;	// coordenada y
		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=1.0;
		c.insets=new Insets(200,100,200,100); //ponher marxes
		add(sel,c);
		
		c.gridx=0; 
		c.gridy=4;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0; 
		c.insets=new Insets(10,10,10,400); 
		add(atras,c);
		
		c.gridx=0; 		
		c.gridy=4;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(10,400,10,10); 
		add(eliminar,c);
				
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
		
		if (e.getActionCommand().equals("ATRÁS")) {
			MenuFichas men = new MenuFichas();
			dispose();
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) men.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
		if (e.getActionCommand().equals("ELIMINAR")) {
			String resul = (String) sel.getSelectedItem();
			 
			int inicio = resul.indexOf("(");
			int fin = resul.indexOf(")");
			
			String ident = resul.substring(inicio + 1, fin);
			 
			if (fic.borrar(ident)) {
				MenuListadoFichas men = new MenuListadoFichas();
				dispose();
				men.setVisible(true);
				
				//para desactivar o espacio no control de menu
				JPanel panel = (JPanel) men.getContentPane();
				
				panel.addKeyListener(this);
				panel.setFocusable(true);
			}
			else {
				MenuErrorRegistroFicha men = new MenuErrorRegistroFicha();
				men.setVisible(true);
				dispose();
				
				//para desactivar o espacio no control de menu
				JPanel panel = (JPanel) men.getContentPane();
				
				panel.addKeyListener(this);
				panel.setFocusable(true);					
			}
			
		}
	}
}
