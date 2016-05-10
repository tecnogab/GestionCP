package ar.com.tecnogab.view;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuItem;

public class MainView extends JFrame {

	private static final long serialVersionUID = 8798148304721074210L;
	
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu menuFile;
	private JToolBar toolBar;
	private JDesktopPane desktopPane;
	private JButton btnCallClientView;
	private JButton btnCallInumadoView;
	private JButton btnCallAddParcela;
	
	/**
	 * Create the frame.
	 */
	public MainView() {
		
		setLookAndFeel();
		setTitle("Gestion - Parque Zenta S.R.L.");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/ar/com/tecnogab/icons_24x24/Logo_24x19.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 625);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuFile = new JMenu("Archivo");
		menuBar.add(menuFile);
		
		JMenu mnParcelas = new JMenu("Parcelas");
		menuBar.add(mnParcelas);
		
		JMenuItem mntmAltaDeSectores = new JMenuItem("Alta de Sectores");
		mntmAltaDeSectores.setIcon(new ImageIcon(MainView.class.getResource("/ar/com/tecnogab/icons_16x16/map_sectores.png")));
		mnParcelas.add(mntmAltaDeSectores);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnCallClientView = new JButton("");
		btnCallClientView.setIcon(new ImageIcon(MainView.class.getResource("/ar/com/tecnogab/icons_48x48/client_add.png")));
		toolBar.add(btnCallClientView);
		
		btnCallInumadoView = new JButton("");
		btnCallInumadoView.setIcon(new ImageIcon(MainView.class.getResource("/ar/com/tecnogab/icons_48x48/angel.png")));
		toolBar.add(btnCallInumadoView);
		
		btnCallAddParcela = new JButton("");
		btnCallAddParcela.setIcon(new ImageIcon(MainView.class.getResource("/ar/com/tecnogab/icons_48x48/headstone_48x48.png")));
		toolBar.add(btnCallAddParcela);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBorder(new BackgroundImage());
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
	
	private void setLookAndFeel() {
		try {
			// select Look and Feel
			UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Green-Large-Font", "", "Parque Zenta S.R.L.");
		} catch (Exception p_exception) {
			p_exception.printStackTrace();
		}
	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public void setDesktopPane(JDesktopPane p_desktopPane) {
		this.desktopPane = p_desktopPane;
	}

	public JButton getBtnCallClientWiew() {
		return btnCallClientView;
	}

	public void setBtnCallClientWiew(JButton p_button) {
		this.btnCallClientView = p_button;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the btnCallInumadoView
	 */
	public JButton getBtnCallInumadoView() {
		return btnCallInumadoView;
	}

	/**
	 * @param btnCallInumadoView the btnCallInumadoView to set
	 */
	public void setBtnCallInumadoView(JButton btnCallInumadoView) {
		this.btnCallInumadoView = btnCallInumadoView;
	}

	/**
	 * @return the btnCallAddParcela
	 */
	public JButton getBtnCallAddParcela() {
		return btnCallAddParcela;
	}

	/**
	 * @param btnCallAddParcela the btnCallAddParcela to set
	 */
	public void setBtnCallAddParcela(JButton btnCallAddParcela) {
		this.btnCallAddParcela = btnCallAddParcela;
	}
}
