import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfileContents extends HashMap<String,List<String>> {	
	public ProfileContents(File profile) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(profile));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] ary = line.split(":");
				if(containsKey(ary[0]+":")){
					get(ary[0]+":").add(line.replaceAll(ary[0] + ":", ""));
				} else {
					put(ary[0]+":", new ArrayList<String>());
					get(ary[0]+":").add(line.replaceAll(ary[0] + ":", ""));
				}
			} 
			reader.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public String getName() {
		for(HashMap.Entry<String,List<String>> element : entrySet()) {
			if(element.getKey().equals("name:")) {
				return element.getValue().get(0);
			}
		}
		return "Error Loading Name";
	}
}
