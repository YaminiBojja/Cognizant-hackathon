
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;
import java.io.FileNotFoundException;
import org.json.JSONObject;
public class Hackathon {

	public static void main(String[] args) throws IOException 
	{
		double[] a = new double[10000];
		JSONObject obj  = new JSONObject();
		JSONObject obj1 = new JSONObject();
		File fileIn1 = new File("E:\\Memory.txt");
		try (BufferedReader bf = new BufferedReader(new FileReader(fileIn1))) 
        {
            String readLine;
            double temp;
            //String str=readLine;
            int line = 0;
            int i=0;
            double sum=0.0;
            double max = 0.0;
            while ((readLine = bf.readLine()) != null) 
            {
                if (line % 2 != 0) {
                	//System.out.println(readLine);
                	String str=readLine;
                	str=str.replaceAll("[^0-9]","");
                    str=str.trim();
                    //str=str.replaceAll("+", "");
                    //System.out.println(str);
                    temp=Integer.parseInt(str);
                    //System.out.println(temp/10000);
                    a[i++]=temp/10000;
                    //sum=sum+temp;
                }
                line++;
            }
            String str1;
            for(int j=0;j<938;j++)
            {
            	str1 = String.format("%d",j);
            	obj1.put(str1 + "s", a[j]);
            	if(max<a[j])
            		max=a[j];
            	sum=sum+a[j];
            }
            //System.out.println(obj1);
            double average=sum/938;
            //System.out.println("AverageMemory(MB): " + average);
            //System.out.println("MaximumMemory(MB): " + max);
            DecimalFormat df = new DecimalFormat("#.###");
            df.setRoundingMode(RoundingMode.CEILING);
            obj.put("AverageMemory(MB)", df.format(average));
            obj.put("values: ", obj1);
            obj.put("MaximumMemory(MB)", df.format(max));
            System.out.println(obj);
         }
 }
}