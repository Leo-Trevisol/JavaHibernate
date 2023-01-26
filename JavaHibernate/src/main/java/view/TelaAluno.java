package view;

import java.awt.*;

import javax.swing.JInternalFrame;

public class TelaAluno extends JInternalFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = -5828468579862413749L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAluno frame = new TelaAluno();
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
	public TelaAluno() {
		setBounds(100, 100, 450, 300);

	}

}
