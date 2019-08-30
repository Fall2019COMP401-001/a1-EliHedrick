package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner("6\n" + 
				"Apple 0.25\n" + 
				"Banana 0.75\n" + 
				"Milk 3.15\n" + 
				"Orange 1.25\n" + 
				"Salami 2.50\n" + 
				"Sponge 1.15\n" + 
				"3 \n" + 
				"Carrie Brownstein 3 2 Banana 1 Orange 2 Milk\n" + 
				"Corin Tucker 2 3 Banana 2 Sponge\n" + 
				"Janet Weiss 1 5 Salami");

		// Your code follows here.
		int itemsInStore = scan.nextInt();
		String[] items = new String[itemsInStore]; // holds names of all items
		int[] customersBought = new int[itemsInStore]; // holds how many customers bought each item
		int[] amountBought = new int[itemsInStore]; // holds amount of each item bought
		boolean[] alreadyBought = new boolean[itemsInStore]; // prevents item counting twice per customer
		for(int x = 0;x < itemsInStore;x++)
		{
			items[x] = scan.next(); // add item name to array
			scan.next(); //skips price, not needed for jedi
		}
		
		int customerAmount= scan.nextInt();
		for(int x = 0; x < customerAmount; x++)
		{
			scan.next(); // skips first and last name
			scan.next();
			int itemsBought = scan.nextInt(); // gets how many items each customer bought
			
			for(int y = 0; y < itemsBought; y++) // checks each item
			{
				int dupeBought = scan.nextInt(); // how many of each item is bought
				String itemName = scan.next();
				int indexOfItem = -1;
				
				for(int z = 0; z < items.length; z++) // find index of item in array
				{
					if(items[z].equals(itemName))
					{
						indexOfItem = z;
						if(alreadyBought[indexOfItem] == false)
							customersBought[indexOfItem]++;
						amountBought[indexOfItem]+= dupeBought;
						alreadyBought[indexOfItem] = true;
						break;
					}
				}
			}
			for(int y = 0; x < items.length; y++)
				alreadyBought[x] = false;
		}
		for(int x = 0; x < items.length; x++) // runs through each item, sees amount bought
			if(customersBought[x] == 0)       // and how many customers bought
			{
				System.out.println("No customers bought " + items[x]);
			}
			else
			System.out.println(customersBought[x] + " customers bought "
					+ amountBought[x] + " " + items[x]);
	}
}
