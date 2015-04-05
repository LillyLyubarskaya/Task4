
public class PhoneNumber {
	private int [][] mainPart;
	private int [] areaCode;
	private int countryCode;
	private char plusOrMinus='\0';
	int[][] getMainPart() {
		return mainPart;
	}
	void setMainPart(int[][] mainPart) {
		this.mainPart = mainPart;
	}
	int[] getAreaCode() {
		return areaCode;
	}
	void setAreaCode(int[] areaCode) {
		this.areaCode = areaCode;
	}
	int getCountryCode() {
		return countryCode;
	}
	void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	char getPlusOrMinus() {
		return plusOrMinus;
	}
	void setPlusOrMinus(char plusOrMinus) {
		this.plusOrMinus = plusOrMinus;
	}
	private String toStringArray(int [] arr){
		StringBuilder sb=new StringBuilder();
		for(int i:arr)
			sb.append(""+i);
		return sb.toString();
	}
	public String toString(){
		StringBuilder sb=new StringBuilder();
		if(plusOrMinus!='\0')
		    sb.append(plusOrMinus);
		if(countryCode!=0)
		    sb.append(countryCode);
		if (areaCode!=null)
			sb.append(" "+toStringArray(areaCode));
		for(int i=0;i<3;i++)
			if(mainPart[i]!=null)
				sb.append(" "+toStringArray(mainPart[i]));
		return sb.toString();
	}

}
