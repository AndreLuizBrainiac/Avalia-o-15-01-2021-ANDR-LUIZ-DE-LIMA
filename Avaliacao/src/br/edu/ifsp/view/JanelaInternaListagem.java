package br.edu.ifsp.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class JanelaInternaListagem extends JInternalFrame {

	private static final long serialVersionUID = -883856413738556249L;

	private JanelaPrincipal janelaPrincipal;

	private JPanel panelListagem;
	private JButton buttonListar;
	private JButton buttonFechar;
	private JTable tablePessoas;
	private DefaultTableModel modelPessoas;
	private JScrollPane scrollPessoas;

	public JanelaInternaListagem(JanelaPrincipal janelaPrincipal) {
		super("Consultar todas as pessoas", true, true, true, true);

		this.janelaPrincipal = janelaPrincipal;
		criarComponentes();
		ajustarPropriedadesJanela();
	}

	private void criarComponentes() {

		Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
				"Listagem de pessoas");
		panelListagem = new JPanel();
		panelListagem.setBorder(border);

		tablePessoas = new JTable();
		tablePessoas.setFillsViewportHeight(true);

		modelPessoas = new DefaultTableModel();
		modelPessoas.addColumn("ID");
		modelPessoas.addColumn("Nome");
		modelPessoas.addColumn("Idade");

		tablePessoas.setModel(modelPessoas);

		scrollPessoas = new JScrollPane(tablePessoas);
		scrollPessoas.setPreferredSize(new Dimension(400, 400));

		buttonListar = new JButton("Listar");

		buttonFechar = new JButton("Fechar");

		adicionarComponentes();
	}

	private void adicionarComponentes() {
		panelListagem.add(buttonListar);
		panelListagem.add(buttonFechar);
		panelListagem.add(scrollPessoas);
		add(panelListagem);
	}

	private void ajustarPropriedadesJanela() {
		setVisible(true);
		pack();
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
	}

	public void fechar() {
		dispose();
	}

	public JButton getButtonListar() {
		return buttonListar;
	}

	public void setButtonListar(JButton buttonListar) {
		this.buttonListar = buttonListar;
	}

	public JButton getButtonFechar() {
		return buttonFechar;
	}

	public void setButtonFechar(JButton buttonFechar) {
		this.buttonFechar = buttonFechar;
	}

	public DefaultTableModel getModelPessoas() {
		return modelPessoas;
	}

	public void setModelPessoas(DefaultTableModel modelPessoas) {
		this.modelPessoas = modelPessoas;
	}

}
