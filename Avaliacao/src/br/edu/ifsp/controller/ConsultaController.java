package br.edu.ifsp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import br.edu.ifsp.dao.PessoaDAO;
import br.edu.ifsp.excecao.IDinvalidoException;
import br.edu.ifsp.model.Pessoa;
import br.edu.ifsp.view.JanelaInternaConsulta;
import br.edu.ifsp.view.JanelaMessage;

public class ConsultaController implements ActionListener {

	private JanelaInternaConsulta tela;

	public ConsultaController(JanelaInternaConsulta jp) {

		this.tela = jp;
		this.tela.getButtonConsultar().addActionListener(this);
		this.tela.getButtonFechar().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == tela.getButtonConsultar()) {

			try {

				validaFieldID();

			} catch (IDinvalidoException ex) {

				JanelaMessage.invalidIDMessage(ex.getMessage());
				tela.limparCampos(tela.getFieldID());
			}

			tela.limparCampos(tela.getFieldID());

		} else {

			tela.fechar();
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
			Pessoa p;

			int flag = 0;
			for (Pessoa pessoa : listaPessoas) {

				if (pessoa.getId() == Integer.parseInt(id)) {
					flag++;
					break;
				}
			}

			if (flag > 0) {

				p = dao.consultarPessoaPorId(Integer.parseInt(id));
				JanelaMessage.idQuerySuccess("Consulta realizada com sucessul");
				tela.getFieldID().setText(Integer.toString(p.getId()));
				tela.getFieldNome().setText(p.getNome());
				tela.getFieldIdade().setText(Integer.toString(p.getIdade()));

			} else {

				throw new IDinvalidoException("ID nao encontrado na base");
			}
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
