package consultas;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import bean.Aluno;
import conexao.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;

public class ApiCriteria  {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		//Transaction transaction = null;
		try {
			
			Session session = HibernateUtil.getSession();
			
			
		//	Criteria crit = session.createCriteria(Aluno.class);
			
			
			List <Aluno> lstAlunos = crit.list();
			
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
