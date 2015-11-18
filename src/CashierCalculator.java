//*******************************************************************
//Assignment #2
//
//CashierCalculator.java By: Luis Saravia Patron ID # 6800505
//
//This program will compute the total price of a user-defined quantity
//of items including taxes (GST & QST).
//It will require the user to enter the number of items, the price of 
//each item, the GST and QST rates in percentage.
//It will validate the entered values and will inform how many invalid entries
//have been made.
//*******************************************************************

//In order to use it later, import Scanner class.
import java.util.Scanner;

public class CashierCalculator {

	public static void main(String[] args) {
			
	//Welcome message
	System.out.println("Assignment 2 - Cashier Calculator-  written by Luis Saravia Patron.");
	System.out.println();
	
	// Define given constant values
	final int MIN_ITEM = 1, MAX_ITEM = 10, MIN_PRICE = 1, MAX_PRICE = 1000, MIN_GST = 0,
	MAX_GST = 100, MIN_QST = 0,	MAX_QST = 100;
	final double PERCENTAGE = 0.01;
			
	// Create variables
	int item_quantity, item_nr;
	int invalid_entries = 0;
	double price = 0, subtotal = 0;
	double gst, gst_rate, qst, qst_rate, total;
		
	// Create scanner object
	Scanner kb = new Scanner(System.in);
	
	//Ask for number of items
	do
	{
	System.out.print("Please enter the number of items [1...10]: ");
	item_quantity = kb.nextInt();
	//evaluate and count invalid entries
	if (MIN_ITEM > item_quantity || item_quantity > MAX_ITEM)
		invalid_entries++;
	}
	//validate or ask again
	while (MIN_ITEM > item_quantity || item_quantity > MAX_ITEM);
	
	//Ask the price for each item and add them to get the Subtotal
	for (item_nr = 1; item_nr <= item_quantity; item_nr++)
		{
		do
		{
		System.out.print("Please enter the price of item "+ item_nr +" [1...1000]: ");
		price = kb.nextDouble();
		//evaluate and count invalid entries
		if (MIN_PRICE > price || price > MAX_PRICE)
			invalid_entries++;
		}
		//validate or ask again
		while (MIN_PRICE > price || price > MAX_PRICE);
		//add prices to get Subtotal
		subtotal = subtotal + price;
		}
	
	//Ask the percentage of GST
	do
	{
	System.out.print("Please enter the tax rate of GST in % [0...100]: ");
	gst = kb.nextDouble();
	//evaluate and count invalid entries
	if (MIN_GST > gst || gst > MAX_GST)
		invalid_entries++;
	}
	//validate or ask again
	while (MIN_GST > gst || gst > MAX_GST);
	
	//Calculate the GST rate
	gst_rate = gst * PERCENTAGE;
	//Calculate the GST amount
	gst = subtotal * gst_rate;				
	
	//Ask the rate of QST
	do
	{
	System.out.print("Please enter the tax rate of QST in % [0...100]: ");
	qst = kb.nextDouble();
	//evaluate and count invalid entries
	if (MIN_QST > qst || qst > MAX_QST)
		invalid_entries++;
	}
	//validate or ask again
	while (MIN_QST > qst || qst > MAX_QST);
	
	//Calculate the QST rate
	qst_rate = qst * PERCENTAGE;
	//Calculate the QST amount
	qst = (subtotal + gst) * qst_rate;
			
	//Calculate the total
	total = subtotal + qst + gst;
	
	//Go to the next line
	System.out.println();
	//inform if there were any invalid entries
	if (invalid_entries > 0)
		{
		if (invalid_entries == 1)
			System.out.println("You have entered " + invalid_entries + " invalid input.");
		else
			System.out.println("You have entered " + invalid_entries + " invalid inputs.");
		// go to the next line
		System.out.println();
		}
	
	//Display Subtotal
	System.out.printf("Sub Total:	$%8.2f%n", subtotal);
	//Display GST amount		
	System.out.printf("GST:		$%8.2f%n", gst);
	//Display QST amount
	System.out.printf("QST:		$%8.2f%n", qst);
	//Display Total
	System.out.println("=========================");
	System.out.printf("Total:		$%8.2f%n", total);
	
	// End of program
	System.out.println();
	System.out.println("End of program. Goodbye!");
	}
}