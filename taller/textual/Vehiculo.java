package textual;

import java.sql.*;
import java.util.ArrayList;

/**
 * Vehiculo es una clase abstracta para los vehiculos.
 * Ofrece las caracteristicas comunes a todos los vehiculos
 * como combustible, almacenamiento, nº de puertas, etc.
 * 
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */
public abstract class Vehiculo
{
    // instance variables - replace the example below with your own
	protected String id;
    protected String marca;
    protected String modelo;
    protected String matricula;
    protected String idcliente;
    protected String tipovehiculo;
    protected String nombrecliente, nombretipovehiculo, nombrevehiculo;
    protected String nPuertas;
    protected String capMotor;
    protected String combustible;
    protected String capAlmacenamiento;
    protected String nPasajeros;
    protected boolean airbags;
    protected String maxVelocidad;
    protected boolean ABS;
    protected boolean GPS;
    protected boolean climatizacion;
    protected boolean descapotable;
    protected String nRuedas;
    protected String fechaAlta;
    protected String motivoVisita;
    protected String lixo;
    protected String soluciones;
    
    protected String sairbags, sABS, sGPS, sclimatizacion, sdescapotable;
    //estas son as que se usan para sacar no formulario de registro de coche
    
    static ConexionBD con;
    static Connection conex;
    static Statement sentencia, sentencia2, sentencia3;
    static ResultSet resultado, resultado2, resultado3;
	ArrayList marcavehiculo;
    
    public Vehiculo() {
        con = new ConexionBD();
        conex = con.getCon();
        try {
			sentencia = conex.createStatement();
			sentencia2 = conex.createStatement();
			sentencia3 = conex.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}    	
    }
    
    
	
    public String getMarca(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
				marca = resultado.getString(2);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marca;
    }

    public String getModelo(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
				modelo = resultado.getString(3);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelo;
    }

    public String getMatricula(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
				matricula = resultado.getString(4);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matricula;
    }

    public String getIdcliente(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
				idcliente = resultado.getString(20);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idcliente;
    }

    public String getNombrecliente(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
				idcliente = resultado.getString(20);
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
	public String getNombrevehiculo(String id) {
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
					nombrevehiculo = resultado.getString(2) + " " + resultado.getString(3) + " " + resultado.getString(4);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombrevehiculo;
	}

    public String getNombretipovehiculo(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
				tipovehiculo = resultado.getString(20);
				resultado3 = sentencia3.executeQuery("SELECT * FROM tipo_vehiculo WHERE id='"+tipovehiculo+"'");
				while (resultado3.next())
				{
					nombretipovehiculo = resultado3.getString(2);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nombretipovehiculo;
	}

    public String getnPuertas(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
			    nPuertas = resultado.getString(5);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nPuertas;
    }


	public String getCapMotor(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
			    capMotor = resultado.getString(8);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return capMotor;
    }
	
	public String getCombustible(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
			    combustible = resultado.getString(9);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return combustible;
    }

	public String getCapAlmacenamiento(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
			    capAlmacenamiento = resultado.getString(10);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return capAlmacenamiento;
    }

	public String getnPasajeros(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
			    nPasajeros = resultado.getString(11);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nPasajeros;
    }

	public String getfechaAlta(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
			    fechaAlta = resultado.getString(19);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fechaAlta;
    }

	public boolean isAirbags(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
			    airbags = resultado.getBoolean(6);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return airbags;
    }
	
	public String getMaxVelocidad(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
			    maxVelocidad = resultado.getString(7);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maxVelocidad;
    }

	public boolean isABS(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
				ABS = resultado.getBoolean(12);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ABS;
    }

	public boolean isGPS(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
				GPS = resultado.getBoolean(13);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return GPS;
    }

	public boolean isClimatizacion(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
				climatizacion = resultado.getBoolean(14);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return climatizacion;
    }

	public boolean isDescapotable(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
				descapotable = resultado.getBoolean(15);
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return descapotable;
    }

	
	public String getnRuedas(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
			    nRuedas = resultado.getString(16);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nRuedas;
    }

	public String getMotivoVisita(String id) {
    	try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE id='"+id+"'");
			while (resultado.next()) {
			    motivoVisita = resultado.getString(17);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return motivoVisita;
    }

	public boolean insertar(String marca, String modelo, String matricula, String combustible, String nPuertas, String nRuedas, String maxVelocidad, String capMotor, String capAlmacenamiento, String nPasajeros, String ABS, String GPS, String airbags, String climatizacion, String descapotable, String idcliente, String motivoVisita) {
		return false;
	}
	
    public boolean editar(String id, String marca, String modelo, String matricula, String combustible, String nPuertas, String nRuedas, String maxVelocidad, String capMotor, String capAlmacenamiento, String nPasajeros, String ABS, String GPS, String airbags, String climatizacion, String descapotable, String idcliente, String motivoVisita) {

		try {
	        sentencia.executeUpdate("UPDATE vehiculo SET marca='"+marca+"', modelo='"+modelo+"', matricula='"+matricula+"', nPuertas='"+nPuertas+"', airbags='"+airbags+"', maxVelocidad='"+maxVelocidad+"', capMotor='"+capMotor+"', combustible='"+combustible+"', capAlmacenamiento='"+capAlmacenamiento+"', nPasajeros='"+nPasajeros+"', ABS='"+ABS+"', GPS='"+GPS+"', climatizacion='"+climatizacion+"', descapotable='"+descapotable+"', nRuedas='"+nRuedas+"', motivoVisita='"+motivoVisita+"', idCliente='"+idcliente+"' WHERE id = '"+id+"'");     
	        return true;
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
    
	public boolean borrar(String id) {
		
		try {
	        sentencia.executeUpdate("DELETE FROM vehiculo WHERE id='"+id+"'");
	        return true;

		} catch(SQLException e) {
			e.printStackTrace();			
			return false;
		}
	}
	
    public String listar() {
		return null;
	}
	   
    public String consultarporMatricula(String matricula) {
		return null;
	}
    
    public String consultarporMarca(String marca) {
		return null;
	}

    public String consultarporModelo(String modelo) {
		return null;
	}

    public String getUltimoRegitro() {
		return null;
    }
	
    public ArrayList MarcaVehiculo(){
		return null;
	}
    public ArrayList ModeloVehiculo(){
		return null;
	}
    public ArrayList MatriculaVehiculo(){
		return null;
	}
    public ArrayList IDVehiculo(){
		return null;
	}
	
    public void cerrarMetodos() {
    	try {
	    	resultado.close();
	    	resultado2.close();
	    	resultado3.close();
			sentencia.close();
			sentencia2.close();
			sentencia3.close();
	    	conex.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
