package br.edu.ifsp.br.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conectar {

	protected static Connection connection;
	protected static Statement statement;
	private static final String servidor = "jdbc:mysql://localhost:3306/dsisemana3?autoReconnect=true&useSSL=false";
	private static final String usuario = "root";
	private static final String senha = "madara666";
	private static final String driver = "com.mysql.jdbc.Driver";

	public static void conectar() {

		if (connection != null)
			return;

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(servidor, usuario, senha);
			statement = connection.createStatement();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static boolean isConnected() {
		return connection != null;
	}
}
