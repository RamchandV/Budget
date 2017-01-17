import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class BillsFunctions {
	
	public static HashMap<String,String> getCurrentBills(ProfileContents profile) {
		HashMap<String,String> bills = new HashMap<String,String>();
		if(profile != null) {
			for(HashMap.Entry<String,List<String>> element : profile.entrySet()) {
				if(element.getKey().equals("monthlyBill:")){
					for(String entry : element.getValue()){
						String[] ary = entry.split(":");
						bills.put(ary[0], ary[1]);
					}					
				}
			}
		}
		return bills;
	}
	
	public static String totalBills(ProfileContents profile) {
		double bills = 0;
		for(HashMap.Entry<String,List<String>> element : profile.entrySet()) {
			if(element.getKey().equals("monthlyBill:")){
				for(String entry : element.getValue()){
					String[] ary = entry.split(":");
					bills += Double.parseDouble(ary[1]);
				}					

			}
		}
		return Double.toString(bills);
	}
}
