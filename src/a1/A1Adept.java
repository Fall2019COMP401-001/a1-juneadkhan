package a1;

import java.util.Arrays;
import java.util.Scanner;

public class A1Adept {

//CHANGE SO THAT ALL INPUT IS AT ONCE

	public static void main(String[] args) {
		
			Scanner scan = new Scanner(System.in);

		// Your code follows here.
			//System.out.println("How many Items are there in the store?");
			int noOfStoreItems = scan.nextInt(); //Takes input for no. of items
			//System.out.println(noOfStoreItems); //Using for Debugging Purposes
			String[][] itemArray = new String [noOfStoreItems][2];
			//System.out.println(Arrays.deepToString(itemArray)); //Using for Debugging Purposes
			
			//Iteration over amount of items to input Item Data
			for (int k=0; k < noOfStoreItems; k++) {
				//System.out.println("Please enter your details in the following format:"
					//+ System.lineSeparator() + "Item Name, Price");
				String storeItemName  = scan.next(); //Takes input Customer Details
				String storeItemPrice  = scan.next(); //Takes input Customer Details - Need to convert to Double later on
				//System.out.println(storeItemName); //Using for Debugging Purposes
				//System.out.println(storeItemPrice); //Using for Debugging Purposes
				itemArray[k][0] = storeItemName;
				itemArray[k][1] = storeItemPrice;
				//System.out.println(Arrays.deepToString(itemArray)); //Using for Debugging Purposes

			}
			
			
			
			//Novice Code
			//System.out.println("How many customers are there?");
			int noOfCustomers = scan.nextInt(); //Takes input for no. of customers
			//System.out.println(noOfCustomers); //Using for Debugging Purposes
			String[][] dataArray = new String [noOfCustomers][3 + (noOfStoreItems*2)];
			//System.out.println(Arrays.deepToString(dataArray)); //Using for Debugging Purposes

				
			for (int n=0; n < noOfCustomers; ++n) {
				//System.out.println("Please enter your details in the following format:"
					//+ System.lineSeparator() + "First Name, Last Name, Number of Items, Item Quantity, Item Name etc.");
				
				String firstName  = scan.next(); //Takes input Customer Details
				String surName  = scan.next(); //Takes input Customer Details
				int noOfItems  = scan.nextInt(); //Takes input Customer Details
				
				//System.out.println(firstName); //Can remove next 3 lines after
				//System.out.println(surName); //DEBUG 
				//System.out.println(noOfItems); //DEBUG
				dataArray[n][0] = firstName;
				dataArray[n][1] = surName;

				for (int i=0; i < (noOfItems*2); i++) {
					
					//new number of items code
					//System.out.println(Arrays.deepToString(dataArray)); //Using for Debugging Purposes
					String itemToBeAddedToList  = scan.next(); //Takes input Customer Details
					//System.out.println(itemToBeAddedToList); //DEBUG 
					dataArray[n][3+i] = itemToBeAddedToList;
					//System.out.println(Arrays.deepToString(dataArray)); //Using for Debugging Purposes

				}

			}
			//
			
			
			//Calculate Total Spend - Requires Restructure 
			for (int p=0; p < (noOfCustomers); p++) {
				double runningTotal = 0.00;
				//System.out.println("ORIGINAL For Loop");
					for (int x = 0 ; x < itemArray.length; x++) {
						//System.out.println("1st For Loop");
						//System.out.println(itemArray.length);
						//System.out.println(Arrays.deepToString(itemArray[x]));//DEBUG 
					    for(int y = 0 ; (y < itemArray[x].length) ; y=y+2)
					    {
							 //System.out.println("2nd For Loop"); //DEBUG 
							 //System.out.println(itemArray[x][y]);//DEBUG 
							 String comparisonVariable = (itemArray[x][y]); //Change Name of Variable
							 String itemPrice = (itemArray[x][y+1]); //Change Name of Variable
							 //System.out.println(itemArray[x][y+1]);//DEBUG 
							 //System.out.println("Comparison Variable is: " + comparisonVariable);//DEBUG 
							 //System.out.println("Price: " + itemPrice);//DEBUG 

							 for (int q=0; q < (dataArray[p].length) ; q += 2) {
									//System.out.println("Q= " + q + "and dataArray[p].length =" + dataArray[p].length);//DEBUG 
									String tempQuantity = dataArray[p][3+q];
									boolean NullCheck = (tempQuantity != null);
									if (!NullCheck) {
										break;
									}
									//System.out.println("Temp Quantity: " + tempQuantity);//DEBUG 
						            double currentQuantity = Double.valueOf(tempQuantity);
									//System.out.println("Current Quantity is: " + currentQuantity); //DEBUG 
									String currentItem = dataArray[p][3+q+1];
									//System.out.println("Current Item is: " + currentItem);//DEBUG 
									//System.out.println((comparisonVariable).trim().equals((currentItem)));//DEBUG 
									boolean compareIdentifier = ((comparisonVariable).trim().equals((currentItem)));//DEBUG 
									//System.out.println("Compare Indentifier: " + compareIdentifier);//DEBUG 

									 if (compareIdentifier){
 
										  //System.out.println("IF/ELSE"); //DEBUG 
							              double itemValue = Double.valueOf(itemPrice);
										  //System.out.println("Running Total is: " + runningTotal);//DEBUG 
										  //System.out.println("Item Value: " + itemValue); //Using for Debugging Purposes
										  runningTotal = runningTotal + (itemValue * currentQuantity);
										  //System.out.println("New Running Total is: " + runningTotal); //Using for Debugging Purposes
										  String runningTotal_str = Double.toString(runningTotal);
										  dataArray[p][2] = runningTotal_str;
										  //System.out.println(Arrays.deepToString(dataArray)); //Using for Debugging Purposes
										  break;
							         }
							 }
					        
					    }
					}
			}
			
		//Calculate Biggest + Average
		int biggestIndex = 0;
		int smallestIndex = 1000;
		double biggestValue = 0.0;
		double smallestValue = 100.0;
		double total = 0;
		double average = 0;
		for (int g=0; g < (dataArray.length); g++) {
			String tempTotal = dataArray[g][2];
            double totalCustomer = Double.valueOf(tempTotal);	
			if ( totalCustomer > biggestValue) {
				biggestValue = totalCustomer;
				biggestIndex = g;
			}
			if ( totalCustomer < smallestValue) {
				smallestValue = totalCustomer;
				smallestIndex = g;
			}
			//System.out.println("Biggest Index: "+ biggestIndex + " BiggestValue: " + biggestValue);
			//System.out.println("Smallest Index: "+ smallestIndex + " SmallestValue: " + smallestValue);
			total += totalCustomer;	
			average = total/dataArray.length;
			//System.out.println("Average: "+ average);

		}
		
		//Display Final Output
		System.out.println("Biggest: " + dataArray[biggestIndex][0] + " " + dataArray[biggestIndex][1] + " (" +
				String.format("%.2f",biggestValue) + ")");
		System.out.println("Smallest: " + dataArray[smallestIndex][0] + " " + dataArray[smallestIndex][1] + " (" +
				String.format("%.2f",smallestValue) + ")");
		System.out.println("Average: " + String.format("%.2f", average));

		
	}
	
	private static double parseDouble(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


