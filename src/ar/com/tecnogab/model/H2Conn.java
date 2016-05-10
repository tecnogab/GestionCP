package ar.com.tecnogab.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class H2Conn {

	public H2Conn() {
	}

	public Connection getConnection() {
		Connection l_conn = null;

		try {
			
			Class.forName("org.h2.Driver");
			l_conn = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/~/cementerio", "sa", "");

		} catch (ClassNotFoundException p_classNotFoundException) {
			JOptionPane.showMessageDialog(null, p_classNotFoundException.getMessage());
			p_classNotFoundException.printStackTrace();
		} catch (SQLException p_SQLException) {
			JOptionPane.showMessageDialog(null, p_SQLException.getMessage());
			p_SQLException.printStackTrace();
		}
		
		return l_conn;
	}

}
