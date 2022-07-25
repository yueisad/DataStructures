//CS570 - Alden Park 

public class Complexity {
    
public static void method0 (int n) throws Exception { 
    int counter = 0; 
    for (int i=0; i<n; i++) {
        System.out.println("Operation " + counter); 
        counter++; 
    }
    System.out.println("Operations done: " + counter);
    }


public static void method1 (int n) throws Exception { 
    if (n <= 0) {
        throw new Exception("This number is negative"); 
    }
    int counter = 0; 
    for (int i = 0;  i<n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println("operation " + counter); 
            counter++;
        }
    }
    System.out.println("Operations done: " + counter);
}

public static void method2 (int n) throws Exception {
    if (n <= 0) {
        throw new Exception("This number is negative"); 
    }
    int counter = 0;
    for (int i = 0; i<n; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k<n; k++) {
                System.out.println("operation " + counter); 
                counter++;
            }
        }
    }
    System.out.println("Operations done: " + counter);
}

public static void method3 (int n) throws Exception {
    if (n <= 0) {
        throw new Exception("This number is negative or 0"); 
    }
    int counter = 0;
    for (int i = 1; i<n; i = i * 2) {
        System.out.println("operation " + counter);
        counter ++;
    }
    System.out.println("Operations done: " + counter);
}

public static void method4 (int n) throws Exception {
    if (n <= 0) {
        throw new Exception("This number is negative or 0"); 
    }
    int counter = 0;
    for (int i = 1; i<=n; i++) {
        for (int j = 1; j < n; j = j * 2) {
            System.out.println("operation " + counter);
            counter++;
        }
    }
    System.out.println("Operations done: " + counter);
}

public static void method5 (int n) throws Exception {
    if (n <= 0) {
        throw new Exception("This number is negative or 0"); //instead, you can also print the statement that the number is negative
    }
    int counter = 0;
    for (int i = 2; i<n; i = (int)Math.pow(i,2)) { 
        System.out.println("Operation " + (Math.pow(i,2) - i));
        counter++;
    }
    System.out.println("Operations done: " + counter);
}

//extra credit question:
public static void method6 (int n) throws Exception {
    if (n <= 0) {
        throw new Exception("This number is negative or 0"); 
    }
    if (n <= 0) return;
    int counter = 0; 
    for (int i = 0; i < (int)Math.pow(2, n); i++) {
        System.out.println("Operation " + (Math.pow(2, n) - i));
        counter++; 
    }
    System.out.println("Operations done: " + counter);
} 



//testing methods 
public static void main(String[] args) throws Exception {
   

    System.out.println("This is method 0");
    method0(3); // n

    System.out.println();

    System.out.println("This is method 1");
    method1(3); // n^2

    System.out.println();

    System.out.println("This is method 2");
    method2(3); // n^3

    System.out.println();

    System.out.println("This is method 3");
    method3(16); // logn

    System.out.println();

    System.out.println("This is method 4");
    method4(8); // nlogn

    System.out.println();

    System.out.println("This is method 5");
    method5(256); // loglogn 
   
    System.out.println();

    System.out.println("This is method 6");
    method6(2); // 2^n

    System.out.println();
}

}
