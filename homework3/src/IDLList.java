//CS570 HW3 - Alden Park

import java.util.ArrayList;

public class IDLList<E> {
    private class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        public Node(E elem) {
            data = elem;
            next = null;
            prev = null;
        }

        public Node(E elem, Node<E> prev, Node<E> next) {
            data = elem;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;
    private ArrayList<Node<E>>indices;

    public IDLList() {
        head = null; 
        tail = null; 
        size = 0;
        indices = new ArrayList<Node<E>>();
    }


    public boolean add(int index, E elem) {
        if (size == 0) {
            System.out.println("List is empty, creating new head at index 0");
            index = 0; 
        }
        if (index >= 0 && index <= size) {
            if (index == 0) {
                add(elem);
            }
            else if(index == size) {
                append(elem);
            }
            else {
                Node<E> curr = indices.get(index);
                Node<E> node = new Node<E>(elem, curr.prev, curr);
                node.prev.next = node;
                curr.prev = node;
                indices.add(index, node);
                indices.set(index - 1, node.prev);
                indices.set(index + 1, curr);
                size ++;
            }
            return true;
        }
        return false;
    }

    public boolean add(E elem) {
        Node<E>node = new Node<E>(elem, null, head);
        
        if(head == null) {
        tail = node;
        }

        else {
            head.prev = node;
            indices.set(0,head);
        }

        head = node;
        indices.add(0, node);
        size++;
        return true;
    }


    public boolean append(E elem) {
        Node<E>node = new Node<E>(elem, tail,null);
        tail.next = node;
        indices.set(size-1, tail);
        tail = node; 
        indices.add(node);
        size++;
        return true;
    }

    public E get(int index) {
        if (index >= 0 && index < size) {
            return indices.get(index).data;
        } 
        else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public E getHead() {
        if(size > 0) {
            return head.data;
        }
        else {
            throw new IllegalStateException("List is empty");
        }
    }

    public E getLast() {
        if (size > 0) {
            return tail.data;
        }
        else {
            throw new IllegalStateException("List is empty");
        }
    }

    public int size() {
        return size;
    }
    
    public E remove() {
        if (size > 0){
            E data = head.data;
            head = head.next;
            size --;
            indices.remove(0);

            if(head != null) {
                head.prev = null;
                indices.set(0, head);
            } else {
                tail = null;
            }
            return data; //check this part
        } else {
            throw new IllegalStateException("List is empty");
        }   
    }

    public E removeLast() {
        if (size > 0){ 
            E data = tail.data;
            tail = tail.prev;
            size--;
            indices.remove(size);

            if (tail!= null) {
                tail.next=null;
                indices.set(size - 1, tail);
            }
            else {
                head = null;
            }
            return data;
        } else {
            throw new IllegalStateException("List is empty");
        }
    }

    public E removeAt(int index) {
       if (index >= 0 && index < size) {
        if (index == 0) {
            return remove();
        } 
        else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> node = indices.get(index);
            indices.remove(index);
            indices.get(index).prev = node.prev;
            indices.get(index-1).next = node.next;
            node.next = null;
            node.prev = null;
            size--;
            return node.data;
        }

        } else {
            throw new IndexOutOfBoundsException("List out of bounds");
        }   
    }

    public boolean remove(E elem) {
        Node<E> curr = head;
        int curr_index = 0;

        while(curr != null) {
            if (curr.data.equals(elem)) {
                break; 
            }
            curr = curr.next;
            curr_index ++;
        }
        if (curr == null) {
            return false;
        } else {
            removeAt(curr_index);
            return true;
        }
    }
    
    
    public String toString() {
        String str = "";
        Node<E>curr = head;

        while(curr!=null) {
            str += curr.data.toString();
            if (curr!=tail) {
                str += "|";
            }
            curr = curr.next;
        }
        return str;
    }
    
}
