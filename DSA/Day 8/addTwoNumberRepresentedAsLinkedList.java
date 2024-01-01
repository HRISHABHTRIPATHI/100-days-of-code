//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {

            int n = sc.nextInt();
            int val = sc.nextInt();

            Node first = new Node(val);
            Node tail = first;
            for (int i = 0; i < n - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            int m = sc.nextInt();
            val = sc.nextInt();

            Node second = new Node(val);
            tail = second;
            for (int i = 0; i < m - 1; i++) {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends

/*
 * node for linked list
 * 
 * class Node {
 * int data;
 * Node next;
 * 
 * Node(int d) {
 * data = d;
 * next = null;
 * }
 * }
 * 
 */

class Solution {
    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second) {
        // code here
        // return head of sum list
        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        // Reverse both linked lists
        first = reverse(first);
        second = reverse(second);

        int carry = 0;
        Node head = null;
        Node current = null;

        while (first != null || second != null || carry != 0) {
            int sum = (first != null ? first.data : 0) + (second != null ? second.data : 0) + carry;

            carry = sum / 10;
            int digit = sum % 10;

            Node newNode = new Node(digit);

            if (head == null) {
                head = newNode;
                current = head;
            } else {
                current.next = newNode;
                current = current.next;
            }

            if (first != null) {
                first = first.next;
            }

            if (second != null) {
                second = second.next;
            }
        }

        // Reverse the result before returning
        head = reverse(head);

        return head;
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;

        return head;
    }

}