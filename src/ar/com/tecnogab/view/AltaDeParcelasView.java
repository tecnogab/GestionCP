package ar.com.tecnogab.view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AltaDeParcelasView extends JInternalFrame {

	private static final long serialVersionUID = 1012803430485409977L;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public AltaDeParcelasView() {
		setBounds(100, 100, 321, 215);
		getContentPane().setLayout(null);
		
		JLabel lblIngreseLaCantidad = new JLabel("Ingrese la cantidad de sectores:");
		lblIngreseLaCantidad.setBounds(12, 12, 176, 16);
		getContentPane().add(lblIngreseLaCantidad);
		
		textField = new JTextField();
		textField.setBounds(22, 40, 114, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(230, 155, 74, 22);
		getContentPane().add(btnNewButton);
	}
}
