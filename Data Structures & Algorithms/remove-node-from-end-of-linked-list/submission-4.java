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

// class Solution {
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         if (head.next == null) {
//             return null;
//         }
//         ListNode pres = head;
//         ListNode prev = null;
//         ListNode next = head.next;

//         while (pres != null) {
//             pres.next = prev;
//             prev = pres;
//             pres = next;
//             if (next != null) {
//                 next = next.next;
//             }
//         }
//         head = prev;

//         if (n == 1) {
//             head = head.next;
//         } else {
//             ListNode node = head;
//             for (int i = 2; i < n; i++) {
//                 node = node.next;
//             }

//         node.next = node.next.next;
//         }
//         ListNode ans = reverse(head);
//         return ans;
//     }
//     ListNode reverse(ListNode head) {
//         ListNode prev = null;
//         ListNode present = head;
//         ListNode next = head.next;

//         while (present != null) {
//             present.next = prev;
//             prev = present;
//             present = next;
//             if (next != null) {
//                 next = next.next;
//             }
//         }
//         head = prev;

//         return prev;
//     }
// }

// better : two pointer
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode preNth = nthNode(head, n);

        if (preNth == null) {
            return head.next;
        }
        preNth.next = preNth.next.next;

        return head;
    }
    // this methode give prev node of the nth node from the last
    public ListNode nthNode(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i <= n; i++) {
            if (first == null) {
                return null;
            }
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
