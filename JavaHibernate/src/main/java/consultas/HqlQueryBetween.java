package consultas;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import bean.Aluno;
import conexao.HibernateUtil;

public class HqlQueryBetween {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		//Transaction transaction = null;
		try {
			
			Session session = HibernateUtil.getSession();
			Query query = session.createQuery("from Aluno where alu_codigo between :dtaini and :dtafim");
			query.setParameter("dtaini", 1);
			query.setParameter("dtafim", 20);
			
			
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
