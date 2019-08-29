package a1;

import java.util.Arrays;
import java.util.Scanner;

//CHANGE SO THAT ALL INPUT IS AT ONCE

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		System.out.println("How many customers are there?");
		int noOfCustomers = scan.nextInt(); //Takes input for no. of customers
		System.out.println(noOfCustomers); //Using for Debugging Purposes
		String[][] dataArray = new String [noOfCustomers][3];
		System.out.println(Arrays.deepToString(dataArray)); //Using for Debugging Purposes


		for (int n=0; n < noOfCustomers; ++n) {
			double runningTotal = 0.0;
			System.out.println("Please enter your details in the following format:"
				+ System.lineSeparator() + "First Name, Last Name, Number of Items");
			
			String firstName  = scan.next(); //Takes input Customer Details
			char nameInitials = firstName.charAt(0);
			String surName  = scan.next(); //Takes input Customer Details
			int noOfItems  = scan.nextInt(); //Takes input Customer Details
			
			System.out.println(firstName); //Can remove next 3 lines after
			System.out.println(nameInitials); //Can remove next 3 lines after
			System.out.println(surName); //DEBUG 
			System.out.println(noOfItems); //DEBUG
			
			for (int i=0; i < noOfItems; i++) {
				System.out.println("Please enter your shopping details in the following format:"
						+ System.lineSeparator() + "Quantity, Name, Price");
				
				int itemQuantity  = scan.nextInt(); //Takes input Item Details
				String itemName  = scan.next(); //Takes input Item Details
				double itemPrice  = scan.nextDouble(); //Takes Item Customer Details
				
				System.out.println(itemQuantity); //Can remove next 3 lines after
				System.out.println(itemName); //DEBUG 
				System.out.println(itemPrice); //DEBUG
				double totalItemPrice = itemPrice * itemQuantity;
				runningTotal = runningTotal + totalItemPrice;
				String finalTotal = Double.toString(runningTotal);
				System.out.println(runningTotal); //DEBUG
				String nameInitialsFinal = Character.toString(nameInitials);
				dataArray[n][0] = nameInitialsFinal;
				dataArray[n][1] = surName;
				dataArray[n][2] = finalTotal;
				System.out.println(Arrays.deepToString(dataArray)); //Using for Debugging Purposes
				
				
			}

		}
		
		  int noOfRows = dataArray.length;
		  for (int j=0; j < noOfRows; j++) {
			  System.out.println(dataArray[j][0] + ". " + dataArray[j][1] + ": " + dataArray[j][2]);
		  }
		
	}
}
