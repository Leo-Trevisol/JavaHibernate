package daoGenerico;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Aluno;
import conexao.ConexaoBD;
import conexao.HibernateUtil;

public class ListarAlunosDaoGenerico {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		//Transaction transaction = null;
		try {
			
			Aluno aluno = new Aluno();
			DaoGenerico alunodao = new DaoGenerico(aluno);
			
			List<Aluno> lstAlunos = new ArrayList<>();
			
			lstAlunos = alunodao.todos("Aluno");
			
			int sizeList = lstAlunos.size();
			
			for(int i = 0; i <sizeList; i++) {
				Aluno aluno1 = lstAlunos.get(i);
				System.out.println(aluno1.toString() );
			}
			

		} catch (Exception e) {
			System.out.println("Erro ao buscar aluno: " + e.getMessage());
		}

	}

}
