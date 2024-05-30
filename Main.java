package test1;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int decision;
		EntryNode rootNode = null;
		
		while (true){
			System.out.println("Welcome to the phonebook.");
			System.out.println("Please decide what action you wish to preform:");
			decision = Integer.parseInt(s.nextLine());
			
			System.out.print("You have selected ");
			
			if(rootNode == null) {
				switch(decision) {
				case 0:
					System.out.println("<New Entry>");
					System.out.print("Please insert name of new entry: ");
					String new_name = s.nextLine();
					System.out.print("Please enter Phone Number: ");
					int number = Integer.parseInt(s.nextLine());
					System.out.println();
					rootNode = new EntryNode(new_name, number);
					break;
				case 1:
					System.out.println("<Print Phone numbers>");
					System.out.println();
					System.out.println("<No numbers in system>");
					System.out.println();
					break;
				}
				continue;
			}
			switch(decision) {
				case 0:
					System.out.println("<New Entry>");
					System.out.print("Please insert name of new entry: ");
					String new_name = s.nextLine();
					System.out.print("Please enter Phone Number: ");
					int number = Integer.parseInt(s.nextLine());
					System.out.println();
					rootNode = rootNode.addEntry(new_name, number);
					break;
				case 1:
					System.out.println("<Print Phone numbers>");
					rootNode.printList();
					break;
				case 2:
					System.out.println("<Remove Entry>");
					System.out.print("Please select the Entry you wish to remove: ");
					String rm_name = s.nextLine();
					if(rootNode.next != null) {
						rootNode.rmEntry(rm_name);
					}
					else {
						rootNode = null;
					}
					break;
			}
		}
	}
}
