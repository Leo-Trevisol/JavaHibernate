package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.hibernate.Transaction;

import conexao.ConexaoBD;
import controller.QuestionarioController.QuestionarioConsultarListener;
import controller.QuestionarioController.QuestionarioDeletarListener;
import controller.QuestionarioController.QuestionarioLimparListener;
import controller.QuestionarioController.QuestionarioNovoListener;
import controller.QuestionarioController.QuestionarioSairListener;
import controller.QuestionarioController.QuestionarioSalvarListener;
import jakarta.persistence.Query;
import jakarta.transaction.SystemException;
import model.CandidatoModel;
import model.QuestionarioModel;
import transporte.Candidato;
import transporte.Questionario;
import view.FrmCadastrarCandidatos;
import view.FrmCadastrarQuestionarios;

public class CandidatoController {
	
	private Candidato candidato;
	private CandidatoModel candidatoModel;
	private FrmCadastrarCandidatos candidadosFrm;
	
	
	public CandidatoController(FrmCadastrarCandidatos candidadosFrm, CandidatoModel candidatoModel
			) {
		super();
		this.candidadosFrm = candidadosFrm;
		this.candidatoModel = candidatoModel;
		
		this.candidadosFrm.addSalvarListener(new CandidatoSalvarListener());
		this.candidadosFrm.addConsultarListener(new CandidatoConsultarListener());
		this.candidadosFrm.addNovoListener(new CandidatoNovoListener());
		this.candidadosFrm.addDeletarListener(new CandidatoDeletarListener());
		this.candidadosFrm.addLimparListener(new CandidatoLimparListener());
		this.candidadosFrm.addSairListener(new CandidatoSairListener());
		
	}


	public CandidatoController() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	class CandidatoSalvarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			String nome = "";
			String tema = "";
			char op;
			op = 'I';
			
			try {
				
				nome = candidadosFrm.getNome();
				tema = candidadosFrm.getTema();
				
				
				candidato = new Candidato();
				
				
				candidato.setNome(nome);
				candidato.setTema(tema);
				
				
				
				op = candidadosFrm.getOper();
				//op = 'I';
				
				if(op == 'I') {
					candidatoModel.insere(candidato);
				}else {
					candidatoModel.atualiza(candidato);
				}
				
				candidadosFrm.limpaTela();
			
			}catch(Exception ex ) {
				ex.printStackTrace();
			}
			
			
		}
		
		
	}
	
	class CandidatoConsultarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			
		    	 candidadosFrm.esconde_componentes(false);

		            DefaultTableModel dataModel=null;
		    	
		            Transaction transaction = null;
		    	try {
		    		org.hibernate.Session session = ConexaoBD.getSessionFactory().openSession();
		    		transaction = (Transaction) session.beginTransaction();
		    		
		    		  Query query = session.createQuery("from Candidato");
		                List<Candidato> lstCandidato = ((org.hibernate.query.Query) query).list();

		                Vector dados = new Vector();
		                for(Candidato d : lstCandidato){
		                    Vector<String> linha = new Vector<String>();
		                    linha.add((String) ""+ d.getId());
		                    linha.add((String) "" + d.getNome());
		                    linha.add((String) "" + d.getTema());
		                    linha.add((String) "" + d.getAcertos());
		                    linha.add((String) "" + d.getNota());
		                    

		                    dados.add(linha);

		                }
		                //Vector para os t�tulos das colunas
		                Vector<String> titulos = new Vector<String>();
		                titulos.add("ID");
		                titulos.add("Nome");
		                titulos.add("Tema");
		                titulos.add("Acertos");
		                titulos.add("Nota");


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
		    	candidadosFrm.exibe_tabela(dataModel);
				
	           
				 
			 }
		}
	
	class CandidatoNovoListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			candidadosFrm.limpaTela();
			
		}
		
	}
	
	class CandidatoDeletarListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			candidato = candidadosFrm.getDadosTela();
			
			
			try {
				if(candidadosFrm.confirmaExclusao() ==0) {
					
					candidatoModel.deleta(candidato);
					candidadosFrm.limpaTela();
					
				}
			}catch(Exception ex ) {
				ex.printStackTrace();
			}
			
		}
		
	}
	
	class CandidatoLimparListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			candidadosFrm.limpaTela();
		}
		
	}
	
	class CandidatoSairListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
		
		
	}
		

}
