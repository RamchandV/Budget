import java.util.*;
import java.util.List;

public class Functions {
	
	public static HashMap<String,String> getCurrentItems(ProfileContents profile, String item) {
		HashMap<String,String> items = new HashMap<String,String>();
		if(profile != null) {
			for(HashMap.Entry<String,List<String>> element : profile.entrySet()) {
				if(element.getKey().equals(item)){
					for(String entry : element.getValue()){
						String[] ary = entry.split(":");
						items.put(ary[0], ary[1]);
					}					
				}
			}
		}
		return items;
	}
	
	public static String totalItems(ProfileContents profile, String item) {
		double itemsTotal = 0;
		for(HashMap.Entry<String,List<String>> element : profile.entrySet()) {
			if(element.getKey().equals(item)){
				for(String entry : element.getValue()){
					String[] ary = entry.split(":");
					itemsTotal += Double.parseDouble(ary[1]);
				}					

			}
		}
		return Double.toString(itemsTotal);
	}
}
