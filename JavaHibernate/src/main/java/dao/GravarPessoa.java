package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;


import bean.Pessoa;
import conexao.ConexaoBD;

public class GravarPessoa {
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
    	try {
    		Session session = ConexaoBD.getSessionFactory().openSession();
    		transaction = (Transaction) session.beginTransaction();
    		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setPes_nome("Leozin");
		pessoa.setPes_codigo(1);
		pessoa.setPes_email("Leozin@gmail.com");
		pessoa.setPes_sexo('m');
		pessoa.setPes_idade(15);
		pessoa.setPes_fone("55555");
		pessoa.setPes_cpf("02444134010");
		
		 session.persist(pessoa);
            
          
		 transaction.commit();
		
		session.clear();
		
	}catch(Exception e) {
		System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
	}
	
}

}
