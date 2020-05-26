import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
	public static void main(String[] args) throws IOException {
		File file = new File("E:\\Memory.txt");
		ArrayList<Float> l = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		JSONObject memory = new JSONObject();
		JSONObject maxValue = new JSONObject();
		JSONObject avgValue = new JSONObject();

		String st;
		int i = 1;
		while ((st = br.readLine()) != null) {
			String data = br.readLine().split("TOTAL:   ")[1].split("       ")[0];
			float value = Float.parseFloat(data) / 1000;
			//System.out.println(value);
			String index = i + "s";
			memory.put(index, value);
			l.add(value);
			i++;
			
		}
		float avg = 0;
		
		for(int j=0; j<l.size(); j++){
			avg += l.get(j);
		}
		avg = avg/l.size();
		//System.out.println("end of while");
		avgValue.put("AverageMemory(MB)", avg);
		maxValue.put("MaxMemory(MB)", Collections.max(l));
		JSONObject valuesObject = new JSONObject();
		valuesObject.put("values", memory);

		JSONArray valuesList = new JSONArray();
		valuesList.add(avgValue);
		valuesList.add(valuesObject);
		valuesList.add(maxValue);
		
		

		FileWriter fw = new FileWriter("E:\\output.json");
		fw.write(valuesList.toJSONString());
		fw.flush();
		//System.out.println("End of the program");
	}
}

