package br.edu.ifsp.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JanelaInternaUpdate extends JInternalFrame {

	private static final long serialVersionUID = -5686567830038607987L;
	
	private JanelaPrincipal janelaPrincipal;
	
	private JPanel panelConsulta;
	private JLabel labelID;
	private JTextField fieldID;
	private JLabel labelNome;
	private JLabel labelIdade;
	private JTextField fieldNome;
	private JTextField fieldIdade;
	private JButton buttonUpdate;
	private JButton buttonFechar;
	
	public JanelaInternaUpdate(JanelaPrincipal janelaPrincipal) {
        super("Atualizacao de pessoas", true, true, true, true);
       
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

//		fieldNome.setEditable(false);
//		fieldIdade.setEditable(false);

		buttonUpdate = new JButton("Editar");
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
		panelConsulta.add(buttonUpdate);
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

	public JButton getButtonUpdate() {
		return buttonUpdate;
	}

	public void setButtonUpdate(JButton buttonConsultar) {
		this.buttonUpdate = buttonConsultar;
	}

	public JButton getButtonFechar() {
		return buttonFechar;
	}

	public void setButtonFechar(JButton buttonFechar) {
		this.buttonFechar = buttonFechar;
	}	
}
