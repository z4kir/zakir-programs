import java.lang.reflect.Constructor;

public class MyLinkedList {
    Node head;
    Node tail;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;


        }
    }

    public void printMyLinkedList() {
        Node n = head;

        while (n != tail) {
            System.out.println(n.data);
            n = n.next;


        }
    }


    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        Node first = ll.new Node(10);
        ll.head = first;

        Node second = ll.new Node(20);
        first.next = second;
        Node third = ll.new Node(30);
        second.next = third;
        Node four = ll.new Node(40);
        third.next = four;
        ll.tail = four.next;
        ll.printMyLinkedList();


    }

}
