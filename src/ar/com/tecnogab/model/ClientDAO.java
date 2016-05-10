package ar.com.tecnogab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ClientDAO {

	private H2Conn m_conn = null;

	public ClientDAO() {
		m_conn = new H2Conn();
	}

	public void insertClient(int p_clientNum, String p_clientDNI, String p_clientName, String p_clientLastName,
			String p_clientDateUp, String p_clientBirthDate) {

		String l_insertClient = "INSERT INTO T_CLIENTS"
				+ "(CLIENT_NUM, CLIENT_DNI, CLIENT_NAME, CLIENT_LASTNAME, CLIENT_DATEUP, CLIENT_BIRTHDATE) VALUES"
				+ "(?,?,?,?,?,?)";

		Connection l_accessDB = m_conn.getConnection();
		PreparedStatement l_ps = null;

		try {

			l_ps = l_accessDB.prepareStatement(l_insertClient);

			l_ps.setInt(1, p_clientNum);
			l_ps.setString(2, p_clientDNI);
			l_ps.setString(3, p_clientName);
			l_ps.setString(4, p_clientLastName);
			l_ps.setString(5, p_clientDateUp);
			l_ps.setString(6, p_clientBirthDate);

			// execute insert SQL stetement
			l_ps.executeUpdate();
			System.out.println("Record is inserted into T_CLIENTS table!");

		} catch (SQLException p_SQLException) {
			JOptionPane.showMessageDialog(null, p_SQLException);
		}

	}
	
	public int getLastRecord(){
		
		int l_id = 0;
		String l_getLastIdSQL = "SELECT MAX(ID_CLIENT) AS ID FROM T_CLIENTS";
		
		Connection l_accessDB = m_conn.getConnection();
		Statement l_stmt = null;
		ResultSet l_rs = null;
		
		try {
			
			l_stmt = l_accessDB.createStatement();
			l_rs = l_stmt.executeQuery(l_getLastIdSQL);
			
			while (l_rs.next()) {
				l_id = l_rs.getInt("ID");				
			}
			
		} catch (SQLException p_SQLException) {
			JOptionPane.showMessageDialog(null, p_SQLException);
		}	
		
		return l_id;
	}
	
	public int getClientNum(String p_clientNum){
		
		int l_clientNum = 0;
		String l_getLastIdSQL = "SELECT CLIENT_NUM FROM T_CLIENTS WHERE CLIENT_NUM = " + p_clientNum;
		
		Connection l_accessDB = m_conn.getConnection();
		Statement l_stmt = null;
		ResultSet l_rs = null;
		
		try {
			
			l_stmt = l_accessDB.createStatement();
			l_rs = l_stmt.executeQuery(l_getLastIdSQL);
			
			while (l_rs.next()) {
				l_clientNum = l_rs.getInt("CLIENT_NUM");				
			}
			
		} catch (SQLException p_SQLException) {
			JOptionPane.showMessageDialog(null, p_SQLException);
		}	
		
		return l_clientNum;
	}
	
	public String getDNI(String p_dni){
		String l_dni = "";
		String l_getLastIdSQL = "SELECT CLIENT_DNI FROM T_CLIENTS WHERE CLIENT_DNI = " + p_dni;		
		Connection l_accessDB = m_conn.getConnection();
		Statement l_stmt = null;
		ResultSet l_rs = null;
		
		try {
			
			l_stmt = l_accessDB.createStatement();
			l_rs = l_stmt.executeQuery(l_getLastIdSQL);
			
			while (l_rs.next()) {
				l_dni = l_rs.getString("CLIENT_DNI");				
			}
			
		} catch (SQLException p_SQLException) {
			JOptionPane.showMessageDialog(null, p_SQLException);
		}	
		
		return l_dni;
	}

}
