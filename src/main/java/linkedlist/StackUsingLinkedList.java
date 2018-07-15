package linkedlist;

public class StackUsingLinkedList<E> {

    Node<E> head;

    public E push(E e){

        Node<E> node = new Node<E>(e);

        if(head == null){
            head = node;
        }else{
            node.next = head;
            head = node;
        }

        return e;
    }

    public E pop(){

        E e = null;

        if(head == null){
            return null;
        }else{
            Node<E> node = head;
            head = head.next;
            return node.e;
        }

    }

    public void print(){

        if(head == null){
            return;
        }

        Node<E> node = head;

        while(node != null){

            System.out.print(node.e + " ");

            node = node.next;
        }
    }

}

class Node<E> {

    E e;

    Node<E> next;

    Node(E e){
        this.e = e;
    }

}
