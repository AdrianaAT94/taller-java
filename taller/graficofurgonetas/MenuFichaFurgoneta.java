package graficofurgonetas;

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

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import graficofichas.MenuErrorRegistroFicha;
import graficofichas.MenuFichas;
import graficofichas.MenuListadoFichas;
import graficoprincipal.Boton;
import graficoprincipal.PanelImagen;
import textual.Ficha;
import textual.Furgoneta;
import textual.Mecanico;
import textual.Persona;
import textual.Vehiculo;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */

public class MenuFichaFurgoneta extends JFrame implements KeyListener, ActionListener {

	//Botons menu
	Boton atras, enviar;
	Font fuente;
	JPanel panel, panel2, panel3, panel4, panel5;
	JLabel label, descripcion, estado, fechaEntrada, fechaSalida, motivo, cliente, vehiculo, mecanico;
	JTextField inputdescripcion, inputfechaEntrada, inputfechaSalida, inputmotivo, inputcliente, inputvehiculo;
	JComboBox selestado, selmecanico;
	Color co, col;
	Ficha fic;
	Persona mec;
	Vehiculo fur;
	String sfechaEntrada, scliente, svehiculo, idvehi;
	
	public MenuFichaFurgoneta(){
		super("Taller"); //Nome
        //declarar e colocar fondo
        PanelImagen p = new PanelImagen(); //Panel que conten a imaxe
        setContentPane(p); //Asignar panel
        setSize(800,700); //Tamanho ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Poder cerrar a ventana.
        setResizable(false); //Que non se poda cfuriar o tamaanho da ventana
        setLayout(new GridBagLayout()); //Distribucion da ventana
        setLocationRelativeTo(null); //Colocar a ventana no centro
        
        mec = new Mecanico();
        fic = new Ficha();
        fur = new Furgoneta();
        sfechaEntrada = fur.getfechaAlta(fur.getUltimoRegitro());
        scliente = fur.getNombrecliente(fur.getUltimoRegitro());
        svehiculo = fur.getNombrevehiculo(fur.getUltimoRegitro());
       
        atras = new Boton("ATRÁS", 200, 110);
        atras.setForeground(Color.BLACK);
		atras.setFocusPainted(false);
		atras.addActionListener(this);	 
		enviar = new Boton("ENVIAR", 200, 110);
		enviar.setForeground(Color.BLACK);
		enviar.setFocusPainted(false);
		enviar.addActionListener(this);	
		
		//Declaro colores para o fondo e as etiquetas dos paneles
        co= new Color(0);
        col= new Color(255,255,255);
        
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
        panel5 = new JPanel(); 
        panel5.setBackground(co);
        panel5.setLayout(new FlowLayout());
        
        label = new JLabel("EDITAR FICHA");
        label.setFont(new Font("Lucida Sans", Font.BOLD, 20));
        label.setForeground(col);	
        
        descripcion = new JLabel("Descripción: ");
        descripcion.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        descripcion.setForeground(col);	
        estado = new JLabel("Estado: ");
        estado.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        estado.setForeground(col);	
        fechaEntrada = new JLabel("Fecha Entrada: ");
        fechaEntrada.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        fechaEntrada.setForeground(col);	
        fechaSalida = new JLabel("Fecha Salida: ");
        fechaSalida.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        fechaSalida.setForeground(col);	
        motivo = new JLabel("Motivo Parado: ");
        motivo.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        motivo.setForeground(col);	
        cliente = new JLabel("Cliente: ");
        cliente.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        cliente.setForeground(col);	
        vehiculo = new JLabel("Vehiculo: ");
        vehiculo.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        vehiculo.setForeground(col);	
        mecanico = new JLabel("Mecánico: ");
        mecanico.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        mecanico.setForeground(col);	
                
        inputdescripcion = new JTextField(10);
        inputdescripcion.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputdescripcion.setForeground(col);	
        inputdescripcion.setBackground(co);
        inputdescripcion.setEditable(true);
        inputdescripcion.setEnabled(true);
        inputdescripcion.setFocusable(true);
        inputdescripcion.requestFocus();
        inputfechaEntrada = new JTextField(10);
        inputfechaEntrada.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputfechaEntrada.setForeground(col);	
        inputfechaEntrada.setBackground(Color.DARK_GRAY);
        inputfechaEntrada.setEditable(false);
        inputfechaEntrada.setEnabled(false);
        inputfechaEntrada.setFocusable(false);
        inputfechaEntrada.requestFocus();
        inputfechaEntrada.setText(sfechaEntrada);
        inputfechaSalida = new JTextField(10);
        inputfechaSalida.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputfechaSalida.setForeground(col);	
        inputfechaSalida.setBackground(co);
        inputfechaSalida.setEditable(true);
        inputfechaSalida.setEnabled(true);
        inputfechaSalida.setFocusable(true);
        inputfechaSalida.requestFocus();
        inputmotivo = new JTextField(10);
        inputmotivo.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputmotivo.setForeground(col);	
        inputmotivo.setBackground(Color.DARK_GRAY);
        inputmotivo.setEditable(false);
        inputmotivo.setEnabled(false);
        inputmotivo.setFocusable(false);
        inputmotivo.requestFocus();
        
        selestado = new JComboBox();
        selestado.addItem("pendiente");
        selestado.addItem("en proceso");
        selestado.addItem("parado");
        selestado.addItem("fase prueba");
        selestado.addItem("terminado");
        selestado.addActionListener(this);
        
        inputcliente = new JTextField(10);
        inputcliente.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputcliente.setForeground(col);	
        inputcliente.setBackground(Color.DARK_GRAY);
        inputcliente.setEditable(false);
        inputcliente.setEnabled(false);
        inputcliente.setFocusable(false);
        inputcliente.requestFocus();
        inputcliente.setText(scliente);
       
        selmecanico = new JComboBox();

        String nombreper2 = mec.NombrePersona().toString();
        nombreper2 = nombreper2.replace("[", "").replace("]", "");
        String[] parts1 = nombreper2.split(",");
        String apellidoper2 = mec.ApellidoPersona().toString();
        apellidoper2 = apellidoper2.replace("[", "").replace("]", "");
        String[] parts12 = apellidoper2.split(",");
        String idmecanico2 = mec.IDPersona().toString();
        idmecanico2 = idmecanico2.replace("[", "").replace("]", "");
        String[] parts13 = idmecanico2.split(",");
        for (int i=0; i< parts1.length; i++) {
        	selmecanico.addItem(parts1[i].trim()+" "+parts12[i].trim()+" ("+parts13[i].trim()+")");
        }
        
        inputvehiculo = new JTextField(10);
        inputvehiculo.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputvehiculo.setForeground(col);	
        inputvehiculo.setBackground(Color.DARK_GRAY);
        inputvehiculo.setEditable(false);
        inputvehiculo.setEnabled(false);
        inputvehiculo.setFocusable(false);
        inputvehiculo.requestFocus();
        inputvehiculo.setText(svehiculo);
        
        selestado = new JComboBox();
        selestado.addItem("pendiente");
        selestado.addItem("en proceso");
        selestado.addItem("parado");
        selestado.addItem("fase prueba");
        selestado.addItem("terminado");
        selestado.addActionListener(this);        
        
idvehi = fur.getUltimoRegitro();
		
		if (fur.getCombustible(idvehi).equals("diésel")){
			inputdescripcion.setText("Revisión del filtro de partículas");
			if (fur.getNombretipovehiculo(idvehi).equals("furulancia") || fur.getNombretipovehiculo(idvehi).equals("Bomberos") || fur.getNombretipovehiculo(idvehi).equals("Policía")) {
				inputdescripcion.setText("Revisión del filtro de partículas, Revisión de la sirena");	
			}
		}
		else if (fur.getnRuedas(idvehi).equals("2")) {
			inputdescripcion.setText("Comprobar presión de los neumáticos");	
			if (fur.getNombretipovehiculo(idvehi).equals("furulancia") || fur.getNombretipovehiculo(idvehi).equals("Bomberos") || fur.getNombretipovehiculo(idvehi).equals("Policía")) {
				inputdescripcion.setText("Comprobar presión de los neumáticos, Revisión del filtro de partículas, Revisión de la sirena");	
			}
		}
		else if (fur.getNombretipovehiculo(idvehi).equals("furulancia") || fur.getNombretipovehiculo(idvehi).equals("Bomberos") || fur.getNombretipovehiculo(idvehi).equals("Policía")) {
			inputdescripcion.setText("Revisión de la sirena");	
		}
		else {
			inputdescripcion.setText("");
		}	
		
		if (selestado.getSelectedItem().equals("parado")) {
	        inputmotivo.setEditable(true);
	        inputmotivo.setEnabled(true);
	        inputmotivo.setFocusable(true);
	        inputmotivo.setBackground(co);
		}
        
		//Añadense as etiquetas os paneles
		panel.add(label);
		panel2.add(cliente);
		panel2.add(inputcliente);
		panel2.add(vehiculo);
		panel2.add(inputvehiculo);
		panel3.add(fechaEntrada);
		panel3.add(inputfechaEntrada);
		panel3.add(fechaSalida);
		panel3.add(inputfechaSalida);
		panel4.add(estado);
		panel4.add(selestado);
		panel4.add(motivo);
		panel4.add(inputmotivo);
		panel5.add(descripcion);
		panel5.add(inputdescripcion);
		panel5.add(mecanico);
		panel5.add(selmecanico);
		
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
		c.insets=new Insets(200,100,10,100); //ponher marxes
		add(panel2,c);
		
		c.gridx=0; // especifica a coordenada x
		c.gridy=2;	// coordenada y
		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=0;
		c.insets=new Insets(10,100,10,100); //ponher marxes
		add(panel3,c);
		
		c.gridx=0; // especifica a coordenada x
		c.gridy=3;	// coordenada y
		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=0;
		c.insets=new Insets(10,100,10,100); //ponher marxes
		add(panel4,c);
		
		c.gridx=0; // especifica a coordenada x
		c.gridy=4;	// coordenada y
		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=0;
		c.insets=new Insets(10,100,10,100); //ponher marxes
		add(panel5,c);
		
		c.gridx=0; 
		c.gridy=5;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0; 
		c.insets=new Insets(100,10,10,400); 
		add(atras,c);
		
		c.gridx=0; 		
		c.gridy=5;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(100,400,10,10); 
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
				
		if (selestado.getSelectedItem().equals("pendiente") || selestado.getSelectedItem().equals("en proceso") || selestado.getSelectedItem().equals("fase prueba") || selestado.getSelectedItem().equals("terminado")) {
	        inputmotivo.setEditable(false);
	        inputmotivo.setEnabled(false);
	        inputmotivo.setFocusable(false);
	        inputmotivo.setBackground(Color.DARK_GRAY);
	        inputmotivo.setText("");
		}
		
		if (e.getActionCommand().equals("ATRÁS")) {
			MenuFichas men = new MenuFichas();
			dispose();
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) men.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
		if (e.getActionCommand().equals("ENVIAR")) {

				String sest="";
			       
		        if(selestado.getSelectedItem() == "pendiente") {
		        	sest = "1";
		        }  
		        if(selestado.getSelectedItem() == "en proceso") {
		        	sest = "2";
		        }  
		        if(selestado.getSelectedItem() == "parado") {
		        	sest = "3";
		        }  
		        if(selestado.getSelectedItem() == "fase prueba") {
		        	sest = "4";
		        }  
		        if(selestado.getSelectedItem() == "terminado") {
		        	sest = "5";
		        }
				
				if (fic.editar(fur.getUltimoRegitro(), inputdescripcion.getText(), sest, inputfechaSalida.getText(), inputmotivo.getText())) {
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
