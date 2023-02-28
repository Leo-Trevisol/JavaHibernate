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

		Transaction transaction = null;
		try {
		//	Session session = ConexaoBD.getSessionFactory().openSession();
			
			
			Session session = HibernateUtil.getSession();
			
			transaction = (Transaction) session.beginTransaction();
			
			Aluno aluno = new Aluno();
			aluno.setAlu_codigo(2);
			 session.remove(aluno);
			 transaction.commit();
			
			session.clear();

		} catch (Exception e) {
			System.out.println("Erro ao excluir aluno: " + e.getMessage());
		}

	}

}