package br.edu.ifsp.br.connect;

public class ConexaoRemove {

	public static void removerPessoa(String nome) {

		if (Conectar.isConnected()) {
			try {
				String query = String.format("DELETE FROM PESSOA WHERE NOME = '%s'", nome);
				Conectar.statement.executeUpdate(query);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else {
			System.out.println("operacao negada");
		}

	}
}
