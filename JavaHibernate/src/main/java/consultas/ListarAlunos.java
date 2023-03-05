package consultas;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Aluno;
import conexao.ConexaoBD;
import conexao.HibernateUtil;
import dao.AlunoDao2;

public class ListarAlunos {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		//Transaction transaction = null;
		try {
			
			AlunoDao2 alunodao = new AlunoDao2();
			
			List<Aluno> lstAlunos = new ArrayList<>();
			
			lstAlunos = alunodao.todosAlunos();
			
			int sizeList = lstAlunos.size();
			
			for(int i = 0; i <sizeList; i++) {
				Aluno aluno = lstAlunos.get(i);
				System.out.println(aluno.toString() );
			}
			

		} catch (Exception e) {
			System.out.println("Erro ao buscar aluno: " + e.getMessage());
		}

	}

}
