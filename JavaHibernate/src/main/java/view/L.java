package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class L extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					L frame = new L();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public L() {
		setBounds(100, 100, 450, 300);

	}

}
