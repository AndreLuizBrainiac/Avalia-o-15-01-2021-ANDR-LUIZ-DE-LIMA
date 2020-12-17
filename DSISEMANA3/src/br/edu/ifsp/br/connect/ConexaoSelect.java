package br.edu.ifsp.br.connect;

import java.sql.ResultSet;

public class ConexaoSelect {

	private static ResultSet rs;

	public static void selectAll(String tabela) {

		if (Conectar.isConnected()) {
			try {
				String query = String.format("SELECT * FROM %s ORDER BY NOME", tabela);
				rs = Conectar.statement.executeQuery(query);
				Conectar.statement = Conectar.connection.createStatement();
				System.out.println("ID | NOME  | IDADE | \n");
				while (rs.next()) {

					System.out.println(String.format("%s  | %s | %s | \n", rs.getString("ID"), rs.getString("NOME"),
							rs.getString("IDADE")));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		} else {
			System.out.println("operacao negada");
		}

	}
}
