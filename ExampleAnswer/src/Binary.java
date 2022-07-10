public class Binary {
    public static void main(String args[]) {

    }
    
    public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2) {
    
    int l1=bn1.getLength()-1;
    
    int l2 =bn2.getLength()-1;
    
    int max = l1>l2 ?l1:l2;
    
    int val=0;
    
    int d[] =new int [max+1];
    
    while(l1>=0 && l2>=0) {
    
    if(bn1.getDigit(l1)==0 &&bn2.getDigit(l2)==0)val=0;
    
    if(bn1.getDigit(l1)==0 &&bn2.getDigit(l2)==1)val=1;
    
    if(bn1.getDigit(l1)==1 &&bn2.getDigit(l2)==0)val=1;
    
    if(bn1.getDigit(l1)==1 &&bn2.getDigit(l2)==1)val=1;
    
    d[max]=val;
    
    l1--;
    
    l2--;
    
    max--;
    
    }
    
    while(l1>=0) {
    
    d[max]=bn1.getDigit(l1);
    
    l1--;
    
    max--;
    
    }
    
    while(l2>=0) {
    
    d[max]=bn2.getDigit(l2);
    
    l2--;
    
    max--;
    
    }
    
    return d;
    
    }
    
    public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
    
    int l1=bn1.getLength()-1;
    
    int l2 =bn2.getLength()-1;
    
    int max = l1>l2 ?l1:l2;
    
    int val=0;
    
    int d[] =new int [max+1];
    
    while(l1>=0 && l2>=0) {
    
    if(bn1.getDigit(l1)==0 &&bn2.getDigit(l2)==0)val=0;
    
    if(bn1.getDigit(l1)==0 &&bn2.getDigit(l2)==1)val=0;
    
    if(bn1.getDigit(l1)==1 &&bn2.getDigit(l2)==0)val=0;
    
    if(bn1.getDigit(l1)==1 &&bn2.getDigit(l2)==1)val=1;
    
    d[max]=val;
    
    l1--;
    
    l2--;
    
    max--;
    
    }
    
    while(l1>=0) {
    
    d[max]=bn1.getDigit(l1);
    
    l1--;
    
    max--;
    
    }
    
    while(l2>=0) {
    
    d[max]=bn2.getDigit(l2);
    
    l2--;
    
    max--;
    
    }
    
    return d;
    
    }
}
