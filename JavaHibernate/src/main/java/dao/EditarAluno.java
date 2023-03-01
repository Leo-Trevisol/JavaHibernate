package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Aluno;
import conexao.ConexaoBD;

public class EditarAluno {

	public static void main(String[] args) {
		
		try {
    		
		Aluno aluno = new Aluno();
		aluno.setAlu_codigo(1);
		aluno.setAlu_nome("Leo");
		aluno.setAlu_fone("54008080");
		aluno.setAlu_cidade("Caxias do sul");
		aluno.setAlu_curso("HibernateParte2");
		
		AlunoDao2 alunodao = new AlunoDao2();
		alunodao.atualizaAluno(aluno);
		
	}catch(Exception e) {
		System.out.println("Erro ao editar aluno: " + e.getMessage());
	}
	
}

}
