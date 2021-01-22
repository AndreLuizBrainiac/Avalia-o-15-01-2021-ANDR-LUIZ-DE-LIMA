package br.edu.ifsp.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static Conexao conexao = null;
	private Connection dataSource = null;
	private String url = "jdbc:mysql://localhost:3306/dsi?autoReconnect=true&useSSL=false";
	private String usuario = "root";
	private String senha = "madara666";
	
	private Conexao() {
		
		try {			
			this.dataSource = DriverManager.getConnection(url, usuario, senha);
		}
		catch (SQLException e) {
			System.out.println("Erro ao comunicar com o banco de dados");
			e.printStackTrace();
		}

	}
		
	public Connection getConexao() {
		return dataSource;
	}
	
	public static Conexao getInstance() {
		
		if(conexao == null) {
			conexao =  new Conexao();
		}
		return conexao;
		
	}

}
