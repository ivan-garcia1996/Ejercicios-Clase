import javax.swing.JFrame;

public class Ventana extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ventana() {
		this.setTitle("Mi primera Ventana");
		this.setSize(320,240);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("K pasa pe�ita");
		Ventana v1 = new Ventana();
		v1.setVisible(true);

	}

}
