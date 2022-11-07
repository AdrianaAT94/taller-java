package textual;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */
public class Ofertas
{
    protected String idofertaenviada, nombreoferta, clienteoferta, clienteapeloferta, correoclienteoferta, correocomercialoferta, comercialoferta, idoferta, idcomercial, idcliente, soluciones, fecha, fechaActual;
    protected ArrayList nombreofertas;
    
    static ConexionBD con;
    static Connection conex;
    static Statement sentencia, sentencia2, sentencia3, sentencia4;
    static ResultSet resultado, resultado2, resultado3, resultado4;

    public Ofertas()
    {
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
    	
    	fechaActual = annio + "-" + mes2 + "-" + dia2;
    	
        con = new ConexionBD();
        conex = con.getCon();
        try {
			sentencia = conex.createStatement();
			sentencia2 = conex.createStatement();
			sentencia3 = conex.createStatement();
			sentencia4 = conex.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    }
    
	public String getFecha(String idoferta) {
    	try {
			resultado = sentencia.executeQuery("SELECT MAX(id) FROM oferta_enviada WHERE idOferta='"+idoferta+"'");
			while (resultado.next()) {
				idofertaenviada = resultado.getString(1); //id
				resultado2 = sentencia2.executeQuery("SELECT * FROM oferta_enviada WHERE id='"+idofertaenviada+"'");
				while (resultado2.next()) {
					fecha = resultado2.getString(5); //id
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fecha;
	}
	
	public boolean insertar(String descripcion) {

    	try {
	        String sql = "INSERT INTO ofertas (`nombre_oferta`) VALUES ('"+descripcion+"')";
	        sentencia.executeUpdate(sql);
	        return true;

		} catch(SQLException e) {
			e.printStackTrace();		
			return false;
		}
	}
	
	public boolean enviar(String idcli, String idcom, String idofe) {
		String dia2 = "";
		String mes2 = "";
        
        Calendar c = Calendar.getInstance();
    	int dia = c.get(Calendar.DATE);
    	if (dia<10) {
    		dia2 = "0"+dia;
    	}
    	else {
    		dia2 = ""+dia;
    	}
    	int mes = c.get(Calendar.MONTH) + 1;
    	if (mes<10) {
    		mes2 = "0"+mes;
    	}
    	else {
    		mes2 = ""+mes;
    	}
    	int annio = c.get(Calendar.YEAR);
    	
    	fecha = annio + "-" + mes2 + "-" + dia2;
    	try {
	        String sql = "INSERT INTO oferta_enviada (`idOferta`, `idCliente`, `idComercial`, `fechaenvio`) VALUES ('"+idofe+"','"+idcli+"','"+idcom+"','"+fecha+"')";
	        sentencia.executeUpdate(sql);
	        return true;

		} catch(SQLException e) {
			e.printStackTrace();		
			return false;
		}
	}
	
	public String listar() {
        
		try {
			resultado = sentencia.executeQuery("SELECT * FROM ofertas");
			
			if (resultado.next() == true) //move o cursor
			{	
				soluciones = "<html><body><table><tr><th>OFERTAS</th></tr>";
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					nombreoferta = resultado.getString(2);
					
					soluciones+="<tr><td>"+nombreoferta+"</td></tr>";
				
				}
				soluciones+="</table></body></html>";
			}
			else {
				soluciones = "No hay resultados.";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soluciones;		
	}
	
	public String listarEnv() {
        
		try {
			resultado = sentencia.executeQuery("SELECT * FROM oferta_enviada");
			
			if (resultado.next() == true) //move o cursor
			{	
				soluciones = "<html><body><table><tr><th>OFERTA</th><th>CLIENTE</th><th>CORREO CLIENTE</th><th>COMERCIAL</th><th>CORREO COMERCIAL</th><th>FECHA ENVÍO</th></tr>";
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					idoferta = resultado.getString(2);
					idcliente = resultado.getString(3);
					idcomercial = resultado.getString(4);
					fecha = resultado.getString(5);
					resultado2 = sentencia2.executeQuery("SELECT * FROM persona WHERE id='"+idcliente+"'");
					while (resultado2.next())
					{
						clienteoferta = resultado2.getString(3) + " " + resultado2.getString(4);
						correoclienteoferta = resultado2.getString(6);
					}
					resultado3 = sentencia3.executeQuery("SELECT * FROM persona WHERE id='"+idcomercial+"'");
					while (resultado3.next())
					{
						comercialoferta = resultado3.getString(3) + " " + resultado3.getString(4);
						correocomercialoferta = resultado3.getString(6);
					}
					resultado4 = sentencia4.executeQuery("SELECT * FROM ofertas WHERE id='"+idoferta+"'");
					while (resultado4.next())
					{
						nombreoferta = resultado4.getString(2);
					}
					
					soluciones+="<tr><td>"+nombreoferta+"</td><td>"+clienteoferta+"</td><td>"+correoclienteoferta+"</td><td>"+comercialoferta+"</td><td>"+correocomercialoferta+"</td><td>"+fecha+"</td></tr>";
				
				}
				soluciones+="</table></body></html>";
			}
			else {
				soluciones = "No hay resultados.";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soluciones;		
	}
    
	public boolean borrar(String id) {
		
		try {
	        sentencia.executeUpdate("DELETE FROM ofertas WHERE id='"+id+"'");
	        return true;

		} catch(SQLException e) {
			e.printStackTrace();	
			return false;
		}
	}
	
	public ArrayList NombreOfertas() {
		nombreofertas = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM ofertas");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					nombreoferta = resultado.getString(2); //nombre
					
					nombreofertas.add(nombreoferta);
				}
			}
			else {
				nombreofertas.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombreofertas;		
	}
	
	public ArrayList IDOfertas() {
		nombreofertas = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM ofertas");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					idoferta = resultado.getString(1); //id
					
					nombreofertas.add(idoferta);
				}
			}
			else {
				nombreofertas.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombreofertas;		
	}
	
	public ArrayList ClienteDisponiblesOfertas(String idofe) {
		nombreofertas = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE tipoPersona = '1' AND id NOT IN (SELECT idCliente from oferta_enviada WHERE fechaenvio> DATE_ADD('"+fechaActual+"', INTERVAL -1 YEAR) AND idOferta='"+idofe+"')");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					idcliente = resultado.getString(1); //id
					clienteoferta = resultado.getString(3); //nombre
					clienteapeloferta = resultado.getString(4); //apellidos
					nombreofertas.add(clienteoferta+" "+clienteapeloferta+" ("+idcliente+")");
				}
			}
			else {
				nombreofertas.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombreofertas;		
	}
	
    public void cerrarMetodos() {
    	try {
	    	resultado.close();
	    	resultado2.close();
	    	resultado3.close();
	    	resultado4.close();
			sentencia.close();
			sentencia2.close();
			sentencia3.close();
			sentencia4.close();
	    	conex.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }   
}
