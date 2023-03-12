package onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexao.ConexaoBD;

public class Main {
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
		try {
			Session session = ConexaoBD.getSessionFactory().openSession();
			transaction = (Transaction) session.beginTransaction();
			
			Pessoa pessoa = new Pessoa();
			pessoa.setNome("leozin");
			
			List<TelefonePessoa> telefones = new ArrayList<>();
			TelefonePessoa tp = new TelefonePessoa();
			tp.setNumero("55555");
			tp.setPessoa(pessoa);
			telefones.add(tp);
			
			pessoa.setTelefonePessoa(telefones);
			
			session.save(pessoa);
			transaction.commit();
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}

}
	
}
