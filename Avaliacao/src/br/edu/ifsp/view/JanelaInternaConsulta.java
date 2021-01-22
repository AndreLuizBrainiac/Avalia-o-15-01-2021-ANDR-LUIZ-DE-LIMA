package br.edu.ifsp.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JanelaInternaConsulta extends JInternalFrame {

	private static final long serialVersionUID = -8901523677476376247L;

	private JanelaPrincipal janelaPrincipal;

	private JPanel panelConsulta;
	private JLabel labelID;
	private JTextField fieldID;
	private JLabel labelNome;
	private JLabel labelIdade;
	private JTextField fieldNome;
	private JTextField fieldIdade;
	private JButton buttonConsultar;
	private JButton buttonFechar;

	public JanelaInternaConsulta(JanelaPrincipal janelaPrincipal) {
		super("Insercao de pessoas", true, true, true, true);

		this.janelaPrincipal = janelaPrincipal;
		criarComponentes();
		ajustarPropriedadesJanela();
	}

	private void criarComponentes() {

		Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
				"Dados da pessoa");
		panelConsulta = new JPanel();
		panelConsulta.setBorder(border);

		labelID = new JLabel("ID:");
		labelNome = new JLabel("Nome:");
		labelIdade = new JLabel("Idade:");

		fieldID = new JTextField(10);
		fieldNome = new JTextField(10);
		fieldIdade = new JTextField(10);

		fieldNome.setEditable(false);
		fieldIdade.setEditable(false);

		buttonConsultar = new JButton("Consultar");
		buttonFechar = new JButton("Fechar");

		adicionarComponentes();
	}

	private void adicionarComponentes() {

		panelConsulta.add(labelID);
		panelConsulta.add(fieldID);
		panelConsulta.add(labelNome);
		panelConsulta.add(fieldNome);
		panelConsulta.add(labelIdade);
		panelConsulta.add(fieldIdade);
		panelConsulta.add(buttonConsultar);
		panelConsulta.add(buttonFechar);
		add(panelConsulta);
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

	public JTextField getFieldID() {
		return fieldID;
	}

	public void setFieldID(JTextField fieldID) {
		this.fieldID = fieldID;
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

	public JButton getButtonConsultar() {
		return buttonConsultar;
	}

	public void setButtonConsultar(JButton buttonConsultar) {
		this.buttonConsultar = buttonConsultar;
	}

	public JButton getButtonFechar() {
		return buttonFechar;
	}

	public void setButtonFechar(JButton buttonFechar) {
		this.buttonFechar = buttonFechar;
	}
}
