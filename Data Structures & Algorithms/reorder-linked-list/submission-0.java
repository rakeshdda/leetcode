/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head== null || head.next == null){
            return;
        }

        ListNode first = head;

        ListNode mid =middle(head);

        ListNode second = reverseList(mid.next);
        mid.next = null;

        while(second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow= slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode present = head;
        ListNode next = head.next;
        while(present != null){
            present.next = prev;
            prev= present;
            present = next;

            if(next!= null){
                next = next.next;
            }
        }
        return prev;
    }

}
