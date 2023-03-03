package daoGenerico;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Aluno;
import conexao.ConexaoBD;
import conexao.HibernateUtil;

public class ExcluirAlunoDaoGenerico {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			Aluno aluno = new Aluno();
			aluno.setAlu_codigo(1);
			
			DaoGenerico alunodao = new DaoGenerico(aluno);
			alunodao.excluir();

		} catch (Exception e) {
			System.out.println("Erro ao excluir aluno: " + e.getMessage());
		}

	}

}