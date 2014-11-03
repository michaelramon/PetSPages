package framework.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ImportProductData {

	String item;
	ArrayList<String> productString = new ArrayList<String>();
	int listSize;
	FileReader productPrint;
	BufferedReader productBuff;
	Scanner productScanner;
	
	
	public ImportProductData() {
		try {
			// import a File Reader and set up txt file to pull data from
			productPrint  = new FileReader("Products.txt");
			productBuff = new BufferedReader(productPrint);
			// create a scanner
			productScanner = new Scanner(productBuff);
			
			// use while loop to pull data
			do {
				productString.add(productScanner.nextLine());

			} while (productScanner.hasNextLine());

		} catch (Exception IOException) {
		}

		listSize = getSize();
		productScanner.close();

	}

	public int getSize() {
		return productString.size();
	}
	
	public String getItem(int location){
		return productString.get(location);
	}
	

}
