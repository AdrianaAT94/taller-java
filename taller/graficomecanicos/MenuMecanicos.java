package graficomecanicos;

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
import graficoprincipal.MenuPersonas;
import graficoprincipal.PanelImagen;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */

public class MenuMecanicos extends JFrame implements KeyListener, ActionListener {

	//Botons menu
	Boton nuevo, consulta, editar, eliminar, atras;
	Font fuente;
	JPanel panel;
	JLabel label;
	
	public MenuMecanicos(){
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
        nuevo = new Boton("NUEVO", 200, 110); 
        nuevo.setForeground(Color.BLACK); //cambiar color de letras
        nuevo.setFocusPainted(false); //para que non sala o cuadro o redor das letras
        consulta = new Boton("CONSULTA", 200, 110);
        consulta.setForeground(Color.BLACK);
        consulta.setFocusPainted(false);
        editar = new Boton("EDITAR", 200, 110);
        editar.setForeground(Color.BLACK);
        editar.setFocusPainted(false);
        eliminar = new Boton("ELIMINAR", 200, 110);
        eliminar.setForeground(Color.BLACK);
        eliminar.setFocusPainted(false);
        atras = new Boton("ATRÁS", 200, 110);
        atras.setForeground(Color.BLACK);
		atras.setFocusPainted(false);
		nuevo.addActionListener(this);
		consulta.addActionListener(this);
		editar.addActionListener(this);
		eliminar.addActionListener(this);
		atras.addActionListener(this);	
		
		//Declaro colores para o fondo e as etiquetas dos paneles
        Color co= new Color(0);
        Color col= new Color(255,255,255);
        
      //Creanse paneles e daselle un color de fondo
        panel = new JPanel(); 
        panel.setBackground(co);
        
        label = new JLabel("GESTIÓN DE MECÁNICOS");
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
		add(nuevo,c);
		
		c.gridx=0; 
		c.gridy=2;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(consulta,c);
		
		c.gridx=0; 
		c.gridy=3;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(editar,c);
		
		c.gridx=0; 
		c.gridy=4;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(20,200,20,200); 
		add(eliminar,c);
		
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
		if (e.getActionCommand().equals("NUEVO")) {
			MenuNuevoMecanico con = new MenuNuevoMecanico();
			dispose(); //elimina ventana
			con.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel1 = (JPanel) con.getContentPane();
			
			panel1.addKeyListener(this);
			panel1.setFocusable(true);
			
		}
		if (e.getActionCommand().equals("CONSULTA")) {
			MenuConsultaMecanicos con = new MenuConsultaMecanicos();
			dispose(); //elimina ventana
			con.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel1 = (JPanel) con.getContentPane();
			
			panel1.addKeyListener(this);
			panel1.setFocusable(true);
			
		}
		if (e.getActionCommand().equals("EDITAR")) {
			MenuEditarMecanicoLista con = new MenuEditarMecanicoLista();
			dispose(); //elimina ventana
			con.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel1 = (JPanel) con.getContentPane();
			
			panel1.addKeyListener(this);
			panel1.setFocusable(true);
			
		}
		if (e.getActionCommand().equals("ELIMINAR")) {
			MenuEliminarMecanico con = new MenuEliminarMecanico();
			dispose(); //elimina ventana
			con.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel1 = (JPanel) con.getContentPane();
			
			panel1.addKeyListener(this);
			panel1.setFocusable(true);
			
		}
		
		if (e.getActionCommand().equals("ATRÁS")) {
			MenuPersonas men = new MenuPersonas();
			dispose();
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) men.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
	}
}
