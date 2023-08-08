
public class Person implements Runnable {
	public String line;
	public String org;
	public String fName="";
	public String lName="";
	public String mInital="";
	
	public Person(String s)
	{
		this.line=s;
		this.org=line;
	}
	@Override
	public void run() {
		String key;
		String cut;
		int index;
			
			for(int i=0;i<3;i++)
			{
			
				//get the key (M,F,L)
				
				if(line.length()<=0)
				{
					
					break;
				}
				
				key=line.substring(0, 1);
				//get the name
				line=line.substring(1);
				index=line.indexOf(" ");
				
				if(index<0)
				{
					index=line.length();
				}
				cut=line.substring(0, index);
				line=line.substring(index).trim();
				//System.out.println(key+ " "+ cut);
				
				if(key.equals("F"))
				{
					fName=cut;
				}
				else if(key.equals("M"))
				{
					mInital=cut;
				}
				else if(key.equals("L"))
				{
					lName=cut;
				}
				
			}
			
	
			
			//Print and get unknowns
			if(fName.equals(""))
			{
				fName="Unknown";
			}
			
			if(lName.equals(""))
			{
				lName="Unknown";
			}
			
			if(mInital.equals(""))
			{
				mInital="Unknown";
			}
			
			System.out.println("Person-Section 1 is: "+org+" -Last Name:"+lName+ " First Name:"+ fName+" MI:"+mInital);

			
		
	}

}
