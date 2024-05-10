package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ModeloUsuario extends Conector{

	public ArrayList<Usuario> getTodos() {
		
		ArrayList<Usuario> usuarios = new ArrayList<>();

	        Statement st;
			try {
				st = conexion.createStatement();

	        ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
	        while (rs.next()) {
	        	
	        	Usuario usuario = new Usuario();
	            usuario.setNombre(rs.getString("nombre"));
	            usuario.setContra(rs.getString("contrasenia"));
	            usuario.setRol(rs.getString("rol"));
	            //usuario.setRegistrado(rs.getInt("registrado"));
	            usuario.setId(rs.getInt("id_usuario"));
	            
	            usuarios.add(usuario);
	            
	        }
			} catch (SQLException e) {
				
				System.out.println("no se han encontrado usuarios");
				
				e.printStackTrace();
			}

	            
		return usuarios;
	    }

	public void insertUsuario(Usuario usuario) {
	    try {
	        // Preparar la sentencia SQL para la inserción
	        String sql = "INSERT INTO usuarios (nombre, contrasenia, rol) VALUES (?, ?, ?)";
	        PreparedStatement pstmt = conexion.prepareStatement(sql);
	        
	        // Establecer los valores del usuario en la sentencia preparada
	        pstmt.setString(1, usuario.getNombre());
	        pstmt.setString(2, usuario.getContra());
	        pstmt.setString(3, usuario.getRol());
	        //pstmt.setInt(4, usuario.getRegistrado());
	        
	        // Ejecutar la sentencia de inserción
	        pstmt.executeUpdate();
	        
	        System.out.println("Usuario insertado correctamente.");

	    } catch (SQLException e) {
	        System.out.println("Error al insertar usuario.");
	        e.printStackTrace();
	    }
	}

	}
