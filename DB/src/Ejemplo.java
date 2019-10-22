import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.sqlite.JDBC");//carga del driver
			Connection conn = DriverManager.getConnection("jdbc:sqlite:data/ejemplo.db");
			Statement stmt = conn.createStatement();
			//conexion abierta
			//statement creado
			ResultSet rs = stmt.executeQuery("SELECT nombre, apellido FROM Usuario");
			while(rs.next()) {
				//estoy en una fila del resultado
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				System.out.println(nombre);
				System.out.println(apellido);
			}
			//cerramos al terminar de usarlos
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido cargar el driver");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido conectar con la BD");
		}
	}

}
