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
		session.remove(obj);
		transaction.commit();
	}catch(Exception e) {
		System.out.println("Deu erro ao excluir:"  + e.getMessage() + "");
		transaction.rollback();
	}
		
	}

	@Override
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List todos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
