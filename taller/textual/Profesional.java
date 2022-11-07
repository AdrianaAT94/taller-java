package textual;

import java.util.ArrayList;

/**
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */
public abstract class Profesional extends Vehiculo
{

	public Profesional() {}
	
	@Override
	public boolean insertar(String marca, String modelo, String matricula, String combustible, String nPuertas, String nRuedas, String maxVelocidad, String capMotor, String capAlmacenamiento, String nPasajeros, String ABS, String GPS, String airbags, String climatizacion, String descapotable, String idcliente, String motivoVisita) {
		return false;
	}
		
	    @Override
		public String listar() {
			return null;
		}
		
		@Override
		public String consultarporMatricula(String matricula) {
			return null;
		}
	    
	    @Override
		public String consultarporMarca(String marca) {
			return null;
		}

	    @Override
		public String consultarporModelo(String modelo) {
			return null;
		}

	    @Override
		public ArrayList ModeloVehiculo(){
			return null;
		}
	    @Override
		public ArrayList MatriculaVehiculo(){
			return null;
		}
	    @Override
		public ArrayList IDVehiculo(){
			return null;
		}
}