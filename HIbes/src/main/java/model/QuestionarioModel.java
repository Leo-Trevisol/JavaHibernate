package model;

import java.util.List;


import dao.QuestionarioDAO;

import transporte.Questionario;

public class QuestionarioModel {
	
	QuestionarioDAO questionarioDAO = new QuestionarioDAO();
	
	public void insere(Questionario questionario) {
		
		questionarioDAO.insere(questionario);
		
	}
	
public void atualiza(Questionario questionario) {
		
		questionarioDAO.atualiza(questionario);
		
	}

public void deleta(Questionario questionario) {
	
	questionarioDAO.deleta(questionario);
	
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
