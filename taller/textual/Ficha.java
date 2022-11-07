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
public class Ficha
{
	protected String id;
	protected String idvehiculo;
    protected String idcliente;
    protected String idmecanico;
    protected String idestado;
    protected String descripcion;
    protected String estado;
    protected String motivoParado;
    protected String fechaEntrada;
    protected String fechaSalida;
    protected String soluciones;
    protected String nombrecliente;
    protected String nombremecanico;
    protected String nombrevehiculo;

    protected ArrayList nombreficha;
    
    static ConexionBD con;
    static Connection conex;
    static Statement sentencia, sentencia2, sentencia3, sentencia4, sentencia5, sentencia6;
    static ResultSet resultado, resultado2, resultado3, resultado4, resultado5, resultado6;

    public Ficha()
    {
        con = new ConexionBD();
        conex = con.getCon();
        try {
			sentencia = conex.createStatement();
			sentencia2 = conex.createStatement();
			sentencia3 = conex.createStatement();
			sentencia4 = conex.createStatement();
			sentencia5 = conex.createStatement();
			sentencia6 = conex.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    }

	public String getIdvehiculo(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha WHERE id='"+id+"'");
			while (resultado.next()) {
				idvehiculo = resultado.getString(8); //idvehiculo
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idvehiculo;
	}

	public String getNombrevehiculo(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha WHERE id='"+id+"'");
			while (resultado.next()) {
				idvehiculo = resultado.getString(8); //idvehiculo
				
				resultado2 = sentencia2.executeQuery("SELECT * FROM vehiculo WHERE id='"+idvehiculo+"'");
				while (resultado2.next())
				{
					nombrevehiculo = resultado2.getString(2) + " " + resultado2.getString(3) + " " + resultado2.getString(4);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombrevehiculo;
	}

	public void setIdvehiculo(String idvehiculo) {
		this.idvehiculo = idvehiculo;
	}

	public String getIdcliente(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha WHERE id='"+id+"'");
			while (resultado.next()) {
				idcliente = resultado.getString(7); //idcliente
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idcliente;
	}
	
	public String getNombrecliente(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha WHERE id='"+id+"'");
			while (resultado.next()) {
				idcliente = resultado.getString(7); //idcliente
				resultado2 = sentencia2.executeQuery("SELECT * FROM persona WHERE id='"+idcliente+"'");
				while (resultado2.next())
				{
					nombrecliente = resultado2.getString(3) + " " + resultado2.getString(4);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombrecliente;
	}

	public void setIdcliente(String idcliente) {
		this.idcliente = idcliente;
	}

	public String getIdmecanico(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha WHERE id='"+id+"'");
			while (resultado.next()) {
				idmecanico = resultado.getString(9); //idmecanico
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idmecanico;
	}
	
	public String getNombremecanico(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha WHERE id='"+id+"'");
			while (resultado.next()) {
				idmecanico = resultado.getString(9); //idmecanico
				resultado2 = sentencia2.executeQuery("SELECT * FROM persona WHERE id='"+idmecanico+"'");
				while (resultado2.next())
				{
					nombremecanico = resultado2.getString(3) + " " + resultado2.getString(4) + " "+resultado2.getString(2);
				}	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombremecanico;
	}

	public void setIdmecanico(String idmecanico) {
		this.idmecanico = idmecanico;
	}

	public String getDescripcion(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha WHERE id='"+id+"'");
			while (resultado.next()) {
				descripcion = resultado.getString(2); //descripcion
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMotivoParado(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha WHERE id='"+id+"'");
			while (resultado.next()) {
				motivoParado = resultado.getString(6); //motivoParado
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return motivoParado;
	}

	public void setMotivoParado(String motivoParado) {
		this.motivoParado = motivoParado;
	}

	public String getFechaEntrada(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha WHERE id='"+id+"'");
			while (resultado.next()) {
				fechaEntrada = resultado.getString(4); //fechaEntrada
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getFechaSalida(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha WHERE id='"+id+"'");
			while (resultado.next()) {
				fechaSalida = resultado.getString(5); //fechaSalida
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getEstado(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha WHERE id='"+id+"'");
			while (resultado.next()) {
				idestado = resultado.getString(3); //estado
				resultado2 = sentencia2.executeQuery("SELECT * FROM tipo_estado WHERE id='"+idestado+"'");
				while (resultado2.next())
				{
					estado = resultado2.getString(2);
				}	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public boolean insertar(String descripcion, String estado, String fechaEntrada, String fechaSalida, String motivoParado, String idcliente, String idvehiculo, String idmecanico) {		
    	
		if (fechaSalida.isEmpty()) {
	    	try {
		        String sql = "INSERT INTO ficha (`descripcion`, `estado`, `fechaEntrada`, `fechaSalida`, `motivo`, `idCliente`, `idVehiculo`, `idMecanico`) VALUES ("
		        		+"'"+descripcion+"','"+estado+"','"+fechaEntrada+"', NULL,'"+motivoParado+"','"+idcliente+"','"+idvehiculo+"','"+idmecanico+"')";
		        sentencia.executeUpdate(sql);
		        return true;

			} catch(SQLException e) {
				e.printStackTrace();		
				return false;
			}		
		}
		else {
	    	try {
		        String sql = "INSERT INTO ficha (`descripcion`, `estado`, `fechaEntrada`, `fechaSalida`, `motivo`, `idCliente`, `idVehiculo`, `idMecanico`) VALUES ("
		        		+"'"+descripcion+"','"+estado+"','"+fechaEntrada+"','"+fechaSalida+"','"+motivoParado+"','"+idcliente+"','"+idvehiculo+"','"+idmecanico+"')";
		        sentencia.executeUpdate(sql);
		        return true;

			} catch(SQLException e) {
				e.printStackTrace();		
				return false;
			}
			
		}
	}
	
    public boolean editar(String id, String descripcion, String estado, String fechaSalida, String motivoParado) {

    	if (fechaSalida.isEmpty()) {
    		try {
    	        sentencia.executeUpdate("UPDATE ficha SET descripcion='"+descripcion+"', estado='"+estado+"', fechaSalida = NULL, motivo='"+motivoParado+"' WHERE id = '"+id+"'");     
    	        return true;
    		} catch(SQLException e) {
    			e.printStackTrace();
    			return false;
    		} 
    	}
    	else {
    		try {
    	        sentencia.executeUpdate("UPDATE ficha SET descripcion='"+descripcion+"', estado='"+estado+"', fechaSalida='"+fechaSalida+"', motivo='"+motivoParado+"' WHERE id = '"+id+"'");     
    	        return true;
    		} catch(SQLException e) {
    			e.printStackTrace();
    			return false;
    		}    		
    	}
	}
    
    public boolean borrar(String id) {
		
		try {
	        sentencia.executeUpdate("DELETE FROM ficha WHERE id='"+id+"'");
	        return true;

		} catch(SQLException e) {
			e.printStackTrace();			
			return false;
		}
	}
    
    public String listar() {
        
		try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha");
			
			if (resultado.next() == true) //move o cursor
			{	
				soluciones = "<html><body><table><tr><th>DESCRIPCIÓN</th><th>ESTADO</th><th>FECHA ENTRADA</th><th>FECHA SALIDA</th><th>MOTIVO PARADO</th><th>CLIENTE</th><th>COCHE</th><th>MECÁNICO</th></tr>";
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					descripcion = resultado.getString(2); //descripcion
					idestado = resultado.getString(3); //estado
					resultado2 = sentencia2.executeQuery("SELECT * FROM tipo_estado WHERE id='"+idestado+"'");
					while (resultado2.next())
					{
						estado = resultado2.getString(2);
					}
					fechaEntrada = resultado.getString(4); //fechaentrada
					fechaSalida = resultado.getString(5); //fechasalida
					if (fechaSalida == null) {
						fechaSalida = "";
					}
					motivoParado = resultado.getString(6); //motivoparado
					if (motivoParado == null || motivoParado.isEmpty()) {
						motivoParado = "";
					}
					idcliente = resultado.getString(7); //idcliente
					idvehiculo = resultado.getString(8); //idvehiculo
					idmecanico = resultado.getString(9); //idmecanico
					
					resultado3 = sentencia3.executeQuery("SELECT * FROM persona WHERE id='"+idcliente+"'");
					while (resultado3.next())
					{
						nombrecliente = resultado3.getString(3) + " " + resultado3.getString(4);
					}
					
					resultado4 = sentencia4.executeQuery("SELECT * FROM persona WHERE id='"+idmecanico+"'");
					while (resultado4.next())
					{
						nombremecanico = resultado4.getString(3) + " " + resultado4.getString(4) + " "+resultado4.getString(2);
					}
					
					resultado5 = sentencia5.executeQuery("SELECT * FROM vehiculo WHERE id='"+idvehiculo+"'");
					while (resultado5.next())
					{
						nombrevehiculo = resultado5.getString(2) + " " + resultado5.getString(3) + " " + resultado5.getString(4);
					}
					
					soluciones+="<tr><td>"+descripcion+"</td><td>"+estado+"</td><td>"+fechaEntrada+"</td><td>"+fechaSalida+"</td><td>"+motivoParado+"</td><td>"+nombrecliente+"</td><td>"+nombrevehiculo+"</td><td>"+nombremecanico+"</td></tr>";
				
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
	
	public String consultarporMecanico(String nombre, String fechaEnt1, String fechaEnt2) {  

		if (fechaEnt1.isEmpty() || fechaEnt1.equals("") || fechaEnt2.isEmpty() || fechaEnt2.equals("")) {
			try {
				resultado = sentencia.executeQuery("SELECT * FROM persona WHERE UPPER(nombre) LIKE UPPER('%"+nombre+"%') AND tipoPersona='2'");
				
				if (resultado.next() == true) //move o cursor
				{	
					resultado.beforeFirst(); //volve a poñer de primeiro o cursor
					while (resultado.next()) {
						idmecanico = resultado.getString(1); //idmecanico
						resultado2 = sentencia2.executeQuery("SELECT * FROM ficha WHERE idMecanico='"+idmecanico+"'");
						if (resultado2.next() == true) //move o cursor
						{
							soluciones = "<html><body><table><tr><th>DESCRIPCIÓN</th><th>ESTADO</th><th>FECHA ENTRADA</th><th>FECHA SALIDA</th><th>MOTIVO PARADO</th><th>CLIENTE</th><th>COCHE</th><th>MECÁNICO</th></tr>";
							resultado2.beforeFirst(); //volve a poñer de primeiro o cursor
							while (resultado2.next()) {
								descripcion = resultado2.getString(2); //descripcion
								idestado = resultado2.getString(3); //estado
								resultado3 = sentencia3.executeQuery("SELECT * FROM tipo_estado WHERE id='"+idestado+"'");
								while (resultado3.next())
								{
									estado = resultado3.getString(2);
								}
								fechaEntrada = resultado2.getString(4); //fechaentrada
								fechaSalida = resultado2.getString(5); //fechasalida
								if (fechaSalida == null) {
									fechaSalida = "";
								}
								motivoParado = resultado2.getString(6); //motivoparado
								if (motivoParado == null) {
									motivoParado = "";
								}
								idcliente = resultado2.getString(7); //idcliente
								idvehiculo = resultado2.getString(8); //idvehiculo
								idmecanico = resultado2.getString(9); //idmecanico
								
								resultado4 = sentencia4.executeQuery("SELECT * FROM persona WHERE id='"+idcliente+"'");
								while (resultado4.next())
								{
									nombrecliente = resultado4.getString(3) + " " + resultado4.getString(4);
								}
								
								resultado5 = sentencia4.executeQuery("SELECT * FROM persona WHERE id='"+idmecanico+"'");
								while (resultado5.next())
								{
									nombremecanico = resultado5.getString(3) + " " + resultado5.getString(4) + " "+resultado5.getString(2);
								}
								
								resultado6 = sentencia6.executeQuery("SELECT * FROM vehiculo WHERE id='"+idvehiculo+"'");
								while (resultado6.next())
								{
									nombrevehiculo = resultado6.getString(2) + " " + resultado6.getString(3) + " " + resultado6.getString(4);
								}
								
								soluciones+="<tr><td>"+descripcion+"</td><td>"+estado+"</td><td>"+fechaEntrada+"</td><td>"+fechaSalida+"</td><td>"+motivoParado+"</td><td>"+nombrecliente+"</td><td>"+nombrevehiculo+"</td><td>"+nombremecanico+"</td></tr>";
							}
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
		else {
			try {
				resultado = sentencia.executeQuery("SELECT * FROM persona WHERE UPPER(nombre) LIKE UPPER('%"+nombre+"%') AND tipoPersona='2'");
				
				if (resultado.next() == true) //move o cursor
				{	
					resultado.beforeFirst(); //volve a poñer de primeiro o cursor
					while (resultado.next()) {
						idmecanico= resultado.getString(1); //idmecanico
						resultado2 = sentencia2.executeQuery("SELECT * FROM ficha WHERE fechaEntrada >= '"+fechaEnt1+"' AND fechaEntrada <= '"+fechaEnt2+"' AND idMecanico = '"+idmecanico+"'");
						if (resultado2.next() == true) //move o cursor
						{
							soluciones = "<html><body><table><tr><th>DESCRIPCIÓN</th><th>ESTADO</th><th>FECHA ENTRADA</th><th>FECHA SALIDA</th><th>MOTIVO PARADO</th><th>CLIENTE</th><th>COCHE</th><th>MECÁNICO</th></tr>";
							resultado2.beforeFirst(); //volve a poñer de primeiro o cursor
							while (resultado2.next()) {
								descripcion = resultado2.getString(2); //descripcion
								idestado = resultado2.getString(3); //estado
								resultado3 = sentencia3.executeQuery("SELECT * FROM tipo_estado WHERE id='"+idestado+"'");
								while (resultado3.next())
								{
									estado = resultado3.getString(2);
								}
								fechaEntrada = resultado2.getString(4); //fechaentrada
								fechaSalida = resultado2.getString(5); //fechasalida
								if (fechaSalida == null) {
									fechaSalida = "";
								}
								motivoParado = resultado2.getString(6); //motivoparado
								if (motivoParado == null) {
									motivoParado = "";
								}
								idcliente = resultado2.getString(7); //idcliente
								idvehiculo = resultado2.getString(8); //idvehiculo
								idmecanico = resultado2.getString(9); //idmecanico
								
								resultado4 = sentencia4.executeQuery("SELECT * FROM persona WHERE id='"+idcliente+"'");
								while (resultado4.next())
								{
									nombrecliente = resultado4.getString(3) + " " + resultado4.getString(4);
								}
								
								resultado5 = sentencia4.executeQuery("SELECT * FROM persona WHERE id='"+idmecanico+"'");
								while (resultado5.next())
								{
									nombremecanico = resultado5.getString(3) + " " + resultado5.getString(4) + " "+resultado5.getString(2);
								}
								
								resultado6 = sentencia6.executeQuery("SELECT * FROM vehiculo WHERE id='"+idvehiculo+"'");
								while (resultado6.next())
								{
									nombrevehiculo = resultado6.getString(2) + " " + resultado6.getString(3) + " " + resultado6.getString(4);
								}
								
								soluciones+="<tr><td>"+descripcion+"</td><td>"+estado+"</td><td>"+fechaEntrada+"</td><td>"+fechaSalida+"</td><td>"+motivoParado+"</td><td>"+nombrecliente+"</td><td>"+nombrevehiculo+"</td><td>"+nombremecanico+"</td></tr>";
							}
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
	}
	
	public String consultarporCliente(String nombre, String fechaEnt1, String fechaEnt2) {
		
		if (fechaEnt1.isEmpty() || fechaEnt1.equals("") || fechaEnt2.isEmpty() || fechaEnt2.equals("")) {
			try {
				resultado = sentencia.executeQuery("SELECT * FROM persona WHERE UPPER(nombre) LIKE UPPER('%"+nombre+"%') AND tipoPersona='1'");
				
				if (resultado.next() == true) //move o cursor
				{	
					resultado.beforeFirst(); //volve a poñer de primeiro o cursor
					while (resultado.next()) {
						idcliente = resultado.getString(1); //idcliente
						resultado2 = sentencia2.executeQuery("SELECT * FROM ficha WHERE idCliente='"+idcliente+"'");
						if (resultado2.next() == true) //move o cursor
						{
							soluciones = "<html><body><table><tr><th>DESCRIPCIÓN</th><th>ESTADO</th><th>FECHA ENTRADA</th><th>FECHA SALIDA</th><th>MOTIVO PARADO</th><th>CLIENTE</th><th>COCHE</th><th>MECÁNICO</th></tr>";
							resultado2.beforeFirst(); //volve a poñer de primeiro o cursor
							while (resultado2.next()) {
								descripcion = resultado2.getString(2); //descripcion
								idestado = resultado2.getString(3); //estado
								resultado3 = sentencia3.executeQuery("SELECT * FROM tipo_estado WHERE id='"+idestado+"'");
								while (resultado3.next())
								{
									estado = resultado3.getString(2);
								}
								fechaEntrada = resultado2.getString(4); //fechaentrada
								fechaSalida = resultado2.getString(5); //fechasalida
								if (fechaSalida == null) {
									fechaSalida = "";
								}
								motivoParado = resultado2.getString(6); //motivoparado
								if (motivoParado == null) {
									motivoParado = "";
								}
								idcliente = resultado2.getString(7); //idcliente
								idvehiculo = resultado2.getString(8); //idvehiculo
								idmecanico = resultado2.getString(9); //idmecanico
								
								resultado4 = sentencia4.executeQuery("SELECT * FROM persona WHERE id='"+idcliente+"'");
								while (resultado4.next())
								{
									nombrecliente = resultado4.getString(3) + " " + resultado4.getString(4);
								}
								
								resultado5 = sentencia4.executeQuery("SELECT * FROM persona WHERE id='"+idmecanico+"'");
								while (resultado5.next())
								{
									nombremecanico = resultado5.getString(3) + " " + resultado5.getString(4) + " "+resultado5.getString(2);
								}
								
								resultado6 = sentencia6.executeQuery("SELECT * FROM vehiculo WHERE id='"+idvehiculo+"'");
								while (resultado6.next())
								{
									nombrevehiculo = resultado6.getString(2) + " " + resultado6.getString(3) + " " + resultado6.getString(4);
								}
								
								soluciones+="<tr><td>"+descripcion+"</td><td>"+estado+"</td><td>"+fechaEntrada+"</td><td>"+fechaSalida+"</td><td>"+motivoParado+"</td><td>"+nombrecliente+"</td><td>"+nombrevehiculo+"</td><td>"+nombremecanico+"</td></tr>";
							}
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
		else {			
			try {
				resultado = sentencia.executeQuery("SELECT * FROM persona WHERE UPPER(nombre) LIKE UPPER('%"+nombre+"%') AND tipoPersona='1'");
				
				if (resultado.next() == true) //move o cursor
				{	
					resultado.beforeFirst(); //volve a poñer de primeiro o cursor
					while (resultado.next()) {
						idcliente = resultado.getString(1); //idcliente
						resultado2 = sentencia2.executeQuery("SELECT * FROM ficha WHERE fechaEntrada >= '"+fechaEnt1+"' AND fechaEntrada <= '"+fechaEnt2+"' AND idCliente = '"+idcliente+"'");
						if (resultado2.next() == true) //move o cursor
						{
							soluciones = "<html><body><table><tr><th>DESCRIPCIÓN</th><th>ESTADO</th><th>FECHA ENTRADA</th><th>FECHA SALIDA</th><th>MOTIVO PARADO</th><th>CLIENTE</th><th>COCHE</th><th>MECÁNICO</th></tr>";
							resultado2.beforeFirst(); //volve a poñer de primeiro o cursor
							while (resultado2.next()) {
								descripcion = resultado2.getString(2); //descripcion
								idestado = resultado2.getString(3); //estado
								resultado3 = sentencia3.executeQuery("SELECT * FROM tipo_estado WHERE id='"+idestado+"'");
								while (resultado3.next())
								{
									estado = resultado3.getString(2);
								}
								fechaEntrada = resultado2.getString(4); //fechaentrada
								fechaSalida = resultado2.getString(5); //fechasalida
								if (fechaSalida == null) {
									fechaSalida = "";
								}
								motivoParado = resultado2.getString(6); //motivoparado
								if (motivoParado == null) {
									motivoParado = "";
								}
								idcliente = resultado2.getString(7); //idcliente
								idvehiculo = resultado2.getString(8); //idvehiculo
								idmecanico = resultado2.getString(9); //idmecanico
								
								resultado4 = sentencia4.executeQuery("SELECT * FROM persona WHERE id='"+idcliente+"'");
								while (resultado4.next())
								{
									nombrecliente = resultado4.getString(3) + " " + resultado4.getString(4);
								}
								
								resultado5 = sentencia4.executeQuery("SELECT * FROM persona WHERE id='"+idmecanico+"'");
								while (resultado5.next())
								{
									nombremecanico = resultado5.getString(3) + " " + resultado5.getString(4) + " "+resultado5.getString(2);
								}
								
								resultado6 = sentencia6.executeQuery("SELECT * FROM vehiculo WHERE id='"+idvehiculo+"'");
								while (resultado6.next())
								{
									nombrevehiculo = resultado6.getString(2) + " " + resultado6.getString(3) + " " + resultado6.getString(4);
								}
								
								soluciones+="<tr><td>"+descripcion+"</td><td>"+estado+"</td><td>"+fechaEntrada+"</td><td>"+fechaSalida+"</td><td>"+motivoParado+"</td><td>"+nombrecliente+"</td><td>"+nombrevehiculo+"</td><td>"+nombremecanico+"</td></tr>";
							}
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
	}
	
	public String consultarporEstado(String estado, String fechaEnt1, String fechaEnt2) {

		if (fechaEnt1.isEmpty() || fechaEnt1.equals("") || fechaEnt2.isEmpty() || fechaEnt2.equals("")) {
			try {
				resultado = sentencia.executeQuery("SELECT * FROM tipo_estado WHERE nombre_tipo='"+estado+"'");
				
				if (resultado.next() == true) //move o cursor
				{	
					resultado.beforeFirst(); //volve a poñer de primeiro o cursor
					while (resultado.next()) {
						idestado = resultado.getString(1); //idestado
						resultado2 = sentencia2.executeQuery("SELECT * FROM ficha WHERE estado='"+idestado+"'");
						if (resultado2.next() == true) //move o cursor
						{
							soluciones = "<html><body><table><tr><th>DESCRIPCIÓN</th><th>ESTADO</th><th>FECHA ENTRADA</th><th>FECHA SALIDA</th><th>MOTIVO PARADO</th><th>CLIENTE</th><th>COCHE</th><th>MECÁNICO</th></tr>";
							resultado2.beforeFirst(); //volve a poñer de primeiro o cursor
							while (resultado2.next()) {
								descripcion = resultado2.getString(2); //descripcion
								idestado = resultado2.getString(3); //estado
								resultado3 = sentencia3.executeQuery("SELECT * FROM tipo_estado WHERE id='"+idestado+"'");
								while (resultado3.next())
								{
									estado = resultado3.getString(2);
								}
								fechaEntrada = resultado2.getString(4); //fechaentrada
								fechaSalida = resultado2.getString(5); //fechasalida
								if (fechaSalida == null) {
									fechaSalida = "";
								}
								motivoParado = resultado2.getString(6); //motivoparado
								if (motivoParado == null) {
									motivoParado = "";
								}
								idcliente = resultado2.getString(7); //idcliente
								idvehiculo = resultado2.getString(8); //idvehiculo
								idmecanico = resultado2.getString(9); //idmecanico
								
								resultado4 = sentencia4.executeQuery("SELECT * FROM persona WHERE id='"+idcliente+"'");
								while (resultado4.next())
								{
									nombrecliente = resultado4.getString(3) + " " + resultado4.getString(4);
								}
								
								resultado5 = sentencia4.executeQuery("SELECT * FROM persona WHERE id='"+idmecanico+"'");
								while (resultado5.next())
								{
									nombremecanico = resultado5.getString(3) + " " + resultado5.getString(4) + " "+resultado5.getString(2);
								}
								
								resultado6 = sentencia6.executeQuery("SELECT * FROM vehiculo WHERE id='"+idvehiculo+"'");
								while (resultado6.next())
								{
									nombrevehiculo = resultado6.getString(2) + " " + resultado6.getString(3) + " " + resultado6.getString(4);
								}
								
								soluciones+="<tr><td>"+descripcion+"</td><td>"+estado+"</td><td>"+fechaEntrada+"</td><td>"+fechaSalida+"</td><td>"+motivoParado+"</td><td>"+nombrecliente+"</td><td>"+nombrevehiculo+"</td><td>"+nombremecanico+"</td></tr>";
							}
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
		else {
			try {
				resultado = sentencia.executeQuery("SELECT * FROM tipo_estado WHERE nombre_tipo='"+estado+"'");
				
				if (resultado.next() == true) //move o cursor
				{	
					resultado.beforeFirst(); //volve a poñer de primeiro o cursor
					while (resultado.next()) {
						idestado = resultado.getString(1); //idestado
						resultado2 = sentencia2.executeQuery("SELECT * FROM ficha WHERE fechaEntrada >= '"+fechaEnt1+"' AND fechaEntrada <= '"+fechaEnt2+"' AND estado = '"+idestado+"'");
						if (resultado2.next() == true) //move o cursor
						{
							soluciones = "<html><body><table><tr><th>DESCRIPCIÓN</th><th>ESTADO</th><th>FECHA ENTRADA</th><th>FECHA SALIDA</th><th>MOTIVO PARADO</th><th>CLIENTE</th><th>COCHE</th><th>MECÁNICO</th></tr>";
							resultado2.beforeFirst(); //volve a poñer de primeiro o cursor
							while (resultado2.next()) {
								descripcion = resultado2.getString(2); //descripcion
								idestado = resultado2.getString(3); //estado
								resultado3 = sentencia3.executeQuery("SELECT * FROM tipo_estado WHERE id='"+idestado+"'");
								while (resultado3.next())
								{
									estado = resultado3.getString(2);
								}
								fechaEntrada = resultado2.getString(4); //fechaentrada
								fechaSalida = resultado2.getString(5); //fechasalida
								if (fechaSalida == null) {
									fechaSalida = "";
								}
								motivoParado = resultado2.getString(6); //motivoparado
								if (motivoParado == null) {
									motivoParado = "";
								}
								idcliente = resultado2.getString(7); //idcliente
								idvehiculo = resultado2.getString(8); //idvehiculo
								idmecanico = resultado2.getString(9); //idmecanico
								
								resultado4 = sentencia4.executeQuery("SELECT * FROM persona WHERE id='"+idcliente+"'");
								while (resultado4.next())
								{
									nombrecliente = resultado4.getString(3) + " " + resultado4.getString(4);
								}
								
								resultado5 = sentencia4.executeQuery("SELECT * FROM persona WHERE id='"+idmecanico+"'");
								while (resultado5.next())
								{
									nombremecanico = resultado5.getString(3) + " " + resultado5.getString(4) + " "+resultado5.getString(2);
								}
								
								resultado6 = sentencia6.executeQuery("SELECT * FROM vehiculo WHERE id='"+idvehiculo+"'");
								while (resultado6.next())
								{
									nombrevehiculo = resultado6.getString(2) + " " + resultado6.getString(3) + " " + resultado6.getString(4);
								}
								
								soluciones+="<tr><td>"+descripcion+"</td><td>"+estado+"</td><td>"+fechaEntrada+"</td><td>"+fechaSalida+"</td><td>"+motivoParado+"</td><td>"+nombrecliente+"</td><td>"+nombrevehiculo+"</td><td>"+nombremecanico+"</td></tr>";
							}
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
	}
	
	public ArrayList FichaCliente() {
		nombreficha = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					idcliente = resultado.getString(7); //idcliente
					
					resultado2 = sentencia2.executeQuery("SELECT * FROM persona WHERE id='"+idcliente+"'");
					while (resultado2.next())
					{
						nombrecliente = resultado2.getString(3) + " " + resultado2.getString(4);
						nombreficha.add(nombrecliente);
					}
					
				}
			}
			else {
				soluciones = "No hay resultados.";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombreficha;		
	}
	
	public ArrayList FichaVehiculo() {
		nombreficha = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					idvehiculo = resultado.getString(8); //idvehiculo
					
					resultado2 = sentencia2.executeQuery("SELECT * FROM vehiculo WHERE id='"+idvehiculo+"'");
					while (resultado2.next())
					{
						nombrevehiculo = resultado2.getString(2) + " " + resultado2.getString(3) + " " + resultado2.getString(4);
						nombreficha.add(nombrevehiculo);
					}
				}
			}
			else {
				soluciones = "No hay resultados.";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombreficha;		
	}
	
	public ArrayList FichaMecanico() {
		nombreficha = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					idmecanico = resultado.getString(9); //idmecanico
					if (idmecanico == null) {
						nombreficha.add("mecánico no asignado");
					}
					else {
						resultado2 = sentencia2.executeQuery("SELECT * FROM persona WHERE id='"+idmecanico+"'");
						while (resultado2.next())
						{
							nombremecanico = resultado2.getString(3) + " " + resultado2.getString(4) + " "+resultado2.getString(2);
							nombreficha.add(nombremecanico);
						}						
					}
					
				}
			}
			else {
				soluciones = "No hay resultados.";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombreficha;		
	}
	
	public ArrayList FichaID() {
		nombreficha = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM ficha");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					id = resultado.getString(1); //id
					
					nombreficha.add(id);
				}
			}
			else {
				soluciones = "No hay resultados.";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombreficha;		
	}
	
    public void cerrarMetodos() {
    	try {
	    	resultado.close();
	    	resultado2.close();
	    	resultado3.close();
	    	resultado4.close();
	    	resultado5.close();
	    	resultado6.close();
			sentencia.close();
			sentencia2.close();
			sentencia3.close();
			sentencia4.close();
			sentencia5.close();
			sentencia6.close();
	    	conex.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }      
}
