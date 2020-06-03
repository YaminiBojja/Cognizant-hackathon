import java.io.*;
import java.util.*;
import org.json.simple.*;

class Battery {
	public static void main(String args[]) {
		try {
			FileReader fr = new FileReader("F:\\NFTIntern-master\\Battery.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			JSONObject values = new JSONObject();
			String activities = null;
			Double drain = 0.0;
			while ((line = br.readLine()) != null) {
				if (line.contains("Foreground activities:")) {
					activities = line.replaceAll("    Foreground activities: ", "");
				}

				if (line.contains("Uid u0a202:")){
					StringTokenizer tokens = new StringTokenizer(line," ");
					int c = 0;
					while (tokens.hasMoreTokens()) {
						try{
							drain =  Double.valueOf(tokens.nextToken().trim()).doubleValue();
						}catch(Exception e){}
						c++;
						if(c==3)
							break;
					}
				} 
			}

			values.put("Foreground_time", activities);
			values.put("Battery_percentage",(drain / 1000));
			values.put("Battery_drain", drain);
			System.out.println(values);
			FileWriter file = new FileWriter("F:\\NFTIntern-master\\Batteryoutput.json");
			file.write(values.toJSONString());
			file.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
