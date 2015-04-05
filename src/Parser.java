import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {
	public PhoneNumber parse(String arg0){
		PhoneNumber number=new PhoneNumber();
		//plus,minus or none
	    char code=arg0.charAt(0);
		if(code=='+' || code=='-')
			number.setPlusOrMinus(code);
		//check for hyphen or parentheses
		//parse numbers
		String [] arrayNumbers=arg0.split("\\D+");
		for(String el:arrayNumbers){
			//System.out.println("$$$ "+el+" $$$");
		}
		int counter=-1;
		int [][] mainPart=new int[3][];
		int [] areaCode=null;
		for(int i=arrayNumbers.length-1;i>=0;i--){
			//if main part
			if(arrayNumbers[i]!=""){
				counter++;
				if(counter<3){
					String [] arr=arrayNumbers[i].split("");
					mainPart[2-counter]=new int [arr.length];
					for(int j=0;j<arr.length;j++)
						mainPart[2-counter][j]=Integer.parseInt(arr[j]);
				}
				else{
					//if area code
					if(counter==3){
						String [] arr=arrayNumbers[i].split("");
						areaCode=new int [arr.length];
						for(int j=0;j<arr.length;j++)
							areaCode[j]=Integer.parseInt(arr[j]);
					}
					//if country code
					if(counter==4){
						number.setCountryCode(Integer.parseInt(arrayNumbers[i]));
					}
				}
			}
		}
		number.setMainPart(mainPart);
		number.setAreaCode(areaCode);
		System.out.println(number.toString());
		return number;
	}
	 public static boolean test(String testString,String pattern){ 
		 Pattern p = Pattern.compile(pattern);  
	     Matcher m = p.matcher(testString);  
	     return m.matches(); 
	 }
	 public ArrayList<PhoneNumber> accept(){
		 ArrayList<PhoneNumber> result=new ArrayList<>();
		 BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		 System.out.println("Enter number of strings");
		 int amount=0; 
		 try{
			 amount=Integer.parseInt(keyboard.readLine());
		 }catch(Exception e){
			 System.out.println("Enter valid data!");
		 }
		 for(int i=0;i<amount;i++){
			 System.out.println("Enter expression "+i);
			 String arg0=null;
			try {
				while (arg0==null || arg0.trim().length()==0){
					arg0 = keyboard.readLine();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			 System.out.println(arg0);
			 PhoneNumber pn=parse(arg0.trim());
			 System.out.println("Result "+pn);
			 result.add(pn);
		 }
		 return result;
		 
	 }
	 public ArrayList<PhoneNumber> accept(String path){
		 ArrayList<PhoneNumber> result=new ArrayList<>();
		 BufferedReader reader=null;
		 try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 String line=null;
		try {
			while((line=reader.readLine())!=null){
				 System.out.println(line);
				 PhoneNumber pn=parse(line.trim());
				 System.out.println("Result "+pn);
				 result.add(pn);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	 }
	 public static void main(String...strings){
		 Parser parser=new Parser();
		 System.out.println("Test from keyboard");
		 parser.accept();
		 System.out.println("Test from file");
		 parser.accept("phone.pos");
		 //parser.parse("+1 1234 12-34-56");
	 }
	        
}
