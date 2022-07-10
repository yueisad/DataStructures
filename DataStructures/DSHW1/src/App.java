
public class App {
   public static void main (String[] args) throws Exception {
BinaryNumber A = new BinaryNumber("1010");
BinaryNumber B = new BinaryNumber("0111");
System.out.println(A);
System.out.println(B);
System.out.println(A.getDigit(3));
System.out.println(B.getDigit(3));
A.shiftR(3);
B.shiftR(3);
System.out.println(A);
System.out.println(B);
A.add(B);
System.out.println(A);
System.out.println(A.toDecimal());
System.out.println(B.toDecimal());
}

}

