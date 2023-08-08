import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Driver {

	public static void main(String[] args) {
		// get ability to read file
		try {
			File inFile=new File("A:\\Code\\Eclipse Projects\\OS_Assignment1\\src\\InputTXT");
			Scanner reader=new Scanner(inFile);
			
			//Read line and split string among three sections
			String line;
			ArrayList<String> arr=new ArrayList<String>();
			int index;
			int j=0;
			
			//Reads all lines splits them based on the $ and then adds them to the array
			while(reader.hasNextLine()) {
				line=reader.nextLine();
				while(j<3)
				{
					
					index=line.indexOf("$");
					if(index==-1)
					{
						break;
					}
					arr.add(line.substring(0, index));
					line=line.substring(index+1);
					j++;
				}
				j=0;
			}
			//Trim all so there are no spaces in the front
			for(int k=0;k<arr.size();k++)
			{
				arr.set(k, arr.get(k).trim());
			}
			
			//Create different arrays for each thread
			ArrayList<String> sec1=new ArrayList<String>();
			ArrayList<String> sec2=new ArrayList<String>();
			ArrayList<String> sec3=new ArrayList<String>();
			String test;
			
			//Add lines to the correct list
			for(int k=0;k<arr.size();k++)
			{
				test=arr.get(k);
				
				if(test.charAt(0)=='*' && test.charAt(1)!='*') {
					sec1.add(test);
				}
				else if (test.charAt(0)=='*' && test.charAt(1)=='*' && test.charAt(2)!='*')
				{
					sec2.add(test);
				}
				else if (test.charAt(0)=='*' && test.charAt(1)=='*' && test.charAt(2)=='*' && test.charAt(3)!='*') 
				{
					sec3.add(test);
				}
			}
			
			//Remove Stars and extra space
			for(int k=0;k<sec1.size();k++) {
				test=sec1.get(k);
				test=test.substring(1);
				test=test.trim();
				sec1.set(k, test);
				//System.out.println(test);
			}
			
			System.out.println();
		
			for(int k=0;k<sec2.size();k++) {
				test=sec2.get(k);
				test=test.substring(2);
				test=test.trim();
				sec2.set(k, test);
				//System.out.println(test);
			}
			System.out.println();
			for(int k=0;k<sec3.size();k++) {
				test=sec3.get(k);
				test=test.substring(3);
				test=test.trim();
				sec3.set(k, test);
				//System.out.println(test);
			}
			System.out.println();
			
			Thread personThread;
			Thread scoreThread;
			Thread discoverThread;
			
			
			for(int i=0;i<sec1.size();i++) {
				personThread=new Thread(new Person(sec1.get(i)));
				personThread.start();
			}
			for(int i=0;i<sec2.size();i++)
			{
				scoreThread=new Thread(new Scores(sec2.get(i)));
				scoreThread.start();
			}

			for(int i=0;i<sec3.size();i++)
			{
				discoverThread=new Thread(new Discover(sec3.get(i)));
				discoverThread.start();
			}
			
			
		
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	
	}

}
