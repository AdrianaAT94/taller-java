package textual;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */
public abstract class Persona
{
    // instance variables - replace the example below with your own
    protected String id;
    protected String dni;
    protected String nombre;
    protected String apellidos;
    protected String numTelefono;
    protected boolean mecanico;
    protected String correoElectronico;
    protected String direccion;
    protected String fechaAlta;
    protected String lixo;
    protected String soluciones;
    protected String marca, modelo, matricula, idvehiculo, idtipovehiculo, tipovehiculo;
    
    static ConexionBD con;
    static Connection conex;
    static Statement sentencia, sentencia2;
    static ResultSet resultado, resultado2;
	ArrayList nombreapellidos, vehiculos;

    public Persona() {
        con = new ConexionBD();
        conex = con.getCon();
        try {
			sentencia = conex.createStatement();
			sentencia2 = conex.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public String getDni(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE id='"+id+"'");
			while (resultado.next()) {
				dni = resultado.getString(2); //dni
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dni;
	}

	public String getNombre(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE id='"+id+"'");
			while (resultado.next()) {
				nombre = resultado.getString(3); //nombre
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombre;
	}
	
	public String getApellidos(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE id='"+id+"'");
			while (resultado.next()) {
				apellidos = resultado.getString(4); //apellidos
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return apellidos;
	}

	public String getNumTelefono(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE id='"+id+"'");
			while (resultado.next()) {	
				numTelefono = resultado.getString(5); //telefono
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numTelefono;
	}

	public String getCorreoElectronico(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE id='"+id+"'");
			while (resultado.next()) {
				correoElectronico = resultado.getString(6); //correo
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return correoElectronico;
	}

	public String getDireccion(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM persona WHERE id='"+id+"'");
			while (resultado.next()) {
				direccion = resultado.getString(7); //direccion
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return direccion;
	}

	public boolean insertar(String dni, String nombre, String apellidos, String numTelefono, String correoElectronico, String direccion) {
		return false;
	}
    
	public boolean borrar(String id) {
		
		try {
	        sentencia.executeUpdate("DELETE FROM persona WHERE id='"+id+"'");
	        return true;

		} catch(SQLException e) {
			e.printStackTrace();	
			return false;
		}
	}
	

	
	public boolean editar(String id, String nombre, String apellidos, String telefono, String correo, String direccion) {		
		
		try {
	        sentencia.executeUpdate("UPDATE persona SET dni='"+dni+"', nombre='"+nombre+"', apellidos='"+apellidos+"', telf='"+telefono+"', correo='"+correo+"', direccion='"+direccion+"' WHERE id = '"+id+"'"); 
	        return true;

		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public String listar(){
		return null;
	}
    
    public String consultarporDNI(String dni) {
		return null;
	}
    
    public String consultarporNombre(String nombre) {
		return null;
	}

    public String consultarporApellidos(String apellidos) {
		return null;
	}
    
    public ArrayList NombrePersona(){
		return null;
	}
    public ArrayList ApellidoPersona(){
		return null;
	}
    public ArrayList IDPersona(){
		return null;
	}
    public ArrayList VehiculoClientesID(String id) {
    	return null;
    }
    public ArrayList VehiculoClientesMarca(String id) {
    	return null;
    }
    public ArrayList VehiculoClientesModelo(String id) {
    	return null;
    }
    public ArrayList VehiculoClientesMatricula(String id) {
    	return null;
    }
    public ArrayList VehiculoClientesTipo(String id) {
    	return null;
    }
    
    public String getCombustibleVehiculo(String id) {
		return null;
	}
    public String getnRuedasVehiculo(String id) {
		return null;
	}
    public String getProfesionalVehiculo(String id) {
		return null;
	}
    
    public void cerrarMetodos() {
        try {
            resultado.close();
            resultado2.close();
            sentencia.close();
            sentencia2.close();
            conex.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
