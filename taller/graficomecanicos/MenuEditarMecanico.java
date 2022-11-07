package graficomecanicos;

import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.JTextField;

import graficoprincipal.Boton;
import graficoprincipal.PanelImagen;
import textual.Mecanico;
import textual.Persona;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */

public class MenuEditarMecanico extends JFrame implements KeyListener, ActionListener {

	//Botons menu
	Boton atras, enviar;
	Font fuente;
	JPanel panel, panel2, panel3, panel4;
	JLabel label, dni, nombre, apellidos, telefono, correo, direccion;
	JTextField inputdni, inputnombre, inputapellidos, inputtelefono, inputcorreo, inputdireccion;
	Persona mec;
	String sdni, snombre, sapellidos, stelefono, scorreo, sdireccion;
	
	public MenuEditarMecanico(){
		super("Taller"); //Nome
        //declarar e colocar fondo
        PanelImagen p = new PanelImagen(); //Panel que conten a imaxe
        setContentPane(p); //Asignar panel
        setSize(800,700); //Tamanho ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Poder cerrar a ventana.
        setResizable(false); //Que non se poda cambiar o tamaanho da ventana
        setLayout(new GridBagLayout()); //Distribucion da ventana
        setLocationRelativeTo(null); //Colocar a ventana no centro
        
        mec = new Mecanico();
        sdni = mec.getDni(MenuEditarMecanicoLista.id);
        snombre = mec.getNombre(MenuEditarMecanicoLista.id);
        sapellidos = mec.getApellidos(MenuEditarMecanicoLista.id);
        stelefono = mec.getNumTelefono(MenuEditarMecanicoLista.id);
        scorreo = mec.getCorreoElectronico(MenuEditarMecanicoLista.id);
        sdireccion = mec.getDireccion(MenuEditarMecanicoLista.id);
       
        atras = new Boton("ATRÁS", 200, 110);
        atras.setForeground(Color.BLACK);
		atras.setFocusPainted(false);
		atras.addActionListener(this);	 
		enviar = new Boton("ENVIAR", 200, 110);
		enviar.setForeground(Color.BLACK);
		enviar.setFocusPainted(false);
		enviar.addActionListener(this);	
		
		//Declaro colores para o fondo e as etiquetas dos paneles
        Color co= new Color(0);
        Color col= new Color(255,255,255);
        
      //Creanse paneles e daselle un color de fondo
        panel = new JPanel(); 
        panel.setBackground(co);
        
        panel2 = new JPanel(); 
        panel2.setBackground(co);
        panel2.setLayout(new FlowLayout());
        panel3 = new JPanel(); 
        panel3.setBackground(co);
        panel3.setLayout(new FlowLayout());
        panel4 = new JPanel(); 
        panel4.setBackground(co);
        panel4.setLayout(new FlowLayout());
        
        label = new JLabel("EDITAR MECÁNICO");
        label.setFont(new Font("Lucida Sans", Font.BOLD, 20));
        label.setForeground(col);	
        
        dni = new JLabel("DNI: ");
        dni.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        dni.setForeground(col);	
        nombre = new JLabel("Nombre: ");
        nombre.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        nombre.setForeground(col);	
        apellidos = new JLabel("Apellidos: ");
        apellidos.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        apellidos.setForeground(col);	
        telefono = new JLabel("Teléfono: ");
        telefono.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        telefono.setForeground(col);	
        correo = new JLabel("Correo: ");
        correo.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        correo.setForeground(col);	
        direccion = new JLabel("Dirección: ");
        direccion.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        direccion.setForeground(col);	
        
        inputdni = new JTextField(10);
        inputdni.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputdni.setForeground(col);	
        inputdni.setBackground(co);
        inputdni.setEditable(true);
        inputdni.setEnabled(true);
        inputdni.setFocusable(true);
        inputdni.requestFocus();
        inputdni.setText(sdni);
        inputnombre = new JTextField(10);
        inputnombre.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputnombre.setForeground(col);	
        inputnombre.setBackground(co);
        inputnombre.setEditable(true);
        inputnombre.setEnabled(true);
        inputnombre.setFocusable(true);
        inputnombre.requestFocus();
        inputnombre.setText(snombre);
        inputapellidos = new JTextField(10);
        inputapellidos.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputapellidos.setForeground(col);	
        inputapellidos.setBackground(co);
        inputapellidos.setEditable(true);
        inputapellidos.setEnabled(true);
        inputapellidos.setFocusable(true);
        inputapellidos.requestFocus();
        inputapellidos.setText(sapellidos);
        inputtelefono = new JTextField(10);
        inputtelefono.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputtelefono.setForeground(col);	
        inputtelefono.setBackground(co);
        inputtelefono.setEditable(true);
        inputtelefono.setEnabled(true);
        inputtelefono.setFocusable(true);
        inputtelefono.requestFocus();
        inputtelefono.setText(stelefono);
        inputcorreo = new JTextField(10);
        inputcorreo.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputcorreo.setForeground(col);	
        inputcorreo.setBackground(co);
        inputcorreo.setEditable(true);
        inputcorreo.setEnabled(true);
        inputcorreo.setFocusable(true);
        inputcorreo.requestFocus();
        inputcorreo.setText(scorreo);
        inputdireccion = new JTextField(10);
        inputdireccion.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputdireccion.setForeground(col);	
        inputdireccion.setBackground(co);
        inputdireccion.setEditable(true);
        inputdireccion.setEnabled(true);
        inputdireccion.setFocusable(true);
        inputdireccion.requestFocus();
        inputdireccion.setText(sdireccion);
        
      //Añadense as etiquetas os paneles
  		panel.add(label);
  		panel2.add(dni);
  		panel2.add(inputdni);
  		panel2.add(nombre);
  		panel2.add(inputnombre);
  		panel3.add(apellidos);
  		panel3.add(inputapellidos);
  		panel3.add(telefono);
  		panel3.add(inputtelefono);
  		panel4.add(correo);
  		panel4.add(inputcorreo);
  		panel4.add(direccion);
  		panel4.add(inputdireccion);
  		
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
  		c.insets=new Insets(200,200,10,200); //ponher marxes
  		add(panel2,c);
  		
  		c.gridx=0; // especifica a coordenada x
  		c.gridy=2;	// coordenada y
  		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
  		c.gridheight=1; 
  		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
  		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
  		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
  		c.weighty=0;
  		c.insets=new Insets(10,200,10,200); //ponher marxes
  		add(panel3,c);
  		
  		c.gridx=0; // especifica a coordenada x
  		c.gridy=3;	// coordenada y
  		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
  		c.gridheight=1; 
  		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
  		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
  		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
  		c.weighty=0;
  		c.insets=new Insets(10,200,10,200); //ponher marxes
  		add(panel4,c);
  		
  		c.gridx=0; 
  		c.gridy=4;	
  		c.gridwidth=1; 
  		c.gridheight=1; 
  		c.anchor=GridBagConstraints.CENTER; 
  		c.fill=GridBagConstraints.BOTH; 
  		c.weightx=1.0; 
  		c.weighty=1.0; 
  		c.insets=new Insets(175,10,10,400); 
  		add(atras,c);
  		
  		c.gridx=0; 		
  		c.gridy=4;	
  		c.gridwidth=1; 
  		c.gridheight=1; 
  		c.anchor=GridBagConstraints.CENTER; 
  		c.fill=GridBagConstraints.BOTH; 
  		c.weightx=1.0; 
  		c.weighty=1.0;
  		c.insets=new Insets(175,400,10,10); 
  		add(enviar,c);
				
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
			MenuMecanicos men = new MenuMecanicos();
			dispose();
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) men.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
		if (e.getActionCommand().equals("ENVIAR")) {
			if (mec.editar(MenuEditarMecanicoLista.id, inputnombre.getText(), inputapellidos.getText(), inputtelefono.getText(), inputcorreo.getText(), inputdireccion.getText())) {
				MenuListadoMecanicos men = new MenuListadoMecanicos();
				dispose();
				men.setVisible(true);
				
				//para desactivar o espacio no control de menu
				JPanel panel = (JPanel) men.getContentPane();
				
				panel.addKeyListener(this);
				panel.setFocusable(true);			
			}
			else {
				MenuErrorRegistroMecanico men = new MenuErrorRegistroMecanico();
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
