import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BillsFunctions {
	public static HashMap<String,String> getCurrentBills(File profile) {
		HashMap<String,String> bills = new HashMap<String,String>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(profile));
			String line;
			String[] strArry;
			while ((line = reader.readLine()) != null) {
				strArry = line.split(":");
				if(line.startsWith("monthlyBill:")){
					bills.put(strArry[1], strArry[2]);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return bills;
	}
}
