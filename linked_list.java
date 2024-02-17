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
         size++;
         
         Node temp = head;
         int i = 0;
         
         while(i<ind-1){   // we run loop while previous index
            temp = temp.next;
            i++;
         }
         newnide.next = temp.next;  // we store next node address in new node
         temp.next = newnide;  // we insert node at specific index
    } 
    public void delfirst(){
        if(head == null){
            return;
        }
        else if(size == 1){
            head = head.next;
            head = tail = null;
            size--;
            
        }
        head = head.next;
        size--;
    }
    public void dellast(){
        if(head == null){
            return;
        }
        else if(size == 1){
            head = tail = null;
            size--;
        }
        // previous of tail is = size-2
        Node temp = head;
        for(int i=0;i<size-2;i++){
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
    }
    public void delnthfromend(int n){
        // calculatesize
        int sz = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }
        if(n == sz){
            head = head.next; // removefirst
            return;
        }
        // sz-n
        int i =1;
        int itofind = sz-n;
        Node prev =head;
        while(i<itofind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }
    public int iterativesearch(int key){
        Node temp = head;
        int i=0;
        while(temp!=null){
            if(temp.data == key){  // key found
                return i ; // return index
            } 
            temp = temp.next;
            i++;
        }
        return -1;  // key not found
    }
    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int ind = helper(head.next, key);
        if(ind == -1){
            return -1;
        }
        return ind + 1 ;
    }
    public int recursivesearch(int key){
        return helper(head, key);
    }
    public void reverse(){
        Node prev = null;
        Node  curr = tail = head;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    // slow fast approch
    public Node findmidllenode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next; // slow increse by 1 node
            fast = fast.next.next;// fast increse by 2 node
        }
        return slow; // slow is a middle node
    }
    public boolean palindrom(){
        if(head == null || head.next==null){
            System.out.println("Linked list is palindrom");
            return true;
        }
        //step1 - find mid node
        Node midnode = findmidllenode(head);
        //step2 - reverse
        Node prev = null;
        Node curr = midnode;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // right half head
        Node left = head; // left half head
        // step3 - check left half and right half
        while(right != null){
            if(left.data!=right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
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
        ll.delfirst();
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
        ll.reverse();
        ll.printllist();
        ll.delfirst();
        ll.printllist();
        System.out.println("Size of linked list is "+ll.size);
        ll.dellast();
        ll.printllist();
        System.out.println("Size of linked list is "+ll.size);
        ll.delnthfromend(3);
        ll.printllist();
        ll.addfirst(0);
        ll.addfirst(6);
        ll.addlast(6);
        ll.addfirst(25);
        ll.addlast(25);
        ll.printllist();
        System.out.println(ll.iterativesearch(6));
        System.out.println(ll.iterativesearch(25));
        System.out.println(ll.recursivesearch(6));
        System.out.println(ll.recursivesearch(25));
        System.out.println(ll.palindrom());
    }
}