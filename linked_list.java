public class linked_list{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void addfirst(int data){
        // Step1 - create a new node
        Node newNode = new Node(data);
        // size increse
        size ++;
        // if Linkedlist is empty
        if(head == null){
            head = tail = newNode;
            return;
        }
        // step2 - assign head value in newnode next
        newNode.next = head;
        // step3 - Initiliaze new node as head
        head = newNode;
    }
    public void addlast(int data){
        // step 1 - create a new node
        Node newnoode = new Node(data);
        // if Linked list is empty
        // size increse
        size ++;
        if(head == null){
            head = tail = newnoode;
            return;
        }
        tail.next = newnoode;
        tail = newnoode;
    }
    public void addmiddle(int data , int ind){   // ind - index
        // step  - linked list is empty or index 0
         if(ind == 0){
            addfirst(data);
            return;
         }
         // step 1 - create a new node
         Node newnide = new Node(data);
         // size increse
         size ++;
         Node temp = head;
         int i = 0;
         
         while(i<ind-1){   // we run loop while previous index
            temp = temp.next;
            i++;
         }
         newnide.next = temp.next;  // we store next node address in new node
         temp.next = newnide;  // we insert node at specific index
    } 
    public void printllist(){
        // if linked list is empty
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public static void main(String args[]){
        linked_list ll = new linked_list();
        ll.printllist();
        System.out.println("Size of linked list is "+ll.size);
        ll.addfirst(0);
        ll.printllist();
        System.out.println("Size of linked list is "+ll.size);
        ll.addfirst(3);
        ll.printllist();
        System.out.println("Size of linked list is "+ll.size);
        ll.addlast(6);
        ll.printllist();
        System.out.println("Size of linked list is "+ll.size);
        ll.addlast(8);
        ll.printllist();
        System.out.println("Size of linked list is "+ll.size);
        ll.addmiddle(14, 1);
        ll.printllist();
        System.out.println("Size of linked list is "+ll.size);
        ll.addmiddle(15, 3);
        ll.printllist();
        System.out.println("Size of linked list is "+ll.size);
        ll.addmiddle(2, 0);
        ll.printllist();
        System.out.println("Size of linked list is "+ll.size);
    }
}