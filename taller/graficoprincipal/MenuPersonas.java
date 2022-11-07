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

import graficoclientes.MenuClientes;
import graficocomerciales.MenuComerciales;
import graficomecanicos.MenuMecanicos;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */

public class MenuPersonas extends JFrame implements KeyListener, ActionListener {

	//Botons menu
	Boton clientes, comerciales, mecanicos, atras;
	Font fuente;
	JPanel panel;
	JLabel label;
	
	public MenuPersonas(){
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
        clientes = new Boton("CLIENTES", 200, 110); 
        clientes.setForeground(Color.BLACK); //cambiar color de letras
        clientes.setFocusPainted(false); //para que non sala o cuadro o redor das letras
        comerciales = new Boton("COMERCIALES", 200, 110);
        comerciales.setForeground(Color.BLACK);
        comerciales.setFocusPainted(false);
        mecanicos = new Boton("MECÁNICOS", 200, 110);
        mecanicos.setForeground(Color.BLACK);
        mecanicos.setFocusPainted(false);
        atras = new Boton("ATRÁS", 200, 110);
        atras.setForeground(Color.BLACK);
		atras.setFocusPainted(false);
		clientes.addActionListener(this);
		comerciales.addActionListener(this);
		mecanicos.addActionListener(this);
		atras.addActionListener(this);	
		
		//Declaro colores para o fondo e as etiquetas dos paneles
        Color co= new Color(0);
        Color col= new Color(255,255,255);
        
      //Creanse paneles e daselle un color de fondo
        panel = new JPanel(); 
        panel.setBackground(co);
        
        label = new JLabel("GESTIÓN DE PERSONAS");
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
		add(clientes,c);
		
		c.gridx=0; 
		c.gridy=2;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(comerciales,c);
		
		c.gridx=0; 
		c.gridy=3;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(mecanicos,c);
		
		c.gridx=0; 
		c.gridy=4;	
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
		if (e.getActionCommand().equals("CLIENTES")) {
			MenuClientes cli = new MenuClientes();
			dispose();
			cli.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) cli.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
			
		}
		if (e.getActionCommand().equals("COMERCIALES")) {
			MenuComerciales come = new MenuComerciales();
			dispose();
			come.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) come.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
			
		}
		if (e.getActionCommand().equals("MECÁNICOS")) {
			MenuMecanicos meca = new MenuMecanicos();
			dispose();
			meca.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) meca.getContentPane();
			
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
