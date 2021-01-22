package br.edu.ifsp.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JanelaInternaInsercao extends JInternalFrame {

	private static final long serialVersionUID = -6670909629805416761L;

	private JanelaPrincipal janelaPrincipal;

	private JPanel panelInsercao;
	private JLabel labelNome;
	private JLabel labelIdade;
	private JTextField fieldNome;
	private JTextField fieldIdade;
	private JButton buttonInserir;
	private JButton buttonFechar;

	public JanelaInternaInsercao(JanelaPrincipal janelaPrincipal) {
		super("Insercao de pessoas", true, true, true, true);

		this.janelaPrincipal = janelaPrincipal;
		criarComponentes();
		ajustarPropriedadesJanela();
	}

	private void criarComponentes() {

		Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
				"Dados da pessoa");
		panelInsercao = new JPanel();
		panelInsercao.setBorder(border);

		labelNome = new JLabel("Nome:");
		labelIdade = new JLabel("Idade:");

		fieldNome = new JTextField(10);
		fieldIdade = new JTextField(10);

		buttonInserir = new JButton("Inserir");

		buttonFechar = new JButton("Fechar");

		adicionarComponentes();
	}

	private void adicionarComponentes() {

		panelInsercao.add(labelNome);
		panelInsercao.add(fieldNome);
		panelInsercao.add(labelIdade);
		panelInsercao.add(fieldIdade);
		panelInsercao.add(buttonInserir);
		panelInsercao.add(buttonFechar);
		add(panelInsercao);
	}

	private void ajustarPropriedadesJanela() {
		setVisible(true);
		pack();
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
	}

	public void fechar() {
		dispose();
	}

	public void limparCampos(JTextField... fields) {
		for (JTextField field : fields) {
			field.setText(null);
		}
	}

	public JTextField getFieldNome() {
		return fieldNome;
	}

	public void setFieldNome(JTextField fieldNome) {
		this.fieldNome = fieldNome;
	}

	public JTextField getFieldIdade() {
		return fieldIdade;
	}

	public void setFieldIdade(JTextField fieldIdade) {
		this.fieldIdade = fieldIdade;
	}

	public JButton getButtonInserir() {
		return buttonInserir;
	}

	public void setButtonInserir(JButton buttonInserir) {
		this.buttonInserir = buttonInserir;
	}

	public JButton getButtonFechar() {
		return buttonFechar;
	}

	public void setButtonFechar(JButton buttonFechar) {
		this.buttonFechar = buttonFechar;
	}

}
