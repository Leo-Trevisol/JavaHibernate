package view;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import transporte.Candidato;
import transporte.Questao;
import transporte.Questionario;

public class FrmCadastrarQuestoes extends JInternalFrame {
	
	private JLabel fdTitulo, fdNumQuestionario, fdPergunta, fdAlterA, fdAlterB, fdAlterC, fdAlterD, fdResposta, fdId;
	
	private JTextField txtNumQuestionario, txtAlterA, txtAlterB, txtAlterC, txtAlterD, txtResposta, txtId;
	
	private JTextField txtPergunta;
	
	private JButton btNovo, btGravar, btExcluir, btSair, btConsultar, btLimpar; 
	
	private char oper = 'I';
	
	private JScrollPane sp;
	
	//Tabela de Dados
		private JTable tab;
		
		private DefaultTableModel dataModel;
		
		Questao questao;
	
	public FrmCadastrarQuestoes(){
		super("Cadastro de Questoes", false, true, false, false);
		
		Container c = getContentPane();
		c.setLayout( null );
		
		Font fonte = new java.awt.Font("Comic Sans MS", 1, 20);
		Font fonteBt = new java.awt.Font("Comic Sans MS", 1, 14);
		
		
		
		fdTitulo = new JLabel("CADASTRO DE QUESTOES");
		fdTitulo.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); 
		c.add(fdTitulo);
		fdTitulo.setBounds(160,10,450,30);
		
		fdNumQuestionario = new JLabel("Id do questionario:");
		fdNumQuestionario.setFont(fonteBt); 
		c.add(fdNumQuestionario);
		fdNumQuestionario.setBounds(30,70,220,30);
		
		fdPergunta = new JLabel("Pergunta:");
		fdPergunta.setFont(fonteBt); 
		c.add(fdPergunta);
		fdPergunta.setBounds(230,70,220,30);
		
		fdAlterA = new JLabel("Alternativa A:");
		fdAlterA.setFont(fonteBt); 
		c.add(fdAlterA);
		fdAlterA.setBounds(30,110,220,30);
		
		fdAlterB = new JLabel("Alternativa B:");
		fdAlterB.setFont(fonteBt); 
		c.add(fdAlterB);
		fdAlterB.setBounds(30,150,220,30);
		
		fdAlterC = new JLabel("Alternativa C:");
		fdAlterC.setFont(fonteBt); 
		c.add(fdAlterC);
		fdAlterC.setBounds(30,190,220,30);
		
		fdAlterD = new JLabel("Alternativa D:");
		fdAlterD.setFont(fonteBt); 
		c.add(fdAlterD);
		fdAlterD.setBounds(30,230,220,30);
		
		fdResposta = new JLabel("Resposta:");
		fdResposta.setFont(fonteBt); 
		c.add(fdResposta);
		fdResposta.setBounds(30,270,220,30);
		

		
		txtNumQuestionario = new JTextField();
		c.add(txtNumQuestionario);
		txtNumQuestionario.setBounds(165,80,50,20);
		
		txtPergunta = new JTextField();
		c.add(txtPergunta);
		txtPergunta.setBounds(300,80,350,20);
		
		txtAlterA = new JTextField();
		c.add(txtAlterA);
		txtAlterA.setBounds(135,120,400,20);
		
		txtAlterB = new JTextField();
		c.add(txtAlterB);
		txtAlterB.setBounds(135,155,400,20);
		
		txtAlterC = new JTextField();
		c.add(txtAlterC);
		txtAlterC.setBounds(135,195,400,20);
		
		txtAlterD = new JTextField();
		c.add(txtAlterD);
		txtAlterD.setBounds(135,235,400,20);
		
		txtResposta = new JTextField();
		c.add(txtResposta);
		txtResposta.setBounds(135,280,50,20);
		
		btNovo = new JButton("Novo");
		btNovo.setFont(fonteBt);
		c.add(btNovo);
		btNovo.setBounds(50,320,80,30);
		
		btLimpar = new JButton("Limpar");
		btLimpar.setFont(fonteBt);
		c.add(btLimpar);
		btLimpar.setBounds(150,320,80,30);
		
		btConsultar = new JButton("Consultar");
		btConsultar.setFont(fonteBt);
		c.add(btConsultar);
		btConsultar.setBounds(250,320, 100,30);
		
		btExcluir = new JButton("Excluir");
		btExcluir.setFont(fonteBt);
		c.add(btExcluir);
		btExcluir.setBounds(360,320,90,30);
		
		btGravar = new JButton("Gravar");
		btGravar.setFont(fonteBt);
		c.add(btGravar);
		btGravar.setBounds(460,320,90,30);
		
		btSair = new JButton("Sair");
		btSair.setFont(fonteBt);
		c.add(btSair);
		btSair.setBounds(560,320,90,30);
		
		

