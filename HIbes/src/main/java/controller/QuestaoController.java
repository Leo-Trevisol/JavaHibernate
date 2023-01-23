package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.hibernate.Transaction;

import conexao.ConexaoBD;
import controller.CandidatoController.CandidatoConsultarListener;
import controller.CandidatoController.CandidatoDeletarListener;
import controller.CandidatoController.CandidatoLimparListener;
import controller.CandidatoController.CandidatoNovoListener;
import controller.CandidatoController.CandidatoSairListener;
import controller.CandidatoController.CandidatoSalvarListener;
import jakarta.persistence.Query;
import model.CandidatoModel;
import model.QuestaoModel;
import transporte.Candidato;
import transporte.Questao;
import view.FrmCadastrarCandidatos;
import view.FrmCadastrarQuestoes;

public class QuestaoController {
	
	private Questao questao;
	private QuestaoModel questaoModel;
	private FrmCadastrarQuestoes questaoFrm;
	
	
	public QuestaoController(FrmCadastrarQuestoes questaoFrm, QuestaoModel questaoModel
			) {
		super();
		this.questaoFrm = questaoFrm;
		this.questaoModel = questaoModel;
		
		this.questaoFrm.addSalvarListener(new QuestaoSalvarListener());
		this.questaoFrm.addConsultarListener(new QuestaoConsultarListener());
		this.questaoFrm.addNovoListener(new QuestaoNovoListener());
		this.questaoFrm.addDeletarListener(new QuestaoDeletarListener());
		this.questaoFrm.addLimparListener(new QuestaoLimparListener());
		this.questaoFrm.addSairListener(new QuestaoSairListener());
		
	}


	public QuestaoController() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	class QuestaoSalvarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
		//	int idPergunta = 0;
			int numPergunta = 0;
			String pergunta = "";
			String alterA = "";
			String alterB = "";
			String alterC = "";
			String alterD = "";
			int resposta = 0;

			char op;
			op = 'I';
			
			try {
				
				//idPergunta = questaoFrm.getId();
				numPergunta = questaoFrm.getNumPergunta();
				pergunta = questaoFrm.getPergunta();
				alterA = questaoFrm.getAlterA();
				alterB = questaoFrm.getAlterB();
				alterC = questaoFrm.getAlterC();
				alterD = questaoFrm.getAlterD();
				resposta = questaoFrm.getResposta();
				
				
				questao = new Questao();
				
			//	questao.setId(idPergunta);
				questao.setNumPergunta(numPergunta);
				questao.setPergunta(pergunta);
				questao.setAlterA(alterA);
				questao.setAlterB(alterB);
				questao.setAlterC(alterC);
				questao.setAlterD(alterD);
				questao.setResposta(resposta);


				
				op = questaoFrm.getOper();
				op = 'I';
				
				if(op == 'I') {
					questaoModel.insere(questao);
				}else {
					questaoModel.atualiza(questao);
				}
				
				questaoFrm.limpaTela();
			
			}catch(Exception ex ) {
				ex.printStackTrace();
			}
			
			
		}
		
		
	}
	
	class QuestaoConsultarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			 questaoFrm.esconde_componentes(false);

	            DefaultTableModel dataModel=null;
	    	
	            Transaction transaction = null;
	    	try {
	    		org.hibernate.Session session = ConexaoBD.getSessionFactory().openSession();
	    		transaction = (Transaction) session.beginTransaction();
	    		
	    		  Query query = session.createQuery("from Questao");
	                List<Questao> lstQuestao = ((org.hibernate.query.Query) query).list();

	                Vector dados = new Vector();
	                for(Questao questao : lstQuestao){
	                    Vector<String> linha = new Vector<String>();
	                    linha.add((String) ""+ questao.getId());
	                    linha.add((String) "" + questao.getNumPergunta());
	                    linha.add((String) "" + questao.getPergunta());
	                    linha.add((String) "" + questao.getAlterA());
	                    linha.add((String) "" + questao.getAlterB());
	                    linha.add((String) "" + questao.getAlterC());
	                    linha.add((String) "" + questao.getAlterD());
	                    linha.add((String) "" + questao.getResposta());
	                    

	                    dados.add(linha);

	                }
	                //Vector para os t�tulos das colunas
	                Vector<String> titulos = new Vector<String>();
	                titulos.add("ID");
	                titulos.add("N questionario");
	                titulos.add("Pergunta");
	                titulos.add("Alter A");
	                titulos.add("Alter B");
	                titulos.add("Alter C");
	                titulos.add("Alter D");
	                titulos.add("Resposta");


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
	    	questaoFrm.exibe_tabela(dataModel);
			
        
			 
		}
			
	}
	
	class QuestaoNovoListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			questaoFrm.limpaTela();
		
	}
	}
	
	class QuestaoDeletarListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			
	Questao questao = questaoFrm.getDadosTela();
			
			try {
				if(questaoFrm.confirmaExclusao() ==0) {
					
					questaoModel.deleta(questao);
					questaoFrm.limpaTela();
					
				}
			}catch(Exception ex ) {
				ex.printStackTrace();
			}
			
		}
	}
	
	class QuestaoLimparListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			questaoFrm.limpaTela();
		}
		
	}
	
	class QuestaoSairListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
		
	}
		

}
