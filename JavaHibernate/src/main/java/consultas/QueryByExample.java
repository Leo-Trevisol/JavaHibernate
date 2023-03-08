package consultas;

import org.hibernate.Session;

import bean.Aluno;
import conexao.HibernateUtil;

public class QueryByExample {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		//Transaction transaction = null;
		try {
			
			Session session = HibernateUtil.getSession();
			
//			Aluno aluno = new Aluno();
//			aluno.setAlu_cidade("Caxias");
			
			
		//Criteria crit = session.createCriteria(Aluno.class);
		//crit.add(Example.create(aluno));

			
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
