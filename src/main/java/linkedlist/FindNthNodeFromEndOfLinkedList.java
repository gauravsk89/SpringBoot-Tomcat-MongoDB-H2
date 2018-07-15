package linkedlist;

public class FindNthNodeFromEndOfLinkedList<E> {

    private Node<E> head;
    private int length = 0;

    public boolean add(E e){

        Node<E> node = new Node<E>(e);

        Node<E> tail = getTail();

        tail.next = node;
        length++;

        return true;
    }

    private Node<E> getTail(){

        if(head == null)
            return null;

        Node<E> node = head;

        while(node.next != null){
            node = node.next;
        }
        return node;
    }

    public int getLength(){
        return length;
    }

    public E findNthNodeFromEnd(int n){

        if(head == null){
            return null;
        }

        if(getLength() < n){
            return null;
        }

        int count = getLength() - n + 1;

        Node<E> node = head;

        while(count > 1){
            node = node.next;
            count--;
        }

        return node.e;
    }
}


