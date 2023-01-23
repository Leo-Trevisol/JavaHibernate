package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Transaction;

import conexao.ConexaoBD;
import dados.ConsultaDados;
import jakarta.persistence.Query;
import jakarta.transaction.SystemException;

import model.QuestionarioModel;
import transporte.Questionario;
import view.FrmCadastrarQuestionarios;

public class QuestionarioController {
	
	private Questionario questionario;
	private QuestionarioModel questionarioModel;
	private FrmCadastrarQuestionarios questionarioFrm;
	
	private ConsultaDados dados;
	
	
	public QuestionarioController(FrmCadastrarQuestionarios questionarioFrm, QuestionarioModel questionarioModel
			) {
		super();
		this.questionarioFrm = questionarioFrm;
		this.questionarioModel = questionarioModel;
		
		this.questionarioFrm.addSalvarListener(new QuestionarioSalvarListener());
		this.questionarioFrm.addConsultarListener(new QuestionarioConsultarListener());
		this.questionarioFrm.addNovoListener(new QuestionarioNovoListener());
		this.questionarioFrm.addDeletarListener(new QuestionarioDeletarListener());
		this.questionarioFrm.addLimparListener(new QuestionarioLimparListener());
		this.questionarioFrm.addSairListener(new QuestionarioSairListener());
		
	}


	public QuestionarioController() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	class QuestionarioSalvarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			String nome = "";
			String tema = "";
			char op;
			op = 'I';
			dados = new ConsultaDados();
			boolean confirmaQues = false;
			
			List<Questionario> lstQuestionario = dados.buscaQuestionarios("From Questionario");
			
			try {
				
				
				
				nome = questionarioFrm.getNome();
				tema = questionarioFrm.getTema();
				
				for(int i=0; i<lstQuestionario.size();i++) {
					if(lstQuestionario.get(i).getNome().equals(nome)) {
						JOptionPane.showMessageDialog(null, "Questionario ja cadastrado!");
						confirmaQues = true;
					}
				}
				
				if(!confirmaQues) {
					
				questionario = new Questionario();
				
				
				questionario.setNome(nome);
				questionario.setTema(tema);
				
				
				op = questionarioFrm.getOper();
				op = 'I';
				
				if(op == 'I') {
					questionarioModel.insere(questionario);
				}else {
					questionarioModel.atualiza(questionario);
				}
				
				questionarioFrm.limpaTela();
				}
			
			}catch(Exception ex ) {
				ex.printStackTrace();
			}
			
			
		}
		
		
	}
	
	class QuestionarioConsultarListener implements ActionListener {

		
		    public void actionPerformed(ActionEvent e) {
		    	
		    	 questionarioFrm.esconde_componentes(false);

		            DefaultTableModel dataModel=null;
		    	
		            Transaction transaction = null;
		    	try {
		    		org.hibernate.Session session = ConexaoBD.getSessionFactory().openSession();
		    		transaction = (Transaction) session.beginTransaction();
		    		
		    		  Query query = session.createQuery("from Questionario");
		                List<Questionario> lstQuestionario = ((org.hibernate.query.Query) query).list();

		                Vector dados = new Vector();
		                for(Questionario d : lstQuestionario){
		                    Vector<String> linha = new Vector<String>();
		                    linha.add((String) ""+ d.getId());
		                    linha.add((String) "" + d.getNome());
		                    linha.add((String) "" + d.getTema());

		                    dados.add(linha);

		                }
		                //Vector para os t�tulos das colunas
		                Vector<String> titulos = new Vector<String>();
		                titulos.add("ID");
		                titulos.add("Nome");
		                titulos.add("Tema");


		                dataModel = new DefaultTableModel(dados, titulos);

		    		
		          
		    	}
		    	catch(Exception x) {
		    		if (transaction != null) {
		                try {
							transaction.rollback();
						} catch (IllegalStateException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            }
		            x.printStackTrace();
		    	}
		    	  questionarioFrm.exibe_tabela(dataModel);
				
			}
	           

	            	
		}
	
	class QuestionarioNovoListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			questionarioFrm.limpaTela();
			
		}
		
	}
	
	class QuestionarioDeletarListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			questionario = questionarioFrm.getDadosTela(); 
			
			try {
				if(questionarioFrm.confirmaExclusao() ==0) {
					questionarioModel.deleta(questionario);
					questionarioFrm.limpaTela();
					
				}
			}catch(Exception ex ) {
				ex.printStackTrace();
			}
			
		}
		
	}
	
	class QuestionarioLimparListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			questionarioFrm.limpaTela();
		}
		
	}
	
	class QuestionarioSairListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
		
		
	}
		


}
