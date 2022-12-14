package graficodeportivos;

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

import graficoprincipal.Boton;
import graficoprincipal.PanelImagen;
import textual.Deportivo;
import textual.Cliente;
import textual.Persona;
import textual.Vehiculo;

/**
 * @author Adriana Armental Tom?
 * @version 06.03.2017
 */

public class MenuEditarDeportivo extends JFrame implements KeyListener, ActionListener {

	//Botons menu
	Boton atras, enviar;
	Font fuente;
	JPanel panel, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9, panel10;
	JLabel label, matricula, marca, modelo, combustible, nPuertas, nRuedas, maxVelocidad, capMotor, capAlmacenamiento, nPasajeros, ABS, GPS, airbags, climatizacion, descapotable, idcliente, motivoVisita, duenho;
	JTextField inputmatricula, inputmarca, inputmodelo, inputnPuertas, inputnRuedas, inputmaxVelocidad, inputcapMotor, inputcapAlmacenamiento, inputnPasajeros, inputmotivoVisita;
	JComboBox selcombustible, selABS, selGPS, selairbags, selclimatizacion, seldescapotable, selduenho;
	Vehiculo dep;
	Persona cl;
	String smatricula, smarca, smodelo, scombustible, sidcliente, smotivoVisita, snPasajeros, scapAlmacenamiento, smaxVelocidad, snRuedas, snPuertas, scapMotor, sduenho;
	boolean sABS, sairbags, sGPS, sclimatizacion, sdescapotable;

