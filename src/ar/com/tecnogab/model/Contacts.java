package ar.com.tecnogab.model;

public class Contacts {
	
	private String address = null;
	private String telCel = null;
	private String telFijo = null;
	private int idClient = 0;

	public Contacts() {		
		this.address = "";
		this.telCel = "";
		this.telFijo = "";
		this.idClient = 0;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the telCel
	 */
	public String getTelCel() {
		return telCel;
	}

	/**
	 * @param telCel the telCel to set
	 */
	public void setTelCel(String telCel) {
		this.telCel = telCel;
	}

	/**
	 * @return the telFijo
	 */
	public String getTelFijo() {
		return telFijo;
	}

	/**
	 * @param telFijo the telFijo to set
	 */
	public void setTelFijo(String telFijo) {
		this.telFijo = telFijo;
	}

	/**
	 * @return the idClient
	 */
	public int getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient the idClient to set
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

}
