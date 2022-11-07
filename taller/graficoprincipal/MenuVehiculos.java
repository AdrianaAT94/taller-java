package graficoprincipal;

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

import graficoautobuses.MenuAutobuses;
import graficocamiones.MenuCamiones;
import graficofurgonetas.MenuFurgonetas;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */

public class MenuVehiculos extends JFrame implements KeyListener, ActionListener {

	//Botons menu
	Boton coches, motos, camiones, furgonetas, autobuses, profesionales, atras;
	Font fuente;
	JPanel panel;
	JLabel label;
	
	public MenuVehiculos(){
		super("Taller"); //Nome
        //declarar e colocar fondo
        PanelImagen p = new PanelImagen(); //Panel que conten a imaxe
        setContentPane(p); //Asignar panel
        setSize(800,700); //Tamanho ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Poder cerrar a ventana.
        setResizable(false); //Que non se poda cambiar o tamaanho da ventana
        setLayout(new GridBagLayout()); //Distribucion da ventana
        setLocationRelativeTo(null); //Colocar a ventana no centro
       
        //Crear botons e ponher a escoita
        coches = new Boton("COCHES", 200, 110); 
        coches.setForeground(Color.BLACK); //cambiar color de letras
        coches.setFocusPainted(false); //para que non sala o cuadro o redor das letras
        motos = new Boton("MOTOS", 200, 110);
        motos.setForeground(Color.BLACK);
        motos.setFocusPainted(false);
        camiones = new Boton("CAMIONES", 200, 110);
        camiones.setForeground(Color.BLACK);
        camiones.setFocusPainted(false);
        furgonetas = new Boton("FURGONETAS", 200, 110);
        furgonetas.setForeground(Color.BLACK);
        furgonetas.setFocusPainted(false);
        autobuses = new Boton("AUTOBUSES", 200, 110);
        autobuses.setForeground(Color.BLACK);
        autobuses.setFocusPainted(false);
        profesionales = new Boton("PROFESIONALES", 200, 110);
        profesionales.setForeground(Color.BLACK);
        profesionales.setFocusPainted(false);
        atras = new Boton("ATRÁS", 200, 110);
        atras.setForeground(Color.BLACK);
		atras.setFocusPainted(false);
		coches.addActionListener(this);
		motos.addActionListener(this);
		camiones.addActionListener(this);
		furgonetas.addActionListener(this);
		autobuses.addActionListener(this);
		profesionales.addActionListener(this);
		atras.addActionListener(this);	
		
		//Declaro colores para o fondo e as etiquetas dos paneles
        Color co= new Color(0);
        Color col= new Color(255,255,255);
        
      //Creanse paneles e daselle un color de fondo
        panel = new JPanel(); 
        panel.setBackground(co);
        
        label = new JLabel("GESTIÓN DE VEHÍCULOS");
        label.setFont(new Font("Lucida Sans", Font.BOLD, 20));
        label.setForeground(col);	
		
		//Añadense as etiquetas os paneles
		panel.add(label);
		
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
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); //ponher marxes
		add(coches,c);
		
		c.gridx=0; 
		c.gridy=2;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(motos,c);
		
		c.gridx=0; 
		c.gridy=3;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(camiones,c);
		
		c.gridx=0; 
		c.gridy=4;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(furgonetas,c);
		
		c.gridx=0; 
		c.gridy=5;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(autobuses,c);
		
		c.gridx=0; 
		c.gridy=6;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(profesionales,c);
		
		c.gridx=0; 
		c.gridy=7;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(atras,c);
		
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
		if (e.getActionCommand().equals("COCHES")) {
			MenuCoches coc = new MenuCoches();
			dispose();
			coc.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) coc.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
			
		}
		if (e.getActionCommand().equals("MOTOS")) {
			MenuMotos mot = new MenuMotos();
			dispose();
			mot.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) mot.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
			
		}
		if (e.getActionCommand().equals("CAMIONES")) {
			MenuCamiones cam = new MenuCamiones();
			dispose();
			cam.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) cam.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
		
		if (e.getActionCommand().equals("FURGONETAS")) {
			MenuFurgonetas fur = new MenuFurgonetas();
			dispose();
			fur.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) fur.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
		
		if (e.getActionCommand().equals("AUTOBUSES")) {
			MenuAutobuses aut = new MenuAutobuses();
			dispose();
			aut.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) aut.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
		
		if (e.getActionCommand().equals("PROFESIONALES")) {
			MenuProfesionales pro = new MenuProfesionales();
			dispose();
			pro.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) pro.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
		
		if (e.getActionCommand().equals("ATRÁS")) {
			MenuPrincipal men = new MenuPrincipal();
			dispose();
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) men.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
	}
}
