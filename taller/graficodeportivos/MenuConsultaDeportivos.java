package graficodeportivos;

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
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */

public class MenuConsultaDeportivos extends JFrame implements KeyListener, ActionListener {

	//Botons menu
	Boton matricula, marca, modelo, todas, atras;
	Font fuente;
	JPanel panel;
	JLabel label;
	
	public MenuConsultaDeportivos(){
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
        todas = new Boton("TODOS", 200, 110);
        todas.setForeground(Color.BLACK);
        todas.setFocusPainted(false);
        matricula = new Boton("POR MATRÍCULA", 200, 110); 
        matricula.setForeground(Color.BLACK); //cambiar color de letras
        matricula.setFocusPainted(false); //para que non sala o cuadro o redor das letras
        marca = new Boton("POR MARCA", 200, 110);
        marca.setForeground(Color.BLACK);
        marca.setFocusPainted(false);
        modelo = new Boton("POR MODELO", 200, 110);
        modelo.setForeground(Color.BLACK);
        modelo.setFocusPainted(false);
        atras = new Boton("ATRÁS", 200, 110);
        atras.setForeground(Color.BLACK);
		atras.setFocusPainted(false);
		todas.addActionListener(this);
		matricula.addActionListener(this);
		marca.addActionListener(this);
		modelo.addActionListener(this);
		atras.addActionListener(this);	
		
		//Declaro colores para o fondo e as etiquetas dos paneles
        Color co= new Color(0);
        Color col= new Color(255,255,255);
        
      //Creanse paneles e daselle un color de fondo
        panel = new JPanel(); 
        panel.setBackground(co);
        
        label = new JLabel("GESTIÓN DE DEPORTIVOS");
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
		add(todas,c);
		
		c.gridx=0; // especifica a coordenada x
		c.gridy=2;	// coordenada y
		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); //ponher marxes
		add(matricula,c);
		
		c.gridx=0; 
		c.gridy=3;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(marca,c);
		
		c.gridx=0; 
		c.gridy=4;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(modelo,c);
		
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
		if (e.getActionCommand().equals("TODOS")) {
			MenuListadoDeportivos men = new MenuListadoDeportivos();
			dispose(); //elimina ventana
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel1 = (JPanel) men.getContentPane();
			
			panel1.addKeyListener(this);
			panel1.setFocusable(true);
			
		}
		if (e.getActionCommand().equals("POR MATRÍCULA")) {
			MenuListadoDeportivosEscribirMatricula men = new MenuListadoDeportivosEscribirMatricula();
			dispose(); //elimina ventana
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel1 = (JPanel) men.getContentPane();
			
			panel1.addKeyListener(this);
			panel1.setFocusable(true);
			
		}
		if (e.getActionCommand().equals("POR MARCA")) {
			MenuListadoDeportivosEscribirMarca men = new MenuListadoDeportivosEscribirMarca();
			dispose(); //elimina ventana
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel1 = (JPanel) men.getContentPane();
			
			panel1.addKeyListener(this);
			panel1.setFocusable(true);
			
		}
		if (e.getActionCommand().equals("POR MODELO")) {
			MenuListadoDeportivosEscribirModelo men = new MenuListadoDeportivosEscribirModelo();
			dispose(); //elimina ventana
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel1 = (JPanel) men.getContentPane();
			
			panel1.addKeyListener(this);
			panel1.setFocusable(true);
			
		}
		
		if (e.getActionCommand().equals("ATRÁS")) {
			MenuDeportivos men = new MenuDeportivos();
			dispose();
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) men.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
	}
}
