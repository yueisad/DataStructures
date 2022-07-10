//CS570 - Alden Park 

public class BinaryNumber {

    private int data[];
	private boolean overflow;
    

	public BinaryNumber(int length) {
		data = new int[length];
        for (int i = 0; i < length; i++) {
            data[i] = 0;
        }
	}

    public BinaryNumber(String str) {
		data = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int num = Character.getNumericValue(str.charAt(i));
            data[i] = num;
        }
	}

    public int getLength() {
        return data.length;
    }

    public int getDigit(int index) throws Exception {
        try {
            return data[index];
        }
        catch (IndexOutOfBoundsException iob){
            throw new Exception(iob.getMessage());
        }
    }

    public void shiftR(int amount) {
        //create a temp new array 
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

    public int toDecimal() throws Exception {
        int num = 0; 
        int total = 0;

        for (int i = 0; i < data.length; i++) {
            num = getDigit(data.length - i -1);
            total += num * Math.pow(2, i);
        }
        return total;
        
    }

    public void clearOverflow() {
        overflow = false;
    }

}
