package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.excecao.IDinvalidoException;
import br.edu.ifsp.excecao.IdadeInvalidaException;
import br.edu.ifsp.excecao.NomeInvalidoException;
import br.edu.ifsp.model.Pessoa;
import br.edu.ifsp.view.JanelaInternaUpdate;
import br.edu.ifsp.view.JanelaMessage;

public class UpdateController implements ActionListener {

	private JanelaInternaUpdate tela;
	private Pessoa modelo;

	public UpdateController(JanelaInternaUpdate jp) {

		modelo = new Pessoa();
		this.tela = jp;
		this.tela.getButtonUpdate().addActionListener(this);
		this.tela.getButtonFechar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.tela.getButtonUpdate()) {

			int flag = 0;
			try {

				validaFieldNome();
				validaFieldIdade();
				validaFieldID();

			} catch (NomeInvalidoException ex) {
				
				flag++;
				JanelaMessage.InvalidNameMessage(ex.getMessage());

			} catch (IdadeInvalidaException ex) {
				
				flag++;
				JanelaMessage.InvalidAgeMessage(ex.getMessage());

			} catch (IDinvalidoException ex) {

				flag++;
				JanelaMessage.invalidIDMessage(ex.getMessage());
			}

			if (flag == 0) {
				PessoaDAO dao = new PessoaDAO();
				dao.editarPessoaPorId(modelo.getId(), modelo.getNome(), modelo.getIdade());
				JanelaMessage.insertSuccessful("Pessoa atualizada com Sucesso");
				this.tela.limparCampos(tela.getFieldID(),tela.getFieldNome(), tela.getFieldIdade());
			}

		} else {

			this.tela.fechar();
		}

	}

	private void validaFieldID() throws IDinvalidoException {

		String id = this.tela.getFieldID().getText().trim();

		if (this.tela.getFieldID().getText().trim().isEmpty()) {

			throw new IDinvalidoException("Necessario preencher o campo id");

		} else if (!isInteger(id)) {

			throw new IDinvalidoException("Somente com numeros inteiros");

		} else if (!id.matches("[0-9]*")) {

			throw new IDinvalidoException("Somente com numeros iteiros e positivos");

		} else {

			ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
			PessoaDAO dao = new PessoaDAO();
			listaPessoas = dao.consultarTodos();

			int flag = 0;
			for (Pessoa pessoa : listaPessoas) {

				if (pessoa.getId() == Integer.parseInt(id)) {
					flag++;
					break;
				}
			}

			if (flag > 0) {

				modelo.setId(Integer.parseInt(id));
			}else {
				throw new IDinvalidoException("ID nao encontrado na base");
			}
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
