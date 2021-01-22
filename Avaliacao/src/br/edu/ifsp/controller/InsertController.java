package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.excecao.IdadeInvalidaException;
import br.edu.ifsp.excecao.NomeInvalidoException;
import br.edu.ifsp.model.Pessoa;
import br.edu.ifsp.view.JanelaInternaInsercao;
import br.edu.ifsp.view.JanelaMessage;

public class InsertController implements ActionListener {

	private JanelaInternaInsercao tela;
	private Pessoa modelo;

	public InsertController(JanelaInternaInsercao jp) {
		this.tela = jp;
		modelo = new Pessoa();
		this.tela.getButtonInserir().addActionListener(this);
		this.tela.getButtonFechar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.tela.getButtonInserir()) {
			
			try {

				validaFieldNome();
				validaFieldIdade();

			} catch (NomeInvalidoException ex) {

				JanelaMessage.InvalidNameMessage(ex.getMessage());

			} catch (IdadeInvalidaException ex) {

				JanelaMessage.InvalidAgeMessage(ex.getMessage());
			}

			if (modelo.getNome() != null && modelo.getIdade() > 0) {
				PessoaDAO dao = new PessoaDAO();
				dao.salvarPessoa(modelo);
				JanelaMessage.insertSuccessful("Pessoa inserida com Sucesso");
				this.tela.limparCampos(tela.getFieldNome(), tela.getFieldIdade());
			}

			

		} else {

			this.tela.fechar();
		}
	}

	private void validaFieldNome() throws NomeInvalidoException {

		String nome = this.tela.getFieldNome().getText().trim();

		if (this.tela.getFieldNome().getText().trim().isEmpty()) {

			throw new NomeInvalidoException("Necessario preencher o campo nome");

		} else if (!nome.matches("^(([a-zA-Z ]|[é])*)$")) {

			throw new NomeInvalidoException("Necessario preencher nome somente com letras");

		} else {
			
			modelo.setNome(nome);
		}
	}

	private void validaFieldIdade() throws IdadeInvalidaException {

		String idade = this.tela.getFieldIdade().getText().trim();

		if (this.tela.getFieldIdade().getText().trim().isEmpty()) {

			throw new IdadeInvalidaException("Necessario preencher o campo idade");

		} else if (!isInteger(idade)) {

			throw new IdadeInvalidaException("Somente com numeros inteiros");

		} else if (!idade.matches("[0-9]*")) {

			throw new IdadeInvalidaException("Somente com numeros iteiros e positivos");

		} else {

			modelo.setIdade(Integer.parseInt(idade));
		}
	}

	private boolean isInteger(String text) {

		text = text.trim();
		try {
			Integer.parseInt(text);
			return true;
		} catch (Throwable ex) {
			return false;
		}
	}
}
