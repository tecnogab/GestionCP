package ar.com.tecnogab.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.Color;

public class ClientView extends JInternalFrame {

	private static final long serialVersionUID = -5544277172530945508L;
	private JTextField textFieldClientNum;
	private JTextField textFieldDNI;
	private JTextField textFieldName;
	private JTextField textFieldLastName;
	private JLabel lblClientNum;
	private JLabel lblDNI;
	private JLabel lblName;
	private JLabel lblLastName;
	private JLabel lblDateUp;
	private JLabel lblDateBirth;
	private JDateChooser dateChooserDateUp;
	private JDateChooser dateChooserBirthDate;
	private JTextField textFieldAddress;
	private JTextField textFieldTelephoneCel;
	private JTextField textFieldTelephoneFijo;
	private JButton btnSaveClient;
	private JLabel lblWaiting;
	private JLabel lblDomicilio;
	private JLabel lblTelfonoCelular;
	private JLabel lblTelfonoFijo;
	private JLabel lblCheckCl;
	private JLabel lblCheckDNI;
	private JLabel lblCheckName;
	private JLabel lblCheckLastName;
	private JLabel lblCheckDateUp;
	private JLabel lblCheckBirthDate;
	private JLabel lblCheckAdrress;
	private JLabel lblCheckTC;
	private JLabel lblCheckTF;
	private JSeparator separator;

