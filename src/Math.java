import java.io.*;

public class Math {
	public String totalAmount(String toTotal, File profile) throws IOException {
		String line;
		String[] strArry;
		Double total = 0.0;
		BufferedReader reader = new BufferedReader(new FileReader(profile));
		while ((line = reader.readLine()) != null) {
			if(line.startsWith(toTotal)) {
				strArry = line.split(":");
				total += Double.parseDouble(strArry[2]);	
			}
		}
		reader.close();
		return total.toString();
	}
	
	public String taxes(){
		return "Pass";
	}
	
	public String spendingMoney(){
		return "Pass";
	}
	
	public String grossToTaxed(){
		return "Pass";
	}
	
	public String yearlyGross(){
		return "Pass";
	}
	
	public String monthlyGross(){
		return "Pass";
	}
	
	public String weeklyGross(){
		return "Pass";
	}
}
