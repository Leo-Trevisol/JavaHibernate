package anotacoes_associacoes.manytomany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import conexao.ConexaoBD;

public class consulta_query_encapsulada {
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
		try {
			Session session = ConexaoBD.getSessionFactory().openSession();
			transaction = (Transaction) session.beginTransaction();
			
			Query listagem_query = session.getNamedQuery("pessoa");
			listagem_query.setParameter("nome", "leozin");
			
			List<Pessoa> lstPessoas = listagem_query.list();
			
			int tam = lstPessoas.size();
			
			System.out.println(tam + " REgistros");
			
			for(int i = 0; i <tam; i++) {
				System.out.println(lstPessoas.get(i));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
