package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Aluno;
import conexao.ConexaoBD;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

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
	private JTable table = new JTable();
	Session session = ConexaoBD.getSessionFactory().openSession();
	Transaction transaction = null;
	List<Aluno> lstAlunos = new ArrayList<>();
	int posiatual = 0;

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
		lbnome.setBounds(308, 29, 95, 32);
		contentPane.add(lbnome);

		JLabel lbcodigo = new JLabel("Codigo");
		lbcodigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbcodigo.setBounds(46, 29, 95, 32);
		contentPane.add(lbcodigo);

		JLabel lbcidade = new JLabel("Cidade:");
		lbcidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbcidade.setBounds(46, 71, 95, 32);
		contentPane.add(lbcidade);

		JLabel lbfone = new JLabel("Fone:");
		lbfone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbfone.setBounds(361, 71, 95, 32);
		contentPane.add(lbfone);

		JLabel lbcurso = new JLabel("Curso:");
		lbcurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbcurso.setBounds(46, 113, 95, 32);
		contentPane.add(lbcurso);

		txtcodigo = new JTextField();
		txtcodigo.setBounds(123, 35, 168, 30);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);

		txtnome = new JTextField();
		txtnome.setColumns(10);
		txtnome.setBounds(371, 29, 214, 30);
		contentPane.add(txtnome);

		txtfone = new JTextField();
		txtfone.setColumns(10);
		txtfone.setBounds(411, 77, 200, 30);
		contentPane.add(txtfone);

		txtcidade = new JTextField();
		txtcidade.setColumns(10);
		txtcidade.setBounds(117, 77, 224, 30);
		contentPane.add(txtcidade);

		txtcurso = new JTextField();
		txtcurso.setColumns(10);
		txtcurso.setBounds(117, 113, 214, 30);
		contentPane.add(txtcurso);

		JButton btnovo = new JButton("Novo");
		
		btnovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtcodigo.setText( "");
				txtnome.setText("");
				txtcidade.setText( "");
				txtfone.setText("");
				txtcurso.setText( "");
			}
		});
		
		
		btnovo.setBounds(56, 155, 100, 37);
		contentPane.add(btnovo);

		JButton btsalvar = new JButton("Salvar");
		btsalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transaction transaction = null;
		    	try {
		    		if(!session.isOpen())
					{
						transaction = (Transaction) session.beginTransaction();
					}
		    		
				Aluno aluno = new Aluno();
				aluno.setAlu_codigo(Integer.parseInt(txtcodigo.getText()));
				aluno.setAlu_nome(txtnome.getText());
				aluno.setAlu_fone(txtfone.getText());
				aluno.setAlu_cidade(txtcidade.getText());
				aluno.setAlu_curso(txtcurso.getText());
				
				 session.persist(aluno);
		            
		          
				 transaction.commit();
				
				session.clear();
				
			}catch(Exception f) {
				System.out.println("Erro ao cadastrar aluno: " + f.getMessage());
			}
		    	
		    	povoarTable();
			
		}
		});
		btsalvar.setBounds(184, 155, 100, 37);
		contentPane.add(btsalvar);

		JButton btalterar = new JButton("Alterar");
		btalterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transaction transaction = null;
		    	try {
		    		if(!session.isOpen())
					{
						transaction = (Transaction) session.beginTransaction();
					}
		    		
				Aluno aluno = new Aluno();
				aluno.setAlu_codigo(Integer.parseInt(txtcodigo.getText()));
				aluno.setAlu_nome(txtnome.getText());
				aluno.setAlu_fone(txtfone.getText());
				aluno.setAlu_cidade(txtcidade.getText());
				aluno.setAlu_curso(txtcurso.getText());
				
				 session.update(aluno);
				 transaction.commit();
				
				session.clear();
				
			}catch(Exception f) {
				System.out.println("Erro ao editar aluno: " + f.getMessage());
			}
		    	
		    	povoarTable();
				
			}
		});
		btalterar.setBounds(331, 155, 100, 37);
		contentPane.add(btalterar);

		JButton btexcluir = new JButton("Excluir");
		btexcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						transaction = (Transaction) session.beginTransaction();
					
					Aluno aluno = new Aluno();
					aluno.setAlu_codigo(Integer.parseInt(txtcodigo.getText()));
					 session.remove(aluno);
					 transaction.commit();
					
					session.clear();

				} catch (Exception f) {
					System.out.println("Erro ao excluir aluno: " +f.getMessage());
				}
				
				povoarTable();
			}
		});
		btexcluir.setBounds(457, 155, 100, 37);
		contentPane.add(btexcluir);

		JList list = new JList();
		list.setBounds(172, 291, 1, 1);
		contentPane.add(list);

		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(89, 222, 458, 122);
		contentPane.add(scrollPane);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = table.rowAtPoint(e.getPoint());
				txtcodigo.setText(table.getValueAt(linha,0).toString());
				txtnome.setText(table.getValueAt(linha,1).toString());
				txtcidade.setText(table.getValueAt(linha,2).toString());
				txtfone.setText(table.getValueAt(linha,3).toString());
				txtcurso.setText(table.getValueAt(linha,4).toString());
				
				try {
					
					List<Aluno> lstAlunos = new ArrayList<>();
					lstAlunos = session.createQuery("From Aluno").list();
					
					int sizeList = lstAlunos.size();
					
					for(int i = 0; i <sizeList; i++) {
						if(lstAlunos.get(i).getAlu_codigo() == Integer.parseInt(txtcodigo.getText())) {
							posiatual = i;
							break;
							
						}
					}
				
			} catch (Exception f) {
				System.out.println("Erro ao buscar aluno: " + f.getMessage());
			}
			}
		});

		table.setEnabled(false);

		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Codigo", "Nome", "Cidade", "Fone", "Curso" }));

		scrollPane.setViewportView(table);
		
		JButton voltartodos = new JButton("|<<");
		voltartodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posiatual =0;
				atualizarFields();
			}
		});
		voltartodos.setBounds(99, 363, 85, 21);
		contentPane.add(voltartodos);
		
		JButton voltarum = new JButton("<<");
		voltarum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(posiatual != 0) {
					posiatual--;
					atualizarFields();
				}
			}
		});
		voltarum.setBounds(220, 363, 85, 21);
		contentPane.add(voltarum);
		
		JButton avancarum = new JButton(">>");
		avancarum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!((posiatual +1) == lstAlunos.size())) {
					posiatual++;
					atualizarFields();
				}
				
			}
		});
		avancarum.setBounds(334, 363, 85, 21);
		contentPane.add(avancarum);
		
		JButton avancartodos = new JButton(">>|");
		avancartodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posiatual = lstAlunos.size() -1;
				atualizarFields();
			}
		});
		avancartodos.setBounds(446, 363, 85, 21);
		contentPane.add(avancartodos);
		povoarTable();
		
	}

	public void povoarTable() {
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(90);
		
		DefaultTableModel model =  (DefaultTableModel) table.getModel();
		
		model.setNumRows(0);
		try {
			
			lstAlunos = session.createQuery("From Aluno").list();
			
			int sizeList = lstAlunos.size();
			
			if(model.getRowCount() > 0 ) {
			for(int i = 0; i <sizeList; i++) {
				model.removeRow(i);
			}
			}
			
			for(int i = 0; i <sizeList; i++) {
				
				Aluno aluno = lstAlunos.get(i);
				model.addRow(new Object[]{aluno.getAlu_codigo(), aluno.getAlu_nome(), aluno.getAlu_cidade(), aluno.getAlu_fone(), aluno.getAlu_curso()});
				if(i == 0) {
					txtcodigo.setText(aluno.getAlu_codigo() + "");
					txtnome.setText(aluno.getAlu_nome() + "");
					txtcidade.setText(aluno.getAlu_cidade() + "");
					txtfone.setText(aluno.getAlu_fone() + "");
					txtcurso.setText(aluno.getAlu_curso() + "");
				}
			}
		}catch(Exception e ) {
			System.out.println("Erro ao popular table " + e.getMessage());
			
		}
		
	}
	
	public void atualizarFields() {
		if(lstAlunos.size() != 0) {
		Aluno aluno = lstAlunos.get(posiatual);
		txtcodigo.setText(aluno.getAlu_codigo() + "");
		txtnome.setText(aluno.getAlu_nome() + "");
		txtcidade.setText(aluno.getAlu_cidade() + "");
		txtfone.setText(aluno.getAlu_fone() + "");
		txtcurso.setText(aluno.getAlu_curso() + "");
		
	}
}
}
