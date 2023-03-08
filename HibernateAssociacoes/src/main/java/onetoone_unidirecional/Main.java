package onetoone_unidirecional;



public class Main {
	
	public static void main(String[] args) {
		try {
			Pessoa pes = new Pessoa();
		//	aluno.setAlu_codigo(2);
			
			
			onetoone_unidirecional.AlunoDao2 alunodao = new AlunoDao2();
			
			alunodao.insereAluno(pes);
			
			
		}catch(Exception e) {
			System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
		}
		
	}

}
