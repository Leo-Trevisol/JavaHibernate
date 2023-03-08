package consultas;

import org.hibernate.Session;

import conexao.HibernateUtil;

public class QueryByExample {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		//Transaction transaction = null;
		try {
			
			Session session = HibernateUtil.getSession();
			
			
		//			Criteria crit = session.createCriteria(Aluno.class);

			
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
