import java.util.Arrays;

public class BinaryNumber2 {

    private int digits[];
    private boolean overFlow = false;

    public BinaryNumber2(int n) {
        digits = new int[n];
    }

    public BinaryNumber2(String r) {
        digits = new int[r.length()];
        
        for(int i=0; i<r.length(); i++) {
            digits[i] = r.charAt(i) - '0';
        }
    }

    public int getLength() {
        return digits.length;
    }

    public int toDecimal() {
        int w = 1;
        int value = 0;

        for (int c : digits) {
            value += c * w;
            w *= 2;
        }
        return value;
    }

    public int getDigit(int index) {
        return digits[index];
    }

    void shiftR(int amount) {
        
        int temp[] = Arrays.copyOf(digits, digits.length + amount);
        
        for(int i=temp.length-1; i>=amount; i--) {
            temp[i] = digits[i-amount];
        }
        for(int i=0; i<amount; i++) {
            temp[i] = 0;
        }
        
        digits = temp;
    }

    void add(BinaryNumber2 aBinaryNumber) {
        if (getLength() != aBinaryNumber.getLength()) {
            System.out.println("Lengths of numbers to be added is not same.");
        } else {
            int carry = 0;

            for (int i = 0; i < digits.length; i++) {
                int s = carry + getDigit(i) + aBinaryNumber.getDigit(i);

                if (s >= 10) {
                    s = s - 10;
                    carry = 1;
                } else {
                    carry = 0;
                }

                digits[i] = s;
            }

            if (carry != 0) {
                overFlow = true;
            }
        }
    }

    public void clearOverflow() {
        overFlow = false;
    }

    @Override
    public String toString() {
        if (overFlow) {
            return "Overflow";
        }
        String s = "";
        for(int x: digits) {
            s += x;
        }
        return s;
    }
}
