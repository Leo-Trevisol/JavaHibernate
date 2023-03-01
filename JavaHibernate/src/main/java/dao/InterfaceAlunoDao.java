package dao;

import java.util.List;

import bean.Aluno;

public interface InterfaceAlunoDao {
	
	public void insereAluno(Aluno aluno);
	public void excluirAluno(Aluno aluno);
	public void atualizaAluno(Aluno aluno);
	public List todosAlunos();
	
	
	

}
