package application.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*		Logs Class
 * 
 * 		Purpose:
 * 
 * 		Notes:
 * 
 * 
 */
/**
 * Logs stores a list of all of the Kiosk's accounts.
 * @author 
 *
 */
public class Logs {

	//PIV
	private ArrayList<Account> alLogs = new ArrayList<Account>();	//list of all the accounts in file

	//Constructors
	/**
	 * Loads the account data from the application's files.
	 */
	public Logs(){
		//read from Accounts.txt file and load all Accounts
		try {
			Scanner accountsBuffer = new Scanner(new File("Accounts.txt"));
			while(accountsBuffer.hasNext()){
				String[] tempAccount = accountsBuffer.nextLine().split("[,]");
				//tempAccount[0] = id
				//tempAccount[1] = type
				//tempAccount[2] = username
				//tempAccount[3] = password
				Account accountLoad = new Account(Integer.parseInt(tempAccount[0]),Integer.parseInt(tempAccount[1]),tempAccount[2],tempAccount[3]);
				alLogs.add(accountLoad);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	//Methods
	/*
	 * Purpose:
	 * 	Used by Admins to create new employees
	 * 	Used by LoginController for new customers
	 * Parameters:
	 * 	
	 * Returns:
	 * 	Account being added to system
	 * Notes:
	 * 	changes files
	 */
	/**
	 * Retrieves the list of all of the Kiosk's accounts.
	 * @return alLogs An ArrayList containing all of the Kiosk's Accounts.
	 */
	public ArrayList<Account> getAccounts(){
		return alLogs;
	}

	/*
	 * Purpose:
	 * 	Used by Admins to create new employees
	 * 	Used by LoginController for new customers
	 * Parameters:
	 * 	
	 * Returns:
	 * 	Account being added to system
	 * Notes:
	 * 	changes files
	 */
	/**
	 * Creates a new account based on user input. Updates the data in the application's files.
	 * @param id The new Account's given ID.
	 * @param type The new Account's given type.
	 * @param username The new Account's given username.
	 * @param password The new Account's given password.
	 * @return - Returns an Account object or null based on whether the Account was successfully created.
	 */
	public Account addNewAccount(int id, int type, String username, String password){
		//make sure account doesn't already exist
		if(accountExists(username) != null)
			return null;
		//int id, int type, String username, String password
		//create new Account Object
		Account accountTemp = new Account(id, type, username, password);

		//add it to the alLogs
		alLogs.add(accountTemp);
		//write new account into the files
		//setup string for account file
		String str = id+","+type+","+username+","+password;
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("Accounts.txt", true));
			writer.append("\n");
			writer.append(str);
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return accountTemp;
	}

	/*
	 * Purpose:
	 * 	Checks to see if Account exists
	 * Parameters:
	 * 	I - String username						username of Account
	 *  I - String password						passwrod of Account
	 * Returns:
	 * 	Account is exists
	 * 	null is Account doesn't exist
	 * Notes:
	 * 	Used by login and creatNewAccoutn
	 */
	/**
	 * Verifies that a specified Account exists.
	 * @param username The specified Account's username.
	 * @return - An Account object or null based on whether the Account was found.
	 */
	public Account accountExists(String username){
		for(int i = 0; i < alLogs.size();i++){
			//check for matching username and password
			Account aTemp = alLogs.get(i);
			if(aTemp.getAccountUsername().equals(username))
				return aTemp;
		}
		return null;
	}
	
	//toString
	/**
	 * Provides a textual representation of the logs.
	 */
	public String toString(){
		String setText = "";
		for (int i = 0; i < alLogs.size(); i++) {
			setText += alLogs.get(i).toString();
		}
		return setText;
	}
}
