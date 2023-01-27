package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Aluno;
import conexao.ConexaoBD;

public class ListarAlunos {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Transaction transaction = null;
		try {
			Session session = ConexaoBD.getSessionFactory().openSession();
			transaction = (Transaction) session.beginTransaction();
			
			List<Aluno> lstAlunos = new ArrayList<>();
			lstAlunos = session.createQuery("From Aluno").list();
			
			int sizeList = lstAlunos.size();
			
			for(int i = 0; i <sizeList; i++) {
				Aluno aluno = lstAlunos.get(i);
				System.out.println(aluno.toString() );
			}
			
			

			session.clear();

		} catch (Exception e) {
			System.out.println("Erro ao buscar aluno: " + e.getMessage());
		}

	}

}