		setSize(700,400);
		setVisible(true);
	}
	
	 public char getOper() {
			return oper;
		}
	
	public int getNumPergunta() {
		return Integer.parseInt(txtNumQuestionario.getText());
	}
	
	public void setNumPergunta(int numero) {
		
		txtNumQuestionario.setText(Integer.toString(numero));
		
	}

	public String getPergunta() {
		return txtPergunta.getText();
	}
	
	public void setNumPergunta(String texto) {
		
		txtPergunta.setText(texto);
		
	}
	
	public String getAlterA() {
		return txtAlterA.getText();
	}
	
	public void setAlterA(String texto) {
		
		txtAlterA.setText(texto);
		
	}
	
	public String getAlterB() {
		return txtAlterB.getText();
	}
	
	public void setAlterB(String texto) {
		
		txtAlterB.setText(texto);
		
	}
	
	public String getAlterC() {
		return txtAlterC.getText();
	}
	
	public void setAlterC(String texto) {
		
		txtAlterC.setText(texto);
		
	}
	
	public String getAlterD() {
		return txtAlterD.getText();
	}
	
	public void setAlterD(String texto) {
		
		txtAlterD.setText(texto);
		
	}
	
	public int getResposta() {
		return Integer.parseInt(txtResposta.getText());
	}
	
	public void setResposta(int numero) {
		
		txtResposta.setText(Integer.toString(numero));
		
	}
	
	public int getId() {
		return Integer.parseInt(txtId.getText());
	}
	
public void setId(int id) {
		
		txtId.setText(Integer.toString(id));
		
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
		
		  public void limpaTela(){
				
				txtNumQuestionario.setText("");
				txtPergunta.setText("");
				txtAlterA.setText("");
				txtAlterB.setText("");
				txtAlterC.setText("");
				txtAlterD.setText("");
				txtResposta.setText("");
				txtNumQuestionario.requestFocus();
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
			
			public void esconde_componentes(boolean mostra){
				fdTitulo.setVisible(mostra);		
				fdPergunta.setVisible(mostra);
				fdNumQuestionario.setVisible(mostra);
				fdAlterA.setVisible(mostra);
				
				txtPergunta.setVisible(mostra);		
				txtNumQuestionario.setVisible(mostra);
				txtAlterA.setVisible(mostra);
				txtAlterB.setVisible(mostra);
				txtAlterC.setVisible(mostra);		
				txtAlterD.setVisible(mostra);
				txtResposta.setVisible(mostra);

				fdAlterB.setVisible(mostra);
				fdAlterC.setVisible(mostra);
				fdAlterD.setVisible(mostra);
				fdResposta.setVisible(mostra);
				btNovo.setVisible(mostra);
				btLimpar.setVisible(mostra);
				btGravar.setVisible(mostra);
				btLimpar.setVisible(mostra);
				btExcluir.setVisible(mostra);
				btSair.setVisible(mostra);
				btConsultar.setVisible(mostra);
			}
			
			public void exibe_tabela(DefaultTableModel dados){
				dataModel = dados;
				if(dataModel != null){
					tab = new JTable(dataModel);			
					tab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					
					sp = new JScrollPane( tab );
					this.getContentPane().add(sp);
					sp.setBounds(50,50,600,200);
					
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
					  		  
					  		String num_pergunta = (String) ""+tab.getValueAt(selectedRow,1);
					  		  int aux_Numpergunta = Integer.parseInt(num_pergunta);
							
					  		 String pergunta = (String) tab.getValueAt(selectedRow, 2);
							  
							  String alterA = (String) tab.getValueAt(selectedRow, 3);
							  String alterB = (String) tab.getValueAt(selectedRow,4);
							  
							  String alterC = (String) tab.getValueAt(selectedRow, 5);
							  String alterD = (String) tab.getValueAt(selectedRow, 6);
							  
							  String resposta = (String) ""+tab.getValueAt(selectedRow,7);
					  		  int aux_resposta = Integer.parseInt(resposta);
							  
							  questao = new Questao(aux_id,aux_Numpergunta, pergunta, alterA, alterB, alterC, alterD, aux_resposta);
							  tab.clearSelection();
		  				      sp.setVisible(false);
		  				      
		  				      oper = 'A';
		  				      esconde_componentes(true);
		  				      mostraReg(questao);
		  				     
					        }
					    }
					});	
				}
			}
			
			public void mostraReg(Questao questao){
				
				txtNumQuestionario.setText( String.valueOf(questao.getNumPergunta()));
				txtPergunta.setText( questao.getPergunta());
				txtAlterA.setText(questao.getAlterA());
				txtAlterB.setText(questao.getAlterB());
				txtAlterC.setText(questao.getAlterC());
				txtAlterD.setText(questao.getAlterD());
				txtResposta.setText(String.valueOf(questao.getResposta()));

				
			}
			
			public Questao getDadosTela(){
				String NomeQuestao = txtPergunta.getText();	
				questao.setPergunta(NomeQuestao);
				return questao;
			}
}
