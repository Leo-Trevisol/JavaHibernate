package model;

import dao.CandidatoDAO;
import dao.QuestionarioDAO;
import transporte.Candidato;
import transporte.Questionario;

public class CandidatoModel {
	
CandidatoDAO candidatoDAO = new CandidatoDAO();
	
	public void insere(Candidato candidato) {
		
		candidatoDAO.insere(candidato);
		
	}
	
public void atualiza(Candidato candidato) {
		
			candidatoDAO.atualiza(candidato);
		
	}

public void deleta(Candidato candidato) {
	
	candidatoDAO.deleta(candidato);
	
}

//public DataTable consulta (String consultaSql) {
//	
//	DataTable dados = atletadao.consultaTableModel(consultaSql);
//	
//	
//	
//	return dados;
//	
//}



}
