package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Aluno;
import conexao.HibernateUtil;

public class AlunoDao2 implements InterfaceAlunoDao{
	
	private final Session session;
	
	public AlunoDao2() {
		this.session = HibernateUtil.getSession();
	}
	

	@Override
	public void insereAluno(Aluno aluno) {
		Transaction transAluno = session.beginTransaction();
		session.save(aluno);
		transAluno.commit();
	}

	@Override
	public void excluirAluno(Aluno aluno) {
		
		Transaction transAluno = session.beginTransaction();
		session.remove(aluno);
		transAluno.commit();
	}

	@Override
	public void atualizaAluno(Aluno aluno) {
		Transaction transAluno = session.beginTransaction();
		session.update(aluno);
		transAluno.commit();
	}

}
