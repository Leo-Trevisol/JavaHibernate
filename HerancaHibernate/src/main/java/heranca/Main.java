package heranca;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexao.ConexaoBD;

public class Main {
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
    	try {
    		Session session = ConexaoBD.getSessionFactory().openSession();
    		transaction = (Transaction) session.beginTransaction();
    		
    		PessoaFisica pess = new PessoaFisica();
    		
    		pess.setNome("leozin");
    		pess.setEmail("leozin@gmail.com");
    		pess.setTelefone("54 984081674");
    		pess.setRg("555555");
    		pess.setCpf("222222");
    		pess.setNascimento(Calendar.getInstance());
    		pess.setNomeusuario("leoUsuario");
    		pess.setSenhausuario("leo123");
    		
    		session.persist(pess);
    		transaction.commit();
    	
    		
    		PessoaJuridica pessj = new PessoaJuridica();
    		
    		pessj.setNome("leozin");
    		pessj.setEmail("leozin@gmail.com");
    		pessj.setTelefone("54 984081674");
    		pessj.setEmpresa("NL");
    		pessj.setCargo("adm");
    		
    		session.persist(pessj);
    		transaction.commit();
    		
    		
    	
    		
    	}catch(Exception e) {
    		System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
    	}
	}

}
