package textual;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */
public class Cliente extends Persona
{

	public Cliente() {} 
	    	
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
	        String sql = "INSERT INTO persona (`dni`, `nombre`, `apellidos`, `telf`, `correo`, `direccion`, `fechaAlta`, `tipoPersona`) VALUES ("
	        		+"'"+dni+"','"+nombre+"','"+apellidos+"','"+numTelefono+"','"+correoElectronico+"','"+direccion+"','"+fechaAlta+"','1')";
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
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE tipoPersona = '1'");
			
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
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE UPPER(dni) LIKE UPPER('%"+dni+"%') AND tipoPersona='1'");
		    
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
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE UPPER(nombre) LIKE UPPER('%"+nombre+"%') AND tipoPersona='1'");
			
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
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE UPPER(apellidos) LIKE UPPER('%"+apellidos+"%') AND tipoPersona='1'");
			
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
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE tipoPersona = '1'");
			
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
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE tipoPersona = '1'");
			
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
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE tipoPersona = '1'");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					id = resultado.getString(1); //id
					
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
	
	@Override
	public ArrayList VehiculoClientesID(String id) {
		vehiculos = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE idCliente = '"+id+"'");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					idvehiculo = resultado.getString(1); //idvehiculo	
					vehiculos.add(idvehiculo);
				}
			}
			else {
				vehiculos.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehiculos;		
	}
	
	@Override
	public ArrayList VehiculoClientesMarca(String id) {
		vehiculos = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE idCliente = '"+id+"'");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					marca = resultado.getString(2); //marca	
					vehiculos.add(marca);
				}
			}
			else {
				vehiculos.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehiculos;		
	}
	
	@Override
	public ArrayList VehiculoClientesModelo(String id) {
		vehiculos = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE idCliente = '"+id+"'");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					modelo = resultado.getString(3); //modelo	
					vehiculos.add(modelo);
				}
			}
			else {
				vehiculos.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehiculos;		
	}
	
	@Override
	public ArrayList VehiculoClientesMatricula(String id) {
		vehiculos = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE idCliente = '"+id+"'");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					matricula = resultado.getString(4); //matricula	
					vehiculos.add(matricula);
				}
			}
			else {
				vehiculos.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehiculos;		
	}
	
	@Override
	public ArrayList VehiculoClientesTipo(String id) {
		vehiculos = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE idCliente = '"+id+"'");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					idtipovehiculo = resultado.getString(18); //tipo	
					resultado2 = sentencia2.executeQuery("SELECT * FROM tipo_vehiculo WHERE id = '"+idtipovehiculo+"'");
					
					if (resultado2.next() == true) //move o cursor
					{	
						resultado2.beforeFirst(); //volve a poñer de primeiro o cursor
						while (resultado2.next()) {
							tipovehiculo = resultado2.getString(2); //tipovehiculo
						}
					}
					vehiculos.add(tipovehiculo);
				}
			}
			else {
				vehiculos.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehiculos;		
	}
	
	@Override
	public String getCombustibleVehiculo(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
			    soluciones = resultado.getString(9);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soluciones;
		
	}
    @Override
	public String getnRuedasVehiculo(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
			    soluciones = resultado.getString(16);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soluciones;
	}
    @Override
	public String getProfesionalVehiculo(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
				tipovehiculo = resultado.getString(18);
				resultado2 = sentencia2.executeQuery("SELECT * FROM tipo_vehiculo WHERE id='"+tipovehiculo+"'");
				while (resultado2.next())
				{
					soluciones = resultado2.getString(2);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soluciones;
	}
}
