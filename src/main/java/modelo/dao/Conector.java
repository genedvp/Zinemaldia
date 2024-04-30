package modelo.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
	
	protected Connection conexion;
	java.sql.Statement statement;

	/**
	 */

	Conector() {
			try {	             
	              Class.forName("com.mysql.cj.jdbc.Driver");
	              this.conexion = DriverManager.getConnection("jdbc:mysql://" + Config.HOST + "/" + Config.BBDD, Config.USERNAME, Config.PASSWORD);
	              System.out.println("Mysql connected");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
