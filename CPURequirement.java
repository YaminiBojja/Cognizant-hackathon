import java.io.*;
import java.util.*;
import org.json.simple.*;
class CPURequirement {
	public static void main(String args[]) {
		try {
			FileReader fr = new FileReader("F:\\Hackathon\\NFTIntern-master\\CPU.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			int i = 1;
			float sum = 0;
			float maximum = 0;

			JSONObject values = new JSONObject();
			JSONObject finaljson = new JSONObject();
			JSONObject sampletransaction = new JSONObject();
			JSONArray finalarray = new JSONArray();
			while ((line = br.readLine()) != null) {
				String splitvalues[] = line.split("\\s+");
				float finalval = Float.parseFloat(splitvalues[8]);
				if (finalval > maximum)
					maximum = finalval;
				sum = sum + finalval;
				String seconds = i + "s";
				values.put(seconds, splitvalues[8].toString());
				i++;
			}
			float average = (float) sum / i;
			finaljson.put("values", values);
			finaljson.put("maxcpu", (String.format("%.2f", maximum)));
			finaljson.put("avgcpu", (String.format("%.2f", average)));
			sampletransaction.put("sampletransaction", finaljson);
			finalarray.add(sampletransaction);
			System.out.println(finalarray);
			FileWriter file = new FileWriter("F:\\Hackathon\\NFTIntern-master\\CPUoutput.json");
			file.write(finalarray.toJSONString());
			file.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