	public MenuEditarDeportivo(){
		super("Taller"); //Nome
        //declarar e colocar fondo
        PanelImagen p = new PanelImagen(); //Panel que conten a imaxe
        setContentPane(p); //Asignar panel
        setSize(800,700); //Tamanho ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Poder cerrar a ventana.
        setResizable(false); //Que non se poda cambiar o tamaanho da ventana
        setLayout(new GridBagLayout()); //Distribucion da ventana
        setLocationRelativeTo(null); //Colocar a ventana no centro
        
        dep = new Deportivo();
        cl = new Cliente();
        
        smatricula = dep.getMatricula(MenuEditarDeportivoLista.id);
        smarca = dep.getMarca(MenuEditarDeportivoLista.id);
        smodelo = dep.getModelo(MenuEditarDeportivoLista.id);
        scombustible = dep.getCombustible(MenuEditarDeportivoLista.id);
        snPuertas = dep.getnPuertas(MenuEditarDeportivoLista.id);
        snRuedas = dep.getnRuedas(MenuEditarDeportivoLista.id);
        smaxVelocidad = dep.getMaxVelocidad(MenuEditarDeportivoLista.id);
        scapMotor = dep.getCapMotor(MenuEditarDeportivoLista.id);
        scapAlmacenamiento = dep.getCapAlmacenamiento(MenuEditarDeportivoLista.id);
        snPasajeros = dep.getnPasajeros(MenuEditarDeportivoLista.id);
        sABS = dep.isABS(MenuEditarDeportivoLista.id);
        sGPS = dep.isGPS(MenuEditarDeportivoLista.id);
        sairbags = dep.isAirbags(MenuEditarDeportivoLista.id);
        sclimatizacion = dep.isClimatizacion(MenuEditarDeportivoLista.id);
        sdescapotable = dep.isDescapotable(MenuEditarDeportivoLista.id);
        sduenho = dep.getIdcliente(MenuEditarDeportivoLista.id);
        smotivoVisita = dep.getMotivoVisita(MenuEditarDeportivoLista.id);
                  
        atras = new Boton("ATR?S", 200, 110);
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
        panel5 = new JPanel(); 
        panel5.setBackground(co);
        panel5.setLayout(new FlowLayout());
        panel6 = new JPanel(); 
        panel6.setBackground(co);
        panel6.setLayout(new FlowLayout());
        panel7 = new JPanel(); 
        panel7.setBackground(co);
        panel7.setLayout(new FlowLayout());
        panel8 = new JPanel(); 
        panel8.setBackground(co);
        panel8.setLayout(new FlowLayout());
        panel9 = new JPanel(); 
        panel9.setBackground(co);
        panel9.setLayout(new FlowLayout());
        panel10 = new JPanel(); 
        panel10.setBackground(co);
        panel10.setLayout(new FlowLayout());
        
        label = new JLabel("EDITAR DEPORTIVO");
        label.setFont(new Font("Lucida Sans", Font.BOLD, 20));
        label.setForeground(col);	
        
        
        matricula = new JLabel("Matr?cula: ");
        matricula.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        matricula.setForeground(col);	
        marca = new JLabel("Marca");
        marca.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        marca.setForeground(col);	
        modelo = new JLabel("Modelo: ");
        modelo.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        modelo.setForeground(col);	
        combustible = new JLabel("Combustible: ");
        combustible.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        combustible.setForeground(col);	
        nPuertas = new JLabel("N? Puertas: ");
        nPuertas.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        nPuertas.setForeground(col);	
        nRuedas = new JLabel("N? Ruedas: ");
        nRuedas.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        nRuedas.setForeground(col);			
        nPasajeros = new JLabel("N? Pasajeros: ");
        nPasajeros.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        nPasajeros.setForeground(col);	
        maxVelocidad = new JLabel("Velocidad m?x.: ");
        maxVelocidad.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        maxVelocidad.setForeground(col);		
        capMotor = new JLabel("Cap. Motor: ");
        capMotor.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        capMotor.setForeground(col);		
        capAlmacenamiento = new JLabel("Cap. Almacenamiento: ");
        capAlmacenamiento.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        capAlmacenamiento.setForeground(col);	
        ABS = new JLabel("ABS: ");
        ABS.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        ABS.setForeground(col);	
        GPS = new JLabel("GPS: ");
        GPS.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        GPS.setForeground(col);
        airbags = new JLabel("Airbags: ");
        airbags.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        airbags.setForeground(col);	
        climatizacion = new JLabel("Climatizaci?n: ");
        climatizacion.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        climatizacion.setForeground(col);	
        climatizacion = new JLabel("Climatizaci?n: ");
        climatizacion.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        climatizacion.setForeground(col);	
        descapotable = new JLabel("Descapotable: ");
        descapotable.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        descapotable.setForeground(col);	
        climatizacion = new JLabel("Climatizaci?n: ");
        climatizacion.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        climatizacion.setForeground(col);	
        motivoVisita = new JLabel("Motivo Visita: ");
        motivoVisita.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        motivoVisita.setForeground(col);	
        duenho = new JLabel("Due?o: ");
        duenho.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        duenho.setForeground(col);			
        
        inputmatricula = new JTextField(10);
        inputmatricula.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputmatricula.setForeground(col);	
        inputmatricula.setBackground(co);
        inputmatricula.setEditable(true);
        inputmatricula.setEnabled(true);
        inputmatricula.setFocusable(true);
        inputmatricula.requestFocus();
        inputmatricula.setText(smatricula);
        inputmarca = new JTextField(10);
        inputmarca.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputmarca.setForeground(col);	
        inputmarca.setBackground(co);
        inputmarca.setEditable(true);
        inputmarca.setEnabled(true);
        inputmarca.setFocusable(true);
        inputmarca.requestFocus();
        inputmarca.setText(smarca);
        inputmodelo = new JTextField(10);
        inputmodelo.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputmodelo.setForeground(col);	
        inputmodelo.setBackground(co);
        inputmodelo.setEditable(true);
        inputmodelo.setEnabled(true);
        inputmodelo.setFocusable(true);
        inputmodelo.requestFocus();
        inputmodelo.setText(smodelo);
        inputnPuertas = new JTextField(10);
        inputnPuertas.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputnPuertas.setForeground(col);	
        inputnPuertas.setBackground(co);
        inputnPuertas.setEditable(true);
        inputnPuertas.setEnabled(true);
        inputnPuertas.setFocusable(true);
        inputnPuertas.requestFocus();
        inputnPuertas.setText(snPuertas);
        inputnRuedas = new JTextField(10);
        inputnRuedas.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputnRuedas.setForeground(col);	
        inputnRuedas.setBackground(co);
        inputnRuedas.setEditable(true);
        inputnRuedas.setEnabled(true);
        inputnRuedas.setFocusable(true);
        inputnRuedas.requestFocus();
        inputnRuedas.setText(snRuedas);
        inputmaxVelocidad = new JTextField(10);
        inputmaxVelocidad.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputmaxVelocidad.setForeground(col);	
        inputmaxVelocidad.setBackground(co);
        inputmaxVelocidad.setEditable(true);
        inputmaxVelocidad.setEnabled(true);
        inputmaxVelocidad.setFocusable(true);
        inputmaxVelocidad.requestFocus();
        inputmaxVelocidad.setText(smaxVelocidad);
        inputcapMotor = new JTextField(10);
        inputcapMotor.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputcapMotor.setForeground(col);	
        inputcapMotor.setBackground(co);
        inputcapMotor.setEditable(true);
        inputcapMotor.setEnabled(true);
        inputcapMotor.setFocusable(true);
        inputcapMotor.requestFocus();
        inputcapMotor.setText(scapMotor);
        inputmaxVelocidad.setText(scapMotor);
        inputcapAlmacenamiento = new JTextField(10);
        inputcapAlmacenamiento.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputcapAlmacenamiento.setForeground(col);	
        inputcapAlmacenamiento.setBackground(co);
        inputcapAlmacenamiento.setEditable(true);
        inputcapAlmacenamiento.setEnabled(true);
        inputcapAlmacenamiento.setFocusable(true);
        inputcapAlmacenamiento.requestFocus();
        inputcapAlmacenamiento.setText(scapAlmacenamiento);
        inputnPasajeros = new JTextField(10);
        inputnPasajeros.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputnPasajeros.setForeground(col);	
        inputnPasajeros.setBackground(co);
        inputnPasajeros.setEditable(true);
        inputnPasajeros.setEnabled(true);
        inputnPasajeros.setFocusable(true);
        inputnPasajeros.requestFocus();
        inputnPasajeros.setText(snPasajeros);
        inputmotivoVisita = new JTextField(10);
        inputmotivoVisita.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputmotivoVisita.setForeground(col);	
        inputmotivoVisita.setBackground(co);
        inputmotivoVisita.setEditable(true);
        inputmotivoVisita.setEnabled(true);
        inputmotivoVisita.setFocusable(true);
        inputmotivoVisita.requestFocus();
        inputmotivoVisita.setText(smotivoVisita);
        
        selcombustible = new JComboBox();
        selcombustible.setFont(new Font("Lucida Sans", Font.PLAIN , 12)); 
        selcombustible.addItem("di?sel");
        selcombustible.addItem("gasolina");
        selcombustible.addItem("el?ctrico");
        selcombustible.setSelectedItem(scombustible);
        selABS = new JComboBox();
        selABS.setFont(new Font("Lucida Sans", Font.PLAIN , 12)); 
        selABS.addItem("si");
        selABS.addItem("no");
        if (sABS == true) {
        	selABS.setSelectedItem("si");
        }
        else {
        	selABS.setSelectedItem("no");
        }
        selGPS = new JComboBox();
        selGPS.setFont(new Font("Lucida Sans", Font.PLAIN , 12)); 
        selGPS.addItem("si");
        selGPS.addItem("no");
        if (sGPS == true) {
        	selGPS.setSelectedItem("si");
        }
        else {
        	selGPS.setSelectedItem("no");
        }
        selairbags = new JComboBox();
        selairbags.setFont(new Font("Lucida Sans", Font.PLAIN , 12)); 
        selairbags.addItem("si");
        selairbags.addItem("no");
        if (sairbags == true) {
        	selairbags.setSelectedItem("si");
        }
        else {
        	selairbags.setSelectedItem("no");
        }
        selclimatizacion = new JComboBox();
        selclimatizacion.setFont(new Font("Lucida Sans", Font.PLAIN , 12)); 
        selclimatizacion.addItem("si");
        selclimatizacion.addItem("no");
        if (sclimatizacion == true) {
        	selclimatizacion.setSelectedItem("si");
        }
        else {
        	selclimatizacion.setSelectedItem("no");
        }
        seldescapotable = new JComboBox();
        seldescapotable.setFont(new Font("Lucida Sans", Font.PLAIN , 12)); 
        seldescapotable.addItem("si");
        seldescapotable.addItem("no");
        if (sdescapotable == true) {
        	seldescapotable.setSelectedItem("si");
        }
        else {
        	seldescapotable.setSelectedItem("no");
        }
        selduenho = new JComboBox();
        selduenho.setFont(new Font("Lucida Sans", Font.PLAIN , 12)); 
        
        String nombreper = cl.NombrePersona().toString();
        nombreper = nombreper.replace("[", "").replace("]", "");
        String[] parts = nombreper.split(",");
        String apellidoper = cl.ApellidoPersona().toString();
        apellidoper = apellidoper.replace("[", "").replace("]", "");
        String[] parts2 = apellidoper.split(",");
        String idcliente2 = cl.IDPersona().toString();
        idcliente2 = idcliente2.replace("[", "").replace("]", "");
        String[] parts3 = idcliente2.split(",");
        for (int i=0; i< parts.length; i++) {
        	selduenho.addItem(parts[i].trim()+" "+parts2[i].trim()+" ("+parts3[i].trim()+")");
            if(sduenho.equals(parts3[i].trim())) {
        		selduenho.setSelectedItem(parts[i].trim()+" "+parts2[i].trim()+" ("+parts3[i].trim()+")");
        	}
        }
        
      //A?adense as etiquetas os paneles
  		panel.add(label);
  		panel2.add(matricula);
  		panel2.add(inputmatricula);
  		panel2.add(marca);
  		panel2.add(inputmarca);
  		panel3.add(modelo);
  		panel3.add(inputmodelo);
  		panel3.add(nPuertas);
  		panel3.add(inputnPuertas);
  		panel4.add(nRuedas);
  		panel4.add(inputnRuedas);
  		panel4.add(maxVelocidad);
  		panel4.add(inputmaxVelocidad);
  		panel5.add(maxVelocidad);
  		panel5.add(inputmaxVelocidad);
  		panel5.add(capMotor);
  		panel5.add(inputcapMotor);
  		panel6.add(capAlmacenamiento);
  		panel6.add(inputcapAlmacenamiento);
  		panel6.add(nPasajeros);
  		panel6.add(inputnPasajeros);
  		panel7.add(motivoVisita);
  		panel7.add(inputmotivoVisita);
  		panel7.add(combustible);
  		panel7.add(selcombustible);
  		panel8.add(ABS);
  		panel8.add(selABS);
  		panel8.add(GPS);
  		panel8.add(selGPS);
  		panel8.add(airbags);
  		panel8.add(selairbags);
  		panel9.add(climatizacion);
  		panel9.add(selclimatizacion);
  		panel9.add(descapotable);
  		panel9.add(seldescapotable);
  		panel10.add(duenho);
  		panel10.add(selduenho);
		
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
		c.insets=new Insets(10,100,10,100); //ponher marxes
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
		c.insets=new Insets(10,200,10,200); //ponher marxes
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
		
		c.gridx=0; // especifica a coordenada x
		c.gridy=5;	// coordenada y
		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=0;
		c.insets=new Insets(10,100,10,100); //ponher marxes
		add(panel6,c);
		
		c.gridx=0; // especifica a coordenada x
		c.gridy=6;	// coordenada y
		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=0;
		c.insets=new Insets(10,100,10,100); //ponher marxes
		add(panel7,c);
		
		c.gridx=0; // especifica a coordenada x
		c.gridy=7;	// coordenada y
		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=0;
		c.insets=new Insets(10,100,10,100); //ponher marxes
		add(panel8,c);
				
		c.gridx=0; // especifica a coordenada x
		c.gridy=8;	// coordenada y
		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=0;
		c.insets=new Insets(10,100,10,100); //ponher marxes
		add(panel9,c);
		
		c.gridx=0; // especifica a coordenada x
		c.gridy=9;	// coordenada y
		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=0;
		c.insets=new Insets(10,100,10,100); //ponher marxes
		add(panel10,c);
			
		c.gridx=0; 
		c.gridy=10;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0; 
		c.insets=new Insets(10,400,10,10); 
		add(atras,c);
		
		c.gridx=0; 		
		c.gridy=10;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(10,10,10,400); 
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
		
		if (e.getActionCommand().equals("ATR?S")) {
			MenuDeportivos men = new MenuDeportivos();
			dispose();
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) men.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
		if (e.getActionCommand().equals("ENVIAR")) {
	        String idcli, a, g, airb, clim, des;
			String resul = (String) selduenho.getSelectedItem();
	        int inicio = resul.indexOf("(");
			int fin = resul.indexOf(")");
			
			idcli = resul.substring(inicio + 1, fin);
	        String combus = (String) selcombustible.getSelectedItem();
	       
	        if(selABS.getSelectedItem() == "si") {
	        	a = "true";
	        }
	        else {
	        	a = "false";
	        }
	        
	        if(selGPS.getSelectedItem() == "si") {
	        	g = "true";
	        }
	        else {
	        	g = "false";
	        }
	        
	        if(selairbags.getSelectedItem() == "si") {
	        	airb = "true";
	        }
	        else {
	        	airb = "false";
	        }
	        
	        if(selclimatizacion.getSelectedItem() == "si") {
	        	clim = "true";
	        }
	        else {
	        	clim = "false";
	        }
	        
	        if(seldescapotable.getSelectedItem() == "si") {
	        	des = "true";
	        }
	        else {
	        	des = "false";
	        }
	        	
	        if (dep.editar(MenuEditarDeportivoLista.id, inputmarca.getText(), inputmodelo.getText(), inputmatricula.getText(), combus, inputnPuertas.getText(), inputnRuedas.getText(), inputmaxVelocidad.getText(), inputcapMotor.getText(), inputcapAlmacenamiento.getText(), inputnPasajeros.getText(), a, g, airb, clim, des, idcli, inputmotivoVisita.getText())) {
				MenuListadoDeportivos men = new MenuListadoDeportivos();
				dispose();
				men.setVisible(true);
				
				//para desactivar o espacio no control de menu
				JPanel panel = (JPanel) men.getContentPane();
				
				panel.addKeyListener(this);
				panel.setFocusable(true);
			}
			else {				
				MenuErrorRegistroDeportivo men = new MenuErrorRegistroDeportivo();
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
