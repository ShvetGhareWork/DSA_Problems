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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode groupPrev = dummy;
        ListNode current = head;

        while (true) {
      
            ListNode groupEnd = groupPrev;
            for (int i = 0; i < k; i++) {
                groupEnd = groupEnd.next;
                if (groupEnd == null) {
                   
                    return dummy.next;
                }
            }

          
            ListNode nextGroupStart = groupEnd.next;
            
           
            ListNode prev = nextGroupStart; 
            ListNode curr = current;
            
            for (int i = 0; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            groupPrev.next = prev; 
            
          
            groupPrev = current; 
            current = nextGroupStart;
        }
    }
}   