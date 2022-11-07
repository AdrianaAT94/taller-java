package graficoofertas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import graficoprincipal.Boton;
import graficoprincipal.PanelImagen;
import textual.Cliente;
import textual.Ofertas;
import textual.Comercial;
import textual.Persona;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */

public class MenuEnviarOferta extends JFrame implements KeyListener, ActionListener {

	//Botons menu
	Boton atras, enviar;
	Font fuente;
	JPanel panel, panel2, panel3, panel4;
	JLabel label, cliente, comercial, oferta;
	JComboBox selcliente, selcomercial, seloferta;
	Ofertas ofe;
	Persona cl, com;
	Color co, col;
	String idofe;
	
	public MenuEnviarOferta(){
		super("Taller"); //Nome
        //declarar e colocar fondo
        PanelImagen p = new PanelImagen(); //Panel que conten a imaxe
        setContentPane(p); //Asignar panel
        setSize(800,700); //Tamanho ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Poder cerrar a ventana.
        setResizable(false); //Que non se poda cambiar o tamaanho da ventana
        setLayout(new GridBagLayout()); //Distribucion da ventana
        setLocationRelativeTo(null); //Colocar a ventana no centro
                
        ofe = new Ofertas();
        cl = new Cliente();
        com = new Comercial();
       
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
        
        label = new JLabel("ENVIAR NUEVA OFERTA");
        label.setFont(new Font("Lucida Sans", Font.BOLD, 20));
        label.setForeground(col);	
        
        cliente = new JLabel("Cliente: ");
        cliente.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        cliente.setForeground(col);	
        comercial = new JLabel("Comercial: ");
        comercial.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        comercial.setForeground(col);	
        oferta = new JLabel("Oferta: ");
        oferta.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        oferta.setForeground(col);
        
        selcliente = new JComboBox();
        selcliente.setFont(new Font("Lucida Sans", Font.PLAIN , 12)); 
        
        seloferta = new JComboBox();
        seloferta.setFont(new Font("Lucida Sans", Font.PLAIN , 12)); 
        seloferta.addItemListener(itemListener);

        String nombreofertas = ofe.NombreOfertas().toString();
        nombreofertas = nombreofertas.replace("[", "").replace("]", "");
        String[] partsofe = nombreofertas.split(",");
        String idofertas = ofe.IDOfertas().toString();
        idofertas = idofertas.replace("[", "").replace("]", "");
        String[] parts2ofe = idofertas.split(",");
        for (int i=0; i< partsofe.length; i++) {
            seloferta.addItem(partsofe[i].trim()+" ("+parts2ofe[i].trim()+")");
        }  
           
        selcomercial = new JComboBox();
        selcomercial.setFont(new Font("Lucida Sans", Font.PLAIN , 12)); 

        String nombrecom = com.NombrePersona().toString();
        nombrecom = nombrecom.replace("[", "").replace("]", "");
        String[] partscom = nombrecom.split(",");
        String apellidocom = com.ApellidoPersona().toString();
        apellidocom = apellidocom.replace("[", "").replace("]", "");
        String[] parts2com = apellidocom.split(",");
        String idcomercial = com.IDPersona().toString();
        idcomercial = idcomercial.replace("[", "").replace("]", "");
        String[] parts3com = idcomercial.split(",");
        for (int i=0; i< parts3com.length; i++) {
        	selcomercial.addItem(partscom[i].trim()+" "+parts2com[i].trim()+" ("+parts3com[i].trim()+")");
        }
        
		//Añadense as etiquetas os paneles
		panel.add(label);
		panel2.add(oferta);
		panel2.add(seloferta);
		panel3.add(cliente);
		panel3.add(selcliente);
		panel4.add(comercial);
		panel4.add(selcomercial);
		
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
	
	ItemListener itemListener = new ItemListener() {
	      @Override
		public void itemStateChanged(ItemEvent itemEvent) {
	        ItemSelectable is = itemEvent.getItemSelectable();

			String resul = selectedString(is);
			
			int inicio = resul.indexOf("(");
			int fin = resul.indexOf(")");

			idofe = resul.substring(inicio + 1, fin);

			selcliente.removeAllItems();
			String nombreper = ofe.ClienteDisponiblesOfertas(idofe).toString();
	        nombreper = nombreper.replace("[", "").replace("]", "");
	        String[] parts = nombreper.split(",");
	        
	        for (int i=0; i< parts.length; i++) {
	        	if (parts[i].isEmpty()) {
	        		selcliente.addItem("Sin clientes disponibles");
	        	}
	        	else {
	            	selcliente.addItem(parts[i].trim());
		       }
	        }
	      }
	    };

	    public String selectedString(ItemSelectable is) {
	        Object selected[] = is.getSelectedObjects();
	        return ((selected.length == 0) ? "null" : (String) selected[0]);
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
			MenuOfertas men = new MenuOfertas();
			dispose();
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) men.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
		if (e.getActionCommand().equals("ENVIAR")) {
			String idcli, idcom, idofe;
			String resulcli = (String) selcliente.getSelectedItem();
			String resulcom = (String) selcomercial.getSelectedItem();
			String resulofe = (String) seloferta.getSelectedItem();
			int iniciocli = resulcli.indexOf("(");
			int fincli = resulcli.indexOf(")");
			int iniciocom = resulcom.indexOf("(");
			int fincom = resulcom.indexOf(")");
			int inicioofe = resulofe.indexOf("(");
			int finofe = resulofe.indexOf(")");
			
			idcli = resulcli.substring(iniciocli + 1, fincli);
			idcom = resulcom.substring(iniciocom + 1, fincom);
			idofe = resulofe.substring(inicioofe + 1, finofe);
			
			if (ofe.enviar(idcli, idcom, idofe)) {
				MenuListadoOfertasEnviadas men = new MenuListadoOfertasEnviadas();
				dispose();
				men.setVisible(true);
				
				//para desactivar o espacio no control de menu
				JPanel panel = (JPanel) men.getContentPane();
				
				panel.addKeyListener(this);
				panel.setFocusable(true);				
			}
			else {
				MenuErrorRegistroOferta men = new MenuErrorRegistroOferta();
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
