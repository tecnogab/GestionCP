package ar.com.tecnogab.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JInternalFrame;

import ar.com.tecnogab.model.ClientDAO;
import ar.com.tecnogab.model.GestionCementeriosDAO;
import ar.com.tecnogab.model.StartTcpServerForH2;
import ar.com.tecnogab.view.ClientView;
import ar.com.tecnogab.view.InumadoView;
import ar.com.tecnogab.view.MainView;

public class MainController implements ActionListener{
	
	/**Group the radio buttons.*/
    ButtonGroup m_group = new ButtonGroup();
	
	/**Instance of the main view and main model*/
	MainView ui_mainView = new MainView();
	GestionCementeriosDAO m_mainModel = new GestionCementeriosDAO();
	
	/**Instance of the client view and client model and client controller*/
	ClientView ui_clientView = new ClientView();
	ClientDAO m_clientModel = new ClientDAO();
	ClientController m_clientControl = new ClientController(ui_clientView, m_clientModel);
	
	/**Instance of the client view and client model and client controller*/
	InumadoView ui_inumadoView = new InumadoView();
	
	/**The Constant String VARIABLE to reference ActionCommands*/
	private final static String CALL_CLIENT_VIEW = "call_client_view";
	private final static String CALL_INUMADO_VIEW = "call_inumado_view";
	
	/** Constructor with arguments receives the view and model
	 *	@param p_view to set view
	 * 	@param p_model to set model
	 **/
	public MainController(MainView p_view, GestionCementeriosDAO p_model) {
		this.ui_mainView = p_view;
		this.m_mainModel = p_model;		
		
		this.ui_mainView.getBtnCallClientWiew().addActionListener(this);
		this.ui_mainView.getBtnCallClientWiew().setActionCommand("call_client_view");
		
		this.ui_mainView.getBtnCallInumadoView().addActionListener(this);
		this.ui_mainView.getBtnCallInumadoView().setActionCommand("call_inumado_view");
		
		StartTcpServerForH2.start();
		
		this.ui_mainView.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent p_windowEvent) {
				StartTcpServerForH2.stop();
			}
		});						
	}
	
	/**The control method instances*/
	public void instanceControl(JInternalFrame p_internalFrame){
		 
		boolean l_viewFlag = true;
		 
		/* Verificar si es instancia de algún componente que ya este en el JDesktopPane*/		
		for (int a=0; a < ui_mainView.getDesktopPane().getComponentCount(); a++){
		    
			if( p_internalFrame.getClass().isInstance( ui_mainView.getDesktopPane().getComponent(a) )){						        
		        p_internalFrame.toFront();		        
		        ui_mainView.getDesktopPane().moveToFront(p_internalFrame);
		        l_viewFlag=false;
		        
		    }else{
		        System.out.println("no lo es, puede mostrarse");
		    }
		}
		
		if(l_viewFlag){
			ui_mainView.getDesktopPane().add(p_internalFrame); }
			p_internalFrame.show();	 		 
		}

	/**The actionPerformed method*/
	@Override
	public void actionPerformed(ActionEvent p_actionEvent) {
		// TODO Events of call client view		
		if (p_actionEvent.getActionCommand().equals(CALL_CLIENT_VIEW)) {						
			instanceControl(ui_clientView);
		}	
		if (p_actionEvent.getActionCommand().equals(CALL_INUMADO_VIEW)) {
			instanceControl(ui_inumadoView);
		}
	}
}
