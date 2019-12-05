# Instructor-Assigned-Team-2
Instructor Assigned Team #2 - Kiosk Simulation System - CS-3443-001-Fall-2019-Applications Programming



---Read Me---



---Project Description---

This Java project provides a simulation of a Kiosk application. It allows the user to login to the Kiosk as either an administrator, employee, or customer. For the former two account types, the user is given special permissions for manipulating account and/or product data. For all three account types, the user is able to view the Kiosk page, and can select and purchase from a variety of items.


---Motivation---

This program will be useful as a training program for potential store managers, allowing them to simulate what might happen for some aspects of a real store and gain experience prior to taking their job. If generalized and otherwise expanded, it could be used to help simulate a wider department store corporation's operations. Finally, the program could be used by other companies interested in working with or designing products to aid a department store, as a means of refining their approach.


---Looking at the code/entire program---

This project uses the Java 8 SDK and its included JavaFX libraries. In order to build it, you will need those libraries to be installed in eclipse. If you don't, follow the link below to learn how.
https://www.tutorialspoint.com/javafx/javafx_environment.htm

To Run the Application on Your Computer:
1. Click on the green "Clone or download" button
2. Click on "Download Zip" to download zip file
*this is the enitre program*
3. Move zip File to prefered location (i.e. a desktop)
4. Extract the files to prefered location (i.e. a desktop or same place)
*from here on out the instructions are for eclipse*
5. Open up eclipse
6. Click on "File" (upper left corner)
7. Click on "Open Projects from File System..."
8. Click on "Directory..."
9. Locate the file on your computer (not the zip, the extracted version)
10. Click it and Click "OK"
11. Click on "Finish"
*from here you have downloaded the project and can view any of the classes and fxml files*
*if you have scene builder you can right click on each fxml and open wit scene builder*
*you can click run to run the kiosk from here*


---Testing the Program---

—Test functionality of Login:
-The user must be able to input a username-password pair that matches a given pair in the Accounts file in order to log in to the application. This should permit access to a view depending on the type of account. Customer accounts (type 0) should gain access to the customer/kiosk view. Employee accounts (type 1) should gain access to the employee view. Admin accounts (type 2) should gain access to the admin view. 
-Inputting a username that does not exist, or a username and a password that does not match, should not allow access to any view and should display an error message. 
-The create new account button should allow the user to input a username-password pair to create a new account of type 0, allowing them to log in to the customer view and saving the new account data to the Accounts file.
*you can create a new account and test it that way as a customer*
** USERNAME AND PASSWORDS ARE CASE SENSITIVE**

Default Accounts for Testing:

default Admin Testing

-Username =Admin
-Password =Admin

default Employee Testing

-Username =employee
-Password =employee

default Customer Testing

-Username =customer1
-Password =customer1

another admin testing

-Username =dkintx
-Password =1234

*all account information is stored in Account.txt*


---Test functionality of Customer---

The user of a type 0 Customer account must have full access to several available options:
-Viewing all available products in a graphical interface and being able to tab through them if they occupy more than one page with the next page / previous page buttons.
-Narrowing down the visible products using the search mechanism, changing what products are visible by inputting descriptive keywords and hitting the search button
-For products that have a stock count above 0, the customer should be able to use the add to cart button under each product to deduct one from the stock variable of that product and add that product to their cart.
-The user should not be able to add a product to their cart when the stock is 0.
-The cart display should show the total price of all products in there, all products in the cart (and at what prices and quantities for each), accurately, and should allow the user to clear the cart or choose to ‘buy’ the products, displaying a message thanking the user for their purchase, and as well editing the Products file to track the kiosk’s stock.
-The logout button should return the user to the Login view.
-The home button should clear the search filters and display all products once again.
*similar to how account information is stored, all product information should be stored in Product.txt*

---Test functionality of Employee---

The user of a type 1 Employee account must have full access to several available options:
-Viewing all products in a graphical box that gives the product data(including name, description, ID, and stock count)
-Being able to input the ID of a product and a non-negative quantity count to increase the stock of that particular product, editing the Products file to make it persistent.
-Attempting to input a negative or decimal quantity count to modify it by should result in an error message or outright failure to act, as well as inputting a non-existent ID.
-The user should be able to hit a customer view button to see the application from a customer’s perspective.
-The user should be able to hit the logout button to return the user to the Login view.

---Test functionality of Admin---

The user of a type 2 Admin account must have full access to several available options:
-Displaying the data in the Accounts file or Products file in a processed format.
-Being able to create a new Account or new Product and store the relevant data in the appropriate file. Doing this should require valid data in order to work, otherwise printing an error message.
-The user should be able to access the employee view and customer view from the admin menu.
-The user should be able to hit the logout button to return the user to the Login view.
