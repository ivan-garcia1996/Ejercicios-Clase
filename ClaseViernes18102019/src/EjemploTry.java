import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EjemploTry { // try with resources hace lo mismo que leerpropiedades pero sin tener el close
	
	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream(new File("config.ini"))){
			Properties p = new Properties();
			p.load(fis);
			System.out.println(p.getProperty("usuario"));		
		}catch (FileNotFoundException e) {
			System.out.println("No se ha podido encontrar el fichero");
		}catch (IOException e) {
			
		}
	}
}
