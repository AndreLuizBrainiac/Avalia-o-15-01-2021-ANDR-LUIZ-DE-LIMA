package br.edu.ifsp.principal;

import br.edu.ifsp.br.connect.Conectar;
import br.edu.ifsp.br.connect.ConexaoInsert;
import br.edu.ifsp.br.connect.ConexaoRemove;
import br.edu.ifsp.br.connect.ConexaoSelect;
import br.edu.ifsp.br.connect.ConexaoUpdate;

public class Main {
	
	public static void main(String[] args) {
		
		Conectar.conectar();
		ConexaoInsert.inserir("andre", 25);
		ConexaoInsert.inserir("jao", 10);
		ConexaoInsert.inserir("lusga", 17);
		ConexaoSelect.selectAll("PESSOA");
		ConexaoUpdate.editarIdade("jao", 30);
		ConexaoUpdate.editarNome("xurato", "andre");
		ConexaoRemove.removerPessoa("xurato");
	}
}
