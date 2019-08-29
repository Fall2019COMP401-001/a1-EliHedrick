package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		int itemsInStore = scan.nextInt();
		String[] items = new String[itemsInStore]; // holds names of all items
		double[] prices = new double[itemsInStore]; // holds prices of all items
		String biggestSpender = "";
		String smallestSpender = "";
		double biggestAmount = 0;
		double smallestAmount = 9999;
		double totalSpent = 0;
		
		for(int x = 0;x < itemsInStore;x++)
		{
			items[x] = scan.next(); // add item name to array
			prices[x] = scan.nextDouble(); // add price to same index as item name
		}
		
		int customerAmount= scan.nextInt();
		for(int x = 0; x < customerAmount; x++)
		{
			String firstName = scan.next();
			String lastName = scan.next();
			int itemsBought = scan.nextInt(); // gets how many items each customer bought
			double sum = 0;
			
			for(int y = 0; y < itemsBought; y++) // checks each item
			{
				int amountBought = scan.nextInt(); // gets amount of each item bought
				String itemName = scan.next();
				int indexOfItem = -1;
				
				for(int z = 0; z < items.length && z == indexOfItem; z++) // find index of item in array
				{
					if(items[z].equals(itemName))
						indexOfItem = z;
				}
				sum += amountBought * prices[indexOfItem]; // adds item price to sum
			}
			totalSpent += sum; // adds sum to total
			
			if(sum > biggestAmount) // checks if customer is new biggest or smallest spender
			{
				biggestAmount = sum;
				biggestSpender =  firstName + " " + lastName;
			}
			
			if(sum < smallestAmount)
			{
				smallestAmount = sum;
				smallestSpender = firstName + " " + lastName;
			}
		}
		System.out.println("Biggest: " + biggestSpender + " ("
				+ String.format("%.2f", biggestAmount) + ")");
		System.out.println("Smallest: " + smallestSpender + " ("
				+ String.format("%.2f", smallestAmount) + ")");
		System.out.println("Average: " + String.format("%.2f", totalSpent / customerAmount));
	}
}
