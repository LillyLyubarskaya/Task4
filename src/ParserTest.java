import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


public class ParserTest {
 Parser parser=new Parser();
	@Test
	public void testParse() {
		//8 (913) 648 82 64
		PhoneNumber n=new PhoneNumber();
		n.setAreaCode(new int []{9,1,3});
		n.setMainPart(new int [][]{{6,4,8},{8,2},{6,4}});
		n.setCountryCode(8);
		n.setPlusOrMinus('+');
		PhoneNumber res=parser.parse("8 (913) 648 82 64");
		assertTrue(Arrays.equals(n.getAreaCode(), res.getAreaCode()) && n.getCountryCode()==res.getCountryCode()&& Arrays.deepEquals(n.getMainPart(), res.getMainPart()) );
		
	}

	
}