	/**
	 * Create the frame.
	 */
	public ClientView() {
		setClosable(true);
		setFrameIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/client_add.png")));
		setTitle("Alta de clientes");
		setBounds(100, 100, 495, 456);
		getContentPane().setLayout(null);
		
		lblClientNum = new JLabel("Cliente n\u00FAmero:");
		lblClientNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClientNum.setBounds(12, 12, 125, 16);
		getContentPane().add(lblClientNum);
		
		lblDNI = new JLabel("DNI:");
		lblDNI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDNI.setBounds(12, 40, 125, 16);
		getContentPane().add(lblDNI);
		
		lblName = new JLabel("Nombre:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(12, 68, 125, 16);
		getContentPane().add(lblName);
		
		lblLastName = new JLabel("Apellido:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(12, 96, 125, 16);
		getContentPane().add(lblLastName);
		
		lblDateUp = new JLabel("Fecha de alta:");
		lblDateUp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateUp.setBounds(12, 124, 125, 16);
		getContentPane().add(lblDateUp);
		
		lblDateBirth = new JLabel("Fecha de nacimiento:");
		lblDateBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateBirth.setBounds(12, 152, 125, 16);
		getContentPane().add(lblDateBirth);
		
		textFieldClientNum = new JTextField();
		textFieldClientNum.setBounds(155, 10, 260, 20);
		getContentPane().add(textFieldClientNum);
		textFieldClientNum.setColumns(10);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(155, 38, 260, 20);
		getContentPane().add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(155, 66, 260, 20);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(155, 94, 260, 20);
		getContentPane().add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		dateChooserDateUp = new JDateChooser();
		dateChooserDateUp.setDateFormatString("dd/MM/yyyy");
		dateChooserDateUp.getComponent(1).setFocusable(true);		
		dateChooserDateUp.setBounds(155, 124, 260, 20);
		getContentPane().add(dateChooserDateUp);
		
		dateChooserBirthDate = new JDateChooser();
		dateChooserBirthDate.setDateFormatString("dd/MM/yyyy");
		dateChooserBirthDate.getComponent(1).setFocusable(true);
		dateChooserBirthDate.setBounds(155, 152, 260, 20);
		getContentPane().add(dateChooserBirthDate);
		
		lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDomicilio.setBounds(12, 180, 125, 16);
		getContentPane().add(lblDomicilio);
		
		lblTelfonoCelular = new JLabel("Tel\u00E9fono celular:");
		lblTelfonoCelular.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfonoCelular.setBounds(12, 208, 125, 16);
		getContentPane().add(lblTelfonoCelular);
		
		lblTelfonoFijo = new JLabel("Tel\u00E9fono fijo:");
		lblTelfonoFijo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelfonoFijo.setBounds(12, 236, 125, 16);
		getContentPane().add(lblTelfonoFijo);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(155, 178, 260, 20);
		getContentPane().add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		textFieldTelephoneCel = new JTextField();
		textFieldTelephoneCel.setBounds(155, 206, 260, 20);
		getContentPane().add(textFieldTelephoneCel);
		textFieldTelephoneCel.setColumns(10);
		
		textFieldTelephoneFijo = new JTextField();
		textFieldTelephoneFijo.setBounds(155, 234, 260, 20);
		getContentPane().add(textFieldTelephoneFijo);
		textFieldTelephoneFijo.setColumns(10);
		
		separator = new JSeparator();
		separator.setBounds(12, 264, 465, 16);
		getContentPane().add(separator);
		
		btnSaveClient = new JButton("");
		btnSaveClient.setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_128x128/client_floppy_disk.png")));
		btnSaveClient.setBounds(308, 291, 169, 127);
		getContentPane().add(btnSaveClient);
		
		lblWaiting = new JLabel("");
		lblWaiting.setForeground(new Color(0, 153, 0));
		lblWaiting.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblWaiting.setBounds(12, 292, 260, 126);
		getContentPane().add(lblWaiting);
		
		lblCheckCl = new JLabel("");
		lblCheckCl.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckCl.setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/cloud_1_16x16.png")));
		lblCheckCl.setBounds(422, 12, 55, 16);
		getContentPane().add(lblCheckCl);
		
		lblCheckDNI = new JLabel("");
		lblCheckDNI.setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/navigate_check.png")));
		lblCheckDNI.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckDNI.setBounds(422, 40, 55, 16);
		getContentPane().add(lblCheckDNI);
		
		lblCheckName = new JLabel("");
		lblCheckName.setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/navigate_check.png")));
		lblCheckName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckName.setBounds(422, 68, 55, 16);
		getContentPane().add(lblCheckName);
		
		lblCheckLastName = new JLabel("");
		lblCheckLastName.setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/navigate_check.png")));
		lblCheckLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckLastName.setBounds(422, 96, 55, 16);
		getContentPane().add(lblCheckLastName);
		
		lblCheckDateUp = new JLabel("");
		lblCheckDateUp.setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/navigate_check.png")));
		lblCheckDateUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckDateUp.setBounds(422, 124, 55, 16);
		getContentPane().add(lblCheckDateUp);
		
		lblCheckBirthDate = new JLabel("");
		lblCheckBirthDate.setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/navigate_check.png")));
		lblCheckBirthDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckBirthDate.setBounds(422, 152, 55, 16);
		getContentPane().add(lblCheckBirthDate);
		
		lblCheckAdrress = new JLabel("");
		lblCheckAdrress.setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/navigate_check.png")));
		lblCheckAdrress.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckAdrress.setBounds(422, 180, 55, 16);
		getContentPane().add(lblCheckAdrress);
		
		lblCheckTC = new JLabel("");
		lblCheckTC.setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/sign_warning.png")));
		lblCheckTC.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckTC.setBounds(422, 208, 55, 16);
		getContentPane().add(lblCheckTC);
		
		lblCheckTF = new JLabel("");
		lblCheckTF.setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/sign_warning.png")));
		lblCheckTF.setHorizontalAlignment(SwingConstants.CENTER);
		lblCheckTF.setBounds(422, 236, 55, 16);
		getContentPane().add(lblCheckTF);
	}

	/**
	 * @return the textFieldClientNum
	 */
	public JTextField getTextFieldClientNum() {
		return textFieldClientNum;
	}

	/**
	 * @param p_textField the textFieldClientNum to set
	 */
	public void setTextFieldClientNum(JTextField p_textField) {
		this.textFieldClientNum = p_textField;
	}

	/**
	 * @return the textFieldDNI
	 */
	public JTextField getTextFieldDNI() {
		return textFieldDNI;
	}

	/**
	 * @param p_textField the textFieldDNI to set
	 */
	public void setTextFieldDNI(JTextField p_textField) {
		this.textFieldDNI = p_textField;
	}

	/**
	 * @return the textFieldName
	 */
	public JTextField getTextFieldName() {
		return textFieldName;
	}

	/**
	 * @param p_textField the textFieldName to set
	 */
	public void setTextFieldName(JTextField p_textField) {
		this.textFieldName = p_textField;
	}

	/**
	 * @return the textFieldLastName
	 */
	public JTextField getTextFieldLastName() {
		return textFieldLastName;
	}

	/**
	 * @param p_textField the textFieldLastName to set
	 */
	public void setTextFieldLastName(JTextField p_textField) {
		this.textFieldLastName = p_textField;
	}

	/**
	 * @return the dateUpDate
	 */
	public JDateChooser getDateChooserDateUp() {
		return dateChooserDateUp;
	}

	/**
	 * @param p_jDateChooser the dateChooserDateUp to set
	 */
	public void setDateChooserDateUp(JDateChooser p_jDateChooser) {
		this.dateChooserDateUp = p_jDateChooser;
	}

	/**
	 * @return the dateChooserBirthDate
	 */
	public JDateChooser getDateChooserBirthDate() {
		return dateChooserBirthDate;
	}

	/**
	 * @param p_jDateChooser the dateChooserBirthDate to set
	 */
	public void setDateBirthDate(JDateChooser p_jDateChooser) {
		this.dateChooserBirthDate = p_jDateChooser;
	}

	/**
	 * @return the textFieldAddress
	 */
	public JTextField getTextFieldAddress() {
		return textFieldAddress;
	}

	/**
	 * @param p_textField the textFieldAddress to set
	 */
	public void setTextFieldAddress(JTextField p_textField) {
		this.textFieldAddress = p_textField;
	}

	/**
	 * @return the textFieldTelephoneCel
	 */
	public JTextField getTextFieldTelephoneCell() {
		return textFieldTelephoneCel;
	}

	/**
	 * @param p_textField the textFieldTelephoneCel to set
	 */
	public void setTextFieldTelephoneCel(JTextField p_textField) {
		this.textFieldTelephoneCel = p_textField;
	}

	/**
	 * @return the textFieldTelephoneFijo
	 */
	public JTextField getTextFieldTelephoneFijo() {
		return textFieldTelephoneFijo;
	}

	/**
	 * @param p_textField the textFieldTelephoneFijo to set
	 */
	public void setTextFieldTelephoneFijo(JTextField p_textField) {
		this.textFieldTelephoneFijo = p_textField;
	}

	/**
	 * @return the btnSaveClient
	 */
	public JButton getBtnSaveClient() {
		return btnSaveClient;
	}

	/**
	 * @param p_jButton the btnSaveClient to set
	 */
	public void setBtnSaveClient(JButton p_jButton) {
		this.btnSaveClient = p_jButton;
	}

	/**
	 * @return the lblWaiting
	 */
	public JLabel getLblWaiting() {
		return lblWaiting;
	}

	/**
	 * @param p_lbl the lblWaiting to set
	 */
	public void setLblWaiting(JLabel p_lbl) {
		this.lblWaiting = p_lbl;
	}

	/**
	 * @return the lblClientNum
	 */
	public JLabel getLblClientNum() {
		return lblClientNum;
	}

	/**
	 * @param lblClientNum the lblClientNum to set
	 */
	public void setLblClientNum(JLabel lblClientNum) {
		this.lblClientNum = lblClientNum;
	}

	/**
	 * @return the lblCheckCl
	 */
	public JLabel getLblCheckCl() {
		return lblCheckCl;
	}

	/**
	 * @param lblCheckCl the lblCheckCl to set
	 */
	public void setLblCheckCl(JLabel lblCheckCl) {
		this.lblCheckCl = lblCheckCl;
	}

	/**
	 * @return the lblCheckDNI
	 */
	public JLabel getLblCheckDNI() {
		return lblCheckDNI;
	}

	/**
	 * @param lblCheckDNI the lblCheckDNI to set
	 */
	public void setLblCheckDNI(JLabel lblCheckDNI) {
		this.lblCheckDNI = lblCheckDNI;
	}

	/**
	 * @return the lblCheckName
	 */
	public JLabel getLblCheckName() {
		return lblCheckName;
	}

	/**
	 * @param lblCheckName the lblCheckName to set
	 */
	public void setLblCheckName(JLabel lblCheckName) {
		this.lblCheckName = lblCheckName;
	}

	/**
	 * @return the lblCheckLastName
	 */
	public JLabel getLblCheckLastName() {
		return lblCheckLastName;
	}

	/**
	 * @param lblCheckLastName the lblCheckLastName to set
	 */
	public void setLblCheckLastName(JLabel lblCheckLastName) {
		this.lblCheckLastName = lblCheckLastName;
	}

	/**
	 * @return the lblCheckDateUp
	 */
	public JLabel getLblCheckDateUp() {
		return lblCheckDateUp;
	}

	/**
	 * @param lblCheckDateUp the lblCheckDateUp to set
	 */
	public void setLblCheckDateUp(JLabel lblCheckDateUp) {
		this.lblCheckDateUp = lblCheckDateUp;
	}

	/**
	 * @return the lblCheckBirthDate
	 */
	public JLabel getLblCheckBirthDate() {
		return lblCheckBirthDate;
	}

	/**
	 * @param lblCheckBirthDate the lblCheckBirthDate to set
	 */
	public void setLblCheckBirthDate(JLabel lblCheckBirthDate) {
		this.lblCheckBirthDate = lblCheckBirthDate;
	}

	/**
	 * @return the lblCheckAdrress
	 */
	public JLabel getLblCheckAdrress() {
		return lblCheckAdrress;
	}

	/**
	 * @param lblCheckAdrress the lblCheckAdrress to set
	 */
	public void setLblCheckAdrress(JLabel lblCheckAdrress) {
		this.lblCheckAdrress = lblCheckAdrress;
	}

	/**
	 * @return the lblCheckTC
	 */
	public JLabel getLblCheckTC() {
		return lblCheckTC;
	}

	/**
	 * @param lblCheckTC the lblCheckTC to set
	 */
	public void setLblCheckTC(JLabel lblCheckTC) {
		this.lblCheckTC = lblCheckTC;
	}

	/**
	 * @return the lblCheckTF
	 */
	public JLabel getLblCheckTF() {
		return lblCheckTF;
	}

	/**
	 * @param lblCheckTF the lblCheckTF to set
	 */
	public void setLblCheckTF(JLabel lblCheckTF) {
		this.lblCheckTF = lblCheckTF;
	}
}
