package daoGenerico;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexao.HibernateUtil;

public class DaoGenerico<Object> implements InterfaceDaoGenerico {
	
	private Session session;
	private Transaction transaction= null;
	private Object obj;
	
	public DaoGenerico(Object obj) {
		this.session = HibernateUtil.getSession();
		this.obj = obj;
	}

	@Override
	public void insere() {
		try {
		transaction = session.beginTransaction();
		session.save(obj);
		transaction.commit();
	}catch(Exception e) {
		System.out.println("Deu erro ao inserir:"  + obj);
		transaction.rollback();
	}
	}

	@Override
	public void excluir() {
		try {
		transaction = session.beginTransaction();
		session.delete(obj);
		transaction.commit();
	}catch(Exception e) {
		System.out.println("Deu erro ao excluir:"  + e.getMessage() + "");
		transaction.rollback();
	}
		
	}

	@Override
	public void atualizar() {
		try {
			transaction = session.beginTransaction();
			session.update(obj);
			transaction.commit();
		}catch(Exception e) {
			System.out.println("Deu erro ao excluir:"  + e.getMessage() + "");
			transaction.rollback();
		}
		
	}
	
	@Override
	public void saveOrUpdate() {
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(obj);
			transaction.commit();
		}catch(Exception e) {
			System.out.println("Deu erro ao excluir:"  + e.getMessage() + "");
			transaction.rollback();
		}
		
	}

	@Override
	public List todos(String classe) {
		List lista = session.createQuery("from " + classe).list();
		return lista;
	}

	
	
	

}
