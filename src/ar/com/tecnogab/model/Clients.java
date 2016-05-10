package ar.com.tecnogab.model;

public class Clients {
	
	private int clientNum;
	private String dni;
	private String name;
	private String lastName;	
	private String stringDateUP;
	private String stringBirthDate;
	
	public Clients() {
		this.clientNum = 0;
		this.dni = "";
		this.name = "";
		this.lastName = "";
		this.stringDateUP = "";
		this.stringBirthDate = "";
	}

	/**
	 * @return the clientNum
	 */
	public int getClientNum() {
		return clientNum;
	}

	/**
	 * @param clientNum the clientNum to set
	 */
	public void setClientNum(int clientNum) {
		this.clientNum = clientNum;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the stringDateUP
	 */
	public String getStringDateUP() {
		return stringDateUP;
	}

	/**
	 * @param stringDateUP the stringDateUP to set
	 */
	public void setStringDateUP(String stringDateUP) {
		this.stringDateUP = stringDateUP;
	}

	/**
	 * @return the stringBirthDate
	 */
	public String getStringBirthDate() {
		return stringBirthDate;
	}

	/**
	 * @param stringBirthDate the stringBirthDate to set
	 */
	public void setStringBirthDate(String stringBirthDate) {
		this.stringBirthDate = stringBirthDate;
	}	
	
	

}
