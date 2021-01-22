package br.edu.ifsp.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JanelaInternaRemocao extends JInternalFrame {

	private static final long serialVersionUID = 4830278680105387692L;

	private JanelaPrincipal janelaPrincipal;

	private JPanel panelRemocao;
	private JLabel labelID;
	private JTextField fieldID;
	private JButton buttonRemover;
	private JButton buttonFechar;

	public JanelaInternaRemocao(JanelaPrincipal janelaPrincipal) {
		super("Remocao de pessoas", true, true, true, true);

		this.janelaPrincipal = janelaPrincipal;
		criarComponentes();
		ajustarPropriedadesJanela();
	}

	private void criarComponentes() {

		Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "ID da pessoa");
		panelRemocao = new JPanel();
		panelRemocao.setBorder(border);

		labelID = new JLabel("ID:");

		fieldID = new JTextField(10);
//		fieldID.setEditable(false);

		buttonRemover = new JButton("Remover");
		buttonFechar = new JButton("Fechar");

		adicionarComponentes();
	}

	private void adicionarComponentes() {
		panelRemocao.add(labelID);
		panelRemocao.add(fieldID);
		panelRemocao.add(buttonRemover);
		panelRemocao.add(buttonFechar);
		add(panelRemocao);
	}

	private void ajustarPropriedadesJanela() {
		setVisible(true);
		pack();
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
	}

	public void limparCampos(JTextField... fields) {
		for (JTextField field : fields) {
			field.setText(null);
		}
	}

	public void fechar() {
		dispose();
	}

	public JTextField getFieldID() {
		return fieldID;
	}

	public void setFieldID(JTextField fieldID) {
		this.fieldID = fieldID;
	}

	public JButton getButtonRemover() {
		return buttonRemover;
	}

	public void setButtonRemover(JButton buttonRemover) {
		this.buttonRemover = buttonRemover;
	}

	public JButton getButtonFechar() {
		return buttonFechar;
	}

	public void setButtonFechar(JButton buttonFechar) {
		this.buttonFechar = buttonFechar;
	}

}
