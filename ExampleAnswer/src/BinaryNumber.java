public class BinaryNumber {
    private int data[];

private int length;

public BinaryNumber(int length) {

data = new int [length];

this.length=length;

for (int i=0;i<length ;i++) {

data[i] = 0;

}

}

public BinaryNumber(String str) {

this.length=str.length();

data = new int [length];

for (int i=0;i<length ;i++) {

data[i] = str.charAt(i)-'0';

}

}

public int getLength() {

return this.length;

}

public int getDigit(int index) {

if(index < this.length)return data[index];

else return -1;

}

public int[] getInnerArray() {

return data;

}

public void bitShift(int direction, int amount) {

if(direction == -1) {

for (int i=0;i<length-amount ;i++)

data [i]=data[i+amount];

for (int i=amount ;i<length ;i++)

data [i]=0;

}

if(direction == 1) {

for (int i=0;i<length-amount ;i++)

data [i+amount]=data[i];

for (int i=0 ;i<amount ;i++)

data [i]=0;

}

}

public void add(BinaryNumber aBinaryNumber) {

int carry =0,sum;

int l1=this.length-1;

int l2 =aBinaryNumber.length-1;

while(l1>=0 &&l2>=0) {

sum=(this.data[l1]+aBinaryNumber.data[l2]+carry);

this.data[l1]=sum%2;

carry=sum/2;

l1--;

l2--;

}

while(l1>=0) {

sum=(this.data[l1]+carry);

this.data[l1]=sum%2;

carry=sum/2;

l1--;

}

}

public String toString() {

String str ="";

for (int i=0;i<length ;i++)

str+=data[i];

return str;

}

public int toDecimal() {

int total=0;

for(int i=0; i<length ;i++) {

total +=data[i]*Math.pow(2,length-i-1);

}

return total;

}
}
