package graficoitv;

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
import graficoprincipal.Boton;
import graficoprincipal.PanelImagen;
import textual.ITV;
import textual.Persona;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */

public class MenuNuevoVehiculoITV extends JFrame implements KeyListener, ActionListener {

	//Botons menu
	Boton atras, enviar;
	Font fuente;
	JPanel panel, panel2;
	JLabel label, vehiculo;
	JComboBox selvehiculo;
	ITV itv;
	Persona cl;
	Color co, col;
	
	public MenuNuevoVehiculoITV(){
		super("Taller"); //Nome
        //declarar e colocar fondo
        PanelImagen p = new PanelImagen(); //Panel que conten a imaxe
        setContentPane(p); //Asignar panel
        setSize(800,700); //Tamanho ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Poder cerrar a ventana.
        setResizable(false); //Que non se poda cambiar o tamaanho da ventana
        setLayout(new GridBagLayout()); //Distribucion da ventana
        setLocationRelativeTo(null); //Colocar a ventana no centro
        
        itv = new ITV();
       
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
                
        label = new JLabel("NUEVO VEHÍCULO PARA ITV");
        label.setFont(new Font("Lucida Sans", Font.BOLD, 20));
        label.setForeground(col);	
        
        vehiculo = new JLabel("Vehículo: ");
        vehiculo.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        vehiculo.setForeground(col);
       
        selvehiculo = new JComboBox();
        selvehiculo.setFont(new Font("Lucida Sans", Font.PLAIN , 12));

    	String marcavehiculo = itv.VehiculoMarca().toString();
        marcavehiculo = marcavehiculo.replace("[", "").replace("]", "");
        String[] vehparts1 = marcavehiculo.split(",");
        String modelovehiculo = itv.VehiculoModelo().toString();
        modelovehiculo = modelovehiculo.replace("[", "").replace("]", "");
        String[] vehparts2 = modelovehiculo.split(",");
        String matriculavehiculo = itv.VehiculoMatricula().toString();
        matriculavehiculo = matriculavehiculo.replace("[", "").replace("]", "");
        String[] vehparts4 = matriculavehiculo.split(",");
        String idvehiculo = itv.VehiculoID().toString();
        idvehiculo = idvehiculo.replace("[", "").replace("]", "");
        String[] vehparts5 = idvehiculo.split(",");
        for (int i=0; i< vehparts5.length; i++) {
        	if (vehparts5[i].isEmpty()) {
        		selvehiculo.addItem("Sin vehiculos");
        	}
        	else {
	        	selvehiculo.addItem(vehparts1[i].trim()+" "+vehparts2[i].trim()+" "+vehparts4[i].trim()+" ("+vehparts5[i].trim()+")");
	       }
        }
		//Añadense as etiquetas os paneles
		panel.add(label);
		panel2.add(vehiculo);
		panel2.add(selvehiculo);
		
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
		c.insets=new Insets(250,100,10,100); //ponher marxes
		add(panel2,c);
		
		c.gridx=0; 
		c.gridy=5;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0; 
		c.insets=new Insets(200,10,10,400); 
		add(atras,c);
		
		c.gridx=0; 		
		c.gridy=5;	
		c.gridwidth=1; 
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; 
		c.fill=GridBagConstraints.BOTH; 
		c.weightx=1.0; 
		c.weighty=1.0;
		c.insets=new Insets(200,400,10,10); 
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
			MenuITV men = new MenuITV();
			dispose();
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) men.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
		if (e.getActionCommand().equals("ENVIAR")) {
			String idveh;
			String resulveh = (String) selvehiculo.getSelectedItem();
			int inicioveh = resulveh.indexOf("(");
			int finveh = resulveh.indexOf(")");
			idveh = resulveh.substring(inicioveh + 1, finveh);
				
			if (itv.insertar(idveh)) {
				MenuListadoVehiculosITV men = new MenuListadoVehiculosITV();
				dispose();
				men.setVisible(true);
				
				//para desactivar o espacio no control de menu
				JPanel panel = (JPanel) men.getContentPane();
				
				panel.addKeyListener(this);
				panel.setFocusable(true);				
			}
			else {
				MenuErrorRegistroITV men = new MenuErrorRegistroITV();
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
