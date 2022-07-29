//CS570 HW3 - Alden Park

public class IDLListTest {

    public static void main(String[] args) throws Exception {

        IDLList<Integer> list = new IDLList<Integer>();

        //add methods 
        list.add(0, 10);
        list.add(0, 4);
        list.add(1, 9);
        list.add(2, 7);
        list.add(3, 3);


        System.out.println("Number of elements in list: " + list.size());

        System.out.println("\nList contents: ");
        System.out.println(list +"\n");

        //get methods
        System.out.println("Get element at index 1: " + list.get(1));
        System.out.println("Get head: " + list.getHead());
        System.out.println("Get tail: " + list.getLast());

        //remove element method (false)
        System.out.println("\nRemove 11: " + list.remove(11)); //should be false for value not in list
        System.out.println("Number of elements in list: " + list.size());
        System.out.println(list);

        //remove element method (true)
        System.out.println("\nRemove 4: "+list.remove(4));
        System.out.println("Number of elements in list: " + list.size());
        System.out.println(list);

        //remove and return head element method
        System.out.println("\nRemove head: " + list.remove());
        System.out.println("Number of elements in list: " + list.size());
        System.out.println(list);

        //remove and return tail element method
        System.out.println("\nRemove tail: "+list.removeLast());
        System.out.println("Number of elements in list: "+list.size());
        System.out.println(list);

        //remove at method
        System.out.println("\nRemove index 1: " + list.removeAt(1));
        System.out.println("Number of elements in list: " + list.size());
        System.out.println(list);

        //empty list (0)
        System.out.println("\nRemove head: " + list.remove());
        System.out.println("Number of elements in list: " + list.size());
        System.out.println(list);

        //test case for adding element to index that has not been created
        System.out.println("Adding 3 to index 3 which has not been created");
        list.add(3, 3); //checking to add element to index that does not exist

        System.out.println("List contents: ");
        System.out.println(list);

        System.out.println("\nAdding 2 more elements");
        list.add(4);
        list.add(7);
        System.out.println("List contents: ");
        System.out.println(list);

    }
    
}
    
    