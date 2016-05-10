package ar.com.tecnogab.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import ar.com.tecnogab.model.ClientDAO;
import ar.com.tecnogab.model.Clients;
import ar.com.tecnogab.model.ContactDAO;
import ar.com.tecnogab.model.Contacts;
import ar.com.tecnogab.validation.Validations;
import ar.com.tecnogab.view.ClientView;

public class ClientController implements ActionListener, KeyListener, FocusListener{	
	
	/**Instance of the client view and client model*/
	Clients m_client = new Clients();
	ClientView ui_clientView = new ClientView();
	ClientDAO m_clientDAO = new ClientDAO();	
	
	Contacts m_contacts = new Contacts();
	ContactDAO m_contacModel = new ContactDAO();
	
	/**Check SUM Variable*/
	private static boolean m_flags[] = {false, false, false, false, false, false, false};
	
	/**The constant string variable to reference the saveClient ActionCommands */
	private final static String SAVE_CLIENT = "save_client";	

	/** Constructor with arguments receives the view and model
	 *	@param p_view to set ClientView
	 * 	@param p_model to set ClientDAO
	 **/
	public ClientController(ClientView p_view, ClientDAO p_model) {
		this.ui_clientView = p_view;
		this.m_clientDAO = p_model;
		
		this.ui_clientView.getBtnSaveClient().setEnabled(false);
		this.ui_clientView.getBtnSaveClient().addActionListener(this);
		this.ui_clientView.getBtnSaveClient().setActionCommand("save_client");			
		this.ui_clientView.getTextFieldClientNum().addKeyListener(this);
		this.ui_clientView.getTextFieldClientNum().addFocusListener(this);
		
		this.ui_clientView.getTextFieldDNI().addKeyListener(this);
		this.ui_clientView.getTextFieldDNI().addFocusListener(this);
		
		this.ui_clientView.getTextFieldName().addKeyListener(this);
		this.ui_clientView.getTextFieldName().addFocusListener(this);
		
		this.ui_clientView.getTextFieldLastName().addKeyListener(this);
		this.ui_clientView.getTextFieldLastName().addFocusListener(this);
				
		this.ui_clientView.getDateChooserDateUp().getComponent(1).addFocusListener(this);
		this.ui_clientView.getDateChooserBirthDate().getComponent(1).addFocusListener(this);
		
		this.ui_clientView.getTextFieldAddress().addKeyListener(this);
		this.ui_clientView.getTextFieldAddress().addFocusListener(this);
		
		this.ui_clientView.getTextFieldTelephoneCell().addKeyListener(this);
		this.ui_clientView.getTextFieldTelephoneCell().addFocusListener(this);
		
		this.ui_clientView.getTextFieldTelephoneFijo().addKeyListener(this);
		this.ui_clientView.getTextFieldTelephoneFijo().addFocusListener(this);
			
		this.ui_clientView.getLblCheckCl().setIcon(null);
		this.ui_clientView.getLblCheckDNI().setIcon(null);
		this.ui_clientView.getLblCheckName().setIcon(null);
		this.ui_clientView.getLblCheckLastName().setIcon(null);
		this.ui_clientView.getLblCheckDateUp().setIcon(null);
		this.ui_clientView.getLblCheckBirthDate().setIcon(null);
		this.ui_clientView.getLblCheckAdrress().setIcon(null);
		this.ui_clientView.getLblCheckTC().setIcon(null);
		this.ui_clientView.getLblCheckTF().setIcon(null);
		this.ui_clientView.getLblWaiting().setIcon(null);
	}
	
