package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.model.Pessoa;
import br.edu.ifsp.view.JanelaInternaListagem;

public class ListagemController implements ActionListener {

	private JanelaInternaListagem tela;

	public ListagemController(JanelaInternaListagem jp) {

		this.tela = jp;
		this.tela.getButtonListar().addActionListener(this);
		this.tela.getButtonFechar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	

		if (e.getSource() == this.tela.getButtonListar()) {

			listar();

		} else {
			
			tela.fechar();
		}
	}

	private void listar() {

		tela.getModelPessoas().setNumRows(0);
		PessoaDAO dao = new PessoaDAO();
		ArrayList<Pessoa> listaPessoas = dao.consultarTodos();
		for (int i = 0; i < listaPessoas.size(); i++) {
			tela.getModelPessoas().addRow(listaPessoas.get(i).toArray());
		}
	}
}
