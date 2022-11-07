package textual;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */
public class Todoterreno extends Coche
{

	public Todoterreno() {}

	@Override
	public boolean insertar(String marca, String modelo, String matricula, String combustible, String nPuertas, String nRuedas, String maxVelocidad, String capMotor, String capAlmacenamiento, String nPasajeros, String ABS, String GPS, String airbags, String climatizacion, String descapotable, String idcliente, String motivoVisita) {
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
	        String sql = "INSERT INTO vehiculo (`marca`, `modelo`, `matricula`, `nPuertas`, `airbags`, `maxVelocidad`, `capMotor`, `combustible`, `capAlmacenamiento`, `nPasajeros`, `ABS`, `GPS`, `climatizacion`, `descapotable`, `nRuedas`, `motivoVisita`, `tipoVehiculo`, `fechaAlta`, `idCliente`) VALUES ("
	        		+"'"+marca+"','"+modelo+"','"+matricula+"','"+nPuertas+"','"+airbags+"','"+maxVelocidad+"','"+capMotor+"','"+combustible+"','"+capAlmacenamiento+"','"+nPasajeros+"','"+ABS+"','"+GPS+"','"+climatizacion+"','"+descapotable+"','"+nRuedas+"','"+motivoVisita+"','4','"+fechaAlta+"','"+idcliente+"')";
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
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE tipoVehiculo='4'");
			
			if (resultado.next() == true) //move o cursor
			{	
				soluciones = "<html><body><table><tr><th>MATRÍCULA</th><th>MARCA</th><th>MODELO</th><th>Nº PUERTAS</th><th>AIRBAGS</th><th>VELOCIDAD MAX.</th><th>CAP.MOTOR</th><th>COMBUSTIBLE</th><th>CAP.ALMACENAMIENTO</th><th>Nº PASAJEROS</th><th>ABS</th><th>GPS</th><th>CLIMATIZACION</th><th>Nº RUEDAS</th><th>DESCAPOTABLE</th><th>MOT.VISITA</th><th>FECHA ALTA</th><th>DUEÑO</th></tr>";
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					marca = resultado.getString(2);
					modelo = resultado.getString(3);
					matricula = resultado.getString(4);
				    nPuertas = resultado.getString(5);
				    airbags = resultado.getBoolean(6);
				    if(airbags == true) {
				    	sairbags = "si";
				    }
				    else {
				    	sairbags = "no";			    	
				    }
				    maxVelocidad = resultado.getString(7);
				    capMotor = resultado.getString(8);
				    combustible = resultado.getString(9);
				    capAlmacenamiento = resultado.getString(10);
				    nPasajeros = resultado.getString(11);
				    ABS = resultado.getBoolean(12);
				    if(ABS == true) {
				    	sABS = "si";
				    }
				    else {
				    	sABS = "no";			    	
				    }
				    GPS = resultado.getBoolean(13);
				    if(GPS == true) {
				    	sGPS = "si";
				    }
				    else {
				    	sGPS = "no";			    	
				    }
				    climatizacion = resultado.getBoolean(14);
				    if(climatizacion == true) {
				    	sclimatizacion = "si";
				    }
				    else {
				    	sclimatizacion = "no";			    	
				    }
				    descapotable = resultado.getBoolean(15);
				    if(descapotable == true) {
				    	sdescapotable = "si";
				    }
				    else {
				    	sdescapotable = "no";			    	
				    }
				    nRuedas = resultado.getString(16);
				    motivoVisita = resultado.getString(17);
					tipovehiculo = resultado.getString(18);
				    fechaAlta = resultado.getString(19);
					idcliente = resultado.getString(20);
					
						resultado2 = sentencia2.executeQuery("SELECT * FROM persona WHERE id='"+idcliente+"'");
						while (resultado2.next())
						{
							nombrecliente = resultado2.getString(3) + " " + resultado2.getString(4);
						}
						
						resultado3 = sentencia3.executeQuery("SELECT * FROM tipo_vehiculo WHERE id='"+tipovehiculo+"'");
						while (resultado3.next())
						{
							nombretipovehiculo = resultado3.getString(2);
						}
					
					soluciones+="<tr><td>"+matricula+"</td><td>"+marca+"</td><td>"+modelo+"</td><td>"+nPuertas+"</td><td>"+sairbags+"</td><td>"+maxVelocidad+"</td><td>"+capMotor+"</td><td>"+combustible+"</td><td>"+capAlmacenamiento+"</td><td>"+nPasajeros+"</td><td>"+sABS+"</td><td>"+sGPS+"</td><td>"+sclimatizacion+"</td><td>"+nRuedas+"</td><td>"+sdescapotable+"</td><td>"+motivoVisita+"</td><td>"+fechaAlta+"</td><td>"+nombrecliente+"</td></tr>";
				
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
	public String consultarporMatricula(String matricula) {
 	
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE UPPER(matricula) LIKE UPPER('%"+matricula+"%') AND tipoVehiculo='4'");
		    
			if (resultado.next() == true) //move o cursor
			{	
				soluciones = "<html><body><table><tr><th>MATRÍCULA</th><th>MARCA</th><th>MODELO</th><th>Nº PUERTAS</th><th>AIRBAGS</th><th>VELOCIDAD MAX.</th><th>CAP.MOTOR</th><th>COMBUSTIBLE</th><th>CAP.ALMACENAMIENTO</th><th>Nº PASAJEROS</th><th>ABS</th><th>GPS</th><th>CLIMATIZACION</th><th>Nº RUEDAS</th><th>DESCAPOTABLE</th><th>MOT.VISITA</th><th>FECHA ALTA</th><th>DUEÑO</th></tr>";
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					marca = resultado.getString(2);
					modelo = resultado.getString(3);
					matricula = resultado.getString(4);
				    nPuertas = resultado.getString(5);
				    airbags = resultado.getBoolean(6);
				    if(airbags == true) {
				    	sairbags = "si";
				    }
				    else {
				    	sairbags = "no";			    	
				    }
				    maxVelocidad = resultado.getString(7);
				    capMotor = resultado.getString(8);
				    combustible = resultado.getString(9);
				    capAlmacenamiento = resultado.getString(10);
				    nPasajeros = resultado.getString(11);
				    ABS = resultado.getBoolean(12);
				    if(ABS == true) {
				    	sABS = "si";
				    }
				    else {
				    	sABS = "no";			    	
				    }
				    GPS = resultado.getBoolean(13);
				    if(GPS == true) {
				    	sGPS = "si";
				    }
				    else {
				    	sGPS = "no";			    	
				    }
				    climatizacion = resultado.getBoolean(14);
				    if(climatizacion == true) {
				    	sclimatizacion = "si";
				    }
				    else {
				    	sclimatizacion = "no";			    	
				    }
				    descapotable = resultado.getBoolean(15);
				    if(descapotable == true) {
				    	sdescapotable = "si";
				    }
				    else {
				    	sdescapotable = "no";			    	
				    }
				    nRuedas = resultado.getString(16);
				    motivoVisita = resultado.getString(17);
					tipovehiculo = resultado.getString(18);
				    fechaAlta = resultado.getString(19);
					idcliente = resultado.getString(20);
					
						resultado2 = sentencia2.executeQuery("SELECT * FROM persona WHERE id='"+idcliente+"'");
						while (resultado2.next())
						{
							nombrecliente = resultado2.getString(3) + " " + resultado2.getString(4);
						}
						
						resultado3 = sentencia3.executeQuery("SELECT * FROM tipo_vehiculo WHERE id='"+tipovehiculo+"'");
						while (resultado3.next())
						{
							nombretipovehiculo = resultado3.getString(2);
						}
					
					soluciones+="<tr><td>"+matricula+"</td><td>"+marca+"</td><td>"+modelo+"</td><td>"+nPuertas+"</td><td>"+sairbags+"</td><td>"+maxVelocidad+"</td><td>"+capMotor+"</td><td>"+combustible+"</td><td>"+capAlmacenamiento+"</td><td>"+nPasajeros+"</td><td>"+sABS+"</td><td>"+sGPS+"</td><td>"+sclimatizacion+"</td><td>"+nRuedas+"</td><td>"+sdescapotable+"</td><td>"+motivoVisita+"</td><td>"+fechaAlta+"</td><td>"+nombrecliente+"</td></tr>";
				
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
	public String consultarporMarca(String marca) {
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE UPPER(marca) LIKE UPPER('%"+marca+"%') AND tipoVehiculo='4'");
		    
			if (resultado.next() == true) //move o cursor
			{	
				soluciones = "<html><body><table><tr><th>MATRÍCULA</th><th>MARCA</th><th>MODELO</th><th>Nº PUERTAS</th><th>AIRBAGS</th><th>VELOCIDAD MAX.</th><th>CAP.MOTOR</th><th>COMBUSTIBLE</th><th>CAP.ALMACENAMIENTO</th><th>Nº PASAJEROS</th><th>ABS</th><th>GPS</th><th>CLIMATIZACION</th><th>Nº RUEDAS</th><th>DESCAPOTABLE</th><th>MOT.VISITA</th><th>FECHA ALTA</th><th>DUEÑO</th></tr>";
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					marca = resultado.getString(2);
					modelo = resultado.getString(3);
					matricula = resultado.getString(4);
				    nPuertas = resultado.getString(5);
				    airbags = resultado.getBoolean(6);
				    if(airbags == true) {
				    	sairbags = "si";
				    }
				    else {
				    	sairbags = "no";			    	
				    }
				    maxVelocidad = resultado.getString(7);
				    capMotor = resultado.getString(8);
				    combustible = resultado.getString(9);
				    capAlmacenamiento = resultado.getString(10);
				    nPasajeros = resultado.getString(11);
				    ABS = resultado.getBoolean(12);
				    if(ABS == true) {
				    	sABS = "si";
				    }
				    else {
				    	sABS = "no";			    	
				    }
				    GPS = resultado.getBoolean(13);
				    if(GPS == true) {
				    	sGPS = "si";
				    }
				    else {
				    	sGPS = "no";			    	
				    }
				    climatizacion = resultado.getBoolean(14);
				    if(climatizacion == true) {
				    	sclimatizacion = "si";
				    }
				    else {
				    	sclimatizacion = "no";			    	
				    }
				    descapotable = resultado.getBoolean(15);
				    if(descapotable == true) {
				    	sdescapotable = "si";
				    }
				    else {
				    	sdescapotable = "no";			    	
				    }
				    nRuedas = resultado.getString(16);
				    motivoVisita = resultado.getString(17);
					tipovehiculo = resultado.getString(18);
				    fechaAlta = resultado.getString(19);
					idcliente = resultado.getString(20);
					
						resultado2 = sentencia2.executeQuery("SELECT * FROM persona WHERE id='"+idcliente+"'");
						while (resultado2.next())
						{
							nombrecliente = resultado2.getString(3) + " " + resultado2.getString(4);
						}
						
						resultado3 = sentencia3.executeQuery("SELECT * FROM tipo_vehiculo WHERE id='"+tipovehiculo+"'");
						while (resultado3.next())
						{
							nombretipovehiculo = resultado3.getString(2);
						}
					
					soluciones+="<tr><td>"+matricula+"</td><td>"+marca+"</td><td>"+modelo+"</td><td>"+nPuertas+"</td><td>"+sairbags+"</td><td>"+maxVelocidad+"</td><td>"+capMotor+"</td><td>"+combustible+"</td><td>"+capAlmacenamiento+"</td><td>"+nPasajeros+"</td><td>"+sABS+"</td><td>"+sGPS+"</td><td>"+sclimatizacion+"</td><td>"+nRuedas+"</td><td>"+sdescapotable+"</td><td>"+motivoVisita+"</td><td>"+fechaAlta+"</td><td>"+nombrecliente+"</td></tr>";
				
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
	public String consultarporModelo(String modelo) {
 	
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE UPPER(modelo) LIKE UPPER('%"+modelo+"%') AND tipoVehiculo='4'");
		    
			if (resultado.next() == true) //move o cursor
			{	
				soluciones = "<html><body><table><tr><th>MATRÍCULA</th><th>MARCA</th><th>MODELO</th><th>Nº PUERTAS</th><th>AIRBAGS</th><th>VELOCIDAD MAX.</th><th>CAP.MOTOR</th><th>COMBUSTIBLE</th><th>CAP.ALMACENAMIENTO</th><th>Nº PASAJEROS</th><th>ABS</th><th>GPS</th><th>CLIMATIZACION</th><th>Nº RUEDAS</th><th>DESCAPOTABLE</th><th>MOT.VISITA</th><th>FECHA ALTA</th><th>DUEÑO</th></tr>";
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					marca = resultado.getString(2);
					modelo = resultado.getString(3);
					matricula = resultado.getString(4);
				    nPuertas = resultado.getString(5);
				    airbags = resultado.getBoolean(6);
				    if(airbags == true) {
				    	sairbags = "si";
				    }
				    else {
				    	sairbags = "no";			    	
				    }
				    maxVelocidad = resultado.getString(7);
				    capMotor = resultado.getString(8);
				    combustible = resultado.getString(9);
				    capAlmacenamiento = resultado.getString(10);
				    nPasajeros = resultado.getString(11);
				    ABS = resultado.getBoolean(12);
				    if(ABS == true) {
				    	sABS = "si";
				    }
				    else {
				    	sABS = "no";			    	
				    }
				    GPS = resultado.getBoolean(13);
				    if(GPS == true) {
				    	sGPS = "si";
				    }
				    else {
				    	sGPS = "no";			    	
				    }
				    climatizacion = resultado.getBoolean(14);
				    if(climatizacion == true) {
				    	sclimatizacion = "si";
				    }
				    else {
				    	sclimatizacion = "no";			    	
				    }
				    descapotable = resultado.getBoolean(15);
				    if(descapotable == true) {
				    	sdescapotable = "si";
				    }
				    else {
				    	sdescapotable = "no";			    	
				    }
				    nRuedas = resultado.getString(16);
				    motivoVisita = resultado.getString(17);
					tipovehiculo = resultado.getString(18);
				    fechaAlta = resultado.getString(19);
					idcliente = resultado.getString(20);
					
						resultado2 = sentencia2.executeQuery("SELECT * FROM persona WHERE id='"+idcliente+"'");
						while (resultado2.next())
						{
							nombrecliente = resultado2.getString(3) + " " + resultado2.getString(4);
						}
						
						resultado3 = sentencia3.executeQuery("SELECT * FROM tipo_vehiculo WHERE id='"+tipovehiculo+"'");
						while (resultado3.next())
						{
							nombretipovehiculo = resultado3.getString(2);
						}
					
					soluciones+="<tr><td>"+matricula+"</td><td>"+marca+"</td><td>"+modelo+"</td><td>"+nPuertas+"</td><td>"+sairbags+"</td><td>"+maxVelocidad+"</td><td>"+capMotor+"</td><td>"+combustible+"</td><td>"+capAlmacenamiento+"</td><td>"+nPasajeros+"</td><td>"+sABS+"</td><td>"+sGPS+"</td><td>"+sclimatizacion+"</td><td>"+nRuedas+"</td><td>"+sdescapotable+"</td><td>"+motivoVisita+"</td><td>"+fechaAlta+"</td><td>"+nombrecliente+"</td></tr>";
				
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
	public String getUltimoRegitro() {
    	try {
			resultado = sentencia.executeQuery("SELECT MAX(id) FROM vehiculo WHERE tipoVehiculo='7'");
			while (resultado.next()) {
				id = resultado.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
    }
	
	@Override
	public ArrayList MarcaVehiculo() {
		marcavehiculo = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE tipoVehiculo='4'");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					marca = resultado.getString(2); //marca
					
					marcavehiculo.add(marca);
				}
			}
			else {
				marcavehiculo.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marcavehiculo;		
	}
	
	@Override
	public ArrayList ModeloVehiculo() {
		marcavehiculo = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE tipoVehiculo='4'");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					modelo = resultado.getString(3); //modelo
					
					marcavehiculo.add(modelo);
				}
			}
			else {
				marcavehiculo.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marcavehiculo;		
	}
	
	@Override
	public ArrayList MatriculaVehiculo() {
		marcavehiculo = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE tipoVehiculo='4'");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					matricula = resultado.getString(4); //matricula
					
					marcavehiculo.add(matricula);
				}
			}
			else {
				marcavehiculo.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marcavehiculo;		
	}
	
	@Override
	public ArrayList IDVehiculo() {
		marcavehiculo = new ArrayList();
		try {
			resultado = sentencia.executeQuery("SELECT * FROM vehiculo WHERE tipoVehiculo='4'");
			
			if (resultado.next() == true) //move o cursor
			{	
				resultado.beforeFirst(); //volve a poñer de primeiro o cursor
				while (resultado.next()) {
					id = resultado.getString(1); //nombre
					
					marcavehiculo.add(id);
				}
			}
			else {
				marcavehiculo.add("No hay resultados.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marcavehiculo;		
	}
}
