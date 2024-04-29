package modelo.dao;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conector {
	
	protected Connection conexion;
	Statement statement;

	/**
	 */

	Conector() {
			try {	             
	              String url = "jdbc:mysql://192.168.1.20:3306/zinemaldia?user=root&password=1324"; 
	              Class.forName("com.mysql.jdbc.Driver");
	              this.conexion = DriverManager.getConnection(url);	  
	              statement = (Statement) conexion.createStatement();
	              System.out.println("Mysql connected");
	              
				//this.conexion = DriverManager.getConnection("jdbc:mysql://" + Config.HOST + "/" + Config.BBDD, Config.USERNAME, Config.PASSWORD);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
}