package model;

import dao.CandidatoDAO;
import dao.QuestaoDAO;
import transporte.Candidato;
import transporte.Questao;

public class QuestaoModel {
	
		QuestaoDAO questaoDAO = new QuestaoDAO();
			
			public void insere(Questao questao) {
				
				questaoDAO.insere(questao);
				
			}
			
		public void atualiza(Questao questao) {
				
			questaoDAO.atualiza(questao);
				
			}

		public void deleta(Questao questao) {
			
			questaoDAO.deleta(questao);
			
		}

		//public DataTable consulta (String consultaSql) {
		//	
//			DataTable dados = atletadao.consultaTableModel(consultaSql);
		//	
		//	
		//	
//			return dados;
		//	
		//}

	

}
