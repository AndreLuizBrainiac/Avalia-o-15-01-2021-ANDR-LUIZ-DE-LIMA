package br.edu.ifsp.br.connect;

public class ConexaoInsert {

	public static void inserir(String nome, int idade) {

		if (Conectar.isConnected()) {
			try {
				String query = String.format("INSERT INTO PESSOA(NOME, IDADE)VALUES('%s', %d)", nome, idade);
				Conectar.statement.executeUpdate(query);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else {
			System.out.println("operacao negada");
		}

	}

}
