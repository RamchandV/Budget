import java.io.*;
import java.util.*;

class Profile {
	public static void main(String[] args) throws IOException {
		loadProfile();
	}
	
	public static void loadProfile() throws IOException {
		Scanner keyboard = new Scanner(System.in); 
		System.out.println("Please enter a profile name:");
		String profileName = keyboard.nextLine();
		profileName += ".txt";
		
		File profile = new File(profileName);
		
		if(profile.exists()) {
			System.out.println("PROFILE FOUND, LOADING.....");
			//TODO Load all user info and display results
			loadProfileInfo(profile);
		} else {
			System.out.println("PROFILE NOT FOUND");
			//TODO Ask user for all profile info
			getProfileInfo(profile, keyboard);
			loadProfileInfo(profile);
		}
		keyboard.close();
	}
	
	public static void loadProfileInfo(File profile) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(profile));
		String line;
		while ((line = reader.readLine()) != null){
			System.out.println(line);
		}
		reader.close();
	}
	
	public static void getProfileInfo(File profile, Scanner keyboard) throws IOException {
		PrintWriter newProfile = new PrintWriter(profile);
		System.out.println("Please provide your current yearly salary:");
		String yearlySalary = keyboard.nextLine();
		newProfile.println("yearlySalary:" + yearlySalary);
		System.out.println("Please provide your current montly bill total:");
		String montlyBillTotal = keyboard.nextLine();
		newProfile.println("montlyBillTotal:" + montlyBillTotal);
		System.out.println("Please provide your current total required outgoing payments:");
		String outgoingPayments = keyboard.nextLine();
		newProfile.println("outgoingPayments:" + outgoingPayments);
		newProfile.close();
	}
}
