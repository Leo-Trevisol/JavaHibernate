package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.hibernate.Transaction;

import conexao.ConexaoBD;
import jakarta.persistence.Query;
import transporte.Candidato;
import transporte.Questao;
import transporte.Questionario;

public class ConsultaDados {
	
	public List<Questionario> buscaQuestionarios(String consulta){
		
		Transaction transaction = null;
		List<Questionario> lstQuestionario = null;
    	try {
    		org.hibernate.Session session = ConexaoBD.getSessionFactory().openSession();
    		transaction = (Transaction) session.beginTransaction();
    		
    		Query query = session.createQuery(consulta);
    		lstQuestionario = ((org.hibernate.query.Query) query).list();
    		
    		
            
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
    	
    	return lstQuestionario;
		
	}	
	public List<Candidato> buscaCandidatos(String consulta){
		
		Transaction transaction = null;
		List<Candidato> lstCandidato = null;
    	try {
    		org.hibernate.Session session = ConexaoBD.getSessionFactory().openSession();
    		transaction = (Transaction) session.beginTransaction();
    		
    		Query query = session.createQuery(consulta);
    		lstCandidato = ((org.hibernate.query.Query) query).list();
    		
    		
            
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
    	
    	return lstCandidato;
		
	}
	
public List<Questao> buscaQuestoes(String consulta){
		
		Transaction transaction = null;
		List<Questao> lstQuestao = null;
    	try {
    		org.hibernate.Session session = ConexaoBD.getSessionFactory().openSession();
    		transaction = (Transaction) session.beginTransaction();
    		
    		Query query = session.createQuery(consulta);
    		lstQuestao = ((org.hibernate.query.Query) query).list();
    		
    		
            
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
    	
    	return lstQuestao;
		
	}	

}
