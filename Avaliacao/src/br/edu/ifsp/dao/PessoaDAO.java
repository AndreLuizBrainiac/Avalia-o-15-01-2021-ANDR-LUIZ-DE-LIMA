package br.edu.ifsp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifsp.connect.Conexao;
import br.edu.ifsp.model.Pessoa;
import br.edu.ifsp.view.JanelaMessage;

public class PessoaDAO {

	public Conexao con;

	public void salvarPessoa(Pessoa pessoa) {

		try {

			this.con = Conexao.getInstance();

			String sql = "INSERT INTO PESSOA(NOME, IDADE)VALUES(?, ?)";
			PreparedStatement pstm = con.getConexao().prepareStatement(sql);
			pstm.setInt(2, pessoa.getIdade());
			pstm.setString(1, pessoa.getNome());
			pstm.executeUpdate();

		} catch (SQLException e) {

			JanelaMessage.sqlError(e.getMessage());
			e.printStackTrace();
		}
	}

	public ArrayList<Pessoa> consultarTodos() {

		ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();

		try {

			this.con = Conexao.getInstance();

			String sql = "SELECT * FROM pessoa";

			PreparedStatement pstm = con.getConexao().prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {

				Pessoa p = new Pessoa();
				p.setId(rs.getInt("ID"));
				p.setNome(rs.getString("NOME"));
				p.setIdade(rs.getInt("IDADE"));

				listaPessoas.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaPessoas;
	}

	public Pessoa consultarPessoaPorId(int id) {

		Pessoa p = new Pessoa();

		try {

			this.con = Conexao.getInstance();

			String sql = "SELECT * FROM pessoa where ID = ?";

			PreparedStatement pstm = con.getConexao().prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {

				p.setId(rs.getInt("ID"));
				p.setNome(rs.getString("NOME"));
				p.setIdade(rs.getInt("IDADE"));
			}

		} catch (SQLException e) {

			JanelaMessage.sqlError(e.getMessage());
			e.printStackTrace();
		}

		return p;
	}

	public void editarPessoaPorId(int id, String nome, int idade) {
		
		System.out.println(id);
		System.out.println(nome);
		System.out.println(idade);
		try {

			this.con = Conexao.getInstance();

			String sql = "update pessoa set nome = ?, idade = ? where id = ?";
						

			PreparedStatement pstm = con.getConexao().prepareStatement(sql);
			pstm.setString(1, nome);
			pstm.setInt(2, idade);
			pstm.setInt(3, id);
			pstm.executeUpdate();

		} catch (SQLException e) {
			
			JanelaMessage.sqlError(e.getMessage());
			e.printStackTrace();
		}
	}

	public void removerPessoaPorId(int id) {

		try {

			this.con = Conexao.getInstance();

			String sql = "DELETE FROM PESSOA WHERE ID = ?";
			PreparedStatement pstm = con.getConexao().prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();

		} catch (SQLException e) {

			JanelaMessage.sqlError(e.getMessage());
			e.printStackTrace();

		}
	}
}
