//CS570 - Alden Park 
//this is the big endian format which affects the adding function and toDecimal
//ask professor if this is okay

public class BinaryNumber {
	//variables
    private int data[];
	private boolean overflow;
    
	//constructors 
	public BinaryNumber(int length) throws Exception {
        data = new int[length];
        if (length < 0) {
            throw new Exception ("this number is negative");
        }
        for (int i = 0; i < length; i++) {
            data[i] = 0;
        }
	}

    //handle the strings and numbers
    public BinaryNumber(String str) throws Exception {
		data = new int[str.length()];
        if(!(str instanceof String)) {
            throw new Exception("please enter a string");
        }
        for (int i = 0; i <= str.length()-1; i++) {
            int num = Character.getNumericValue(str.charAt(i));
            if (num > 1 || num < 0) {
            	throw new Exception("Enter valid binary numbers 1 or 0");
            }
            data[i] = num;
        }
	}

    //get operations 
    public int getLength() {
        return data.length;
    }
    
    //it should handle the negative index 
    public int getDigit(int index) throws Exception {
        try {
            return data[index];
        }
        catch (IndexOutOfBoundsException iob){
            throw new Exception(iob.getMessage());
        }
    }
    
    //shiftR operation 
    public void shiftR(int amount) throws Exception {
        //create a temporary new array 
        int[] shiftedData = new int[data.length + amount];
        if (amount < 0) {
            throw new Exception ("enter non-negative amount");
        }
        for (int i = 0; i < amount; i++) {
            shiftedData[i] = 0;
        }
        for (int i = 0; i < data.length; i++) {
            shiftedData[amount + i] = data[i];
        }
        data = shiftedData;
    }

    //adding binary number operation
    public void add(BinaryNumber aBinaryNumber) throws Exception {
        
        int [] newArray = new int[data.length];
        int carry = 0; 
        int total = 0; 
        
        if (aBinaryNumber.getLength() != data.length) {
            throw new Exception("The binary numbers are not the same length");
        }
        else {
            for (int j = data.length -1; j >= 0; j--) {
                total = getDigit(j) + aBinaryNumber.getDigit(j) + carry;

                if (total == 2) {
                    carry = 1;
                    newArray[j] = 0;
                }

                else if (total == 3) {
                    carry = 1; 
                    newArray[j] = 1;
                }

                else if (total <= 1) {
                    carry = 0; 
                    newArray [j] = total;
                }
            }
        }
        if (carry >= 1){
            overflow = true; 
        }
        else {
            overflow = false;
        }
        data = newArray;
    }
    
    //to string operation
    public String toString() {
        String str = "";
        if (overflow == true) {
            System.out.println("Overflow");
        }
        else {
            for (int i = 0; i < data.length; i++) {
                str += data[i];
            }
        }
        return str;
    }

    //decimal conversion operation
    public int toDecimal() throws Exception {
        int num = 0; 
        int total = 0;

        for (int i = 0; i < data.length; i++) {
            num = getDigit(data.length - i - 1);
            total += num * Math.pow(2, i);
        }
        return total;
        
    }

    //clear overflow
    public void clearOverflow() {
        overflow = false;
    }


    //main function
    public static void main (String[] args) throws Exception {
		System.out.println("\nPlease note this is in big-endian format\n");
    
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
