import java.io.*;
import java.util.*;

class ProfileFunctions {
	File profile;
	
	/**
	 String profileName = keyboard.nextLine();
		profileName += ".profile";
		
		File profile = new File(profileName);
	**/
	public ProfileFunctions(File toLoad) throws IOException {		
		if(toLoad.exists()) {
			loadProfileInfo(toLoad);
		}
	}
	
	public void loadProfileInfo(File profile) throws IOException {
		Math math = new Math();
		BufferedReader reader = new BufferedReader(new FileReader(profile));
		String line;
		while ((line = reader.readLine()) != null){
			System.out.println(line);
		}
		/**
		System.out.println("Your monthly bills total to: " + math.totalAmount("monthlyBill:", profile));
		System.out.println("Your required payments total to: " + math.totalAmount("requiredPayment:", profile));
		System.out.println("Your wish list totals to: " + math.totalAmount("wishlistItem:", profile));
		System.out.println("Your purchased groceries total to: " + math.totalAmount("groceryPurchase:", profile));
		**/
		reader.close();
	}
	
	public static void getProfileInfo(File profile, Scanner keyboard) throws IOException {
		PrintWriter newProfile = new PrintWriter(profile);
		System.out.print("Please provide your current yearly salary -");
		String yearlySalary = keyboard.nextLine();
		newProfile.println("yearlySalary:" + yearlySalary);
		enterMonthlyBills(newProfile, keyboard);
		enterRequiredPayments(newProfile, keyboard);
		enterWishlistItems(newProfile, keyboard);
		enterGroceries(newProfile, keyboard);
		newProfile.close();
	}
	
	public static void enterMonthlyBills(PrintWriter profile, Scanner keyboard) {
		System.out.print("Please provide your monthly bill name and amount separated by a colon(:)");
		System.out.print("Enter \"Done\" when you're finished - ");
		String input = keyboard.nextLine();
		while(true) {
			System.out.print("Please provide your next bill - ");
			input = keyboard.nextLine();
			if(input.equals("Done")) {
				break;
			}
			profile.println("monthlyBill:" + input);
		}
	}
	
	public static void enterRequiredPayments(PrintWriter profile, Scanner keyboard) {
		System.out.print("Please provide your payment name and amount separated by a colon(:)");
		System.out.print("Enter \"Done\" when you're finished - ");
		String input = keyboard.nextLine();
		while(true) {
			System.out.print("Please provide next payment - ");
			input = keyboard.nextLine();
			if(input.equals("Done")) {
				break;
			}
			profile.println("requiredPayment:" + input);
		}
	}
	
	public static void enterWishlistItems(PrintWriter profile, Scanner keyboard) {
		System.out.print("Please provide your wishlist item name, amount and link separated by a colon(:)");
		System.out.print("Enter \"Done\" when you're finished - ");
		String input = keyboard.nextLine();
		while(true) {
			System.out.print("Please provide next item - ");
			input = keyboard.nextLine();
			if(input.equals("Done")) {
				break;
			}
			profile.println("wishlistItem:" + input);
		}
	}
	
	public static void enterGroceries(PrintWriter profile, Scanner keyboard) {
		System.out.print("Please provide your grocery purchase date and amount separated by a colon(:)");
		System.out.print("Enter \"Done\" when you're finished - ");
		String input = keyboard.nextLine();
		while(true) {
			System.out.print("Please provide next shopping total - ");
			input = keyboard.nextLine();
			if(input.equals("Done")) {
				break;
			}
			profile.println("groceryPurchase:" + input);
		}
	}
}
