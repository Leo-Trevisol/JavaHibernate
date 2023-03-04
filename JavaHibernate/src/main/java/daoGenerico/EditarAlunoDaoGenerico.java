package daoGenerico;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Aluno;
import conexao.ConexaoBD;

public class EditarAlunoDaoGenerico {

	public static void main(String[] args) {
		
		try {
    		
		Aluno aluno = new Aluno();
		aluno.setAlu_codigo(7);
		aluno.setAlu_nome("Leo");
		aluno.setAlu_fone("54008080");
		aluno.setAlu_cidade("Caxias do sul");
		aluno.setAlu_curso("HibernateParte2");
		
		DaoGenerico alunodao = new DaoGenerico(aluno);
		alunodao.atualizar();
		
	}catch(Exception e) {
		System.out.println("Erro ao editar aluno: " + e.getMessage());
	}
	
}

}
