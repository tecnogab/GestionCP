package ar.com.tecnogab.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactDAO {

	private H2Conn m_conn = null;
	
	public ContactDAO() {
		m_conn = new H2Conn();
	}
	
	public void insertContact(String p_address, String p_telCel, String p_telFijo, int p_idClient) {

		String l_insertClient = "INSERT INTO T_CONTACTS"
				+ "(ADDRESS, TEL_CEL, TEL_FIJO, ID_CLIENT) VALUES"
				+ "(?,?,?,?)";

		Connection l_accessDB = m_conn.getConnection();
		PreparedStatement l_ps = null;

		try {

			l_ps = l_accessDB.prepareStatement(l_insertClient);

			l_ps.setString(1, p_address);
			l_ps.setString(2, p_telCel);
			l_ps.setString(3, p_telFijo);
			l_ps.setInt(4, p_idClient);			

			// execute insert SQL stetement
			l_ps.executeUpdate();
			System.out.println("Record is inserted into T_CLIENTS table!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
