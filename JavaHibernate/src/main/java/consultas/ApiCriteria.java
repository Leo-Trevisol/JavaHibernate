package consultas;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import bean.Aluno;
import conexao.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class ApiCriteria  {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		//Transaction transaction = null;
		try {
			
			Session session = HibernateUtil.getSession();
			
			
		//			Criteria crit = session.createCriteria(Aluno.class);
//			crit.setMaxResults(2);
//			crit.setFirstResult(1);
//			crit.addOrder(Order.asc("alun_nome"));
//			//crit.add(Expression.eq("alu_nome", "leozin")); //FILTRA 
//			crit.add(Restrictions.between("alu_codigo", 3,7));
			
			//FORMAS DE BUSCAR PELA CIDADE:
			
			//forma 1 
			//	crit.add(Expression.eq("alu_cidade", "Caxias"));
			
			
			//forma 2
			//String [] cidades = {"Caxias", "Bento"};
			//crit.add(Restrictions.in("alu_cidade", cidades)); // in = que contenha
			
			//forma 3
			//crit.add(Restrictions.like("alu_cidade", "Caxias"));
			
			
//			List <Aluno> lstAlunos = crit.list();
//			
//			int sizeList = lstAlunos.size();
//			
//			for(int i = 0; i <sizeList; i++) {
//				Aluno aluno = lstAlunos.get(i);
//				System.out.println(aluno.toString() );
//			}
//			

		} catch (Exception e) {
			System.out.println("Erro ao buscar aluno: " + e.getMessage());
		}

	}


}
