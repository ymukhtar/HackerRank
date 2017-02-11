package datastructure;

/**
 * Created by yasir_mukhtar on 2/8/17.
 */
public class LinkedList {

    public static void main(String[] args) {
        MyLinkedList myLL = new MyLinkedList();
        myLL.addElement(1);
        myLL.addElement(2);
        myLL.addElement(3);
        myLL.addElement(4);
        myLL.addElement(5);
        myLL.print(myLL.head);
        System.out.println("------");
        myLL.reverseMe(myLL.head,myLL.head.next);
        myLL.print(myLL.head);
    }

    public static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class MyLinkedList{
        Node head;
        Node tail;

        public void addElement(int e){
            if(head==null){
                head = new Node(e);
                tail = head;
            }
            else{
                tail.next = new Node(e);
                tail = tail.next;
            }
        }

        public void print(Node head){
            Node temp = head;
            while(temp!=null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }

        public void reverseMe(Node a,Node b){
            if(b == null){
                head = a;
            }else {
                if(a == head){
                    a.next = null;
                }
                Node temp = b.next;
                b.next = a;
                reverseMe(b,temp);
            }
        }
    }
}
