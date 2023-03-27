package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Pessoa2;
import conexao.ConexaoBD;

public class GravarPessoa2 {
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
    	try {
    		Session session = ConexaoBD.getSessionFactory().openSession();
    		transaction = (Transaction) session.beginTransaction();
    		
    		Pessoa2 pess = new Pessoa2();
    		
    		pess.setNome("leozin");
    		pess.setFone("00002020");
    		pess.setCidade("Caxas");
    		pess.setSalario(200.00);
    		pess.setDataCadastro(new Date());
    		pess.setDataNascimento(new Date());
    		
    		List<String> telefones = new ArrayList<>();
    		
    		telefones.add("15151515");
    		telefones.add("262626200");
    		telefones.add("787878");
    		
    		pess.setTelefones(telefones);
    		
    		session.persist(pess);
    		transaction.commit();
    		

    		
    	}catch(Exception e) {
    		System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
    	}
	}

}
