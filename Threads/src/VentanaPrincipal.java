import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class VentanaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private boolean stop = false;
	private int i=0;

	public VentanaPrincipal() {
		
		setSize(640,480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel bPanel = new JPanel();
		add(bPanel, BorderLayout.SOUTH);
		
		JButton b = new JButton("Click");
		bPanel.add(b);
		
		JProgressBar p = new JProgressBar(0,1000000);
		add(p, BorderLayout.NORTH);
		
		
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Thread t = new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						for(i = 0; i<1000001 && !stop; i++) {
							System.out.println(i);
							
							SwingUtilities.invokeLater(new Runnable() {
								
								public void run() {
									p.setValue(i);
								}
							});
							
						}
					}  
					
				});
				
				t.start();
			}
		});
		
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				stop = true;
			}
		});
		
	}

	public static void main(String[] args) {
		
		VentanaPrincipal v1 = new VentanaPrincipal();
		v1.setVisible(true);
		// TODO Auto-generated method stub

	}

}
