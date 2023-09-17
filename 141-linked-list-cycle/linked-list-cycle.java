/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        if(head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = null;

        if(head != null) {
            fast = head.next;
        }

        while((slow != null) && (fast != null) && (slow != fast)) {
            slow = slow.next;

            if(fast.next != null) {
                fast = fast.next.next;
            }
            else{
                return false;
            }
           // System.out.println("slow = " + slow.val + " fast = " + fast.val);
        }

        return (slow == fast);
    }
}