	/**The actionPerformed method*/
	@Override
	public void actionPerformed(ActionEvent p_actionEvent) {		
		//TODO actionPerformed event button		
		if (p_actionEvent.getActionCommand().equals(SAVE_CLIENT)) {
			saveClient();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {		
	}

	@Override
	public void keyReleased(KeyEvent p_keyEvent) {		
	}

	@Override
	public void keyTyped(KeyEvent p_keyEvent) {

		//TODO keyTyped event
		
		if (p_keyEvent.getComponent().equals(ui_clientView.getTextFieldClientNum())) {
			char l_char = p_keyEvent.getKeyChar();			
		      // Verificar si la tecla pulsada no es un dígito
		      if(Validations.isDigit(l_char)){
		    	  p_keyEvent.consume();  // ignorar el evento de teclado
		      }	
		}		
		
		if (p_keyEvent.getComponent().equals(ui_clientView.getTextFieldDNI())) {
			char l_char = p_keyEvent.getKeyChar();
			
		      // Verificar si la tecla pulsada no es un dígito
		      if(((l_char < '0') || (l_char > '9')) && (l_char != '\b' )){
		    	  p_keyEvent.consume();  // ignorar el evento de teclado
		      }	
		}
		
		if (p_keyEvent.getComponent().equals(ui_clientView.getTextFieldName()) || p_keyEvent.getComponent().equals(ui_clientView.getTextFieldLastName())) {
			char c = p_keyEvent.getKeyChar(); 	         
	          if(Character.isDigit(c)) {  	               
	              p_keyEvent.consume(); 	               	               	               
	          } 
		}
		
		if (p_keyEvent.getComponent().equals(ui_clientView.getTextFieldTelephoneCell()) || p_keyEvent.getComponent().equals(ui_clientView.getTextFieldTelephoneFijo())){
			char l_char = p_keyEvent.getKeyChar();			
		      // Verificar si la tecla pulsada no es un dígito
		      if(((l_char < '0') || (l_char > '9')) && (l_char != '\b' )){
		    	  p_keyEvent.consume();  // ignorar el evento de teclado
		      }
		}
	}

	@Override
	public void focusGained(FocusEvent p_arg) {		
		//TODO focusGained event
		if (p_arg.getComponent().equals(ui_clientView.getTextFieldClientNum())) {	
			focusGainedClientNum();
		}		
		if (p_arg.getComponent().equals(ui_clientView.getTextFieldDNI())) {
			focusGainedDNI();
		}
		if (p_arg.getComponent().equals(ui_clientView.getTextFieldName())) {
			focusGainedName();
		}
		if (p_arg.getComponent().equals(ui_clientView.getTextFieldLastName())) {
			focusGainedLastName();
		}
		if (p_arg.getComponent().equals(ui_clientView.getDateChooserDateUp().getComponent(1))) {	
			focusGainedDateUp();
		}		
		if (p_arg.getComponent().equals(ui_clientView.getDateChooserBirthDate().getComponent(1))) {
			focusGainedBirthDate();
		}		
		if (p_arg.getComponent().equals(ui_clientView.getTextFieldAddress())) {
			focusGainedAddress();
		}
		if (p_arg.getComponent().equals(ui_clientView.getTextFieldTelephoneCell())) {
			focusGainedTelCell();
		}		
		if (p_arg.getComponent().equals(ui_clientView.getTextFieldTelephoneFijo())) {
			focusGainedTelFijo();
		}
	}

	@Override
	public void focusLost(FocusEvent p_arg) {
		//TODO Focus Lost event
		if (p_arg.getComponent().equals(ui_clientView.getTextFieldClientNum())) {			
			focusLostClientNum();
		}		
		if (p_arg.getComponent().equals(ui_clientView.getTextFieldDNI())) {			
			focusLostDNI();
		}		
		if (p_arg.getComponent().equals(ui_clientView.getTextFieldName())) {
			focusLostName();
		}		
		if (p_arg.getComponent().equals(ui_clientView.getTextFieldLastName())) {
			focusLostLastName();
		}				
		if (p_arg.getComponent().equals(ui_clientView.getDateChooserDateUp().getComponent(1)) || p_arg.getComponent().equals(ui_clientView.getDateChooserDateUp().getComponent(0))) {			
			focusLostDateUp();
		}		
		if (p_arg.getComponent().equals(ui_clientView.getDateChooserBirthDate().getComponent(1))) {
			focusLostBirthDate();
		}		
		if (p_arg.getComponent().equals(ui_clientView.getTextFieldAddress())) {
			focusLostAddress();
		}		
		if (p_arg.getComponent().equals(ui_clientView.getTextFieldTelephoneCell())) {
			focusLostTelCell();
		}		
		if (p_arg.getComponent().equals(ui_clientView.getTextFieldTelephoneFijo())) {
			focusLostTelFijo();
		}
	}
	
	private void focusLostClientNum(){
		//TODO Check Field Client Number
		String l_clientNum = ui_clientView.getTextFieldClientNum().getText();		
		if (l_clientNum.length() > 8 || l_clientNum.length() == 0) {			
			ui_clientView.getTextFieldClientNum().setForeground(Color.red);
			ui_clientView.getLblCheckCl().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/delete.png")));
			ui_clientView.getTextFieldClientNum().setBackground(Color.orange);
			ui_clientView.getTextFieldClientNum().setText("Este es un dato obligatorio númerico...");
			m_flags[0] = false;						
		}else {								
			SwingWorker<Integer, Object> worker = new SwingWorker<Integer, Object>(){
				@Override
				protected Integer doInBackground() throws Exception {
					int l_num = 0;
					l_num = m_clientDAO.getClientNum(l_clientNum);
					ui_clientView.getLblCheckCl().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/LoadingCircle_16x16.gif")));						
					return l_num;
				}					
				@Override
				protected void done() {
					try {				               
						if (get() == 0) {
							ui_clientView.getTextFieldClientNum().setForeground(Color.black);
							ui_clientView.getLblCheckCl().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/navigate_check.png")));
							m_flags[0] = true;
							checkFlags();
						}else{
							ui_clientView.getTextFieldClientNum().setForeground(Color.red);
							ui_clientView.getTextFieldClientNum().setBackground(Color.orange);
							ui_clientView.getLblCheckCl().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/sign_warning.png")));
							ui_clientView.getLblCheckCl().setToolTipText("El número de cliente que intenta igresar, ya existe en la base de datos..");
							m_flags[0] = false;
							checkFlags();
						}
					} catch (Exception p_exception) {
						System.out.println(p_exception.getMessage());
					}
				}
				
			};			
			worker.execute();				
		}
	}
	
	private void focusLostDNI(){
		//TODO Check Field DNI
		String l_DNI = ui_clientView.getTextFieldDNI().getText();		
		if (l_DNI.length() > 8 || l_DNI.length() < 8 || l_DNI.length() == 0) {
			ui_clientView.getTextFieldDNI().setForeground(Color.red);
			ui_clientView.getLblCheckDNI().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/delete.png")));
			ui_clientView.getTextFieldDNI().setBackground(Color.orange);
			ui_clientView.getTextFieldDNI().setText("DNI con 8 dígitos...");			
			m_flags[1] = false;
		}else {
			SwingWorker<String, Object> worker = new SwingWorker<String, Object>(){

				@Override
				protected String doInBackground() throws Exception {
					String l_checkDNI = m_clientDAO.getDNI(l_DNI);
					ui_clientView.getLblCheckDNI().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/LoadingCircle_16x16.gif")));
					return l_checkDNI;
				}
				
				@Override
				protected void done(){												
					try {
						if (get().isEmpty()) {
							ui_clientView.getTextFieldDNI().setForeground(Color.black);
							ui_clientView.getLblCheckDNI().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/navigate_check.png")));
							m_flags[1] = true;
							checkFlags();
						}else{
							ui_clientView.getTextFieldDNI().setForeground(Color.red);
							ui_clientView.getLblCheckDNI().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/sign_warning.png")));
							ui_clientView.getLblCheckDNI().setToolTipText("El DNI ya existe en la base de datos...");
							ui_clientView.getTextFieldDNI().setBackground(Color.orange);							
							m_flags[1] = false;
							checkFlags();
						}						
					} catch (Exception p_exception) {
						System.out.println(p_exception.getMessage());
					}					
				}				
			};
			
			worker.execute();			
		}
	}
	
	private void focusLostName(){
		//TODO Check Field Name
		String l_name = ui_clientView.getTextFieldName().getText();
		if (l_name.length() == 0) {
			ui_clientView.getTextFieldName().setForeground(Color.red);
			ui_clientView.getLblCheckName().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/delete.png")));
			ui_clientView.getTextFieldName().setBackground(Color.orange);
			ui_clientView.getTextFieldName().setText("El campo nombre es obligatorio...");
			m_flags[2] = false;
		}else {
			ui_clientView.getTextFieldName().setForeground(Color.black);
			ui_clientView.getLblCheckName().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/navigate_check.png")));
			m_flags[2] = true;
			checkFlags();
		}		
	}
	
	private void focusLostLastName(){
		//TODO Check Field Last Name
		String l_name = ui_clientView.getTextFieldLastName().getText();		
		if (l_name.length() == 0) {
			ui_clientView.getTextFieldLastName().setForeground(Color.red);
			ui_clientView.getLblCheckLastName().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/delete.png")));
			ui_clientView.getTextFieldLastName().setBackground(Color.orange);
			ui_clientView.getTextFieldLastName().setText("El campo apellido es obligatorio...");
			m_flags[3] = false;
		}else {
			ui_clientView.getTextFieldLastName().setForeground(Color.black);
			ui_clientView.getLblCheckLastName().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/navigate_check.png")));
			m_flags[3] = true;
			checkFlags();
		}
	}
	
	private void focusLostDateUp(){
		//TODO Check Field Date Up
		try {
			String l_date = ui_clientView.getDateChooserDateUp().getDate().toString();
			if (!l_date.isEmpty()) {
				ui_clientView.getLblCheckDateUp().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/navigate_check.png")));
				m_flags[4] = true;
				checkFlags();
			}
		} catch (Exception p_exception) {								
			ui_clientView.getLblCheckDateUp().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/delete.png")));				
			ui_clientView.getDateChooserDateUp().getComponent(1).setBackground(Color.orange);
			m_flags[4] = false;
		}	
	}
	
	private void focusLostBirthDate(){
		//TODO Check Field Birth Date
		try {
			String l_date = ui_clientView.getDateChooserBirthDate().getDate().toString();
			if (!l_date.isEmpty()) {
				ui_clientView.getLblCheckBirthDate().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/navigate_check.png")));
				m_flags[5] = true;
				checkFlags();
			}
		} catch (Exception p_exception) {								
			ui_clientView.getLblCheckBirthDate().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/delete.png")));
			ui_clientView.getDateChooserBirthDate().getComponent(1).setBackground(Color.orange);
			m_flags[5] = false;
		}	
	}
	
	private void focusLostAddress(){
		//TODO Check Field Address
		String l_address = ui_clientView.getTextFieldAddress().getText();
		if (l_address.isEmpty()) {
			ui_clientView.getTextFieldAddress().setForeground(Color.red);
			ui_clientView.getLblCheckAdrress().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/delete.png")));
			ui_clientView.getTextFieldAddress().setBackground(Color.orange);
			ui_clientView.getTextFieldAddress().setText("El campo domicilio es obligatorio...");
			m_flags[6] = false;
		}else{
			ui_clientView.getTextFieldAddress().setForeground(Color.black);
			ui_clientView.getLblCheckAdrress().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/navigate_check.png")));
			m_flags[6] = true;
			checkFlags();
		}
	}
	
	private void focusLostTelCell(){
		//TODO Check Field Telephone Cell		
		String l_telCell = ui_clientView.getTextFieldTelephoneCell().getText();
		if (l_telCell.isEmpty()) {
			ui_clientView.getLblCheckTC().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/sign_warning.png")));
			ui_clientView.getTextFieldTelephoneCell().setBackground(Color.yellow);
			ui_clientView.getLblCheckTC().setToolTipText("Este campo no contiene ningun dato..");
		}else{
			ui_clientView.getLblCheckTC().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/navigate_check.png")));
		}		
		checkFlags();
	}
	
	private void focusLostTelFijo(){
		//TODO Check Field Telephone Fijo		
		String l_telFijo = ui_clientView.getTextFieldTelephoneFijo().getText();
		if (l_telFijo.isEmpty()) {
			ui_clientView.getLblCheckTF().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/sign_warning.png")));
			ui_clientView.getTextFieldTelephoneFijo().setBackground(Color.yellow);
			ui_clientView.getLblCheckTF().setToolTipText("Este campo no contiene ningun dato..");
		}else{
			ui_clientView.getLblCheckTF().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/navigate_check.png")));
		}
		checkFlags();
	}
	
	private void focusGainedClientNum(){
		ui_clientView.getTextFieldClientNum().setForeground(Color.black);
		ui_clientView.getLblCheckCl().setIcon(null);	
		ui_clientView.getTextFieldClientNum().setBackground(Color.white);
		ui_clientView.getTextFieldClientNum().selectAll();	
		checkFlags();
	}
	
	private void focusGainedDNI(){
		ui_clientView.getTextFieldDNI().setForeground(Color.black);
		ui_clientView.getLblCheckDNI().setIcon(null);	
		ui_clientView.getTextFieldDNI().setBackground(Color.white);
		ui_clientView.getTextFieldDNI().selectAll();		
		checkFlags();
	}
	
	private void focusGainedName(){
		ui_clientView.getTextFieldName().setForeground(Color.black);
		ui_clientView.getLblCheckName().setIcon(null);	
		ui_clientView.getTextFieldName().setBackground(Color.white);
		ui_clientView.getTextFieldName().selectAll();
		checkFlags();
	}
	
	private void focusGainedLastName(){
		ui_clientView.getTextFieldLastName().setForeground(Color.black);
		ui_clientView.getLblCheckLastName().setIcon(null);	
		ui_clientView.getTextFieldLastName().setBackground(Color.white);
		ui_clientView.getTextFieldLastName().selectAll();		
	}
	
	private void focusGainedDateUp(){
		ui_clientView.getLblCheckDateUp().setIcon(null);
		ui_clientView.getDateChooserDateUp().getComponent(1).setBackground(Color.white);
		checkFlags();
	}
	
	private void focusGainedBirthDate(){
		ui_clientView.getLblCheckBirthDate().setIcon(null);
		ui_clientView.getDateChooserBirthDate().getComponent(1).setBackground(Color.white);
		checkFlags();
	}
	
	private void focusGainedAddress(){
		ui_clientView.getTextFieldAddress().setForeground(Color.black);
		ui_clientView.getLblCheckAdrress().setIcon(null);	
		ui_clientView.getTextFieldAddress().setBackground(Color.white);
		ui_clientView.getTextFieldAddress().selectAll();
		checkFlags();
	}
	
	private void focusGainedTelCell(){
		ui_clientView.getTextFieldTelephoneCell().setBackground(Color.white);
		ui_clientView.getLblCheckTC().setIcon(null);
		checkFlags();
	}
	
	private void focusGainedTelFijo(){
		ui_clientView.getTextFieldTelephoneFijo().setBackground(Color.white);
		ui_clientView.getLblCheckTF().setIcon(null);
		checkFlags();
	}
	
	private void checkFlags(){
		//TODO Check all flags if true
		if (m_flags[0] == true && m_flags[1] == true && m_flags[2] == true && m_flags[3] == true && m_flags[4] == true && m_flags[5] == true && m_flags[6] == true) {
			ui_clientView.getBtnSaveClient().setEnabled(true);			
		}else{
			ui_clientView.getBtnSaveClient().setEnabled(false);
		}
	}
	
	private void setClient(){
		//TODO Set client data
		m_client.setClientNum(Integer.parseInt(ui_clientView.getTextFieldClientNum().getText()));
		m_client.setDni(ui_clientView.getTextFieldDNI().getText());
		m_client.setName(ui_clientView.getTextFieldName().getText());
		m_client.setLastName(ui_clientView.getTextFieldLastName().getText());
		m_client.setStringDateUP(getStringDate(ui_clientView.getDateChooserDateUp().getDate()));
		m_client.setStringBirthDate(getStringDate(ui_clientView.getDateChooserBirthDate().getDate()));		
	}
	
	private void deleteFields() throws InterruptedException{
		ui_clientView.getLblWaiting().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_64x64/LoadingCircle_64x64.gif")));
		
		ui_clientView.getLblCheckCl().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/checks.png")));
		Thread.sleep(100);
		ui_clientView.getLblCheckDNI().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/checks.png")));
		Thread.sleep(100);
		ui_clientView.getLblCheckName().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/checks.png")));
		Thread.sleep(100);
		ui_clientView.getLblCheckLastName().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/checks.png")));
		Thread.sleep(100);
		ui_clientView.getLblCheckDateUp().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/checks.png")));
		Thread.sleep(100);
		ui_clientView.getLblCheckBirthDate().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/checks.png")));
		Thread.sleep(100);
		ui_clientView.getLblCheckAdrress().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/checks.png")));		
		Thread.sleep(100);
		ui_clientView.getLblCheckTC().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/checks.png")));
		Thread.sleep(100);
		ui_clientView.getLblCheckTF().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_16x16/checks.png")));
		
		Thread.sleep(250);		
		ui_clientView.getTextFieldClientNum().setText("");
		ui_clientView.getLblCheckCl().setIcon(null);		
		ui_clientView.getTextFieldDNI().setText("");
		ui_clientView.getLblCheckDNI().setIcon(null);
		ui_clientView.getTextFieldName().setText("");
		ui_clientView.getLblCheckName().setIcon(null);		
		ui_clientView.getTextFieldLastName().setText("");
		ui_clientView.getLblCheckLastName().setIcon(null);		
		ui_clientView.getDateChooserDateUp().setCalendar(null);
		ui_clientView.getLblCheckDateUp().setIcon(null);		
		ui_clientView.getDateChooserBirthDate().setCalendar(null);
		ui_clientView.getLblCheckBirthDate().setIcon(null);		
		ui_clientView.getTextFieldAddress().setText("");
		ui_clientView.getLblCheckAdrress().setIcon(null);				
		ui_clientView.getTextFieldTelephoneCell().setText("");		
		ui_clientView.getLblCheckTC().setIcon(null);
		ui_clientView.getTextFieldTelephoneFijo().setText("");
		ui_clientView.getLblCheckTF().setIcon(null);
		
		ui_clientView.getLblWaiting().setIcon(null);
		ui_clientView.getLblWaiting().setText("Los datos fueron guardados con éxito...");
		Thread.sleep(1000);
		ui_clientView.getLblWaiting().setText("");
		m_flags[0] = false;
		m_flags[1] = false;
		m_flags[2] = false;
		m_flags[3] = false;
		m_flags[4] = false;
		m_flags[5] = false;
		m_flags[6] = false;		
	}
	
	private void setContact(){
		//TODO Set client contact
		m_contacts.setAddress(ui_clientView.getTextFieldAddress().getText());
		m_contacts.setTelCel(ui_clientView.getTextFieldTelephoneCell().getText());
		m_contacts.setTelFijo(ui_clientView.getTextFieldTelephoneFijo().getText());
		m_contacts.setIdClient(m_clientDAO.getLastRecord());
	}
	
	
	private String getStringDate(java.util.Date p_date){
		String l_stringDate = null;
		SimpleDateFormat l_df = new java.text.SimpleDateFormat("yyyy-MM-dd");
		l_stringDate = l_df.format(p_date);		
		return l_stringDate;
	}
	
	private void saveClient(){
		//TODO Save the client data
		setClient();			
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
			@Override
			protected Void doInBackground() throws Exception {
				
				int l_num = m_clientDAO.getClientNum(String.valueOf(m_client.getClientNum()));
				String l_dni = m_clientDAO.getDNI(m_client.getDni());
				ui_clientView.getLblWaiting().setIcon(new ImageIcon(ClientView.class.getResource("/ar/com/tecnogab/icons_64x64/Loading1.gif")));
				
				if (l_num == m_client.getClientNum() || l_dni.equals(m_client.getDni())) {
					JOptionPane.showMessageDialog(ui_clientView, "El número de cliente o DNI que intenta ingresar, ya existe em la base de datos..");
				}else{
					m_clientDAO.insertClient(m_client.getClientNum(), m_client.getDni(), m_client.getName(), m_client.getLastName(), m_client.getStringDateUP(), m_client.getStringBirthDate());
					Thread.sleep(50);
					setContact();
					m_contacModel.insertContact(m_contacts.getAddress(), m_contacts.getTelCel(), m_contacts.getTelFijo(), m_contacts.getIdClient());
					deleteFields();
				}
													
				return null;
			}
			
			@Override				
			protected void done() {
				ui_clientView.getBtnSaveClient().setEnabled(false);				
			}
		};	
		
		worker.execute();		
	}
}
