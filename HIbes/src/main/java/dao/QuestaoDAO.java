package dao;

import org.hibernate.Transaction;

import conexao.ConexaoBD;

public class QuestaoDAO {

	public void insere(Object objeto) {
		Transaction transaction = null;
    	try {
    		org.hibernate.Session session = ConexaoBD.getSessionFactory().openSession();
    		transaction = (Transaction) session.beginTransaction();
    		
            session.persist(objeto);
            
            transaction.commit();
    	}
    	catch(Exception e) {
    		if (transaction != null) {
                try {
					transaction.rollback();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            e.printStackTrace();
    	}
    	
		
	}
	
	public void deleta(Object objeto) {
		Transaction transaction = null;
    	try {
    		org.hibernate.Session session = ConexaoBD.getSessionFactory().openSession();
    		transaction = (Transaction) session.beginTransaction();
    		
            session.remove(objeto);
            
            transaction.commit();
    	}
    	catch(Exception e) {
    		if (transaction != null) {
                try {
					transaction.rollback();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            e.printStackTrace();
    	}
	}
	
	public void atualiza(Object objeto) {
		Transaction transaction = null;
    	try {
    		org.hibernate.Session session = ConexaoBD.getSessionFactory().openSession();
    		transaction = (Transaction) session.beginTransaction();
    		
            session.merge(objeto);
            
            transaction.commit();
    	}
    	catch(Exception e) {
    		if (transaction != null) {
                try {
					transaction.rollback();
				} catch (IllegalStateException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
            e.printStackTrace();
    	}
	}
}
