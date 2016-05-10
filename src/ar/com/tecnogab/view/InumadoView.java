package ar.com.tecnogab.view;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InumadoView extends JInternalFrame {

	private static final long serialVersionUID = -4499506568366883285L;
	private JTextField textFieldClientSearch;
	private JTable table;
	private JLabel lblClientSearch;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public InumadoView() {
		setClosable(true);
		setFrameIcon(new ImageIcon(InumadoView.class.getResource("/ar/com/tecnogab/icons_16x16/headstone.png")));
		setTitle("Alta de inumados");
		setBounds(100, 100, 600, 556);
		getContentPane().setLayout(null);
		
		lblClientSearch = new JLabel("Busqueda de clientes:");
		lblClientSearch.setBounds(12, 12, 165, 16);
		getContentPane().add(lblClientSearch);
		
		textFieldClientSearch = new JTextField();
		textFieldClientSearch.setBounds(22, 40, 333, 20);
		getContentPane().add(textFieldClientSearch);
		textFieldClientSearch.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 69, 570, 114);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"N\u00BA Cliente", "DNI", "Nombre", "Apellido"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(131);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(171);
		scrollPane.setViewportView(table);

	}
}
