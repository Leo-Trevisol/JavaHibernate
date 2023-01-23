package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Transaction;

import conexao.ConexaoBD;
import controller.CandidatoController.CandidatoConsultarListener;
import controller.CandidatoController.CandidatoDeletarListener;
import controller.CandidatoController.CandidatoLimparListener;
import controller.CandidatoController.CandidatoNovoListener;
import controller.CandidatoController.CandidatoSairListener;
import controller.CandidatoController.CandidatoSalvarListener;
import dados.ConsultaDados;
import jakarta.persistence.Query;
import model.CandidatoModel;
import model.ResponderQuestionarioModel;
import transporte.Candidato;
import transporte.Questao;
import transporte.Questionario;
import view.FrmCadastrarCandidatos;
import view.FrmResponderQuestionario;

public class ResponderQuestionarioController {
	
	private Candidato candidato;
	private Questionario questionario;
	private ResponderQuestionarioModel responderQuestionarioModel;
	private FrmResponderQuestionario frmResponderQuestionario;
	private CandidatoModel candidatoModel;
	
	private int index = 0;
	
	private int acertos = 0;
	
	private int NumPergunta = 1;
	
	private List<Questao> lstQuestaoAtt;
	
	private Candidato candAtt;
	
	public ResponderQuestionarioController(FrmResponderQuestionario frmResponderQuestionario,ResponderQuestionarioModel responderQuestionarioModel,
			CandidatoModel candidatoModel
			) {
		super();
		this.frmResponderQuestionario = frmResponderQuestionario;
		this.responderQuestionarioModel = responderQuestionarioModel;
		this.candidatoModel = candidatoModel;
		
		this.frmResponderQuestionario.addComecarListener(new ResponderComecarListener());
		this.frmResponderQuestionario.addProximaListener(new ResponderProximaListener());
		this.frmResponderQuestionario.addFinalizarListener(new ResponderFinalizarListener());
		this.frmResponderQuestionario.addVoltarListener(new ResponderVoltarListener());
		
	
		
	}

	public ResponderQuestionarioController() {
		super();
		//TODO Auto-generated constructor stub
	}
	
	class ResponderComecarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			  lstQuestaoAtt = new ArrayList<Questao>();
			
			index = 0;
			if(!getLstQuestaoAtt().isEmpty()) {
				getLstQuestaoAtt().removeAll(lstQuestaoAtt);
			}
			acertos = 0;
			NumPergunta = 1;
			
			
			
			frmResponderQuestionario.setNome1("Candidato: " + frmResponderQuestionario.getComboNome());
			frmResponderQuestionario.setTema1("Questionario: " + frmResponderQuestionario.getComboTema());

			boolean confirmaCand = false;
			
			ConsultaDados dados = new ConsultaDados();
			
			  List<Questao> lstQuestao = dados.buscaQuestoes("From Questao");
			  
			
			  
			  List<Questionario> lstQuestionario = dados.buscaQuestionarios("From Questionario");
			  
			  List<Candidato> lstCandidato = dados.buscaCandidatos("From Candidato");
			  
