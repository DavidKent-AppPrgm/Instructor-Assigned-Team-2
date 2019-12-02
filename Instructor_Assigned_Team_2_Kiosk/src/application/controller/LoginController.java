package application.controller;

import java.awt.Label;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.stream.FileImageInputStream;

import javafx.scene.Node;
import application.model.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*		Login Class
 * 
 * 		Purpose:
 * 
 * 		Notes:
 * 
 * 
 */
/**
 * Controller class that handles the events associated with the Login page.
 * @author 
 *
 */
public class LoginController {

	//PIV
	private Logs Logs = new Logs();
	public static Account loger;				//used to tell who is currently logged in

	//buttons
	@FXML javafx.scene.control.Button buttonCreateNewAccountPrompt;
	@FXML javafx.scene.control.Button buttonCreateNewAccount;
	@FXML javafx.scene.control.Button buttonLogin;
	@FXML javafx.scene.control.Button buttonBack;

	//textFields
	@FXML javafx.scene.control.TextField textFieldUsername;
	@FXML javafx.scene.control.PasswordField passFieldPassword;

	//labels
	@FXML javafx.scene.control.Label labelLoginError;


	//Constructors
	/*
	 * Purpose:
	 * 	
	 * Notes:
	 * 	
	 */
	public LoginController() {}
	
	//Methods
	/*
	 * Purpose:
	 * 	Handles event for when login button is clicked (loads Accounts)
	 * Parameters:
	 * 	I - Event event							button clicked
	 * Returns:
	 * 	void
	 * Notes:
	 * 	Logs user in (will load Kiosk)
	 */
	/**
	 * Verifies that the given username and password are valid. 
	 * If so, it changes the current view to the Kiosk, Admin, or Employee page based on the given input.
	 * @param event The Login button is clicked.
	 */
	public void loginClicked(Event event){
		if(textFieldUsername.getText().toString().equals("") || passFieldPassword.getText().toString().equals("")){
			labelLoginError.setText("Error: Invalid Username and Password");
		}
		else{
			String username = textFieldUsername.getText().toString().toLowerCase();
			String password = passFieldPassword.getText().toString().toLowerCase();
			loger = Logs.accountExists(username);
			//make sure user Account exists
			if(loger != null){
				//login kiosk
				//check if password matches for Account
				if(loger.authenticatePassword(password)){
					
					//Check if Customer Logged in
					if(loger.getAccountType() == 0){
						//load Kiosk.fxml
						Parent kiosk = null;
						try {
							kiosk = FXMLLoader.load(getClass().getResource("../view/Kiosk.fxml"));
						} catch (IOException e) {
							e.printStackTrace();
						}
						Scene sScene = new Scene(kiosk);
						Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

						window.setScene(sScene);
						window.show();
					}
					//Check if Employee Logged in
					else if(loger.getAccountType() == 1){
						//load Employee.fxml
						Parent kiosk = null;
						try {
							kiosk = FXMLLoader.load(getClass().getResource("../view/Employee.fxml"));
						} catch (IOException e) {
							e.printStackTrace();
						}
						Scene sScene = new Scene(kiosk);
						Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
						window.setScene(sScene);
						window.show();
					}
					//Check if Admin Logged in
					else if(loger.getAccountType() == 2){
						//load Admin.fxml
						Parent kiosk = null;
						try {
							kiosk = FXMLLoader.load(getClass().getResource("../view/Admin.fxml"));
						} catch (IOException e) {
							e.printStackTrace();
						}
						Scene sScene = new Scene(kiosk);
						Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	
						window.setScene(sScene);
						window.show();
					}
				}
				else{
					labelLoginError.setText("Error: Invalid Username and Password");
				}
			}
			else{ //account doesn't exist
				//show user error
				labelLoginError.setText("Error: Invalid Username and Password");
			}
		}
	}

	/*
	 * Purpose:
	 * 	Creation of new Account for a customer (loads Accounts)
	 * Parameters:
	 * 	I - Event event							button clicked
	 * Returns:
	 * 	void
	 * Notes:
	 * 	Will automatically login after creation
	 * changes files
	 */
	/**
	 * Creates a new account based on the username and password that the new user enters.
	 * Verifies that the data is valid and that it doesn't match that of an existing account.
	 * @param event The "Create New Account" button on the account creation page is clicked.
	 */
	public void createNewAccountClicked(Event event){

		if(textFieldUsername.getText().toString().equals("") || passFieldPassword.getText().toString().equals("")){
			labelLoginError.setText("Error: Invalid Username and Password");
		}
		else{
			String username = textFieldUsername.getText().toString().toLowerCase();
			String password = passFieldPassword.getText().toString().toLowerCase();
			loger = Logs.accountExists(username);
			//make sure Account doesn't already exist
			if(loger == null){
				//create new customer(0) account (add to files)
				loger = Logs.addNewAccount(Logs.getAccounts().size()+1, 0, username, password);
				
				//load Kiosk.fxml
				Parent kiosk = null;
				try {
					kiosk = FXMLLoader.load(getClass().getResource("../view/Kiosk.fxml"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				Scene sScene = new Scene(kiosk);
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				
				window.setScene(sScene);
				window.show();
			}
			else{ //account does exist
				//show user error
				labelLoginError.setText("Error: Account Already Exists");
			}
		}
	}

	/*
	 * Purpose:
	 * 	Prompt for the user if they are new
	 * Parameters:
	 * 	I - Event event							button clicked
	 * Returns:
	 * 	void
	 * Notes:
	 * 	Handles view to show account creation is user is new
	 */
	/**
	 * Prompt for new users; directs them to the account creation page.
	 * @param event The "Create New Account Prompt" button on the Login page is clicked.
	 */
	public void createNewAccountPromptClicked(Event event){
		//make login prompt buttons invisible
		buttonLogin.visibleProperty().setValue(false);
		buttonCreateNewAccountPrompt.visibleProperty().setValue(false);
		//make creatAccount button and back button visible 
		buttonCreateNewAccount.visibleProperty().setValue(true);
		buttonBack.visibleProperty().setValue(true);
	}

	/*
	 * Purpose:
	 * 	back to login page
	 * Parameters:
	 * 	I - Event event							button clicked
	 * Returns:
	 * 	void
	 * Notes:
	 * 	Used in case user accidently presses Create New Account
	 */
	/**
	 * Reverts from the "Create New Account" page to the Login page.
	 * @param event The Back button is clicked.
	 */
	public void buttonBackClicked(Event event){
		//make login prompt buttons visible
		buttonLogin.visibleProperty().setValue(true);
		buttonCreateNewAccountPrompt.visibleProperty().setValue(true);
		//make creatAccount button and back button invisible 
		buttonCreateNewAccount.visibleProperty().setValue(false);
		buttonBack.visibleProperty().setValue(false);
	}
	
	/*
	 * Purpose:
	 * 	Checks to see what current id number is at
	 * Parameters:
	 * 	None
	 * Returns:
	 * 	int current id number
	 * Notes:
	 * 	Used to create new Account with id + 1
	 */
	/**
	 * Checks the current set of account IDs. Creates a new account ID.
	 * @return num A new account ID that is the current largest ID incremented.
	 */
	public int getIDCurrentNumberOfAccounts(){
		int num = 0;
		try {
			Scanner accountsBuffer = new Scanner(new File("Accounts.txt"));
			while(accountsBuffer.hasNext()){
				accountsBuffer.next();
				num++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return num;
	}
}
