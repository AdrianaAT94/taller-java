
package graficofichas;

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
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import graficoprincipal.Boton;
import graficoprincipal.PanelImagen;
import textual.Ficha;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */

public class MenuListadoFichasEscribirCliente extends JFrame implements KeyListener, ActionListener {

	//Botons menu
	Boton atras, enviar;
	Font fuente;
	JPanel panel, panel2, panel3, panel4;
	JLabel label, label2, cliente, fechaEntrada1, fechaEntrada2;
	static JTextField input, inputfechaEntrada1, inputfechaEntrada2;
	Ficha fic;
	
	public MenuListadoFichasEscribirCliente(){
		super("Taller"); //Nome
        //declarar e colocar fondo
        PanelImagen p = new PanelImagen(); //Panel que conten a imaxe
        setContentPane(p); //Asignar panel
        setSize(800,700); //Tamanho ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Poder cerrar a ventana.
        setResizable(false); //Que non se poda cambiar o tamaanho da ventana
        setLayout(new GridBagLayout()); //Distribucion da ventana
        setLocationRelativeTo(null); //Colocar a ventana no centro
        
        String dia2 = "";
		String mes2 = "";
        
        Calendar cal = Calendar.getInstance();
    	int dia = cal.get(Calendar.DATE);
    	if (dia<10) {
    		dia2 = "0"+dia;
    	}
    	else {
    		dia2 = ""+dia;
    	}
    	int mes = cal.get(Calendar.MONTH) + 1;
    	if (mes<10) {
    		mes2 = "0"+mes;
    	}
    	else {
    		mes2 = ""+mes;
    	}
    	int annio = cal.get(Calendar.YEAR);
    	
    	String fechaActual = annio + "-" + mes2 + "-" + dia2;
        
        fic = new Ficha();
       
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
        
        panel3 = new JPanel(); 
        panel3.setBackground(co);
        panel3.setLayout(new FlowLayout());
        panel4 = new JPanel(); 
        panel4.setBackground(co);
        panel4.setLayout(new FlowLayout());
        
        label = new JLabel("BUSCADOR POR CLIENTE DE FICHAS");
        label.setFont(new Font("Lucida Sans", Font.BOLD, 20));
        label.setForeground(col);	
        
        label2 = new JLabel("¿Que cliente (nombre) quieres buscar?");
        label2.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        label2.setForeground(col);	

        cliente = new JLabel("Nombre Cliente: ");
        cliente.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        cliente.setForeground(col);	
        fechaEntrada1 = new JLabel("Rango Fecha Inicial: ");
        fechaEntrada1.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        fechaEntrada1.setForeground(col);	
        fechaEntrada2 = new JLabel("Rango Fecha Final: ");
        fechaEntrada2.setFont(new Font("Lucida Sans", Font.PLAIN, 14));
        fechaEntrada2.setForeground(col);	
        
        input = new JTextField(30);
        input.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        input.setForeground(col);	
        input.setBackground(co);
        input.setEditable(true);
        input.setEnabled(true);
        input.setFocusable(true);
        input.requestFocus();
        inputfechaEntrada1 = new JTextField(10);
        inputfechaEntrada1.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputfechaEntrada1.setForeground(col);	
        inputfechaEntrada1.setBackground(co);
        inputfechaEntrada1.setEditable(true);
        inputfechaEntrada1.setEnabled(true);
        inputfechaEntrada1.setFocusable(true);
        inputfechaEntrada1.requestFocus();
        inputfechaEntrada2 = new JTextField(10);
        inputfechaEntrada2.setFont(new Font("Lucida Sans", Font.PLAIN , 12));
        inputfechaEntrada2.setForeground(col);	
        inputfechaEntrada2.setBackground(co);
        inputfechaEntrada2.setEditable(true);
        inputfechaEntrada2.setEnabled(true);
        inputfechaEntrada2.setFocusable(true);
        inputfechaEntrada2.requestFocus();
        inputfechaEntrada2.setText(fechaActual);
		
		//Añadense as etiquetas os paneles
		panel.add(label);
		panel2.add(label2);
		panel3.add(cliente);
		panel3.add(input);
		panel4.add(fechaEntrada1);
		panel4.add(inputfechaEntrada1);
		panel4.add(fechaEntrada2);
		panel4.add(inputfechaEntrada2);
		
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
		c.insets=new Insets(10,200,10,200); //ponher marxes
		add(panel2,c);
		
		c.gridx=0; // especifica a coordenada x
		c.gridy=2;	// coordenada y
		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=0;
		c.insets=new Insets(150,100,10,100); //ponher marxes
		add(panel3,c);
		
		c.gridx=0; // especifica a coordenada x
		c.gridy=3;	// coordenada y
		c.gridwidth=1; //numero de celdas que ocupa no GridBagLayout
		c.gridheight=1; 
		c.anchor=GridBagConstraints.CENTER; //posicion dentro dunha celda
		c.fill=GridBagConstraints.BOTH; //espacio que ocupara dentro dunha celda
		c.weightx=1.0; //porcentaxe de espazo libre que ocupara 
		c.weighty=0;
		c.insets=new Insets(10,100,50,100); //ponher marxes //ponher marxes
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
			MenuConsultaFichas men = new MenuConsultaFichas();
			dispose();
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) men.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
		if (e.getActionCommand().equals("ENVIAR")) {
			MenuListadoFichasPorCliente men = new MenuListadoFichasPorCliente();
			dispose();
			men.setVisible(true);
			
			//para desactivar o espacio no control de menu
			JPanel panel = (JPanel) men.getContentPane();
			
			panel.addKeyListener(this);
			panel.setFocusable(true);
		}
	}
}
