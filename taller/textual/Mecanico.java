package textual;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */
public class Mecanico extends Persona
{

	public Mecanico() {}
	
	@Override
	public boolean insertar(String dni, String nombre, String apellidos, String numTelefono, String correoElectronico, String direccion) {		
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
    	
    	fechaAlta = annio + "-" + mes2 + "-" + dia2;
    	
    	try {
	        String sql = "INSERT INTO persona (`dni`, `nombre`, `apellidos`, `telf`, `correo`, `direccion` `fechaAlta`, `tipoPersona`) VALUES ("
	        		+"'"+dni+"','"+nombre+"','"+apellidos+"','"+numTelefono+"','"+correoElectronico+"','"+direccion+"','"+fechaAlta+"','2')";
	        sentencia.executeUpdate(sql);	
	        return true;

		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public String listar() {

		try {
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE tipoPersona = '2'");
			
			if (resultado.next() == true) //move o cursor
			{	
				soluciones = "<html><body><table><tr><th>DNI</th><th>NOMBRE</th><th>APELLIDOS</th><th>TELÉFONO</th><th>CORREO</th><th>DIRECCIÓN</th><th>FECHA ALTA</th></tr>";
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					dni = resultado.getString(2); //dni
					nombre = resultado.getString(3); //nombre
					apellidos = resultado.getString(4); //apellidos
					numTelefono = resultado.getString(5); //telefono
					correoElectronico = resultado.getString(6); //correo
					direccion = resultado.getString(7); //direccion
					fechaAlta = resultado.getString(8); //fechaalta
					
					soluciones+="<tr><td>"+dni+"</td><td>"+nombre+"</td><td>"+apellidos+"</td><td>"+numTelefono+"</td><td>"+correoElectronico+"</td><td>"+direccion+"</td><td>"+fechaAlta+"</td></tr>";
				
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
	
	@Override
	public String consultarporDNI(String dni) {
    	
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE UPPER(dni) LIKE UPPER('%"+dni+"%') AND tipoPersona='2'"); 
		    
			if (resultado.next() == true) //move o cursor
			{	
				soluciones = "<html><body><table><tr><th>DNI</th><th>NOMBRE</th><th>APELLIDOS</th><th>TELÉFONO</th><th>CORREO</th><th>DIRECCIÓN</th><th>FECHA ALTA</th></tr>";
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					dni = resultado.getString(2); //dni
					nombre = resultado.getString(3); //nombre
					apellidos = resultado.getString(4); //apellidos
					numTelefono = resultado.getString(5); //telefono
					correoElectronico = resultado.getString(6); //correo
					direccion = resultado.getString(7); //direccion
					fechaAlta = resultado.getString(8); //fechaalta
					
					soluciones+="<tr><td>"+dni+"</td><td>"+nombre+"</td><td>"+apellidos+"</td><td>"+numTelefono+"</td><td>"+correoElectronico+"</td><td>"+direccion+"</td><td>"+fechaAlta+"</td></tr>";
				
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
	
	@Override
	public String consultarporNombre(String nombre) {
    	
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE UPPER(nombre) LIKE UPPER('%"+nombre+"%') AND tipoPersona='2'");
			
			if (resultado.next() == true) //move o cursor
			{	
				soluciones = "<html><body><table><tr><th>DNI</th><th>NOMBRE</th><th>APELLIDOS</th><th>TELÉFONO</th><th>CORREO</th><th>DIRECCIÓN</th><th>FECHA ALTA</th></tr>";
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					dni = resultado.getString(2); //dni
					nombre = resultado.getString(3); //nombre
					apellidos = resultado.getString(4); //apellidos
					numTelefono = resultado.getString(5); //telefono
					correoElectronico = resultado.getString(6); //correo
					direccion = resultado.getString(7); //direccion
					fechaAlta = resultado.getString(8); //fechaalta
					
					soluciones+="<tr><td>"+dni+"</td><td>"+nombre+"</td><td>"+apellidos+"</td><td>"+numTelefono+"</td><td>"+correoElectronico+"</td><td>"+direccion+"</td><td>"+fechaAlta+"</td></tr>";
				
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
	
	@Override
	public String consultarporApellidos(String apellidos) {
    	
		try {
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE UPPER(apellidos) LIKE UPPER('%"+apellidos+"%') AND tipoPersona='2'");
			
			if (resultado.next() == true) //move o cursor
			{	
				soluciones = "<html><body><table><tr><th>DNI</th><th>NOMBRE</th><th>APELLIDOS</th><th>TELÉFONO</th><th>CORREO</th><th>DIRECCIÓN</th><th>FECHA ALTA</th></tr>";
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					dni = resultado.getString(2); //dni
					nombre = resultado.getString(3); //nombre
					apellidos = resultado.getString(4); //apellidos
					numTelefono = resultado.getString(5); //telefono
					correoElectronico = resultado.getString(6); //correo
					direccion = resultado.getString(7); //direccion
					fechaAlta = resultado.getString(8); //fechaalta
					
					soluciones+="<tr><td>"+dni+"</td><td>"+nombre+"</td><td>"+apellidos+"</td><td>"+numTelefono+"</td><td>"+correoElectronico+"</td><td>"+direccion+"</td><td>"+fechaAlta+"</td></tr>";
				
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

	@Override
	public ArrayList NombrePersona() {
		nombreapellidos = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE tipoPersona = '2'");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					nombre = resultado.getString(3); //nombre
					
					nombreapellidos.add(nombre);
				}
			}
			else {
				nombreapellidos.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombreapellidos;		
	}
	
	@Override
	public ArrayList ApellidoPersona() {
		nombreapellidos = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE tipoPersona = '2'");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					apellidos = resultado.getString(4); //apellidos
					
					nombreapellidos.add(apellidos);
				}
			}
			else {
				nombreapellidos.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombreapellidos;		
	}
	
	@Override
	public ArrayList IDPersona() {
		nombreapellidos = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE tipoPersona = '2'");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					id = resultado.getString(1); //nombre
					
					nombreapellidos.add(id);
				}
			}
			else {
				nombreapellidos.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombreapellidos;		
	}
	
}
