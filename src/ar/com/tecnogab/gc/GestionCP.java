package ar.com.tecnogab.gc;

import java.awt.EventQueue;

import ar.com.tecnogab.controller.MainController;
import ar.com.tecnogab.model.GestionCementeriosDAO;
import ar.com.tecnogab.view.MainView;

public class GestionCP {
	
	private static GestionCementeriosDAO m_gcDAO;
	private static MainView m_mainView;
	@SuppressWarnings("unused")
	private static MainController m_mainController;
	

	public static void main(String[] args) {				
		
		m_mainView = new MainView();		
		m_gcDAO = new GestionCementeriosDAO();
		m_mainController = new MainController(m_mainView, m_gcDAO);
		
        EventQueue.invokeLater(new Runnable() {
            public void run() {            	
            	m_mainView.setVisible(true);
            	m_mainView.setLocationRelativeTo(null);   
            }
        });
	}

}
