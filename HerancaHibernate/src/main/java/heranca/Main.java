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
    		pess.setNomeusuario("usuario 3");
    		pess.setSenhausuario("111111");
    		
    		session.persist(pess);
    		
    		
    		PessoaJuridica pessj = new PessoaJuridica();
    		
    		pessj.setNome("leo Juridico");
    		pessj.setEmail("leo Juridico");
    		pessj.setTelefone("51515151");
    		pessj.setEmpresa("Empresa do leo");
    		pessj.setCargo("Gerente");
    		
    		
    		session.persist(pessj);
    		transaction.commit();
    		
    		
    	}catch(Exception e) {
    		System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
    	}
	}

}
