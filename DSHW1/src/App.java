//testing out binary class functions:

public class App {
	
	public static void main (String[] args) throws Exception {
		
		//constructors + getters for the binary numbers 
		BinaryNumber A = new BinaryNumber("10110");		//change 
		System.out.println("Binary A = " + A);
		//see length
		System.out.println("Length of binary: "+ A.getLength()); 
		//get digit
		System.out.println("In binary A, the digit is : " + A.getDigit(2)); //get digit at the index location (change value)
		//get decimal
		System.out.println("Binary to decimal form: " + A.toDecimal());
		//shift test
		A.shiftR(2);	//change 
		System.out.println("SHIFTED: " + A);
		
		
		//spacing
		System.out.println("\n");
		
		//duplicate tests for second binary
		BinaryNumber B = new BinaryNumber("11100");		//change
		System.out.println("Binary B = " + B);
		System.out.println("Length of binary: "+ B.getLength()); 
		System.out.println("In binary A, the digit is : " + B.getDigit(1)); 		//get digit at index location
		System.out.println("Binary to decimal form: " + B.toDecimal());
		B.shiftR(2);		
		System.out.println("SHIFTED: " + B);
		
		//spacing
		System.out.println("\n");
		
		//adding the binary numbers
		A.add(B);
		System.out.println("The new total: " + A);
		
		System.out.println("New total decimal form: " + A.toDecimal());
		
	}

}
