package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int customerAmount = scan.nextInt();
		
		for(int x = 0; x < customerAmount; x++) // loops through all customers
		{
			String firstName = scan.next();
			String lastName = scan.next();
			double sum = 0; // sum of all items bought per customer
			int itemsBought = scan.nextInt(); // gets how many items each customer bought
			
			for(int y = 0; y < itemsBought; y++) // checks each item
			{
				int amountBought = scan.nextInt();
				scan.next(); // skips item name, not needed in novice
				double price = scan.nextDouble() * amountBought;
				sum += price; // adds to sum of customer
			}
			System.out.println(firstName.substring(0,1) + ". " + lastName + ": "
					+ String.format("%.2f", sum)); // prints out customer name and total spent
		}
	}
}
