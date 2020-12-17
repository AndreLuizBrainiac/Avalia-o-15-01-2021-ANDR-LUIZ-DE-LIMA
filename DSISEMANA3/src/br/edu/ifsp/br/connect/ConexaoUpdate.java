package br.edu.ifsp.br.connect;

public class ConexaoUpdate {

	public static void editarNome(String novoNome, String antigoNome) {

		if (Conectar.isConnected()) {
			try {
				String query = String.format("UPDATE PESSOA SET NOME = '%s' WHERE NOME = '%s'", novoNome, antigoNome);
				Conectar.statement.executeUpdate(query);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else {
			System.out.println("operacao negada");
		}

	}

	public static void editarIdade(String nome, int idade) {

		if (Conectar.isConnected()) {
			try {
				String query = String.format("UPDATE PESSOA SET IDADE = %d WHERE NOME = '%s'", idade, nome);
				Conectar.statement.executeUpdate(query);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else {
			System.out.println("operacao negada");
		}

	}
}
