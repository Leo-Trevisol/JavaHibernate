package view;

import java.awt.Color;
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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Aluno;
import conexao.ConexaoBD;
import dao.AlunoDao;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

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
	AlunoDao alunodao = new AlunoDao();
	String filtro = " from Aluno ";
	String orderby = " order by alu_codigo ";
	private JTextField txtpesquisar;

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
		setBounds(100, 100, 695, 482);
		contentPane = new JPanel(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel);

		JLabel lbnome = new JLabel("Nome: ");
		lbnome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbnome.setBounds(338, 91, 66, 32);
		contentPane.add(lbnome);

		JLabel lbcodigo = new JLabel("Codigo");
		lbcodigo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbcodigo.setBounds(89, 91, 65, 32);
		contentPane.add(lbcodigo);

		JLabel lbcidade = new JLabel("Cidade:");
		lbcidade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbcidade.setBounds(89, 133, 95, 32);
		contentPane.add(lbcidade);

		JLabel lbfone = new JLabel("Fone:");
		lbfone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbfone.setBounds(402, 133, 95, 32);
		contentPane.add(lbfone);

		JLabel lbcurso = new JLabel("Curso:");
		lbcurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbcurso.setBounds(89, 173, 65, 32);
		contentPane.add(lbcurso);

		txtcodigo = new JTextField();
		txtcodigo.setEnabled(false);
		txtcodigo.setBounds(160, 97, 168, 30);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);

		txtnome = new JTextField();
		txtnome.setColumns(10);
		txtnome.setBounds(414, 97, 240, 30);
		contentPane.add(txtnome);

		txtfone = new JTextField();
		txtfone.setColumns(10);
		txtfone.setBounds(458, 139, 196, 30);
		contentPane.add(txtfone);

		txtcidade = new JTextField();
		txtcidade.setColumns(10);
		txtcidade.setBounds(160, 133, 224, 30);
		contentPane.add(txtcidade);

		txtcurso = new JTextField();
		txtcurso.setColumns(10);
		txtcurso.setBounds(160, 173, 224, 30);
		contentPane.add(txtcurso);

		JButton btnovo = new JButton("Novo");
		table.setSelectionBackground(Color.yellow);
		
		btnovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtcodigo.setText( "");
				txtnome.setText("");
				txtcidade.setText( "");
				txtfone.setText("");
				txtcurso.setText( "");
			}
		});
		
		
		btnovo.setBounds(122, 226, 100, 37);
		contentPane.add(btnovo);

		JButton btsalvaralterar = new JButton("Salvar ou Atualizar");
		btsalvaralterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		    		System.out.println(txtcodigo.getText());
				Aluno aluno = new Aluno();
				if(!(txtcodigo.getText().isEmpty())) {
					aluno.setAlu_codigo(Integer.parseInt(txtcodigo.getText()));
				}
				aluno.setAlu_nome(txtnome.getText());
				aluno.setAlu_fone(txtfone.getText());
				aluno.setAlu_cidade(txtcidade.getText());
				aluno.setAlu_curso(txtcurso.getText());
				
				alunodao.saveOrUpdate(aluno);
		    	povoarTable();
			
		}
		});
		btsalvaralterar.setBounds(267, 226, 157, 37);
		contentPane.add(btsalvaralterar);

		JButton btexcluir = new JButton("Excluir");
		btexcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					Aluno aluno = new Aluno();
					aluno.setAlu_codigo(Integer.parseInt(txtcodigo.getText()));
					alunodao.deleta(aluno);
					posiatual = 0;
				atualizarFields();
				povoarTable();
			}
		});
		btexcluir.setBounds(480, 226, 100, 37);
		contentPane.add(btexcluir);

		JList list = new JList();
		list.setBounds(205, 342, 1, 1);
		contentPane.add(list);

		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(122, 273, 458, 122);
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
		voltartodos.setBounds(132, 414, 85, 21);
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
		voltarum.setBounds(253, 414, 85, 21);
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
		avancarum.setBounds(367, 414, 85, 21);
		contentPane.add(avancarum);
		
		JButton avancartodos = new JButton(">>|");
		avancartodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				posiatual = lstAlunos.size() -1;
				atualizarFields();
			}
		});
		avancartodos.setBounds(479, 414, 85, 21);
		contentPane.add(avancartodos);
		
		JLabel lbpesquisar = new JLabel("Pesquisar aluno:");
		lbpesquisar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbpesquisar.setBounds(78, 22, 175, 32);
		contentPane.add(lbpesquisar);
		
		txtpesquisar = new JTextField();
		txtpesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				filtro = "from Aluno where upper(alu_nome) like'" + txtpesquisar.getText().toUpperCase() + "%'";
				
				if(!txtpesquisar.getText().isEmpty()) {
				 char c = txtpesquisar.getText().charAt(0);
				if (Character.isDigit(c)) {
				filtro += " or alu_codigo like '" +
				Integer.parseInt(txtpesquisar.getText()) + "%' ";
				}
				}	
				

				povoarTable();
			}
		});
		txtpesquisar.setColumns(10);
		txtpesquisar.setBounds(236, 22, 183, 30);
		contentPane.add(txtpesquisar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(458, 22, 196, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbordenar = new JLabel("Ordenar:");
		lbordenar.setBounds(65, 5, 66, 17);
		lbordenar.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lbordenar);
		
		JRadioButton rbnome = new JRadioButton("Nome");
		rbnome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderby = "order by alu_nome";
				povoarTable();
			}
		});
		rbnome.setBounds(21, 28, 66, 21);
		panel.add(rbnome);
		
		JRadioButton rbcodigo = new JRadioButton("Codigo");
		rbcodigo.setSelected(true);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbnome);
		bg.add(rbcodigo);
		rbcodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderby = "order by alu_codigo";
				povoarTable();
			}
		});
		rbcodigo.setBounds(111, 28, 66, 21);
		panel.add(rbcodigo);
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
			
			lstAlunos = session.createQuery(filtro + orderby).list();
			
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
					table.setRowSelectionInterval(0,0);
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
