package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class TelaAluno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8367072039961003264L;
	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtnome;
	private JTextField txtfone;
	private JTextField txtcidade;
	private JTextField txtcurso;
	private JTable table;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 431);
		contentPane = new JPanel(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel);
		
		JLabel lbnome = new JLabel("Nome: ");
		lbnome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbnome.setBounds(46, 71, 95, 32);
		contentPane.add(lbnome);
		
		JLabel lbcodigo = new JLabel("Codigo");
		lbcodigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbcodigo.setBounds(46, 29, 95, 32);
		contentPane.add(lbcodigo);
		
		JLabel lbcidade = new JLabel("Cidade:");
		lbcidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbcidade.setBounds(295, 29, 95, 32);
		contentPane.add(lbcidade);
		
		JLabel lbfone = new JLabel("Fone:");
		lbfone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbfone.setBounds(339, 71, 95, 32);
		contentPane.add(lbfone);
		
		JLabel lbcurso = new JLabel("Curso:");
		lbcurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbcurso.setBounds(46, 113, 95, 32);
		contentPane.add(lbcurso);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(117, 29, 168, 30);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnome = new JTextField();
		txtnome.setColumns(10);
		txtnome.setBounds(117, 71, 214, 30);
		contentPane.add(txtnome);
		
		txtfone = new JTextField();
		txtfone.setColumns(10);
		txtfone.setBounds(395, 71, 200, 30);
		contentPane.add(txtfone);
		
		txtcidade = new JTextField();
		txtcidade.setColumns(10);
		txtcidade.setBounds(371, 29, 224, 30);
		contentPane.add(txtcidade);
		
		txtcurso = new JTextField();
		txtcurso.setColumns(10);
		txtcurso.setBounds(117, 113, 214, 30);
		contentPane.add(txtcurso);
		
		JButton btnovo = new JButton("Novo");
		btnovo.setBounds(46, 177, 100, 37);
		contentPane.add(btnovo);
		
		JButton btsalvar = new JButton("Salvar");
		btsalvar.setBounds(156, 177, 100, 37);
		contentPane.add(btsalvar);
		
		JButton btalterar = new JButton("Alterar");
		btalterar.setBounds(276, 177, 100, 37);
		contentPane.add(btalterar);
		
		JButton btexcluir = new JButton("Excluir");
		btexcluir.setBounds(395, 177, 100, 37);
		contentPane.add(btexcluir);
		
		JList list = new JList();
		list.setBounds(172, 291, 1, 1);
		contentPane.add(list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 244, 458, 122);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Codigo", "Nome", "Cidade", "Fone", "Curso"
			}
		));
		scrollPane.setViewportView(table);
	}
}