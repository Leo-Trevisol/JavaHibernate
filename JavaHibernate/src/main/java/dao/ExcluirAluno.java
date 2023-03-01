package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Aluno;
import conexao.ConexaoBD;
import conexao.HibernateUtil;

public class ExcluirAluno {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			Aluno aluno = new Aluno();
			aluno.setAlu_codigo(3);
			
			AlunoDao2 alunodao = new AlunoDao2();
			alunodao.excluirAluno(aluno);

		} catch (Exception e) {
			System.out.println("Erro ao excluir aluno: " + e.getMessage());
		}

	}

}