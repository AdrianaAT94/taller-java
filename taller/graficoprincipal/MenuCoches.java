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

import graficodeportivos.MenuDeportivos;
import graficomonovolumenes.MenuMonovolumenes;
import graficotodoterrenos.MenuTodoterrenos;
import graficoturismos.MenuTurismos;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */

public class MenuCoches extends JFrame implements KeyListener, ActionListener {

	//Botons menu
	Boton turismos, deportivos, monovolumenes, todoterrenos, atras;
	Font fuente;
	JPanel panel;
	JLabel label;
	
	public MenuCoches(){
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
        turismos = new Boton("TURISMOS", 200, 110); 
        turismos.setForeground(Color.BLACK); //cambiar color de letras
        turismos.setFocusPainted(false); //para que non sala o cuadro o redor das letras
        deportivos = new Boton("DEPORTIVOS", 200, 110);
        deportivos.setForeground(Color.BLACK);
        deportivos.setFocusPainted(false);
        monovolumenes = new Boton("MONOVOLÚMENES", 200, 110);
        monovolumenes.setForeground(Color.BLACK);
        monovolumenes.setFocusPainted(false);
        todoterrenos = new Boton("TODOTERRENOS", 200, 110);
        todoterrenos.setForeground(Color.BLACK);
        todoterrenos.setFocusPainted(false);
        atras = new Boton("ATRÁS", 200, 110);
        atras.setForeground(Color.BLACK);
		atras.setFocusPainted(false);
		turismos.addActionListener(this);
		deportivos.addActionListener(this);
		monovolumenes.addActionListener(this);
		todoterrenos.addActionListener(this);
		atras.addActionListener(this);	
		
		//Declaro colores para o fondo e as etiquetas dos paneles
        Color co= new Color(0);
        Color col= new Color(255,255,255);
        
      //Creanse paneles e daselle un color de fondo
        panel = new JPanel(); 
        panel.setBackground(co);
        
        label = new JLabel("GESTIÓN DE COCHES");
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
		add(turismos,c);
		
		c.gridx=0; 
		c.gridy=2;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(deportivos,c);
		
		c.gridx=0; 
		c.gridy=3;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(monovolumenes,c);
		
		c.gridx=0; 
		c.gridy=4;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(todoterrenos,c);
				
		c.gridx=0; 
		c.gridy=5;	
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
		if (e.getActionCommand().equals("TURISMOS")) {
			MenuTurismos tur = new MenuTurismos();
			dispose();
			tur.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) tur.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
			
		}
		if (e.getActionCommand().equals("DEPORTIVOS")) {
			MenuDeportivos dep = new MenuDeportivos();
			dispose();
			dep.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) dep.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
			
		}
		if (e.getActionCommand().equals("MONOVOLÚMENES")) {
			MenuMonovolumenes mon = new MenuMonovolumenes();
			dispose();
			mon.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) mon.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
		
		if (e.getActionCommand().equals("TODOTERRENOS")) {
			MenuTodoterrenos tod = new MenuTodoterrenos();
			dispose();
			tod.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) tod.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
		
		if (e.getActionCommand().equals("ATRÁS")) {
			MenuVehiculos men = new MenuVehiculos();
			dispose();
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) men.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
	}
}
