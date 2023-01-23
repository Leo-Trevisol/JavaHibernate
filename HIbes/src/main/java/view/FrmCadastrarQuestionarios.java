package view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


import conexao.ConexaoBD;
import dados.ConsultaDados;
import dao.QuestionarioDAO;
import jakarta.persistence.Query;
import transporte.Candidato;
import transporte.Questionario;


public class FrmCadastrarQuestionarios extends JInternalFrame {
	
	private JLabel fdTitulo, fdNome, fdTema;
	
	private JTextField txtNome, txtTema;
	
	private JButton btNovo, btGravar, btExcluir, btSair, btConsultar, btLimpar;
	
	private char oper = 'I';
	
	private JScrollPane sp;
	
	//Tabela de Dados
		private JTable tab;
		
		private DefaultTableModel dataModel;
		
		private ConsultaDados consdados = new ConsultaDados();
		
		Questionario questionario;
	
	public FrmCadastrarQuestionarios() {
		super("Cadastro de Questionarios", false, true, false, false);
		
		Container c = getContentPane();
		c.setLayout( null );
		
		Font fonte = new java.awt.Font("Comic Sans MS", 1, 20);
		Font fonteBt = new java.awt.Font("Comic Sans MS", 1, 14);

		
		fdTitulo = new JLabel("CADASTRO DE QUESTIONARIOS");
		fdTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); 
		c.add(fdTitulo);
		fdTitulo.setBounds(125,10,450,30);
		
		fdNome = new JLabel("Nome do questionario:");
		fdNome.setFont(fonte); 
		c.add(fdNome);
		fdNome.setBounds(100,80,220,30);
		
		fdTema = new JLabel("Nome do tema:");
		fdTema.setFont(fonte); 
		c.add(fdTema);
		fdTema.setBounds(100,140,220,30);
		
		
		txtNome = new JTextField();
		c.add(txtNome);
		txtNome.setBounds(320,80,220,30);
		
		txtTema = new JTextField();
		c.add(txtTema);
		txtTema.setBounds(255,140,220,30);
		
		btNovo = new JButton("Novo");
		btNovo.setFont(fonteBt);
		c.add(btNovo);
		btNovo.setBounds(50,300,90,40);
		
		btLimpar = new JButton("Limpar");
		btLimpar.setFont(fonteBt);
		c.add(btLimpar);
		btLimpar.setBounds(150,300,90,40);
		
		btConsultar = new JButton("Consultar");
		btConsultar.setFont(fonteBt);
		c.add(btConsultar);
		btConsultar.setBounds(250,300,100,40);
		
		btExcluir = new JButton("Excluir");
		btExcluir.setFont(fonteBt);
		c.add(btExcluir);
		btExcluir.setBounds(360,300,90,40);
		
		btGravar = new JButton("Gravar");
		btGravar.setFont(fonteBt);
		c.add(btGravar);
		btGravar.setBounds(460,300,90,40);
		
		btSair = new JButton("Sair");
		btSair.setFont(fonteBt);
		c.add(btSair);
		btSair.setBounds(560,300,90,40);
		
		
		
		
		setSize(700,400);
		setVisible(true);
		
	}
	
	  public void addSalvarListener(ActionListener listenForGravarButton) {
			btGravar.addActionListener(listenForGravarButton);
		}	
		public void addConsultarListener(ActionListener listenForConsultarButton) {
			btConsultar.addActionListener(listenForConsultarButton);
		}
		public void addNovoListener(ActionListener listenForNovoButton) {
			btNovo.addActionListener(listenForNovoButton);
			oper = 'I';
		}
		public void addDeletarListener(ActionListener listenForDeletarButton) {
			btExcluir.addActionListener(listenForDeletarButton);
		}
		public void addSairListener(ActionListener listenForSairButton) {
			btSair.addActionListener(listenForSairButton);
		}
		
		public void addLimparListener(ActionListener listenForLimparButton) {
			btLimpar.addActionListener(listenForLimparButton);
		}
		
		public String getNome() {
			return txtNome.getText();
		}
		
		public void setNome(String nome) {
			txtNome.setText(nome);
		}
		
		public String getTema() {
			return txtTema.getText();
		}
		
		public void setTema(String tema) {
			txtTema.setText(tema);
		}
		
		 public char getOper() {
				return oper;
			}
		
		  public void limpaTela(){
				
				txtNome.setText("");
				txtTema.setText("");
				txtNome.requestFocus();
			}
		    
			public int confirmaExclusao() {
				
				int conf = 0;
				Object[] options = {"SIM", "N�O"};
				conf = JOptionPane.showOptionDialog(null,
							"Confirma a Exclus�o?",
							"Confirma��o",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							null, 
							options,
							options[0]); 
				
				return conf;
				
			}
			
			public void exibe_tabela(DefaultTableModel dados){
				dataModel = dados;
				if(dataModel != null){
					tab = new JTable(dataModel);			
					tab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					
					sp = new JScrollPane( tab );
					this.getContentPane().add(sp);
					sp.setBounds(100,100,500,200);
					
					tab.addKeyListener(new KeyAdapter(){//Tabela "Escuta" o ESC e ï¿½ ocultada
						@Override
						public void keyPressed(KeyEvent e) {  
							if(e.getKeyCode()==27){ //tecla 27 ï¿½ o ESC
								 sp.setVisible(false);
			  				      esconde_componentes(true);					
							}
						}
					});
					
					ListSelectionModel cel = tab.getSelectionModel();
					
					cel.addListSelectionListener(new ListSelectionListener() {
					    public void valueChanged(ListSelectionEvent e) {
					        //Ignore extra messages.
					       if (e.getValueIsAdjusting()) return;
					
					       ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					       if (!lsm.isSelectionEmpty()) {
					          int selectedRow = tab.getSelectedRow();
					          int selectedCol = tab.getSelectedColumn();
					          
					  		  String id = (String) ""+tab.getValueAt(selectedRow,0);
					  		  int aux_id = Integer.parseInt(id);
							
							  
							  String nome = (String) tab.getValueAt(selectedRow, 1);
							  String tema = (String) tab.getValueAt(selectedRow, 2);
							  
							 
							  questionario = new Questionario(aux_id,nome, tema);
							  tab.clearSelection();
		  				      sp.setVisible(false);
		  				      
		  				      oper = 'A';
		  				      esconde_componentes(true);
		  				      mostraReg(questionario, tema);
		  				     
					        }
					    }
					});	
				}
			}
			
			public void esconde_componentes(boolean mostra){
				fdNome.setVisible(mostra);		
				fdTema.setVisible(mostra);
				txtNome.setVisible(mostra);
				txtTema.setVisible(mostra);
				

				btNovo.setVisible(mostra);
				btGravar.setVisible(mostra);
				btConsultar.setVisible(mostra);
				btExcluir.setVisible(mostra);
				btSair.setVisible(mostra);
				btLimpar.setVisible(mostra);
			}
			
			public void mostraReg(Questionario questionario, String nomeQuestionario){
				txtNome.setText(questionario.getNome());
				txtTema.setText(nomeQuestionario);
				
				
			}
			
			public Questionario getDadosTela(){
				String nomeQuestionario = txtTema.getText();	
				questionario.setTema(nomeQuestionario);
				return questionario;
			}
			
			
}
