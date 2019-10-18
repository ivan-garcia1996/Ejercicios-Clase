import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EjemploEscritura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Alumno a = new Alumno();
		a.setNombre("Ivan");
		a.setApellido("Garcia");
		
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(new File("datos.bin")))){
			os.writeObject(a);
		}catch(FileNotFoundException e){
			System.out.println("No se ha encontrado el fichero");
		}catch(IOException e){
			System.out.println("No se a podido serializar el objeto");
		}
	}
}
