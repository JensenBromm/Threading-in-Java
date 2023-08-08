import java.util.ArrayList;

public class Scores implements Runnable {

	private String line;
	private String org;
	private double standDev;
	private double avg;
	
	public Scores(String line)
	{
		this.line=line;
		this.org=line;
	}
	@Override
	public void run() {
		ArrayList<Integer> intList=new ArrayList<Integer>();
		int sum=0;
		int xSquaredTotal=0;
		
		
		//Split the line at the commas
		while(line.indexOf(",")!=-1)
		{
			int index=line.indexOf(",");
			String numString=line.substring(0,index);
			
			//Trim the used number out of the line
			line=line.substring(index+1);
			line=line.trim();

			//Add number to integer list
			intList.add(Integer.parseInt(numString));
		}
		
		//Add last number to integer list
		intList.add(Integer.parseInt(line));
		
		//Find the sum and the Squared sum
		for(int i=0;i<intList.size();i++) {
			sum +=intList.get(i);
			xSquaredTotal+=Math.pow(intList.get(i), 2);
			
		}
		
		//Calculate Standard Deviation
		avg=sum/intList.size();
		double overN=1./intList.size();
		standDev=Math.sqrt((overN*xSquaredTotal)-Math.pow(avg, 2));
		

		//Check for outliers
		ArrayList<Integer> outliers=new ArrayList<Integer>();
		for(int i=0;i<intList.size();i++)
		{
			if(intList.get(i)>(standDev*1.9))
			{
				outliers.add(intList.get(i));
			}
		}
		
		System.out.println("Socres- Section 2 is: "+org+ " Average: "+avg+" SD: "+standDev+" Outliers: "+outliers.toString());
		
	}

}
