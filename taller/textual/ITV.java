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
public class ITV
{
    protected String soluciones, idvehiculo, marcavehiculo, modelovehiculo, matriculavehiculo, nombrevehiculo, fecha, fechaActual;
    protected ArrayList nombrevehiculos;
    
    static ConexionBD con;
    static Connection conex;
    static Statement sentencia, sentencia2;
    static ResultSet resultado, resultado2;

    public ITV()
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
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    }
	
	public boolean insertar(String idvehiculo) {

    	try {
	        String sql = "INSERT INTO revisionitv (`idVehiculo`, `fechaAlta`) VALUES ('"+idvehiculo+"','"+fechaActual+"')";
	        sentencia.executeUpdate(sql);
	        return true;

		} catch(SQLException e) {
			e.printStackTrace();		
			return false;
		}
	}
	
	public String listar() {
        
		try {
			resultado = sentencia.executeQuery("SELECT * FROM revisionitv");
			
			if (resultado.next() == true) //move o cursor
			{	
				soluciones = "<html><body><table><tr><th>VEHÍCULO</th><th>FECHA</th></tr>";
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					idvehiculo = resultado.getString(2);
					fecha = resultado.getString(3);
					resultado2 = sentencia2.executeQuery("SELECT * FROM vehiculo WHERE id='"+idvehiculo+"'");
					while (resultado2.next()) {
						nombrevehiculo = resultado2.getString(2) + " " + resultado2.getString(3) + " "+resultado2.getString(4);
						soluciones+="<tr><td>"+nombrevehiculo+"</td><td>"+fecha+"</td></tr>";
					}				
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
	
	public ArrayList VehiculoID() {
		nombrevehiculos = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					idvehiculo = resultado.getString(1); //idvehiculo	
					nombrevehiculos.add(idvehiculo);
				}
			}
			else {
				nombrevehiculos.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombrevehiculos;		
	}
	
	public ArrayList VehiculoMarca() {
		nombrevehiculos = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					marcavehiculo = resultado.getString(2); //marca	
					nombrevehiculos.add(marcavehiculo);
				}
			}
			else {
				nombrevehiculos.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombrevehiculos;		
	}
	
	public ArrayList VehiculoModelo() {
		nombrevehiculos = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					modelovehiculo = resultado.getString(3); //modelo	
					nombrevehiculos.add(modelovehiculo);
				}
			}
			else {
				nombrevehiculos.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombrevehiculos;		
	}
	
	public ArrayList VehiculoMatricula() {
		nombrevehiculos = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					matriculavehiculo = resultado.getString(4); //matricula	
					nombrevehiculos.add(matriculavehiculo);
				}
			}
			else {
				nombrevehiculos.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombrevehiculos;		
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
