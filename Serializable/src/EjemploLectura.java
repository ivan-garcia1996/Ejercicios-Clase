import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class EjemploLectura {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(new File("datos.bin")))){
			Alumno a = (Alumno) is.readObject();
			System.out.println(a.getNombre());
			System.out.println(a.getApellido());
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
