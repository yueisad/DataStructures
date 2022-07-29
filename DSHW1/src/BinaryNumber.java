//CS570 - Alden Park 
//this is the big endian format which affects the adding function and toDecimal
//ask professor if this is okay

public class BinaryNumber {
	//variables
    private int data[];
	private boolean overflow;
    
	//constructors 
	public BinaryNumber(int length) throws Exception {
		try {
			data = new int[length];
			for (int i = 0; i < length; i++) {
				data[i] = 0;
			}
		}
		catch (NegativeArraySizeException na) {
			throw new Exception("Invalid, try again");
		}
	}
    //handle the strings and numbers
    public BinaryNumber(String str) throws Exception {
		data = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
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
        for (int i = 0; i < amount; i++) {
            shiftedData[i] = 0;
        }
        for (int j = 0; j < data.length; j++) {
            shiftedData[amount + j] = data[j];
        }
        //new array become the current array 
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
                total = getDigit(j)%10 + aBinaryNumber.getDigit(j) + carry;

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
        if (carry > 1){
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

}
