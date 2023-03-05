package consultas;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import bean.Aluno;
import conexao.HibernateUtil;
import dao.AlunoDao2;

public class HqlQueryParametros {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		//Transaction transaction = null;
		try {
			
			Session session = HibernateUtil.getSession();
//			Query query = session.createQuery("from Aluno where alu_nome = :nome");
//			query.setParameter("nome", "Leo");
			
			Query query = session.getNamedQuery("findAluno");
			 query.setParameter("name","Leo");   
			
			List <Aluno> lstAlunos = query.list();
			
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
