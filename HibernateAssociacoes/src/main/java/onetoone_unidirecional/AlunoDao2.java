package onetoone_unidirecional;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class AlunoDao2 {
	
	private final Session session;
	
	public AlunoDao2() {
		this.session = HibernateUtil.getSession();
	}
	

	public void insereAluno(Pessoa aluno) {
		
		try {
		Transaction transAluno = session.beginTransaction();
		session.save(aluno);
		transAluno.commit();
		
		}catch(HibernateException e ) {
			System.out.println("Erro ao inserir aluno: " + e.getMessage());
		}
	}

	

}
