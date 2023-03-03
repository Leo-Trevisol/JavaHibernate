package daoGenerico;

import bean.Aluno;
import dao.AlunoDao2;

public class GravaAlunoDaoGenerico {
	
	public static void main(String[] args) {
		try {
			Aluno aluno = new Aluno();
		//	aluno.setAlu_codigo(2);
			aluno.setAlu_nome("Dao generico");
			aluno.setAlu_fone("2525252525");
			aluno.setAlu_cidade("cidade do aluno dao generico");
			aluno.setAlu_curso("curso do aluno generico");
			
			DaoGenerico dao = new DaoGenerico(aluno);
			
			dao.insere();
			
			
		}catch(Exception e) {
			System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
		}
		
	}

}
