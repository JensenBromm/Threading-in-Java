import java.util.ArrayList;

public class Discover implements Runnable{
	private String line;
	private String org;
	
	public Discover(String line)
	{
		this.line=line;
		this.org=line;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		ArrayList<String> pass=new ArrayList<String>();
		String word;
		int index;

		while(line.indexOf(" ")!=-1)
		{
			index=line.indexOf(" ");
			word=line.substring(0, index);
			if(!toDigit(word).equals(word))
			{
				word=toDigit(word);
				pass.add(word);
			}
			else if(!Character.isUpperCase(word.charAt(0)))
			{
				pass.add(word.substring(0, 1));
			}

			line=line.substring(index);
			line=line.trim();
		}
		
		word=line.trim();
		if(!toDigit(word).equals(word))
		{
			word=toDigit(word);
			pass.add(word);
		}
		else if(!Character.isUpperCase(word.charAt(0)))
		{
			pass.add(word.substring(0, 1));
		}
		
		checkPass(pass);

		
	}
	public String toDigit(String num)
	{
		if(num.equalsIgnoreCase("one"))
		{
			return "1";
		}
		else if(num.equalsIgnoreCase("two"))
		{
			return "2";
		}
		else if(num.equalsIgnoreCase("three"))
		{
			return "3";
		}
		else if(num.equalsIgnoreCase("four"))
		{
			return "4";
		}
		else if(num.equalsIgnoreCase("five"))
		{
			return "5";
		}
		else if(num.equalsIgnoreCase("six"))
		{
			return "6";
		}
		else if(num.equalsIgnoreCase("seven"))
		{
			return "7";
		}
		else if(num.equalsIgnoreCase("eight"))
		{
			return "8";
		}
		else if(num.equalsIgnoreCase("nine"))
		{
			return "9";
		}
		else
		{
			return num;
		}
	}

	public boolean containsNum(String test)
	{
		if(test.equals("1") || test.equals("2") || test.equals("3") || test.equals("4") || test.equals("5") || test.equals("6") || test.equals("7") || test.equals("8") || test.equals("9"))
			return true;
		else
			return false;
	}
	
	public void checkPass(ArrayList<String> pass)
	{
		boolean isValidFront=false;
		boolean isValidBack=false;
		boolean hasNum=false;
		
		//Base Case
		if(pass.size()<6)
		{
			System.out.println("Discover-Section 3 is: "+org+ "-Password: " +pass.toString()+" INVALID");
			return;
		}
		
		if(!Character.isLetter(pass.get(0).charAt(0)))
		{
			isValidFront=false;
			//test back half
			if(Character.isLetter(pass.get(pass.size()).charAt(0))) {
				for(int i=pass.size()-1;i>pass.size()-6;i--)
				{
					if(containsNum(pass.get(i)))
					{
						hasNum=true;
						isValidBack=true;
					}
				}
			}
			else
				isValidBack=false;
		}
		else
		{
			//check front half
			for(int i=0;i<6;i++)
			{
				if(containsNum(pass.get(i)))
				{
					hasNum=true;
					isValidFront=true;
				}
			}
			
			if(!isValidFront)
			{
				for(int i=pass.size()-1;i>pass.size()-7;i--)
				{
					if(containsNum(pass.get(i)))
					{
						hasNum=true;
						isValidBack=true;
					}
				}
			}
		}
		
		if(isValidFront)
		{
			StringBuilder s=new StringBuilder();
			for(int i=pass.size()-1;i>pass.size()-6;i--)
			{
				s.append(pass.get(i));
			}
			System.out.println("Discover-Section 3 is: "+org+ "-Password: "+s);
	
		}
		else if(isValidBack)
		{
			StringBuilder s=new StringBuilder();
			for(int i=pass.size()-1;i>pass.size()-6;i--)
			{
				s.append(pass.get(i));
			}
			System.out.println("Discover-Section 3 is: "+org+ "-Password: "+s);
		}
		else
			System.out.println("Discover-Section 3 is: "+org+ "-Password: " +pass.toString()+" INVALID");
		
	
		
		
		
	}

}
