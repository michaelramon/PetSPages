package framework.data;

import java.util.Scanner;
import java.io.BufferedReader;

import java.io.FileReader;

public class ImportCustomerData {
	String shipAddress1, shipAddress2, shipCity, shipZipcode, telephone,
			billAddress1, billAddress2, billCity, billZipcode, email, password,
			firstName, lastName, state, country, wishListName, item1, item2,
			item3;

	Scanner customerScanner = null;
	// import a File Reader and set up txt file to pull data from
	FileReader customerPrint = null;
	// import a buffer reader
	BufferedReader customerBuff = null;
	String[] customerString = null;

	public ImportCustomerData() {

		int counter = 0;

		try {

			customerPrint = new FileReader("Customer.txt");
			// use while loop to pull data
			customerBuff = new BufferedReader(customerPrint);

			// create a scanner
			customerScanner = new Scanner(customerBuff);
			customerString = new String[17];
			do {
				customerString[counter] = customerScanner.nextLine();
				counter++;

			} while (customerScanner.hasNext());

		} catch (Exception IOException) {
		}
		// read in all data from file
		email = customerString[0];
		password = customerString[1];
		country = customerString[2];
		firstName = customerString[3];
		lastName = customerString[4];
		billAddress1 = customerString[5];
		billCity = customerString[6];
		billZipcode = customerString[7];
		telephone = customerString[8];
		state = customerString[9];
		shipAddress1 = customerString[10];
		shipCity = customerString[11];
		shipZipcode = customerString[12];
		wishListName = customerString[13];
		item1 = customerString[14];
		item2 = customerString[15];
		item3 = customerString[16];
		// close the scanner
		customerScanner.close();
	}

}
