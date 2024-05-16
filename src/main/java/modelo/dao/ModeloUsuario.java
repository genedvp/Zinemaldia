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
	        	usuario.setIdUsuario(rs.getInt("id_usuario"));
	            usuario.setNombre(rs.getString("nombre"));
	            usuario.setApellidos(rs.getString("apellidos"));
	            usuario.setContra(rs.getString("contrasenia"));
	            usuario.setCorreo(rs.getString("correo_electronico"));
	            usuario.setRol(rs.getString("rol"));
	            //usuario.setRegistrado(rs.getInt("registrado"));
	            
	            usuarios.add(usuario);
	            
	        }
			} catch (SQLException e) {
				
				System.out.println("no se han encontrado usuarios");
				
				e.printStackTrace();
			}

	            
		return usuarios;
	    }

	public int insertUsuario(Usuario usuario) {
	    try {
	        // Preparar la sentencia SQL para la inserción
	        String sql = "INSERT INTO usuarios (nombre, apellidos, correo_electronico, contrasenia, rol) VALUES (?,?,?,?,?)";
	        PreparedStatement pstmt = conexion.prepareStatement(sql);
	        
	        // Establecer los valores del usuario en la sentencia preparada
	        pstmt.setString(1, usuario.getNombre());
	        pstmt.setString(2, usuario.getApellidos());
	        pstmt.setString(3, usuario.getCorreo());
	        pstmt.setString(4, usuario.getContra());
	        pstmt.setString(5, usuario.getRol());
	        //pstmt.setInt(6, usuario.getRegistrado());
	        
	        pstmt.executeUpdate();
	        
	        System.out.println("Usuario insertado correctamente.");
	        
	        int id = obtenerIdCreado(usuario);
	        
	        return id;
	        
	    } catch (SQLException e) {
	    	
	        System.out.println("Error al insertar usuario.");
	        
			return 0;
	    }
	}

	public int obtenerIdCreado(Usuario usuario) {
	    String sql = "SELECT id_usuario FROM usuarios WHERE correo_electronico=?";
	    try {
	        PreparedStatement pst = conexion.prepareStatement(sql);
	        pst.setString(1, usuario.getCorreo());
	        ResultSet rs = pst.executeQuery();
	        
	        if (rs.next()) {
	            int id = rs.getInt("id_usuario");
	            return id;
	        } else {

	            return 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return 0; 
	    }
	}

	
	public boolean usuarioExiste(String correo) {
		
		String sql = "select count(id_usuario) as existe from usuarios where correo_electronico=?";
		try {
			
			PreparedStatement pst= conexion.prepareStatement(sql);
			pst.setString(1, correo);
			ResultSet rs = pst.executeQuery();
			int id = rs.getInt("existe");
			
			if (id>0) {return true;
							} else { return false;}
			
		} catch (SQLException e) {
			return false;
		}	
	}

	public Usuario getUsuario(int id) {
	    Usuario usuario = null;

	    try {
	        PreparedStatement statement = conexion.prepareStatement("SELECT * FROM usuarios WHERE id_usuario = ?");
	        statement.setInt(1, id);

	        ResultSet rs = statement.executeQuery();

	        if (rs.next()) {
	            usuario = new Usuario();
	            usuario.setIdUsuario(rs.getInt("id_usuario"));
	            usuario.setNombre(rs.getString("nombre"));
	            usuario.setApellidos(rs.getString("apellidos"));
	            usuario.setContra(rs.getString("contrasenia"));
	            usuario.setCorreo(rs.getString("correo_electronico"));
	            usuario.setRol(rs.getString("rol"));
	            // usuario.setRegistrado(rs.getInt("registrado"));
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al obtener el usuario con ID " + id);
	        e.printStackTrace();
	    }

	    return usuario;
	}

	public boolean deleteUsuario(int id) {
        try {
            PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM usuarios WHERE id_usuario=?");
            pst.setInt(1, id);
            pst.execute();
            
            return true;
            
        } catch (SQLException e) {
        	
            e.printStackTrace();
            return false;
            
        }
		
	}
    public int updateUsuario(Usuario usuario) {
        try {
            PreparedStatement pstmt = this.conexion.prepareStatement("UPDATE usuarios SET nombre=?, apellidos=?, correo_electronico=?, contrasenia=?, rol=? WHERE id_usuario = ?");

            pstmt.setString(1, usuario.getNombre());
	        pstmt.setString(2, usuario.getApellidos());
	        pstmt.setString(3, usuario.getCorreo());
	        pstmt.setString(4, usuario.getContra());
	        pstmt.setString(5, usuario.getRol());

            return pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
	
}


