import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class EjemploProperties {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		p.setProperty("carpeta", "C:\\user\\all\\datos");
		p.setProperty("usuario", "maria");
		p.setProperty("ventana", "680,480");
		
		try {
		FileOutputStream fos = new FileOutputStream(new File("config.ini"));
			try {
				p.store(fos, "Esto es un ejemplo de configuracion" );
			}
			catch (IOException e){
				System.out.println("No se ha podido escribir el fichero" + e.getMessage());
			}finally {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}catch(FileNotFoundException e) {
			System.out.println("No se ha podido abrir el fichero" + e.getMessage());
		}
		
		System.out.println("Programa terminado");
	}

}
