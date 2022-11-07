package textual;

import java.sql.*;
/**
 * Conexion es una clase para conectar con la BD .
 * 
 * @author Adriana Armental Tomé
 * @version 06.03.2017
 */
public class ConexionBD
{
    static final String DATABASE_URL = "jdbc:mysql://localhost/taller";
    static final String USER = "root";
    static final String PASSWORD = "";
    Connection con;

    public ConexionBD()
    {
        try {	
             //Carregamos o driver JDBC
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        } 
    }

	public Connection getCon() {
		return con;
	}   
    
}