			  for(Candidato cand: lstCandidato) {
				  if(cand.getNome().equals(frmResponderQuestionario.getComboNome())) {
					  setCand(cand);
					  if(!cand.getTema().equals(frmResponderQuestionario.getComboTema())) {
						  confirmaCand = true;
					  }
					 
					  
				  }
			  }
			  
			  
			  if(confirmaCand) {
				  JOptionPane.showMessageDialog(null,"O candidato nao tem acesso a este questionario");
				  
			  }else {
			  
			  
			  for(Questionario quest : lstQuestionario) {
				  if(quest.getNome().equals(frmResponderQuestionario.getComboTema())) {
					  frmResponderQuestionario.setTema2("Tema: " + quest.getTema());
					 for(Questao questao : lstQuestao) {
						 if(questao.getNumPergunta() == quest.getId()) {
							 lstQuestaoAtt.add(questao);
						 }
					 }
				  }
			  }
			  
			  if(lstQuestaoAtt.isEmpty()) {
				  JOptionPane.showMessageDialog(null, "Nao ha questoes para esse questionario");
			  }else {
				  
		            frmResponderQuestionario.esconde_componentes(false);

			  

 	 		frmResponderQuestionario.setPergunta((String) ""+ NumPergunta + "- " + lstQuestaoAtt.get(getIndex()).getPergunta().toUpperCase());
            frmResponderQuestionario.setAlterA((String) "A- "  + lstQuestaoAtt.get(getIndex()).getAlterA());
            frmResponderQuestionario.setAlterB((String) "B- " + lstQuestaoAtt.get(getIndex()).getAlterB());
            frmResponderQuestionario.setAlterC((String) "C- " + lstQuestaoAtt.get(getIndex()).getAlterC());
            frmResponderQuestionario.setAlterD((String) "D- " + lstQuestaoAtt.get(getIndex()).getAlterD());
            
          
			  }
			  }
	                    
		}
		
	}
	
	class ResponderProximaListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			if(retornaResposta() == 0) {
				JOptionPane.showInternalMessageDialog(null, "Nenhuma alternativa selecionada!");
			}else {
				
				NumPergunta++;
			
			
			ConsultaDados dados = new ConsultaDados();
			
			boolean verifica = false;
			
		
		
				
			List<Questao> lstQuestao = dados.buscaQuestoes("From Questao");
			
			 List<Questao> lstQuestaoAtt = new ArrayList<Questao>();
			  
			  List<Questionario> lstQuestionario = dados.buscaQuestionarios("From Questionario");
			  
			  for(Questionario quest : lstQuestionario) {
				  if(quest.getNome().equals(frmResponderQuestionario.getComboTema())) {
					 for(Questao questao : lstQuestao) {
						 if(questao.getNumPergunta() == quest.getId()) {
							 lstQuestaoAtt.add(questao);
						 }
					 }
				  }
			  }
			  
			
			 index++;
			 if(retornaResposta() == lstQuestaoAtt.get((getIndex())-1).getResposta() ) {
				 
				 acertos++;
				 
			 }

				
			  
			  if(lstQuestaoAtt.size()<=index) {
				frmResponderQuestionario.getButtonProxima().setVisible(false);
				frmResponderQuestionario.getButtonFinalizar().setVisible(true);
			  }else {
				  
			  
			  
			
		frmResponderQuestionario.setPergunta((String) ""+ NumPergunta + "- " + lstQuestaoAtt.get(getIndex()).getPergunta().toUpperCase());
	    frmResponderQuestionario.setAlterA((String) "A- "  + lstQuestaoAtt.get(getIndex()).getAlterA());
	    frmResponderQuestionario.setAlterB((String) "B- " + lstQuestaoAtt.get(getIndex()).getAlterB());
	    frmResponderQuestionario.setAlterC((String) "C- " + lstQuestaoAtt.get(getIndex()).getAlterC());
	    frmResponderQuestionario.setAlterD((String) "D- " + lstQuestaoAtt.get(getIndex()).getAlterD());

	  
	    
	   
	                
	                  
			
			  }
			  
			}
			  
			
		}
		
	}
	
	class ResponderFinalizarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			double conta = 0;
			
			conta = 10 / getLstQuestaoAtt().size();
			
			double nota = conta * acertos;
			
			
			
			
			getCand().setAcertos(acertos);
			getCand().setNota((float) nota);
			
			if(acertos == getLstQuestaoAtt().size()) {
				nota =10;
			}
			
			
			candidatoModel.atualiza(getCand());
			
			frmResponderQuestionario.setFim("Voce acertou: "+ acertos + " de " + getLstQuestaoAtt().size() + " questoes");
			frmResponderQuestionario.setNota("Nota: " + nota + " / 10");
			
			
			frmResponderQuestionario.esconde_componentes2();
			
			frmResponderQuestionario.getButtonFinalizar().setVisible(false);
			frmResponderQuestionario.getButtonVoltar().setVisible(true);
		
			
			
		}
		
	}
	
	class ResponderVoltarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			frmResponderQuestionario.esconde_componentes3();
			
			
		}
		
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
	public int retornaResposta() {
		
		if(frmResponderQuestionario.getBtAlterA().isSelected()) {
			return 1;
		}
		
		if(frmResponderQuestionario.getBtAlterB().isSelected()) {
			return 2;
		}
		
		if(frmResponderQuestionario.getBtAlterC().isSelected()) {
			return 3;
		}
		
		if(frmResponderQuestionario.getBtAlterD().isSelected()) {
			return 4;
		}
		
		
		return 0;
	}

	public List<Questao> getLstQuestaoAtt() {
		return lstQuestaoAtt;
	}

	public void setLstQuestaoAtt(List<Questao> lstQuestaoAtt) {
		this.lstQuestaoAtt = lstQuestaoAtt;
	}
	
	public Candidato getCand() {
		return candAtt;
	}
	
	public void setCand(Candidato cand) {
		candAtt = cand;
	}
	
	

}
