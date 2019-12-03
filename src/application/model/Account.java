package application.model;

/*		Account Class
 * 
 * 		Purpose:
 * 
 * 		Notes:
 * 
 * 
 */
/**
 * Each account has an ID, type, username, and password.
 * @author 
 *
 */
public class Account {

	//PIV
	private int iID;
	private int iType;
	
	private String pszUsername;
	private String pszPassword;
	
	//Constructors
	/**
	 * 
	 * @param id An integer containing the new account's given ID.
	 * @param type An integer containing the new account's given type.
	 * @param username A String containing the new account's given username.
	 * @param password A String containing the new account's given password.
	 */
	public Account(int id, int type, String username, String password) {
		iID = id;
		iType = type;
		pszUsername = username;
		pszPassword = password;
	}
	
	//Methods
	/*
	 * Purpose:
	 * 	used to get the name of the Account
	 * Parameters:
	 * 	None
	 * Returns:
	 * 	String username of the Account
	 * Notes:
	 * 	
	 */
	/**
	 * Retrieves an account's username.
	 * @return pszUsername A String containing the account's username.
	 */
	public String getAccountUsername(){
		return pszUsername;
	}
	
	/*
	 * Purpose:
	 * 	used to get the name of the Account
	 * Parameters:
	 * 	None
	 * Returns:
	 * 	String username of the Account
	 * Notes:
	 * 	
	 */
	/**
	 * Retrieves the account's type.
	 * @return iType An integer containing the account's type.
	 */
	public int getAccountType(){
		return iType;
	}
	
	/*
	 * Purpose:
	 * 	used to get the name of the Account
	 * Parameters:
	 * 	None
	 * Returns:
	 * 	String username of the Account
	 * Notes:
	 * 	
	 */
	/**
	 * Retrieves the account's ID.
	 * @return iID An integer containing the account's ID.
	 */
	public int getAccountId(){
		return iID;
	}
	
	/*
	 * Purpose:
	 * 	Used to check if password is correct during login
	 * Parameters:
	 * 	I - String password							password entered by the user (not accounts password if wrong)
	 * Returns:
	 * 	true if password is correct
	 *  false if password is incorrect
	 * Notes:
	 * 	
	 */
	/**
	 * Verifies that the given password matches that of the account.
	 * @param password The password provided by user input.
	 * @return - A boolean value indicating whether the given password was correct.
	 */
	public boolean authenticatePassword(String password) {
		if(this.pszPassword.equals(password))
			return true;
		return false;
	}
	//toString
	/**
	 * Provides a textual representation of an account's data.
	 */
	public String toString(){
		return "ID - " + iID + "\nType - " + iType + "\nUsername - " + pszUsername + "\nPassword - " + pszPassword+"\n\n";
	}
}
