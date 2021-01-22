package br.edu.ifsp.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import br.edu.ifsp.controller.GeneralController;

public class JanelaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = -4702960031393227602L;

	private JDesktopPane desktop;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItemInsercao;
	private JMenuItem menuItemListagem;
	private JMenuItem menuItemConsulta;
	private JMenuItem menuItemUpdate;
	private JMenuItem menuItemRemocao;
	private JMenuItem menuItemSair;

	private JanelaInternaInsercao janelaInsercao;
	private JanelaInternaListagem janelaListagem;
	private JanelaInternaConsulta janelaConsulta;
	private JanelaInternaUpdate janelaUpdate;
	private JanelaInternaRemocao janelaRemocao;

	private GeneralController generalController;

	public JanelaPrincipal(String titulo) {
		super(titulo);
		generalController = new GeneralController();
		criarComponentes();
		ajustarPropriedadesJanela();
	}

	private void criarComponentes() {

		menuBar = new JMenuBar();
		menu = new JMenu("Arquivo");

		menuItemInsercao = new JMenuItem("Insercao de pessoas");
		menuItemInsercao.setMnemonic('I');
		menuItemInsercao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));

		menuItemListagem = new JMenuItem("Listagem de pessoas");
		menuItemListagem.setMnemonic('L');
		menuItemListagem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK));

		menuItemConsulta = new JMenuItem("Pesquisa unica");
		menuItemConsulta.setMnemonic('P');
		menuItemConsulta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));

		menuItemUpdate = new JMenuItem("Atualizar dados");
		menuItemUpdate.setMnemonic('U');
		menuItemUpdate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK));

		menuItemRemocao = new JMenuItem("Remocao");
		menuItemRemocao.setMnemonic('R');
		menuItemRemocao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));

		menuItemSair = new JMenuItem("Sair");
		menuItemSair.setMnemonic('S');
		menuItemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));

		menuItemInsercao.addActionListener(this);
		menuItemListagem.addActionListener(this);
		menuItemConsulta.addActionListener(this);
		menuItemUpdate.addActionListener(this);
		menuItemRemocao.addActionListener(this);
		menuItemSair.addActionListener(this);

		menu.add(menuItemInsercao);
		menu.add(menuItemListagem);
		menu.add(menuItemConsulta);
		menu.add(menuItemUpdate);
		menu.add(menuItemRemocao);
		menu.addSeparator();
		menu.add(menuItemSair);

		menuBar.add(menu);

		setJMenuBar(menuBar);

		desktop = new JDesktopPane();
		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

		add(desktop);
	}

	private void ajustarPropriedadesJanela() {
		setVisible(true);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void encerrarAplicacao() {
		System.exit(0);
	}

	private void configurarEAdicionarJanela(JInternalFrame janelaInterna) {

		janelaInterna.addInternalFrameListener(new OuvinteJanelaInterna());
		desktop.add(janelaInterna);
		desktop.moveToFront(janelaInterna);
		janelaInterna.requestFocusInWindow();

		try {
			janelaInterna.setSelected(true);
		} catch (PropertyVetoException erro) {
			erro.printStackTrace();
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == menuItemInsercao) {

			janelaInsercao = new JanelaInternaInsercao(this);
			configurarEAdicionarJanela(janelaInsercao);
			menuItemInsercao.setEnabled(false);
			generalController.acessInsertController(janelaInsercao);

		} else if (e.getSource() == menuItemListagem) {

			janelaListagem = new JanelaInternaListagem(this);
			configurarEAdicionarJanela(janelaListagem);
			menuItemListagem.setEnabled(false);
			generalController.acessaListagemController(janelaListagem);

		} else if (e.getSource() == menuItemConsulta) {

			janelaConsulta = new JanelaInternaConsulta(this);
			configurarEAdicionarJanela(janelaConsulta);
			menuItemConsulta.setEnabled(false);
			generalController.acessaConsultaController(janelaConsulta);

		} else if (e.getSource() == menuItemUpdate) {

			janelaUpdate = new JanelaInternaUpdate(this);
			configurarEAdicionarJanela(janelaUpdate);
			menuItemUpdate.setEnabled(false);
			generalController.acessaUpdateController(janelaUpdate);
			
		} else if (e.getSource() == menuItemRemocao) {

			janelaRemocao = new JanelaInternaRemocao(this);
			configurarEAdicionarJanela(janelaRemocao);
			menuItemRemocao.setEnabled(false);
			generalController.acessaRemocaoController(janelaRemocao);

		} else {
			encerrarAplicacao();
		}

	}

	private class OuvinteJanelaInterna extends InternalFrameAdapter {

		@Override
		public void internalFrameClosed(InternalFrameEvent e) {
			JInternalFrame janelaInterna;
			janelaInterna = (JInternalFrame) e.getSource();
			desktop.remove(janelaInterna);
			if (janelaInterna == janelaInsercao) {
				janelaInsercao = null;
				menuItemInsercao.setEnabled(true);
			} else if (janelaInterna == janelaListagem) {
				janelaListagem = null;
				menuItemListagem.setEnabled(true);
			} else if (janelaInterna == janelaConsulta) {
				janelaConsulta = null;
				menuItemConsulta.setEnabled(true);
			}else if (janelaInterna == janelaUpdate) {
				janelaUpdate = null;
				menuItemUpdate.setEnabled(true);
			}else {
				janelaRemocao = null;
				menuItemRemocao.setEnabled(true);
			}
		}

	}

}
