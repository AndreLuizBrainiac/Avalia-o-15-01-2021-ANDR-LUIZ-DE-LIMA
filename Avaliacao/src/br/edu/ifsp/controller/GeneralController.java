package br.edu.ifsp.controller;

import br.edu.ifsp.view.JanelaInternaConsulta;
import br.edu.ifsp.view.JanelaInternaInsercao;
import br.edu.ifsp.view.JanelaInternaListagem;
import br.edu.ifsp.view.JanelaInternaRemocao;
import br.edu.ifsp.view.JanelaInternaUpdate;

public class GeneralController {

	private InsertController insertController;
	private ListagemController listagemController;
	private ConsultaController consultaController;
	private UpdateController updateController;
	private RemocaoController remocaoController;
	

	public void acessInsertController(JanelaInternaInsercao jp) {
		insertController = new InsertController(jp);
	}

	public void acessaListagemController(JanelaInternaListagem jp) {
		listagemController = new ListagemController(jp);
	}
	
	public void acessaConsultaController(JanelaInternaConsulta jp) {
		consultaController = new ConsultaController(jp);
	}
	
	public void acessaUpdateController(JanelaInternaUpdate jp) {
		updateController = new UpdateController(jp);
	}
	
	public void acessaRemocaoController(JanelaInternaRemocao jp) {
		remocaoController = new RemocaoController(jp);
	}
	
	
}
