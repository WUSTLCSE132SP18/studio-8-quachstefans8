package studio8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// TODO: Develop an algorithm to count steps in accelerometer data
//    Major steeps:
//       1. Create a class and main method.
//       2. Using a Scanner and File object, read data from your .csv file.
//       3. Develop and test algorithms to count the "peaks" in the data.
public class CountSteps {
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\stefa\\git\\studio-8-quachstefans8\\data\\data.csv");
		Scanner inputStream = new Scanner(file);
		List<double[]> data = new ArrayList<double[]>();
		int peaks[] = new int[3]; //peaks in x,y,z
		
		//Storing all the data into an ArrayList
		while(inputStream.hasNext()) {
			String input = inputStream.nextLine();
			String[] xyz = input.split(",");
			double[] trueData = new double[3];
			int index = 0;
			for(String s: xyz) {
				trueData[index] = Double.parseDouble(s);
				index++;
			}
			data.add(trueData);
			
		}
		
		//counting peaks
		for(int i=1; i<data.size()-1; i++) {
			double[] prev=data.get(i-1);
			double[] curr=data.get(i);
			double[] next=data.get(i+1);
			for(int j=0; j<3; j++) { //peaks[]
				if(curr[j] > prev[j] && curr[j] < next[j]) {
					peaks[j]++;
					
				}
				
			}
		}
		System.out.println("x peaks: "+ peaks[0]+ "\t y peaks: " + peaks[1]+ "\t z peaks: "+ peaks[2]);
	}
}