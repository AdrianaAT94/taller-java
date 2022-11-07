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

import graficofichas.MenuFichas;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */

public class MenuPrincipal extends JFrame implements KeyListener, ActionListener {

	//Botons menu
	Boton personas, vehiculos, fichas, ofertas, salir;
	Font fuente;
	JPanel panel;
	JLabel label;
	
	public MenuPrincipal(){
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
        personas = new Boton("PERSONAS", 200, 110); 
        personas.setForeground(Color.BLACK); //cambiar color de letras
        personas.setFocusPainted(false); //para que non sala o cuadro o redor das letras
        vehiculos = new Boton("VEHÍCULOS", 200, 110);
        vehiculos.setForeground(Color.BLACK);
        vehiculos.setFocusPainted(false);
		fichas = new Boton("FICHAS", 200, 110);
		fichas.setForeground(Color.BLACK);
		fichas.setFocusPainted(false);
		ofertas = new Boton("PROMOCIONES", 200, 110);
		ofertas.setForeground(Color.BLACK);
		ofertas.setFocusPainted(false);
		salir = new Boton("SALIR", 200, 110);
		salir.setForeground(Color.BLACK);
		salir.setFocusPainted(false);
		personas.addActionListener(this);
		vehiculos.addActionListener(this);
		fichas.addActionListener(this);
		ofertas.addActionListener(this);
		salir.addActionListener(this);	
		
		//Declaro colores para o fondo e as etiquetas dos paneles
        Color co= new Color(0);
        Color col= new Color(255,255,255);
        
      //Creanse paneles e daselle un color de fondo
        panel = new JPanel(); 
        panel.setBackground(co);
        
        label = new JLabel("BIENVENIDO");
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
		add(personas,c);
		
		c.gridx=0; 
		c.gridy=2;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(vehiculos,c);
		
		c.gridx=0; 
		c.gridy=3;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(fichas,c);
		
		c.gridx=0; 
		c.gridy=4;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(ofertas,c);
		
		c.gridx=0; 
		c.gridy=5;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(salir,c);
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
		if (e.getActionCommand().equals("PERSONAS")) {
			MenuPersonas per = new MenuPersonas();
			dispose(); //elimina ventana
			per.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel1 = (JPanel) per.getContentPane();
			
			panel1.addKeyListener(this);
			panel1.setFocusable(true);
		}
		if (e.getActionCommand().equals("VEHÍCULOS")) {
			MenuVehiculos veh = new MenuVehiculos();
			dispose(); //elimina ventana
			veh.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel1 = (JPanel) veh.getContentPane();
			
			panel1.addKeyListener(this);
			panel1.setFocusable(true);
		}
		if (e.getActionCommand().equals("FICHAS")) {
			MenuFichas fic = new MenuFichas();
			dispose(); //elimina ventana
			fic.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel1 = (JPanel) fic.getContentPane();
			
			panel1.addKeyListener(this);
			panel1.setFocusable(true);
		}
		if (e.getActionCommand().equals("PROMOCIONES")) {
			MenuPromociones ofe = new MenuPromociones();
			dispose(); //elimina ventana
			ofe.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel1 = (JPanel) ofe.getContentPane();
			
			panel1.addKeyListener(this);
			panel1.setFocusable(true);
		}
		if (e.getActionCommand().equals("SALIR")) {
			System.exit(0); //Pechar programa
		}
	}
}
