package linkedlist;

public class FindNthNodeFromEndOfLinkedList_UsingTwoPointers<E> {

    private Node<E> head;

    public boolean add(E e){

        Node<E> node = new Node<E>(e);

        Node<E> tail = getTail();

        tail.next = node;

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

    public E findNthNodeFromEnd(int n){

        if(head == null){
            return null;
        }

        Node<E> ref = head;
        Node<E> pointer = head;

        for(int i=1; i<=n; i++){

            if(pointer == null){    // list is shorter than the asked index position
                return null;
            }
            pointer = pointer.next;
        }

        while(pointer != null){
            pointer = pointer.next;
            ref = ref.next;
        }

        return ref.e;
    }
}


