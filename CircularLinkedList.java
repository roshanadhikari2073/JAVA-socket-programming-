class ListNode {
  int val; 
  ListNode next; 

  ListNode(int x){
    this.val = x;
    this.next = null;
  }
}

public class CircularLinkedList{

  public static boolean isCircular(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next != null) {
      slow = slow.next; 
      fast = fast.next.next;
      if(slow == fast) return true;
    }
    return false;
   
  }

  public static void main(String...args) {

    ListNode n1 = new ListNode(1);
    ListNode n2 = new ListNode(2);
    ListNode n3 = new ListNode(3);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(5);
    ListNode n6 = new ListNode(6);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n5.next = n6;
    n6.next = n3;

    System.out.println("The provided LinkedList is circular " + isCircular(n1) );
    
  }
  
}
