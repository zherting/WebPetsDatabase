package view;

import java.util.List;
import java.util.Scanner;
import controller.OwnerinfoHelper;
import model.TableOwnerinfo;

public class StartProgram {

	static Scanner in = new Scanner(System.in);
	static OwnerinfoHelper oih = new OwnerinfoHelper();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the pet's type: ");
		String type = in.nextLine();
		System.out.print("Enter the pet's name: ");
		String name = in.nextLine();
		System.out.print("Enter the owner's name: ");
		String owner = in.nextLine();
		TableOwnerinfo toAdd = new TableOwnerinfo(type, name, owner);
		oih.insertItem(toAdd);
	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the pet's type to delete: ");
		String type = in.nextLine();
		System.out.print("Enter the pet's name to delete: ");
		String name = in.nextLine();
		System.out.print("Enter the owner's name to delete: ");
		String owner = in.nextLine();
		TableOwnerinfo toDelete = new TableOwnerinfo(type, name, owner);
		oih.deleteItem(toDelete);
	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Type");
		System.out.println("2 : Search by Pet's name");
		System.out.println("3 : Search by Owner's name");
		int searchBy = in.nextInt();
		in.nextLine();
		List<TableOwnerinfo> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the type: ");
			String typeName = in.nextLine();
			foundItems = oih.searchForItemByType(typeName);
		} else if (searchBy == 2) {
			System.out.print("Enter the pet's name: ");
			String petName = in.nextLine();
			foundItems = oih.searchForItemByName(petName);
		} else {
			System.out.print("Enter the Owner's name: ");
			String ownerName = in.nextLine();
			foundItems = oih.searchForItemByOwner(ownerName);
		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (TableOwnerinfo l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			TableOwnerinfo toEdit = oih.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getOwner());
			System.out.println("1 : Update Pet's type");
			System.out.println("2 : Update Pet's name");
			System.out.println("3 : Update Owner's name");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Type: ");
				String newType = in.nextLine();
				toEdit.setType(newType);
			} else if (update == 2) {
				System.out.print("New Name: ");
				String newName = in.nextLine();
				toEdit.setName(newName);
			} else if (update == 3) {
				System.out.print("New Owner: ");
				String newOwner = in.nextLine();
				toEdit.setOwner(newOwner);
			}

			oih.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our Pet's owner table! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an item");
			System.out.println("*  2 -- Edit an item");
			System.out.println("*  3 -- Delete an item");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				oih.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<TableOwnerinfo> allOwnerinfo = oih.showAllOwnerinfo();
		for (TableOwnerinfo singleOwnerinfo : allOwnerinfo) {
			System.out.println(singleOwnerinfo.returnOwnerDetails());
		}
	}
}