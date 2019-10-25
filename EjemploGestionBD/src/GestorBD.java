import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GestorBD {
	
	private Connection conn = null;
	
	public void conectar() throws BDException {
			try {
				Class.forName("org.sqlite.JDBC");//carga del driver
				conn = DriverManager.getConnection("jdbc:sqlite:data/ejemploGestor.db");
			}catch (ClassNotFoundException e) {
				throw new BDException("No se ha podido cargar el driver",e);
			} catch (SQLException e) {
				throw new BDException("No se ha podido conectar con la BD",e);
			}
	}
	
	public void desconectar() throws BDException {
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new BDException("No se ha podido cerrar la conexión con la BD",e);
		}
	}
	
	public void crearTablaUsuario() throws BDException { // No hay q acordarse del close, asi lo hace solo
		try (Statement stmt = conn.createStatement()){// lo que tiene que cerrar
			stmt.executeUpdate("CREATE TABLE usuario (id INTEGER PRIMARY KEY, nombre VARCHAR, apellido VARCHAR)");
		}catch (SQLException e) {
			throw new BDException("No se ha podido crear la tabla 'usuario'",e);
		}
	}
	
	public void borrarTablaUsuario() throws BDException { // No hay q acordarse del close, asi lo hace solo
		try (Statement stmt = conn.createStatement()){// lo que tiene que cerrar
			stmt.executeUpdate("DROP TABLE usuario");
		}catch (SQLException e) {
			throw new BDException("No se ha podido crear la tabla 'usuario'",e);
		}
	}
	
	public List<Usuario> obtenerTodosUsuario() throws BDException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try (Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery("SELECT id, nombre, apellido FROM usuario");
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				
				usuarios.add(u);
			}
		}catch (SQLException e) {
			throw new BDException("No se pudo obtener la lista de la tabla 'usuario'",e);
		}
		
		return usuarios;
	}
	
	public Usuario obtenerUsuarioId(int id) throws BDException {
		try (Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery("SELECT id, nombre, apellido FROM usuario WHERE id="+id);
			if(rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				return u;
			}else {
				return new Usuario();
			}
		}catch (SQLException e) {
			throw new BDException("No se pudo obtener el usuario con el id "+id,e);
		} 
	}
	
	public List<Usuario> obtenerUsuarioApellido(String apellido) throws BDException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try (Statement stmt = conn.createStatement()){
			ResultSet rs = stmt.executeQuery("SELECT id, nombre, apellido FROM usuario WHERE apellido='"+apellido+"'");
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNombre(rs.getString("nombre"));
				u.setApellido(rs.getString("apellido"));
				usuarios.add(u);
			}
		}catch (SQLException e) {
			throw new BDException("No se pudo obtener el usuario con el apellido "+apellido,e);
		} 
		return usuarios;
	}
}
