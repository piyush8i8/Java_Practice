


// Exchange of last node of a circular link list




// class Node {
//     int data;
//     Node next;

//     Node(int data) {
//         this.data = data;
//     }
// }

// public class CircularLinkedList {
//     Node head = null;
//     Node tail = null;

    
//     void add(int data) {
//         Node newNode = new Node(data);
//         if (head == null) {
//             head = tail = newNode;
//             tail.next = head; 
//         } else {
//             tail.next = newNode;
//             tail = newNode;
//             tail.next = head;
//         }
//     }

   
//     void display() {
//         if (head == null) return;

//         Node temp = head;
//         do {
//             System.out.print(temp.data + " ");
//             temp = temp.next;
//         } while (temp != head);
//         System.out.println();
//     }

    
//     void swapFirstAndLast() {
//         if (head == null || head.next == head) return; 

//         Node prev = null, curr = head;

        
//         while (curr.next != head) {
//             prev = curr;
//             curr = curr.next;
//         }

//         curr.next = head.next;
//         prev.next = head;
//         head.next = head;
//         tail = head;
//         head = curr;

        
//         tail.next = head;
//     }

//     public static void main(String[] args) {
//         CircularLinkedList cll = new CircularLinkedList();
//         cll.add(10);
//         cll.add(20);
//         cll.add(30);
//         cll.add(40);
//         cll.add(50);

//         System.out.println("Original list:");
//         cll.display();

//         cll.swapFirstAndLast();

//         System.out.println("After swapping first and last:");
//         cll.display();
//     }
// }



// Parenthesis

// public class VaildParaenthesis {

//     public static String longestValidParentheses(String s) {
//         int maxLen = 0;
//         int start = 0;
//         int validStart = -1;

//         java.util.Stack<Integer> stack = new java.util.Stack<>();

//         for (int i = 0; i < s.length(); i++) {
//             if (s.charAt(i) == '(') {
//                 stack.push(i);
//             } else {
//                 if (!stack.isEmpty()) {
//                     stack.pop();
//                     int lastInvalid = stack.isEmpty() ? start : stack.peek() + 1;
//                     if (i - lastInvalid + 1 > maxLen) {
//                         maxLen = i - lastInvalid + 1;
//                         validStart = lastInvalid;
//                     }
//                 } else {
//                     start = i + 1;
//                 }
//             }
//         }

//         return validStart != -1 ? s.substring(validStart, validStart + maxLen) : "";
//     }

//     public static void main(String[] args) {
//         String input1 = "((()";
//         String input2 = ")()())";

//         System.out.println(longestValidParentheses(input1));  
//         System.out.println(longestValidParentheses(input2));  
//     }
// }


// Merge two sorted linked list

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class MergeSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

    
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        
        return dummy.next;
    }

   
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(10);
        l1.next.next = new ListNode(15);

       
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(16);

        
        ListNode mergedList = mergeTwoLists(l1, l2);

        
        printList(mergedList);
    }
}
